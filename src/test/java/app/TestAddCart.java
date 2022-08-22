package app;

import Utils.Utils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestAddCart {
    private static ChromeDriver driver;
    HomePage homePage;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testAddToCart() {
        StepDefinition stepDef = new StepDefinition();
        stepDef.login(Utils.email, Utils.pwd, Utils.emailInput, Utils.passwordInput);

        WomenPage womenPage = homePage.clickOnWomenTab();
        womenPage.ClickOnCategory();
        ProductPage productPage = womenPage.clickOnProduct();
        productPage.addToCart();
        productPage.clickOnAddToCartButton();

        assertEquals(Utils.expectedAddSuccess, productPage.getMessageAddSuccess(Utils.messageAddSuccess));
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }
}
