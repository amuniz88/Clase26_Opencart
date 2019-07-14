package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTestWithLogin extends BaseTest{

    @BeforeMethod
    @Parameters({"usuario","password"})
    public void setupLogin(String email, String pass){
        logP = hPage.clickInLogin();
        hPage = logP.goToLogin(email, pass);
    }
}
