package com.routePerfect.tests;
import com.routePerfect.model.Login;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
  @Test
  public void loginTest() {
    fw.getLoginHelper().fillLoginForm(new Login().setEmail("test1@test.test").setPassword("test"));

    /***** assert: is user logged in *****/
    Assert.assertTrue(fw.getLoginHelper().isElementPresent(By
            .xpath("//span[@class='site-menu__user__menu__name'][contains(.,'Hi test')]")),"user is logged in");
  }
}
