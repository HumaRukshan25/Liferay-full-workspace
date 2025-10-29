<%@ include file="/init.jsp" %>

<portlet:actionURL name="/password/forgot" var="forgotPasswordActionURL" />

<div class="container">
    <h2>Forgot Password</h2>
    
    <p>Enter your email address and we'll send you a password reset link.</p>
    
    <aui:form action="<%= forgotPasswordActionURL %>" method="post" name="forgotPasswordForm">
        <aui:input name="email" label="Email Address" type="email" required="true">
            <aui:validator name="email" />
        </aui:input>
        
        <aui:button type="submit" value="Send Reset Link" />
    </aui:form>
    
    <c:if test="${not empty resetLinkSent}">
        <div class="alert alert-success">
            A password reset link has been sent to your email address.
        </div>
    </c:if>
    
    <c:if test="${not empty resetError}">
        <div class="alert alert-danger">
            ${resetError}
        </div>
    </c:if>
    
    <portlet:renderURL var="loginURL">
        <portlet:param name="mvcPath" value="/view.jsp" />
    </portlet:renderURL>
    
    <p><a href="<%= loginURL %>">Back to Login</a></p>
</div>