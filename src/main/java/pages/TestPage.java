package pages;

import basePage.BasePage;
import io.qameta.allure.Step;
import models.Product;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TestPage extends BasePage {

    public TestPage(WebDriver driver) {
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

    @FindBy(css = "#customer-form div:nth-child(9) div:nth-child(2)>span")
    WebElement customerPrivacyCheckbox;

    @FindBy(css = "#customer-form div:nth-child(11) div:nth-child(2)>span")
    WebElement policyCheckbox;

    @FindBy(css = "[data-link-action='register-new-customer']")
    WebElement saveButton;

    @FindBy(css = ".form-footer .continue")
    WebElement personalInfoContinueButton;

    @FindBy(css = "#payment-option-2-container>span")
    WebElement payByBankWireInput;

    @FindBy(css = "#conditions-to-approve span:nth-child(1)")
    WebElement termsAndConditionsCheckbox;

    @FindBy(css = ".ps-shown-by-js>[type='submit']")
    WebElement placeOrderButton;

    @FindBy(css = "#checkout-delivery-step .continue")
    WebElement deliveryInfoContinueButton;

    @FindBy(css = "#content-hook_order_confirmation .card-title")
    WebElement confirmationMessage;

    @FindBy(css = ".total-value>td:nth-child(2)")
    WebElement totalPrice;

    @Step("Click on first product")
    public TestPage clickOnFirstProduct() {
        performClick(firstProduct);
        return new TestPage(driver);
    }

    @Step("add product to cart")
    public TestPage addProductToCart(Product product) {
        product.setPrice(price.getText());
        performClick(addToCartButton);
        return new TestPage(driver);
    }

    @Step("Click on confirmation proceed to checkout")
    public TestPage clickOnConfirmationProceedToCheckout() {
        performClick(confirmationProceedToCheckout);
        return new TestPage(driver);
    }

    @Step("Click on proceed to checkout")
    public TestPage clickOnProceedToCheckout() {
        performClick(proceedToCheckoutButton);
        return new TestPage(driver);
    }

    @Step("Register new user")
    public TestPage registerNewUser(User user) {
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        checkCustomerPrivacyCheckbox();
        checkPolicyCheckbox();
        clickOnSaveButton();
        return this;
    }

    @Step("Register new user")
    public TestPage registerNewUserFail(User user) {

        return this;
    }

    @Step("Fill in address form")
    public TestPage fillAddressForm(User user) {
        Select country = new Select(countrySelect);

        typeTextTo(addressInput, user.getAddress());
        typeTextTo(cityInput, user.getCity());
        typeTextTo(postcodeInput, user.getZipCode());
        country.selectByVisibleText(user.getCountry());
        return this;

    }

    @Step("Click on continue button personal info section")
    public TestPage clickOnContinueButtonPersonalInfoSection() {
        performClick(personalInfoContinueButton);
        return this;
    }

    @Step("Click on continue button delivery info section")
    public TestPage clickOnContinueButtonDeliveryInfoSection() {
        performClick(deliveryInfoContinueButton);
        return this;
    }

    @Step("Select pay by bank wire")
    public TestPage selectPayByBankWire() {
        performClick(payByBankWireInput);
        return this;
    }

    @Step("Click on terms and conditions checkbox")
    public TestPage clickOnTermsAndConditionsCheckbox() {
        performClick(termsAndConditionsCheckbox);
        return this;
    }

    @Step("Place order")
    public TestPage placeOrder() {
        performClick(placeOrderButton);
        return this;
    }
    @Step("Get confirmation message")
    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    @Step("Get total price")
    public String getTotalPrice() {
        return totalPrice.getText();
    }


    @Step("Set first name")
    public TestPage setFirstName(String name) {
        typeTextTo(firstNameInput, name);
        return this;
    }

    @Step("Set lat name")
    public TestPage setLastName(String lastName) {
        typeTextTo(lastNameInput, lastName);
        return this;
    }

    @Step("Set email")
    public TestPage setEmail(String email) {
        typeTextTo(emailInput, email);
        return this;
    }

    @Step("Set password")
    public TestPage setPassword(String password) {
        typeTextTo(passwordInput, password);
        return this;
    }

    @Step("Check customer privacy checkbox")
    public TestPage checkCustomerPrivacyCheckbox() {
        performClick(customerPrivacyCheckbox);
        return this;
    }

    @Step("Check policy checkbox")
    public TestPage checkPolicyCheckbox() {
        performClick(policyCheckbox);
        return this;
    }

    @Step("Click on save button")
    public TestPage clickOnSaveButton() {
        performClick(saveButton);
        return new TestPage(driver);
    }
}
