package ru.stqa.selenium.example.ShoppingCartPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.manage().window().maximize();
        if (isElementPresent(driver, By.id("logotype-wrapper"))) {
            return;
        }
        driver.get("http://localhost/litecart/en/");
    }

    public void takeFirstProduct() {
        driver.findElement(By.cssSelector("div.content ul.listing-wrapper a")).click();
    }

    public void goToCartPage() {
        WebElement cart = driver.findElement(By.id("cart"));
        cart.findElement(By.className("link")).click();
    }
}
