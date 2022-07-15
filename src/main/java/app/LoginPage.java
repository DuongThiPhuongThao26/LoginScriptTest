package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

    private final By emailInput = By.cssSelector("[type='text'][placeholder='Email ID']");

    private final By passwordInput = By.cssSelector("[type='password'][placeholder='Password']");

    private final By LoginBtn = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) throws InterruptedException {
        WebElement emailId = driver.findElement(emailInput);
        emailId.sendKeys(email);
        Thread.sleep(1000);
    }

    public void enterPassword(String pwd) throws InterruptedException {
        WebElement password = driver.findElement(passwordInput);
        password.sendKeys(pwd);
        Thread.sleep(1000);
    }

    public String clickButton() throws InterruptedException {
        WebElement buttonLogin = driver.findElement(LoginBtn);
        buttonLogin.click();
        Thread.sleep(3000);
        return driver.getCurrentUrl();
    }

}

