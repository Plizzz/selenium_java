package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;

public class correctProduct extends TestBase {
    @Test
    public void correctProduct() {
        driver.get("http://localhost/litecart/en/");

        WebElement campaignsBlock = driver.findElement(By.id("box-campaigns"));
        String nameOfProduct1 = campaignsBlock.findElement(By.className("name")).getText();

        WebElement prices = campaignsBlock.findElement(By.className("price-wrapper"));
        String regularPrice1 = prices.findElement(By.className("regular-price")).getText();
        String campaignPrice1 = prices.findElement(By.className("campaign-price")).getText();

        campaignsBlock.findElement(By.className("link")).click();

        campaignsBlock = driver.findElement(By.id("box-product"));
        String nameOfProduct2 = campaignsBlock.findElement(By.className("title")).getText();

        prices = campaignsBlock.findElement(By.className("price-wrapper"));
        String regularPrice2 = prices.findElement(By.className("regular-price")).getText();
        String campaignPrice2 = prices.findElement(By.className("campaign-price")).getText();

        System.out.println(nameOfProduct1 + " = " + nameOfProduct2);
        System.out.println(regularPrice1 + " = " + regularPrice2);
        System.out.println(campaignPrice1 + " = " + campaignPrice2);
    }
}
