package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;

public class addProduct extends TestBase {
    @Test
    public void newProduct() {
        WebElement leftMenu = driver.findElement(By.id("sidebar"));
        WebElement links = leftMenu.findElement(By.cssSelector("li#app-:nth-child(2)"));
        links.click();

        driver.findElement(By.cssSelector("#content div a:last-child")).click();

        WebElement generalTab = driver.findElement(By.id("tab-general"));

        WebElement status = generalTab.findElement(By.cssSelector("tr"));
        status.findElement(By.cssSelector("input[type=radio]")).click();

        WebElement name = generalTab.findElement(By.cssSelector("tr:nth-child(2) span"));
        name.findElement(By.tagName("input")).sendKeys("Super Product");

        WebElement code = generalTab.findElement(By.cssSelector("tr:nth-child(3)"));
        code.findElement(By.tagName("input")).sendKeys(randomAlphaNumeric(5));

        WebElement categories = generalTab.findElement(By.cssSelector("tr:nth-child(4)"));

        WebElement prodGroups = generalTab.findElement(By.cssSelector("tr:nth-child(7) table"));
        prodGroups.findElement(By.cssSelector("tr:nth-child(4) input[type=\"checkbox\"]")).click();

        WebElement  quantityTable = generalTab.findElement(By.cssSelector("tr:nth-child(8) table"));
        WebElement quantity = quantityTable.findElement(By.tagName("input"));
        quantity.clear();
        quantity.sendKeys("100");

        WebElement soldOutStatus = quantityTable.findElement(By.cssSelector("td:last-child"));
        soldOutStatus.findElement(By.cssSelector("select")).click();
        soldOutStatus.findElement(By.cssSelector(" option[value=\"2\"]")).click();

        WebElement image = generalTab.findElement(By.cssSelector("tr:nth-child(9)"));
        image.findElement(By.tagName("input")).sendKeys(new File("./LinuxToy.jpg").getAbsolutePath());

        WebElement dateFrom = generalTab.findElement(By.cssSelector("tr:nth-child(10)"));
        dateFrom.findElement(By.tagName("input")).sendKeys("06-10-2017");

        WebElement dateTo = generalTab.findElement(By.cssSelector("tr:nth-child(11)"));
        dateTo.findElement(By.tagName("input")).sendKeys("06-10-2019");

        driver.findElement(By.cssSelector(".index li:nth-child(2) a")).click();
    }
}
