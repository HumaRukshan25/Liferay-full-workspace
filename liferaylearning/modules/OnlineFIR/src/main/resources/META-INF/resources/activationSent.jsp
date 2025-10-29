<%@ include file="/init.jsp" %>

<h2>Activation Email Sent</h2>

<p>Thank you for signing up! An activation link has been sent to your email address.</p>

<%
    String emailAddress = (String)request.getAttribute("pendingEmail");
%>

<portlet:actionURL name="/user/activate" var="activateURL">
    <portlet:param name="email" value="<%= emailAddress %>" />
</portlet:actionURL>

<p>
    <a href="<%= activateURL %>">Click here to activate your account</a>
</p>


