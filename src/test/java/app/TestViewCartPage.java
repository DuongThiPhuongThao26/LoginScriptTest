package app;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestViewCartPage {
    By product = By.xpath("//a[@class='product photo product-item-photo']//img[@alt='Breathe-Easy Tank']");
    By productSize = By.xpath("//div[contains(@option-label,'M')]");
    By productColor = By.xpath("//div[contains(@aria-label,'White')]");
    By addToCartButton = By.xpath("//span[normalize-space()='Add to Cart']");
    By category = By.xpath("//a[contains(text(),'Tops')]");
    By cartEmptyMessage = By.xpath("//p[normalize-space()='You have no items in your shopping cart.']");
    By editIcon = By.xpath("//a[@title='Edit item parameters']");
    By updateCart = By.xpath("//button[@title='Update Cart']");
    By updateCartMessage = By.xpath("//div[@data-ui-id='message-success']");

    By quantityBox = By.xpath("//input[@id='qty']");

    @Test
    public void removeItem() throws InterruptedException {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage homePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@");

        WomenPage womenPage = homePage.clickOnWomenTab();
        womenPage.ClickOnCategory(category);
        ProductPage productPage = womenPage.clickOnProduct(product);
        productPage.addToCart(productSize, productColor);
        productPage.clickOnAddToCartButton(addToCartButton);

        Thread.sleep(3000);
        productPage.clickOnCart();

        ViewCartPage viewCartPage = productPage.viewAndEditCart();
        viewCartPage.removeItem();
        viewCartPage.getTextOfMessageAddProduct(cartEmptyMessage);

        assertEquals("You have no items in your shopping cart.", viewCartPage.getTextOfMessageAddProduct(cartEmptyMessage));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }

    @Test
    public void editItem() throws InterruptedException {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage homePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@");

        WomenPage womenPage = homePage.clickOnWomenTab();
        womenPage.ClickOnCategory(category);
        ProductPage productPage = womenPage.clickOnProduct(product);
        productPage.addToCart(productSize, productColor);
        productPage.clickOnAddToCartButton(addToCartButton);
        Thread.sleep(3000);
        productPage.clickOnCart();

        ViewCartPage viewCartPage = productPage.viewAndEditCart();
        viewCartPage.editItem(editIcon);

        productPage.addToCart(productSize, productColor);

        viewCartPage.editProductQuantity(quantityBox, "3");
        productPage.clickOnUpdateCartButton(updateCart);

        assertEquals("Breathe-Easy Tank was updated in your shopping cart.", viewCartPage.getTextOfMessageUpdateProduct(updateCartMessage));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }
}
