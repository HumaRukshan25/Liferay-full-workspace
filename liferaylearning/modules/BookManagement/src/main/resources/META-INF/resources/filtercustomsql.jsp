<%@ page import="com.ats.books.model.Books" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<portlet:defineObjects />

<h2>Filtered Books</h2>
<c:if test="${not empty filteredBooks}">
    <ul>
        <c:forEach var="book" items="${filteredBooks}">
            <li>${book.title}</li>
        </c:forEach>
    </ul>
</c:if>
