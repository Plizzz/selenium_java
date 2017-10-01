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

        // Количество стран
        int numOfCountries = driver.findElement(By.className("dataTable")).findElements(By.cssSelector("tr.row td:nth-child(5) a")).size();
        // Для проверки правильности сортировки стран
        int tmpCountry = 0;
        // Для проверки правильности сортировки зон
        int tmpZone = 0;

        for (int i = 0; i < numOfCountries; i++) {
            // Таблица со странами
            WebElement tableOfCountries = driver.findElement(By.className("dataTable"));
            // Список стран
            List<WebElement> countries = tableOfCountries.findElements(By.cssSelector("tr.row td:nth-child(5) a"));
            // Список количества зон у стран
            List<WebElement> zonesOfCountry = tableOfCountries.findElements(By.cssSelector("tr.row td:nth-child(6)"));

            //Первую страну не сравниваем
            if (i == 0)
                tmpCountry++;
            else {
                // Если предыдущая страна лексикографически меньше текущей, то проверяем
                // сортировку в прямом алфавитном порядке
                if (countries.get(i - 1).getText().compareTo(countries.get(i).getText()) < 0) {
                    System.out.println(countries.get(i - 1).getText() + " < " + countries.get(i).getText());
                    tmpCountry++;
                }
            }

            // Если количество геозон отлично от 0, то кликаем по стране
            if (Integer.parseInt(zonesOfCountry.get(i).getText()) > 0) {
                System.out.println("ZONE: "+countries.get(i).getText());
                countries.get(i).click();

                // Таблица геозон
                WebElement tableOfZones = driver.findElement(By.id("table-zones"));
                // Список геозон
                List<WebElement> zone = tableOfZones.findElements(By.cssSelector("tr td:nth-child(3)"));
                // Количество геозон
                int numOfZones = zone.size();
                // Осуществляем проход по каждой геозоне и осуществляем проверку на
                // правильность сортировки
                for (int j = 0; j < numOfZones-1; j++) {

                    if (j == 0) {
                        tmpZone++;
                    }
                    else {
                        if (zone.get(j-1).getText().compareTo(zone.get(j).getText()) < 0) {
                            System.out.println("---"+zone.get(j - 1).getText() + " < " + zone.get(j).getText());
                            tmpZone++;
                        }
                    }
                }
                if (tmpZone == numOfZones-1) {
                    System.out.println("Zones are arranged in alphabetical order");
                }
                else {
                    System.out.println("Zones are not in alphabetical order");
                }
                tmpZone = 0;
                // После прохода по геозонам, возвращаемся назад
                driver.navigate().back();
            }
        }

        // Если tmp равен количеству стран, то все страны отсортированы в алфавтном порядке
        if (tmpCountry == numOfCountries){
            System.out.println("Countries are arranged in alphabetical order");
        }
        else {
            System.out.println("Countries are not in alphabetical order");
        }

    }

//    @Test
//    public void sortZones() {
//        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
//        driver.findElement(By.name("username")).sendKeys("admin");
//        driver.findElement(By.name("password")).sendKeys("admin");
//        driver.findElement(By.name("login")).click();
//        WebElement tableOfCountries = driver.findElement(By.className("dataTable"));
//
//        int numOfCoutries = tableOfCountries.findElements(By.cssSelector("tr.row td:nth-child(3) a")).size();
//
//        for (int i = 0; i < numOfCoutries; i++) {
//            List<WebElement> countries = tableOfCountries.findElements(By.cssSelector("tr.row td:nth-child(3) a"));
//
//            countries.get(i).click();
//
//            WebElement tableOfGeoZones = driver.findElement(By.id("table-zones"));
//            int numOfZones = tableOfGeoZones.findElements(By.cssSelector("td:nth-child(3)")).size();
//
//            List<WebElement> Zones = tableOfGeoZones.findElements(By.cssSelector("td:nth-child(3) option"));
//            for (int j = 0; j < numOfZones; j++) {
//                System.out.println(Zones.get(j).getText());
//
//            }
//        }
//
//    }
}
