package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ComputerPage extends BasePage {
    @FindBy(linkText = "Desktops")
    WebElement desktopsOption;

    @FindBy(id = "products-orderby")
    WebElement sortByDropdown;

    @FindBy(css = ".product-box-add-to-cart-button")
    List<WebElement> addToCartButtons;

    @FindBy(xpath = "//h1[text()='Build your own computer']")
    WebElement buildIt;
    @FindBy(id = "product_attribute_1")
    WebElement processorDropdown;

    @FindBy(id = "product_attribute_2")
    WebElement ramDropdown;

    @FindBy(id = "product_attribute_3_6")
    WebElement hddCheckbox;

    @FindBy(id = "product_attribute_3_7")
    WebElement sddCheckbox;

    @FindBy(id = "product_attribute_4_8")
    WebElement osCheckbox;

    @FindBy(id = "product_attribute_4_9")
    WebElement msOfficeCheckbox;

    @FindBy(id = "product_attribute_5_10")
    WebElement totalCommanderCheckbox;

    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCartButton;

    public ComputerPage(WebDriver driver) {
        super(driver);
    }

    public void selectProcessor(String processor) {
        new Select(processorDropdown).selectByVisibleText(processor);
    }

    public void selectRAM(String ram) {
        new Select(ramDropdown).selectByVisibleText(ram);
    }

    public void selectHDD(boolean isChecked) {
        if (isChecked && !hddCheckbox.isSelected()) {
            hddCheckbox.click();
        } else if (!isChecked && hddCheckbox.isSelected()) {
            hddCheckbox.click();
        }
    }

    public void selectSDD(boolean isChecked) {
        if (isChecked && !sddCheckbox.isSelected()) {
            sddCheckbox.click();
        } else if (!isChecked && sddCheckbox.isSelected()) {
            sddCheckbox.click();
        }
    }

    public void selectOS(boolean isChecked) {
        if (isChecked && !osCheckbox.isSelected()) {
            osCheckbox.click();
        } else if (!isChecked && osCheckbox.isSelected()) {
            osCheckbox.click();
        }
    }

    public void selectMSOffice(boolean isChecked) {
        if (isChecked && !msOfficeCheckbox.isSelected()) {
            msOfficeCheckbox.click();
        } else if (!isChecked && msOfficeCheckbox.isSelected()) {
            msOfficeCheckbox.click();
        }
    }

    public void selectTotalCommander(boolean isChecked) {
        if (isChecked && !totalCommanderCheckbox.isSelected()) {
            totalCommanderCheckbox.click();
        } else if (!isChecked && totalCommanderCheckbox.isSelected()) {
            totalCommanderCheckbox.click();
        }
    }

    public void addToCart() {
        addToCartButton.click();
    }

    @Step
    public void selectDesktops() {
        desktopsOption.click();
    }

    @Step
    public void sortBy(String option) {
        Select select = new Select(sortByDropdown);
        select.selectByVisibleText(option);
    }

    @Step
    public void addAllDesktopsToCart() {
        for (WebElement button : addToCartButtons) {
            button.click();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Step
    public void ProductDetails() throws InterruptedException {
        Thread.sleep(2000);
        selectProcessor("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
        selectRAM("2 GB");
        selectHDD(true);
        selectSDD(true);
        selectOS(true);
        selectMSOffice(true);
        selectTotalCommander(true);
        addToCart();
    }
}
