<%@ include file="/init.jsp" %>

<h2>Add New User</h2>

<portlet:actionURL var="saveUserURL" name="/admin/saveUser" />

<aui:form action="${saveUserURL}" method="post">

    <aui:input name="loginName" label="Login Name" required="true" />
    <aui:input name="firstName" label="First Name" required="true" />
    <aui:input name="lastName" label="Last Name" required="true" />
    <aui:input name="email" label="Email" type="email" required="true" />
    <aui:input name="phoneNo" label="Phone Number" />

    <aui:select name="role" label="Role" required="true">
        <aui:option value="">--Select Role--</aui:option>
        <aui:option value="Admin">Admin</aui:option>
        <aui:option value="Citizen">Citizen</aui:option>
        <aui:option value="Police">Police</aui:option>
    </aui:select>

    <aui:select name="active" label="Active">
        <aui:option value="true">Yes</aui:option>
        <aui:option value="false">No</aui:option>
    </aui:select>

    <aui:button-row>
        <aui:button type="submit" value="Save User" />
        <portlet:renderURL var="manageUsersURL">
            <portlet:param name="mvcRenderCommandName" value="/admin/manageUsers" />
        </portlet:renderURL>
        <aui:button type="button" value="Cancel" onClick="location.href='${manageUsersURL}'" />
    </aui:button-row>

</aui:form>
