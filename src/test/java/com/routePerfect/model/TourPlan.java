package com.routePerfect.model;

public class TourPlan {
  private String destinationShort;
  private String destinationLong;
  private Integer positionOfDestinationDrag;
  private Integer positionOfDestinationDrop;
  private Integer nightsOfDestination;
  private Boolean planningModeAuto;
  private Boolean lockPosition;
  private Boolean removeDestination;
  private Boolean resetPlan;

  public TourPlan(String destinationShort, String destinationLong, Integer positionOfDestinationDrag,
                  Integer positionOfDestinationDrop, Integer nightsOfDestination,
                  Boolean planningModeAuto, Boolean lockPosition, Boolean removeDestination,
                  Boolean resetPlan) {

    this.destinationShort = destinationShort;
    this.destinationLong = destinationLong;
    this.positionOfDestinationDrag = positionOfDestinationDrag;
    this.positionOfDestinationDrop = positionOfDestinationDrop;
    this.nightsOfDestination = nightsOfDestination;
    this.planningModeAuto = planningModeAuto;
    this.lockPosition = lockPosition;
    this.removeDestination = removeDestination;
    this.resetPlan = resetPlan;
  }
/***** constructor only for adding destination*****/
  public TourPlan() {
    this.destinationShort = destinationShort;
    this.destinationLong = destinationLong;
  }

  public TourPlan setDestinationShort(String destinationShort) {
    this.destinationShort = destinationShort;
    return this;
  }

  public TourPlan setDestinationLong(String destinationLong) {
    this.destinationLong = destinationLong;
    return this;
  }

  public TourPlan setPositionOfDestinationDrag(Integer positionOfDestinationDrag) {
    this.positionOfDestinationDrag = positionOfDestinationDrag;
    return this;
  }

  public TourPlan setPositionOfDestinationDrop(Integer positionOfDestinationDrop) {
    this.positionOfDestinationDrop = positionOfDestinationDrop;
    return this;
  }

  public TourPlan setNightsOfDestination(Integer nightsOfDestination) {
    this.nightsOfDestination = nightsOfDestination;
    return this;
  }

  public TourPlan setPlanningModeAuto(Boolean planningModeAuto) {
    this.planningModeAuto = planningModeAuto;
    return this;
  }

  public TourPlan setLockPosition(Boolean lockPosition) {
    this.lockPosition = lockPosition;
    return this;
  }

  public TourPlan setRemoveDestination(Boolean removeDestination) {
    this.removeDestination = removeDestination;
    return this;
  }

  public TourPlan setResetPlan(Boolean resetPlan) {
    this.resetPlan = resetPlan;
    return this;
  }

  public String getDestinationShort() {
    return destinationShort;
  }

  public String getDestinationLong() {
    return destinationLong;
  }

  public Integer getPositionOfDestinationDrag() {
    return positionOfDestinationDrag;
  }

  public Integer getPositionOfDestinationDrop() {
    return positionOfDestinationDrop;
  }

  public Integer getNightsOfDestination() {
    return nightsOfDestination;
  }

  public Boolean getPlanningModeAuto() {
    return planningModeAuto;
  }

  public Boolean getLockPosition() {
    return lockPosition;
  }

  public Boolean getRemoveDestination() {
    return removeDestination;
  }

  public Boolean getResetPlan() {
    return resetPlan;
  }
}
