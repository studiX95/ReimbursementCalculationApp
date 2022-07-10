package com.michalstodolny.reimbursementcalculationapp;

import com.michalstodolny.reimbursementcalculationapp.reimbursement.Reimbursement;
import com.michalstodolny.reimbursementcalculationapp.reimbursement.ReimbursementResult;
import com.michalstodolny.reimbursementcalculationapp.user.AdditionalCost;
import com.michalstodolny.reimbursementcalculationapp.user.BusinessTrip;
import com.michalstodolny.reimbursementcalculationapp.user.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@WebServlet("/user-set")
public class UserSetFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //personal data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String jobPosition = request.getParameter("jobPosition");
        User user = new User(firstName, lastName, jobPosition);
        //business trip data
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        double mileage = Double.parseDouble(request.getParameter("mileage"));
        String startDate = request.getParameter("startDate");
        LocalDate start = LocalDate.parse(startDate);
        String endDate = request.getParameter("endDate");
        LocalDate end = LocalDate.parse(endDate);
        BusinessTrip trip = new BusinessTrip(from, to, mileage, start, end);

        String[] receipts = request.getParameterValues("receipt");
        String[] costs = request.getParameterValues("cost");

        Map<String, String> additionalCosts;
        List<AdditionalCost> listOfAdditionalCosts;
        if ((receipts.length > 0) && (receipts.length == costs.length)) {
            additionalCosts = new HashMap<>();
            if (receipts.length == costs.length) {
                for (int i = 0; i < receipts.length; i++) {
                    additionalCosts.put(receipts[i], costs[i]);
                }
            }

            listOfAdditionalCosts = new ArrayList<>();
            Iterator<Map.Entry<String, String>> itr = additionalCosts.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<String, String> entry = itr.next();
                listOfAdditionalCosts.add(new AdditionalCost(entry.getKey(), Double.parseDouble(entry.getValue())));
            }
            user.setTrip(trip);
            user.setListOfAdditionalCosts(listOfAdditionalCosts);
        }

        Reimbursement reimbursment = new Reimbursement(user);
        ReimbursementResult result = reimbursment.calculate();
        request.setAttribute("result", result);
        request.getRequestDispatcher("/reimbursement.jsp").forward(request, response);
    }

}
