<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Edit User</h2>

<liferay-ui:success key="userUpdated" message="User updated successfully!" />

<!-- Create action URL for the form -->
<portlet:actionURL var="updateUserURL" name="/admin/updateUser12" />

<aui:form action="${updateUserURL}" method="post">
    <aui:input name="userId" type="hidden" value="${editUser.userId}" />

    <aui:input name="firstName" label="First Name" value="${editUser.firstName}" required="true" />
    <aui:input name="lastName" label="Last Name" value="${editUser.lastName}" required="true" />
    <aui:input name="screenName" label="Screen Name" value="${editUser.screenName}" required="true" />
    <aui:input name="email" label="Email" value="${editUser.emailAddress}" required="true" type="email" />

    <aui:select label="Status" name="active">
        <c:choose>
            <c:when test="${editUser.status == 0}">
                <aui:option value="true" selected="true">Active</aui:option>
                <aui:option value="false">Inactive</aui:option>
            </c:when>
            <c:otherwise>
                <aui:option value="true">Active</aui:option>
                <aui:option value="false" selected="true">Inactive</aui:option>
            </c:otherwise>
        </c:choose>
    </aui:select>

    <aui:button type="submit" value="Save" />
</aui:form>
