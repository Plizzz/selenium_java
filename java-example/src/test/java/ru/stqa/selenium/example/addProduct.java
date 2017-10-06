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

        //WebElement categories = generalTab.findElement(By.cssSelector("tr:nth-child(4)"));

        WebElement prodGroups = generalTab.findElement(By.cssSelector("tr:nth-child(7) table"));
        prodGroups.findElement(By.cssSelector("tr:nth-child(4) input[type=\"checkbox\"]")).click();

        WebElement  quantityTable = generalTab.findElement(By.cssSelector("tr:nth-child(8) table"));
        WebElement quantity = quantityTable.findElement(By.tagName("input"));
        quantity.clear();
        quantity.sendKeys("100");

        WebElement soldOutStatus = quantityTable.findElement(By.cssSelector("td:last-child"));
        soldOutStatus.findElement(By.tagName("select")).click();
        soldOutStatus.findElement(By.cssSelector("option[value=\"2\"]")).click();

        WebElement image = generalTab.findElement(By.cssSelector("tr:nth-child(9)"));
        image.findElement(By.tagName("input")).sendKeys(new File("./LinuxToy.jpg").getAbsolutePath());

        WebElement dateFrom = generalTab.findElement(By.cssSelector("tr:nth-child(10)"));
        dateFrom.findElement(By.tagName("input")).sendKeys("06-10-2017");

        WebElement dateTo = generalTab.findElement(By.cssSelector("tr:nth-child(11)"));
        dateTo.findElement(By.tagName("input")).sendKeys("06-10-2019");

        driver.findElement(By.cssSelector(".index li:nth-child(2) a")).click();

        WebElement infoTab = driver.findElement(By.id("tab-information"));

        WebElement manufacturer = infoTab.findElement(By.cssSelector("tr select"));
        manufacturer.click();
        manufacturer.findElement(By.cssSelector("option[value=\"1\"")).click();

        WebElement keywords = infoTab.findElement(By.cssSelector("tr:nth-child(3) input"));
        keywords.sendKeys("Linux");

        WebElement shortDesc = infoTab.findElement(By.cssSelector("tr:nth-child(4) input"));
        shortDesc.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                "Suspendisse sollicitudin ante massa, eget ornare libero porta congue.");

        WebElement desc = infoTab.findElement(By.cssSelector("tr:nth-child(5) .trumbowyg-editor"));
        desc.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                "Suspendisse sollicitudin ante massa, eget ornare libero porta congue. Cras scelerisque" +
                "dui non consequat sollicitudin. Sed pretium tortor ac auctor molestie. Nulla facilisi." +
                "Maecenas pulvinar nibh vitae lectus vehicula semper. Donec et aliquet velit. Curabitur non" +
                "ullamcorper mauris. In hac habitasse platea dictumst. Phasellus ut pretium justo, sit amet" +
                "bibendum urna. Maecenas sit amet arcu pulvinar, facilisis quam at, viverra nisi. Morbi sit" +
                "amet adipiscing ante. Integer imperdiet volutpat ante, sed venenatis urna volutpat a. Proin" +
                "justo massa, convallis vitae consectetur sit amet, facilisis id libero.");

        WebElement headTitle = infoTab.findElement(By.cssSelector("tr:nth-child(6) input"));
        headTitle.sendKeys("Pinguin");

        WebElement metaDesc = infoTab.findElement(By.cssSelector("tr:nth-child(7) input"));
        metaDesc.sendKeys("Pinguin");

        driver.findElement(By.cssSelector(".index li:nth-child(4) a")).click();
    }
}
