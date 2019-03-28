package com.routePerfect.manager;

import com.routePerfect.model.TourPlan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TourPlanHelper extends HelperBase {
  public TourPlanHelper(WebDriver wd) {
    super(wd);
  }


  public void addDestinationTourPlanner(TourPlan TourPlanShortLongNameDest) {
    closeOnBoarding();

    type(By.cssSelector("[placeholder='Add a destination or a region']")
            , TourPlanShortLongNameDest.getDestinationShort());
    selectLongNameFromDropDownTourPlan(TourPlanShortLongNameDest.getDestinationLong());
  }

  public void selectLongNameFromDropDownTourPlan(String destinationConfirmFull){
    WebElement longName = waitUntilPresent(By.xpath("//*[contains(text(),'"+ destinationConfirmFull +", ')]"));
    longName.click();
  }

}
