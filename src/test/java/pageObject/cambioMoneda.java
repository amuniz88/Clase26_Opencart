package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class cambioMoneda extends BasePage{

    @FindBy(xpath = "//*[contains(@class,'price')]")
    WebElement moneda;

    @FindBy(css = ".dropdown-toggle")
    WebElement btn_Moneda;

    @FindBy(name = "EUR")
    WebElement btn_euro;

    @FindBy(name = "USD")
    WebElement btn_dolar;

    @FindBy(name = "GBP")
    WebElement btn_sterling;

    public cambioMoneda(WebDriver driver){
        super(driver);
    }

    public void cambiarMoneda(String moneda){
        btn_Moneda.click();

        if(moneda.equals("dolar")){
            btn_dolar.click();
        }else if(moneda.equals("euro")){
            btn_euro.click();
        }else{
            btn_sterling.click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
    }

    public boolean monedaIsDisplayed(){
        return moneda.isDisplayed();
    }

    public boolean monedaContains(){
        List<WebElement> precios = driver.findElements(By.xpath("//*[contains(@class,'price')]"));
        boolean valid = false;

        for(int i = 0; i < precios.size(); i++){
            if(precios.get(i).getText().contains("$")){
                valid = true;
            }else if (precios.get(i).getText().contains("€")){
                valid = true;
            }else if(precios.get(i).getText().contains("£")){
                valid = true;
            }else{
                valid = false;
            }
        }
        return valid;
    }


}
