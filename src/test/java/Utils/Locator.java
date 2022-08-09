package Utils;

import org.openqa.selenium.By;

public class Locator {
    public static final By product = By.xpath("//a[@class='product photo product-item-photo']//img[@alt='Breathe-Easy Tank']");
    public static final By productSize = By.xpath("//div[contains(@option-label,'M')]");
    public static final By productColor = By.xpath("//div[contains(@aria-label,'White')]");
    public static final By addToCartButton = By.xpath("//span[normalize-space()='Add to Cart']");
    public static final By messageAddSuccess = By.xpath("//div[contains(@data-bind,'html: $parent.prepareMessageForHtml(message.text)')]");
    public static final By category = By.xpath("//a[contains(text(),'Tops')]");
    public static final By productSize = By.xpath("//div[contains(@option-label,'M')]");
    public static final By productColor = By.xpath("//div[contains(@aria-label,'White')]");
    public static final By addToCartButton = By.xpath("//span[normalize-space()='Add to Cart']");
    public static final By category = By.xpath("//a[contains(text(),'Tops')]");
    public static final By cartEmptyMessage = By.xpath("//p[normalize-space()='You have no items in your shopping cart.']");
    public static final By editIcon = By.xpath("//a[@title='Edit item parameters']");
    public static final By updateCart = By.xpath("//button[@title='Update Cart']");
    public static final By updateCartMessage = By.xpath("//div[@data-ui-id='message-success']");
    public static final By quantityBox = By.xpath("//input[@id='qty']");

}
