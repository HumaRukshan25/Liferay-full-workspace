<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Edit My Profile</h2>

<c:if test="${not empty userProfile}">
    <portlet:actionURL var="updateProfileURL" name="/police/updateProfile" />

    <aui:form action="${updateProfileURL}" method="post" name="editProfileForm">
        <aui:input type="hidden" name="userId" value="${userProfile.userId}" />

        <div style="border:1px solid #ccc; padding:20px; border-radius:8px; width:450px; background:#f9f9f9;">
            <aui:input name="firstName" label="First Name" value="${userProfile.firstName}" required="true" />
            <aui:input name="lastName" label="Last Name" value="${userProfile.lastName}" required="true" />
            <aui:input name="emailAddress" label="Email Address" value="${userProfile.emailAddress}" required="true" />
            <aui:input name="screenName" label="Screen Name" value="${userProfile.screenName}" />

            <aui:button-row>
                <aui:button type="submit" value="Save Changes" cssClass="btn btn-success" />
                <portlet:renderURL var="backURL">
                    <portlet:param name="mvcRenderCommandName" value="/police/viewProfile" />
                </portlet:renderURL>
                <aui:button type="button" value="Cancel" onClick="location.href='${backURL}'" cssClass="btn btn-secondary" />
            </aui:button-row>
        </div>
    </aui:form>
</c:if>

<c:if test="${empty userProfile}">
    <p>No profile data available.</p>
</c:if>
