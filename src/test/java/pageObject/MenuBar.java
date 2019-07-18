package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuBar extends BasePO {

    @FindBy(partialLinkText = "Desktops")
    WebElement link_Desktop;

    @FindBy(partialLinkText = "Laptops & Notebooks")
    WebElement link_LaptopsNotebooks;

    @FindBy(partialLinkText = "Commponents")
    WebElement link_Components;

    @FindBy(partialLinkText = "Tables")
    WebElement link_Tables;

    @FindBy(partialLinkText = "Software")
    WebElement link_Software;

    @FindBy(partialLinkText = "Phones & PDAs")
    WebElement link_PhonesPDAs;

    @FindBy(partialLinkText = "Cameras")
    WebElement link_Cameras;

    @FindBy(partialLinkText = "MP3 Players")
    WebElement link_MP3Players;


    public MenuBar(WebDriver driver) {
        super(driver);
    }

    public SearchPage seleccionarOpcion(String opcion){

        switch (opcion){
            case "Tables":
                link_Tables.click();
                break;

            case "Software":
                link_Software.click();
                break;

            case "Phones & PDAs":
                link_PhonesPDAs.click();
                break;

            case "Cameras":
                link_Cameras.click();
                break;
        }

//        if(opcion.equalsIgnoreCase("Desktops")){
//            link_Desktop.click();
//        }else if(opcion.equalsIgnoreCase("Laptops & Notebooks")){
//            link_LaptopsNotebooks.click();
//        }else if(opcion.equalsIgnoreCase("Commponents")){
//            link_Components.click();
//        }else if(opcion.equalsIgnoreCase("Tables")){
//
//        }else if(opcion.equalsIgnoreCase("Software")){
//        }else if(opcion.equalsIgnoreCase("Phones & PDAs")){
//        }else if(opcion.equalsIgnoreCase("Cameras")){
//        }else if(opcion.equalsIgnoreCase("MP3 Players")){
//            link_MP3Players.click();
//        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));

        return new SearchPage(driver);
    }
}
