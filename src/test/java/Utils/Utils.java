package Utils;

import org.openqa.selenium.By;

public class Utils {
    public static final String email = "duongphuong261020@gmail.com";
    public static final String pwd = "Lungtung1234@";
    public static final By emailInput = By.xpath("//input[@id='email']");
    public static final By passwordInput = By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']");
    public static final By linkSignIn = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
    public static final By womenTab = By.xpath("//span[normalize-space()='Women']");
    public static final By product = By.xpath("//a[@class='product photo product-item-photo']//img[@alt='Breathe-Easy Tank']");
    public static final By messageAddSuccess = By.xpath("//div[contains(@data-bind,'html: $parent.prepareMessageForHtml(message.text)')]");
    public static final By category = By.xpath("//a[contains(text(),'Tops')]");
    public static final By productSize = By.xpath("//div[contains(@option-label,'M')]");
    public static final By productColor = By.xpath("//div[contains(@aria-label,'White')]");
    public static final By addCartButton = By.xpath("//span[normalize-space()='Add to Cart']");
    public static final By cartEmptyMessage = By.xpath("//p[normalize-space()='You have no items in your shopping cart.']");
    public static final By editIcon = By.xpath("//a[@title='Edit item parameters']");
    public static final By updateCart = By.xpath("//button[@title='Update Cart']");
    public static final By updateCartMessage = By.xpath("//div[@data-ui-id='message-success']");
    public static final By quantityBox = By.xpath("//input[@id='qty']");
    public static final By trashIcon = By.xpath("//a[@class='action action-delete']");
    public static final By removeIcon = By.xpath("//a[@title='Remove item']");
    public static final By alertMessage = By.xpath("//aside[contains(@class,'_show')]//div[contains(@class,'modal-inner-wrap')]");
    public static final By messageRemoveSuccess = By.xpath("//strong[@class='subtitle empty']");
    public static final By cartIcon = By.xpath("//div[@data-block='minicart']");
    public static final By linkViewCart = By.xpath("//span[normalize-space()='View and Edit Cart']");
}
