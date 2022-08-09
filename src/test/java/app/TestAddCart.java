package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Utils.Locator;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

@DisplayName("JUNIT5")
public class TestAddCart {
  @Test
  public void testAddToCart() throws InterruptedException {
    StepDefinition stepDef = new StepDefinition();
    stepDef.initDriver();
    HomePage homePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@");

    WomenPage womenPage = homePage.clickOnWomenTab();
    womenPage.ClickOnCategory(Locator.product);
    ProductPage productPage = womenPage.clickOnProduct(Locator.product);

    productPage.addToCart(Locator.productSize, Locator.productColor);
    productPage.clickOnAddToCartButton(Locator.addCartButton);
    assertEquals("You added Breathe-Easy Tank to your shopping cart.", productPage.getMessage(Locator.messageAddSuccess));

    Thread.sleep(3000);
    stepDef.quitBrowser();
  }
}
