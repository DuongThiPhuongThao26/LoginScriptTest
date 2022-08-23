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
public class TestLogin {
    private static WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testSignIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Utils.email, Utils.pwd);
        HomePage homePage = new HomePage(driver);
        assertEquals(Utils.urlExpected, homePage.getUrl());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
