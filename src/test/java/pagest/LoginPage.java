package pagest;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    By userField = By.cssSelector("[placeholder='Username']");
    By passwordField = By.cssSelector("[placeholder='Password']");
    By loginBtn = By.id("login-button");
    By error = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Авторизация под кредами пользователя: логин={user.email} пароль = ****")
    public LoginPage login(User user) {
        driver.findElement(userField).sendKeys(user.getEmail());
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(loginBtn).click();
        return this;
    }

    @Step("Отображение сообщения об ошибке")
    public boolean isErrorMsgAppear() {
        return driver.findElement(error).isDisplayed();
    }

    @Step("Получаем текс сообщения об ошибке")
    public String errorMessageText() {
        return driver.findElement(error).getText();
    }

    public LoginPage login(String user, String password) {
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
        return this;
    }
}
