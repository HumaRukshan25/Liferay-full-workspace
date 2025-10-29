<%@page import="com.liferay.portal.kernel.service.ContactLocalServiceUtil"%>
<%@page
	import="com.liferay.portal.security.auth.ScreenNameValidatorFactory"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.portal.kernel.service.CountryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Contact"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.portal.kernel.security.auth.ScreenNameValidator"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp"%>


<portlet:actionURL name="UpdatedUser" var="UpdatedUserURL" />
<%
	String redirect = ParamUtil.getString(request, "redirect");

	Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();

	birthdayCalendar.set(Calendar.MONTH, Calendar.JANUARY);
	birthdayCalendar.set(Calendar.DATE, 1);
	birthdayCalendar.set(Calendar.YEAR, 1970);
%>
<%
	long UserId = ParamUtil.getLong(request, "UserId");
	System.out.println("UserId ::::::::" + UserId);

	User ueser = null;
	if (UserId > 0) {

		ueser = UserLocalServiceUtil.fetchUser(UserId);
		
		if (ueser == null) {

			System.out.println("No User found for the given UserId: " + UserId);
		}
	}

	if (ueser == null) {
%>

<div class="alert alert-danger">

	No phone found with ID
	<%=UserId%>. Please check the ID.
</div>
<%
	} else {
%>
<div class="container">
	<div class="row justify-content-center-OLD">
		<div class="col-md-12 col-lg-12">
			<div class="card mt-5 shadow-lg">
				<div class="card-header text-center">
					<h4>Updated Agent Account</h4>
				</div>
				<div class="card-body" style="min-height: 600px;">
					<!-- Increased height for the card -->
					<aui:form action="<%=UpdatedUserURL%>" method="post">
						<aui:input name="saveLastPath" type="hidden" value="<%=false%>" />
						<aui:input name="<%=Constants.CMD%>" type="hidden"
							value="<%=Constants.ADD%>" />

						<aui:input name="userId" type="hidden" value="<%=ueser.getUserId()%>" />
						<%
						List<Contact> userContacts = ContactLocalServiceUtil.getContacts(-1, -1);
						if (userContacts != null && !userContacts.isEmpty()) {
							for (Contact contacts : userContacts) {
								if(contacts.getUserId() == ueser.getUserId()){
						%>
							<aui:input name="ContactId" type="hidden" value="<%=contacts.getContactId()%>" />
							
							<%
								}
							}
						}
							%>
						<aui:fieldset>
							<!-- Profile Photo -->
							<div class="form-group text-center">
								<img src="<%=ueser.getPortraitURL(themeDisplay)%>" id="img_url"
									alt="Profile Picture" class="img-thumbnail mb-3"
									style="width: 150px; height: 150px; object-fit: cover;">
								<aui:script>
                                    function img_pathUrl(input){
                                        $('#img_url')[0].src = (window.URL ? URL : webkitURL).createObjectURL(input.files[0]);
                                    }
                                </aui:script>
								<aui:input name="portraitImage" label="Profile Photo"
									type="file" id="img_file" onChange="img_pathUrl(this);"
									class="form-control-file">
									
									<aui:validator name="acceptFiles">'jpg,png'</aui:validator>
								</aui:input>
							</div>

							<!-- First Name and Last Name in the same row -->
							<div class="form-row">
								<div class="form-group col-md-6">
									<aui:input name="firstName" label="First Name"
										value="<%=ueser.getFirstName()%>" class="form-control">
										
									</aui:input>
								</div>
								<div class="form-group col-md-6">
									<aui:input name="lastName" label="Last Name"
										value="<%=ueser.getLastName()%>" class="form-control">
									</aui:input>
								</div>
							</div>

							<!-- Email Address -->
							<div class="form-row">
								<div class="form-group col-md-6">
									<aui:input name="emailAddress" label="Email Address"
										type="email" value="<%=ueser.getEmailAddress()%>"
										required="<%=PrefsPropsUtil.getBoolean(themeDisplay.getCompanyId(),
								PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED)%>"
										class="form-control" />
								</div>

								<!-- Screen Name -->
								<div class="form-group col-md-6">
									<%-- <aui:input name="screenName" label="Screen Name"
										class="form-control">
										<aui:validator name="required" />
									</aui:input> --%>
									<aui:input name="screenName" label="Screen Name"
										value="<%=ueser.getScreenName()%>">

										<%
											ScreenNameValidator screenNameValidator = ScreenNameValidatorFactory.getInstance();
										%>

										<c:if
											test="<%=Validator.isNotNull(screenNameValidator.getAUIValidatorJS())%>">
											
											<aui:validator
												errorMessage="<%=screenNameValidator.getDescription(themeDisplay.getLocale())%>"
												name="custom">
												<%=screenNameValidator.getAUIValidatorJS()%>
											</aui:validator>
										</c:if>
									</aui:input>
								</div>
							</div>
							<!-- Password -->
							<div class="form-row">
								<div class="form-group col-md-6">
										
									<aui:input name="jobTitle" label="Job Title"
										class="form-control" value="<%=ueser.getJobTitle()%>" />
								</div>
							
								<!-- Gender -->
								<div class="form-group col-md-6">
									<aui:select name="gender" label="Gender" class="form-control">
										<aui:option value="true"><%=ueser.getMale() ? "Male" : "Female"%></aui:option>
										<aui:option value="true">Male</aui:option>
										<aui:option value="false">Female</aui:option>
									</aui:select>
								</div>
							</div>
							
							
							<div class="form-row">
								<div class="form-group col-md-6">
									<%-- <%
										List<Country> countries = CountryLocalServiceUtil.getCountries(-1, -1);
									%>
									<aui:select name="country" label="Select country"
										id="selectedCountry">
										<aui:option value="">Select Country</aui:option>
										<%
											for (Country countryItems : countries) {
										%>
										<aui:option value="<%=countryItems.getCountryId()%>"><%=countryItems.getName().toUpperCase()%></aui:option>
										<%
											}
										%>
									</aui:select>
									<aui:script>
							$("#<portlet:namespace />selectedCountry").on("change",selectedCountry);
							    function selectedCountry(){
								 console.log($("#<portlet:namespace />selectedCountry").val());
								         Liferay.Service(
										'/region/get-regions',
										{
						    				countryId: $('#<portlet:namespace />selectedCountry').val()
										},
										function(data) {
						    			console.log(data);
						    			var stateNameList = data;
						    			$('#<portlet:namespace />selectedState').empty();
						    			for(var i in stateNameList) {
						    			$('#<portlet:namespace />selectedState').append("<option
											value='"+ stateNameList[i].regionId +"'>"+stateNameList[i].title+"</option>");
	    										}
									}
							);
								   	}
						</aui:script>
								</div>
								<div class="form-group col-md-6">
									<aui:select name="state" label="Select state"
										id="selectedState">
										<aui:option value="">Select State</aui:option>
										<aui:script>
						$("#<portlet:namespace />selectedState").on("change",selectedState);
						 function selectedState(){
							 var stateId = $("#<portlet:namespace />selectedState").val();
							 Liferay.Service(
										'/district/get-by-region-id',
										{
						    				regionId: stateId
										},
										function(data) {
						    			console.log(data);
									var districtNameList = data;
					    			$('#<portlet:namespace />selectedDistrict').empty();
					    			$('#<portlet:namespace />availableLocality').empty();
					    			for(var i in districtNameList) {
					    			$('#<portlet:namespace />selectedDistrict').append("<option
												value='"+ districtNameList[i].districtId +"'>"+districtNameList[i].name+"</option>");
					    			}
					    			}
									);
		 }
						</aui:script>
									</aui:select> --%>
								</div>

							</div>
							<!-- Submit Button -->
							<div class="form-group text-center mt-4">
								<aui:button type="submit" value="Create User"
									class="btn btn-primary btn-lg" />
							</div>
						</aui:fieldset>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>

<%
    }
%>
