package app;

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

    public void removeItem(By trashIcon) {
        basePage.Click(trashIcon);
    }

    public void editItem(By editIcon) {
        basePage.Click(editIcon);
    }

    public void editProductQuantity(By quantityBox, String quantity) {
        basePage.Click(quantityBox);
        driver.findElement(quantityBox).clear();
        basePage.sendKeys(quantityBox, quantity);
    }

    public String getTextOfMessageAddProduct(By cartEmpty) {
        return basePage.getText(cartEmpty);
    }

    public String getTextOfMessageUpdateProduct(By updateCartMessage) {
        return basePage.getText(updateCartMessage);
    }

}
