package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    WebDriver driver;
    BasePage basePage;
    By cartIcon = By.xpath("//div[@data-block='minicart']");
    By linkViewCart = By.xpath("//span[normalize-space()='View and Edit Cart']");

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public void addToCart(By productSize, By productColor) {
        waiForDisplay(productSize);
        driver.findElement(productSize).click();
        waiForDisplay(productColor);
        driver.findElement(productColor).click();
    }

    public void clickOnAddToCartButton(By addToCartButton) {
        waiForDisplay(addToCartButton);
        driver.findElement(addToCartButton).click();
    }

    public void clickOnUpdateCartButton(By updateCart) {
        waiForDisplay(updateCart);
        driver.findElement(updateCart).click();
    }

    public String getMessage(By announcementMessage) {
        waiForDisplay(announcementMessage);
        return driver.findElement(announcementMessage).getText();
    }

    public void clickOnCart() {
        waiForDisplay(cartIcon);
        driver.findElement(cartIcon).click();
    }

    public ViewCartPage viewAndEditCart() {
        waiForDisplay(linkViewCart);
        driver.findElement(linkViewCart).click();
        return new ViewCartPage(driver);
    }
}
