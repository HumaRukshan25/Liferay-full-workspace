<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="/init.jsp" %> 

 <!--
<h2>Add Book</h2>
<portlet:actionURL name="/books/add" var="addURL" />

<aui:form action="${addURL}" method="post">
    <aui:input name="title" label="Title" required="true" />
    <aui:input name="author" label="Author" />
    <aui:input name="publishDate" type="date" label="Publish Date" required="true" />
    <aui:button type="submit" value="Submit" />
</aui:form>-->



<h2>Add Book</h2>
<portlet:actionURL name="/books/add" var="addURL" />

<aui:form action="${addURL}" method="post">
    <aui:input name="title" label="Title" required="true" />
    <!-- User Dropdown -->

   
    
   <aui:select name="author" label="in liferay Author role given for users " id="userSelect">
    <%
        try {
            long companyId = PortalUtil.getDefaultCompanyId(); // No themeDisplay

            Role authorRole = RoleLocalServiceUtil.getRole(companyId, "Author");
            List<User> authorUsers = UserLocalServiceUtil.getRoleUsers(authorRole.getRoleId());

            for (User user : authorUsers) {
    %>
                <aui:option value="<%= user.getFullName() %>"><%= user.getFullName() %></aui:option>
    <%
            }
        } catch (Exception e) {
            out.println("Error fetching Author users: " + e.getMessage());
        }
    %>
</aui:select>



 
    
    <aui:input name="publishDate" type="date" label="Publish Date" required="true" />
    <aui:button type="submit" value="Submit" />
</aui:form>