package Utils;

import org.openqa.selenium.By;

public class Utils {
    public static final By womenTab = By.xpath("//span[normalize-space()='Women']");
    public static final By category = By.xpath("//a[contains(text(),'Tops')]");
    public static final By product = By.xpath("//a[@class='product photo product-item-photo']//img[@alt='Breathe-Easy Tank']");
    public static final By productSize = By.xpath("//div[contains(@option-label,'M')]");
    public static final By productColor = By.xpath("//div[contains(@aria-label,'White')]");
    public static final By cartIcon = By.xpath("//div[@data-block='minicart']");
    public static final By addCartButton = By.xpath("//span[normalize-space()='Add to Cart']");
    public static final By updateCart = By.xpath("//button[@title='Update Cart']");
    public static final By linkSignIn = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
    public static final By removeIcon = By.xpath("//a[@title='Remove item']");
    public static final By acceptButton = By.xpath("//button[@class='action-primary action-accept']");
    public static final By quantityBoxInCart = By.xpath("//input[@id='cart-item-218-qty']");
    public static final By linkViewCart = By.xpath("//span[normalize-space()='View and Edit Cart']");

}
