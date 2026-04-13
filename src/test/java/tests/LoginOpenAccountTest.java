package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountsPage;
import pages.LoginPage;
import utils.LoggerUtil;

public class LoginOpenAccountTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void openNewAccountTest() {

        LoginPage loginPage =
                new LoginPage(getDriver());

        loginPage.login("john", "demo");

        AccountsPage accountsPage =
                new AccountsPage(getDriver());

        accountsPage.clickOpenNewAccount();

        accountsPage.selectAccountType();

        accountsPage.clickOpenAccountButton();

        boolean status =
                accountsPage.isAccountCreated();
        LoggerUtil.logInfo( "Account creation status: " + status);

    }

}