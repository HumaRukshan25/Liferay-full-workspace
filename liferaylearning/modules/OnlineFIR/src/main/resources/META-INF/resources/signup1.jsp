<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>User Signup</h2>

<%-- Display backend errors --%>
<%
String error = (String) request.getAttribute("signupError");
if (error != null) {
%>
<div style="border:1px solid red; padding:10px; background:#ffe6e6;">
    <strong>Error:</strong><br>
    <%= error %>
</div>
<% } %>

<portlet:actionURL name="/user/signup1" var="signupActionURL" />

<aui:form action="<%= signupActionURL %>" method="post" name="signupForm">
    <aui:input name="loginName" label="Username" required="true" />
    <aui:input name="firstName" label="First Name" required="true" />
    <aui:input name="lastName" label="Last Name" required="true" />
    <aui:input name="email" label="Email Address" type="email" required="true" />
    <aui:input name="phoneNo" label="Phone Number" type="text" required="true" />
    <aui:input name="password" label="Password" type="password" required="true" />
    <aui:select name="role" label="Select Role" required="true">
        <aui:option value="User">Citizen</aui:option>
        <aui:option value="Police">Police</aui:option>
        <aui:option value="Administrator">Admin</aui:option>
    </aui:select>
    <aui:button type="submit" value="Sign Up" />
</aui:form>

<c:if test="${not empty signupSuccess}">
    <div style="border:1px solid green; padding:10px; background:#e6ffe6;">
        ${signupSuccess}
    </div>
</c:if>

<portlet:renderURL var="loginURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<p>Already have an account? <a href="<%= loginURL %>">Back to Login</a></p>
