package dataProviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DPGeneral {

    @DataProvider(name="DP_RegistroUsuario")
    public Object [][] dpregistrousuario(){
        return new Object[][]{
                {"Emilia","Muvi","e.m@gmail.com", "098098098", "Calle 1, entre 2 y 3", "Montevideo", "21000", "225", "3690", "123456", "123456", "yes", true}
        };
    }

//    @DataProvider(name="DP_Login")
//    public Object [][] dpLogin(){
//        return new Object[][]{
//                {"e.m@gmail.com","123456"}
//        };
//    }

    //El if es a modo de ejemplo y saber como es, solo estoy usando el primero
    @DataProvider(name="DP_WishList")
    public Object[][] dpWishList(Method method){
        Object[][] datos = new Object[][]{};

        if(method.getName().equalsIgnoreCase("addToWishTest") || method.getName().equalsIgnoreCase("addToCartTest")) {
            datos = new Object[][]{
                    {"iMac"}
            };
        }
        else if(method.getName().equalsIgnoreCase("elProfePusoElLoginAca")){
            datos = new Object[][]{
                    {"e.m@gmail.com", "123456"}
            };
        }
        return datos;
    }
}
