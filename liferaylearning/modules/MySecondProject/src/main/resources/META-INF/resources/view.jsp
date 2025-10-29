<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%@ page contentType="text/html; charset=UTF-8" %>
<%
   // Redirect before any HTML is written
   response.sendRedirect("anotherPage.jsp?name=Huma");
%>

<p>
	<b><liferay-ui:message key="mysecondproject.caption"/></b>
</p>
<!-- /* for learning */ -->
<%
String name = "Huma";
/* for learning */
// for learning
%>
<h4>Hi, I am <%= name %></h4>


<%
request.setAttribute("name", "HumaR");
%>

<h4>Hi, I am ${name}</h4>

<%
    int a = 5, b = 10;
    System.out.println("Sum: " + (a + b));
%>

<%! int counter = 0; %>
<%= ++counter %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="name" value="Huma" />
<p>Hello, ${name}!</p>


<%
    session.setAttribute("username", "Huma");
    out.println(session.getAttribute("username"));
%>




