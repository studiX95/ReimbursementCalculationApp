package com.michalstodolny.reimbursementcalculationapp.reimbursement;

import com.michalstodolny.reimbursementcalculationapp.admin.CurrentRate;
import com.michalstodolny.reimbursementcalculationapp.user.AdditionalCost;
import com.michalstodolny.reimbursementcalculationapp.user.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Reimbursement {
    private final double dailyAllowanceRate;
    private final double dailyMileageRate;

    private User user;
    private double totalAllowance;
    private double totalMileage;
    private double totalAdditionalCosts;
    private List<AdditionalCost> listOfAdditionalCosts;

    {
        try {
            dailyAllowanceRate = Double.parseDouble(new CurrentRate().getDaillyAllowanceRate());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            dailyMileageRate = Double.parseDouble(new CurrentRate().getMileageRate());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Reimbursement(User user) {
        this.user = user;
    }

    public ReimbursementResult calculate() {

        LocalDate start = LocalDate.parse(user.getTrip().getStartDate().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate end = LocalDate.parse(user.getTrip().getEndDate().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
        long numberOfdays = ChronoUnit.DAYS.between(user.getTrip().getStartDate(), user.getTrip().getEndDate()) + 1;

        this.totalAllowance = dailyAllowanceRate * numberOfdays;
        this.totalMileage = dailyMileageRate * this.user.getTrip().getMileage();

        double costs = 0;
        List<AdditionalCost> list = user.getListOfAdditionalCosts();
        for (AdditionalCost cost: list) {
            costs += cost.getCost();
        }

        this.totalAdditionalCosts = costs;

        return new ReimbursementResult(totalAllowance,totalMileage,totalAdditionalCosts,user.getListOfAdditionalCosts(),this.user,numberOfdays);

    }

}
