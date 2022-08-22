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
        HomePage homePage = stepDef.login(Utils.email, Utils.pwd, Utils.emailInput, Utils.passwordInput);

        WomenPage womenPage = homePage.clickOnWomenTab();
        womenPage.ClickOnCategory();
        ProductPage productPage = womenPage.clickOnProduct();
        productPage.addToCart();
        productPage.clickOnAddToCartButton();

        Thread.sleep(3000);
        productPage.clickOnCart();

        ViewCartPage viewCartPage = productPage.viewAndEditCart();
        viewCartPage.removeItem(Utils.trashIcon);
        viewCartPage.getTextOfMessageAddProduct(Utils.cartEmptyMessage);

        assertEquals(Utils.expectedRemoveSuccess, viewCartPage.getTextOfMessageAddProduct(Utils.cartEmptyMessage));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }

    @Test
    public void removeItemInCart() throws InterruptedException {
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

        productPage.removeProduct();

        assertEquals(Utils.expectedRemoveSuccess, productPage.getMessageRemoveSuccess(Utils.messageRemoveSuccess));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }
}
