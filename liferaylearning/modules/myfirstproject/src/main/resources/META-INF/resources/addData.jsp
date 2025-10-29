<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<portlet:actionURL name="/myfirst/addData" var="addDataActionURL" />

<h2>This is addData.jsp</h2>

<aui:form name="fm2" method="post" action="<%= addDataActionURL.toString() %>">
	<aui:fieldset>
		<aui:input label="First Name" name="firstName" type="text" />
		<aui:input label="Last Name" name="lastName" type="text" />
		<aui:input label="Username" name="username" type="text" />
		<aui:input label="Email" name="email" type="email" />
	</aui:fieldset>

	<aui:fieldset>
		<aui:input label="Hobbies" name="hobbies" type="textarea" />
		<aui:input label="Receive email updates" name="emailUpdates" type="checkbox" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button name="submitButton" type="submit" value="Submit" />
	</aui:button-row>
</aui:form>




