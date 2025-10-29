<%@ include file="/init.jsp" %>

<portlet:renderURL var="editEntryURL">
    <portlet:param name="mvcPath" value="/addBooks.jsp" />
</portlet:renderURL>

<portlet:renderURL var="renderCmdURL">
    <portlet:param name="mvcRenderCommandName" value="/myfirst/addData" />
</portlet:renderURL>

<a href="<%= editEntryURL.toString() %>">Add Book (Direct JSP)</a><br/>
<a href="<%= renderCmdURL.toString() %>">Render Add Book (MVCRenderCommand)</a><br/>

<p><%= String.valueOf(request.getAttribute("myString")) %></p>
