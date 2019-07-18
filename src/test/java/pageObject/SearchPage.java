package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{

    List<ProductItem> resultado;
    boolean encontrado;

    @FindBy(className = "product-layout")
    List<WebElement> listaElementos;

    public SearchPage(WebDriver driver){
        super(driver);
        resultado = new ArrayList<>();
        encontrado = false;
        for(WebElement element : listaElementos){
            resultado.add(new ProductItem(element));
        }
    }

    public void addToWishList(String Object) {
        for(ProductItem prod : resultado){
            prod.addToWish();
            encontrado = true;
            break;
        }
    }

    public boolean isObjectAddedToWishList(String object){
        if(!encontrado) {
            System.err.println("Producto " + object + " no encontrado");
            return false;
        }
        else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("div.alert-success"))));
            WebElement addToWishListSucces = driver.findElement(By.cssSelector(("div.alert-success")));
            return addToWishListSucces.getText().contains("Success: You have added " + object + " to your wish list!");
        }
    }

    public void addToCartList(String object){
        for(ProductItem prod : resultado){
            if(prod.getName().equals(object)){
                prod.addToCart();
                break;
            }
        }
    }

    public boolean isObjectAddedToCartList(String object){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("div.alert-success"))));
        WebElement addToCartSucces = driver.findElement(By.cssSelector(("div.alert-success")));
        return addToCartSucces.getText().contains("Success: You have added " + object + " to your shopping cart!");
    }

    public void addToCartMenorPrecio(){
        int posicion = -1;
        double menor = 99999;

        for(int i = 0; i < resultado.size(); i++){
            if(resultado.get(i).getPrice() < menor){
                posicion = i;
                menor = resultado.get(i).getPrice();
            }
        }
        resultado.get(posicion).addToCart();
        setMenorPrecioName(resultado.get(posicion).getName());
    }

//    public void removeToCartMenorPrecio(){
//
//    }
}
