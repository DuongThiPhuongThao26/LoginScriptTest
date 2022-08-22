package app;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    WebDriver driver;
    BasePage basePage;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public WomenPage clickOnWomenTab() {
        driver.findElement(Utils.womenTab).click();
        return new WomenPage(driver);
    }
}
