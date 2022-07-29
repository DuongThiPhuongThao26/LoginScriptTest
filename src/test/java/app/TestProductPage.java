package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DisplayName("JUNIT5")
public class TestProductPage {
  WebDriver driver;
  By product = By.xpath("//a[@class='product photo product-item-photo']//img[@alt='Breathe-Easy Tank']");
  By productSize = By.xpath("//div[contains(@option-label,'M')]");
  By productColor = By.xpath("//div[contains(@aria-label,'White')]");
  By addToCartButton = By.xpath("//span[normalize-space()='Add to Cart']");
  By messageAddSuccess = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
  By category = By.xpath("//a[contains(text(),'Tops')]");

  @Test
  public void testAddToCart() {
    StepDefinition stepDef = new StepDefinition();
    stepDef.initDriver();
    HomePage homePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@");

    WomenPage womenPage = homePage.clickOnWomenTab();
    womenPage.ClickOnCategory(category);
    ProductPage productPage = womenPage.clickOnProduct(product);
    productPage.addToCart(productSize, productColor, addToCartButton);
    assertEquals("You added Breathe-Easy Tank to your shopping cart.", productPage.getMessage(messageAddSuccess));
  }

}
