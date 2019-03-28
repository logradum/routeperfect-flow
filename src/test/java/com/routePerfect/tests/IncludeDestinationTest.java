package com.routePerfect.tests;
import com.routePerfect.model.TourPlan;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncludeDestinationTest extends TestBase {
  @Test
  public void addDestinationTest() {

    TourPlan tour;
    fw.getTourPlanHelper().addDestinationTourPlanner(tour = new TourPlan().setDestinationShort("birm").setDestinationLong("Birmingham"));

    /***** assert: is destination included *****/
    Assert.assertTrue(fw.getLoginHelper().isElementPresent(By
            .xpath("//span[@class='ItineraryElement-location--cityName'][contains(text(),'"+tour.getDestinationLong()+"')]"))
            , "assert on destination 'include'");


  }
}
