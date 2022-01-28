package allureTest;

import io.qameta.allure.*;
import models.Product;
import models.User;
import models.UserFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.TestPage;
import testBase.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Epic("Different suite examples")
@Feature("Allure Report Tests Demo")
@Execution(ExecutionMode.CONCURRENT)
public class Suite2Test extends TestBase {

    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("Test Description : Place order")
    @Story("Correct place order")
    public void successfulAllureReportsTest() {
        final String ORDER_IS_CONFIRMED = "YOUR ORDER IS CONFIRMED";
        User user = new UserFactory().getRandomUser();
        TestPage testPage = new TestPage(driver);
        Product product = new Product();

        testPage.clickOnFirstProduct()
                .addProductToCart(product)
                .clickOnConfirmationProceedToCheckout()
                .clickOnProceedToCheckout()
                .registerNewUser(user)
                .fillAddressForm(user)
                .clickOnContinueButtonPersonalInfoSection()
                .clickOnContinueButtonDeliveryInfoSection()
                .selectPayByBankWire()
                .clickOnTermsAndConditionsCheckbox()
                .placeOrder();

        assertTrue(testPage.getConfirmationMessage().contains(ORDER_IS_CONFIRMED));
        assertEquals(testPage.getTotalPrice(), product.getPrice());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("Test Description : Place order")
    @Story("Incorrect place order")
    public void failedAllureReportsTest() {
        final String ORDER_IS_CONFIRMED = "YOUR ORDER IS CONFIRMED";
        User user = new UserFactory().getRandomUser();
        TestPage testPage = new TestPage(driver);
        Product product = new Product();

        testPage.clickOnFirstProduct()
                .addProductToCart(product)
                .clickOnConfirmationProceedToCheckout()
                .clickOnProceedToCheckout()
                .registerNewUser(user)
                .fillAddressForm(user)
                .clickOnContinueButtonPersonalInfoSection()
                .clickOnContinueButtonDeliveryInfoSection()
                .selectPayByBankWire()
                .clickOnTermsAndConditionsCheckbox()
                .placeOrder();

        assertFalse(testPage.getConfirmationMessage().contains(ORDER_IS_CONFIRMED));
        assertEquals(testPage.getTotalPrice(), product.getPrice());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("Test Description : Place order")
    @Story("Incorrect place order")
    public void brokenAllureReportsTest() {
        final String ORDER_IS_CONFIRMED = "YOUR ORDER IS CONFIRMED";
        User user = new UserFactory().getRandomUser();
        TestPage testPage = new TestPage(driver);
        Product product = new Product();

        testPage.clickOnFirstProduct()
                .addProductToCart(product)
                .clickOnConfirmationProceedToCheckout()
                .clickOnProceedToCheckout()
                .registerNewUserFail(user)
                .fillAddressForm(user)
                .clickOnContinueButtonPersonalInfoSection()
                .clickOnContinueButtonDeliveryInfoSection()
                .selectPayByBankWire()
                .clickOnTermsAndConditionsCheckbox()
                .placeOrder();

        assertTrue(testPage.getConfirmationMessage().contains(ORDER_IS_CONFIRMED));
        assertEquals(testPage.getTotalPrice(), product.getPrice());
    }

    @Severity(SeverityLevel.NORMAL)
    @Disabled
    @Test
    @Description("Test Description : Place order")
    @Story("Incorrect place order")
    public void skippedAllureReportsTest() {

    }
}
