package com.routePerfect.tests;
import com.routePerfect.manager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.lang.reflect.Method;

public class TestBase {



  public static class MyListener extends AbstractWebDriverEventListener{
    public MyListener() {
      super();
    }



    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println("search: " + by);

      logger.info("Find happened on " + element
              + " Using method " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by + " found");
      logger.info("Find happened on " + element
              + " Using method " + by);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable );

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
      super.beforeGetScreenshotAs(target);
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
      super.afterGetScreenshotAs(target, screenshot);
    }
  }

  static Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static AppManager fw = new AppManager(System.getProperty("browser",
          BrowserType.CHROME));

  @BeforeSuite
  public void setUp(){
    fw.start();
  }

  @AfterSuite(alwaysRun = true)
  public void teatDown() throws InterruptedException {
    fw.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m){
    logger.info("Start test "+ m.getName());
  }

  @AfterMethod
  public void logTestStop(Method m){
    logger.info("Stop test"+ m.getName());
  }

}
