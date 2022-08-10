package app;

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

    public void ClickOnCategory(By category) {
        basePage.Click(category);
    }

    public ProductPage clickOnProduct(By product) {
        basePage.Click(product);
        return new ProductPage(driver);
    }
}
