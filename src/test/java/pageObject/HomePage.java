package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

//    @FindBy(xpath = "//*[contains(@class,'price')]")
//    private WebElement moneda;

    @FindBy(className = "product-layout")
    private List<WebElement> listado;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public boolean verificarCambioMoneda(String moneda){
        String simbolo = obtenerSimboloMoneda(moneda);

        boolean validacion = true;

        List<ProductItem> listaProd = new ArrayList<>();
        for(WebElement e : listado){
            listaProd.add(new ProductItem(e));
        }
        for(ProductItem pItem : listaProd){
            if(!pItem.getTaxes().contains(simbolo))
                validacion = false;
        }
        return validacion;
    }

    public String obtenerSimboloMoneda(String moneda){
        String monedaSimbolo = "";

        if(moneda.equals("USD")){
            monedaSimbolo = "$";
        }else if(moneda.equals("EUR")){
            monedaSimbolo = "€";
        }else{
            monedaSimbolo = "£";
        }
        return monedaSimbolo;
    }
}
