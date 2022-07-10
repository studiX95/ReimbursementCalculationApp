package com.michalstodolny.reimbursementcalculationapp;

import com.michalstodolny.reimbursementcalculationapp.admin.CurrentRate;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/user-get")
public class UserGetFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurrentRate rate = new CurrentRate();
        request.setAttribute("rate",rate);
        request.getRequestDispatcher("/user.jsp").forward(request,response);
    }
}
