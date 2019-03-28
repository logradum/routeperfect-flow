package com.routePerfect.model;

public class TripPlanner {
  private String startFromDestinationShort;
  private String startFromDestinationLong;
  private String endInDestinationShort;
  private String endInDestinationLong;
  private int startDayAfter;
  private int endDayAfter;


  public TripPlanner setStartFromDestinationShort(String startFromDestinationShort) {
    this.startFromDestinationShort = startFromDestinationShort;
    return this;
  }

  public TripPlanner setStartFromDestinationLong(String startFromDestinationLong) {
    this.startFromDestinationLong = startFromDestinationLong;
    return this;
  }

  public TripPlanner setEndInDestinationShort(String endInDestinationShort) {
    this.endInDestinationShort = endInDestinationShort;
    return this;
  }

  public TripPlanner setEndInDestinationLong(String endInDestinationLong) {
    this.endInDestinationLong = endInDestinationLong;
    return this;
  }

  public TripPlanner setStartDayAfter(int startDayAfter) {
    this.startDayAfter = startDayAfter;
    return this;
  }

  public TripPlanner setEndDayAfter(int endDayAfter) {
    this.endDayAfter = endDayAfter;
    return this;
  }

  public String getStartFromDestinationShort() {
    return startFromDestinationShort;
  }

  public String getStartFromDestinationLong() {
    return startFromDestinationLong;
  }

  public String getEndInDestinationShort() {
    return endInDestinationShort;
  }

  public String getEndInDestinationLong() {
    return endInDestinationLong;
  }

  public int getEndDayAfter() {
    return endDayAfter;
  }

  public int getStartDayAfter() {
    return startDayAfter;
  }


}
