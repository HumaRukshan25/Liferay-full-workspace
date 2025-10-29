<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/init.jsp" %>

<portlet:defineObjects />

<h2>Welcome to Cin/Cout/ System</h2>

<portlet:renderURL var="registerURL">
    <portlet:param name="mvcPath" value="/register.jsp" />
</portlet:renderURL>

<portlet:renderURL var="loginURL">
    <portlet:param name="mvcPath" value="/login.jsp" />
</portlet:renderURL>

<p>
    <a href="${registerURL}">Register</a>
</p>
<p>
    <a href="${loginURL}">Login</a>
</p>
