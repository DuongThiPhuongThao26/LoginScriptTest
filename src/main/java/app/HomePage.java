package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    BasePage basePage;

    public static final By womenTab = By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]");
    public static final By tops = By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]");
    public static final By tanks = By.xpath("//span[normalize-space()='Bras & Tanks']");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickOnWomenTab() {
        WebElement women = driver.findElement(womenTab);
        WebElement top = driver.findElement(tops);
        WebElement tank = driver.findElement(tanks);

        Actions actions = new Actions(this.driver);
        actions.moveToElement(women).moveToElement(top).moveToElement(tank).click().build().perform();

    }
}
