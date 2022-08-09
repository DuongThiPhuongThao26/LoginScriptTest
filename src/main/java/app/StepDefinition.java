package app;

import config.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
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

  public void quitBrowser(){
    driver.quit();
  }

  public HomePage login(String email, String pwd) {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.ClickOnSignIn();
    loginPage.enterEmail(email);
    loginPage.enterPassword(pwd);
    loginPage.clickButton();
    return new HomePage(driver);
  }
}
