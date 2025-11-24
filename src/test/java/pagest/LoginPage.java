package pagest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By userField = By.cssSelector("[placeholder='Username']");
    By passwordField = By.cssSelector("[placeholder='Password']");
    By loginBtn = By.id("login-button");
    By error = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com");
    }

    public void login(final String userName, final String passwordName) {
        driver.findElement(userField).sendKeys("standard_user");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginBtn).click();
    }

    public boolean IsErrorAppear() {
        return driver.findElement(error).isDisplayed();
    }

    public String ErrorMessageText() {
        return driver.findElement(error).getText();
    }
}