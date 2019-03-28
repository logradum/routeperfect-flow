package com.routePerfect.tests;

import com.routePerfect.model.TripPlanner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RouteBuildingTest extends TestBase {

  @Test
  public void buildRouteTest() throws InterruptedException {

    /***** test could work only with dates starting on the current or next month from today *****/
    /***** test could work only with route duration from 12 up to 28 days *****/
    /***** app works only when start in date begin after 4 (on the 5-th) day after today *****/

    TripPlanner TripPlanner;
    fw.getTripPlannerHelper().fillTripPlanner(TripPlanner = new TripPlanner()
            .setStartFromDestinationShort("lon")
            .setStartFromDestinationLong("London")
            .setEndInDestinationShort("oxf")
            .setEndInDestinationLong("Oxford")
            .setStartDayAfter(5)
            .setEndDayAfter(12));

    fw.getTripPlannerHelper().changePaxTwoAdultsTwoKidsTripPlanner();
    fw.getTripPlannerHelper().clickSubmitButtonHomePageTripPlanner();
    fw.getTripPlannerHelper().getNumberOfDestinations();

    /***** START DESTINATION TEST *****/
    Assert.assertTrue(fw.getTripPlannerHelper()
                    .isElementPresent(By
                            .xpath("//div[@id='0']//span[@class='ItineraryElement-location--cityName']" +
                                    "[contains(text(),'" + TripPlanner.getStartFromDestinationLong() + "')]"))
            , "Start destination is present");

    /***** END DESTINATION TEST: two assertions because end destination could be also the start destination *****/
    if (TripPlanner.getStartFromDestinationShort()==TripPlanner.getEndInDestinationShort()) {
      int lastDestXpathNum = fw.getTripPlannerHelper().getNumberOfDestinations()-1;

      Assert.assertTrue(fw.getTripPlannerHelper().isElementPresent(By
                              .xpath("//div[@id='"+lastDestXpathNum+"']//span[@class='ItineraryElement-location--cityName']" +
                                      "[contains(text(),'" + TripPlanner.getEndInDestinationLong() + "')]"))
              , "end destination is present");
    } else {Assert.assertTrue(fw.getTripPlannerHelper().isElementPresent(By
                      .xpath("//span[@class='ItineraryElement-location--cityName'][contains(text(),'" + TripPlanner
                              .getEndInDestinationLong() + "')]")));
    }

    /***** Date Starting in assertion. Searches exactly in Start date field*****/
    Assert.assertTrue(fw.getTripPlannerHelper()
            .isElementPresent(By.xpath("(//*[@class='datepicker-click-exclude'])[1]//*[@ng-reflect-model='"
                    + fw.getTripPlannerHelper().getStartDateString()+"']"))
            , "start date: "+fw.getTripPlannerHelper().getStartDateString()+" is present");

    /***** Date Ending in assertion. Searches exactly in End date field*****/
    Assert.assertTrue(fw.getTripPlannerHelper()
            .isElementPresent(By.xpath("(//*[@class='datepicker-click-exclude'])[2]//*[@ng-reflect-model='"
                    + fw.getTripPlannerHelper().getEndDateString()+"']"))
            , "end date: "+fw.getTripPlannerHelper().getEndDateString()+" is present");
  }
}