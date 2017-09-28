package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class stickersScene extends TestBase {

    @Test
    public void stickers() {
        driver.get("http://localhost/litecart/");

        WebElement products = driver.findElement(By.cssSelector(".middle > .content"));
        List <WebElement> box = products.findElements(By.className("box"));

        for (int i = 0; i < box.size(); i++) {
            List <WebElement> ducks = box.get(i).findElements(By.tagName("li"));

            System.out.println("\n"+box.get(i).findElement(By.className("title")).getText());

            for (int j = 0; j < ducks.size(); j++) {
                WebElement sticker = ducks.get(j).findElement(By.className("sticker"));
                String duckName = ducks.get(j).findElement(By.className("name")).getText();

                System.out.println(duckName + " is " + sticker.getText());
            }
        }
    }
}
