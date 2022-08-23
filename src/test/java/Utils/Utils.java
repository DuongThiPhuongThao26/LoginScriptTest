package Utils;

import org.openqa.selenium.By;

public class Utils {
    public static final By messageAddSuccess = By.xpath("//div[contains(@data-bind,'html: $parent.prepareMessageForHtml(message.text)')]");
    public static final By cartEmptyMessage = By.xpath("//p[normalize-space()='You have no items in your shopping cart.']");
    public static final By updateCartMessage = By.xpath("//div[@data-ui-id='message-success']");
    public static final By messageRemoveSuccess = By.xpath("//strong[@class='subtitle empty']");
    public static final String email = "duongphuong261020@gmail.com";
    public static final String pwd = "Lungtung1234@";
    public static final String expectedEditSuccess = "Breathe-Easy Tank was updated in your shopping cart.";
    public static final String expectedRemoveSuccess = "You have no items in your shopping cart.";
    public static final String quantity = "3";
    public static final String expectedAddSuccess = "You added Breathe-Easy Tank to your shopping cart.";
    public static final String expectedQuantity = "3";
    public static final String urlExpected = "https://magento.softwaretestingboard.com/";
}
