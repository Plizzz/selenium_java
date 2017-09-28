package ru.stqa.selenium.example;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class TestBase {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        //New scheme
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();

/*        //Old scheme with Firefox ESR
          FirefoxOptions options = new FirefoxOptions().setLegacy(true);
          options.setBinary(new FirefoxBinary(new File("/home/alex/Tools/firefox ESR/firefox")));
          driver = new FirefoxDriver(options);

          //Firefox nightly
          FirefoxOptions options = new FirefoxOptions();
          options.setBinary(new FirefoxBinary(new File("/home/alex/Tools/firefox nightly/firefox")));
          driver = new FirefoxDriver(options);
*/

        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    boolean isElementPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
