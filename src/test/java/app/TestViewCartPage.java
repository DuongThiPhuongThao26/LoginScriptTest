package app;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestViewCartPage {
    WebDriver driver;
    By product = By.xpath("//a[@class='product photo product-item-photo']//img[@alt='Breathe-Easy Tank']");
    By productSize = By.xpath("//div[contains(@option-label,'M')]");
    By productColor = By.xpath("//div[contains(@aria-label,'White')]");
    By addToCartButton = By.xpath("//span[normalize-space()='Add to Cart']");
    By category = By.xpath("//a[contains(text(),'Tops')]");
    By cartEmptyMessage = By.xpath("//p[normalize-space()='You have no items in your shopping cart.']");

    @Test
    public void removeItemInViewCartPage() {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage homePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@");

        WomenPage womenPage = homePage.clickOnWomenTab();
        womenPage.ClickOnCategory(category);
        ProductPage productPage = womenPage.clickOnProduct(product);
        productPage.addToCart(productSize, productColor, addToCartButton);

        productPage.clickOnCart();
        ViewCartPage viewCartPage = productPage.viewAndEditCart();
        viewCartPage.removeItem();
        viewCartPage.getTextOfMessage(cartEmptyMessage);

        assertEquals("You have no items in your shopping cart.", viewCartPage.getTextOfMessage(cartEmptyMessage));
    }

    @Test
    public void removeItemInProductPage() {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage homePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@");

        WomenPage womenPage = homePage.clickOnWomenTab();
        womenPage.ClickOnCategory(category);
        ProductPage productPage = womenPage.clickOnProduct(product);
        productPage.addToCart(productSize, productColor, addToCartButton);

        productPage.clickOnCart();

        productPage.clickOnRemoveItem();

        Alert alert = driver.switchTo().alert();
        alert.accept();

//        assertEquals("You have no items in your shopping cart.", viewCartPage.getTextOfMessage(cartEmptyMessage));
    }
}
