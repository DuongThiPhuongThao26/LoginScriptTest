package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

  WebDriver driver;
  BasePage basePage;

  By womenTab = By.xpath("//span[normalize-space()='Women']");

  public HomePage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    basePage = new BasePage(this.driver);
  }

  public String getTittleHomePage() {
    return driver.getTitle();
  }

  public WomenPage clickOnWomenTab() {
    waiForDisplay(womenTab);
    driver.findElement(womenTab).click();
    return new WomenPage(driver);
  }
}
