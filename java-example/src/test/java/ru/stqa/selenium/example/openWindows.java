package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class openWindows extends TestBase {
    @Test
    public void newWindow() {
        driver.findElement(By.cssSelector("#box-apps-menu li:nth-child(3) a")).click();
        driver.findElement(By.cssSelector("#content div .button")).click();

        List <WebElement> blank = driver.findElements(By.xpath("//td[@id=\"content\"]//table//a[@target=\"_blank\"]"));
        System.out.println(blank.size());
        for (int i = 0; i < blank.size(); i++) {
            blank = driver.findElements(By.xpath("//td[@id=\"content\"]//table//a[@target=\"_blank\"]"));
        }
    }
}
