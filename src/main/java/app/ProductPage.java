package app;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    WebDriver driver;
    BasePage basePage;

    public static final By productSize = By.xpath("//div[contains(@option-label,'M')]");
    public static final By productColor = By.xpath("//div[contains(@aria-label,'White')]");
    public static final By cartIcon = By.xpath("//div[@data-block='minicart']");
    public static final By addCartButton = By.xpath("//span[normalize-space()='Add to Cart']");
    public static final By updateCart = By.xpath("//button[@title='Update Cart']");
    public static final By updateButton = By.xpath("//div[@class='details-qty qty']//button[@title='Update']");
    public static final By removeIcon = By.xpath("//a[@title='Remove item']");
    public static final By acceptButton = By.xpath("//button[@class='action-primary action-accept']");
    public static final By quantityBoxInCart = By.xpath("//div[@class='details-qty qty']//input[@class='item-qty cart-item-qty']");
    public static final By countItem = By.xpath("//div[@class = 'items-total']//span[@class = 'count']");
    public static final By linkViewCart = By.xpath("//span[normalize-space()='View and Edit Cart']");

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public void addToCart() {
        waiForDisplay(productSize);
        driver.findElement(productSize).click();
        driver.findElement(productColor).click();
    }

    public void clickOnCart() {
        waiForClickable(cartIcon);
        ;
        driver.findElement(cartIcon).click();
    }

    public void clickOnAddToCartButton() {
        driver.findElement(addCartButton).click();
    }

    public void clickOnUpdateCartButton() {
        waiForDisplay(updateCart);
        driver.findElement(updateCart).click();
    }

    public void clickUpdateButton() {
        waiForClickable(updateButton);
        driver.findElement(updateButton).click();
    }

    public void removeProduct() {
        driver.findElement(removeIcon).click();
        waiForClickable(acceptButton);
        driver.findElement(acceptButton).click();
    }

    public void editQuantity(String quantity){
        waiForClickable(quantityBoxInCart);
        driver.findElement(quantityBoxInCart).click();
        driver.findElement(quantityBoxInCart).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(quantityBoxInCart).sendKeys(quantity);
    }

    public String getCountItem() {
        return driver.findElement(countItem).getText();
    }

    public String getMessageAddSuccess(By messageAddSuccess) {
        waiForDisplay(messageAddSuccess);
        return driver.findElement(messageAddSuccess).getText();
    }

    public String getMessageRemoveSuccess(By messageRemoveSuccess) {
        return driver.findElement(messageRemoveSuccess).getText();
    }

    public void viewAndEditCart() {
        driver.findElement(linkViewCart).click();
    }

}
