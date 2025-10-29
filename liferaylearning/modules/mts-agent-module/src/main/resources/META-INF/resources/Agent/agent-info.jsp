<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.kernel.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.ListType"%>
<%@page import="com.liferay.portal.kernel.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Phone"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.service.AddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Address"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@include file="../init.jsp"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%
    String userIdParam = request.getParameter("userId");

    if (userIdParam != null) {
        try {
            long userId = Long.parseLong(userIdParam);
            User user2 = UserLocalServiceUtil.getUserById(userId);
            List<Address> userAddresses = AddressLocalServiceUtil.getAddresses(-1, -1);
            List<Phone> userPhones = PhoneLocalServiceUtil.getPhones(-1, -1);

            if (user2 != null) {
%>

<div class="main-panel">
    <div class="content-wrapper">
        <div class="row">
            <!-- User Details Tab -->
            <!-- class="col-md-12 col-xl-6 grid-margin stretch-card" -->
            <div>  
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title d-flex justify-content-between align-items-center">
                            Agent Details
                            <a href="<%= renderResponse.createRenderURL() + "?jspPage=/Agent/update-profile.jsp" %>" class="text-muted">
                                <!-- Optional: Edit Icon Here -->
                            </a>
                        </h4>
                        <!-- Nav Pills -->
                        <ul class="nav nav-pills nav-pills-success" id="pills-tab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active fs-5" id="pills-home-tab" data-bs-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">Details</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link fs-5" id="pills-profile-tab" data-bs-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">Address</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link fs-5" id="pills-contact-tab" data-bs-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">Contact</a>
                            </li>
                        </ul>
<%
							PortletURL UpdateUserURL = renderResponse.createRenderURL();
							UpdateUserURL.setParameter("jspPage", "/Agent/agent-updated.jsp");
							UpdateUserURL.setParameter("UserId", String.valueOf(user2.getUserId()));
						%>
                        <!-- Tab Content -->
                        <div class="tab-content" id="pills-tabContent">
                            <!-- User Details Tab Content -->
                            <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                                <div class="media">
                                    <img class="me-3 w-14 rounded" src="<%= user2.getPortraitURL(themeDisplay) %>" alt="<%= user2.getFullName() %>'s Image">
                                    <div class="media-body" style="font-family: Arial, sans-serif; font-size: 16px; color: #333;">
                                        <h4 class="mt-0" style="font-size: 24px; font-weight: 600;"><%=user2.getFullName() %></h4>
										<p style="font-size: 14px; color: #666;">
											First Name: <strong><%=user2.getFirstName() %></strong>
										</p>
										<p style="font-size: 14px; color: #666;">
											Last Name: <strong><%=user2.getLastName() %></strong>
										</p>
										<p style="font-size: 14px; color: #666;">
											Email: <strong><%=user2.getEmailAddress() %></strong>
										</p>
										<p style="font-size: 14px; color: #666;">
											Gender: <strong><%= user2.getMale() ? "Male" : "Female" %></strong>
										</p>
										<p style="font-size: 14px; color: #666;">
											Occupation: <strong><%=user2.getJobTitle() %></strong>
										</p>
										<p style="font-size: 14px; color: #666;">
											Role: <strong> <% 
                        long[] roleIds = user2.getRoleIds();
                        Set<String> roleNames = new HashSet<>();  

                        if (roleIds != null && roleIds.length > 0) {
                            for (long roleId : roleIds) {
                                Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Patient"); 
                                roleNames.add(role.getName());
                            }

                            for (String roleName : roleNames) {
                                out.print(roleName + " ");
                            }
                        } else {
                            out.print("No roles assigned");
                        }
                    %></strong>
										</p>
										<!-- <hr style="border: 1px solid #ddd;"> -->
                                    </div>
                                    <a href="<%=UpdateUserURL%>" class="text-muted pr-5 mr-5">
										<i class="fas fa-pencil-alt fs-4 text-success"></i>
									</a>
                                </div>
                            </div>

                            <!-- Address Tab Content -->
                            <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                                <h4>Address Details</h4>
                                <ul class="address-list" style="font-family: Arial, sans-serif; font-size: 16px; color: #333;">
                                    <%
                                        PortletURL UpdateURL = renderResponse.createRenderURL();
                                        UpdateURL.setParameter("jspPage", "/Agent/update-address.jsp");

                                        List<ListType> AddressTypes = ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.address");

                                        if (userAddresses != null && !userAddresses.isEmpty()) {
                                            for (Address address : userAddresses) {
                                                if (address.getUserId() == user2.getUserId()) {
                                                    UpdateURL.setParameter("UpdateAddressId", String.valueOf(address.getAddressId()));
                                    %>
                                    <%
								        String AddressType = ListTypeServiceUtil.getListType(address.getListTypeId()).getName();
		                                
									%>
									<li style="font-size: 14px; color: #666;"><strong>Primary
											Type:</strong> <%= (address.getPrimary() == true) ? "primary" : "no-primary" %></li>
                                                <li style="font-size: 14px; color: #666;"><strong>Address Type:</strong> <%= AddressType %></li>
                                                <li style="font-size: 14px; color: #666;"><strong>Street 1:</strong> <%= address.getStreet1() %></li>
                                                <li style="font-size: 14px; color: #666;"><strong>Street 2:</strong> <%= address.getStreet2() %></li>
                                                <li style="font-size: 14px; color: #666;"><strong>City:</strong> <%= address.getCity() %></li>
                                                <li style="font-size: 14px; color: #666;"><strong>Zip Code:</strong> <%= address.getZip() %></li>
                                                <a href="<%= UpdateURL %>" class="text-muted">
                                                    <i class="fas fa-pencil-alt fs-4 text-success"></i>
                                                </a>
                                                <portlet:actionURL name="DeleteAddress" var="DeleteAddressActionURL">
										<portlet:param name="addressId"
											value="<%=String.valueOf(address.getAddressId())%>" />
									</portlet:actionURL>

									<a href="${DeleteAddressActionURL}" class=" "
										onclick="return confirm('Are you sure you want to delete this item?');">
										<i class="fas fa-trash-alt fs-4 text-danger"></i>
									</a>
									<hr style="border: 1px solid #ddd;">
                                    <%
                                                }
                                            }
                                        } else {
                                    %>
                                            <li>No address available.</li>
                                    <%
                                        }
                                    %>
                                </ul>
                                <%
                                    PortletURL AddressURL = renderResponse.createRenderURL();
                                    AddressURL.setParameter("jspPage", "/Agent/add-address.jsp");
                                    AddressURL.setParameter("AddressuserIds", String.valueOf(user2.getUserId()));

                                    PortletURL ContactURL = renderResponse.createRenderURL();
                                    ContactURL.setParameter("jspPage", "/Agent/add-contact.jsp");
                                    ContactURL.setParameter("ContactuserId", String.valueOf(user2.getUserId()));
                                %>
                                <a href="<%= AddressURL.toString() %>" class="text-muted">
                                    <i class="fa-solid fa-circle-plus fs-4 text-info"></i>
                                </a>
                            </div>

                            <!-- Contact Tab Content -->
                            <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">
                                <h4>Contact Details</h4>
                                <ul class="address-list" style="font-family: Arial, sans-serif; font-size: 16px; color: #333;">
                                    <%
                                        List<ListType> phoneTypes = ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.phone");
                                        PortletURL UpdateContactURL = renderResponse.createRenderURL();
                                        UpdateContactURL.setParameter("jspPage", "/Agent/update-contact.jsp");

                                        if (userPhones != null && !userPhones.isEmpty()) {
                                            for (Phone phone : userPhones) {
                                                if (phone.getUserId() == user2.getUserId()) {
                                                    UpdateContactURL.setParameter("UpdatephoneId", String.valueOf(phone.getPhoneId()));
                                                    String phoneType = ListTypeServiceUtil.getListType(phone.getListTypeId()).getName();
                                    %>
                                    <li style="font-size: 14px; color: #666;"><strong>Primary
											Type:</strong> <%=(phone.getPrimary() == true)?"primary":"no-primary"%></li>
                                                    <li><strong>Phone Number:</strong> <%= phone.getNumber() %></li>
                                                    <li><strong>Phone Type:</strong> <%= phoneType %></li>
                                                    <a href="<%= UpdateContactURL %>" class="text-muted">
                                                        <i class="fas fa-pencil-alt fs-4 text-success"></i>
                                                    </a>
                                                    <portlet:actionURL name="DeleteContact" var="DeleteContactActionURL">
										<portlet:param name="phoneId"
											value="<%=String.valueOf(phone.getPhoneId())%>" />
									</portlet:actionURL>

									<a href="${DeleteContactActionURL}" class=" "
										onclick="return confirm('Are you sure you want to delete this item?');">
										<i class="fas fa-trash-alt fs-4 text-danger"></i>
									</a>
                                    <%
                                                }
                                            }
                                        } else {
                                    %>
                                            <li>No phone numbers available</li>
                                    <%
                                        }
                                    %>
                                </ul>
                                <a href="<%= ContactURL %>" class="text-muted">
                                    <i class="fa-solid fa-circle-plus fs-4 text-info"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%
            } else {
                out.print("User not found.");
            }
        } catch (NumberFormatException e) {
            out.print("Invalid userId format.");
        }
    } else {
        out.print("User ID is missing in the request.");
    }
%>


<%-- <%
	String userIdParam = request.getParameter("userId");

	if (userIdParam != null) {
		try {
			long userId = Long.parseLong(userIdParam);
			User user2 = UserLocalServiceUtil.getUserById(userId);
			List<Address> userAddresses = AddressLocalServiceUtil.getAddresses(-1, -1);
			List<Phone> userPhones = PhoneLocalServiceUtil.getPhones(-1, -1);

			if (user2 != null) {
%>
<div class="row">
	<div class="col-md-6 col-lg-6">
		<div class="card">
			<div class="d-flex justify-content-center">
				<img src="<%=user2.getPortraitURL(themeDisplay)%>"
					class="card-img-top img-fluid w-50 m-3"
					alt="<%=user2.getFullName()%>'s Image">
			</div>
			<hr style="border: none; border-top: 2px solid #333; margin: 20px 0;">
			<div class="card-body" style="padding: 20px;">
				<h2 class="card-title">Agent Details :</h2>
				<div class="card-text" style="margin-top: 15px;">
					<p>First Name: <strong><%=user2.getFirstName()%></strong></p>
					<p>Last Name: <strong><%=user2.getLastName()%></strong></p>
					<p>Email Address: <strong><%=user2.getEmailAddress()%></strong></p>
					<p>Gender: <strong><%=user2.getMale() ? "Male" : "Female"%></strong></p>
					<p>Occupation: <strong><%=user2.getJobTitle()%></strong></p>
					<hr style="border: none; border-top: 2px solid #333; margin: 20px 0;">
				</div>

				<div class="card-text" style="margin-top: 20px;">
					<h6 style="font-size: 1rem; font-weight: bold; color: #555;">Roles:</h6>
					<ul style="padding-left: 1.5rem; list-style-type: none; margin-top: 5px;">
						<%
							long[] roleIds = user2.getRoleIds();
							boolean hasAgentRole = false;
							if (roleIds != null && roleIds.length > 0) {
								for (long roleId : roleIds) {
									Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Agent");
									if ("Agent".equals(role.getName()) && !hasAgentRole) {
										hasAgentRole = true;
						%>
						<li style="font-size: 0.9rem; color: green;"><strong><%=role.getName()%></strong></li>
						<%
									}
								}
							} else {
						%>
						<li style="font-size: 0.9rem; color: #777;">No roles assigned</li>
						<%
							}
						%>
					</ul>
					<hr style="border: none; border-top: 2px solid #333; margin: 20px 0;">
				</div>

				<!-- Displaying the addresses -->
				<%
					PortletURL UpdateURL = renderResponse.createRenderURL();
					UpdateURL.setParameter("jspPage", "/Agent/update-address.jsp");

					List<ListType> AddressTypes = ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.address");
				%>
				<div class="card-text" style="margin-top: 15px;">
					<h2 class="card-title">Address Details :</h2>
					<ul>
						<%
							boolean mainAddressDisplayed = false;
							if (userAddresses != null && !userAddresses.isEmpty()) {
								for (Address address : userAddresses) {
									if (address.getUserId() == user2.getUserId()) {
										UpdateURL.setParameter("UpdateAddressId", String.valueOf(address.getAddressId()));
						%>
										<p><strong>Address Type:</strong> <%= address.getListTypeId() %></p>
										<p><strong>Street 1:</strong> <%= address.getStreet1() %></p>
										<p><strong>Street 2:</strong> <%= address.getStreet2() %></p>
										<p><strong>City:</strong> <%= address.getCity() %></p>
										<p><strong>Zip Code:</strong> <%= address.getZip() %></p>
										<a href="<%= UpdateURL %>" class=""><i class="fas fa-pencil-alt fa-lg"></i> </a>
						<%
									}
								}
							} else {
						%>
								<p>No addresses available.</p>
						<%
							}
						%>
					</ul>
					<hr style="border: none; border-top: 2px solid #333; margin: 20px 0;">
				</div>

				<!-- Displaying the phones -->
				<%
					List<ListType> phoneTypes = ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.phone");
					PortletURL UpdateContactURL = renderResponse.createRenderURL();
					UpdateContactURL.setParameter("jspPage", "/Agent/update-contact.jsp");
				%>
				<div class="card-text" style="margin-top: 15px;">
					<h2 class="card-title">Contact Details :</h2>
					<ul>
						<%
							if (userPhones != null && !userPhones.isEmpty()) {
								for (Phone phone : userPhones) {
									if (phone.getUserId() == user2.getUserId()) {
										UpdateContactURL.setParameter("UpdatephoneId", String.valueOf(phone.getPhoneId()));
										String listTypeName = "";
										for (ListType listType : phoneTypes) {
											if (phone.getListTypeId() == listType.getListTypeId()) {
												listTypeName = listType.getName();
												break;
											}
										}
						%>
										<p><strong>Phone Number:</strong> <%= phone.getNumber() %></p>
										<p><strong>Phone Type:</strong> <%= listTypeName %></p>
										<a href="<%= UpdateContactURL %>" class=""><i class="fas fa-pencil-alt fa-lg"></i> </a>
						<%
									}
								}
							} else {
						%>
								<li>No phone numbers available</li>
						<%
							}
						%>
					</ul>
					<hr style="border: none; border-top: 2px solid #333; margin: 20px 0;">
				</div>
			</div>
		</div>

		<div class="d-flex justify-content-center m-4 gap-4">
			<portlet:renderURL var="backUrl">
				<portlet:param name="mvcRenderCommandName" value="/view.jsp" />
			</portlet:renderURL>
			<a href="<%= backUrl %>" class="btn btn-secondary">Back</a>

			<%
				PortletURL AddressURL = renderResponse.createRenderURL();
				AddressURL.setParameter("jspPage", "/Agent/add-address.jsp");
				AddressURL.setParameter("AddressuserIds", String.valueOf(user2.getUserId()));

				PortletURL ContactURL = renderResponse.createRenderURL();
				ContactURL.setParameter("jspPage", "/Agent/add-contact.jsp");
				ContactURL.setParameter("ContactuserId", String.valueOf(user2.getUserId()));
			%>
			<a href="<%= AddressURL.toString() %>" class="btn btn-primary">Add Address</a>
			<a href="<%= ContactURL.toString() %>" class="btn btn-success">Add Contact</a>
		</div>
	</div>
</div>

<%
			} else {
				out.print("User not found.");
			}
		} catch (NumberFormatException e) {
			out.print("Invalid userId format.");
		}
	} else {
		out.print("User ID is missing in the request.");
	}
%>
 --%>