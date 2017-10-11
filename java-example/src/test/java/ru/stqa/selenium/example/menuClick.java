package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;

public class menuClick extends TestBase {

    @Test
    public void Test1() {

        int numOfEl = driver.findElements(By.id("app-")).size();
        int row;

        for (int i = 0; i < numOfEl; i++) {
            WebElement leftMenu = driver.findElement(By.id("sidebar"));
            List<WebElement> links = leftMenu.findElements(By.id("app-"));
            links.get(i).click();

            if (isElementPresent(driver, By.tagName("h1"))) {
                String name = driver.findElement(By.tagName("h1")).getText();
                System.out.println(name);
            }
            row = driver.findElements(By.cssSelector("ul.docs li")).size();

            for (int j = 1; j < row; j++) {
                List<WebElement> rows = driver.findElements(By.cssSelector("ul.docs li"));
                rows.get(j).click();

                if (isElementPresent(driver, By.tagName("h1"))) {
                    String name = driver.findElement(By.tagName("h1")).getText();
                    System.out.println(name);
                }
                else {
                    System.out.println("No header");
                }
            }
        }
    }
}
