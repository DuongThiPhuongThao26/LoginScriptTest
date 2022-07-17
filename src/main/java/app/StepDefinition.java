package app;

import config.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TimeoutException;
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

    public String login(String email, String pwd) throws TimeoutException {

        try {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(email);
            loginPage.enterPassword(pwd);
            return loginPage.clickButton();

        } catch (TimeoutException timeoutException) {
            return driver.getCurrentUrl();
        }

    }

}
