package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
  WebDriver driver;
  BasePage basePage;
  By cartIcon = By.xpath("//body/div/header/div/div[@data-block='minicart']/a[1]");
  By linkViewCart = By.xpath("//span[normalize-space()='View and Edit Cart']");
  By trashIcon = By.xpath("//a[@title='Remove item']");

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

  public void clickOnCart(){
    waiForDisplay(cartIcon);
    driver.findElement(cartIcon).click();
  }

  public void clickOnRemoveItem(){
    waiForDisplay(trashIcon);
    driver.findElement(trashIcon).click();
  }

  public ViewCartPage viewAndEditCart() {
    waiForDisplay(linkViewCart);
    driver.findElement(linkViewCart).click();
    return new ViewCartPage(driver);
  }
}
