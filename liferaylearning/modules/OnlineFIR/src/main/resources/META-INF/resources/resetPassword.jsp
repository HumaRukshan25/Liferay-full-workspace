<%@ include file="/init.jsp" %>

<h2>Reset Your Password</h2>

<portlet:actionURL name="/password/reset" var="resetPasswordURL" />

<aui:form action="<%= resetPasswordURL %>" method="post">
    <!-- Take email to identify which user password to reset -->
    <aui:input name="email" type="text" label="Email" required="true" />

    <aui:input name="newPassword" type="password" label="New Password" required="true" />
    <aui:input name="confirmPassword" type="password" label="Confirm Password" required="true" />

    <aui:button type="submit" value="Reset Password" />
</aui:form>

<liferay-ui:error key="resetError" message="Password reset failed. Please try again." />
<liferay-ui:success key="resetSuccess" message="Password reset successful. You can now log in." />
