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

    public String getTextOfMessage(By cartEmpty){
        waiForDisplay(cartEmpty);
        return driver.findElement(cartEmpty).getText();
    }

    public void editItem(By editIcon){
        waiForDisplay(editIcon);
        driver.findElement(editIcon).click();
    }
}
