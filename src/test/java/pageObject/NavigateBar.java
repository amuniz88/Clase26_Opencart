package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigateBar extends BasePO{

    @FindBy(className = "fa-user")
    WebElement btn_myAcount;

    @FindBy(css = "[href*=register]")
    WebElement btn_registro;

    @FindBy(css = "[href*=login]")
    WebElement btn_login;

    @FindBy(name = "search")
    WebElement txt_search;

    @FindBy(className = "btn-default")
    WebElement btn_Search;

    CurrencyMenu curMenu;

    public NavigateBar (WebDriver driver){
        super(driver);
        curMenu = new CurrencyMenu(driver);
    }

    public void selectMoneda(String moneda){
        curMenu.seleccionarMoneda(moneda);
    }

    public RegisterPage clickInRegister(){
        btn_myAcount.click();
        btn_registro.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        return new RegisterPage(driver);
    }

    public LoginPage clickLogin(){
        btn_myAcount.click();
        btn_login.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'btn-primary')]")));

        return new LoginPage(driver);
    }

    public SearchPage searchPage(String elemento){
        txt_search.sendKeys(elemento);
        btn_Search.click();

        //ejercicio 3 agregar al carrito
        return new SearchPage(driver);
    }
}
