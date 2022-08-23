package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    WebDriver driver;
    BasePage basePage;

    public static final By productSize = By.xpath("//div[contains(@option-label,'M')]");
    public static final By productColor = By.xpath("//div[contains(@aria-label,'White')]");
    public static final By cartIcon = By.xpath("//div[@data-block='minicart']");
    public static final By addCartButton = By.xpath("//span[normalize-space()='Add to Cart']");
    public static final By updateCart = By.xpath("//button[@title='Update Cart']");
    public static final By updateButton = By.xpath("//div[@class='details-qty qty']//button[@id='update-cart-item-1237']");
    public static final By removeIcon = By.xpath("//a[@title='Remove item']");
    public static final By acceptButton = By.xpath("//button[@class='action-primary action-accept']");
    public static final By quantityBoxInCart = By.xpath("//div[@class='details-qty qty']//input[@id='cart-item-1237-qty']");
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

    public void changeQuantityItem(String quantity) {
        driver.findElement(quantityBoxInCart).click();
        driver.findElement(quantityBoxInCart).clear();
        basePage.sendKeys(quantityBoxInCart, quantity);
    }

    public String getCountItem() {
        return basePage.getText(countItem);
    }

    public String getMessageAddSuccess(By messageAddSuccess) {
        return basePage.getText(messageAddSuccess);
    }

    public String getMessageRemoveSuccess(By messageRemoveSuccess) {
        return basePage.getText(messageRemoveSuccess);
    }

    public void viewAndEditCart() {
        driver.findElement(linkViewCart).click();
    }

}
