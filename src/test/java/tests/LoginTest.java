package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.wiseAdminPermission;
import static user.UserFactory.wiseLockedUserPermission;

public class LoginTest extends BaseTest {
    @DataProvider(name = "invalidData")
    public Object[][] loginData() {
        return new Object[][]{
                {locked, password, "Epic sadface: Sorry, this user has been locked out."},
                {"", password, "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"Locked_out_user", password, "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test
    public void checkIncorrectLogin(){
        loginPage.open();
        loginPage.login(wiseLockedUserPermission());
        assertTrue(loginPage.isErrorMsgAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(description = "Некорректный логин")
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login(wiseAdminPermission());
        assertTrue(productsPage.isPageLoaded("Products"), "Register bth is not visible");
    }
}
