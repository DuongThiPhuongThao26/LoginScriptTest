package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCartPage extends ProductPage {
    ProductPage productPage;

    public static final By trashIcon = By.xpath("//a[@class='action action-delete']");
    public static final By editIcon = By.xpath("//a[@title='Edit item parameters']");
    public static final By quantityBox = By.xpath("//input[@id='qty']");
    public static final By cartEmptyMessage = By.xpath("//p[normalize-space()='You have no items in your shopping cart.']");
    public static final By updateCartMessage = By.xpath("//div[@data-ui-id='message-success']");

    public ViewCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        productPage = new ProductPage(this.driver);
    }

    public void removeItem() {
        driver.findElement(trashIcon).click();
    }

    public void editItem() {
        driver.findElement(editIcon).click();
    }

    public void editProductQuantity(String quantity) {
        driver.findElement(quantityBox).click();
        driver.findElement(quantityBox).clear();
        driver.findElement(quantityBox).sendKeys(quantity);
    }

    public String getTextOfMessageAddProduct() {
        return driver.findElement(cartEmptyMessage).getText();
    }

    public String getTextOfMessageUpdateProduct() {
        waiForDisplay(updateCartMessage);
        return driver.findElement(updateCartMessage).getText();
    }

}
