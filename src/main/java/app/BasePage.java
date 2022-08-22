package app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private final WebDriver driver;
    private  WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    }

    public void waiForDisplay(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void waiForClickable(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void sendKeys(By element, String text) {
        waiForDisplay(element);
        driver.findElement(element).sendKeys(text);
    }
    public String getText(By element){
        waiForDisplay(element);
        return driver.findElement(element).getText();
    }

}
