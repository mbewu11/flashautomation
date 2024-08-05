package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    @FindBy(linkText = "Orders")
    WebElement ordersLink;

    @FindBy(css = ".order-list")
    WebElement ordersList;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void navigateToOrders() {
        ordersLink.click();
    }

    @Step
    public boolean isOrderPresent() {
        return ordersList.isDisplayed();
    }
}
