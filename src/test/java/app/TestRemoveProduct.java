package app;

import Utils.Locator;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestRemoveProduct {
    WebDriver driver;
    @Test
    public void removeItemInViewCartPage() throws InterruptedException {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage homePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@", Locator.linkSignIn, Locator.emailInput, Locator.passwordInput);

        WomenPage womenPage = homePage.clickOnWomenTab(Locator.womenTab);
        womenPage.ClickOnCategory(Locator.category);
        ProductPage productPage = womenPage.clickOnProduct(Locator.product);
        productPage.addToCart(Locator.productSize, Locator.productColor);
        productPage.clickOnAddToCartButton(Locator.addCartButton);

        Thread.sleep(3000);
        productPage.clickOnCart(Locator.cartIcon);

        ViewCartPage viewCartPage = productPage.viewAndEditCart(Locator.linkViewCart);
        viewCartPage.removeItem(Locator.trashIcon);
        viewCartPage.getTextOfMessageAddProduct(Locator.cartEmptyMessage);

        assertEquals("You have no items in your shopping cart.", viewCartPage.getTextOfMessageAddProduct(Locator.cartEmptyMessage));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }

    @Test
    public void removeItemInCart() throws InterruptedException {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage homePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@", Locator.linkSignIn, Locator.emailInput, Locator.passwordInput);

        WomenPage womenPage = homePage.clickOnWomenTab(Locator.womenTab);
        womenPage.ClickOnCategory(Locator.category);
        ProductPage productPage = womenPage.clickOnProduct(Locator.product);
        productPage.addToCart(Locator.productSize, Locator.productColor);
        productPage.clickOnAddToCartButton(Locator.addCartButton);

        Thread.sleep(3000);
        productPage.clickOnCart(Locator.cartIcon);

        productPage.removeProduct(Locator.removeIcon, Locator.alertMessage);

        assertEquals("You have no items in your shopping cart.", productPage.getMessageRemoveSuccess(Locator.messageRemoveSuccess));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }
}
