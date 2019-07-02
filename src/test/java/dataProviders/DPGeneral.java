package dataProviders;

import org.testng.annotations.DataProvider;

public class DPGeneral {

    @DataProvider(name="asdd")
    public Object [][] dp(){
        return new Object[][]{
                {"","",""},
                {"","",""}
        };
    }
    @DataProvider(name="asd")
    public Object [][] dp2(){
        return new Object[][]{
                {"","",""},
                {"","",""}
        };
    }
}
