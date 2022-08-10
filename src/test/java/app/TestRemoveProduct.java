package app;

import Utils.Utils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestRemoveProduct {
    @Test
    public void removeItemInViewCartPage() throws InterruptedException {
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
        viewCartPage.removeItem(Utils.trashIcon);
        viewCartPage.getTextOfMessageAddProduct(Utils.cartEmptyMessage);

        assertEquals("You have no items in your shopping cart.", viewCartPage.getTextOfMessageAddProduct(Utils.cartEmptyMessage));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }

    @Test
    public void removeItemInCart() throws InterruptedException {
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

        productPage.removeProduct(Utils.removeIcon, Utils.acceptButton);

        assertEquals("You have no items in your shopping cart.", productPage.getMessageRemoveSuccess(Utils.messageRemoveSuccess));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }
}
