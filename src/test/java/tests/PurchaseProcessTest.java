package tests;

import org.testng.annotations.Test;
import pages.*;
import testng.SoftAssert;

public class PurchaseProcessTest extends BaseTest {
    @Test
    public void PurchaseProcessTest() throws Exception {
        SoftAssert softAssert = new SoftAssert();

        new HomePage(getDriver()).navigateToLogin();
        new LoginPage(getDriver()).UserLogin("okzambewu@gmail.com", "password123");

        // Navigate to Computers -> Desktops
        new HomePage(getDriver()).clickComputersTab();
        new ComputerPage(getDriver()).selectDesktops();

        // Sort desktops by each option and add all to cart
        String[] sortOptions = {"Name: A to Z", "Name: Z to A", "Price: Low to High", "Price: High to Low", "Created on"};
        for (String option : sortOptions) {
            new ComputerPage(getDriver()).sortBy(option);
            Thread.sleep(2000);
        }
        new ComputerPage(getDriver()).addAllDesktopsToCart();
        new ComputerPage(getDriver()).ProductDetails();

        // Validate total price in cart
        new CartItemsPage(getDriver()).ClickShoppingCart();
        String totalPriceBeforeRemoval = new CartItemsPage(getDriver()).getTotalPrice();
        softAssert.assertNotNull(totalPriceBeforeRemoval, "Total price should not be null");

        // Remove one item from cart and validate total price
        Thread.sleep(2000);
        new CartItemsPage(getDriver()).removeItemFromCart(0);
        String totalPriceAfterRemoval = new CartItemsPage(getDriver()).getTotalPrice();
        softAssert.assertNotEquals(totalPriceBeforeRemoval, totalPriceAfterRemoval, "Total price should change after removal");

        // Checkout items
        new CartItemsPage(getDriver()).TermsOfServiceCheck();
        new CartItemsPage(getDriver()).ClickCheckOut();
        new CheckOutPage(getDriver()).fillInBillingDetails("Faith", "Doo", "okzambewu@gmail.com", "Albania", "Alaska", "New York", "123 Elm Street", "10001", "1234567890");
        new CheckOutPage(getDriver()).ClickContinueButton();
        new CheckOutPage(getDriver()).ClickPaymentContinueButton();
        new CheckOutPage(getDriver()).ClickPaymentInfoContinueButton();
        new CheckOutPage(getDriver()).ClickConfirmButton();
    }
}
