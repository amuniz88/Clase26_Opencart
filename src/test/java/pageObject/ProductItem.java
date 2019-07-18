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

    public String getTaxes(){
        return element.findElement(By.cssSelector(".price-tax")).getText().replace("Ex Tax: ", "");
    }

    public Double getPrice(){
        int index = element.findElement(By.className("price")).getText().indexOf("\n");  //puede suceder que el numero sea mayor o menor a 3 cifas por eso lo llevamos hasta el enter (\n)
        return Double.valueOf(element.findElement(By.className("price")).getText().substring(1, index));
//        return Integer.valueOf(element.findElement(By.className("price")).getText().substring(1, 4));
    }

    public void addToWish(){
        element.findElement(By.cssSelector("i.fa-heart")).click();
    }

    public void addToCart(){
        element.findElement(By.className("fa-shopping-cart")).click();
    }
}
