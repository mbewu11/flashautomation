package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartItemsPage extends BasePage {
    @FindBy(xpath = "//button[@type='button' and @name='updatecart' and @class='remove-btn']")
    List<WebElement> removeFromCartCheckboxes;

    @FindBy(name = "updatecart")
    WebElement updateCartButton;

    @FindBy(xpath = "//td[@class='cart-total-right']//span[@class='value-summary']//strong")
    WebElement totalPrice;

    @FindBy(xpath = "//span[@class='cart-label' and text()='Shopping cart']")
    WebElement shoppingCartTab;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    WebElement checkOut;

    @FindBy(css = "#termsofservice")
    WebElement termsOfServicesCheckbox;

    public CartItemsPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void removeItemFromCart(int index) {
        removeFromCartCheckboxes.get(index).click();
    }

    @Step
    public String getTotalPrice() {
        return totalPrice.getText();
    }

    @Step
    public void ClickShoppingCart() {
        shoppingCartTab.click();
    }

    @Step
    public void TermsOfServiceCheck() {
        termsOfServicesCheckbox.click();
        waitPageBusy();
    }

    @Step
    public void ClickCheckOut() throws InterruptedException {
        waitPageBusy();
        checkOut.click();
        Thread.sleep(3000);
    }
}
