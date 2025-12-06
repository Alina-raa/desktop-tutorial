package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pagest.CartPage;
import pagest.LoginPage;
import pagest.ProductsPage;
import utils.PropertyReader;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    String user;
    String locked;
    String password;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
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
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        user = PropertyReader.getProperty("sausedemo.user");
        locked = PropertyReader.getProperty("sausedemo.locked_user");
        password = PropertyReader.getProperty("sausedemo.password");

    }

    @AfterMethod
    public void close() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
