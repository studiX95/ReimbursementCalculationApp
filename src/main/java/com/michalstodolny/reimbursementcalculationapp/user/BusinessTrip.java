package com.michalstodolny.reimbursementcalculationapp.user;

import java.time.LocalDate;
import java.util.Date;

public class BusinessTrip {
    private String from;
    private String destination;
    private double mileage;
    private LocalDate startDate;
    private LocalDate endDate;


    public BusinessTrip() {}
    public BusinessTrip(String from, String destination, double mileage, LocalDate startDate, LocalDate endDate) {
        this.from = from;
        this.destination = destination;
        this.mileage = mileage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
