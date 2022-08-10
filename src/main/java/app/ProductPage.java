package app;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    WebDriver driver;
    BasePage basePage;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(this.driver);
    }

    public void addToCart(By productSize, By productColor) {
        basePage.Click(productSize);
        basePage.Click(productColor);
    }

    public void clickOnCart(By cartIcon) {
        basePage.Click(cartIcon);
    }

    public void clickOnAddToCartButton(By addToCartButton) {
        basePage.Click(addToCartButton);
    }

    public void clickOnUpdateCartButton(By updateCart) {
        basePage.Click(updateCart);
    }

    public void removeProduct(By removeIcon, By acceptButton) {
        basePage.Click(removeIcon);
        basePage.Click(acceptButton);
    }

    public String getMessageAddSuccess(By messageAddSuccess) {
        return basePage.getText(messageAddSuccess);
    }

    public String getMessageRemoveSuccess(By messageRemoveSuccess) {
        return basePage.getText(messageRemoveSuccess);
    }

    public ViewCartPage viewAndEditCart(By linkViewCart) {
        basePage.Click(linkViewCart);
        return new ViewCartPage(driver);
    }
}
