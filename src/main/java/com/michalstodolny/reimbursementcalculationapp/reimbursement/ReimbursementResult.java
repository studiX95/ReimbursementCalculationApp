package com.michalstodolny.reimbursementcalculationapp.reimbursement;

import com.michalstodolny.reimbursementcalculationapp.user.AdditionalCost;
import com.michalstodolny.reimbursementcalculationapp.user.User;

import java.util.List;

public class ReimbursementResult {
    private double totalAllowance;
    private double totalMileage;
    private double totalAdditionalCosts;
    private List<AdditionalCost> listOfAdditionalCosts;

    private User user;
    private double totalReslut;

    private long numberOfDays;

    public ReimbursementResult(double totalAllowance, double totalMileage, double totalAdditionalCosts, List<AdditionalCost> listOfAdditionalCosts, User user, long numberOfDays) {
        this.totalAllowance = totalAllowance;
        this.totalMileage = totalMileage;
        this.totalAdditionalCosts = totalAdditionalCosts;
        this.listOfAdditionalCosts = listOfAdditionalCosts;
        this.user = user;
        this.totalReslut = totalAllowance + totalMileage + totalAdditionalCosts;
        this.numberOfDays = numberOfDays;
    }

    public double getTotalAllowance() {
        return totalAllowance;
    }

    public double getTotalMileage() {
        return totalMileage;
    }

    public double getTotalAdditionalCosts() {
        return totalAdditionalCosts;
    }

    public List<AdditionalCost> getListOfAdditionalCosts() {
        return listOfAdditionalCosts;
    }

    public double getTotalReslut() {
        return totalReslut;
    }

    public long getNumberOfDays() {
        return numberOfDays;
    }

    public User getUser() {
        return user;
    }
}
