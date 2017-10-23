package ru.stqa.selenium.example.ShoppingCartPageObject.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.selenium.example.ShoppingCartPageObject.pages.CartPage;
import ru.stqa.selenium.example.ShoppingCartPageObject.pages.MainPage;
import ru.stqa.selenium.example.ShoppingCartPageObject.pages.ProductPage;

public class Application {

    private WebDriver driver;

    private MainPage mainPage;
    private CartPage cartPage;
    private ProductPage productPage;

    public Application() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void goToTheFirstProduct() {
        mainPage.open();
        mainPage.takeFirstProduct();
    }

    public void addProduct(int numOfProducts) {
        productPage.addProduct(numOfProducts).goToMainPage();
    }

    public void goToTheCart() {
        mainPage.goToCartPage();
    }

    public void deleteAllProducts(int numOfProducts) {
        cartPage.deleteAllProducts(numOfProducts);
    }
}
