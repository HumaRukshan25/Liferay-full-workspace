<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@ include file="./init.jsp"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.model.Address"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<portlet:renderURL var="registerAgentURL">
	<portlet:param name="jspPage" value="/Agent/agent-registration.jsp" />
</portlet:renderURL>

<c:if
	test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, REG_AGENT_FORM)}">

<a href="<%= registerAgentURL%>" class="btn btn-success mb-4"><i class="fa-solid fa-user-plus"></i>Add-Agent</a>
</c:if>
<% 


List<User> users = (List<User>) request.getAttribute("users"); 
PortletURL informationRenderURL = renderResponse.createRenderURL();
informationRenderURL.setParameter("jspPage", "/Agent/agent-info.jsp");
%>
<c:if
	test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, AGENT_LIST)}">
<%-- Check if there are users --%>

<% if (users != null && !users.isEmpty()) { %>
<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Profile Image</th>
				<!-- <th>User ID   this primary key</th> --> 
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Address</th>
				<th>Roles</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<% for (User user1 : users) { %>
			<tr class="user-row" data-user-id="<%= user1.getUserId() %>">
				<td>
					<% 
                        // Fetch user's profile image (portrait) URL
                        long portraitId = user1.getPortraitId();
                        String imageUrl = "/api/secure/user_portrait?img_id=" + portraitId; 
                        if (portraitId != 0) { 
                    %> <img
					src="<%= user1.getPortraitURL(themeDisplay) %>"
					alt="<%= user1.getFullName() %>'s Image"
					class="rounded-circle profile-img" width="50" height="50" /> <% 
                        } else {
                    %> <img
					src="<%= themeDisplay.getPathThemeImages() %>/common/user-avatar-default.png"
					alt="<%= user1.getFullName() %>'s Image"
					class="rounded-circle profile-img" width="50" height="50" /> <% 
                        }
                    %>
				</td>
				<%-- <td><%= user1.getUserId() %></td> --%>
				<td><%= user1.getFirstName() %></td>
				<td><%= user1.getLastName() %></td>
				<td><%= user1.getEmailAddress() %></td>
				<td>
					<% 
                        long[] roleIds = user1.getRoleIds();
                        Set<String> roleNames = new HashSet<>();  

                        if (roleIds != null && roleIds.length > 0) {
                            for (long roleId : roleIds) {
                                Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Agent"); 
                                roleNames.add(role.getName());
                            }

                            for (String roleName : roleNames) {
                                out.print(roleName + " ");
                            }
                        } else {
                            out.print("No roles assigned");
                        }
                    %>
				</td>
				<td>
					<%
				informationRenderURL.setParameter("userId", String.valueOf(user1.getUserId()));
			  %>  <a href="<%= informationRenderURL %>"
					class="">  <i class="fas fa-eye fs-4 text-info"></i></a>
					
					<portlet:actionURL name="DeleteUser" var="DeleteUserActionURL">
						<portlet:param name="userId" value="<%=String.valueOf(user1.getUserId())%>" />
				</portlet:actionURL>
				
				<a href="${DeleteUserActionURL}"
				class=" "
				onclick="return confirm('Are you sure you want to delete this item?');">
				 <i class="fas fa-trash-alt fs-4 text-danger"></i>
				</a>
					</td>
			</tr>
			<% } %>
		</tbody>
	</table>
</div>
<% } else { %>
<p class="error-message">Sorry Not Allowed in Agent List</p>
<% } %>
</c:if>
<style>
h2.portlet-title-text.portlet-title-editable {
    display: none;
}
.error-message {
  font-weight: bold; /* Makes the text bold */
  font-style: italic; /* Makes the text italic */
  color: #d9534f; /* Sets the color to a shade of red */
  font-size: 16px; /* Sets a default font size */
  transition: color 0.3s ease, transform 0.3s ease; /* Adds transition for hover effect */
}

.error-message:hover {
  color: #c9302c; /* Darker red color on hover */
  transform: scale(1.05); /* Slight zoom effect on hover */
}
/* General Table Styling */
table.table-striped {
	width: 100%;
	border-collapse: collapse;
}

/* Shared borders for table cells */
table.table-striped th, table.table-striped td {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
	font-size: 14px;
}

/* Alternate row background colors (striped effect) */
table.table-striped tbody tr:nth-child(odd) {
	background-color: #f9f9f9;
}

table.table-striped tbody tr:nth-child(even) {
	background-color: #ffffff;
}

/* Row hover effect */
table.table-striped tbody tr:hover {
	background-color: #e9f7ff;
	cursor: pointer;
}

/* Profile image hover effect: Increase size and pointer cursor */
.profile-img {
	transition: all 0.3s ease-in-out;
}

.user-row:hover .profile-img {
	transform: scale(1.2); /* Image enlarges on hover */
	cursor: pointer; /* Pointer cursor to show it's interactive */
}

/* Row background highlight on hover */
.user-row:hover td {
	background-color: #f1f1f1;
}

/* Styling for the button */
button.btn {
	margin-top: 5px;
	font-size: 12px;
}

/* Ensure font consistency across rows and columns */
table.table-striped td, table.table-striped th {
	font-size: 14px;
}

/* Hover effect for the entire row */
.user-row:hover {
	background-color: #e9f7ff;
}

/* Optional: If you want a detailed user card (can be hidden and shown dynamically) */
.user-card {
	position: absolute;
	top: 0;
	right: 0;
	width: 300px;
	background: white;
	border: 1px solid #ccc;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 10px;
	display: none;
	z-index: 10;
	font-size: 14px;
}

.user-card img {
	width: 60px;
	height: 60px;
	border-radius: 50%;
}

.user-row:hover .user-card {
	display: block;
}
</style>
