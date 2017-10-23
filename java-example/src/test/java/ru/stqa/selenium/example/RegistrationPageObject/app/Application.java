package ru.stqa.selenium.example.RegistrationPageObject.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.selenium.example.RegistrationPageObject.model.Customer;
import ru.stqa.selenium.example.RegistrationPageObject.pages.AdminPanelLoginPage;
import ru.stqa.selenium.example.RegistrationPageObject.pages.CustomerListPage;
import ru.stqa.selenium.example.RegistrationPageObject.pages.RegistrationPage;

import java.util.Set;

public class Application {

    private WebDriver driver;

    private RegistrationPage registrationPage;
    private AdminPanelLoginPage adminPanelLoginPage;
    private CustomerListPage customerListPage;

    public Application() {
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
        adminPanelLoginPage = new AdminPanelLoginPage(driver);
        customerListPage = new CustomerListPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void registerNewCustomer(Customer customer) {
        registrationPage.open();
        registrationPage.firstnameInput.sendKeys(customer.getFirstname());
        registrationPage.lastnameInput.sendKeys(customer.getLastname());
        registrationPage.address1Input.sendKeys(customer.getAddress());
        registrationPage.postcodeInput.sendKeys(customer.getPostcode());
        registrationPage.cityInput.sendKeys(customer.getCity());
        registrationPage.selectCountry(customer.getCountry());
        registrationPage.selectZone(customer.getZone());
        registrationPage.emailInput.sendKeys(customer.getEmail());
        registrationPage.phoneInput.sendKeys(customer.getPhone());
        registrationPage.passwordInput.sendKeys(customer.getPassword());
        registrationPage.confirmedPasswordInput.sendKeys(customer.getPassword());
        registrationPage.createAccountButton.click();
    }

    public Set<String> getCustomerIDs() {
        if (adminPanelLoginPage.open().isOnThisPage()) {
            adminPanelLoginPage.enterUsername("admin").enterPassword("admin").submitLogin();
        }
        return customerListPage.open().getCustomerIDs();
    }
}
