package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegistrationPage;
import pages.AccountsPage;
import pages.TransferFundsPage;
import utils.RetryAnalyzer;


public class TransferFundsTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void transferFundsWorkflowTest() {

        RegistrationPage registrationPage =
                new RegistrationPage(driver);

        String username =
                "user" + System.currentTimeMillis();

        String password = "password123";

        // Register user (auto login)

        registrationPage.registerUser(
                username,
                password
        );

        AccountsPage accountsPage =
                new AccountsPage(driver);

        // Create new account

        accountsPage.clickOpenNewAccount();

        accountsPage.selectAccountType();

        accountsPage.clickOpenAccountButton();

        accountsPage.isAccountCreated();

        TransferFundsPage transferPage =
                new TransferFundsPage(driver);

        // Transfer funds

        transferPage.navigateToTransferFunds();

        transferPage.enterAmount("Invalid");

        transferPage.selectFromAccount();

        transferPage.selectToAccount();

        transferPage.clickTransferButton();

        boolean status =
                transferPage.isTransferSuccessful();

        System.out.println(
                "Transfer status: " + status);

    }

}