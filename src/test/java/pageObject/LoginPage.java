package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePO {

    @FindBy(name = "email")
    WebElement txt_email;

    @FindBy(name = "password")
    WebElement txt_password;

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    WebElement btn_login;

    @FindBy(css = "[id=\"content\"]")
    WebElement lbl_My_Account;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToLogin(String email, String password){
        txt_email.sendKeys(email);
        txt_password.sendKeys(password);

        btn_login.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id=\"content\"]")));
    }

    public boolean myAccountIsDisplayed(){
        return lbl_My_Account.isDisplayed();
    }

    public boolean myAccountContains(String valor){
        return lbl_My_Account.getText().contains(valor);
    }
}
