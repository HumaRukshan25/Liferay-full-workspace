<%@ include file="/init.jsp" %>

<h2>Activation Email Sent</h2>

<p>Thank you for signing up! An activation link has been sent to your email address.</p>

<%
String email = (String) session.getAttribute("pendingUserEmail");
String firstName = (String) session.getAttribute("pendingUserFirstName");
%>

<portlet:actionURL name="/user/activate1" var="activateURL1">
    <portlet:param name="email" value="<%= email %>" />
    <portlet:param name="firstName" value="<%= firstName %>" />
</portlet:actionURL>

<p>
    <a href="<%= activateURL1 %>">Click here to activate your account</a>
</p>

<portlet:renderURL var="signupURL">
    <portlet:param name="mvcPath" value="/signup1.jsp" />
</portlet:renderURL>
<p>If this email is incorrect or you want to signup again, <a href="<%= signupURL %>">Back to Signup</a></p>