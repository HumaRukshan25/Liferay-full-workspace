/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import fironlineser.model.FIRRR;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FIRRR in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FIRRRCacheModel implements CacheModel<FIRRR>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FIRRRCacheModel)) {
			return false;
		}

		FIRRRCacheModel firrrCacheModel = (FIRRRCacheModel)object;

		if (firId == firrrCacheModel.firId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, firId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", firId=");
		sb.append(firId);
		sb.append(", complainantName=");
		sb.append(complainantName);
		sb.append(", incidentDate=");
		sb.append(incidentDate);
		sb.append(", incidentDetails=");
		sb.append(incidentDetails);
		sb.append(", incidentLocation=");
		sb.append(incidentLocation);
		sb.append(", status=");
		sb.append(status);
		sb.append(", timeline=");
		sb.append(timeline);
		sb.append(", modificationDetails=");
		sb.append(modificationDetails);
		sb.append(", assignedInspector=");
		sb.append(assignedInspector);
		sb.append(", proofFileName=");
		sb.append(proofFileName);
		sb.append(", proofFilePath=");
		sb.append(proofFilePath);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FIRRR toEntityModel() {
		FIRRRImpl firrrImpl = new FIRRRImpl();

		if (uuid == null) {
			firrrImpl.setUuid("");
		}
		else {
			firrrImpl.setUuid(uuid);
		}

		firrrImpl.setFirId(firId);

		if (complainantName == null) {
			firrrImpl.setComplainantName("");
		}
		else {
			firrrImpl.setComplainantName(complainantName);
		}

		if (incidentDate == Long.MIN_VALUE) {
			firrrImpl.setIncidentDate(null);
		}
		else {
			firrrImpl.setIncidentDate(new Date(incidentDate));
		}

		if (incidentDetails == null) {
			firrrImpl.setIncidentDetails("");
		}
		else {
			firrrImpl.setIncidentDetails(incidentDetails);
		}

		if (incidentLocation == null) {
			firrrImpl.setIncidentLocation("");
		}
		else {
			firrrImpl.setIncidentLocation(incidentLocation);
		}

		if (status == null) {
			firrrImpl.setStatus("");
		}
		else {
			firrrImpl.setStatus(status);
		}

		if (timeline == null) {
			firrrImpl.setTimeline("");
		}
		else {
			firrrImpl.setTimeline(timeline);
		}

		if (modificationDetails == null) {
			firrrImpl.setModificationDetails("");
		}
		else {
			firrrImpl.setModificationDetails(modificationDetails);
		}

		if (assignedInspector == null) {
			firrrImpl.setAssignedInspector("");
		}
		else {
			firrrImpl.setAssignedInspector(assignedInspector);
		}

		if (proofFileName == null) {
			firrrImpl.setProofFileName("");
		}
		else {
			firrrImpl.setProofFileName(proofFileName);
		}

		if (proofFilePath == null) {
			firrrImpl.setProofFilePath("");
		}
		else {
			firrrImpl.setProofFilePath(proofFilePath);
		}

		firrrImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			firrrImpl.setCreateDate(null);
		}
		else {
			firrrImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			firrrImpl.setModifiedDate(null);
		}
		else {
			firrrImpl.setModifiedDate(new Date(modifiedDate));
		}

		firrrImpl.resetOriginalValues();

		return firrrImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		firId = objectInput.readLong();
		complainantName = objectInput.readUTF();
		incidentDate = objectInput.readLong();
		incidentDetails = objectInput.readUTF();
		incidentLocation = objectInput.readUTF();
		status = objectInput.readUTF();
		timeline = objectInput.readUTF();
		modificationDetails = objectInput.readUTF();
		assignedInspector = objectInput.readUTF();
		proofFileName = objectInput.readUTF();
		proofFilePath = objectInput.readUTF();

		userId = objectInput.readLong();
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

		objectOutput.writeLong(firId);

		if (complainantName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(complainantName);
		}

		objectOutput.writeLong(incidentDate);

		if (incidentDetails == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(incidentDetails);
		}

		if (incidentLocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(incidentLocation);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (timeline == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(timeline);
		}

		if (modificationDetails == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modificationDetails);
		}

		if (assignedInspector == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(assignedInspector);
		}

		if (proofFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(proofFileName);
		}

		if (proofFilePath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(proofFilePath);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long firId;
	public String complainantName;
	public long incidentDate;
	public String incidentDetails;
	public String incidentLocation;
	public String status;
	public String timeline;
	public String modificationDetails;
	public String assignedInspector;
	public String proofFileName;
	public String proofFilePath;
	public long userId;
	public long createDate;
	public long modifiedDate;

}