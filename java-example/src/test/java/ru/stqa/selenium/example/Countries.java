package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Countries extends TestBase{

    @Test
    public void sortCountries() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        WebElement table = driver.findElement(By.className("dataTable"));
        List<WebElement> countries = table.findElements(By.cssSelector("tr.row td:nth-child(5)"));

        int numOfCountries = countries.size();
        int tmp = 1;

        System.out.println(numOfCountries);
        for (int i = 1; i < numOfCountries; i++) {
            // Если предыдущая страна лексикографически меньше текущей, то сортировка в алфавитном порядке
            if (countries.get(i-1).getText().compareTo(countries.get(i).getText()) < 0) {
                System.out.println(countries.get(i-1).getText()+" < "+countries.get(i).getText());
                tmp++;
            }
        }

        // Если tmp равен количеству стран, то все страны отсортированы в алфавтном порядке
        if (tmp == 238){
            System.out.println("Countries are arranged in alphabetical order");
        }
        else {
            System.out.println("Countries are not in alphabetical order");
        }

    }
}
