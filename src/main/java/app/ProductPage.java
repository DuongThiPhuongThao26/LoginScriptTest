package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
  WebDriver driver;
  BasePage basePage;
  By cartIcon = By.xpath("//a[@class='action showcart active']");
  By linkViewCart = By.xpath("//span[normalize-space()='View and Edit Cart']");

  public ProductPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    basePage = new BasePage(this.driver);
  }

  public void addToCart(By productSize, By productColor, By addToCartButton) {
    waiForDisplay(productSize);
    driver.findElement(productSize).click();
    waiForDisplay(productColor);
    driver.findElement(productColor).click();
    waiForDisplay(addToCartButton);
    driver.findElement(addToCartButton).click();
  }

  public String getMessage(By announcementMessage) {
    waiForDisplay(announcementMessage);
    return driver.findElement(announcementMessage).getText();
  }

  public ViewCartPage viewAndEditCart() {
    driver.findElement(cartIcon).click();
    waiForDisplay(linkViewCart);
    driver.findElement(linkViewCart).click();
    return new ViewCartPage();
  }
}
