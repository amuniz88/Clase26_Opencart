package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage{

    @FindBy(id = "input-firstname")
    WebElement txt_name;

    @FindBy(id = "input-lastname")
    WebElement txt_apellido;

    @FindBy(id = "input-email")
    WebElement txt_email;

    @FindBy(id = "input-telephone")
    WebElement txt_phone;

    @FindBy(id = "input-address-1")
    WebElement txt_address;

    @FindBy (id = "input-city")
    WebElement txt_city;

    @FindBy (id = "input-postcode")
    WebElement txt_postcode;

    @FindBy(id = "input-country")
    WebElement combo_country;

    @FindBy(id = "input-zone")
    WebElement combo_zone;

    @FindBy(id = "input-password")
    WebElement txt_pass;

    @FindBy(id = "input-confirm")
    WebElement txt_confirmPass;

    //radios
    @FindBy(xpath = "//input[@name=\"newsletter\" and @value=1]")
    WebElement radio_Yes;

    @FindBy(xpath = "//input[@name=\"newsletter\" and @value=0]")
    WebElement radio_No;

    //check
    @FindBy(name = "agree")
    WebElement check_PrivacyPolicy;

    @FindBy(className = "btn-primary")
    WebElement btn_Continuar;

    @FindBy(tagName = "h1")
    WebElement lbl_h1;

    public RegisterPage(WebDriver driver){
        super(driver);
    }


    public void registerNewUsuario(
            String name, String apellido, String email, String phone
            , String addres, String city, String postCode, String country
            , String zone, String pass, String confirm, String radio, boolean check) {

        txt_name.sendKeys(name);
        txt_apellido.sendKeys(apellido);
        txt_email.sendKeys(email);
        txt_phone.sendKeys(phone);
        txt_address.sendKeys(addres);
        txt_city.sendKeys(city);
        txt_postcode.sendKeys(postCode);
        Select c_country = new Select(combo_country);
        c_country.selectByValue(country);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Montevideo')]")));

        Select c_zone = new Select(combo_zone);
        c_zone.selectByValue(zone);
        txt_pass.sendKeys(pass);
        txt_confirmPass.sendKeys(confirm);

        if (radio.equals("yes")) {
            radio_Yes.click();
        } else {
            radio_No.click();
        }
        if(check == true)
        {
            check_PrivacyPolicy.click();
        }

        btn_Continuar.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
    }

    public boolean accountCreatedIsDisplayed(){
        return lbl_h1.isDisplayed();
    }

    public boolean accountCreatedContains(String contenido){
        return lbl_h1.getText().contains(contenido);
    }
}
