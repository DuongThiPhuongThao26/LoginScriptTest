package app;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    WebDriver driver;
    BasePage basePage;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public String getTittleHomePage() {
        return driver.getTitle();
    }

}