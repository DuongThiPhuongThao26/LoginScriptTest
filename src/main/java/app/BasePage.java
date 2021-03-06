package app;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  private final WebDriver driver;
  private final WebDriverWait wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(40));
  }

  public void waiForDisplay(By element) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    driver.findElement(element);
  }
}
