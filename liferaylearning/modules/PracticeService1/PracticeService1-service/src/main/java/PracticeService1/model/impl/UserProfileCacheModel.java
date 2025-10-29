/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.model.impl;

import PracticeService1.model.UserProfile;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserProfile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserProfileCacheModel
	implements CacheModel<UserProfile>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserProfileCacheModel)) {
			return false;
		}

		UserProfileCacheModel userProfileCacheModel =
			(UserProfileCacheModel)object;

		if (userId == userProfileCacheModel.userId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", password=");
		sb.append(password);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserProfile toEntityModel() {
		UserProfileImpl userProfileImpl = new UserProfileImpl();

		userProfileImpl.setUserId(userId);

		if (userName == null) {
			userProfileImpl.setUserName("");
		}
		else {
			userProfileImpl.setUserName(userName);
		}

		if (password == null) {
			userProfileImpl.setPassword("");
		}
		else {
			userProfileImpl.setPassword(password);
		}

		userProfileImpl.resetOriginalValues();

		return userProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		password = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}
	}

	public long userId;
	public String userName;
	public String password;

}