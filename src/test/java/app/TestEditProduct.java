package app;

import Utils.Locator;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestEditProduct {

    @Test
    public void editItem() throws InterruptedException {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage homePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@");

        WomenPage womenPage = homePage.clickOnWomenTab();
        womenPage.ClickOnCategory(Locator.category);
        ProductPage productPage = womenPage.clickOnProduct(Locator.product);
        productPage.addToCart(Locator.productSize, Locator.productColor);
        productPage.clickOnAddToCartButton(Locator.addCartButton);
        Thread.sleep(3000);
        productPage.clickOnCart();

        ViewCartPage viewCartPage = productPage.viewAndEditCart();
        viewCartPage.editItem(Locator.editIcon);

        productPage.addToCart(Locator.productSize, Locator.productColor);

        viewCartPage.editProductQuantity(Locator.quantityBox, "3");
        productPage.clickOnUpdateCartButton(Locator.updateCart);

        assertEquals("Breathe-Easy Tank was updated in your shopping cart.", viewCartPage.getTextOfMessageUpdateProduct(Locator.updateCartMessage));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }
}
