<%@ include file="/init.jsp" %>

<h2>Add New User</h2>

<%-- Display success/error messages --%>
<c:if test="${not empty success}">
    <div class="alert alert-success">
        ${success}
    </div>
</c:if>

<c:if test="${not empty error}">
    <div class="alert alert-danger">
        ${error}
    </div>
</c:if>

<portlet:actionURL var="saveUserURL1" name="/admin/saveUser1" />

<aui:form action="${saveUserURL1}" method="post" name="addUserForm">
    <aui:input name="loginName" label="Login Name" required="true">
        <aui:validator name="required" errorMessage="Please enter a login name"/>
    </aui:input>
    
    <aui:input name="firstName" label="First Name" required="true">
        <aui:validator name="required" errorMessage="Please enter first name"/>
    </aui:input>
    
    <aui:input name="lastName" label="Last Name" required="true">
        <aui:validator name="required" errorMessage="Please enter last name"/>
    </aui:input>
    
    <aui:input name="email" label="Email" type="email" required="true">
        <aui:validator name="required" errorMessage="Please enter email"/>
        <aui:validator name="email" errorMessage="Please enter a valid email"/>
    </aui:input>
    
    <aui:input name="phoneNo" label="Phone Number">
        <aui:validator name="digits" errorMessage="Please enter numbers only"/>
        <aui:validator name="minLength">10</aui:validator>
        <aui:validator name="maxLength">15</aui:validator>
    </aui:input>

    <aui:input name="password" label="Password" type="password" required="true" value="Test@123">
        <aui:validator name="required" errorMessage="Please enter password"/>
    </aui:input>

    <aui:select name="role" label="Role" required="true">
        <aui:option value="">--Select Role--</aui:option>
        <aui:option value="Administrator">Admin</aui:option>
        <aui:option value="Citizen">Citizen</aui:option>
        <aui:option value="Police">Police</aui:option>
    </aui:select>

    <aui:select name="active" label="Active Status">
        <aui:option value="true" selected="true">Active</aui:option>
        <aui:option value="false">Inactive</aui:option>
    </aui:select>

    <aui:button-row>
        <aui:button type="submit" value="Save User" />
        <portlet:renderURL var="manageUsersURL1">
            <portlet:param name="mvcRenderCommandName" value="/admin/manageUsers1" />
        </portlet:renderURL>
        <aui:button type="button" value="Cancel" onClick="location.href='${manageUsersURL1}'" />
    </aui:button-row>

</aui:form>