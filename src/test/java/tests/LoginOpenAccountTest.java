package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountsPage;
import pages.LoginPage;

public class LoginOpenAccountTest extends BaseTest {

    @Test
    public void openNewAccountTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.loginToApplication("john", "demo");

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