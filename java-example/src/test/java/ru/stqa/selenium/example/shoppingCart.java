package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class shoppingCart extends TestBase {

    @Test
    public void cart() {
        driver.get("http://localhost/litecart/en/");

        WebElement content = driver.findElement(By.cssSelector("div.content ul.listing-wrapper"));
        WebElement product = content.findElement(By.tagName("a"));
        product.click();

        WebElement quantity = driver.findElement(By.className("quantity"));
        System.out.println(quantity.getText());
        driver.findElement(By.name("add_cart_product")).click();
        wait.until(ExpectedConditions.stalenessOf(quantity));
        quantity = driver.findElement(By.className("quantity"));

        driver.findElement(By.cssSelector("#breadcrumbs a")).click();
    }
}
