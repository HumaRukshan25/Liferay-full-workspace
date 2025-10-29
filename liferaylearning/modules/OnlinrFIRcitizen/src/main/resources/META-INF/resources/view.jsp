<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="onlinrfircitizen.caption"/></b>
</p>




<h2>Enter OTP for loginn</h2>
<p>Please check your email for the OTP and enter it below:</p>
 
 
 <!-- // this is for default admin to verify otpp-->
<portlet:actionURL name="/otp/verify" var="verifyOtpURL" />

<portlet:actionURL name="/otp/resend" var="resendOtpURL" />

<aui:form action="<%= verifyOtpURL %>" method="post" name="verifyOtpForm">
    <aui:fieldset>
        <aui:input name="otp" label="Enter OTP" type="text" required="true" />
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Verify OTP" />
       
        
     
        <aui:button type="button" value="Back to Login" onClick="location.href='/c/portal/login';" />
 
    <aui:button type="button" value="Logout" onClick="location.href='/c/portal/logout';" />
 <!-- Resend OTP button -->
 
    
</aui:button-row>
</aui:form>



<!-- 

<div class="text-center mt-3">
    <a href="http://localhost:8080/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fcreate_account&saveLastPath=false" class="btn btn-sm btn-outline-primary">
        <liferay-ui:message key="sign up user" />
    </a>
</div>


<aui:form action="<%= resendOtpURL %>" method="post">
    <aui:button type="submit" value="Resend OTP" onClick="this.disabled=true;" />
</aui:form>
 -->

<liferay-ui:success key="otpStatus" message="✅ OTP verified successfully!" />
<liferay-ui:error key="otpError" message="❌ Invalid OTP. Please try again." />











<br><br><br><br><br><br><br> <br><br><br><br><br><br><br> <br><br><br><!-- adds vertical space -->






<h2>User Login</h2>

<portlet:actionURL name="/admin/login" var="loginActionURL" />
<aui:form action="<%= loginActionURL %>" method="post" name="loginForm">
    <aui:input name="loginName" label="Username" type="text" required="true" />
    <aui:input name="password" label="Password" type="password" required="true" />
      <aui:select name="role" label="Select Role" required="true">
        <aui:option value="citizen" label="Citizen" />
        <aui:option value="police" label="Police" />
       <aui:option value="admin" label="Admin" /> 
    </aui:select>
    <aui:button type="submit" value="Login" />
</aui:form>

<c:if test="${not empty loginError}">
    <div class="alert alert-danger">
        ${loginError}
    </div>
</c:if>

<%-- Signup Link --%>
<portlet:renderURL var="signupURL">
    <portlet:param name="mvcPath" value="/signup.jsp" />
</portlet:renderURL>

<p>
    Dont have an account?
    <a href="<%= signupURL %>">Sign Up Here</a>
</p>



<%-- Forgot Password Link --%>
<portlet:renderURL var="forgotPasswordURL">
    <portlet:param name="mvcPath" value="/forgotPassword.jsp" />
</portlet:renderURL>

<p>

    Forgot your password?
    <a href="<%= forgotPasswordURL %>">Reset it here</a>
</p>
