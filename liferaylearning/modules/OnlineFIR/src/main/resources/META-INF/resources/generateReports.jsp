<%@ include file="/init.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Generate FIR Report</h2>
<p>Enter FIR ID to generate CSV report:</p>

<portlet:actionURL name="/admin/processReports" var="generateReportURL" />

<aui:form action="${generateReportURL}" method="post">
    <aui:input name="firId" label="Enter FIR ID" type="text" required="true" />
    <aui:button type="submit" value="Generate Report" />
</aui:form>

<c:if test="${not empty errorMsg}">
    <p style="color:red">${errorMsg}</p>
</c:if>
