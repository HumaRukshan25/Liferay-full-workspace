/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SignupUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SignupUser
 * @generated
 */
public class SignupUserWrapper
	extends BaseModelWrapper<SignupUser>
	implements ModelWrapper<SignupUser>, SignupUser {

	public SignupUserWrapper(SignupUser signupUser) {
		super(signupUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("signupUserId", getSignupUserId());
		attributes.put("loginName", getLoginName());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());
		attributes.put("phoneNo", getPhoneNo());
		attributes.put("password_", getPassword_());
		attributes.put("role", getRole());
		attributes.put("active", isActive());
		attributes.put("activationToken", getActivationToken());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long signupUserId = (Long)attributes.get("signupUserId");

		if (signupUserId != null) {
			setSignupUserId(signupUserId);
		}

		String loginName = (String)attributes.get("loginName");

		if (loginName != null) {
			setLoginName(loginName);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phoneNo = (String)attributes.get("phoneNo");

		if (phoneNo != null) {
			setPhoneNo(phoneNo);
		}

		String password_ = (String)attributes.get("password_");

		if (password_ != null) {
			setPassword_(password_);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String activationToken = (String)attributes.get("activationToken");

		if (activationToken != null) {
			setActivationToken(activationToken);
		}
	}

	@Override
	public SignupUser cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the activation token of this signup user.
	 *
	 * @return the activation token of this signup user
	 */
	@Override
	public String getActivationToken() {
		return model.getActivationToken();
	}

	/**
	 * Returns the active of this signup user.
	 *
	 * @return the active of this signup user
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the email of this signup user.
	 *
	 * @return the email of this signup user
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the first name of this signup user.
	 *
	 * @return the first name of this signup user
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the last name of this signup user.
	 *
	 * @return the last name of this signup user
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the login name of this signup user.
	 *
	 * @return the login name of this signup user
	 */
	@Override
	public String getLoginName() {
		return model.getLoginName();
	}

	/**
	 * Returns the password_ of this signup user.
	 *
	 * @return the password_ of this signup user
	 */
	@Override
	public String getPassword_() {
		return model.getPassword_();
	}

	/**
	 * Returns the phone no of this signup user.
	 *
	 * @return the phone no of this signup user
	 */
	@Override
	public String getPhoneNo() {
		return model.getPhoneNo();
	}

	/**
	 * Returns the primary key of this signup user.
	 *
	 * @return the primary key of this signup user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role of this signup user.
	 *
	 * @return the role of this signup user
	 */
	@Override
	public String getRole() {
		return model.getRole();
	}

	/**
	 * Returns the signup user ID of this signup user.
	 *
	 * @return the signup user ID of this signup user
	 */
	@Override
	public long getSignupUserId() {
		return model.getSignupUserId();
	}

	/**
	 * Returns the signup user uuid of this signup user.
	 *
	 * @return the signup user uuid of this signup user
	 */
	@Override
	public String getSignupUserUuid() {
		return model.getSignupUserUuid();
	}

	/**
	 * Returns the uuid of this signup user.
	 *
	 * @return the uuid of this signup user
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this signup user is active.
	 *
	 * @return <code>true</code> if this signup user is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the activation token of this signup user.
	 *
	 * @param activationToken the activation token of this signup user
	 */
	@Override
	public void setActivationToken(String activationToken) {
		model.setActivationToken(activationToken);
	}

	/**
	 * Sets whether this signup user is active.
	 *
	 * @param active the active of this signup user
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the email of this signup user.
	 *
	 * @param email the email of this signup user
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the first name of this signup user.
	 *
	 * @param firstName the first name of this signup user
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the last name of this signup user.
	 *
	 * @param lastName the last name of this signup user
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the login name of this signup user.
	 *
	 * @param loginName the login name of this signup user
	 */
	@Override
	public void setLoginName(String loginName) {
		model.setLoginName(loginName);
	}

	/**
	 * Sets the password_ of this signup user.
	 *
	 * @param password_ the password_ of this signup user
	 */
	@Override
	public void setPassword_(String password_) {
		model.setPassword_(password_);
	}

	/**
	 * Sets the phone no of this signup user.
	 *
	 * @param phoneNo the phone no of this signup user
	 */
	@Override
	public void setPhoneNo(String phoneNo) {
		model.setPhoneNo(phoneNo);
	}

	/**
	 * Sets the primary key of this signup user.
	 *
	 * @param primaryKey the primary key of this signup user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role of this signup user.
	 *
	 * @param role the role of this signup user
	 */
	@Override
	public void setRole(String role) {
		model.setRole(role);
	}

	/**
	 * Sets the signup user ID of this signup user.
	 *
	 * @param signupUserId the signup user ID of this signup user
	 */
	@Override
	public void setSignupUserId(long signupUserId) {
		model.setSignupUserId(signupUserId);
	}

	/**
	 * Sets the signup user uuid of this signup user.
	 *
	 * @param signupUserUuid the signup user uuid of this signup user
	 */
	@Override
	public void setSignupUserUuid(String signupUserUuid) {
		model.setSignupUserUuid(signupUserUuid);
	}

	/**
	 * Sets the uuid of this signup user.
	 *
	 * @param uuid the uuid of this signup user
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SignupUserWrapper wrap(SignupUser signupUser) {
		return new SignupUserWrapper(signupUser);
	}

}