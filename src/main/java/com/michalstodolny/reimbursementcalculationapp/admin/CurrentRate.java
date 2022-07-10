package com.michalstodolny.reimbursementcalculationapp.admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CurrentRate {

    private String allowance;
    private String mileage;
    private List<String> costs;

    public CurrentRate() throws IOException {
        this.allowance = getDaillyAllowanceRate();
        this.mileage = getMileageRate();
        this.costs = getAdditionalCosts();
    }
    public CurrentRate(String allowance, String mileage, String[] costs) throws IOException {

        if(allowance == null)
            this.allowance = getDaillyAllowanceRate();
        else
            saveDailyAllowanceRate(allowance);

        if (mileage == null)
            this.mileage = getMileageRate();
        else
            saveDailyMileageRate(mileage);

        if (costs == null)
            this.costs = getAdditionalCosts();
        else
            saveAdditionalCosts(List.of(costs));

    }

    private void saveDailyAllowanceRate(String allowance) throws IOException {
        PrintWriter writer = new PrintWriter("allowance.txt");
        writer.write(allowance);
        writer.flush();
        writer.close();
    }

    public String getDaillyAllowanceRate() throws IOException {
        String allowance = null;
        Scanner in = new Scanner(Paths.get("allowance.txt"));
        while(in.hasNext()) {
            allowance = in.next();
        }
        in.close();
        return allowance;
    }

    private void saveDailyMileageRate(String mileage) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("mileage.txt");
        writer.write(mileage);
        writer.flush();
        writer.close();
    }

    public String getMileageRate() throws IOException {
        String mileage = null;
        Scanner in = new Scanner(Paths.get("mileage.txt"));
        while(in.hasNext()) {
            mileage = in.next();
        }
        in.close();
        return mileage;
    }



    private void saveAdditionalCosts(List<String> costs) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("costs.txt");
        for (String cost: costs) {
            writer.println(cost);
        }
        writer.flush();
        writer.close();
    }

    public List<String> getAdditionalCosts() throws IOException {
        Scanner in = new Scanner(Paths.get("costs.txt"));
        List<String> costs = new ArrayList<>();
        while(in.hasNext()) {
            costs.add(in.nextLine());
        }

        return costs;
    }

    @Override
    public String toString() {
        return "CurrentRate{" +
                "allowance='" + allowance + '\'' +
                ", mileage='" + mileage + '\'' +
                ", costs=" + costs +
                '}';
    }
}
