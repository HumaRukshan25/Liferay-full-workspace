


<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.ats.books.service.BooksLocalServiceUtil"%>

<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>

<%@page import="java.util.HashSet"%>



<%@ page import="com.ats.books.model.Books" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/init.jsp" %>



<h1>--Book List--</h1>

<!-- USED RENDER URL -->
    
<!-- ----------ADD BOOK FROM HERE----------------- -->   

<portlet:renderURL var="addBookURL">
    <portlet:param name="mvcRenderCommandName" value="/books/add" />
</portlet:renderURL>

<a href="${addBookURL}" class="btn btn-primary">Add Book</a><br/><br/>

<table class="table table-bordered">
    <thead>
        <tr><th>BookId</th><th>Title</th><th>Author</th><th>Publish Date</th><th>Edit</th><th>Delete</th></tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
            <td>${book.bookId}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
              
                <td><fmt:formatDate value="${book.publishDate}" pattern="yyyy-MM-dd" /></td>
                
                <td>
                    <portlet:renderURL var="editBookURL">
                        <portlet:param name="mvcRenderCommandName" value="/books/edit" />
                        <portlet:param name="bookId" value="${book.bookId}" />
                    </portlet:renderURL>
                  

                    <a href="${editBookURL}" class="btn btn-warning btn-sm">Edit</a>
                    
                     </td>
                     
                      <td>
                      <portlet:actionURL name="/books/delete" var="deleteBookURL">
                        <portlet:param name="bookId" value="${book.bookId}" />
                    </portlet:actionURL>
                    <aui:form>
                        <aui:button type="button" value="Delete"
                            onClick="if(confirm('Delete this book?')) { location.href='${deleteBookURL}'; }" />
                    </aui:form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- ---BOOK category  Table----- -->
<portlet:renderURL var="viewBookCategoryURL">
    <portlet:param name="mvcRenderCommandName" value="/bookcategory/view" />
</portlet:renderURL>

<a href="${viewBookCategoryURL}" class="btn btn-success">Manage Book Categories</a>


<!-- -----FOO Table--------------- -->
<portlet:renderURL var="viewFooURL">
    <portlet:param name="mvcRenderCommandName" value="/foo/view" />
</portlet:renderURL>

<a href="${viewFooURL}" class="btn btn-info" >Manage Foo Records</a>





<!--------FILTER BOOKS USING DYNAMIC QUERY--- -->
<portlet:renderURL var="filterBooksURL">
    <portlet:param name="mvcRenderCommandName" value="/books/viewFiltered" />
</portlet:renderURL>

<a href="${filterBooksURL}" class="btn btn-primary" >filter books using Dynamic query</a>


<!--------FILTER BOOKS USING DSL --- -->
 <!-- FILTER BOOKS USING DSL QUERY-->


<portlet:renderURL var="filterBooksDSLURL">
    <portlet:param name="mvcRenderCommandName" value="/books/filterdslView" />
</portlet:renderURL>

<a href="${filterBooksDSLURL}" class="btn btn-warning">
    Filter Books using DSL Query
</a>


<!--------FILTER BOOKS USING custom sql--- -->
 <!-- FILTER BOOKS USING custom sql QUERY-->


<portlet:renderURL var="filterBookscustomSQL">
    <portlet:param name="mvcRenderCommandName" value="/books/filtersqlView" />
</portlet:renderURL>

<a href="${filterBookscustomSQL}" class="btn btn-secondary">
    Filter Books using Custom sql Query
</a>







<!-- ----liferay user with Author role from table -->
<aui:select name="author" label=" liferay user with Author role from table" id="userSelect">
<%
    // Step 1: Get all author names used in books
    List<Books> booksList = BooksLocalServiceUtil.getBookses(-1, -1);
    HashSet<String> bookAuthorNames = new HashSet<>();

    for (Books book : booksList) {
        bookAuthorNames.add(book.getAuthor().trim()); // assuming book.getAuthor() is full name
    }

    // Step 2: Get all Liferay users and match names
    List<User> allUsers = UserLocalServiceUtil.getUsers(-1, -1);

    for (User user1 : allUsers) {
        String userFullName = user1.getFullName().trim();

        if (bookAuthorNames.contains(userFullName)) {
%>
    <aui:option value="<%= user1.getUserId() %>"><%= userFullName %></aui:option>
<%
        }
    }
%>
</aui:select>


<!-- -------------all the users from liferay---------- -->
  <aui:select name="author" label="all the users from liferay" id="userSelect">
        <%
            java.util.List<User> allUsers = UserLocalServiceUtil.getUsers(-1, -1);
            for (User user1 : allUsers) {
        %>
        <!--  user1.getUserId()-->
           <aui:option value="<%=  user1.getFullName() %>"><%= user1.getFullName() %></aui:option>
        <%
            }
        %>
    </aui:select>
</h4>

<!-- ---------ALL THE ROLES WITH USER------------->
<!-- ----for pratice and learning below dropdown--- -->
<label for="roleUserSelect">Select User by Role:</label>
<select name="roleUserSelect" id="roleUserSelect" class="form-control" style="width: 300px;">
<%
    long companyId = PortalUtil.getDefaultCompanyId();
    String[] roleNames = {
        "Administrator",
        "Analytics Administrator",
        "Author",
        "Guest",
        "Owner",
        "Portal Content Reviewer",
        "Power User",
        "Publications User",
        "Supplier",
        "User"
    };

    for (String roleName : roleNames) {
        try {
            Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
            List<User> roleUsers = UserLocalServiceUtil.getRoleUsers(role.getRoleId());

            if (!roleUsers.isEmpty()) {
%>
    <optgroup label="<%= roleName %>">
<%
                for (User user : roleUsers) {
%>
        <option value="<%= user.getUserId() %>"><%= user.getFullName() %></option>
<%
                }
%>
    </optgroup>
<%
            }
        } catch (Exception e) {
         
        }
    }
%>
</select>


