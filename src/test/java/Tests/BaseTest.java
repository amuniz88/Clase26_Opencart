package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegisterPage;
import utils.GetProperties;

public class BaseTest {

//    String moneda;

    protected SoftAssert SA;
    protected ChromeOptions options;
    protected WebDriver driver;
    protected HomePage hPage;
    protected RegisterPage registerPage;
    protected LoginPage logP;

    protected GetProperties properties    = new GetProperties();
    protected String url                  = properties.getString("URL");
    protected String hub_url              = properties.getString("HUB_URL");

    @BeforeMethod(alwaysRun = true)
    @Parameters({"moneda", "browser"})
    public void start(String moneda, String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", properties.getString("CHROMEDRIVER_PATH"));

            options = new ChromeOptions();
//            options.addArguments("--start-maximized");
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", properties.getString("FIREFOXDRIVER_PATH"));

            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();

        driver.get(url);

        hPage = new HomePage(driver);

        SA = new SoftAssert();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
