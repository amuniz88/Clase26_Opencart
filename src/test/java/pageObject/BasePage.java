package pageObject;

import org.openqa.selenium.WebDriver;

public class BasePage extends BasePO{

    protected NavigateBar bar;


    public BasePage(WebDriver driver){
        super(driver);
        bar = new NavigateBar(driver);
    }

    public void seleccionarMoneda(String moneda){
        bar.selectMoneda(moneda);
    }
    public RegisterPage clickInRegister(){
        return bar.clickInRegister();
    }
    public LoginPage clickInLogin(){
        return bar.clickLogin();
    }
    public SearchPage searchObject(String elemento){
        return bar.searchElement(elemento);
        }
    public WishListPage goToWishList(){return bar.goToWishList();}
    public CartListPage goToCartList(){return bar.goToCartList();}
}