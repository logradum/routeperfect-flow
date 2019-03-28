package com.routePerfect.manager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Calendar;

public class HelperBase {
 public WebDriver wd;
  Calendar calStart = Calendar.getInstance();
  Calendar calEnd = Calendar.getInstance();


  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public Boolean isElementPresent(By selector){
    return wd.findElements(selector).size() > 0;
  }

  public void waitAndClick(By selector) {
    waitUntilPresent(selector).click();
  }

  public void clickHiddenElement(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor)wd;
    js.executeScript("arguments[0].click();", element);
  }

  public WebElement waitUntilPresent(By selector) {
   return (new WebDriverWait(wd,10))
            .until(ExpectedConditions.elementToBeClickable(selector));
  }

  public void click(By selector){
    if (isElementPresent(selector)) {
      wd.findElement(selector).click();
    }
  }
  public void type(By locator, String text) {
    if(text!=null) {
      click(locator);
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }

  public void closeOnBoarding() {
    while (isElementPresent(By.cssSelector("[class='Icon Icon--close']"))){
      click(By.cssSelector("[class='Icon Icon--close']"));}
  }



}
