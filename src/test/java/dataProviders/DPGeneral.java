package dataProviders;

import org.testng.annotations.DataProvider;

public class DPGeneral {

    @DataProvider(name="DP_RegistroUsuario")
    public Object [][] dpregistrousuario(){
        return new Object[][]{
                {"Emilia","Muvi","e.m@gmail.com", "098098098", "Calle 1, entre 2 y 3", "Montevideo", "21000", "225", "3690", "123456", "123456", "yes", true}
        };
    }

    @DataProvider(name="DP_Login")
    public Object [][] dpLogin(){
        return new Object[][]{
                {"e.m@gmail.com","123456"}
        };
    }

    @DataProvider(name="DP_WishList")
    public Object[][] dpWishList(){
        return new Object[][]{
                {"e.m@gmail.com","123456", "iMac"}
        };
    }

}
