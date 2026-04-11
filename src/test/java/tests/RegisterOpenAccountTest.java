package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegistrationPage;
import pages.AccountsPage;

public class RegisterOpenAccountTest extends BaseTest {

    @Test
    public void fullBankWorkflowTest() {

        RegistrationPage registrationPage =
                new RegistrationPage(driver);

        String username =
                "user" + System.currentTimeMillis();

        String password = "password123";

        // Register User
        registrationPage.registerUser(
                username,
                password
        );

        System.out.println("Registered user: " + username);


        // Open New Account
        AccountsPage accountsPage =
                new AccountsPage(driver);

        accountsPage.clickOpenNewAccount();

        accountsPage.selectAccountType();

        accountsPage.clickOpenAccountButton();

        boolean status =
                accountsPage.isAccountCreated();

        System.out.println(
                "Account creation status: " + status);

    }

}