package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginCase extends BaseTestWithLogin{
//este test hereda lo de Base Test, pero si alguno necesita el login va a tener que heredar de este...

    @Test //los datos para login se sacaban del dp pero se cambiaron para refactorizar la utilización del método y ahora se pasa por parámetro
    public void login(){
        //la clase hereda de BaseTestWithLogin y es la que cumple la función de loguear
        Assert.assertTrue(logP.myAccountIsDisplayed());
        Assert.assertTrue(logP.myAccountContains("My Account"));
    }
}
