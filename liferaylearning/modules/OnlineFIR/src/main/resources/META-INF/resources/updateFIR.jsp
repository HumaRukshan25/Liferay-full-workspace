<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h2>Update FIR Details</h2>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/viewAllFIRs.jsp" />
</portlet:renderURL>

<button style="background-color:#2196F3; color:white; padding:8px 15px; border:none; border-radius:5px; cursor:pointer; margin-bottom:10px;"
        onclick="location.href='${viewURL}'">
    Back to view all firs
</button>


<!-- Action URL for updating FIR -->
<portlet:actionURL name="/admin/updateFIR" var="updateFIRURL" />



<form method="post" action="${updateFIRURL}" style="margin-top:10px;">
    <input type="hidden" name="<portlet:namespace/>firId" value="${fir.firId}" />

    <table style="border-collapse:collapse;width:60%;">
        <tr>
            <td><b>Complainant Name:</b></td>
            <td><input type="text" name="<portlet:namespace/>complainantName" value="${fir.complainantName}" style="width:100%;" /></td>
        </tr>

        <tr>
            <td><b>Incident Details:</b></td>
            <td><textarea name="<portlet:namespace/>incidentDetails" rows="3" cols="40" style="width:100%;">${fir.incidentDetails}</textarea></td>
        </tr>

        <tr>
            <td><b>Incident Location:</b></td>
            <td><input type="text" name="<portlet:namespace/>incidentLocation" value="${fir.incidentLocation}" style="width:100%;" /></td>
        </tr>

        <tr>
            <td><b>Status:</b></td>
            <td><input type="text" name="<portlet:namespace/>status" value="${fir.status}" style="width:100%;" /></td>
        </tr>

        <tr>
            <td><b>Assigned Inspector:</b></td>
            <td>
                <select name="<portlet:namespace/>assignedInspector" style="width:100%;">
                    <option value="">Select</option>
                    <c:forEach var="inspector" items="${inspectors}">
                        <option value="${inspector.fullName}"
                            <c:if test="${fir.assignedInspector == inspector.fullName}">selected</c:if>>
                            ${inspector.fullName}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <button type="submit"
        style="margin-top:20px;background-color:#4CAF50;color:white;border:none;padding:10px 20px;border-radius:5px;cursor:pointer;">
        Save Changes
    </button>
</form>
