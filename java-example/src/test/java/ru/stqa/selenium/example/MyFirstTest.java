package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest extends TestBase{

    @Test
    public void myFirstTest() {
        driver.get("http://google.com/");
        WebElement searchWebDriver = driver.findElement(By.name("q"));
        searchWebDriver.sendKeys("webdriver");
        searchWebDriver.sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Поиск в Google"));
    }
}
