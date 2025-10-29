
<%@page import="com.ats.books.model.Books"%>
<%@page import="java.util.List"%>
<%@ include file="/bookCategory.jsp" %>

<%
    List<Books> books = com.ats.books.service.BooksLocalServiceUtil.getBookses(-1, -1);
    request.setAttribute("books", books);
%>

<portlet:actionURL name="/bookcategory/edit" var="editCategoryURL" />
<aui:form action="${editCategoryURL}" method="post">

    <aui:input name="categoryId" type="hidden" value="${category.categoryId}" />

    <aui:select name="bookId" label="Select Book" required="true">
        <aui:option value="">-- Select Book --</aui:option>
        <c:forEach var="book" items="${books}">
            <c:choose>
                <c:when test="${book.bookId == category.bookId}">
                    <aui:option value="${book.bookId}" selected="selected">${book.bookId}</aui:option>
                </c:when>
                <c:otherwise>
                    <aui:option value="${book.bookId}">${book.bookId}</aui:option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </aui:select>

    <aui:input name="categoryName" label="Category Name" value="${category.categoryName}" />
  




    <aui:button type="submit" value="Update" />
</aui:form>
