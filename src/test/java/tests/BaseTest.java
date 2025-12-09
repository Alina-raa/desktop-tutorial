package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pagest.CartPage;
import pagest.LoginPage;
import pagest.ProductsPage;
import utils.PropertyReader;
import utils.TestListener;

import java.time.Duration;
@Listeners({AllureTestNg.class, TestListener.class})
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    String user;
    String locked;
    String password;
    String inCorlocked_user;
    String zero_user;
    String zero_password;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--windows-size=1920,1080");
            options.addArguments("--guest");
            // options.addArguments("start-maximized");
            //options.addArgument("headless");

            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        user = PropertyReader.getProperty("sausedemo.user");
        locked = PropertyReader.getProperty("sausedemo.locked_user");
        password = PropertyReader.getProperty("sausedemo.password");
        inCorlocked_user =PropertyReader.getProperty("sausedemo.inCorlocked_user");
        zero_user = PropertyReader.getProperty("sausedemo.zero_user");
        zero_password =PropertyReader.getProperty("sausedemo.zero_password");



    }

    @AfterMethod
    public void close() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
