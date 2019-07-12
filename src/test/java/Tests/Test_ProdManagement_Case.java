package Tests;

import dataProviders.DPGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_ProdManagement_Case extends BaseTest{

    @Test(dataProvider = "DP_WishList", dataProviderClass = DPGeneral.class)
    public void addToWishTest(String email, String pass, String element){
        logP = hPage.clickInLogin();
        hPage = logP.goToLogin(email, pass);
        sPage = hPage.searchObject(element);
        sPage.addToWishList(element);

        Assert.assertTrue(sPage.isObjectAddedToWishList(element));

        whishList = sPage.goToWishList();

        Assert.assertTrue(whishList.verifyIfAt(element));
    }
}
