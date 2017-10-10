package ru.stqa.selenium.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class shoppingCart extends TestBase {

    @Test
    public void cart() {
        driver.get("http://localhost/litecart/en/");
        for (int i = 1; i < 4; i++) {
            WebElement content = driver.findElement(By.cssSelector("div.content ul.listing-wrapper"));
            WebElement product = content.findElement(By.tagName("a"));
            product.click();

            WebElement quantity = driver.findElement(By.className("quantity"));

            List<WebElement> size = driver.findElements(By.cssSelector("td.options select option"));
            if (size.size() > 0) {
                size.get(2).click();
            }
            driver.findElement(By.name("add_cart_product")).click();
            wait.until(ExpectedConditions.textToBePresentInElement(quantity, "" + i));

            driver.findElement(By.cssSelector("#breadcrumbs a")).click();
        }
        WebElement cart = driver.findElement(By.id("cart"));
        cart.findElement(By.className("link")).click();

        for (int i = 1; i < 4; i++) {
            if (isElementPresent(driver, By.cssSelector("#checkout-cart-wrapper em"))) {
                break;
            }
            WebElement duckInCartForm = driver.findElement(By.cssSelector("form div a"));
            List<WebElement> duckInTable = driver.findElements(By.cssSelector(".dataTable tr"));

            Assert.assertTrue(duckInCartForm.getText().equals(duckInTable.get(1).findElement(By.className("item")).getText()));
            driver.findElement(By.cssSelector("p:last-child button")).click();

            wait.until(ExpectedConditions.stalenessOf(duckInTable.get(1)));
        }

    }
}
