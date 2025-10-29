<%@page import="com.liferay.portal.kernel.service.RegionServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.CountryServiceUtil"%>
<%@page
	import="com.liferay.portal.kernel.service.AddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Address"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
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
<portlet:actionURL name="updateAddress" var="updateAddressActionURL" />

<%
    long addressId = ParamUtil.getLong(request, "UpdateAddressId");
List<ListType> addressTypes = null;
List<Region> regions = null;
List<Country> countries = null;
regions = RegionLocalServiceUtil.getRegions(-1, -1);  // Fetch all regions
countries = CountryLocalServiceUtil.getCountries(-1, -1);  // Fetch all countries
addressTypes = ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.address"); 

System.out.println("addressId: " + addressId);

    Address address = null;
  
    if (addressId > 0) {
        address = AddressLocalServiceUtil.fetchAddress(addressId);
       
        if (address == null) {
            System.out.println("No address found for the given addressId: " + addressId);
          
        }
    }

    if (address == null) {
%>
        <div class="alert alert-danger">
            No address found with ID <%= addressId %>. Please check the ID.
            <%--   No phone found with ID <%= phoneId %>. Please check the ID. --%>
        </div>
<%
    } else {
%>
<div class="container">
    <div class="card shadow-lg p-4 mb-4">
        <div class="card-body">
<aui:form name="updateAddressAction"
	action="<%= updateAddressActionURL.toString() %>" method="POST"
	enctype="multipart/form-data">
	<aui:input name="addressId" type="hidden" value="<%= address.getAddressId()%>" />
	<aui:row>
		<aui:col md="6">
			<aui:input name="street1" value="<%= address.getStreet1() %>"
				label="Street One" />

		</aui:col>

		<aui:col md="6">
			<aui:input name="street2" value="<%= address.getStreet2()%>"
				label="Street  Two"  />
		</aui:col>
		<aui:col md="6">
			<aui:input name="city" value="<%= address.getCity() %>" label="City"
				 />
		</aui:col>
		<aui:col md="6">
			<aui:input name="zip" value="<%= address.getZip() %>" label="Zip"
				/>

		</aui:col>
		<aui:col md="6">
			
		<aui:select name="listTypeId" label="Address Type" class="form-control" >
                              
        <%
                              
                                if (addressTypes != null) {
                                    for (ListType listType : addressTypes) {
                                    	  String sellistTypeId = String.valueOf(address.getListTypeId());
                                          String sellistTypeName = listType.getName();
                                          
                                        String listTypeId = String.valueOf(listType.getListTypeId());
                                        String listTypeName = listType.getName();
                                %>
                                   <aui:option value="<%= sellistTypeId %>"><%= sellistTypeName %></aui:option>
                                    <aui:option value="<%= listTypeId %>"><%= listTypeName %></aui:option>
                                <% 
                                    }
                                }
                                %>
                            </aui:select>
		</aui:col>
		<aui:col md="6">
			
		<aui:select name="countryId" label="Select Country"
							class="form-control">
							<%
								String Countryname = CountryServiceUtil.getCountry(address.getCountryId()).getName();
							%>
							<aui:option value="<%=address.getCountryId()%>"
								selected="selected"><%=Countryname%></aui:option>
							<%
								if (countries != null) {
														for (Country country : countries) {
							%>
							<aui:option value="<%=country.getCountryId()%>"><%=country.getName()%></aui:option>

							<%
								}
													}
							%>
						</aui:select>

		</aui:col>
		<aui:col md="6">
		
					<aui:select name="regionId" label="Select State"
							class="form-control">

							<%
								String Regionname = RegionServiceUtil.getRegion(address.getRegionId()).getName();
							%>
							<aui:option value="<%=address.getRegionId()%>"><%=Regionname%></aui:option>
							<%
								if (regions != null) {
														for (Region region : regions) {
															if (region.getCountryId() == address.getCountryId()) {
							%>
							<aui:option value="<%=region.getRegionId()%>"><%=region.getName()%></aui:option>
							<%
								}
														}
													}
							%>
						</aui:select>
		</aui:col>
		<aui:col md="6">
			<aui:select name="primary" label="Primary Address"
							class="form-control">
							<aui:option value="<%=address.getPrimary()%>"><%=(address.getPrimary() == true) ? "primary" : "no-primary"%></aui:option>
							<aui:option value="1">Primary</aui:option>
							<aui:option value="0">No-Primary</aui:option>
						</aui:select>
		</aui:col>
		
	
	</aui:row>

	<aui:button type="submit" value="Save" />
	<portlet:renderURL var="backUrl">
                            <portlet:param name="mvcRenderCommandName" value="/Patient/patient-info.jsp" />
                        </portlet:renderURL>
	<aui:a href="<%=backUrl %>" cssClass="btn btn-primary" label="Back" />
</aui:form>
<%
    }
%>