package com.michalstodolny.reimbursementcalculationapp.user;

import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String jobPosition;

    private BusinessTrip trip;

    private List<AdditionalCost> listOfAdditionalCosts;

    public User() {}
    public User(String firstName, String lastName, String jobPosition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobPosition = jobPosition;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public BusinessTrip getTrip() {
        return trip;
    }

    public void setTrip(BusinessTrip trip) {
        this.trip = trip;
    }

    public List<AdditionalCost> getListOfAdditionalCosts() {
        return listOfAdditionalCosts;
    }

    public void setListOfAdditionalCosts(List<AdditionalCost> listOfAdditionalCosts) {
        this.listOfAdditionalCosts = listOfAdditionalCosts;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", trip=" + trip +
                ", listOfAdditionalCosts=" + listOfAdditionalCosts +
                '}';
    }
}
