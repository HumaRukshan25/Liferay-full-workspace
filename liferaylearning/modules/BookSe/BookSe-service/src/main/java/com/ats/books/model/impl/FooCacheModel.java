/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.model.impl;

import com.ats.books.model.Foo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Foo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FooCacheModel implements CacheModel<Foo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FooCacheModel)) {
			return false;
		}

		FooCacheModel fooCacheModel = (FooCacheModel)object;

		if (fooId == fooCacheModel.fooId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fooId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fooId=");
		sb.append(fooId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Foo toEntityModel() {
		FooImpl fooImpl = new FooImpl();

		if (uuid == null) {
			fooImpl.setUuid("");
		}
		else {
			fooImpl.setUuid(uuid);
		}

		fooImpl.setFooId(fooId);
		fooImpl.setGroupId(groupId);
		fooImpl.setCompanyId(companyId);
		fooImpl.setUserId(userId);

		if (userName == null) {
			fooImpl.setUserName("");
		}
		else {
			fooImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			fooImpl.setCreateDate(null);
		}
		else {
			fooImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fooImpl.setModifiedDate(null);
		}
		else {
			fooImpl.setModifiedDate(new Date(modifiedDate));
		}

		fooImpl.resetOriginalValues();

		return fooImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fooId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fooId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long fooId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}