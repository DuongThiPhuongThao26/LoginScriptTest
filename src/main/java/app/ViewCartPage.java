package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCartPage extends ProductPage {
    WebDriver driver;
    ProductPage productPage;

    By trashIcon = By.xpath("//a[@class='action action-delete']");

    public ViewCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        productPage = new ProductPage(this.driver);
    }

    public void removeItem() {
        waiForDisplay(trashIcon);
        driver.findElement(trashIcon).click();
    }

    public String getTextOfMessageAddProduct(By cartEmpty) {
        waiForDisplay(cartEmpty);
        return driver.findElement(cartEmpty).getText();
    }

    public String getTextOfMessageUpdateProduct(By updateCartMessage) {
        waiForDisplay(updateCartMessage);
        return driver.findElement(updateCartMessage).getText();
    }

    public void editItem(By editIcon) {
        waiForDisplay(editIcon);
        driver.findElement(editIcon).click();
    }

    public void editProductQuantity(By quantityBox, String quantity, By updateShoppingCart) {
        waiForDisplay(quantityBox);
        driver.findElement(quantityBox).click();
        driver.findElement(quantityBox).clear();
        driver.findElement(quantityBox).sendKeys(quantity);
    }

}
