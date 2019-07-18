package Tests;

import dataProviders.DPGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_ProdManagement_Case extends BaseTestWithLogin{

    @Test(dataProvider = "DP_WishList", dataProviderClass = DPGeneral.class)
    public void addToWishTest(String element){
        sPage = hPage.searchObject(element);
        sPage.addToWishList(element);

        Assert.assertTrue(sPage.isObjectAddedToWishList(element));

        whishList = sPage.goToWishList();

        Assert.assertTrue(whishList.verifyIfAt(element));
    }

    @Test(dataProvider = "DP_WishList", dataProviderClass = DPGeneral.class)
    public void addToCartTest(String element){
        sPage = hPage.searchObject(element);
        sPage.addToCartList(element);

        Assert.assertTrue(sPage.isObjectAddedToCartList(element));

        cartListPage = sPage.goToCartList();

        Assert.assertTrue(cartListPage.verifyIfAt(element));
    }

    @Test
    public void addPhoneCheapToCart(){
        sPage = hPage.selectMenuPhonesPDAs();
        sPage.addToCartMenorPrecio();

//        Assert.assertTrue(sPage.isObjectAddedToCartList(menorPrecioName));

        cartListPage = sPage.goToCartList();

        Assert.assertTrue(cartListPage.hayElementosInToList());
        Assert.assertTrue(cartListPage.verifyIfAt(cartListPage.getMenorPrecioName()));
//        cartListPage = hPage.goToCartList();
//        cartListPage.removeProduct(menorPrecioName);
//        Assert.assertFalse(cartListPage.verifyIfAt(menorPrecioName));
    }
}
