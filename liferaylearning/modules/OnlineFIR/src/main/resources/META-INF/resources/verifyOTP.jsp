<%@ include file="/init.jsp" %>

<h2> Enter OTP</h2>
<p>Please check your email for the OTP and enter it below:</p>

<portlet:actionURL name="/otp/verify2" var="verifyOtpURL2" />
<aui:form action="<%= verifyOtpURL2 %>" method="post" name="verifyOtpForm">
    <aui:fieldset>
        <aui:input name="otp" label="Enter OTP" type="text" required="true" />
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Verify OTP" />
    </aui:button-row>
</aui:form>

<liferay-ui:success key="otpStatus" message="✅ OTP verified successfully!" />
<liferay-ui:error key="otpError" message="❌ Invalid OTP. Please try again." />
