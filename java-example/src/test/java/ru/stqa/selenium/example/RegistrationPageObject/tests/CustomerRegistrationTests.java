package ru.stqa.selenium.example.RegistrationPageObject.tests;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.stqa.selenium.example.RegistrationPageObject.model.Customer;

import java.util.Set;

import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class CustomerRegistrationTests extends Base {

    @Test
    @UseDataProvider(value = "validCustomers", location = DataProviders.class)
    public void canRegisterCustomer(Customer customer) {
        Set<String> oldIDs = app.getCustomerIDs();

        app.registerNewCustomer(customer);

        Set<String> newIDs = app.getCustomerIDs();

        assertTrue(newIDs.containsAll(oldIDs));
        assertTrue(newIDs.size() == oldIDs.size() + 1);
    }
}
