package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegistrationPage;
import pages.AccountsPage;
import pages.TransferFundsPage;
import utils.LoggerUtil;
import utils.RetryAnalyzer;


public class TransferFundsTest extends BaseTest {

    @Test(
            groups = {"regression"},
            retryAnalyzer = RetryAnalyzer.class)
    public void transferFundsWorkflowTest() {

        RegistrationPage registrationPage =
                new RegistrationPage(getDriver());

        String username =
                "user" + System.currentTimeMillis();

        String password = "password123";

        // Register user (auto login)

        registrationPage.registerUser(
                username,
                password
        );

        AccountsPage accountsPage =
                new AccountsPage(getDriver());

        // Create new account

        accountsPage.clickOpenNewAccount();

        accountsPage.selectAccountType();

        accountsPage.clickOpenAccountButton();

        accountsPage.isAccountCreated();

        TransferFundsPage transferPage =
                new TransferFundsPage(getDriver());

        // Transfer funds

        transferPage.navigateToTransferFunds();

        transferPage.enterAmount("100");

        transferPage.selectFromAccount();

        transferPage.selectToAccount();

        transferPage.clickTransferButton();

        boolean status =
                transferPage.isTransferSuccessful();

        LoggerUtil.logInfo("Transfer status: " + status);

    }

}