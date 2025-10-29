
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="/init.jsp" %>



<h2>Edit Book</h2>

<portlet:actionURL name="/books/edit" var="editURL" />

<aui:form action="${editURL}" method="post">
    <aui:input name="bookId" type="hidden" value="${book.bookId}" />
    <aui:input name="title" label="Title" value="${book.title}" />
    <!-- <aui:input name="author" label="Author" value="${book.author}" /> -->
    
  
    
     <aui:select name="author" label="liferay Author role for a user "  value="${book.author}" id="userSelect">
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
    <aui:input name="publishDate" type="date" label="Publish Date" value="${publishDateStr}" />
    <aui:button type="submit" value="Update" />
</aui:form>

