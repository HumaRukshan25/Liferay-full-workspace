<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h2>Track FIR Status</h2>

<script>
    window.history.replaceState(null, "", window.location.href);
</script>

<portlet:renderURL var="dashboardURL">
    <portlet:param name="mvcPath" value="/citizen_dashboard.jsp" />
</portlet:renderURL>

<button 
    style="background-color:#2196F3; color:white; padding:8px 15px; border:none; border-radius:5px; cursor:pointer; margin-bottom:10px;"
    onclick="location.href='${dashboardURL}'">
     Back to Dashboard
</button>

<hr />

<c:choose>
    <c:when test="${not empty firs}">
        <table border="1" style="border-collapse: collapse; width: 100%; font-family: Arial, sans-serif;">
            <tr style="background-color:#4CAF50; color:white;">
                <th>ID</th>
                <th>Complainant Name</th>
                <th>Incident Date</th>
                <th>Location</th>
                <th>Details</th>
                <th>Status</th>
            </tr>

            <c:forEach var="fir" items="${firs}">
                <fmt:formatDate var="incidentDateStr" value="${fir.incidentDate}" pattern="yyyy-MM-dd" />
                <tr>
                    <td>${fir.firId}</td>
                    <td>${fir.complainantName}</td>
                    <td>${incidentDateStr}</td>
                    <td>${fir.incidentLocation}</td>
                    <td>${fir.incidentDetails}</td>
                    <td>
                        <c:choose>
                            <c:when test="${empty fir.status}">
                                Pending
                            </c:when>
                            <c:otherwise>
                                ${fir.status}
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>No FIRs found for your account.</p>
    </c:otherwise>
</c:choose>

<style>
    table td, table th {
        padding: 8px;
        text-align: left;
    }
</style>
