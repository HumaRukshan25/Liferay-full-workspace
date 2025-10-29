/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import fironlineser.model.SignupUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SignupUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SignupUserCacheModel
	implements CacheModel<SignupUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SignupUserCacheModel)) {
			return false;
		}

		SignupUserCacheModel signupUserCacheModel =
			(SignupUserCacheModel)object;

		if (signupUserId == signupUserCacheModel.signupUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, signupUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", signupUserId=");
		sb.append(signupUserId);
		sb.append(", loginName=");
		sb.append(loginName);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phoneNo=");
		sb.append(phoneNo);
		sb.append(", password_=");
		sb.append(password_);
		sb.append(", role=");
		sb.append(role);
		sb.append(", active=");
		sb.append(active);
		sb.append(", activationToken=");
		sb.append(activationToken);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SignupUser toEntityModel() {
		SignupUserImpl signupUserImpl = new SignupUserImpl();

		if (uuid == null) {
			signupUserImpl.setUuid("");
		}
		else {
			signupUserImpl.setUuid(uuid);
		}

		signupUserImpl.setSignupUserId(signupUserId);

		if (loginName == null) {
			signupUserImpl.setLoginName("");
		}
		else {
			signupUserImpl.setLoginName(loginName);
		}

		if (firstName == null) {
			signupUserImpl.setFirstName("");
		}
		else {
			signupUserImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			signupUserImpl.setLastName("");
		}
		else {
			signupUserImpl.setLastName(lastName);
		}

		if (email == null) {
			signupUserImpl.setEmail("");
		}
		else {
			signupUserImpl.setEmail(email);
		}

		if (phoneNo == null) {
			signupUserImpl.setPhoneNo("");
		}
		else {
			signupUserImpl.setPhoneNo(phoneNo);
		}

		if (password_ == null) {
			signupUserImpl.setPassword_("");
		}
		else {
			signupUserImpl.setPassword_(password_);
		}

		if (role == null) {
			signupUserImpl.setRole("");
		}
		else {
			signupUserImpl.setRole(role);
		}

		signupUserImpl.setActive(active);

		if (activationToken == null) {
			signupUserImpl.setActivationToken("");
		}
		else {
			signupUserImpl.setActivationToken(activationToken);
		}

		signupUserImpl.resetOriginalValues();

		return signupUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		signupUserId = objectInput.readLong();
		loginName = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		email = objectInput.readUTF();
		phoneNo = objectInput.readUTF();
		password_ = objectInput.readUTF();
		role = objectInput.readUTF();

		active = objectInput.readBoolean();
		activationToken = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(signupUserId);

		if (loginName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(loginName);
		}

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phoneNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNo);
		}

		if (password_ == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password_);
		}

		if (role == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(role);
		}

		objectOutput.writeBoolean(active);

		if (activationToken == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(activationToken);
		}
	}

	public String uuid;
	public long signupUserId;
	public String loginName;
	public String firstName;
	public String lastName;
	public String email;
	public String phoneNo;
	public String password_;
	public String role;
	public boolean active;
	public String activationToken;

}