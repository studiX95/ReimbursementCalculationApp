<%@ page import="com.michalstodolny.reimbursementcalculationapp.admin.CurrentRate" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="./css/admin.css">
</head>
<body class="container">
<%
    Object rate = (CurrentRate) request.getAttribute("rate");
    List<String> costs = ((CurrentRate) rate).getAdditionalCosts();
%>

<form action="admin-set" class="form form--admin" id="form">

    <div class="finals">
        <h4 class="final__heading">All set current finals</h4>
        <div class="final__item">Current daily allowance rate: <%=((CurrentRate) rate).getDaillyAllowanceRate() %> </div>
        <div class="final__item">Current mileage rate: <%= ((CurrentRate) rate).getMileageRate() %> </div>
        <div class="final__item">Current receipts that user can choose: <%=((CurrentRate) rate).getAdditionalCosts()%>  </div>
    </div>

    <fieldset class="fields">
        <h4 class="form__heading">Set new values of finals</h4>
        <div class="field">
            <label for="allowance" class="field__item  field__item--label">Rate for daily allowance: </label>
            <input type="number" name="allowance" id="allowance" class="field__item field__item--input" required>
        </div>
        <div class="field">
            <label for="mileage" class="field__item  field__item--label">Rate for mileage: </label>
            <input type="number" step="0.1" name="mileage" id="mileage" class="field__item  field__item--input" required>
        </div>
        <div id="receipts" class="receipt">
            <div class="receipt__addPanel">
                <p class="receipt__text">Add a new receipt </p><div id="addReceiptBtn" class="receipt__add">ADD</div>
            </div>

            <div class="receipt">
                <label for="" class="field__item  field__item--label">New receipt: </label>
                <input type="text" class="field__item  field__item--input" name="costs" required>
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
        receipt.id = "receipt";
        receipt.className = "field"

        var label = document.createElement("label");
        var text = document.createTextNode("New receipt: ");
        label.className = "field__item  field__item--label";
        label.append(text);
        var input = document.createElement("input");
        input.setAttribute("type","text");
        input.setAttribute("name","costs");
        input.id = "cost";
        input.className = "field__item  field__item--input";

        receipt.append(label);
        receipt.append(input);

        receipts.append(receipt);

    });
</script>

</body>
</html>