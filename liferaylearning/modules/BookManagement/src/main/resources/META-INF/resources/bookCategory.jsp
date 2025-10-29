
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.ats.books.model.Books" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/init.jsp" %>
<portlet:defineObjects />

<!-- USED RENDER URL -->
<h2>Book Category List</h2>


<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>


<h4>Using custom fields</h4>
<%
    User currentUser = PortalUtil.getUser(request);
    String bloodGroup = "";
    if (currentUser != null) {
        Object value = currentUser.getExpandoBridge().getAttribute("bloodGroup");
        bloodGroup = (value != null) ? value.toString() : "Not Set";
    }
%>

<p><strong>Blood Group:</strong> <%= bloodGroup %></p>


<portlet:renderURL var="addCategoryURL">
    <portlet:param name="mvcRenderCommandName" value="/bookcategory/add" />
</portlet:renderURL>

<a href="${addCategoryURL}" class="btn btn-primary">Add Category</a><br/><br/>

<%
    Map<Long, String> bookMap = new HashMap<>();
    List<Books> booksList = com.ats.books.service.BooksLocalServiceUtil.getBookses(-1, -1);
    for (Books book : booksList) {
        bookMap.put(book.getBookId(), book.getTitle());
    }
    request.setAttribute("bookMap", bookMap);
%>

<table class="table table-bordered">
    <thead>
        <tr>
            <th>Book ID</th>
            <th>Category ID</th>
            <th>User Name</th>
            <th>Create Date</th>
            <th>Modified Date</th>
            <th>Category Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="category" items="${bookCategories}">
            <tr>
                <td>${category.bookId}</td>
                <td>${category.categoryId}</td>
                <td>${category.userName}</td>
                <td><fmt:formatDate value="${category.createDate}" pattern="yyyy-MM-dd" /></td>
                <td><fmt:formatDate value="${category.modifiedDate}" pattern="yyyy-MM-dd" /></td>
                <td>${category.categoryName}</td>
                <td>
                    <portlet:renderURL var="editCategoryURL">
                        <portlet:param name="mvcRenderCommandName" value="/bookcategory/edit" />
                        <portlet:param name="categoryId" value="${category.categoryId}" />
                    </portlet:renderURL>
                    <a href="${editCategoryURL}" class="btn btn-warning btn-sm">Edit</a>
                </td>
                <td>
                    <portlet:actionURL name="/bookcategory/delete" var="deleteCategoryURL">
                        <portlet:param name="categoryId" value="${category.categoryId}" />
                    </portlet:actionURL>
                    <aui:button type="button" value="Delete"
                        onClick="if(confirm('Delete this category?')) { location.href='${deleteCategoryURL}'; }" />
                </td>
            </tr>
        </c:forEach>
    </tbody>
    
</table>
