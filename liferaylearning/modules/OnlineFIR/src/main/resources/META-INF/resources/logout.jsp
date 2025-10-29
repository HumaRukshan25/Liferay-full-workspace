<%@ include file="/init.jsp" %>
<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>
