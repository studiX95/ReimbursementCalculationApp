<%@ page import="com.michalstodolny.reimbursementcalculationapp.reimbursement.Reimbursement" %>
<%@ page import="com.michalstodolny.reimbursementcalculationapp.reimbursement.ReimbursementResult" %>
<%@ page import="com.michalstodolny.reimbursementcalculationapp.admin.CurrentRate" %><%--
  Created by IntelliJ IDEA.
  User: Michał
  Date: 2022-07-09
  Time: 04:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ReimbursementResult result = (ReimbursementResult) request.getAttribute("result");
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/reimburdement.css">
</head>
<body class="container">

<div class="container--reimbursement">
    <%
        double allowanceRate = result.getTotalAllowance() / result.getNumberOfDays();
        double mileageRate =  result.getTotalMileage() / result.getUser().getTrip().getMileage();
    %>

    <div class="reimbursement">
        <h2 class="reimbursement__heading">Summary of the costs for <%=result.getUser().getFirstName() + " " + result.getUser().getLastName()%></h2>

        <div class="summary">
            <p class="reimbursement__text">You have spent <%=result.getNumberOfDays()%> days on your business trip and traveled <%=result.getUser().getTrip().getMileage()%> km.</p>
            <p class="reimbursement__text">Your daily allowance rate was <%=allowanceRate%>.</p>
            <p class="reimbursement__text">Your mileage rate was <%=mileageRate%>.</p>
        </div>
        <div>
            <p class="reimbursement__text">Your reimbursement for daily allowance is <%=result.getTotalAllowance()%></p>
            <p class="reimbursement__text">Your reimbursement for traveled kilometers is <%=result.getTotalMileage()%></p>
            <p class="reimbursement__text">Your reimbursement for additional costs is <%=result.getTotalAdditionalCosts()%></p>
        </div>
        <div>
            <p class="reimbursement__text">You will get back <%=result.getTotalReslut()%></p>
        </div>
        <div class="buttons">
            <a href="index.html" class="btn btn--goBack">Go back to main website</a>
        </div>
    </div>

</div>


</body>
</html>
