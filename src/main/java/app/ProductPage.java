package app;
import Utils.Utils;
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

    public void addToCart() {
        driver.findElement(Utils.productSize).click();
        driver.findElement(Utils.productColor).click();
    }

    public void clickOnCart() {
        driver.findElement(Utils.cartIcon).click();
    }

    public void clickOnAddToCartButton() {
        driver.findElement(Utils.addCartButton).click();
    }

    public void clickOnUpdateCartButton() {
        driver.findElement(Utils.updateCart).click();
    }

    public void removeProduct() {
        driver.findElement(Utils.removeIcon).click();
        driver.findElement(Utils.acceptButton).click();
    }

    public void changeQuantityItem(String quantity){
        driver.findElement(Utils.quantityBoxInCart).click();
        driver.findElement(Utils.quantityBoxInCart).clear();
        basePage.sendKeys(Utils.quantityBoxInCart, quantity);
    }

    public String getCountItem(By element){
        return basePage.getText(element);
    }
    public String getMessageAddSuccess(By messageAddSuccess) {
        return basePage.getText(messageAddSuccess);
    }

    public String getMessageRemoveSuccess(By messageRemoveSuccess) {
        return basePage.getText(messageRemoveSuccess);
    }

    public ViewCartPage viewAndEditCart() {
        driver.findElement(Utils.linkViewCart).click();
        return new ViewCartPage(driver);
    }

    public static void main(String[] args) {
        System.out.println("I rule!");
        System.out.println("The world");
    }
}
