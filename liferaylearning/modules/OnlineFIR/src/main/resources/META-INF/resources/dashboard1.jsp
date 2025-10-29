<%@ include file="/init.jsp" %>

<div class="admin-dashboard">
    <h2>Welcome Admin</h2>
    <p>You have successfully logged in to the Admin Dashboard!</p>

    <div class="admin-options">
        <h3>Admin Functions:</h3>
        <ul>
            <li>
                <portlet:renderURL var="stationManagementURL">
                    <portlet:param name="mvcRenderCommandName" value="/admin/stationManagement" />
                </portlet:renderURL>
                <a href="${stationManagementURL}">Station Management</a>
            </li>

            <li>
                <portlet:renderURL var="viewAllFIRsURL">
                    <portlet:param name="mvcRenderCommandName" value="/admin/viewAllFIRs" />
                </portlet:renderURL>
                <a href="${viewAllFIRsURL}">View All FIRs</a>
            </li>

            <li>
                <portlet:renderURL var="manageUsersURL1">
                    <portlet:param name="mvcRenderCommandName" value="/admin/manageUsers1" />
                </portlet:renderURL>
                <a href="${manageUsersURL1}">Manage Users</a>
            </li>

            <li>
                <portlet:renderURL var="generateReportsURL">
                    <portlet:param name="mvcRenderCommandName" value="/admin/generateReports" />
                </portlet:renderURL>
                <a href="${generateReportsURL}">Generate Reports</a>
            </li>

            <li>
                <portlet:renderURL var="systemSettingsURL">
                    <portlet:param name="mvcRenderCommandName" value="/admin/systemSettings" />
                </portlet:renderURL>
                <a href="${systemSettingsURL}">System Settings</a>
            </li>
        </ul>
    </div>

    <aui:button type="button" value="Logout" onClick="location.href='/c/portal/logout';" />
</div>

<style>
/* ===== Scoped CSS for Admin Dashboard ===== */
.admin-dashboard {
    font-family: Arial, sans-serif;
    background-color: #f4f6f9;
    color: #333;
    margin: 20px;
    padding: 20px;
    border-radius: 10px;
}

/* Headings */
.admin-dashboard h2 {
    color: #2c3e50;
    margin-bottom: 10px;
    text-align: center;
}

.admin-dashboard h3 {
    color: #34495e;
    margin-bottom: 15px;
    text-align: center;
}

/* Paragraph styling */
.admin-dashboard p {
    font-size: 16px;
    margin-bottom: 20px;
    text-align: center;
}

/* Admin options container */
.admin-dashboard .admin-options {
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    max-width: 600px;
    margin: 0 auto 20px auto;
}

/* Admin options list */
.admin-dashboard .admin-options ul {
    list-style: none;
    padding: 0;
    margin: 0;
}

.admin-dashboard .admin-options ul li {
    margin-bottom: 15px;
    text-align: center;
}

/* Links styling */
.admin-dashboard .admin-options ul li a {
    text-decoration: none;
    color: #fff;
    background-color: #007bff;
    padding: 10px 15px;
    border-radius: 5px;
    display: inline-block;
    transition: background-color 0.3s ease;
    font-weight: bold;
    width: 80%;
}

.admin-dashboard .admin-options ul li a:hover {
    background-color: #0056b3;
}

/* Logout button styling */
.admin-dashboard aui\\:button {
    background-color: #e74c3c !important;
    color: #fff !important;
    border: none !important;
    padding: 10px 20px !important;
    border-radius: 5px !important;
    cursor: pointer;
    font-size: 16px !important;
    transition: background-color 0.3s ease;
    display: block;
    margin: 0 auto;
}

.admin-dashboard aui\\:button:hover {
    background-color: #c0392b !important;
}

/* Responsive design */
@media (max-width: 768px) {
    .admin-dashboard .admin-options {
        max-width: 100%;
        padding: 15px;
    }

    .admin-dashboard .admin-options ul li a {
        display: block;
        width: 100%;
    }
}
</style>
