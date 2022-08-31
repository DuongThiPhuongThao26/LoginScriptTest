package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    BasePage basePage;

    public static final By womenTab = By.xpath("//span[normalize-space()='Women']");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickOnWomenTab() {
        driver.findElement(womenTab).click();
    }
}
