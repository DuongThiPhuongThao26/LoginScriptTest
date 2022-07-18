package app;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private final By dashboard = By.xpath("//div[contains(text(),'Dashboard')]");

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrlDashboardPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard)).isDisplayed();
        return driver.getCurrentUrl();
    }
}