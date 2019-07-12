package Tests;

import dataProviders.DPGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginCase extends BaseTest{
//este test hereda lo de Base Test, pero si alguno necesita el login va a tener que heredar de este...

    @Test(dataProvider = "DP_Login", dataProviderClass = DPGeneral.class)
    public void login(String email, String pass){
        logP = hPage.clickInLogin();
        logP.goToLogin(email, pass);

        Assert.assertTrue(logP.myAccountIsDisplayed());
        Assert.assertTrue(logP.myAccountContains("My Account"));
    }
}
