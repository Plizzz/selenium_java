package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.By;

public class loginScript extends TestBase {

    @Test
    public void loginScript() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
}
