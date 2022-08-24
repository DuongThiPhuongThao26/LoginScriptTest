package app;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    static String driverPath = "src/test/resources/drivers/chromedriver.exe";

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        return driver;
    }

    @Before
    public void initializeTestBaseSetup() {
        initChromeDriver();
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
