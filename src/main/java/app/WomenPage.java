package app;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenPage extends HomePage {

    WebDriver driver;
    HomePage homePage;

    public WomenPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        homePage = new HomePage(this.driver);
    }

    public void ClickOnCategory() {
        driver.findElement(Utils.category).click();
    }

    public ProductPage clickOnProduct() {
        driver.findElement(Utils.product).click();
        return new ProductPage(driver);
    }
}
