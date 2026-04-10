package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginToApplication("Vikram", "Dharman");

        boolean status = loginPage.isLoginSuccessful();

        System.out.println("Login status: " + status);

    }
}