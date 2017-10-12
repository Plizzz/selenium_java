package ru.stqa.selenium.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class openWindows extends TestBase {
    @Test
    public void newWindow() {
        // Находим элемент Country
        driver.findElement(By.cssSelector("#box-apps-menu li:nth-child(3) a")).click();
        // Кликаем на кнопку Add New Country
        driver.findElement(By.cssSelector("#content div .button")).click();

        // Ищем список ссылок, на которые нужно ткнуть и сохраняем в лист
        List <WebElement> blank = driver.findElements(By.xpath("//td[@id=\"content\"]//table//a[@target=\"_blank\"]"));

        for (int i = 0; i < blank.size(); i++) {
            // Основное окошко
            String mainWindow = driver.getWindowHandle();
            // Список открытых окон
            Set<String> oldWindow = driver.getWindowHandles();
            // Кликаем по порядку на каждую ссылку
            blank.get(i).click();

            // Ожидаем появления нового окна и записываем идентификатор в переменную
            String newWindow = wait.until(thereIsWindowOtherThan(oldWindow));

            // Переключаемся в новое окно
            driver.switchTo().window(newWindow);

            // Ожидаем появления элемента на странице
            if (i == 3)
                wait.until(ExpectedConditions.presenceOfElementLocated(By.className("default-logo")));  // т.к. это единственный сайт, отличный от википедии
            else
                wait.until(ExpectedConditions.textToBe(By.id("siteSub"), "From Wikipedia, the free encyclopedia"));

            // Закрываем новое окно
            driver.close();
            // Переходим в основное окошко
            driver.switchTo().window(mainWindow);

        }
    }
}
