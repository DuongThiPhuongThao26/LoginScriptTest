package app;

import Utils.Utils;
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

    public void ClickOnSignIn() {
        driver.findElement(Utils.linkSignIn).click();
    }

    public void enterEmail(String email, By emailInput) {
        basePage.sendKeys(emailInput, email);
    }

    public void enterPassword(String pwd, By passwordInput) {
        basePage.sendKeys(passwordInput, pwd);
    }

    public void clickButton() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }

}
