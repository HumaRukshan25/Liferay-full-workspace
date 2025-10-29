/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserProfile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserProfile
 * @generated
 */
public class UserProfileWrapper
	extends BaseModelWrapper<UserProfile>
	implements ModelWrapper<UserProfile>, UserProfile {

	public UserProfileWrapper(UserProfile userProfile) {
		super(userProfile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("password", getPassword());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}
	}

	@Override
	public UserProfile cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the password of this user profile.
	 *
	 * @return the password of this user profile
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the primary key of this user profile.
	 *
	 * @return the primary key of this user profile
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this user profile.
	 *
	 * @return the user ID of this user profile
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this user profile.
	 *
	 * @return the user name of this user profile
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this user profile.
	 *
	 * @return the user uuid of this user profile
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the password of this user profile.
	 *
	 * @param password the password of this user profile
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the primary key of this user profile.
	 *
	 * @param primaryKey the primary key of this user profile
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this user profile.
	 *
	 * @param userId the user ID of this user profile
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this user profile.
	 *
	 * @param userName the user name of this user profile
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this user profile.
	 *
	 * @param userUuid the user uuid of this user profile
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected UserProfileWrapper wrap(UserProfile userProfile) {
		return new UserProfileWrapper(userProfile);
	}

}