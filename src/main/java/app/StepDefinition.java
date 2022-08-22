package app;

import config.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinition {
    WebDriver driver;

    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://magento.softwaretestingboard.com/");
        this.driver.manage().window().maximize();
    }

    public void quitBrowser() {
        driver.quit();
    }

    public void login(String email, String pwd, By emailInput, By passwordInput) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.ClickOnSignIn();
        loginPage.enterEmail(email, emailInput);
        loginPage.enterPassword(pwd, passwordInput);
        loginPage.clickButton();
    }
}
