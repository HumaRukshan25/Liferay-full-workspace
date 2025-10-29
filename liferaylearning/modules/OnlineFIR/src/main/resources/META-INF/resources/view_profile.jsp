<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>My Profile</h2>

<c:if test="${not empty userProfile}">
    <div style="border:1px solid #ccc; padding:15px; border-radius:8px; width:400px; background:#f9f9f9;">
        <p><strong>Full Name:</strong> ${userProfile.fullName}</p>
        <p><strong>Email:</strong> ${userProfile.emailAddress}</p>
        <p><strong>Screen Name:</strong> ${userProfile.screenName}</p>
        <p><strong>User ID:</strong> ${userProfile.userId}</p>
        <p><strong>Last Login:</strong> ${userProfile.lastLoginDate}</p>

        <!-- Display Role instead of Job Title -->
        <c:if test="${not empty userRoles}">
            <p><strong>Role:</strong> 
                <c:forEach var="role" items="${userRoles}" varStatus="status">
                    ${role.name}<c:if test="${!status.last}">, </c:if>
                </c:forEach>
            </p>
        </c:if>

        <c:if test="${not empty addresses}">
            <hr>
            <h4>Address Details</h4>
            <c:forEach var="addr" items="${addresses}">
                <p><strong>Street:</strong> ${addr.street1}</p>
                <p><strong>City:</strong> ${addr.city}</p>
                <p><strong>Postal Code:</strong> ${addr.zip}</p>
                <p><strong>Country:</strong> ${addr.country.name}</p>
                <hr>
            </c:forEach>
        </c:if>

        <!-- Edit button -->
        <portlet:renderURL var="editProfileURL">
            <portlet:param name="mvcRenderCommandName" value="/editProfile" />
        </portlet:renderURL>

        <button 
            style="background-color:#2196F3; color:white; padding:8px 15px; border:none; border-radius:5px; cursor:pointer;"
            onclick="location.href='${editProfileURL}'">
            Edit Profile
        </button>
    </div>
</c:if>

<c:if test="${empty userProfile}">
    <p>No user information available.</p>
</c:if>
