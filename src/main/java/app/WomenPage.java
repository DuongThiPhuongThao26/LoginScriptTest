package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenPage extends HomePage {

    WebDriver driver;
    HomePage homePage;

    public static final By category = By.xpath("//a[contains(text(),'Tops')]");
    public static final By product = By.xpath("//a[@class='product photo product-item-photo']//img[@alt='Breathe-Easy Tank']");

    public WomenPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        homePage = new HomePage(this.driver);
    }

    public void ClickOnCategory() {
        driver.findElement(category).click();
    }

    public void clickOnProduct() {
        driver.findElement(product).click();
    }
}
