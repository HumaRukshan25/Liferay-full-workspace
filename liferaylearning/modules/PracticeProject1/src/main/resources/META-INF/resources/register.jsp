
<%@ include file="/init.jsp" %>
<portlet:defineObjects />

<h2>Register</h2>

<aui:form action="<%= renderResponse.createActionURL() %>" method="post">
    <aui:input name="username" label="Username" />
    <aui:input name="password" label="Password" type="password" />
    <aui:button type="submit" value="Register" />
    <aui:input type="hidden" name="javax.portlet.action" value="/registerUser" />
</aui:form>
