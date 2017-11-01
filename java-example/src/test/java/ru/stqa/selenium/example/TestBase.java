package ru.stqa.selenium.example;

import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class TestBase {
    public static ThreadLocal<EventFiringWebDriver> tlDriver = new ThreadLocal<>();
    public EventFiringWebDriver driver;
    public WebDriverWait wait;

    public class myListener extends AbstractWebDriverEventListener {
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + " found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            super.onException(throwable, driver);
            File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File screen = new File("screen"+System.currentTimeMillis() + ".png");
            try {
                Files.copy(tmp, screen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Before
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }
        //New scheme
//        Remote Control
//        try {
//            DesiredCapabilities capability = new DesiredCapabilities();
//            capability.setBrowserName("firefox");
//            capability.setVersion("56");
//            capability.setPlatform(Platform.MAC);
//
//            driver = new RemoteWebDriver(new URL("https://alexander1228:U4Hjai4Vq5MEHBNxHxnH@hub-cloud.browserstack.com/wd/hub"), capability);
//        }
//        catch (MalformedURLException e){
//            e.printStackTrace();
//        }
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new myListener());
        wait = new WebDriverWait(driver, 10);
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

        driver.get("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

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

    // Waiting for a new window to appear
    public ExpectedCondition <String> thereIsWindowOtherThan(Set<String> oldWindows) {
      return new ExpectedCondition<String>() {
          @Nullable
          @Override
          public String apply(@Nullable WebDriver driver) {
              Set<String> handles = driver.getWindowHandles();
              handles.removeAll(oldWindows);

              return handles.size() > 0 ? handles.iterator().next() : null;
          }
      };
    }

}
