package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewUserRegistrationPage;

public class NewUserRegistrationTest extends BaseTest {
    @Test
    public void NewUserRegistrationTest() throws Exception {
        new HomePage(getDriver()).navigateToRegister();
        new NewUserRegistrationPage(getDriver()).registerNewUser("female", "Faith", "Doo", "8", "January", "1998", "okzambewu@gmail.com", "See Inc.", "password123", true);
    }
}
