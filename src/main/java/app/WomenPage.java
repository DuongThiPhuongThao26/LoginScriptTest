package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenPage extends HomePage {

    WebDriver driver;
    HomePage homePage;
    By productSize = By.xpath("//div[@id='option-label-size-143-item-168']");
    By productColor = By.xpath("//div[@id='option-label-color-93-item-59']");
    By addToCartButton = By.xpath("//span[normalize-space()='Add to Cart']");
    By alert = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    By categoryTop = By.xpath("//a[contains(text(),'Tops')]");

    public WomenPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        homePage = new HomePage(this.driver);
    }

    public void addToCart() {
        waiForDisplay(categoryTop);
        driver.findElement(categoryTop).click();
        waiForDisplay(productSize);
        driver.findElement(productSize).click();
        waiForDisplay(productColor);
        driver.findElement(productColor).click();
        waiForDisplay(addToCartButton);
        driver.findElement(addToCartButton).click();
    }

    public String getTextOfAlert() {
        waiForDisplay(alert);
        return driver.findElement(alert).getText();
    }

}

