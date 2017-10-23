package ru.stqa.selenium.example.tests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import ru.stqa.selenium.example.model.Customer;

public class DataProviders {

    @DataProvider
    public static Object[][] validCustomers() {
        return new Object[][]{
                {Customer.newEntity()
                        .withFirstname("Adam").withLastname("Smith").withPhone("+0123456798")
                        .withAddress("Hidden Place").withPostcode("12345").withCity("New city")
                        .withCountry("US").withZone("KS")
                        .withEmail("adam" + System.currentTimeMillis() + "@test.ru")
                        .withPassword("password").build()},

        };
    }
}
