<%@page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<style>
/* SAME STYLES TAKEN FROM view.jsp */

.page-title {
    text-align: center;
    font-size: 32px;
    font-weight: bold;
    color: #004aad;
    margin-top: 25px;
    margin-bottom: 30px;
    text-transform: uppercase;
    letter-spacing: 1px;
}

.form-container {
    display: flex;
    justify-content: center;
    width: 100%;
}

.form-container form {
    background: #ffffff;
    padding: 30px;
    width: 750px;
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0,0,0,0.2);
    margin-bottom: 35px;
}

.aui-field-wrapper-content input {
    width: 100%;
}



/* ============================
   EDIT & DELETE BUTTONS
============================ */
.aui-button[value="Edit"] {
    background: #28a745 !important;
    color: white !important;
    padding: 8px 14px !important;
    border-radius: 6px !important;
}

.aui-button[value="Edit"]:hover {
    background: #1e7e34 !important;
}

.aui-button[value="Delete"] {
    background: #dc3545 !important;
    color: white !important;
    padding: 8px 14px !important;
    border-radius: 6px !important;
}

.aui-button[value="Delete"]:hover {
    background: #b02a37 !important;
}
</style>

<%
    // ✅ Parent category ID (replace with your Airport root category ID)
    long airportRootCategoryId = 68521;  

    List<AssetCategory> airports = AssetCategoryLocalServiceUtil.getChildCategories(airportRootCategoryId);
%>


<!-- ✅ PAGE HEADING -->
<div class="page-title">Add Flight</div>

<!-- ✅ FORM CENTERED -->
<div class="form-container">

    <portlet:actionURL name="addFlight" var="addFlightURL"></portlet:actionURL>

    <aui:form action="<%= addFlightURL %>" method="post">

        <aui:input name="flightNumber" label="Flight Number" type="text" style="margin-bottom:16px;">
            <aui:validator name="required" />
        </aui:input>

        <aui:input name="airline" label="Airline" type="text" style="margin-bottom:16px;">
            <aui:validator name="required" />
            <aui:validator name="custom" errorMessage="Only letters and spaces allowed.">
                /^[A-Za-z ]+$/
            </aui:validator>
        </aui:input>

        <aui:input name="departureAirport" label="Departure Airport" type="text" style="margin-bottom:16px;">
            <aui:validator name="required" />
        </aui:input>

       
        
<aui:select name="arrivalAirport" label="Arrival Airport" style="margin-bottom:16px;">
    <aui:validator name="required" />

    <% for (AssetCategory airport : airports) { %>
        <aui:option value="<%= airport.getName() %>">
            <%= airport.getName() %>
        </aui:option>
    <% } %>

</aui:select>


        <aui:input name="departureTime" label="Departure Time" type="date" style="margin-bottom:16px;">
            <aui:validator name="required" />
        </aui:input>

        <aui:input name="arrivalTime" label="Arrival Time" type="date" style="margin-bottom:16px;">
            <aui:validator name="required" />
        </aui:input>

        <aui:input name="availableSeats" label="Available Seats" type="number" style="margin-bottom:16px;">
            <aui:validator name="required" />
            <aui:validator name="number" />
        </aui:input>

        <aui:input name="price" label="Ticket Price" type="number" style="margin-bottom:16px;">
            <aui:validator name="required" />
            <aui:validator name="number" />
        </aui:input>

        <aui:button type="submit" value="Add Flight"
            style="background:#007bff;padding:10px 20px;border-radius:6px;color:#fff;font-size:16px;" />
    </aui:form>
</div>
