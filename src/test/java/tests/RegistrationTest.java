package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test
    public void userRegistrationTest() {

        RegistrationPage registrationPage =
                new RegistrationPage(driver);

        String username = "vikram" + System.currentTimeMillis();

        registrationPage.registerUser(
                username,
                "password123"
        );

        boolean status =
                registrationPage.isRegistrationSuccessful();

        System.out.println("Registration status: " + status);

    }


}