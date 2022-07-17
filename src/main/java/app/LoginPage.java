package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    private final By emailInput = By.cssSelector("[type='text'][placeholder='Email ID']");

    private final By passwordInput = By.cssSelector("[type='password'][placeholder='Password']");

    private final By LoginBtn = By.xpath("//button[@type='submit']");
    private final By dashboard = By.xpath("//div[contains(text(),'Dashboard')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));

        WebElement emailId = driver.findElement(emailInput);
        emailId.sendKeys(email);
    }

    public void enterPassword(String pwd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));

        WebElement password = driver.findElement(passwordInput);
        password.sendKeys(pwd);
    }

    public String clickButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(LoginBtn)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
        return driver.getCurrentUrl();
    }
}

