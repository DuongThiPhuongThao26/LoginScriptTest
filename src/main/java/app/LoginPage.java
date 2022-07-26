package app;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage {

    private final By emailInput = By.xpath("//input[@id='email']");
    private final By passwordInput = By.xpath(
        "//fieldset[@class='fieldset login']//input[@id='pass']");
    private final By linkSignIn = By.xpath(
        "//div[@class='panel header']//a[contains(text(),'Sign In')]");
    By errorMessage = By.xpath(
        "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");

    By signInBtn = By.xpath("///button[@class='action login primary']");

    WebDriver driver;
    BasePage basePage;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public void ClickOnSignIn() {
        waiForDisplay(linkSignIn);
        driver.findElement(linkSignIn).click();
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
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public boolean canNotLogin() {
        try {
            waiForDisplay(errorMessage);
            return driver.findElement(errorMessage).isDisplayed();
        } catch (TimeoutException timeoutException) {
            return false;
        }
    }

}


