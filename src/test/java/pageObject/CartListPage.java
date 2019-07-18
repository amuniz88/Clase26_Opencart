package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartListPage extends BasePage {

    List<CartListItem> productos;

    @FindBy(xpath = "//button[@data-original-title='Remove']")
    WebElement btn_eliminarRegistro;

    @FindBy(partialLinkText = "Continue")
    WebElement linkContinue;

    public CartListPage(WebDriver driver) {
        super(driver);
        productos = new ArrayList<>();
        List<WebElement> filas = driver.findElements(By.cssSelector("tbody tr"));
        for(WebElement fila : filas){
            productos.add(new CartListItem(fila));
        }
    }

    public boolean verifyIfAt(String object) {
        for(CartListItem product : productos){
            if(product.getName().contains(object))
                return true;
        }
        return false;
    }

    public boolean hayElementosInToList(){
        return productos.size() > 0;
    }

//    public void removeProduct(String menorPrecioName){
//        for(CartListItem product : productos){
//            if(product.getName().contains(menorPrecioName)){
//                btn_eliminarRegistro.click();
//            }
//        }
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
//
//        linkContinue.click();
//    }
}
