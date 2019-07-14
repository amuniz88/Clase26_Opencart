package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigateBar extends BasePO{

    @FindBy(partialLinkText = "My Account")
    WebElement myAcountLink;

    @FindBy(partialLinkText = "Register")
    WebElement registerLink;

    @FindBy(partialLinkText = "Login")
    WebElement loginLink;

    @FindBy(name = "search")
    WebElement txt_search;

    @FindBy(className = "btn-default")
    WebElement btn_Search;

    @FindBy(partialLinkText = "Wish List")
    WebElement wishListLink;

    @FindBy(partialLinkText = "Shopping Cart")
    WebElement cartListLink;

    CurrencyMenu curMenu;

    public NavigateBar (WebDriver driver){
        super(driver);
        curMenu = new CurrencyMenu(driver);
    }

    public void selectMoneda(String moneda){
        curMenu.seleccionarMoneda(moneda);
    }

    public RegisterPage clickInRegister(){
        wait.until(ExpectedConditions.elementToBeClickable(myAcountLink));
        myAcountLink.click();
        wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        registerLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        return new RegisterPage(driver);
    }

    public LoginPage clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(myAcountLink));
        myAcountLink.click();
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'btn-primary')]")));

        return new LoginPage(driver);
    }

    public SearchPage searchElement(String elemento){
        txt_search.sendKeys(elemento);
        btn_Search.click();

        //ejercicio 3 agregar al carrito
        return new SearchPage(driver);
    }

    public WishListPage goToWishList() {
        wait.until(ExpectedConditions.elementToBeClickable(wishListLink));
        wishListLink.click();

        return new WishListPage(driver);
    }

    public CartListPage goToCartList (){
        wait.until(ExpectedConditions.elementToBeClickable(cartListLink));
        cartListLink.click();

        return new CartListPage(driver);
    }
}
