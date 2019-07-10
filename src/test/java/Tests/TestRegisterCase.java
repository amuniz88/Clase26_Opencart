package Tests;

import dataProviders.DPGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegisterCase extends BaseTest{

    @Test(dataProvider = "DP_RegistroUsuario", dataProviderClass = DPGeneral.class)
    public void registroDeUsuario(String name, String apellido, String email, String phone, String addres, String city, String postCode, String country, String zone, String pass, String confirm, String radio, boolean check){

        registerPage = hPage.clickInRegister();
        registerPage.registerNewUsuario(name, apellido, email, phone, addres, city, postCode, country, zone, pass, confirm, radio, check);

        Assert.assertTrue(registerPage.accountCreatedIsDisplayed());
        Assert.assertTrue(registerPage.accountCreatedContains("Your Account Has Been Created!"));
    }
}
