package app;

import config.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinition {

    private final ConfigProperties configProperties = new ConfigProperties();
    WebDriver driver;

    public void initDriver() {

        WebDriverManager.chromedriver().browserVersion(configProperties.getConfig("ChromeVersion")).setup();
        this.driver = new ChromeDriver();
        this.driver.get(configProperties.getConfig("WebUrl"));
        this.driver.manage().window().maximize();
    }

    public void quitBrowser() {
        driver.quit();
    }

    public HomePage login(String email, String pwd, By linkSignIn, By emailInput, By passwordInput) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.ClickOnSignIn(linkSignIn);
        loginPage.enterEmail(email, emailInput);
        loginPage.enterPassword(pwd, passwordInput);
        loginPage.clickButton();
        return new HomePage(driver);
    }
}
