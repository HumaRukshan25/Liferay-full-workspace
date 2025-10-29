<%@ include file="/init.jsp" %>



<style>
/* General page styling */
body {
    font-family: Arial, sans-serif;
    background-color: #f4f6f9;
    color: #333;
    margin: 20px;
}

/* Headings */
h2, h3 {
    color: #2c3e50;
    margin-bottom: 15px;
}

/* Form styling */
aui\\:form {
    background-color: #e8f5e9; /* light green background */
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    margin-bottom: 30px;
}

/* Form inputs */
aui\\:input {
    display: block;
    margin-bottom: 15px;
    width: 100%;
}

/* Form buttons */
aui\\:button {
    background-color: #4caf50; /* green button */
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 14px;
    transition: background-color 0.3s ease;
}

aui\\:button:hover {
    background-color: #388e3c;
}

/* Table styling */
table {
    width: 100%;
    border-collapse: collapse;
    background-color: #fff;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
}

th, td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: left;
}

th {
    background-color: #4caf50;
    color: white;
}

tr:nth-child(even) {
    background-color: #f9f9f9;
}

tr:hover {
    background-color: #dcedc8; /* light green hover */
}

/* Action forms/buttons inline */
td form {
    display: inline-block;
    margin-right: 5px;
}
</style>



<!-- ✅ Add this block here -->
<script>
    // Prevent the browser from going back to OTP or login when back is clicked
    window.history.replaceState(null, "", window.location.href);
</script>

<portlet:renderURL var="dashboardURL">
    <portlet:param name="mvcPath" value="/dashboard1.jsp" />
</portlet:renderURL>

<button 
    style="background-color:#2196F3; color:white; padding:8px 15px; border:none; border-radius:5px; cursor:pointer; margin-bottom:10px;"
    onclick="location.href='${dashboardURL}'">
     Back to Dashboard
</button>
<!-- ✅ End of added block -->


<h2>Station Management</h2>

<!-- ✅ Create Action URL for Add -->
<portlet:actionURL name="/admin/manageStationAction" var="addStationURL" />

<aui:form action="${addStationURL}" method="post">
    <aui:input type="hidden" name="actionType" value="add" />

    <aui:input name="stationName" label="Station Name" required="true" />
    <aui:input name="address" label="Address" required="true" />
    <aui:input name="jurisdictionArea" label="Jurisdiction Area" required="true" />

    <aui:button type="submit" value="Add Station" />
</aui:form>

<!-- ✅ Existing Stations -->
<h3>Existing Police Stations</h3>
<table border="1" style="border-collapse: collapse; width: 100%;">
    <tr>
        <th>ID</th>
        <th>Station Name</th>
        <th>Address</th>
        <th>Jurisdiction Area</th>
        <th>Status</th>
        <th>Officer In Charge</th> <!-- New column -->
        <th>Actions</th>
    </tr>

    <c:forEach var="station" items="${stations}">
        <tr>
            <td>${station.stationId}</td>
            <td>${station.stationName}</td>
            <td>${station.address}</td>
            <td>${station.jurisdictionArea}</td>
            <td>${station.status}</td>
            <td>${station.officerInCharge}</td> <!-- Display officer -->
            <td>
                <!-- ✅ Update Action URL -->
                <portlet:actionURL name="/admin/manageStationAction" var="updateStationURL" />
                <aui:form action="${updateStationURL}" method="post" style="display:inline;">
                    <aui:input type="hidden" name="actionType" value="update" />
                    <aui:input type="hidden" name="stationId" value="${station.stationId}" />
                    <aui:input name="stationName" type="text" value="${station.stationName}" label="New Name" />
                    <aui:input name="address" type="text" value="${station.address}" label="New Address" />
                    <aui:input name="jurisdictionArea" type="text" value="${station.jurisdictionArea}" label="New Area" />
                    <aui:button type="submit" value="Update" />
                </aui:form>

                <!-- ✅ Delete Action URL -->
                <portlet:actionURL name="/admin/manageStationAction" var="deleteStationURL" />
                <aui:form action="${deleteStationURL}" method="post" style="display:inline;">
                    <aui:input type="hidden" name="actionType" value="delete" />
                    <aui:input type="hidden" name="stationId" value="${station.stationId}" />
                    <aui:button type="submit" value="Delete" />
                </aui:form>
            </td>
        </tr>
    </c:forEach>
</table>
