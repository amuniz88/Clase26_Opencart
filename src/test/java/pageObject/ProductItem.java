package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductItem {

    WebElement element;

    public ProductItem(WebElement main){
        this.element = main;
    }

    public String getName(){
        return element.findElement(By.tagName("h4")).getText();
    }

//    public String getNewPrice(){}
//    public String getOldPrice(){}

    public String getTaxes(){
        return element.findElement(By.cssSelector(".price-tax")).getText().replace("Ex Tax: ", "");
    }

    public void addToWish(){
        element.findElement(By.cssSelector("i.fa-heart")).click();
    }
}
