<%@ include file="/init.jsp" %>

<%
    // Use a different variable name to avoid conflict with Liferay's session
    HttpSession userSession = request.getSession();
    String email = (String) userSession.getAttribute("pendingUserEmail");
    String storedOtp = (String) userSession.getAttribute("pendingOTP");
%>

<h2>Enter OTP</h2>

<%-- Display debug info --%>
<p>Debug: Email in session: <%= email %></p>
<p>Debug: Stored OTP in session: <%= storedOtp %></p>

<%-- Display OTP errors if any --%>
<%
String otpError = (String) request.getAttribute("otpError");
if (otpError != null) {
%>
<div style="border:1px solid red; padding:10px; background:#ffe6e6;">
    <strong>Error:</strong> <%= otpError %>
</div>
<% } %>

<%-- Method 1: Using AUI Form (Recommended) --%>
<portlet:actionURL name="/user/verifyOtp" var="verifyOtpURL" />

<aui:form action="<%= verifyOtpURL %>" method="post" name="otpForm">
    <aui:input type="hidden" name="email" value="<%= email %>" />
    <aui:input name="otp" label="OTP Code" required="true" />
    <aui:button type="submit" value="Verify OTP" />
</aui:form>

<%-- Method 2: Using Portlet Form with correct encoding --%>
<portlet:actionURL name="/user/verifyOtp" var="verifyOtpURL2" />

<form action="<%= verifyOtpURL2 %>" method="post" name="otpForm2">
    <input type="hidden" name="<portlet:namespace />email" value="<%= email %>" />
    <label>OTP:</label>
    <input type="text" name="<portlet:namespace />otp" required />
    <button type="submit">Verify OTP</button>
</form>

<%-- Method 3: Debug form to see what's being submitted --%>
<portlet:actionURL name="/user/verifyOtp" var="verifyOtpURL3" />

<form action="<%= verifyOtpURL3 %>" method="post" id="debugForm">
    <input type="hidden" name="email" value="<%= email %>" />
    <label>OTP:</label>
    <input type="text" name="otp" id="otpInput" required />
    <button type="button" onclick="submitDebugForm()">Verify OTP (Debug)</button>
</form>

<script>
function submitDebugForm() {
    var otpValue = document.getElementById('otpInput').value;
    console.log('Submitting OTP:', otpValue);
    document.getElementById('debugForm').submit();
}
</script>