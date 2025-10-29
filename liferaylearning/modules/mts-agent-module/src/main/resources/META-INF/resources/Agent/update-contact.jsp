<%@page
	import="com.liferay.portal.kernel.service.RegionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.model.ListType"%>
<%@page import="com.liferay.portal.kernel.service.ListTypeServiceUtil"%>
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
<%@ include file="../init.jsp"%>
<%@page import="com.liferay.portal.kernel.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Phone"%>
<portlet:actionURL name="updateContact" var="updateContactActionURL" />


<%
	long phoneId = ParamUtil.getLong(request, "UpdatephoneId");
	List<ListType> addressTypes = null;

	List<ListType> phoneTypes = ListTypeServiceUtil
			.getListTypes("com.liferay.portal.kernel.model.Contact.phone");

	System.out.println("phoneId" + phoneId);

	Phone phone = null;
	if (phoneId > 0) {

		phone = PhoneLocalServiceUtil.fetchPhone(phoneId);
		if (phone == null) {

			System.out.println("No address found for the given addressId: " + phoneId);
		}
	}

	if (phone == null) {
%>
<div class="alert alert-danger">

	No phone found with ID
	<%=phoneId%>. Please check the ID.
</div>
<%
	} else {
%>
<div class="container">
	<div class="card shadow-lg p-4 mb-4">
		<div class="card-body">
			<aui:form name="updateContactAction"
				action="<%=updateContactActionURL%>" method="POST"
				enctype="multipart/form-data">

				<h1>Updated Contact Details</h1>
				<aui:input name="phoneId" type="hidden"
					value="<%=phone.getPhoneId()%>" />
				<aui:col md="6">
					<aui:select name="primary" label="Primary Address"
							class="form-control">
							<aui:option value="<%=phone.getPrimary()%>"><%=(phone.getPrimary() == true) ? "primary" : "no-primary"%></aui:option>
							<aui:option value="1">Primary</aui:option>
							<aui:option value="0">No-Primary</aui:option>
						</aui:select>
				</aui:col>
				<aui:select class="form-control" id="listTypeId"
					name="listTypeId" required="true">
	<%-- 				<aui:option value="">Select Phone Type</aui:option> --%>
					<%
						if (phoneTypes != null) {
										for (ListType listType : phoneTypes) {
											String sellistTypeId = String.valueOf(phone.getListTypeId());
											String sellistTypeName = listType.getName();
											String listTypeId = String.valueOf(listType.getListTypeId());
											String listTypeName = listType.getName();
					%>
					<aui:option value="<%=sellistTypeId %>"><%=sellistTypeName %></aui:option>
					<aui:option value="<%=listTypeId%>"><%=listTypeName%></aui:option>
					<%
						}
									}
					%>
				</aui:select>
				<aui:input type="text" id="phoneNumber" name="phoneNumber"
					placeholder="Enter phone number" class="form-control"
					required="true" value="<%=phone.getNumber()%>" />

				<aui:button type="submit" value="Save" />
				<portlet:renderURL var="backUrl">
					<portlet:param name="mvcRenderCommandName"
						value="/Patient/patient-info.jsp" />
				</portlet:renderURL>
				<aui:a href="<%=backUrl%>" cssClass="btn btn-primary" label="Back" />
			</aui:form>
			<%
    }
%>