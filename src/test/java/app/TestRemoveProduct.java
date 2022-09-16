package app;

import Utils.Utils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestRemoveProduct extends BaseTest {
    public void navigateToProductPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Utils.email, Utils.pwd);

        HomePage homePage = new HomePage(driver);
        homePage.clickOnWomenTab();

        WomenPage womenPage = new WomenPage(driver);
        womenPage.ClickOnCategory();
        womenPage.clickOnProduct();
    }

    @Test
    public void removeItemInViewCartPage() throws InterruptedException {
        navigateToProductPage();
        ProductPage productPage = new ProductPage(driver);
        productPage.productSelection();
        productPage.clickOnAddToCartButton();

        Thread.sleep(3000);

        productPage.clickOnCart();
        productPage.viewAndEditCart();

        ViewCartPage viewCartPage = new ViewCartPage(driver);
        viewCartPage.removeItem();
        viewCartPage.getTextOfMessageAddProduct();

        assertEquals(Utils.expectedRemoveSuccess, viewCartPage.getTextOfMessageAddProduct());
    }

    @Test
    public void removeItemInCart() throws InterruptedException {
        navigateToProductPage();
        ProductPage productPage = new ProductPage(driver);
        productPage.productSelection();
        productPage.clickOnAddToCartButton();

        Thread.sleep(3000);

        productPage.clickOnCart();
        productPage.removeProduct();

        assertEquals(Utils.expectedRemoveSuccess, productPage.getMessageRemoveSuccess());
    }
}
