package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenPage extends HomePage {

  WebDriver driver;
  HomePage homePage;

  public WomenPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    homePage = new HomePage(this.driver);
  }

  public void ClickOnCategory(By category) {
    waiForDisplay(category);
    driver.findElement(category).click();
  }

  public ProductPage clickOnProduct(By product) {
    waiForDisplay(product);
    driver.findElement(product).click();
    return new ProductPage(driver);
  }
}
