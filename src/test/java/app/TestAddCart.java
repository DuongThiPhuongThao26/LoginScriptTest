package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Utils.Utils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("JUNIT5")
public class TestAddCart {
  @Test
  public void testAddToCart() throws InterruptedException {
    StepDefinition stepDef = new StepDefinition();
    stepDef.initDriver();
    HomePage homePage = stepDef.login(Utils.email, Utils.pwd, Utils.emailInput, Utils.passwordInput);

    WomenPage womenPage = homePage.clickOnWomenTab();
    womenPage.ClickOnCategory();
    ProductPage productPage = womenPage.clickOnProduct();
    productPage.addToCart();
    productPage.clickOnAddToCartButton();


    assertEquals(Utils.expectedAddSuccess, productPage.getMessageAddSuccess(Utils.messageAddSuccess));

    Thread.sleep(3000);
    stepDef.quitBrowser();
  }
}
