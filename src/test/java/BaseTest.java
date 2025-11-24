import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
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
        SafariOptions options = new SafariOptions();
        //options.merge("--guest");
        // options.addArgument("start-maximized");
        //options.merge("--windows-size=1920,1080");
        // options.addArgument("headless");

        driver = new SafariDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

    }

  /*  @AfterMethod
   // public void close() {

   */
}
