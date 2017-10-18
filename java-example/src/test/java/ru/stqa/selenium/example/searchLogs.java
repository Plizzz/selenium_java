package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

public class searchLogs extends TestBase {
    @Test
    public void searchLog() {
        WebElement leftMenu = driver.findElement(By.id("sidebar"));
        WebElement links = leftMenu.findElement(By.cssSelector("li#app-:nth-child(2)"));
        links.click();
        driver.manage().logs().get("browser").forEach(logEntry -> System.out.println("Log for catalog's page " + logEntry));

        WebElement table = driver.findElement(By.className("dataTable"));
        List<WebElement> products = table.findElements(By.cssSelector("td:nth-child(3) a"));
        products.get(1).click();

        for (int i = 3; i < products.size(); i++) {
            products = driver.findElements(By.cssSelector(".dataTable td:nth-child(3) a"));
            products.get(i).click();
            for (LogEntry logEntry : driver.manage().logs().get("browser").getAll())
                System.out.println("Log for product's page " + logEntry);
            driver.navigate().back();
        }
    }
}
