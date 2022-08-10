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
    HomePage homePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@", Locator.linkSignIn, Locator.emailInput, Locator.passwordInput);

    WomenPage womenPage = homePage.clickOnWomenTab(Locator.womenTab);
    womenPage.ClickOnCategory(Locator.category);
    ProductPage productPage = womenPage.clickOnProduct(Locator.product);
    productPage.addToCart(Locator.productSize, Locator.productColor);
    productPage.clickOnAddToCartButton(Locator.addCartButton);

    String messageExpected = "You added Breathe-Easy Tank to your shopping cart.";
    assertEquals(messageExpected, productPage.getMessageAddSuccess(Locator.messageAddSuccess));

    Thread.sleep(3000);
    stepDef.quitBrowser();
  }
}
