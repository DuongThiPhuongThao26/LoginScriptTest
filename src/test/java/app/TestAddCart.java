package app;

import Utils.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestAddCart extends BaseTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = getDriver();
    }

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
