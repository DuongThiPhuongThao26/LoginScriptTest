package app;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage {
    WebDriver driver;
    BasePage basePage;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public void ClickOnSignIn(By linkSignIn) {
        waiForDisplay(linkSignIn);
        driver.findElement(linkSignIn).click();
    }

    public void enterEmail(String email, By emailInput) {
        waiForDisplay(emailInput);
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String pwd, By passwordInput) {
        waiForDisplay(passwordInput);
        driver.findElement(passwordInput).sendKeys(pwd);
    }

    public void clickButton() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }

}
