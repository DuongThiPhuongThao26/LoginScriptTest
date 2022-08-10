package app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMinutes(10));
    }

    public void waiForDisplay(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void Click(By element) {
        waiForDisplay(element);
        driver.findElement(element).click();
    }

    public void sendKeys(By element, String text) {
        waiForDisplay(element);
        driver.findElement(element).sendKeys(text);
    }
    public String getText(By element){
        waiForDisplay(element);
        return driver.findElement(element).getText();
    }

    public void clear(By element){
        waiForDisplay(element);
        driver.findElement(element).clear();
    }

}
