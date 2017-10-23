package ru.stqa.selenium.example.ShoppingCartPageObject.tests;

import org.junit.Test;

public class ShoppingCartTests extends Base {
    @Test
    public void cart() {
        int numOfProducts = 4;

        for (int i = 1; i <= numOfProducts; i++) {
            app.goToTheFirstProduct();
            app.addProduct(i);
        }
        app.goToTheCart();
        app.deleteAllProducts(numOfProducts);
    }
}
