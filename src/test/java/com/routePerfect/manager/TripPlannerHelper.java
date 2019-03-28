package com.routePerfect.manager;

import com.routePerfect.model.TripPlanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TripPlannerHelper extends HelperBase {


  public TripPlannerHelper(WebDriver wd) {
    super(wd);
  }


  public void changePaxTwoAdultsTwoKidsTripPlanner() {
    openPaxDropDownTripPlanner();
    openPaxOtherOptionsTripPlanner();
    openSelectPaxChildrenDropDownTripPlanner();
    selectTwoChildrenFromDropDownPaxTripPlanner();

    /***** while Done button is hidden issue#1741 use javascript for clicking done *****/
    //waitUntilPresent(By.xpath("//button[@class='Button Button--main Button--primary btn-strong btn-strong--small']")).click();
    clickHiddenElement(wd.findElement(By.xpath("//button[@class='Button Button--main Button--primary btn-strong btn-strong--small']")));
  }

  public void selectTwoChildrenFromDropDownPaxTripPlanner() {
    /***** xpath dynamic for both homepage and trip-planner, means, always 2 kids *****/
    waitAndClick(By.xpath("(//md-option[contains(@id,'md-option')])[3]"));
  }

  public void openSelectPaxChildrenDropDownTripPlanner() {
    click(By.xpath("(//div[@class='mat-select-trigger'])[3]"));
  }

  public void openPaxOtherOptionsTripPlanner() {
    waitAndClick(By.xpath("//span[contains(text(),'Other options...')]"));
  }

  public void openPaxDropDownTripPlanner() {
    click(By.xpath("(//div[@class='input-field last'])"));
  }

  public void clickSubmitButtonHomePageTripPlanner(){
    click(By.cssSelector("#hp_showtrip"));
  }

  public void selectStartDateTripPlanner(Integer startDayFromNow) throws InterruptedException {
    Integer startDateFromNow = getStartInNumOfDateTripPlanner(startDayFromNow);

    /*** isCurrentMOnth uses the same calStart calendar instance to compare so we should get instance "now" again ***/
    calStart = Calendar.getInstance();

    click(By.cssSelector("[placeholder='Not selected']"));
    if(!isCurrentMonthForStartInTripPlanner(startDayFromNow)){
      click(By.cssSelector("[class='Icon Icon--ic_arrow_right flexy']"));
    }

    Thread.sleep(500);
    WebElement startingIn = waitUntilPresent(By.xpath("(//div[contains(text(),'"+ startDateFromNow
            +"')][@class='datepicker__calendar__month__day__num__active'])[1]"));
    startingIn.click();
  }

  public void selectEndInDateTripPlanner(Integer endDayFromNow) {
    Integer endDateFromNow = getEndInNumOfDateTripPlanner(endDayFromNow);

    click(By.xpath("(//*[@placeholder='Not selected'])[2]"));
    //System.out.println("date of end travel after getStartDate is "+endDateFromNow);
    WebElement endingIn = waitUntilPresent(By.xpath("//div[contains(text(),'"+ endDateFromNow +"')]"));
    endingIn.click();
  }

  public int getEndInNumOfDateTripPlanner(int durationDaysFromStartIn) {
    calEnd.add(Calendar.DATE, durationDaysFromStartIn);
    return calEnd.get(Calendar.DAY_OF_MONTH);
  }

  public int getStartInNumOfDateTripPlanner(int dayOfMonthUntilToday) {
    calStart.add(Calendar.DATE, dayOfMonthUntilToday);
    return calStart.get(Calendar.DAY_OF_MONTH);
  }
  public String getStartDateString() {
    Calendar calStart = getStartInCalendarDate();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String date = sdf.format(calStart.getTime());
    return date;
  }
  public String getEndDateString() {
    Calendar calEnd = getEndInCalendarDate();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String date = sdf.format(calEnd.getTime());
    return date;
  }

  public Calendar getStartInCalendarDate(){
    return calStart;
  }

  public Calendar getEndInCalendarDate(){
    return calEnd;
  }



  public boolean isCurrentMonthForStartInTripPlanner(Integer dayOfMonthFromToday) {
    /***** get current month (+1 because months starting from 0) *****/
    int monthCurrent = (calStart.get(Calendar.MONTH))+1;
    //System.out.println("current month is "+monthCurrent);

    //System.out.println("days to add"+dayOfMonthFromToday);
    /***** get month of starting route day *****/
    calStart.add(Calendar.DATE, dayOfMonthFromToday);
    int monthTravelDate = (calStart.get(Calendar.MONTH))+1;
    //System.out.println("month of travel is "+monthTravelDate);

    return monthCurrent == monthTravelDate;
  }



  public void fillStartInTripPlanner(String destinationShortName, String destinationConfirmFull) {
    typeAndChooseFromDropdownTripPlanner(By.xpath("(//*[@placeholder='City/Region/Country'])[1]")
            , By.xpath("(//*[@placeholder='City/Region/Country'])[1]")
            , destinationShortName, destinationConfirmFull);
  }

  public void typeAndChooseFromDropdownTripPlanner(By selectorField, By fieldlaceHolderToConfirm, String destinationShortname, String destinationConfirmFull) {
    waitUntilPresent(By.cssSelector("#startIn"));
    wd.findElement(selectorField).click();
    wd.findElement(fieldlaceHolderToConfirm).sendKeys(destinationShortname);
    WebElement startingIn = waitUntilPresent(By.xpath("//*[contains(text(),'"+ destinationConfirmFull +", ')]"));
    startingIn.click();
  }

  public void fillEndInTripPlanner(String destinationShortName, String destinationConfirmFullWithComa) {
    typeAndChooseFromDropdownTripPlanner(By.xpath("//input-combobox[@id='endingIn']")
            , By.xpath("(//*[@placeholder='City/Region/Country'])[2]")
            , destinationShortName, destinationConfirmFullWithComa);
  }


  public void fillTripPlanner(TripPlanner route) throws InterruptedException {
    fillStartInTripPlanner(route.getStartFromDestinationShort(), route.getStartFromDestinationLong());
    fillEndInTripPlanner(route.getEndInDestinationShort(), route.getEndInDestinationLong());
    /***** route duration should be up to the end of next month, because app could click calendar month only once *****/
    selectStartDateTripPlanner(route.getStartDayAfter());
    selectEndInDateTripPlanner(route.getEndDayAfter());
  }

  public Integer getNumberOfDestinations() {
    return wd.findElements(By.cssSelector("[class='ItineraryElement-inner']")).size();
  }
}
