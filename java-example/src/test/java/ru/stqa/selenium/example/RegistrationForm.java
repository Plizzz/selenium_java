package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.*;

public class RegistrationForm extends TestBase {

    @Test
    public void regForm() {
        driver.findElement(By.cssSelector("div.content tr:nth-child(5) a")).click();

        // Случайное значение для LastName
        String randValue = randomAlphaNumeric(5);

        WebElement taxID = driver.findElement(By.name("tax_id"));
        taxID.sendKeys("55555");

        WebElement company = driver.findElement(By.name("company"));
        company.sendKeys("HumanLab");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("username");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys(randValue);

        WebElement address1 = driver.findElement(By.name("address1"));
        address1.sendKeys("USA");

        WebElement address2 = driver.findElement(By.name("address2"));
        address2.sendKeys("-");

        WebElement postcode = driver.findElement(By.name("postcode"));
        postcode.sendKeys("90210");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Beverly Hills");

        // Выбор страны
        driver.findElement(By.cssSelector("[id ^= select2]")).click();
        WebElement country = driver.findElement(By.className("select2-search__field"));
        country.sendKeys("United States");
        country.sendKeys(Keys.ENTER);

        // Выбор штата
        WebElement zoneCode = driver.findElement(By.cssSelector("td:nth-child(2) select"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex = 11;" +
                                                           "arguments[0].dispatchEvent(new Event('change'))", zoneCode);


        // Случайный email-адрес
        String emailAddr = randomAlphaNumeric(10)+"@test.ru";
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(emailAddr);

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("+1-541-754-3010");

        driver.findElement(By.name("newsletter")).click();

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password");

        WebElement confirmedPassword = driver.findElement(By.name("confirmed_password"));
        confirmedPassword.sendKeys("password");

        driver.findElement(By.name("create_account")).click();

        // logout
        driver.findElement(By.cssSelector("div#box-account li:last-child a")).click();

        email = driver.findElement(By.name("email"));
        email.sendKeys(emailAddr);

        password = driver.findElement(By.name("password"));
        password.sendKeys("password");

        driver.findElement(By.name("login")).click();

        // logout
        driver.findElement(By.cssSelector("div#box-account li:last-child a")).click();
    }
}
