
<%@page import="com.ats.books.model.Books"%>
<%@page import="java.util.List"%>
<%@ include file="/bookCategory.jsp" %>

<!-- USED ACTION URL -->

<%
    List<Books> books = com.ats.books.service.BooksLocalServiceUtil.getBookses(-1, -1);
    request.setAttribute("books", books);
%>

<portlet:actionURL name="/bookcategory/add" var="addCategoryURL" />
<aui:form action="${addCategoryURL}" method="post">

    <aui:select name="bookId" label="Select Book" required="true">
        <aui:option value="">-- Select Book --</aui:option>
        <c:forEach var="book" items="${books}">
            <aui:option value="${book.bookId}">${book.bookId}</aui:option>
        </c:forEach>
    </aui:select>

    <aui:input name="categoryName" label="Category Name" required="true" />
    <aui:input name="categoryCode" label="Category Code" required="true" />
    <aui:input name="description" label="Description" />
    <aui:input name="createdBy" label="Created By" />
    <aui:input name="department" label="Department" />

    <aui:select name="status" label="Status">
        <aui:option value="Active">Active</aui:option>
        <aui:option value="Inactive">Inactive</aui:option>
    </aui:select>

    <aui:button type="submit" value="Submit" />
</aui:form>
