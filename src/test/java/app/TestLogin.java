package app;

import Utils.Utils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestLogin {
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
    public void testSignIn() {
        StepDefinition stepDef = new StepDefinition();
        stepDef.login(Utils.email, Utils.pwd, Utils.emailInput, Utils.passwordInput);
        homePage = new HomePage(driver);
        assertEquals(Utils.urlExpected, homePage.getUrl());
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

}
