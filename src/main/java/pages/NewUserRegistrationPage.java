package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewUserRegistrationPage extends BasePage {
    @FindBy(id = "gender-male")
    WebElement genderMale;

    @FindBy(id = "gender-female")
    WebElement genderFemale;

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    WebElement dayOfBirth;

    @FindBy(name = "DateOfBirthMonth")
    WebElement monthOfBirth;

    @FindBy(name = "DateOfBirthYear")
    WebElement yearOfBirth;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Company")
    WebElement company;

    @FindBy(id = "Newsletter")
    WebElement newsletter;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "register-button")
    WebElement registerButton;

    public NewUserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            genderMale.click();
        } else if (gender.equalsIgnoreCase("female")) {
            genderFemale.click();
        }
    }

    @Step
    public void registerNewUser(String gender, String fName, String lName, String day, String month, String year, String mail, String companyName, String pwd, boolean subscribeToNewsletter) {
        selectGender(gender);
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        dayOfBirth.sendKeys(day);
        monthOfBirth.sendKeys(month);
        yearOfBirth.sendKeys(year);
        email.sendKeys(mail);
        company.sendKeys(companyName);
        if (subscribeToNewsletter) {
            newsletter.click();
        }
        password.sendKeys(pwd);
        confirmPassword.sendKeys(pwd);
        registerButton.click();
    }
}
