package pages;

import basePage.FluentBasePage;
import models.Product;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FluentTestPage extends FluentBasePage {

    public FluentTestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div:nth-child(1)>article>div>a.product-thumbnail")
    WebElement firstProduct;

    @FindBy(css = "[itemprop='price']")
    WebElement price;

    @FindBy(css = ".add-to-cart")
    WebElement addToCartButton;

    @FindBy(css = ".cart-content-btn>.btn-primary")
    WebElement confirmationProceedToCheckout;

    @FindBy(css = "div.checkout .btn-primary")
    WebElement proceedToCheckoutButton;

    @FindBy(css = "[name='address1']")
    WebElement addressInput;

    @FindBy(css = "[name='city']")
    WebElement cityInput;

    @FindBy(css = "[name='postcode']")
    WebElement postcodeInput;

    @FindBy(css = "[name='id_country']")
    WebElement countrySelect;

    @FindBy(css = "input[name='firstname']")
    WebElement firstNameInput;

    @FindBy(css = "input[name='lastname']")
    WebElement lastNameInput;

    @FindBy(css = "input.form-control[name='email']")
    WebElement emailInput;

    @FindBy(css = "[name='password']")
    WebElement passwordInput;

    @FindBy(css = "#customer-form div:nth-child(9) div:nth-child(2)>span") //span zamiast input - ani visibly of element ani clickable
    WebElement customerPrivacyCheckbox;

    @FindBy(css = "#customer-form div:nth-child(11) div:nth-child(2)>span") //span zamiast input- ani visibly of element ani clickable
    WebElement policyCheckbox;

    @FindBy(css = "[data-link-action='register-new-customer']")
    WebElement saveButton;

    @FindBy(css = ".form-footer .continue")
    WebElement personalInfoContinueButton;

    @FindBy(css = "#payment-option-2-container>span") //span zamiast input- ani visibly of element ani clickable
    WebElement payByBankWireInput;

    @FindBy(css = "#conditions-to-approve span:nth-child(1)")//span zamiast input- ani visibly of element ani clickable
    WebElement termsAndConditionsCheckbox;

    @FindBy(css = ".ps-shown-by-js>[type='submit']")
    WebElement placeOrderButton;

    @FindBy(css = "#checkout-delivery-step .continue")
    WebElement deliveryInfoContinueButton;

    @FindBy(css = "#content-hook_order_confirmation .card-title")
    WebElement confirmationMessage;

    @FindBy(css = ".total-value>td:nth-child(2)")
    WebElement totalPrice;


    public FluentTestPage clickOnFirstProduct() {
        performClick(firstProduct);
        return new FluentTestPage(driver);
    }

    public FluentTestPage addProductToCart(Product product) {
        product.setPrice(price.getText());
        performClick(addToCartButton);
        return new FluentTestPage(driver);
    }

    public FluentTestPage clickOnConfirmationProceedToCheckout() {
        performClick(confirmationProceedToCheckout);
        return new FluentTestPage(driver);
    }

    public FluentTestPage clickOnProceedToCheckout() {
        performClick(proceedToCheckoutButton);
        return new FluentTestPage(driver);
    }

    public FluentTestPage registerNewUser(User user) {
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        checkCustomerPrivacyCheckbox();
        checkPolicyCheckbox();
        clickOnSaveButton();
        return this;
    }

    public FluentTestPage fillAddressForm(User user) {
        Select country = new Select(countrySelect);

        typeTextTo(addressInput, user.getAddress());
        typeTextTo(cityInput, user.getCity());
        typeTextTo(postcodeInput, user.getZipCode());
        country.selectByVisibleText(user.getCountry());
        return this;

    }

    public FluentTestPage clickOnContinueButtonPersonalInfoSection() {
        performClick(personalInfoContinueButton);
        return this;
    }

    public FluentTestPage clickOnContinueButtonDeliveryInfoSection() {
        performClick(deliveryInfoContinueButton);
        return this;
    }

    public FluentTestPage selectPayByBankWire() {
        performClick(payByBankWireInput);
        return this;
    }

    public FluentTestPage clickOnTermsAndConditionsCheckbox() {
        performClick(termsAndConditionsCheckbox);
        return this;
    }

    public FluentTestPage placeOrder() {
        performClick(placeOrderButton);
        return this;
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }


    public FluentTestPage setFirstName(String name) {
        typeTextTo(firstNameInput, name);
        return this;
    }

    public FluentTestPage setLastName(String lastName) {
        typeTextTo(lastNameInput, lastName);
        return this;
    }

    public FluentTestPage setEmail(String email) {
        typeTextTo(emailInput, email);
        return this;
    }

    public FluentTestPage setPassword(String password) {
        typeTextTo(passwordInput, password);
        return this;
    }

    public FluentTestPage checkCustomerPrivacyCheckbox() {
        performClick(customerPrivacyCheckbox);
        return this;
    }

    public FluentTestPage checkPolicyCheckbox() {
        performClick(policyCheckbox);
        return this;
    }

    public FluentTestPage clickOnSaveButton() {
        performClick(saveButton);
        return new FluentTestPage(driver);
    }
}
