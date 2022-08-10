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
        HomePage homePage = stepDef.login(Utils.email, Utils.pwd, Utils.linkSignIn, Utils.emailInput, Utils.passwordInput);

        WomenPage womenPage = homePage.clickOnWomenTab(Utils.womenTab);
        womenPage.ClickOnCategory(Utils.category);
        ProductPage productPage = womenPage.clickOnProduct(Utils.product);
        productPage.addToCart(Utils.productSize, Utils.productColor);
        productPage.clickOnAddToCartButton(Utils.addCartButton);
        Thread.sleep(3000);
        productPage.clickOnCart(Utils.cartIcon);

        ViewCartPage viewCartPage = productPage.viewAndEditCart(Utils.linkViewCart);
        viewCartPage.editItem(Utils.editIcon);

        productPage.addToCart(Utils.productSize, Utils.productColor);

        viewCartPage.editProductQuantity(Utils.quantityBox, Utils.quantity);
        productPage.clickOnUpdateCartButton(Utils.updateCart);

        assertEquals(Utils.expectedEditSuccess, viewCartPage.getTextOfMessageUpdateProduct(Utils.updateCartMessage));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }

    @Test
    public void editItemInCart() throws InterruptedException {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage homePage = stepDef.login(Utils.email, Utils.pwd, Utils.linkSignIn, Utils.emailInput, Utils.passwordInput);

        WomenPage womenPage = homePage.clickOnWomenTab(Utils.womenTab);
        womenPage.ClickOnCategory(Utils.category);
        ProductPage productPage = womenPage.clickOnProduct(Utils.product);
        productPage.addToCart(Utils.productSize, Utils.productColor);
        productPage.clickOnAddToCartButton(Utils.addCartButton);

        Thread.sleep(3000);

        productPage.clickOnCart(Utils.cartIcon);
        productPage.changeQuantityItem(Utils.quantityBoxInCart, Utils.quantity);
        productPage.clickOnUpdateCartButton(Utils.updateButton);

        assertEquals("3", productPage.getCountItem(Utils.countItem));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }
}
