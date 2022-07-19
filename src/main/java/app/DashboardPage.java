package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final By dashboard = By.xpath("//div[contains(text(),'Dashboard')]");

    WebDriver driver;
    BasePage basePage;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public String getUrlDashboardPage() {
        waiForDisplay(dashboard);
        return getCurrentUrl();
    }
}