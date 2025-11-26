import org.testng.annotations.Test;
import pagest.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void checkIncorrectLogin() {
        loginPage.open();
        loginPage.login("Locked_out_user", "secret_sauce");
        assertTrue(loginPage.IsErrorAppear(), "Error message does not appear");
        assertEquals(loginPage.ErrorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageLoaded(), "Register bth is not visible");
    }
}