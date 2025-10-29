<%@ include file="/init.jsp" %>
<h1>Welcome to My Book Page</h1>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcRenderCommandName" value="/book/view" />
</portlet:renderURL>

<a href="${viewURL}">Back to Book List</a>
