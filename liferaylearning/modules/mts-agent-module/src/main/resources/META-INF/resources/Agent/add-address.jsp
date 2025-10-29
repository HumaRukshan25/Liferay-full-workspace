<%@page import="com.liferay.portal.kernel.model.Region"%>
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
 
<portlet:actionURL name="CreateAddress" var="AddressURL"
	windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
	<portlet:param name="mvcRenderCommandName" value="/agent" />
</portlet:actionURL>


<%
    // Fetch userId parameter from request
    String userIdParam = request.getParameter("AddressuserIds");

    // Initialize necessary variables
    List<Region> regions = null;
    List<Country> countries = null;
    List<ListType> addressTypes = null;
    User user2 = null;

    // Make sure userId is present
    if (userIdParam != null) {
        try {
            long userId = Long.parseLong(userIdParam);
            user2 = UserLocalServiceUtil.getUserById(userId);
            System.out.println("user Id is...."+ userId);

            // Fetch regions, countries, and address types
            regions = RegionLocalServiceUtil.getRegions(-1, -1);  // Fetch all regions
            countries = CountryLocalServiceUtil.getCountries(-1, -1);  // Fetch all countries
            addressTypes = ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.address");  // Fetch address types
        } catch (Exception e) {
            e.printStackTrace();  // Log exception if needed
        }
   
%>

<h2 class="text-center mb-4">
    Add New Address for <%= user2 != null ? user2.getFullName() : "User" %>
</h2>

<div class="container">
    <div class="card shadow-lg p-4 mb-4">
        <div class="card-body">
            <aui:form name="addressForm" action="<%= AddressURL %>" method="post">
                <!-- Hidden field for User ID -->
                <aui:input type="hidden" name="UserId" value="<%= userIdParam%>" >
                </aui:input>

                <!-- Primary Address Checkbox -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="primary">Is Primary Address?</label>
                            <aui:input type="checkbox" name="primary" />
                        </div>
                    </div>
                </div>

                <!-- Address Type and Street 1 -->
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <aui:select name="listTypeId" label="Address Type" class="form-control" required="true">
                                <aui:option value="">Select Address Type</aui:option>
                                <%
                                // Ensure addressTypes is not null and iterate through it
                                if (addressTypes != null) {
                                    for (ListType listType : addressTypes) {
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
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="street1">Street 1</label>
                            <aui:input name="street1" class="form-control" required="true" />
                        </div>
                    </div>
                </div>

                <!-- Street 2 and City -->
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="street2">Street 2</label>
                            <aui:input name="street2" class="form-control" />
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="city">City</label>
                            <aui:input name="city" class="form-control" required="true" />
                        </div>
                    </div>
                </div>

                <!-- Zip Code, Country, and Region -->
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="zip">Zip Code</label>
                            <aui:input name="zip" class="form-control" required="true" />
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="countryId">Select Country</label>
                            <aui:select name="countryId" label="Select Country" class="form-control" required="true">
                                <aui:option value="">Select Country</aui:option>
                                <%
                                // Ensure countries list is not null and iterate through it
                                if (countries != null) {
                                    for (Country country : countries) {
                                %>
                                    <aui:option value="<%= country.getCountryId() %>"><%= country.getName() %></aui:option>
                                <% 
                                    }
                                }
                                %>
                            </aui:select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="regionId">Select Region</label>
                            <aui:select name="regionId" label="Select Region" class="form-control">
                                <aui:option value="" label="-- Select a Region --" />
                                <%
                                // Ensure regions list is not null and iterate through it
                                if (regions != null) {
                                    for (Region region : regions) {
                                %>
                                    <aui:option value="<%= region.getRegionId() %>"><%= region.getName() %></aui:option>
                                <% 
                                    }
                                }
                                %>
                            </aui:select>
                        </div>
                    </div>
                </div>

                <!-- Submit and Back Buttons -->
                <div class="form-group text-center">
                    <div class="btn-group" role="group">
                        <!-- Back Button -->
                        <portlet:renderURL var="backUrl">
                            <portlet:param name="mvcRenderCommandName" value="/Patient/patient-info.jsp" />
                        </portlet:renderURL>
                        <a href="<%= backUrl %>" class="btn btn-secondary btn-lg mr-2">Back</a>

                        <!-- Add Address Button -->
                        <aui:button value="Add Address" type="submit" class="btn btn-primary btn-lg hover-shadow" />
                    </div>
                </div>
            </aui:form>
        </div>
    </div>
</div>
<%
    } else {
		out.print("User ID is missing in the request.");
	}
%>


<!-- Custom Styles for Hover -->
<style>
.btn-primary:hover {
	background-color: #0056b3;
	border-color: #004085;
}

.form-group label {
	font-weight: bold;
}

.form-control {
	border-radius: 0.25rem;
}

.card {
	border-radius: 10px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.hover-shadow:hover {
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.15);
}
</style>
