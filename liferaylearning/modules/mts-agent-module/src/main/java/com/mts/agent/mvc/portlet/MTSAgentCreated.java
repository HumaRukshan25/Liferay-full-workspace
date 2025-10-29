package com.mts.agent.mvc.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mts.agent.mvc.constants.MtsAgentModulePortletKeys;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.MTS",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=MtsAgentRegister",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/agent-registration.jsp",
			"javax.portlet.name=" + MtsAgentModulePortletKeys.MTSAGENTREGISTER,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class MTSAgentCreated<_log> extends MVCPortlet {
	public void  CreatAgent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_log.info("Agent AccountCreated Method Inside ::::::::::::::::");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		String screenName = ParamUtil.getString(actionRequest, "screenName", null);
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress", null);
		String firstName = ParamUtil.getString(actionRequest, "firstName", null);
		String lastName = ParamUtil.getString(actionRequest, "lastName", null);
		String middleName = ParamUtil.getString(actionRequest, "middleName", null);
		long prefixValue = ParamUtil.getLong(actionRequest, "prefixValue", 0);
		boolean gender = ParamUtil.getBoolean(actionRequest, "gender");
		String occupation = ParamUtil.getString(actionRequest, "occupation", null);
		int birthdayMonth = ParamUtil.getInteger(actionRequest, "birthdayMonth");
		int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");
		String password1 = ParamUtil.getString(actionRequest, "password1", null);
		System.out.println("Agent Gender ::::"+ gender);
		ServiceContext serviceContext = new ServiceContext();
		User user = UserLocalServiceUtil.fetchUserByScreenName(themeDisplay.getCompanyId(), screenName);
		User userByEmail = UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), emailAddress);

		if (Validator.isNotNull(user) || Validator.isNotNull(userByEmail)) {
			if (Validator.isNotNull(user)) {
				SessionErrors.add(actionRequest, "screenName-already-in-use");
			}
			if (Validator.isNotNull(userByEmail)) {
				SessionErrors.add(actionRequest, "email-already-in-use");
			}
			
		}
		try {
			user = UserLocalServiceUtil.addUser(0L, themeDisplay.getCompanyId(), false, password1, password1, false,
					screenName, emailAddress, themeDisplay.getLocale(), firstName, middleName, lastName, prefixValue,
					0L, gender, birthdayMonth, birthdayDay, birthdayYear, occupation, UserConstants.TYPE_REGULAR, null,
					null, null, null, true, serviceContext);
			Role role = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), "Agent");
			if (Validator.isNotNull(role)) {
				_log.info("Role Agent found: " + role);
				if (!UserLocalServiceUtil.hasRoleUser(role.getRoleId(), user.getUserId())) {
					_log.info("Assigning Agent role to user: " + user.getScreenName());
					UserLocalServiceUtil.addRoleUser(role.getRoleId(), user.getUserId());
				}
			} else {
				_log.warn("Role Agent not found. Please ensure the role exists.");
			}
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			File file = uploadPortletRequest.getFile("portraitImage");
			byte[] portraitBytes = FileUtil.getBytes(file);

			if (portraitBytes != null) {
				user = UserLocalServiceUtil.updatePortrait(user.getUserId(), portraitBytes);
				UserLocalServiceUtil.updateUser(user);
			}
			_log.info("Agent Name ::::::::::::::::" + firstName);
			_log.info("Agent Mobile NUmber ::::::::::::::::" + screenName);
			_log.info("Agent Email ::::::::::::::::" + emailAddress);
			_log.info("Agent Gender :::::::::::::::: " + (gender ? "Male" : "Female"));
			_log.info("Agent Role ::::::::::::::::" + role);
			_log.info("Agent image ::::::::::::::::" + portraitBytes);
			if (Validator.isNull(redirectURL)) {
				_log.error(" Using default redirect.");
				redirectURL = "/agent";
			}
			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			_log.error("Error during user creation or role assignment", e);
			
		}
		
	}

	private static final Log _log = LogFactoryUtil.getLog(MTSAgentCreated.class);
}

