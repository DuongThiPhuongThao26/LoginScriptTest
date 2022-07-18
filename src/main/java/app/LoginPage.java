package app;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;

    private final By emailInput = By.cssSelector("[type='text'][placeholder='Email ID']");

    private final By passwordInput = By.cssSelector("[type='password'][placeholder='Password']");

    private final By LoginBtn = By.xpath("//button[@type='submit']");
    private final By errorBox = By.xpath("//div[@class='login-page__form__error-box']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));

        WebElement emailId = driver.findElement(emailInput);
        emailId.sendKeys(email);
    }

    public void enterPassword(String pwd) {

        WebElement password = driver.findElement(passwordInput);
        password.sendKeys(pwd);
    }

    public void clickButton() {
        driver.findElement(LoginBtn).click();
    }

    public boolean canNotLogin() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorBox));
            return driver.findElement(errorBox).isDisplayed();
        } catch (TimeoutException timeoutException) {
            return false;
        }
    }
}

