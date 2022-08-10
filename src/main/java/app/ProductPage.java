package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    WebDriver driver;
    BasePage basePage;

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

    public void clickOnCart(By cartIcon) {
        waiForDisplay(cartIcon);
        driver.findElement(cartIcon).click();
    }

    public void clickOnAddToCartButton(By addToCartButton) {
        waiForDisplay(addToCartButton);
        driver.findElement(addToCartButton).click();
    }

    public void clickOnUpdateCartButton(By updateCart) {
        waiForDisplay(updateCart);
        driver.findElement(updateCart).click();
    }

    public void removeProduct(By removeIcon, By alertMessage) {
        waiForDisplay(removeIcon);
        driver.findElement(removeIcon).click();
        waiForDisplay(alertMessage);
        driver.switchTo().alert().accept();
    }

    public String getMessageAddSuccess(By messageAddSuccess) {
        waiForDisplay(messageAddSuccess);
        return driver.findElement(messageAddSuccess).getText();
    }

    public String getMessageRemoveSuccess(By messageRemoveSuccess) {
        waiForDisplay(messageRemoveSuccess);
        return driver.findElement(messageRemoveSuccess).getText();
    }

    public ViewCartPage viewAndEditCart(By linkViewCart) {
        waiForDisplay(linkViewCart);
        driver.findElement(linkViewCart).click();
        return new ViewCartPage(driver);
    }
}
