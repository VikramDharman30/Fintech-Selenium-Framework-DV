package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegistrationPage;
import pages.AccountsPage;
import utils.LoggerUtil;
import utils.RetryAnalyzer;

@Listeners(utils.TestListener.class)
public class RegisterOpenAccountTest extends BaseTest {

    @Test(groups = {"smoke", "regression"},
            retryAnalyzer = RetryAnalyzer.class)
    public void fullBankWorkflowTest() {
        if (driver == null) {
            throw new RuntimeException("Driver not initialized");
        }
        Assert.assertTrue(false);

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

        LoggerUtil.logInfo(
                "Account creation status: " + status);

    }

}