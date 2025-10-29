<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/init.jsp" %>

<h2>File New FIR</h2>


<!-- ✅ Add this block here -->
<script>
    // Prevent the browser from going back to OTP or login when back is clicked
    window.history.replaceState(null, "", window.location.href);
</script>

<portlet:renderURL var="dashboardURL">
    <portlet:param name="mvcPath" value="/police_dashboard.jsp" />
</portlet:renderURL>

<button 
    style="background-color:#2196F3; color:white; padding:8px 15px; border:none; border-radius:5px; cursor:pointer; margin-bottom:10px;"
    onclick="location.href='${dashboardURL}'">
     Back to Dashboard
</button>
<!-- ✅ End of added block -->




<style>
/* General page styling */
body {
    font-family: Arial, sans-serif;
    margin: 20px;
    background-color: #f8f8f8;
}

/* Headings */
h2 {
    color: #333;
    margin-bottom: 15px;
}

/* Back button */
button {
    transition: 0.3s;
}
button:hover {
    background-color: #1976d2;
}

/* Form styling */
aui-form {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    margin-bottom: 20px;
    box-shadow: 0 0 5px rgba(0,0,0,0.1);
}
aui-form aui-input, aui-form aui-button {
    display: block;
    width: 100%;
    margin-bottom: 10px;
}

/* Submit button */
aui-button[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 10px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: 0.3s;
}
aui-button[type="submit"]:hover {
    background-color: #45a049;
}

/* Table styling */
table {
    border-collapse: collapse;
    width: 100%;
    background-color: #fff;
    box-shadow: 0 0 5px rgba(0,0,0,0.1);
}

table th, table td {
    text-align: left;
    padding: 12px;
    border-bottom: 1px solid #ddd;
}

table th {
    background-color: #4CAF50;
    color: white;
}

table tr:hover {
    background-color: #f1f1f1;
}

/* Action buttons inside table */
aui-form[style*="display:inline;"] aui-button {
    background-color: #2196F3;
    color: white;
    padding: 5px 10px;
    font-size: 0.9em;
    border-radius: 4px;
    margin-right: 5px;
}

aui-form[style*="display:inline;"] aui-button:hover {
    background-color: #1976d2;
}

/* Status badge */
.status-badge {
    padding: 5px 10px;
    border-radius: 12px;
    color: white;
    font-weight: bold;
    text-align: center;
    display: inline-block;
    min-width: 80px;
}


/* Status colors */
.status-pending { background-color: #ff9800; }     /* Orange */
.status-accepted { background-color: #4CAF50; }    /* Green */
.status-rejected { background-color: #f44336; }    /* Red */
.status-closed { background-color: #607D8B; }      /* Grey/Blue Grey */
.status-resolved { background-color: #2196F3; }    /* Blue */
.status-inprogress { background-color: #9C27B0; }  /* Purple */



/* Individual button colors (optional for clarity) */
button.accept { background-color: #4CAF50; }      /* Green */
button.reject { background-color: #f44336; }      /* Red */
button.close { background-color: #607D8B; }       /* Grey */
button.resolve { background-color: #2196F3; }     /* Blue */
button.inprogress { background-color: #9C27B0; }  /* Purple */
</style>

<portlet:actionURL name="/fir/manageFIRAction" var="fileFIRActionURL" />
<aui:form action="<%= fileFIRActionURL %>" method="post" name="fileFIRForm">
    <aui:input type="hidden" name="actionType" value="add" />
    <aui:input name="complainantName" label="Your Name" required="true" />
    <aui:input name="incidentDate" label="Date of Incident" type="date" required="true" />
    <aui:input name="incidentLocation" label="Incident Location" required="true" />
    <aui:input name="incidentDetails" label="Incident Details" type="textarea" required="true" />
    
    
     <!-- File upload field -->
    <aui:input type="file" name="proofFile" label="Upload Proof Document" required="true" />
    <aui:input name="userId" type="hidden" value="<%= themeDisplay.getUserId() %>" />
    <aui:button type="submit" value="Submit FIR" />
</aui:form>

<hr />

<h2>Existing FIRs</h2>

<c:choose>
    <c:when test="${not empty firs}">
        <table border="1" style="border-collapse: collapse; width: 100%;">
            <tr>
                <th>ID</th>
                <th>Complainant Name</th>
                <th>Incident Date</th>
                <th>Location</th>
                <th>Details</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>

            <c:forEach var="fir" items="${firs}">
             <fmt:formatDate var="incidentDateStr" value="${fir.incidentDate}" pattern="yyyy-MM-dd" />
            
                <tr>
                    <td>${fir.firId}</td>
                    <td>${fir.complainantName}</td>
                    <td>${fir.incidentDate}</td>
                    <td>${fir.incidentLocation}</td>
                    <td>${fir.incidentDetails}</td>
                  <!--   <td>${fir.status}</td> -->
                         <td>
    <c:choose>
        <c:when test="${fir.status == 'Pending'}">
            <span class="status-badge status-pending">${fir.status}</span>
        </c:when>
        <c:when test="${fir.status == 'Accepted'}">
            <span class="status-badge status-accepted">${fir.status}</span>
        </c:when>
        <c:when test="${fir.status == 'Rejected'}">
            <span class="status-badge status-rejected">${fir.status}</span>
        </c:when>
        <c:when test="${fir.status == 'Closed'}">
            <span class="status-badge status-closed">${fir.status}</span>
        </c:when>
        <c:when test="${fir.status == 'Resolved'}">
            <span class="status-badge status-resolved">${fir.status}</span>
        </c:when>
        <c:when test="${fir.status == 'In Progress'}">
            <span class="status-badge status-inprogress">${fir.status}</span>
        </c:when>
        <c:otherwise>
            <span class="status-badge status-pending">${fir.status}</span>
        </c:otherwise>
    </c:choose>
</td>
                    <td>
                        <!-- Update FIR -->
                        <portlet:actionURL name="/fir/manageFIRAction" var="updateFIRURL" />
                        <aui:form action="${updateFIRURL}" method="post" style="display:inline;">
                            <aui:input type="hidden" name="actionType" value="update" />
                            <aui:input type="hidden" name="firId" value="${fir.firId}" />
                            <aui:input name="complainantName" type="text" value="${fir.complainantName}" />
                           <!--  <aui:input name="incidentDate" type="date" value="${fir.incidentDate}" />
                         -->
                            <aui:input name="incidentDate" type="date" value="${incidentDateStr}" />
                            <aui:input name="incidentLocation" type="text" value="${fir.incidentLocation}" />
                            <aui:input name="incidentDetails" type="text" value="${fir.incidentDetails}" />
                          <!--   <aui:input name="status" type="text" value="${fir.status}" /> -->
                            <aui:button type="submit" value="Modify" />
                        </aui:form>

                        <!-- Delete FIR -->
                        <portlet:actionURL name="/fir/manageFIRAction" var="deleteFIRURL" />
                        <aui:form action="${deleteFIRURL}" method="post" style="display:inline;">
                            <aui:input type="hidden" name="actionType" value="delete" />
                            <aui:input type="hidden" name="firId" value="${fir.firId}" />
                            <aui:button type="submit" value="Withdraw" />
                        </aui:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>No FIRs filed yet.</p>
    </c:otherwise>
</c:choose>
