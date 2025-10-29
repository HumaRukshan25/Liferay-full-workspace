<%@page import="javax.portlet.PortletURL"%>
<%@ page contentType="text/html; charset=UTF-8" %>



<%@ include file="/init.jsp" %>

<%@ page import="java.util.*" %>
<%@ page import="PracticeService1.model.CheckInOutApp" %>
<%@ page import="PracticeService1.service.CheckInOutAppLocalServiceUtil" %>

<portlet:defineObjects />

<%
    Long userId = (Long) renderRequest.getPortletSession().getAttribute("loggedInUserId");

    if (userId == null) {
        PortletURL loginURL = renderResponse.createRenderURL();
        loginURL.setParameter("mvcPath", "/login.jsp");
%>
    <p>User not logged in. <a href="<%= loginURL.toString() %>">Login here</a></p>
<%
    } else {
        List<CheckInOutApp> logs = CheckInOutAppLocalServiceUtil.getCheckInOutApps(-1, -1);
        CheckInOutApp latestLog = null;

        for (int i = logs.size() - 1; i >= 0; i--) {
            CheckInOutApp log = logs.get(i);
            if (log.getUserId() == userId) {
                latestLog = log;
                break;
            }
        }
%>
    <h2>Welcome, User ID: <%= userId %></h2>

    <% if (latestLog != null) { %>
        <p><strong>Check-In Time:</strong> <%= latestLog.getCheckInTime() %></p>
        <p><strong>Check-Out Time:</strong> 
            <%= latestLog.getCheckOutTime() != null ? latestLog.getCheckOutTime() : "Not yet checked out" %>
        </p>
    <% } else { %>
        <p>No logs found for you.</p>
    <% } %>

    <aui:form action="<%= renderResponse.createActionURL() %>" method="post">
        <aui:input type="hidden" name="javax.portlet.action" value="/logoutUser" />
        <aui:button type="submit" value="Check-Out" />
    </aui:form>
<%
    }
%>
