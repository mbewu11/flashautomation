package pages;

import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckOutPage extends BasePage {

    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement firstName;

    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastName;

    @FindBy(id = "BillingNewAddress_Email")
    WebElement email;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country;

    @FindBy(xpath = "//*[@id=\"BillingNewAddress_StateProvinceId\"]/option[5]")
    WebElement province;

    @FindBy(id = "BillingNewAddress_City")
    WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement postalCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumber;

    @FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button[2]")
    WebElement continueButton;

    @FindBy(xpath = "//input[@title='Confirm']")
    WebElement confirmButton;

    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
    WebElement continueShippingButton;
    @FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
    WebElement continuePaymentButton;
    @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
    WebElement continuePaymentInfoButton;

    @FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/button")
    WebElement confirmOrderButton;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void fillInBillingDetails(String fName, String lName, String mail, String cnt, String state, String cty, String addr, String zip, String phone) {
        setValue(firstName, fName);
        setValue(lastName, lName);
        setValue(email, mail);
        selectFromList(country, cnt);
        //selectFromList(province,state);
        setValue(city, cty);
        setValue(address, addr);
        setValue(postalCode, zip);
        setValue(phoneNumber, phone);
        continueButton.click();
    }

    @Step
    public void confirmOrder() {
        continueButton.click();
    }

    @Step
    public void ClickContinueButton() throws InterruptedException {
        Thread.sleep(3000);
        continueShippingButton.click();
    }

    @Step
    public void ClickPaymentContinueButton() throws InterruptedException {
        Thread.sleep(3000);
        continuePaymentButton.click();
    }

    @Step
    public void ClickConfirmButton() throws InterruptedException {
        Thread.sleep(3000);
        confirmOrderButton.click();
    }

    @Step
    public void ClickPaymentInfoContinueButton() throws InterruptedException {
        Thread.sleep(3000);
        continuePaymentInfoButton.click();
    }

    @Step
    public void ProceedToCheckout() {
        driver.findElement(By.className("inventory_item")).click();
        driver.findElement(By.className("btn_primary")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.className("checkout_button")).click();

        String checkoutUrl = driver.getCurrentUrl();
        Assert.assertTrue(checkoutUrl.contains("checkout-step-one"));
    }

    @Step
    public void EnterShippingInformation() {
        driver.findElement(By.className("inventory_item")).click();
        driver.findElement(By.className("btn_primary")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.className("checkout_button")).click();
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.className("btn_primary")).click();

        String checkoutUrl = driver.getCurrentUrl();
        Assert.assertTrue(checkoutUrl.contains("checkout-step-two"));
    }

    @Step
    public void CompletePurchase() {
        driver.findElement(By.className("inventory_item")).click();
        driver.findElement(By.className("btn_primary")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.className("checkout_button")).click();
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.className("btn_primary")).click();
        driver.findElement(By.className("btn_action")).click();

        String confirmationMessage = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(confirmationMessage.toUpperCase(), "THANK YOU FOR YOUR ORDER!");
    }
}