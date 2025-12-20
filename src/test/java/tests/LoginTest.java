package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

public class LoginTest extends BaseTest {
    @DataProvider(name = "invalidData")
    public Object[][] loginData() {
        return new Object[][]{
                {wiseLockedUserPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {wiseZeroUserPermission(), "Epic sadface: Username is required"},
                {wiseZeroPassPermission(), "Epic sadface: Password is required"},
                {wiseinCorlockedUserPermission(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Epic("Создание лида")
    @Feature("Создание карточки клиента")
    @Story("Пагинация")
    @TmsLink("desktop-tutorial")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Ryabova Alina alinessar@gmail.com")
    @Issue("desktop-tutorial")
    @Test(description = "Проверка некорректного логина", dataProvider = "invalidData")
    public void checkIncorrectLogin(User user, String err) {
        loginPage
                .open()
                .login(user);
        //AllureUtils.takeScreenshot(driver);
        assertTrue(loginPage.isErrorMsgAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMessageText(), err);
    }

    @TmsLink("desktop-tutorial")
    @Test(description = "Проверка корректного логина")
    public void checkCorrectLogin() {
        loginPage
                .open()
                .login(wiseAdminPermission());
        assertTrue(productsPage.isPageLoaded(PRODUCTS.getDisplayName()), "Register bth is not visible");
    }
}
