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
 * This class is a wrapper for {@link PoliceStation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PoliceStation
 * @generated
 */
public class PoliceStationWrapper
	extends BaseModelWrapper<PoliceStation>
	implements ModelWrapper<PoliceStation>, PoliceStation {

	public PoliceStationWrapper(PoliceStation policeStation) {
		super(policeStation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("stationId", getStationId());
		attributes.put("stationName", getStationName());
		attributes.put("address", getAddress());
		attributes.put("jurisdictionArea", getJurisdictionArea());
		attributes.put("officerInCharge", getOfficerInCharge());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("email", getEmail());
		attributes.put("status", getStatus());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
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

		Long stationId = (Long)attributes.get("stationId");

		if (stationId != null) {
			setStationId(stationId);
		}

		String stationName = (String)attributes.get("stationName");

		if (stationName != null) {
			setStationName(stationName);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String jurisdictionArea = (String)attributes.get("jurisdictionArea");

		if (jurisdictionArea != null) {
			setJurisdictionArea(jurisdictionArea);
		}

		String officerInCharge = (String)attributes.get("officerInCharge");

		if (officerInCharge != null) {
			setOfficerInCharge(officerInCharge);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
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
	public PoliceStation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this police station.
	 *
	 * @return the address of this police station
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the contact number of this police station.
	 *
	 * @return the contact number of this police station
	 */
	@Override
	public String getContactNumber() {
		return model.getContactNumber();
	}

	/**
	 * Returns the create date of this police station.
	 *
	 * @return the create date of this police station
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this police station.
	 *
	 * @return the email of this police station
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the jurisdiction area of this police station.
	 *
	 * @return the jurisdiction area of this police station
	 */
	@Override
	public String getJurisdictionArea() {
		return model.getJurisdictionArea();
	}

	/**
	 * Returns the modified date of this police station.
	 *
	 * @return the modified date of this police station
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the officer in charge of this police station.
	 *
	 * @return the officer in charge of this police station
	 */
	@Override
	public String getOfficerInCharge() {
		return model.getOfficerInCharge();
	}

	/**
	 * Returns the primary key of this police station.
	 *
	 * @return the primary key of this police station
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the station ID of this police station.
	 *
	 * @return the station ID of this police station
	 */
	@Override
	public long getStationId() {
		return model.getStationId();
	}

	/**
	 * Returns the station name of this police station.
	 *
	 * @return the station name of this police station
	 */
	@Override
	public String getStationName() {
		return model.getStationName();
	}

	/**
	 * Returns the status of this police station.
	 *
	 * @return the status of this police station
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this police station.
	 *
	 * @return the user ID of this police station
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this police station.
	 *
	 * @return the user name of this police station
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this police station.
	 *
	 * @return the user uuid of this police station
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this police station.
	 *
	 * @return the uuid of this police station
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
	 * Sets the address of this police station.
	 *
	 * @param address the address of this police station
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the contact number of this police station.
	 *
	 * @param contactNumber the contact number of this police station
	 */
	@Override
	public void setContactNumber(String contactNumber) {
		model.setContactNumber(contactNumber);
	}

	/**
	 * Sets the create date of this police station.
	 *
	 * @param createDate the create date of this police station
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this police station.
	 *
	 * @param email the email of this police station
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the jurisdiction area of this police station.
	 *
	 * @param jurisdictionArea the jurisdiction area of this police station
	 */
	@Override
	public void setJurisdictionArea(String jurisdictionArea) {
		model.setJurisdictionArea(jurisdictionArea);
	}

	/**
	 * Sets the modified date of this police station.
	 *
	 * @param modifiedDate the modified date of this police station
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the officer in charge of this police station.
	 *
	 * @param officerInCharge the officer in charge of this police station
	 */
	@Override
	public void setOfficerInCharge(String officerInCharge) {
		model.setOfficerInCharge(officerInCharge);
	}

	/**
	 * Sets the primary key of this police station.
	 *
	 * @param primaryKey the primary key of this police station
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the station ID of this police station.
	 *
	 * @param stationId the station ID of this police station
	 */
	@Override
	public void setStationId(long stationId) {
		model.setStationId(stationId);
	}

	/**
	 * Sets the station name of this police station.
	 *
	 * @param stationName the station name of this police station
	 */
	@Override
	public void setStationName(String stationName) {
		model.setStationName(stationName);
	}

	/**
	 * Sets the status of this police station.
	 *
	 * @param status the status of this police station
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this police station.
	 *
	 * @param userId the user ID of this police station
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this police station.
	 *
	 * @param userName the user name of this police station
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this police station.
	 *
	 * @param userUuid the user uuid of this police station
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this police station.
	 *
	 * @param uuid the uuid of this police station
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
	protected PoliceStationWrapper wrap(PoliceStation policeStation) {
		return new PoliceStationWrapper(policeStation);
	}

}