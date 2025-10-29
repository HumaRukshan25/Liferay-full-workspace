/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.model.impl;

import PracticeService1.model.CheckInOutApp;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CheckInOutApp in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CheckInOutAppCacheModel
	implements CacheModel<CheckInOutApp>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CheckInOutAppCacheModel)) {
			return false;
		}

		CheckInOutAppCacheModel checkInOutAppCacheModel =
			(CheckInOutAppCacheModel)object;

		if (logId == checkInOutAppCacheModel.logId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, logId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", logId=");
		sb.append(logId);
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
		sb.append(", checkInTime=");
		sb.append(checkInTime);
		sb.append(", checkOutTime=");
		sb.append(checkOutTime);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", location=");
		sb.append(location);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CheckInOutApp toEntityModel() {
		CheckInOutAppImpl checkInOutAppImpl = new CheckInOutAppImpl();

		if (uuid == null) {
			checkInOutAppImpl.setUuid("");
		}
		else {
			checkInOutAppImpl.setUuid(uuid);
		}

		checkInOutAppImpl.setLogId(logId);
		checkInOutAppImpl.setGroupId(groupId);
		checkInOutAppImpl.setCompanyId(companyId);
		checkInOutAppImpl.setUserId(userId);

		if (userName == null) {
			checkInOutAppImpl.setUserName("");
		}
		else {
			checkInOutAppImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			checkInOutAppImpl.setCreateDate(null);
		}
		else {
			checkInOutAppImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			checkInOutAppImpl.setModifiedDate(null);
		}
		else {
			checkInOutAppImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (checkInTime == Long.MIN_VALUE) {
			checkInOutAppImpl.setCheckInTime(null);
		}
		else {
			checkInOutAppImpl.setCheckInTime(new Date(checkInTime));
		}

		if (checkOutTime == Long.MIN_VALUE) {
			checkInOutAppImpl.setCheckOutTime(null);
		}
		else {
			checkInOutAppImpl.setCheckOutTime(new Date(checkOutTime));
		}

		if (remarks == null) {
			checkInOutAppImpl.setRemarks("");
		}
		else {
			checkInOutAppImpl.setRemarks(remarks);
		}

		if (location == null) {
			checkInOutAppImpl.setLocation("");
		}
		else {
			checkInOutAppImpl.setLocation(location);
		}

		checkInOutAppImpl.resetOriginalValues();

		return checkInOutAppImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		logId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		checkInTime = objectInput.readLong();
		checkOutTime = objectInput.readLong();
		remarks = objectInput.readUTF();
		location = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(logId);

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
		objectOutput.writeLong(checkInTime);
		objectOutput.writeLong(checkOutTime);

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}
	}

	public String uuid;
	public long logId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long checkInTime;
	public long checkOutTime;
	public String remarks;
	public String location;

}