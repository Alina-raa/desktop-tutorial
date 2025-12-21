package pagest;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*Данная страница описывает функционал витрины*/
public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART_BUTTON_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    By cartBadge = By.xpath("//*[@data-test='shopping-cart-badge']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Загрузка страницы")
    public boolean isPageLoaded(final String pageTitle) {
        return driver.findElement(By.xpath(TEXT_LOCATOR_PATTERN.formatted(pageTitle))).isDisplayed();
    }

    @Step("Добавляем товар в корзину по названию")
    public ProductsPage addToCart(final String goodsName) {
        By addGoodsToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addGoodsToCart).click();
        return this;
    }

    @Step("Добавляем товар в корзину")
    public ProductsPage addToCart(final int goodsOrder) {
        driver.findElements(By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"))).get(goodsOrder).click();
        return this;
    }

    @Step("Отображение наименования товара")
    public String checkGoodsQuantity() {
        return driver.findElement(cartBadge).getText();
    }

    public void switchToCart() {
        driver.findElement(cartBadge).click();
    }
}
