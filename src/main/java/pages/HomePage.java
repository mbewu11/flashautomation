package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[@class='ico-register' and text()='Register']")
    WebElement registerLink;

    @FindBy(className = "ico-login")
    WebElement loginLink;

    @FindBy(linkText = "Computers")
    WebElement computersTab;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void navigateToRegister() {
        registerLink.click();
    }

    @Step
    public void navigateToLogin() {
        loginLink.click();
    }

    @Step
    public void clickComputersTab() {
        computersTab.click();
    }
}
