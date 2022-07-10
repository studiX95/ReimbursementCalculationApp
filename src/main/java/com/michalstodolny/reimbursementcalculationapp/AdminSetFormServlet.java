package com.michalstodolny.reimbursementcalculationapp;

import com.michalstodolny.reimbursementcalculationapp.admin.CurrentRate;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin-set")
public class AdminSetFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String allowance = request.getParameter("allowance");
        String mileage = request.getParameter("mileage");
        String[] costs = request.getParameterValues("costs");

        CurrentRate rate = new CurrentRate(allowance,mileage,costs);
        request.setAttribute("rate",rate);
        request.getRequestDispatcher("/admin.jsp").forward(request,response);
    }

}


