package app;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCartPage extends ProductPage {
    WebDriver driver;
    ProductPage productPage;

    public ViewCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        productPage = new ProductPage(this.driver);
    }

    public void removeItem() {
        driver.findElement(Utils.trashIcon).click();
    }

    public void editItem() {
        driver.findElement(Utils.editIcon).click();
    }

    public void editProductQuantity() {
        driver.findElement(Utils.quantityBox).click();
        driver.findElement(Utils.quantityBox).clear();
        basePage.sendKeys(Utils.quantityBox, Utils.quantity);
    }

    public String getTextOfMessageAddProduct(By cartEmpty) {
        return basePage.getText(cartEmpty);
    }

    public String getTextOfMessageUpdateProduct(By updateCartMessage) {
        return basePage.getText(updateCartMessage);
    }

}
