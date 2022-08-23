package app;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage {
    WebDriver driver;
    BasePage basePage;

    public static final By linkSignIn = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
    public static final By emailInput = By.xpath("//input[@id='email']");
    public static final By passwordInput = By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public void ClickOnSignIn() {
        driver.findElement(linkSignIn).click();
    }

    public void enterEmail(String email, By emailInput) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String pwd, By passwordInput) {
        driver.findElement(passwordInput).sendKeys(pwd);
    }

    public void clickButton() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public void login(String email, String pwd) {
        ClickOnSignIn();
        enterEmail(email, emailInput);
        enterPassword(pwd, passwordInput);
        clickButton();
    }
}
