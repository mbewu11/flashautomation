package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void UserLogin(String mail, String pwd) {
        setValue(email, mail);
        setValue(password, pwd);
        loginButton.click();
    }
}
