package pageObject;

import org.openqa.selenium.WebDriver;

public class BasePage extends BasePO{

    protected NavigateBar bar;
    protected MenuBar menBar;
    protected static String menorPrecioName;

    public String getMenorPrecioName() {
        return menorPrecioName;
    }

    public void setMenorPrecioName(String menorPrecioName) {
        this.menorPrecioName = menorPrecioName;
    }

    public BasePage(WebDriver driver){
        super(driver);
        bar = new NavigateBar(driver);
        menBar  = new MenuBar(driver);

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
    public SearchPage selectMenuPhonesPDAs(){
        return bar.goToSeleccionarOpcion("Phones & PDAs");
    }
}