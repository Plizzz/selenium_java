package ru.stqa.selenium.example;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class TestBase {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }
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
        tlDriver.set(driver);
        driver.manage().window().maximize();

        driver.get("http://localhost/litecart/");

//        driver.findElement(By.name("username")).sendKeys("admin");
//        driver.findElement(By.name("password")).sendKeys("admin");
//        driver.findElement(By.name("login")).click();

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {driver.quit(); driver = null;}));
    }

    @After
    public void stop() {
    }

    boolean isElementPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

    // Constant string from which we take random characters
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                                                       "abcdefghijklmnopqrstuvwxyz" +
                                                       "0123456789";
    // A function that generates a random character set.
    // Specify the length of a string as a parameter
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
