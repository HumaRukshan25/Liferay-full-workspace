<%@ include file="/init.jsp" %>

<h2>Signup Verification Successful</h2>
<p>Welcome, <b>user</b>! You have successfully verified.</p>

<aui:button-row>
    <portlet:renderURL var="viewURL">
        <portlet:param name="mvcPath" value="/view.jsp" />
    </portlet:renderURL>

    <aui:button 
        type="button" 
        value="Go Back to Login" 
        onClick="location.href='<%= viewURL %>';" 
    />
</aui:button-row>
