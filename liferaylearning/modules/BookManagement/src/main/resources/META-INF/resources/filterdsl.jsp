
<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ats.books.model.Books" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />


<!-- 2. for learning dsl query -->
<portlet:actionURL var="dslSearchURL" name="/books/filterdslAction" />

<aui:form action="${dslSearchURL}" method="post">
    <aui:input name="keyword" label="Enter Book Title" />
    <aui:button type="submit" value="Search" />
</aui:form>

<%
    List<Books> filteredBooks = (List<Books>) request.getAttribute("filteredBooks");
    String keyword = (String) request.getAttribute("keyword");
%>

<% if (filteredBooks != null && !filteredBooks.isEmpty()) { %>
    <h3>Books Matching: "<%= keyword %>"</h3>
    <ul>
        <% for (Books book : filteredBooks) { %>
            <li><strong>Title:</strong> <%= book.getTitle() %> |
                <strong>Author:</strong> <%= book.getAuthor() %></li>
        <% } %>
    </ul>
<% } else if (filteredBooks != null) { %>
    <p>No books found for "<%= keyword %>".</p>
<% } %>
