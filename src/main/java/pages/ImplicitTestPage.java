package pages;

import basePage.ImplicitBasePage;
import models.Product;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ImplicitTestPage extends ImplicitBasePage {

    public ImplicitTestPage(WebDriver driver) {
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

    @FindBy(css = "[name='customer_privacy']")
    WebElement customerPrivacyCheckbox;

    @FindBy(css = "[name='psgdpr']")
    WebElement policyCheckbox;

    @FindBy(css = "[data-link-action='register-new-customer']")
    WebElement saveButton;

    @FindBy(css = ".form-footer .continue")
    WebElement personalInfoContinueButton;

    @FindBy(id = "payment-option-2")
    WebElement payByBankWireInput;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement termsAndConditionsCheckbox;

    @FindBy(css = ".ps-shown-by-js>[type='submit']")
    WebElement placeOrderButton;

    @FindBy(css = "#checkout-delivery-step .continue")
    WebElement deliveryInfoContinueButton;

    @FindBy(css = "#content-hook_order_confirmation .card-title")
    WebElement confirmationMessage;

    @FindBy(css = ".total-value>td:nth-child(2)")
    WebElement totalPrice;


    public ImplicitTestPage clickOnFirstProduct() {
        performClick(firstProduct);
        return new ImplicitTestPage(driver);
    }

    public ImplicitTestPage addProductToCart(Product product) {
        product.setPrice(price.getText());
        performClick(addToCartButton);
        return new ImplicitTestPage(driver);
    }

    public ImplicitTestPage clickOnConfirmationProceedToCheckout() {
        performClick(confirmationProceedToCheckout);
        return new ImplicitTestPage(driver);
    }

    public ImplicitTestPage clickOnProceedToCheckout() {
        performClick(proceedToCheckoutButton);
        return new ImplicitTestPage(driver);
    }

    public ImplicitTestPage registerNewUser(User user) {
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        checkCustomerPrivacyCheckbox();
        checkPolicyCheckbox();
        clickOnSaveButton();
        return this;
    }

    public ImplicitTestPage fillAddressForm(User user) {
        Select country = new Select(countrySelect);

        typeTextTo(addressInput, user.getAddress());
        typeTextTo(cityInput, user.getCity());
        typeTextTo(postcodeInput, user.getZipCode());
        country.selectByVisibleText(user.getCountry());
        return this;

    }

    public ImplicitTestPage clickOnContinueButtonPersonalInfoSection() {
        performClick(personalInfoContinueButton);
        return this;
    }

    public ImplicitTestPage clickOnContinueButtonDeliveryInfoSection() {
        performClick(deliveryInfoContinueButton);
        return this;
    }

    public ImplicitTestPage selectPayByBankWire() {
        performClick(payByBankWireInput);
        return this;
    }

    public ImplicitTestPage clickOnTermsAndConditionsCheckbox() {
        performClick(termsAndConditionsCheckbox);
        return this;
    }

    public ImplicitTestPage placeOrder() {
        performClick(placeOrderButton);
        return this;
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }


    public ImplicitTestPage setFirstName(String name) {
        typeTextTo(firstNameInput, name);
        return this;
    }

    public ImplicitTestPage setLastName(String lastName) {
        typeTextTo(lastNameInput, lastName);
        return this;
    }

    public ImplicitTestPage setEmail(String email) {
        typeTextTo(emailInput, email);
        return this;
    }

    public ImplicitTestPage setPassword(String password) {
        typeTextTo(passwordInput, password);
        return this;
    }

    public ImplicitTestPage checkCustomerPrivacyCheckbox() {
        performClick(customerPrivacyCheckbox);
        return this;
    }

    public ImplicitTestPage checkPolicyCheckbox() {
        performClick(policyCheckbox);
        return this;
    }

    public ImplicitTestPage clickOnSaveButton() {
        performClick(saveButton);
        return new ImplicitTestPage(driver);
    }


}
