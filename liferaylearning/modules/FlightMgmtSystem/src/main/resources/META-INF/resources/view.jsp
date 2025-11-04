<%@page import="FlightMgmtSystemService.service.FlightLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="FlightMgmtSystemService.model.Flight"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<style>

/* ============================
   PAGE HEADING
============================ */
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

/* ============================
   FORM CENTER + RESPONSIVE SIZE
============================ */
.form-container {
    display: flex;
    justify-content: center;
    width: 100%;
}

.form-container form {
    background: #ffffff;
    padding: 30px;
    width: 750px;             /* ✅ Increased width */
    border-radius: 12px;
    box-shadow: 0px 4px 12px rgba(0,0,0,0.2);
    margin-bottom: 35px;
}

/* Make all AUI input fields same width */
.aui-field-wrapper-content input {
    width: 100%;
}

/* ============================
   TABLE AREA CENTER + SPACING
============================ */
.table-section {
    padding: 0px 60px;   /* ✅ Increased spacing so table won't touch edges */
}

/* ============================
   TABLE DESIGN
============================ */
table {
    width: 100%;
    margin-top: 20px;
    border-collapse: collapse;
    background: white;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 4px 12px rgba(0,0,0,0.15);
}

table th, table td {
    padding: 14px;
    text-align: center;
    font-size: 15px;
}

table th {
    background: #004aad;
    color: white;
    text-transform: uppercase;
}

table tr:nth-child(even) {
    background: #f8f9fa;
}


</style>



<!-- ✅ PAGE TITLE -->
<!-- ✅ PAGE TITLE -->
<div class="page-title">Flight Management System</div>

<!-- ✅ ADD FLIGHT BUTTON (opens add_flight.jsp) -->
<portlet:renderURL var="addFlightPageURL">
    <portlet:param name="mvcPath" value="/add_flight.jsp" />
</portlet:renderURL>

<div style="text-align:center; margin-bottom: 25px;">
    <aui:button value="Add Flight"
        style="background:#007bff;padding:12px 20px;border-radius:6px;color:#fff;font-size:16px;"
        onClick="<%= addFlightPageURL %>" />
</div>




<!-- ✅ TABLE WITH SIDE SPACING -->
<div class="table-section">

<h2>Flight Records</h2>

<%
    List<Flight> flights = FlightLocalServiceUtil.getFlights(-1, -1);
%>

<table>
<tr>
    <th>Flight Number</th>
    <th>Airline</th>
    <th>Departure</th>
    <th>Arrival</th>
    <th>Seats</th>
    <th>Price</th>
    <th>Actions</th>
</tr>

<% for (Flight flight : flights) { %>
<tr>
    <td><%= flight.getFlightNumber() %></td>
    <td><%= flight.getAirline() %></td>
    <td><%= flight.getDepartureAirport() %></td>
    <td><%= flight.getArrivalAirport() %></td>
    <td><%= flight.getAvailableSeats() %></td>
    <td><%= flight.getPrice() %></td>

    <td>
        <portlet:renderURL var="editURL">
            <portlet:param name="mvcPath" value="/edit_flight.jsp" />
            <portlet:param name="flightId" value="<%= String.valueOf(flight.getFlightId()) %>" />
        </portlet:renderURL>

        <aui:button value="Edit" onClick="<%= editURL %>" />

        <portlet:actionURL name="deleteFlight" var="deleteURL">
            <portlet:param name="flightId" value="<%= String.valueOf(flight.getFlightId()) %>" />
        </portlet:actionURL>

        <aui:button value="Delete" onClick="<%= deleteURL %>" />
    </td>
</tr>
<% } %>
</table>

</div>
