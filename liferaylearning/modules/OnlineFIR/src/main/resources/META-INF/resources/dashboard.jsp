<%@ include file="/init.jsp" %>

<h2>Welcome Admin</h2>
<p>You have successfully logged in to the Admin Dashboard!</p>



<div class="admin-options">
    <h3>Admin Functions:</h3>
    <ul>
        <li>
            <portlet:renderURL var="viewAllFIRsURL">
                <portlet:param name="mvcRenderCommandName" value="/admin/viewAllFIRs" />
            </portlet:renderURL>
            <a href="${viewAllFIRsURL}">View All FIRs</a>
        </li>

        <li>
            <portlet:renderURL var="manageUsersURL">
                <portlet:param name="mvcRenderCommandName" value="/admin/manageUsers" />
            </portlet:renderURL>
            <a href="${manageUsersURL}">Manage Users</a>
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

<aui:button-row>
    <portlet:renderURL var="adminLogoutURL">
        <portlet:param name="mvcRenderCommandName" value="/admin/logout" />
    </portlet:renderURL>
    <aui:button type="button" value="Logout" onClick="location.href='${adminLogoutURL}'" />
</aui:button-row>