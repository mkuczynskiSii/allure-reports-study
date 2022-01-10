package fluentTest;

import models.Product;
import models.User;
import models.UserFactory;
import org.junit.jupiter.api.RepeatedTest;
import pages.FluentTestPage;
import testBase.FluentTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FluentTest extends FluentTestBase {

    @RepeatedTest(30)
    public void fluentTest() {
        final String ORDER_IS_CONFIRMED = "YOUR ORDER IS CONFIRMED";
        User user = new UserFactory().getRandomUser();
        FluentTestPage testPage = new FluentTestPage(driver);
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
}
