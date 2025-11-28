import org.testng.annotations.Test;
import pagest.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test(description = "Проверка корректного логина")
    public void checkIncorrectLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertTrue(loginPage.isErrorMsgAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(description = "Некорректный логин")
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageLoaded(), "Register bth is not visible");
    }
}