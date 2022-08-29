package app;
import Utils.Utils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestAddCart extends BaseTest {
    @Test
    public void testAddToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Utils.email, Utils.pwd);

        HomePage homePage = new HomePage(driver);
        homePage.clickOnWomenTab();

        WomenPage womenPage = new WomenPage(driver);
        womenPage.ClickOnCategory();
        womenPage.clickOnProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.productSelection();
        productPage.clickOnAddToCartButton();

        assertEquals(Utils.expectedAddSuccess, productPage.getMessageAddSuccess());
    }
}
