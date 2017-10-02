package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Countries extends TestBase{

    // Задание №9. Часть 1
    @Test
    public void sortCountries() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        // Количество стран
        int numOfCountries = driver.findElement(By.className("dataTable")).findElements(By.cssSelector("tr.row td:nth-child(5) a")).size();
        // Для проверки правильности сортировки стран
        int tmpCountry = 0;
        // Для проверки правильности сортировки зон
        int tmpZone = 0;
        // Для сравнения страны
        String country = "";
        System.out.println("Countries:");

        for (int i = 0; i < numOfCountries; i++) {
            // Таблица со странами
            WebElement tableOfCountries = driver.findElement(By.className("dataTable"));
            // Список стран
            List<WebElement> countries = tableOfCountries.findElements(By.cssSelector("tr.row td:nth-child(5) a"));
            // Список количества зон у стран
            List<WebElement> zonesOfCountry = tableOfCountries.findElements(By.cssSelector("tr.row td:nth-child(6)"));

            //Первую страну не сравниваем. Записываем ее в переменную country
            if (country == "") {
                country = countries.get(i).getText();
                tmpCountry++;
            }
            else {
                // Если предыдущая страна лексикографически меньше текущей, то проверяем
                // сортировку в прямом алфавитном порядке
                if (country.compareTo(countries.get(i).getText()) < 0) {
                    country = countries.get(i).getText();
                    tmpCountry++;
                }
            }
            System.out.println("---"+country);

            // Если количество геозон отлично от 0, то кликаем по стране
            if (Integer.parseInt(zonesOfCountry.get(i).getText()) > 0) {
                System.out.println("ZONES: "+country);
                countries.get(i).click();

                // Таблица геозон
                WebElement tableOfZones = driver.findElement(By.id("table-zones"));
                // Список геозон
                List<WebElement> zones = tableOfZones.findElements(By.cssSelector("tr td:nth-child(3)"));
                String zone = "";
                // Количество геозон (убираем последнюю строчку, т.к. там нет информации по зонам)
                int numOfZones = zones.size() - 1;
                // Осуществляем проход по каждой геозоне и осуществляем проверку на
                // правильность сортировки
                for (int j = 0; j < numOfZones; j++) {
                    if (j == 0) {
                        zone = zones.get(j).getText();
                        tmpZone++;
                    }
                    else {
                        if (zone.compareTo(zones.get(j).getText()) < 0) {
                            zone = zones.get(j).getText();
                            tmpZone++;
                        }
                    }
                    System.out.println("------"+zone);
                }
                if (tmpZone == numOfZones) {
                    System.out.println("Zones are arranged in alphabetical order\n");
                }
                else {
                    System.out.println("Zones are not in alphabetical order\n");
                }
                tmpZone = 0;
                // После прохода по геозонам, возвращаемся назад
                driver.navigate().back();
            }
        }

        // Если tmpCountry равен количеству стран, то все страны отсортированы в алфавтном порядке
        if (tmpCountry == numOfCountries){
            System.out.println("Countries are arranged in alphabetical order");
        }
        else {
            System.out.println("Countries are not in alphabetical order");
        }

    }

    // Задание №9. Часть 2
    @Test
    public void sortZones() {
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        // Количество стран
        int numOfCountries = driver.findElement(By.className("dataTable")).findElements(By.cssSelector("tr.row td:nth-child(3) a")).size();
        // Заходим в каждую страну и ищем геозоны
        for (int i = 0; i < numOfCountries; i++) {
            // Таблица со странами
            WebElement tableOfCountries = driver.findElement(By.className("dataTable"));
            // Список стран
            List<WebElement> countries = tableOfCountries.findElements(By.cssSelector("tr.row td:nth-child(3) a"));

            System.out.println(countries.get(i).getText()+":");
            countries.get(i).click();
            // Для проверки правильности сортировки
            int tmpZone = 0;
            // Таблица геозон
            WebElement tableOfGeoZones = driver.findElement(By.id("table-zones"));
            // Количество геозон
            int numOfZones = tableOfGeoZones.findElements(By.cssSelector("td:nth-child(3)")).size();
            // Для сравнения геозон
            String selectedZone = "";
            // Рассмотрим каждую геозону и сравним ее с предыдущей
            for (int j = 0; j < numOfZones; j++) {
                // Список геозон
                List<WebElement> zones = tableOfGeoZones.findElements(By.cssSelector("td:nth-child(3)"));
                // Выбранная геозона
                WebElement options = zones.get(j).findElement(By.cssSelector("option[selected]"));
                // Если первый обход по циклу, то записываем первое значение и переходим на следующий
                if (selectedZone == "") {
                    selectedZone = options.getText();
                    tmpZone++;
                }
                else {
                    if (selectedZone.compareTo(options.getText()) < 0) {
                                selectedZone = options.getText();
                                tmpZone++;
                            }
                }
                System.out.println("---"+selectedZone);
            }
            
            if (tmpZone == numOfZones) {
                System.out.println("Zones are arranged in alphabetical order\n");
            }
            else{
                System.out.println("Zones are not in alphabetical order\n");
            }
            driver.navigate().back();
        }
    }
}
