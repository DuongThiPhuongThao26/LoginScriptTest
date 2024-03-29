package app;

import Utils.Utils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestEditProduct extends BaseTest {

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
    public void editItemInViewCart() throws InterruptedException {
        navigateToProductPage();
        ProductPage productPage = new ProductPage(driver);
        productPage.productSelection();
        productPage.clickOnAddToCartButton();

        Thread.sleep(3000);

        productPage.clickOnCart();
        productPage.viewAndEditCart();

        ViewCartPage viewCartPage = new ViewCartPage(driver);
        viewCartPage.editItem();
        productPage.productSelection();
        viewCartPage.editProductQuantity(Utils.quantity);
        productPage.clickOnUpdateCartButton();

        assertEquals(Utils.expectedEditSuccess, viewCartPage.getTextOfMessageUpdateProduct());
    }

    @Test
    public void editItemInCart() throws InterruptedException {
        navigateToProductPage();
        ProductPage productPage = new ProductPage(driver);
        productPage.productSelection();
        productPage.clickOnAddToCartButton();

        Thread.sleep(3000);

        productPage.clickOnCart();
        productPage.editQuantity(Utils.quantity);
        productPage.clickUpdateButton();

        Thread.sleep(2000);

        assertEquals(Utils.expectedQuantity, productPage.getCountItem());
    }
}
