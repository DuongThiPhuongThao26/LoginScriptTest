package app;

import Utils.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestEditProduct {
    private static WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void editItemInViewCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Utils.email, Utils.pwd);

        HomePage homePage = new HomePage(driver);
        homePage.clickOnWomenTab();

        WomenPage womenPage = new WomenPage(driver);
        womenPage.ClickOnCategory();
        womenPage.clickOnProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.clickOnAddToCartButton();

        Thread.sleep(3000);

        productPage.clickOnCart();
        productPage.viewAndEditCart();

        ViewCartPage viewCartPage = new ViewCartPage(driver);
        viewCartPage.editItem();
        productPage.addToCart();
        viewCartPage.editProductQuantity(Utils.quantity);
        productPage.clickOnUpdateCartButton();

        assertEquals(Utils.expectedEditSuccess, viewCartPage.getTextOfMessageUpdateProduct(Utils.updateCartMessage));
    }

    @Test
    public void editItemInCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Utils.email, Utils.pwd);

        HomePage homePage = new HomePage(driver);
        homePage.clickOnWomenTab();

        WomenPage womenPage = new WomenPage(driver);
        womenPage.ClickOnCategory();
        womenPage.clickOnProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.clickOnAddToCartButton();

        Thread.sleep(3000);

        productPage.clickOnCart();
        productPage.editQuantity(Utils.quantity);
        productPage.clickUpdateButton();

        Thread.sleep(2000);

        assertEquals(Utils.expectedQuantity, productPage.getCountItem());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
