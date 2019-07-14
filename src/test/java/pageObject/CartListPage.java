package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartListPage extends BasePO {

    List<CartListItem> productos;

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
}
