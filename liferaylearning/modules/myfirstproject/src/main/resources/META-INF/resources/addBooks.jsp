

<%@ include file="./init.jsp" %>

<!-- Action url -->
<portlet:actionURL name="addEntry" var="addEntryURL" />

<aui:form name="student" action="${addEntryURL}" method="post">

    <!-- Personal Information Fieldset -->
    <aui:fieldset label="Personal Information" markupView="lexicon">
        <aui:row>
            <aui:col width="50">
                <aui:input label="First Name" name="firstName" type="text" />
            </aui:col>
            <aui:col width="50">
                <aui:input label="Last Name" name="lastName" type="text" />
            </aui:col>
        </aui:row>
        <aui:row>
            <aui:col width="50">
                <aui:input label="Username" name="username" type="text" />
            </aui:col>
            <aui:col width="50">
                <aui:input label="Email" name="email" type="email" />
            </aui:col>
        </aui:row>
    </aui:fieldset>

    <!-- Miscellaneous Fieldset -->
    <aui:fieldset label="Miscellaneous" markupView="lexicon">
        <aui:input label="Hobbies" name="hobbies" type="textarea" />
        <aui:input label="Receive email updates" name="emailUpdates" type="checkbox" />
    </aui:fieldset>

    <!-- Submit Button -->
    <aui:button-row>
        <aui:button name="submitButton" type="submit" value="Submit" />
    </aui:button-row>
</aui:form>


