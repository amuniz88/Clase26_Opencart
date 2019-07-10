package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CurrencyMenu extends BasePO{

    public CurrencyMenu(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "form-currency")
    private WebElement btn_currency;

    @FindBy(name = "EUR")
    private WebElement btn_euro;

    @FindBy(css = "[name=\"USD\"]")
    private WebElement btn_dolar;

    @FindBy(name = "GBP")
    private WebElement btn_sterling;

    public void seleccionarMoneda(String moneda){
        btn_currency.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("USD")));

        if(moneda.equalsIgnoreCase("USD")){
            btn_dolar.click();
        }else if(moneda.equalsIgnoreCase("EUR")){
            btn_euro.click();
        }else if(moneda.equalsIgnoreCase("GBP")){
            btn_sterling.click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
    }


}
