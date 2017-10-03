package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.StringTokenizer;

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
        String s1 = colorOfRegularPrice1.substring(5);
        StringTokenizer stringTokenizer1 = new StringTokenizer(s1);
        int r = Integer.parseInt(stringTokenizer1.nextToken(",").trim());
        int g = Integer.parseInt(stringTokenizer1.nextToken(",").trim());
        int b = Integer.parseInt(stringTokenizer1.nextToken(",").trim());
        if ((r == g) && (g == b))
            s1 = "Color of regular price in the mainpage is gray";
        else
            s1 = "Color of regular price in the mainpage isn't gray";

        String textDecorOfRegularPrice1 = regularPrice.getCssValue("text-decoration-line");

        String fontSizeOfRegularPrice1 = regularPrice.getCssValue("font-size");
        StringTokenizer fr1 = new StringTokenizer(fontSizeOfRegularPrice1);
        float sizeOfRegularPrice1 = Float.parseFloat(fr1.nextToken("p").trim());

        String colorOfCampaignPrice1 = campaignPrice.getCssValue("color");
        String s2 = colorOfCampaignPrice1.substring(5);
        StringTokenizer stringTokenizer2 = new StringTokenizer(s2);
        r = Integer.parseInt(stringTokenizer2.nextToken(",").trim());
        g = Integer.parseInt(stringTokenizer2.nextToken(",").trim());
        b = Integer.parseInt(stringTokenizer2.nextToken(",").trim());
        if ((r != 0) && (g == 0) && (b == 0)) {
            s2 = "Color of campaign price in the mainpage is red";
        }
        else
            s2 = "Color of campaign price in the mainpage isn't red";

        String textDecorOfCampaignPrice1 = campaignPrice.getCssValue("font-weight");

        String fontSizeOfCampaignPrice1 = campaignPrice.getCssValue("font-size");
        StringTokenizer fc1 = new StringTokenizer(fontSizeOfCampaignPrice1);
        float sizeOfCampaignPrice1 = Float.parseFloat(fc1.nextToken("p").trim());

        campaignsBlock.findElement(By.className("link")).click();

        campaignsBlock = driver.findElement(By.id("box-product"));
        String nameOfProduct2 = campaignsBlock.findElement(By.className("title")).getText();

        prices = campaignsBlock.findElement(By.className("price-wrapper"));
        regularPrice = prices.findElement(By.className("regular-price"));
        campaignPrice = prices.findElement(By.className("campaign-price"));

        String regularPrice2 = regularPrice.getText();
        String campaignPrice2 = campaignPrice.getText();

        String colorOfRegularPrice2 = regularPrice.getCssValue("color");
        String s3 = colorOfRegularPrice2.substring(5);
        StringTokenizer stringTokenizer3 = new StringTokenizer(s3);
        r = Integer.parseInt(stringTokenizer3.nextToken(",").trim());
        g = Integer.parseInt(stringTokenizer3.nextToken(",").trim());
        b = Integer.parseInt(stringTokenizer3.nextToken(",").trim());
        if ((r == g) && (g == b))
            s3 = "Color of regular price in the productpage is gray";
        else
            s3 = "Color of regular price in the productpage isn't gray";

        String textDecorOfRegularPrice2 = regularPrice.getCssValue("text-decoration-line");

        String fontSizeOfRegularPrice2 = regularPrice.getCssValue("font-size");
        StringTokenizer fr2 = new StringTokenizer(fontSizeOfRegularPrice2);
        float sizeOfRegularPrice2 = Float.parseFloat(fr2.nextToken("p").trim());

        String colorOfCampaignPrice2 = campaignPrice.getCssValue("color");
        String s4 = colorOfCampaignPrice2.substring(5);
        StringTokenizer stringTokenizer4 = new StringTokenizer(s4);
        r = Integer.parseInt(stringTokenizer4.nextToken(",").trim());
        g = Integer.parseInt(stringTokenizer4.nextToken(",").trim());
        b = Integer.parseInt(stringTokenizer4.nextToken(",").trim());

        if ((r != 0) && (g == 0) && (b == 0)) {
            s4 = "Color of campaign price in the productpage is red";
        }
        else
            s4 = "Color of campaign price in the productpage isn't red";

        String textDecorOfCampaignPrice2 = campaignPrice.getCssValue("font-weight");

        String fontSizeOfCampaignPrice2 = campaignPrice.getCssValue("font-size");
        StringTokenizer fc2 = new StringTokenizer(fontSizeOfCampaignPrice2);
        float sizeOfCampaignPrice2 = Float.parseFloat(fc2.nextToken("p").trim());

        System.out.println("------------------------A-------------------------");
        System.out.println(nameOfProduct1 + " = " + nameOfProduct2);
        System.out.println("------------------------A-------------------------\n");

        System.out.println("------------------------Б-------------------------");
        System.out.println(regularPrice1 + " = " + regularPrice2);
        System.out.println(campaignPrice1 + " = " + campaignPrice2);
        System.out.println("------------------------Б-------------------------\n");

        System.out.println("------------------------В-------------------------");
        System.out.println("Text decoration of regular price in the mainpage: " + textDecorOfRegularPrice1);
        System.out.println(s1);
        System.out.println("----------------------");
        System.out.println("Text decoration of regular price in the productpage: " + textDecorOfRegularPrice2);
        System.out.println(s3);
        System.out.println("------------------------В-------------------------\n");

        System.out.println("------------------------Г-------------------------");
        System.out.println("Text decoration of regular price in the mainpage: " + textDecorOfCampaignPrice1);
        System.out.println(s2);
        System.out.println("----------------------");
        System.out.println("Text decoration of regular price in the productpage: " + textDecorOfCampaignPrice2);
        System.out.println(s4);
        System.out.println("------------------------Г-------------------------\n");

        System.out.println("------------------------Д-------------------------");
        System.out.println("Font size of regular price in the mainpage: " + fontSizeOfRegularPrice1);
        System.out.println("Font size of campaign price in the mainpage: " + fontSizeOfCampaignPrice1);
        if (sizeOfRegularPrice1 < sizeOfCampaignPrice1)
            System.out.println("Font-size of the campaign price is bigger than the regular price in the mainpage");
        else
            System.out.println("Font-size of the regular price is bigger than the campaign price in the mainpage");
        System.out.println("----------------------");

        System.out.println("Font size of regular price in the productpage: " + fontSizeOfRegularPrice2);
        System.out.println("Font size of campaign price in the productpage: " + fontSizeOfCampaignPrice2);
        if (sizeOfRegularPrice2 < sizeOfCampaignPrice2) {
            System.out.println("Font-size of the campaign price is bigger than the regular price in the productpage");
        }
        else
            System.out.println("Font-size of the regular price is bigger than the campaign price in the productpage");
        System.out.println("------------------------Д-------------------------\n");

    }
}
