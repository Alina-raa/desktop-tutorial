package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.wiseAdminPermission;

public class CartTest extends BaseTest {
    @Test
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(wiseAdminPermission());
        productsPage.isPageLoaded("Products");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.switchToCart();
        assertEquals(cartPage.getProductsNames().size(), 2);
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Bolt T-Shirt"));
    }
}
