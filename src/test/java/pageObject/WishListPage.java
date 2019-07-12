package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WishListPage extends BasePO {

    List<WishListItem> productos;

    @FindBy(css = "tbody tr")
    List<WebElement> filas;

    public WishListPage(WebDriver driver) {
        super(driver);
        productos = new ArrayList<>();
        for(WebElement fila : filas){
            productos.add(new WishListItem(fila));
        }
    }

    public boolean verifyIfAt(String object) {
        for(WishListItem product : productos){
            if(product.getName().equals(object))
                return true;
        }
        return false;
    }
}
