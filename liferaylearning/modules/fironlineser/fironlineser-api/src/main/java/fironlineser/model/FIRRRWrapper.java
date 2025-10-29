/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FIRRR}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FIRRR
 * @generated
 */
public class FIRRRWrapper
	extends BaseModelWrapper<FIRRR> implements FIRRR, ModelWrapper<FIRRR> {

	public FIRRRWrapper(FIRRR firrr) {
		super(firrr);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("firId", getFirId());
		attributes.put("complainantName", getComplainantName());
		attributes.put("incidentDate", getIncidentDate());
		attributes.put("incidentDetails", getIncidentDetails());
		attributes.put("incidentLocation", getIncidentLocation());
		attributes.put("status", getStatus());
		attributes.put("timeline", getTimeline());
		attributes.put("modificationDetails", getModificationDetails());
		attributes.put("assignedInspector", getAssignedInspector());
		attributes.put("proofFileName", getProofFileName());
		attributes.put("proofFilePath", getProofFilePath());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long firId = (Long)attributes.get("firId");

		if (firId != null) {
			setFirId(firId);
		}

		String complainantName = (String)attributes.get("complainantName");

		if (complainantName != null) {
			setComplainantName(complainantName);
		}

		Date incidentDate = (Date)attributes.get("incidentDate");

		if (incidentDate != null) {
			setIncidentDate(incidentDate);
		}

		String incidentDetails = (String)attributes.get("incidentDetails");

		if (incidentDetails != null) {
			setIncidentDetails(incidentDetails);
		}

		String incidentLocation = (String)attributes.get("incidentLocation");

		if (incidentLocation != null) {
			setIncidentLocation(incidentLocation);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String timeline = (String)attributes.get("timeline");

		if (timeline != null) {
			setTimeline(timeline);
		}

		String modificationDetails = (String)attributes.get(
			"modificationDetails");

		if (modificationDetails != null) {
			setModificationDetails(modificationDetails);
		}

		String assignedInspector = (String)attributes.get("assignedInspector");

		if (assignedInspector != null) {
			setAssignedInspector(assignedInspector);
		}

		String proofFileName = (String)attributes.get("proofFileName");

		if (proofFileName != null) {
			setProofFileName(proofFileName);
		}

		String proofFilePath = (String)attributes.get("proofFilePath");

		if (proofFilePath != null) {
			setProofFilePath(proofFilePath);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public FIRRR cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the assigned inspector of this firrr.
	 *
	 * @return the assigned inspector of this firrr
	 */
	@Override
	public String getAssignedInspector() {
		return model.getAssignedInspector();
	}

	/**
	 * Returns the complainant name of this firrr.
	 *
	 * @return the complainant name of this firrr
	 */
	@Override
	public String getComplainantName() {
		return model.getComplainantName();
	}

	/**
	 * Returns the create date of this firrr.
	 *
	 * @return the create date of this firrr
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the fir ID of this firrr.
	 *
	 * @return the fir ID of this firrr
	 */
	@Override
	public long getFirId() {
		return model.getFirId();
	}

	/**
	 * Returns the incident date of this firrr.
	 *
	 * @return the incident date of this firrr
	 */
	@Override
	public Date getIncidentDate() {
		return model.getIncidentDate();
	}

	/**
	 * Returns the incident details of this firrr.
	 *
	 * @return the incident details of this firrr
	 */
	@Override
	public String getIncidentDetails() {
		return model.getIncidentDetails();
	}

	/**
	 * Returns the incident location of this firrr.
	 *
	 * @return the incident location of this firrr
	 */
	@Override
	public String getIncidentLocation() {
		return model.getIncidentLocation();
	}

	/**
	 * Returns the modification details of this firrr.
	 *
	 * @return the modification details of this firrr
	 */
	@Override
	public String getModificationDetails() {
		return model.getModificationDetails();
	}

	/**
	 * Returns the modified date of this firrr.
	 *
	 * @return the modified date of this firrr
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this firrr.
	 *
	 * @return the primary key of this firrr
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the proof file name of this firrr.
	 *
	 * @return the proof file name of this firrr
	 */
	@Override
	public String getProofFileName() {
		return model.getProofFileName();
	}

	/**
	 * Returns the proof file path of this firrr.
	 *
	 * @return the proof file path of this firrr
	 */
	@Override
	public String getProofFilePath() {
		return model.getProofFilePath();
	}

	/**
	 * Returns the status of this firrr.
	 *
	 * @return the status of this firrr
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the timeline of this firrr.
	 *
	 * @return the timeline of this firrr
	 */
	@Override
	public String getTimeline() {
		return model.getTimeline();
	}

	/**
	 * Returns the user ID of this firrr.
	 *
	 * @return the user ID of this firrr
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this firrr.
	 *
	 * @return the user uuid of this firrr
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this firrr.
	 *
	 * @return the uuid of this firrr
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the assigned inspector of this firrr.
	 *
	 * @param assignedInspector the assigned inspector of this firrr
	 */
	@Override
	public void setAssignedInspector(String assignedInspector) {
		model.setAssignedInspector(assignedInspector);
	}

	/**
	 * Sets the complainant name of this firrr.
	 *
	 * @param complainantName the complainant name of this firrr
	 */
	@Override
	public void setComplainantName(String complainantName) {
		model.setComplainantName(complainantName);
	}

	/**
	 * Sets the create date of this firrr.
	 *
	 * @param createDate the create date of this firrr
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the fir ID of this firrr.
	 *
	 * @param firId the fir ID of this firrr
	 */
	@Override
	public void setFirId(long firId) {
		model.setFirId(firId);
	}

	/**
	 * Sets the incident date of this firrr.
	 *
	 * @param incidentDate the incident date of this firrr
	 */
	@Override
	public void setIncidentDate(Date incidentDate) {
		model.setIncidentDate(incidentDate);
	}

	/**
	 * Sets the incident details of this firrr.
	 *
	 * @param incidentDetails the incident details of this firrr
	 */
	@Override
	public void setIncidentDetails(String incidentDetails) {
		model.setIncidentDetails(incidentDetails);
	}

	/**
	 * Sets the incident location of this firrr.
	 *
	 * @param incidentLocation the incident location of this firrr
	 */
	@Override
	public void setIncidentLocation(String incidentLocation) {
		model.setIncidentLocation(incidentLocation);
	}

	/**
	 * Sets the modification details of this firrr.
	 *
	 * @param modificationDetails the modification details of this firrr
	 */
	@Override
	public void setModificationDetails(String modificationDetails) {
		model.setModificationDetails(modificationDetails);
	}

	/**
	 * Sets the modified date of this firrr.
	 *
	 * @param modifiedDate the modified date of this firrr
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this firrr.
	 *
	 * @param primaryKey the primary key of this firrr
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the proof file name of this firrr.
	 *
	 * @param proofFileName the proof file name of this firrr
	 */
	@Override
	public void setProofFileName(String proofFileName) {
		model.setProofFileName(proofFileName);
	}

	/**
	 * Sets the proof file path of this firrr.
	 *
	 * @param proofFilePath the proof file path of this firrr
	 */
	@Override
	public void setProofFilePath(String proofFilePath) {
		model.setProofFilePath(proofFilePath);
	}

	/**
	 * Sets the status of this firrr.
	 *
	 * @param status the status of this firrr
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the timeline of this firrr.
	 *
	 * @param timeline the timeline of this firrr
	 */
	@Override
	public void setTimeline(String timeline) {
		model.setTimeline(timeline);
	}

	/**
	 * Sets the user ID of this firrr.
	 *
	 * @param userId the user ID of this firrr
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this firrr.
	 *
	 * @param userUuid the user uuid of this firrr
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this firrr.
	 *
	 * @param uuid the uuid of this firrr
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
	protected FIRRRWrapper wrap(FIRRR firrr) {
		return new FIRRRWrapper(firrr);
	}

	@Override
	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}

}