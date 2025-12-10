package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static user.UserFactory.wiseAdminPermission;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(wiseAdminPermission());
        productsPage.isPageLoaded("Products");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart(1);
        assertEquals(productsPage.checkGoodsQuantity(), "3");
    }
}
