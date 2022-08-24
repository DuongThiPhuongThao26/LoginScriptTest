package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    WebDriver driver;
    BasePage basePage;

    public static final By linkSignIn = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
    public static final By emailInput = By.xpath("//input[@id='email']");
    public static final By passwordInput = By.xpath("//div[@class='control']//input[@title='Password']");
    public static final By signInButton = By.xpath("//div[@class='primary']//button[@class='action login primary']");


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public void clickOnSignIn() {
        driver.findElement(linkSignIn).click();
    }

    public void enterEmail(By emailInput, String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(By passwordInput, String pwd) {
        driver.findElement(passwordInput).sendKeys(pwd);
    }

    public void clickButton() {
        driver.findElement(signInButton).click();
    }

    public void login(String email, String pwd) {
        clickOnSignIn();
        enterEmail(emailInput, email);
        enterPassword(passwordInput, pwd);
        clickButton();
    }
}
