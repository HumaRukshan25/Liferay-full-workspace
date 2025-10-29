<%@ page import="java.util.List" %>
<%@ page import="fironlineser.model.SignupUser" %>
<%@ include file="/init.jsp" %>


<style>
    h2 {
        font-weight: 600;
        margin-bottom: 20px;
        color: #2c3e50;
    }

    /* Scrollable container */
    .table-container {
        max-width: 100%;
        overflow-x: auto;
    }

    .table {
        min-width: 900px; /* force proper width */
        border-collapse: collapse;
        background: #fff;
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        border-radius: 8px;
        overflow: hidden;
        font-size: 13px; /* smaller font */
    }

    .table thead {
        background: #007bff;
        color: white;
        text-align: center;
    }

    .table thead th {
        padding: 8px;
        font-size: 13px;
        white-space: nowrap;
    }

    .table tbody tr:hover {
        background: #f2f9ff;
    }

    .table tbody td {
        padding: 6px 8px;
        text-align: center;
        color: #333;
        white-space: nowrap; /* prevent wrapping */
    }

    .btn {
        padding: 4px 8px;
        border-radius: 5px;
        font-size: 12px;
    }

    .btn-primary {
        background: #007bff;
        border: none;
    }

    .btn-primary:hover {
        background: #0056b3;
    }

    .btn-danger {
        background: #dc3545;
        border: none;
    }

    .btn-danger:hover {
        background: #a71d2a;
    }

    .aui-button {
        margin-right: 10px;
    }
</style>

<h2>Manage Users</h2>

<aui:button-row>
    <portlet:renderURL var="addUserURL">
        <portlet:param name="mvcRenderCommandName" value="/admin/addUser" />
    </portlet:renderURL>
    <aui:button type="button" value="Add User" onClick="location.href='${addUserURL}'" />

    <portlet:renderURL var="adminDashboardURL">
        <portlet:param name="mvcRenderCommandName" value="/dashboard" />
    </portlet:renderURL>
    <aui:button type="button" value="Back to Dashboard" onClick="location.href='${adminDashboardURL}'" />
</aui:button-row>


<div class="table-container">
<table class="table table-bordered table-striped">
    <thead>
        <tr>
            <th>User ID</th>
            <th>Login Name</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Role</th>
            <th>Active</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.signupUserId}</td>
                <td>${user.loginName}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.phoneNo}</td>
                <td>${user.role}</td>
                <td><c:choose>
                        <c:when test="${user.active}">Yes</c:when>
                        <c:otherwise>No</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <!-- Edit -->
                    <portlet:renderURL var="editUserURL">
                        <portlet:param name="mvcRenderCommandName" value="/admin/editUser" />
                        <portlet:param name="userId" value="${user.signupUserId}" />
                    </portlet:renderURL>
                    <a href="${editUserURL}" class="btn btn-primary">Edit</a>

                    <!-- Delete -->
                    <portlet:actionURL name="/admin/deleteUser" var="deleteUserURL">
                        <portlet:param name="userId" value="${user.signupUserId}" />
                    </portlet:actionURL>
                    <aui:button type="button" value="Delete"
                        onClick="if(confirm('Are you sure?')) window.location.href='${deleteUserURL}'" />
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
