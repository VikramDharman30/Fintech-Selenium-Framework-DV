package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.RegistrationPage;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void validLoginTest() {

       LoginPage loginPage =
                new LoginPage(driver);

        String username = "john";
        String password = "demo";

        loginPage.login(username, password);

        boolean status =
                loginPage.isLoginSuccessful();

        Assert.assertTrue(
                status,
                "Login failed with valid credentials"
        );

    }

    @Test(groups = {"regression"})
    public void invalidLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "invalidUser",
                "wrongPassword"
        );

        boolean status =
                loginPage.isLoginErrorDisplayed();

        Assert.assertTrue(
                status,
                "Error message not shown for invalid login"
        );

    }



}