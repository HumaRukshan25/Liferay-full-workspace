<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.ats.books.model.Books" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/init.jsp" %>

<portlet:defineObjects />
<!-- 1. for learning dynamic query -->
<portlet:actionURL var="filterBooksActionURL" name="/books/filterBooks" />



<%
    String titleValue = (String) request.getAttribute("title");
    String sortValue = (String) request.getAttribute("sortColumn");
    List<Books> bookList = (List<Books>) request.getAttribute("bookList");
%>

<h2>Search and Sort Books</h2>

<aui:form method="post" action="${filterBooksActionURL}">
    <aui:input name="title" label="Search by Title" value="<%= titleValue != null ? titleValue : "" %>" />

    <aui:select name="sortColumn" label="Sort by">
        <aui:option value="">-- Select --</aui:option>
        <aui:option value="title" selected="<%= "title".equals(sortValue) %>">Title</aui:option>
        <aui:option value="author" selected="<%= "author".equals(sortValue) %>">Author</aui:option>
    </aui:select>

    <aui:button type="submit" value="Search" />
</aui:form>

<br/>

<%
    if (bookList != null && !bookList.isEmpty()) {
%>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <tr>
                <th>Title <%= "title".equals(sortValue) ? "(sortedbytitle)" : "" %></th>
                <th>Author <%= "author".equals(sortValue) ? "(sortedbyauthor)" : "" %></th>
            </tr>
        </thead>
        <tbody>
            <% for (Books book : bookList) { %>
                <tr>
                    <td><%= book.getTitle() %></td>
                    <td><%= book.getAuthor() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
<% } else if (bookList != null) { %>
    <p>No books found.</p>
<% } %>
