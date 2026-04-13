package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegistrationPage;
import utils.LoggerUtil;

public class RegistrationTest extends BaseTest {

    @Test
    public void userRegistrationTest() {

        RegistrationPage registrationPage =
                new RegistrationPage(getDriver());

        String username = "Vik" + System.currentTimeMillis();

        registrationPage.registerUser(
                username,
                "password123"
        );

        boolean status =
                registrationPage.isRegistrationSuccessful();

        LoggerUtil.logInfo("Registration status: " + status);
    }


}