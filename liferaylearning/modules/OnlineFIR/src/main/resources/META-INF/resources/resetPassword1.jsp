<%@ include file="/init.jsp" %>

<h2>Reset Your Password--</h2>

<portlet:actionURL name="/password/resetUser" var="resetPasswordURL" />

<aui:form action="<%= resetPasswordURL %>" method="post">
    <aui:input name="email" type="email" label="Email" required="true" />
    <aui:input name="newPassword" type="password" label="New Password" required="true" />
    <aui:input name="confirmPassword" type="password" label="Confirm Password" required="true" />

    <aui:button type="submit" value="Reset Password" />
</aui:form>

<!-- ✅ Error & Success Messages -->
<liferay-ui:error key="resetError" message="Password reset failed. Please try again." />
<liferay-ui:error key="userNotFound" message="No user found with this email." />
<liferay-ui:success key="resetSuccess" message="Password reset successful. You can now log in." />

<!-- Reset Password Link -->
<portlet:renderURL var="resetPasswordURL" windowState="NORMAL">
    <portlet:param name="mvcPath" value="/resetPassword1.jsp" />
</portlet:renderURL>

<p><a href="<%= resetPasswordURL.toString() %>">Forgot Password? Reset Here</a></p>
