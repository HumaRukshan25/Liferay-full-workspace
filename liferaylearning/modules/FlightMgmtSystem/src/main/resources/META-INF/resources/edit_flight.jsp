<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="FlightMgmtSystemService.model.Flight" %>
<%@ page import="FlightMgmtSystemService.service.FlightLocalServiceUtil" %>

<%
    long flightId = ParamUtil.getLong(request, "flightId");
    Flight flight = FlightLocalServiceUtil.getFlight(flightId);
%>

<style>
/* ============================
   EDIT FORM STYLING
============================ */
.edit-flight-container {
    max-width: 650px;
    margin: 20px auto;
}

.edit-flight-container h2 {
    background: #004aad;
    display: inline-block;
    color: white;
    padding: 8px 14px;
    border-radius: 6px;
}

/* AUI Form Container */
.aui-form {
    background: #ffffff;
    padding: 25px !important;
    border-radius: 12px;
    margin-top: 10px;
    box-shadow: 0px 4px 12px rgba(0,0,0,0.15);
}

/* Field spacing */
.aui-form .aui-field-wrapper {
    margin-bottom: 16px;
}

/* Input label */
.aui-form label {
    font-weight: bold;
    color: #444;
}

/* Input styling */
.aui-form input[type="text"],
.aui-form input[type="number"],
.aui-form input[type="date"] {
    border-radius: 6px !important;
    border: 1px solid #cfd3d7 !important;
    padding: 10px !important;
    width: 100% !important;
    box-sizing: border-box;
}

/* Submit button */
.aui-form .aui-button-input-submit {
    background: #ff9800 !important;
    padding: 10px 20px !important;
    border-radius: 6px !important;
    color: #fff !important;
    font-size: 16px;
    cursor: pointer;
}

.aui-form .aui-button-input-submit:hover {
    background: #e68900 !important;
}



/* Back button - Same size and styling as Update button */
.back-btn {
    margin-bottom: 20px;
    display: inline-block;
    background: #ff9800 !important;   /* Same color as Update button */
    padding: 10px 20px !important;    /* Same padding */
    border-radius: 6px !important;
    color: #fff !important;
    font-size: 16px !important;
    cursor: pointer;
    text-decoration: none !important;
}

.back-btn:hover {
    background: #e68900 !important;   /* Same hover color */
}

</style>


<div class="edit-flight-container">

<!-- ✅ Back Button -->
<portlet:renderURL var="backURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<a class="back-btn" href="<%= backURL %>"> Back</a>

<h2>Edit Flight</h2>

<!-- ✅ Submit URL -->
<portlet:actionURL name="updateFlight" var="updateFlightURL" />

<!-- ✅ Edit Form -->
<aui:form action="<%= updateFlightURL %>" method="post">

    <aui:input name="flightId" type="hidden" value="<%= flight.getFlightId() %>" />

    <aui:input name="flightNumber" value="<%= flight.getFlightNumber() %>" label="Flight Number" />
    <aui:input name="airline" value="<%= flight.getAirline() %>" label="Airline" />
    <aui:input name="departureAirport" value="<%= flight.getDepartureAirport() %>" label="Departure Airport" />
    <aui:input name="arrivalAirport" value="<%= flight.getArrivalAirport() %>" label="Arrival Airport" />

    <aui:input name="departureTime" type="date" label="Departure Date"
               value="<%= new java.text.SimpleDateFormat(\"yyyy-MM-dd\").format(flight.getDepartureTime()) %>" />

    <aui:input name="arrivalTime" type="date" label="Arrival Date"
               value="<%= new java.text.SimpleDateFormat(\"yyyy-MM-dd\").format(flight.getArrivalTime()) %>" />

    <aui:input name="availableSeats" value="<%= flight.getAvailableSeats() %>" label="Seats" />
    <aui:input name="price" value="<%= flight.getPrice() %>" label="Price" />

    <aui:button type="submit" value="Update" />
</aui:form>

</div>
