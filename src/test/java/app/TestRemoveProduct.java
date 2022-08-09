package app;

import Utils.Locator;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestRemoveProduct {
    @Test
    public void removeItem() throws InterruptedException {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage homePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@");

        WomenPage womenPage = homePage.clickOnWomenTab();
        womenPage.ClickOnCategory(Locator.category);
        ProductPage productPage = womenPage.clickOnProduct(Locator.product);
        productPage.addToCart(Locator.productSize, Locator.productColor);
        productPage.clickOnAddToCartButton(Locator.addToCartButton);

        Thread.sleep(3000);
        productPage.clickOnCart();

        ViewCartPage viewCartPage = productPage.viewAndEditCart();
        viewCartPage.removeItem();
        viewCartPage.getTextOfMessageAddProduct(Locator.cartEmptyMessage);

        assertEquals("You have no items in your shopping cart.", viewCartPage.getTextOfMessageAddProduct(Locator.cartEmptyMessage));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }

}
