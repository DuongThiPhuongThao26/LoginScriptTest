package app;

import Utils.Utils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestEditProduct {

    @Test
    public void editItemInViewCart() throws InterruptedException {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage homePage = stepDef.login(Utils.email, Utils.pwd, Utils.emailInput, Utils.passwordInput);

        WomenPage womenPage = homePage.clickOnWomenTab();
        womenPage.ClickOnCategory();
        ProductPage productPage = womenPage.clickOnProduct();
        productPage.addToCart();
        productPage.clickOnAddToCartButton();
        Thread.sleep(3000);
        productPage.clickOnCart();

        ViewCartPage viewCartPage = productPage.viewAndEditCart();
        viewCartPage.editItem(Utils.editIcon);

        productPage.addToCart();

        viewCartPage.editProductQuantity(Utils.quantityBox, Utils.quantity);
        productPage.clickOnUpdateCartButton();

        assertEquals(Utils.expectedEditSuccess, viewCartPage.getTextOfMessageUpdateProduct(Utils.updateCartMessage));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }

    @Test
    public void editItemInCart() throws InterruptedException {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage homePage = stepDef.login(Utils.email, Utils.pwd, Utils.emailInput, Utils.passwordInput);

        WomenPage womenPage = homePage.clickOnWomenTab();
        womenPage.ClickOnCategory();
        ProductPage productPage = womenPage.clickOnProduct();
        productPage.addToCart();
        productPage.clickOnAddToCartButton();

        Thread.sleep(3000);

        productPage.clickOnCart();
        productPage.changeQuantityItem(Utils.quantity);
        productPage.clickOnUpdateCartButton();

        assertEquals(Utils.expectedQuantity, productPage.getCountItem(Utils.countItem));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }
}
