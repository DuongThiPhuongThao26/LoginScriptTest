package app;

import config.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinition{

    WebDriver driver;

    private final ConfigProperties configProperties = new ConfigProperties();

    public void initDriver() throws InterruptedException {
        WebDriverManager.chromedriver()
                .browserVersion(configProperties.getConfig("ChromeVersion")).setup();
        this.driver = new ChromeDriver();
        this.driver.get(configProperties.getConfig("WebUrl"));
        this.driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    public String login(String email, String pwd) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(pwd);
        return loginPage.clickButton();
    }
}
