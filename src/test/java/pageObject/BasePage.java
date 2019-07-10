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
//    public void login(){
//    }
}