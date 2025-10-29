<%@ include file="/init.jsp" %>

<h2> Login Failed</h2>
<p>Invalid username or password. Please try again.</p>

<aui:button-row>
    <aui:button type="button" value="Back to Login" onClick="location.href='<%= renderResponse.createRenderURL() %>';" />
</aui:button-row>
