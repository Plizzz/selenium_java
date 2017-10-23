package ru.stqa.selenium.example.ShoppingCartPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends Page{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addProduct(int NumOfItemsInTheCart) {
        WebElement quantity = driver.findElement(By.className("quantity"));

        if (isElementPresent(driver, By.cssSelector("td.options select option"))) {
            driver.findElements(By.cssSelector("td.options select option")).get(2).click();
        }

        driver.findElement(By.name("add_cart_product")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(quantity, "" + NumOfItemsInTheCart));
        return this;
    }

    public void goToMainPage() {
        driver.findElement(By.cssSelector("#breadcrumbs a")).click();
    }
}
