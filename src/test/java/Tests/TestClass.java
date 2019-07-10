package Tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass extends BaseTest{

    @Parameters("moneda")
    @Test
    public void cambioMonedaParameters(String moneda){
        hPage.seleccionarMoneda(moneda);

        Assert.assertTrue(hPage.verificarCambioMoneda(moneda));
    }
}
