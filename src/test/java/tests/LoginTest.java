package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void LoginTest() {
        new HomePage(getDriver()).navigateToLogin();
        new LoginPage(getDriver()).UserLogin("janedoe@example.com", "password123");
    }
}
