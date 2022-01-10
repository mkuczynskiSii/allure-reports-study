package implicitTest;

import models.Product;
import models.User;
import models.UserFactory;
import org.junit.jupiter.api.RepeatedTest;
import pages.ImplicitTestPage;
import testBase.ImplicitTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ImplicitTest extends ImplicitTestBase {

    @RepeatedTest(30)
    public void implicitTest() {
        final String ORDER_IS_CONFIRMED = "YOUR ORDER IS CONFIRMED";
        User user = new UserFactory().getRandomUser();
        ImplicitTestPage testPage = new ImplicitTestPage(driver);
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
