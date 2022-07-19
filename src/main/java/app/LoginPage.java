package app;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailInput = By.cssSelector("[type='text'][placeholder='Email ID']");
    private final By passwordInput = By.cssSelector("[type='password'][placeholder='Password']");
    private final By loginBtn = By.xpath("//button[@type='submit']");
    private final By errorBox = By.xpath("//div[@class='login-page__form__error-box']");
    WebDriver driver;
    BasePage basePage;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public void enterEmail(String email) {
        waiForDisplay(emailInput);
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String pwd) {
        waiForDisplay(passwordInput);
        driver.findElement(passwordInput).sendKeys(pwd);
    }

    public void clickButton() {
        waiForDisplay(loginBtn);
        driver.findElement(loginBtn).click();
    }

    public boolean canNotLogin() {
        try {
            waiForDisplay(errorBox);
            return driver.findElement(errorBox).isDisplayed();
        } catch (TimeoutException timeoutException) {
            return false;
        }
    }
}

