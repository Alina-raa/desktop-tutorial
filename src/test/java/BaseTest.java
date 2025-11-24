import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pagest.LoginPage;
import pagest.ProductsPage;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //options.addArgument("--windows-size=1920,1080");
        //options.addArgument("--guest");
        // options.addArgument("headless");

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

    }

    @AfterMethod
    public void close() {
    }
}