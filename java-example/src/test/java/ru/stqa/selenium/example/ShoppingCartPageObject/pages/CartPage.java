package ru.stqa.selenium.example.ShoppingCartPageObject.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends Page {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void deleteAllProducts(int numOfProducts) {
        for (int i = 1; i <= numOfProducts; i++) {
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
