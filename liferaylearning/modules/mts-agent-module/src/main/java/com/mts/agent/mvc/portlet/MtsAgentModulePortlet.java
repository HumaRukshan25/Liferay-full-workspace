package com.mts.agent.mvc.portlet;

import com.mts.agent.mvc.constants.MtsAgentModulePortletKeys;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author USER
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.MTS",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MtsAgentModule", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MtsAgentModulePortletKeys.MTSAGENTMODULE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MtsAgentModulePortlet extends MVCPortlet {

	public void CreatAgent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_log.info("Agent AccountCreated Method Inside ::::::::::::::::");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		String screenName = ParamUtil.getString(actionRequest, "screenName", null);
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress", null);
		String firstName = ParamUtil.getString(actionRequest, "firstName", null);
		String lastName = ParamUtil.getString(actionRequest, "lastName", null);
		String middleName = ParamUtil.getString(actionRequest, "middleName", null);
		long prefixValue = ParamUtil.getLong(actionRequest, "prefixValue", 0);
		boolean gender = ParamUtil.getBoolean(actionRequest, "male");
		String occupation = ParamUtil.getString(actionRequest, "occupation", null);
		int birthdayMonth = ParamUtil.getInteger(actionRequest, "birthdayMonth");
		int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");
		String password1 = ParamUtil.getString(actionRequest, "password1", null);

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
				redirectURL = "/home";
			}
			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			_log.error("Error during user creation or role assignment", e);

		}

	}

	public void CreateContact(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		System.out.println("inside Contact Method:::");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long UserId = ParamUtil.getLong(actionRequest, "UserId");
		String phoneNumber = ParamUtil.getString(actionRequest, "phoneNumber");
		String className = User.class.getName();
		long listTypeId = ParamUtil.getLong(actionRequest, "listTypeId");
		boolean primary = ParamUtil.getBoolean(actionRequest, "primary");
		long classPK = themeDisplay.getUserId();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		Phone phone;
		try {
			phone = PhoneLocalServiceUtil.addPhone(UserId, className, classPK, phoneNumber, null, listTypeId, primary,
					serviceContext);
			System.out.println("Mobile Number Add successfully :::::");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateContact(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("Inside of Contact Updated Address ::::::::");
		// phone updated
		long phoneId = ParamUtil.getLong(actionRequest, "phoneId");
		String phoneNumber = ParamUtil.getString(actionRequest, "phoneNumber");
		long phonelistTypeId = ParamUtil.getLong(actionRequest, "listTypeId");
		boolean primary = ParamUtil.getBoolean(actionRequest, "primary");

		Phone phone = null;
		try {
			phone = PhoneLocalServiceUtil.getPhone(phoneId);
			System.out.println("Updated Contact Details ::::::");
		} catch (Exception e) {
			System.err.println("Error fetching address: " + e.getMessage());
			e.printStackTrace();
		}
		if (Validator.isNotNull(phone)) {

			phone.setNumber(phoneNumber);
			phone.setListTypeId(phonelistTypeId);
			phone.setPrimary(primary);

			PhoneLocalServiceUtil.updatePhone(phone);
		} else {
			System.out.println("Contact not found or null for phoneId: " + phoneId);
		}
	}

	public void DeleteContact(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		try {
			long phoneId = ParamUtil.getLong(actionRequest, "phoneId");
			System.out.println(" Deleted Received :::::" + phoneId);
			Phone phone = PhoneLocalServiceUtil.fetchPhone(phoneId);
			if (Validator.isNotNull(phone)) {
				PhoneLocalServiceUtil.deletePhone(phone);
				System.out.println("Contact deleed successfully");
			} else {
				System.out.println("No User  found for User: " + phoneId);
			}
		} catch (Exception e) {
			System.out.println("Error while deleting product profile: " + e.getMessage());
		}

	}

	public void CreateAddress(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		System.out.println("Inside Address Method :::::::::");
		long UserId = ParamUtil.getLong(actionRequest, "UserId");
		String street1 = ParamUtil.getString(actionRequest, "street1");
		String street2 = ParamUtil.getString(actionRequest, "street2");
		String city = ParamUtil.getString(actionRequest, "city");
		String zip = ParamUtil.getString(actionRequest, "zip");
		long listTypeId = ParamUtil.getLong(actionRequest, "listTypeId");
		long countryId = ParamUtil.getLong(actionRequest, "countryId");
		long regionId = ParamUtil.getLong(actionRequest, "regionId");
		String externalReferenceCode = "";
		String className = User.class.getName();
		long classPK = themeDisplay.getUserId();
		String name = "Home Address";
		String description = "Primary address";
		boolean mailing = false;
		boolean primary = true;
		String phoneNumber = "";
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		try {
			if (UserId > 0) {
				Address address = AddressLocalServiceUtil.addAddress(externalReferenceCode, UserId, className, classPK,
						name, description, street1, street2, null, city, zip, regionId, countryId, listTypeId, mailing,
						primary, phoneNumber, serviceContext);
				System.out.println("Address successfully added! Address ID: " + address.getAddressId());

			} else {
				System.out.println("UserId is Empty ");
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		actionResponse.setRenderParameter("mvcRenderCommandName", "/Agent");
	}

	public void updateAddress(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("Inside of Updated Address ::::::::");
		long addressId = ParamUtil.getLong(actionRequest, "addressId");
		String street1 = ParamUtil.getString(actionRequest, "street1");
		String street2 = ParamUtil.getString(actionRequest, "street2");
		String city = ParamUtil.getString(actionRequest, "city");
		String zip = ParamUtil.getString(actionRequest, "zip");
		long listTypeId = ParamUtil.getLong(actionRequest, "listTypeId");
		long countryId = ParamUtil.getLong(actionRequest, "countryId");
		long regionId = ParamUtil.getLong(actionRequest, "regionId");
		boolean primary = ParamUtil.getBoolean(actionRequest, "primary");

		Address address = null;
		try {
			address = AddressLocalServiceUtil.getAddress(addressId); // This will throw an exception if not found

			System.out.println("Address Updated Successfully :::: " + address);
		} catch (Exception e) {
			System.err.println("Error fetching address: " + e.getMessage());
			e.printStackTrace();
		}

		if (Validator.isNotNull(address)) {
			// Proceed with updates
			address.setStreet1(street1);
			address.setStreet2(street2);
			address.setCity(city);
			address.setZip(zip);
			address.setListTypeId(listTypeId);
			address.setCountryId(countryId);
			address.setRegionId(regionId);
			address.setPrimary(primary);
			AddressLocalServiceUtil.updateAddress(address);

		} else {
			System.out.println("Address not found or 0 for addressId: " + addressId);

		}
	}

	public void DeleteAddress(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		try {
			long addressId = ParamUtil.getLong(actionRequest, "addressId");
			System.out.println(" Deleted Received :::::" + addressId);
			Address address = AddressLocalServiceUtil.fetchAddress(addressId);
			if (Validator.isNotNull(address)) {
				AddressLocalServiceUtil.deleteAddress(address);
				System.out.println("User deleed successfully");
			} else {
				System.out.println("No User  found for User: " + addressId);
			}
		} catch (Exception e) {
			System.out.println("Error while deleting product profile: " + e.getMessage());
		}

	}

	public void UpdatedUser(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_log.info("Agent Account Updated Method Inside ::::::::::::::::");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		long userId = ParamUtil.getLong(actionRequest, "userId");
		long ContactId = ParamUtil.getLong(actionRequest, "ContactId");
		long updateUserId = ParamUtil.getLong(actionRequest, "updateUserId");
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress", null);
		String firstName = ParamUtil.getString(actionRequest, "firstName", null);
		String lastName = ParamUtil.getString(actionRequest, "lastName", null);
		boolean gender = ParamUtil.getBoolean(actionRequest, "gender");
		String occupation = ParamUtil.getString(actionRequest, "occupation", null);
		int birthdayMonth = ParamUtil.getInteger(actionRequest, "birthdayMonth");
		int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");
		ServiceContext serviceContext = new ServiceContext();
		User user = UserLocalServiceUtil.fetchUser(userId);
		User userByEmail = UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), emailAddress);
		Contact _contact = ContactLocalServiceUtil.fetchContact(ContactId);
		System.out.println("Updatd Gender :::" + gender);
		if (Validator.isNull(user)) {
			SessionErrors.add(actionRequest, "user-not-found");
			_log.error("User not found with screenName: " + screenName);
			return;
		}
		if (Validator.isNotNull(userByEmail) && userByEmail.getUserId() != user.getUserId()) {
			SessionErrors.add(actionRequest, "email-already-in-use");
		}

		try {
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setScreenName(screenName);
			user.setEmailAddress(emailAddress);
			// Gender Updated
			_contact.setMale(gender);
			ContactLocalServiceUtil.updateContact(_contact);

			UserLocalServiceUtil.updateUser(user);

			// Handle profile picture update
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			File file = uploadPortletRequest.getFile("portraitImage");
			byte[] portraitBytes = FileUtil.getBytes(file);

			if (portraitBytes != null && portraitBytes.length > 0) {
				user = UserLocalServiceUtil.updatePortrait(user.getUserId(), portraitBytes);
			}

			// Redirect to the given URL or default to "/home"
			if (Validator.isNull(redirectURL)) {
				_log.error("Using default redirect.");
				redirectURL = "/agent";
			}
			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			_log.error("Error during user update", e);
		}
	}

	public void DeleteUser(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		try {
			long userId = ParamUtil.getLong(actionRequest, "userId");
			System.out.println(" Deleted Received :::::" + userId);
			User user = UserLocalServiceUtil.fetchUser(userId);
			if (Validator.isNotNull(user)) {
				UserLocalServiceUtil.deleteUser(userId);
				System.out.println("User deleed successfully");
			} else {
				System.out.println("No User  found for User: " + userId);
			}
		} catch (Exception e) {
			System.out.println("Error while deleting product profile: " + e.getMessage());
		}

	}

	/**
	 * dynamically userRole based user list
	 */
	/*
	 * @Override public void doView(RenderRequest renderRequest, RenderResponse
	 * renderResponse) throws PortletException, IOException { ThemeDisplay
	 * themeDisplay = (ThemeDisplay)
	 * renderRequest.getAttribute(WebKeys.THEME_DISPLAY); Role role; try { role =
	 * RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Agent");
	 * List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
	 * renderRequest.setAttribute("users", users); } catch (PortalException e) {
	 * e.printStackTrace(); } super.doView(renderRequest, renderResponse); }
	 */

	/**
	 * user role based data listed.
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Role> userRoles = themeDisplay.getUser().getRoles();

		boolean isPowerUserOrAdmin = isUserPowerUserOrAdmin(userRoles);
		if (isPowerUserOrAdmin) {

			try {

				Role AgentRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Agent");
				List<User> users = UserLocalServiceUtil.getRoleUsers(AgentRole.getRoleId());
				renderRequest.setAttribute("users", users);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("else inside  line 4017 :::::");
			renderRequest.setAttribute("users", Collections.singletonList(themeDisplay.getUser()));
		}
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * Helper method to check if the user has "Power User" or "Administrator" role.
	 */

	private boolean isUserPowerUserOrAdmin(List<Role> userRoles) {
		for (Role userRole : userRoles) {
			if ("Power User".equals(userRole.getName()) || "Administrator".equals(userRole.getName())) {
				return true;
			}
		}
		return false;
	}

	private static final Log _log = LogFactoryUtil.getLog(MtsAgentModulePortlet.class);

	@Reference
	private Portal _portal;
}