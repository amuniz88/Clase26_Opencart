package Tests;

import pageObject.cambioMoneda;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestClass {

    String moneda;

    private ChromeOptions options;
    private WebDriver driver;
    private cambioMoneda cMoneda;

    @BeforeMethod
    @Parameters({"moneda", "browser"})
    public void start(String moneda, String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

            options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

            driver.manage().window().maximize();
            driver = new FirefoxDriver();
        }

        Properties prop = new Properties();
        InputStream is = getClass().getResourceAsStream("/config.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.moneda = moneda;

        driver.get(prop.getProperty("URL"));

        cMoneda = new cambioMoneda(driver);
    }

    @Test
    public void cambioMoneda(){
        cMoneda.cambiarMoneda(moneda);

        Assert.assertTrue(cMoneda.monedaContains());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
