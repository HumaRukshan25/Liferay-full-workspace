/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import fironlineser.model.PoliceStation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PoliceStation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PoliceStationCacheModel
	implements CacheModel<PoliceStation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PoliceStationCacheModel)) {
			return false;
		}

		PoliceStationCacheModel policeStationCacheModel =
			(PoliceStationCacheModel)object;

		if (stationId == policeStationCacheModel.stationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", stationId=");
		sb.append(stationId);
		sb.append(", stationName=");
		sb.append(stationName);
		sb.append(", address=");
		sb.append(address);
		sb.append(", jurisdictionArea=");
		sb.append(jurisdictionArea);
		sb.append(", officerInCharge=");
		sb.append(officerInCharge);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", status=");
		sb.append(status);
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
	public PoliceStation toEntityModel() {
		PoliceStationImpl policeStationImpl = new PoliceStationImpl();

		if (uuid == null) {
			policeStationImpl.setUuid("");
		}
		else {
			policeStationImpl.setUuid(uuid);
		}

		policeStationImpl.setStationId(stationId);

		if (stationName == null) {
			policeStationImpl.setStationName("");
		}
		else {
			policeStationImpl.setStationName(stationName);
		}

		if (address == null) {
			policeStationImpl.setAddress("");
		}
		else {
			policeStationImpl.setAddress(address);
		}

		if (jurisdictionArea == null) {
			policeStationImpl.setJurisdictionArea("");
		}
		else {
			policeStationImpl.setJurisdictionArea(jurisdictionArea);
		}

		if (officerInCharge == null) {
			policeStationImpl.setOfficerInCharge("");
		}
		else {
			policeStationImpl.setOfficerInCharge(officerInCharge);
		}

		if (contactNumber == null) {
			policeStationImpl.setContactNumber("");
		}
		else {
			policeStationImpl.setContactNumber(contactNumber);
		}

		if (email == null) {
			policeStationImpl.setEmail("");
		}
		else {
			policeStationImpl.setEmail(email);
		}

		if (status == null) {
			policeStationImpl.setStatus("");
		}
		else {
			policeStationImpl.setStatus(status);
		}

		policeStationImpl.setUserId(userId);

		if (userName == null) {
			policeStationImpl.setUserName("");
		}
		else {
			policeStationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			policeStationImpl.setCreateDate(null);
		}
		else {
			policeStationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			policeStationImpl.setModifiedDate(null);
		}
		else {
			policeStationImpl.setModifiedDate(new Date(modifiedDate));
		}

		policeStationImpl.resetOriginalValues();

		return policeStationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		stationId = objectInput.readLong();
		stationName = objectInput.readUTF();
		address = objectInput.readUTF();
		jurisdictionArea = objectInput.readUTF();
		officerInCharge = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		status = objectInput.readUTF();

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

		objectOutput.writeLong(stationId);

		if (stationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stationName);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (jurisdictionArea == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jurisdictionArea);
		}

		if (officerInCharge == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(officerInCharge);
		}

		if (contactNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactNumber);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

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
	public long stationId;
	public String stationName;
	public String address;
	public String jurisdictionArea;
	public String officerInCharge;
	public String contactNumber;
	public String email;
	public String status;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}