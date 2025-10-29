
<%@page import="com.liferay.portal.kernel.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Phone"%>
<%@page import="com.liferay.portal.kernel.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.ListType"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="../init.jsp"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.model.Country"%>
<%@ page
	import="com.liferay.portal.kernel.service.CountryLocalServiceUtil"%>
<%@ page import="java.util.List"%>


<portlet:actionURL name="CreateContact" var="ContactURL"
	windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
	<portlet:param name="mvcRenderCommandName" value="/Agent" />
</portlet:actionURL>
<% 


    // Fetch userId parameter from request
    String userIdParam = request.getParameter("ContactuserId");
    User user2 = null;

    // Make sure userId is present
    if (userIdParam != null) {
        try {
            long userId = Long.parseLong(userIdParam);
            user2 = UserLocalServiceUtil.getUserById(userId);
            System.out.println("user Id is...." + userId);
        } catch (Exception e) {
            e.printStackTrace();  // Log exception if needed
        }
   
        // Fetch available phone types
        List<ListType> phoneTypes = ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.phone");
%>

<div class="card">
	<div class="card-header">
		<h5>
			Add Contact Details for
			<%= user2 != null ? user2.getFullName() : "User" %></h5>
	</div>
	<div class="card-body">
		<aui:form name="addContactForm" action="<%= ContactURL %>"
			method="post">
			<!-- Hidden field for User ID -->
			<aui:input type="hidden" name="UserId" value="<%= userIdParam %>" />
			<div class="form-group">
				<label for="primary">Is Primary Address?</label>
				<aui:input type="checkbox" name="primary" />
			</div>
			<!-- Phone Number Field -->
			<div class="form-group">
				<label for="Phone Number"></label>
				<aui:input type="text" id="phoneNumber" name="phoneNumber"
					placeholder="Enter phone number" class="form-control"
					required="true" />
			</div>

			<!-- Phone Type Dropdown -->
			<div class="form-group">
				<label for="Phone Type"></label>
				<aui:select class="form-control" id="listTypeId" name="listTypeId"
					required="true">
					<aui:option value="">Select Phone Type</aui:option>
					<%
                        if (phoneTypes != null) {
                            for (ListType listType : phoneTypes) {
                                String listTypeId = String.valueOf(listType.getListTypeId());
                                String listTypeName = listType.getName();
                    %>
					<aui:option value="<%= listTypeId %>"><%= listTypeName %></aui:option>
					<% 
                            }
                        }
                    %>
				</aui:select>
			</div>

			<!-- Submit Button -->
			<div class="form-group text-center">
				<aui:button type="submit" class="btn btn-primary" value="Save" />
			</div>
		</aui:form>
	</div>
</div>

<%
    } else {
        out.print("User ID is missing in the request.");
    }
%>
