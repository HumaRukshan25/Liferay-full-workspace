<%@taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@ taglib uri="http://liferay.com/tld/form" prefix="liferay"%>

<%@page import="com.liferay.portal.kernel.model.Contact"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@ include file="./init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />
<%-- <portlet:actionURL name="createUser" var="createUser">
    <portlet:param name="mvcRenderCommandName" value="/view.jsp" />
</portlet:actionURL> --%>
<portlet:actionURL name="CreatAgent" var="createAccountURL"
	windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<portlet:param name="mvcRenderCommandName" value="/home" />
</portlet:actionURL>

<%
Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();

birthdayCalendar.set(Calendar.MONTH, Calendar.JANUARY);
birthdayCalendar.set(Calendar.DATE, 1);
birthdayCalendar.set(Calendar.YEAR, 1970);

%>
<div class="container">
    <div class="row justify-content-center-OLD">
        <div class="col-md-12 col-lg-12">
            <div class="card mt-5 shadow-lg">
                <div class="card-header text-center">
                    <h4>Create Agent Account</h4>
                </div>
                <div class="card-body" style="min-height: 600px;"> <!-- Increased height for the card -->
                    <aui:form action="<%=createAccountURL%>" method="post">
                        <aui:fieldset>
                            <!-- Profile Photo -->
                            <div class="form-group text-center">
                                <img
                                    src="/image/user_male_portrait?img_id=0&img_id_token=ml8ak%2BZFyxdJKXMun4My4PavmL4%3D&t=1704777810332"
                                    id="img_url" alt="Profile Picture" class="img-thumbnail mb-3" style="width: 150px; height: 150px; object-fit: cover;">
                                <aui:script>
                                    function img_pathUrl(input){
                                        $('#img_url')[0].src = (window.URL ? URL : webkitURL).createObjectURL(input.files[0]);
                                    }
                                </aui:script>
                                <aui:input name="portraitImage" label="Profile Photo" type="file" id="img_file" onChange="img_pathUrl(this);" class="form-control-file">
                                    <aui:validator name="required" />
                                    <aui:validator name="acceptFiles">'jpg,png'</aui:validator>
                                </aui:input>
                            </div>

                            <!-- First Name and Last Name in the same row -->
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <aui:input name="firstName" label="First Name" class="form-control">
                                        <aui:validator name="required" />
                                    </aui:input>
                                </div>
                                <div class="form-group col-md-6">
                                    <aui:input name="lastName" label="Last Name" class="form-control">
                                    </aui:input>
                                </div>
                            </div>

                            <!-- Email Address -->
                          <div class="form-row">
                                <div class="form-group col-md-6">
                                <aui:input name="emailAddress" label="Email Address" type="email"
                                    required="<%=PrefsPropsUtil.getBoolean(themeDisplay.getCompanyId(),
                                                        PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED)%>" class="form-control" />
                            </div>

                            <!-- Screen Name -->
                                <div class="form-group col-md-6">
                                <aui:input name="screenName" label="Screen Name" class="form-control">
                                    <aui:validator name="required" />
                                </aui:input>
                            </div>
  						</div>
                            <!-- Password -->
                          <div class="form-row">
                                <div class="form-group col-md-6">
                                <aui:input name="password1" type="password" label="Password" class="form-control">
                                    <aui:validator name="required" />
                                </aui:input>
                            </div>

                            <!-- Gender -->
                                <div class="form-group col-md-6">
                                <aui:select name="gender" label="Gender" class="form-control">
                                    <aui:option value="true">Male</aui:option>
                                    <aui:option value="false">Female</aui:option>
                                </aui:select>
                            </div>
						</div>
                            <!-- Job Title -->
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                <aui:input name="occupation" label="Job Title" class="form-control" />
                            </div>

                            <!-- Birthday -->
                            <div class="form-group col-md-6">
                            <aui:model-context model="<%=Contact.class%>" />
                            <c:choose>
                                <c:when test="<%=PrefsPropsUtil.getBoolean(company.getCompanyId(),
                                    PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_BIRTHDAY)%>">
                                    <aui:input name="birthday" value="<%=birthdayCalendar%>" class="form-control" />
                                </c:when>
                                <c:otherwise>
                                    <aui:input name="birthdayMonth" type="hidden" value="<%=Calendar.JANUARY%>" />
                                    <aui:input name="birthdayDay" type="hidden" value="1" />
                                    <aui:input name="birthdayYear" type="hidden" value="1970" />
                                </c:otherwise>
                            </c:choose>
</div>
</div>
                            <!-- Submit Button -->
                            <div class="form-group text-center mt-4">
                                <aui:button type="submit" value="Create User" class="btn btn-primary btn-lg" />
                            </div>
                        </aui:fieldset>
                    </aui:form>
                </div>
            </div>
        </div>
    </div>
</div>


<c:if
	test="<%=Validator.isNotNull(request.getAttribute("successMessage"))%>">
	<div class="alert alert-success">
		<%=request.getAttribute("successMessage")%>
	</div>
</c:if>

<c:if
	test="<%=Validator.isNotNull(request.getAttribute("errorMessage"))%>">
	<div class="alert alert-danger">
		<%=request.getAttribute("errorMessage")%>
	</div>
</c:if>
<%-- Display screen name error --%>
<c:if test="<%=Validator.isNotNull(request.getAttribute("screenName-already-in-use"))%>">
    <div class="alert alert-danger">
        The screen name is already in use.
    </div>
</c:if>

<%-- Display email error --%>
<c:if test="<%=Validator.isNotNull(request.getAttribute("email-already-in-use"))%>">
    <div class="alert alert-danger">
        The email address is already in use.
    </div>
</c:if>

<%-- Display screen name invalid error --%>
<c:if test="<%=Validator.isNotNull(request.getAttribute("screenName-invalid"))%>">
    <div class="alert alert-danger">
        The screen name is invalid. It must contain only alphanumeric characters or the following special characters: -._.
    </div>
</c:if>

<%-- Display screen name and email match error --%>
<c:if test="<%=Validator.isNotNull(request.getAttribute("screenName-email-match"))%>">
    <div class="alert alert-danger">
        The screen name cannot be the same as the email address.
    </div>
</c:if>
