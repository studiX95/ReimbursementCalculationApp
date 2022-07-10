<%@ page import="com.michalstodolny.reimbursementcalculationapp.admin.CurrentRate" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Michał
  Date: 2022-07-08
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%Object rate = (CurrentRate) request.getAttribute("rate");%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/user.css">
</head>
<body class="container">
<form action="user-set" id="form" class="form form--user" >

        <fieldset class="fields">
            <h4 class="form__heading">Personal Data</h4>
            <div class="field">
                <label for="firstName" class="field__item  field__item--label">First name: </label>
                <input type="text" name="firstName" id="firstName" class="field__item field__item--input" required="required">
            </div>
            <div class="field">
                <label for="lastName" class="field__item  field__item--label">Last name: </label>
                <input type="text" name="lastName" id="lastName" class="field__item field__item--input" required>
            </div>
            <div class="field">
                <label for="jobPosition" class="field__item  field__item--label">Job position: </label>
                <select class="field__item field__item--input" name="jobPosition" id="jobPosition">
                    <option value="programmer">Programmer</option>
                    <option value="tester">Tester</option>
                    <option value="hr">HR Specialist</option>
                    <option value="manager">Manager</option>
                    <option value="leader">Team Leader</option>
                    <option value="other">other</option>
                </select>
            </div>
        </fieldset>

        <fieldset class="fields">
            <h4 class="form__heading">Business trip data</h4>
            <div class="field">
                <label for="from" class="field__item  field__item--label">From: </label>
                <input type="text" name="from" id="from" class="field__item field__item--input" required>
            </div>
            <div class="field">
                <label for="to" class="field__item  field__item--label">To: </label>
                <input type="text" name="to" id="to" class="field__item field__item--input" required>
            </div>
            <div class="field">
                <label for="mileage" class="field__item  field__item--label">Car mileage: </label>
                <input type="number" name="mileage" id="mileage" class="field__item field__item--input" required>
            </div>
            <div class="field">
                <label for="startDate" class="field__item  field__item--label">Start date: </label>
                <input type="date" name="startDate" id="startDate" class="field__item field__item--input" required>
            </div>
            <div class="field">
                <label for="endDate" class="field__item  field__item--label">End date: </label>
                <input type="date" name="endDate" id="endDate" class="field__item field__item--input" required>
            </div>
        </fieldset>

        <fieldset class="fields">
            <h4 class="form__heading">Additional costs data</h4>
            <div id="receipts">
                <div class="receipt__addPanel">
                    <p class="receipt__text">Add a new receipt </p><div id="addReceiptBtn" class="receipt__add">ADD</div>
                </div>
                <div class="receipt">
                    <label class="field__item  field__item--label" for="">Receipt: </label>
                    <select class="field__item field__item--input" name="receipt">
                        <% for (String list: ((CurrentRate) rate).getAdditionalCosts()) { %> <%=String.format("<option value=\'%s\'>%s</option>",list,list)%><%}%>";
                    </select>
                    <label class="field__item  field__item--label" for="">Cost: </label>
                    <input type="number" name="cost" class="field__item field__item--input" required="required">
                </div>
            </div>
        </fieldset>
        <div class="buttons">
            <a href="index.html" class="btn btn--goBack">Go back to main website</a>
            <input type="submit" value="Send" class="btn btn--submit">
        </div>


</form>






<script>
    var btn = document.getElementById("addReceiptBtn");
    var receipts = document.getElementById("receipts");

    btn.addEventListener('click', function () {

        var receipt = document.createElement("div");
        var label = document.createElement("label");
        var text = document.createTextNode("Receipt: ")
        label.append(text);
        label.className = "field__item  field__item--label";
        var select = document.createElement("select");
        select.setAttribute("name","receipt")
        select.className = "field__item field__item--input";
        var options = "<% for (String list: ((CurrentRate) rate).getAdditionalCosts()) { %> <%=String.format("<option value=\'%s\'>%s</option>",list,list)%><%}%>";
        select.innerHTML = options;

        var label2 = document.createElement("label");
        var text2 = document.createTextNode("Cost: ")
        label2.append(text2);
        label2.className = "field__item  field__item--label";

        var input = document.createElement("input");
        input.setAttribute("type","number");
        input.setAttribute("name","cost");
        input.setAttribute("required","required");
        input.className = "field__item  field__item--input";

        receipt.append(label);
        receipt.append(select);
        receipt.append(label2);
        receipt.append(input);
        receipt.className = "receipt";
        receipts.append(receipt);

    });
</script>

</body>
</html>
