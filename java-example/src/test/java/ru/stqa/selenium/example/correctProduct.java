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
        WebElement regularPrice = prices.findElement(By.className("regular-price"));
        WebElement campaignPrice = prices.findElement(By.className("campaign-price"));

        String regularPrice1 = regularPrice.getText();
        String campaignPrice1 = campaignPrice.getText();

        String colorOfRegularPrice1 = regularPrice.getCssValue("color");
        String textDecorOfRegularPrice1 = regularPrice.getCssValue("text-decoration-line");
        String fontSizeOfRegularPrice1 = regularPrice.getCssValue("font-size");

        String colorOfCampaignPrice1 = campaignPrice.getCssValue("color");
        String textDecorOfCampaignPrice1 = campaignPrice.getCssValue("font-weight");
        String fontSizeOfCampaignPrice1 = campaignPrice.getCssValue("font-size");

        campaignsBlock.findElement(By.className("link")).click();

        campaignsBlock = driver.findElement(By.id("box-product"));
        String nameOfProduct2 = campaignsBlock.findElement(By.className("title")).getText();

        prices = campaignsBlock.findElement(By.className("price-wrapper"));
        regularPrice = prices.findElement(By.className("regular-price"));
        campaignPrice = prices.findElement(By.className("campaign-price"));

        String regularPrice2 = regularPrice.getText();
        String campaignPrice2 = campaignPrice.getText();

        String colorOfRegularPrice2 = regularPrice.getCssValue("color");
        String textDecorOfRegularPrice2 = regularPrice.getCssValue("text-decoration-line");
        String fontSizeOfRegularPrice2 = regularPrice.getCssValue("font-size");

        String colorOfCampaignPrice2 = campaignPrice.getCssValue("color");
        String textDecorOfCampaignPrice2 = campaignPrice.getCssValue("font-weight");
        String fontSizeOfCampaignPrice2 = campaignPrice.getCssValue("font-size");

        System.out.println(nameOfProduct1 + " = " + nameOfProduct2);
        System.out.println(regularPrice1 + " = " + regularPrice2);
        System.out.println(campaignPrice1 + " = " + campaignPrice2);
        System.out.println("------------------------------------------------");
        System.out.println("Color of regular price in the mainpage: " + colorOfRegularPrice1);
        System.out.println("Text decoration of regular price in the mainpage: " + textDecorOfRegularPrice1);
        System.out.println("Font size of regular price in the mainpage: " + fontSizeOfRegularPrice1);
        System.out.println("------------------------------------------------");
        System.out.println("Color of regular price in the productpage: " + colorOfRegularPrice2);
        System.out.println("Text decoration of regular price in the productpage: " + textDecorOfRegularPrice2);
        System.out.println("Font size of regular price in the productpage: " + fontSizeOfRegularPrice2);
        System.out.println("------------------------------------------------");
        System.out.println("Color of campaign price in the mainpage: " + colorOfCampaignPrice1);
        System.out.println("Text decoration of regular price in the mainpage: " + textDecorOfCampaignPrice1);
        System.out.println("Font size of regular price in the mainpage: " + fontSizeOfCampaignPrice1);
        System.out.println("------------------------------------------------");
        System.out.println("Color of campaign price in the productpage: " + colorOfCampaignPrice2);
        System.out.println("Text decoration of regular price in the productpage: " + textDecorOfCampaignPrice2);
        System.out.println("Font size of regular price in the productpage: " + fontSizeOfCampaignPrice2);
    }
}
