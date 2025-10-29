<%@ include file="/init.jsp" %>

<h2>Edit User</h2>

<portlet:actionURL name="/admin/updateUser" var="updateUserURL" />

<aui:form action="<%= updateUserURL %>" method="post">
    <aui:input name="userId" type="hidden" value="${editUser.signupUserId}" />

    <aui:input name="firstName" label="First Name" value="${editUser.firstName}" />
    <aui:input name="lastName" label="Last Name" value="${editUser.lastName}" />
    <aui:input name="email" label="Email" value="${editUser.email}" />
    <aui:input name="phoneNo" label="Phone" value="${editUser.phoneNo}" />
    <aui:input name="role" label="Role" value="${editUser.role}" />
    <aui:input name="active" label="Active" type="checkbox" checked="${editUser.active}" />

    <aui:button type="submit" value="Update User" />
</aui:form>
