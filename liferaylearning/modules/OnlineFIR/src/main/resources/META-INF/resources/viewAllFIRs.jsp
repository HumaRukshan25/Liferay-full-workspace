<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h2>Case Management [All FIR Records - Admin Panel]</h2>

<portlet:renderURL var="dashboardURL">
    <portlet:param name="mvcPath" value="/dashboard1.jsp" />
</portlet:renderURL>

<button style="background-color:#2196F3; color:white; padding:8px 15px; border:none; border-radius:5px; cursor:pointer; margin-bottom:10px;"
        onclick="location.href='${dashboardURL}'">
    Back to Dashboard
</button>

<style>
.scroll-container {
    max-height: 500px;
    overflow-y: auto;
    overflow-x: auto;
    border: 1px solid #ccc;
    margin-top: 15px;
    border-radius: 6px;
    width: 100%;
    white-space: nowrap;
}
table { display: inline-block; min-width: 1300px; border-collapse: collapse; font-family: Arial, sans-serif; }
th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
th { background-color: #4CAF50; color: white; }
tr:nth-child(even) { background-color: #f9f9f9; }
tr:hover { background-color: #f1f1f1; }
button.update, button.delete {
    border: none; border-radius: 5px; padding: 6px 10px; color: white; cursor: pointer; font-size: 13px;
}
button.update { background-color: #4CAF50; }
button.delete { background-color: #f44336; }
button.update:hover, button.delete:hover { opacity: 0.85; }
</style>

<c:if test="${not empty firs}">
<div class="scroll-container">
    <table>
        <thead>
            <tr>
                <th>FIR ID</th>
                <th>Complainant</th>
                <th>Incident Date</th>
                <th>Details</th>
                <th>Location</th>
                <th>Status</th>
                <th>Assigned Inspector</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="fir" items="${firs}">
                <tr>
                    <td>${fir.firId}</td>
                    <td>${fir.complainantName}</td>
                    <td><fmt:formatDate value="${fir.incidentDate}" pattern="dd-MM-yyyy HH:mm" /></td>
                    <td>${fir.incidentDetails}</td>
                    <td>${fir.incidentLocation}</td>
                    <td>${fir.status}</td>
                    <td>${fir.assignedInspector}</td>
                    <td>
                     <portlet:renderURL var="updateFIRURL">
    <portlet:param name="mvcRenderCommandName" value="/admin/editFIR" />
    <portlet:param name="firId" value="${fir.firId}" />
</portlet:renderURL>
                     

                        <button class="update" onclick="location.href='${updateFIRURL}'">Edit</button>


                        <portlet:actionURL name="/admin/deleteFIR" var="deleteFIRURL">
                            <portlet:param name="firId" value="${fir.firId}" />
                        </portlet:actionURL>
                        <button class="delete"
                            onclick="if(confirm('Are you sure to delete FIR ${fir.firId}?')) window.location.href='${deleteFIRURL}'">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</c:if>

<c:if test="${empty firs}">
    <p>No FIR records found.</p>
</c:if>

<footer style="margin-top:20px;text-align:center;color:#555;">
    Copyright © ATS Global
</footer>
