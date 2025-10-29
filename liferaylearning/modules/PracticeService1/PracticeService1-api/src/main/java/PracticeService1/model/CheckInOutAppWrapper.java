/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CheckInOutApp}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CheckInOutApp
 * @generated
 */
public class CheckInOutAppWrapper
	extends BaseModelWrapper<CheckInOutApp>
	implements CheckInOutApp, ModelWrapper<CheckInOutApp> {

	public CheckInOutAppWrapper(CheckInOutApp checkInOutApp) {
		super(checkInOutApp);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("logId", getLogId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("checkInTime", getCheckInTime());
		attributes.put("checkOutTime", getCheckOutTime());
		attributes.put("remarks", getRemarks());
		attributes.put("location", getLocation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long logId = (Long)attributes.get("logId");

		if (logId != null) {
			setLogId(logId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Date checkInTime = (Date)attributes.get("checkInTime");

		if (checkInTime != null) {
			setCheckInTime(checkInTime);
		}

		Date checkOutTime = (Date)attributes.get("checkOutTime");

		if (checkOutTime != null) {
			setCheckOutTime(checkOutTime);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}
	}

	@Override
	public CheckInOutApp cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the check in time of this check in out app.
	 *
	 * @return the check in time of this check in out app
	 */
	@Override
	public Date getCheckInTime() {
		return model.getCheckInTime();
	}

	/**
	 * Returns the check out time of this check in out app.
	 *
	 * @return the check out time of this check in out app
	 */
	@Override
	public Date getCheckOutTime() {
		return model.getCheckOutTime();
	}

	/**
	 * Returns the company ID of this check in out app.
	 *
	 * @return the company ID of this check in out app
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this check in out app.
	 *
	 * @return the create date of this check in out app
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this check in out app.
	 *
	 * @return the group ID of this check in out app
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the location of this check in out app.
	 *
	 * @return the location of this check in out app
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the log ID of this check in out app.
	 *
	 * @return the log ID of this check in out app
	 */
	@Override
	public long getLogId() {
		return model.getLogId();
	}

	/**
	 * Returns the modified date of this check in out app.
	 *
	 * @return the modified date of this check in out app
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this check in out app.
	 *
	 * @return the primary key of this check in out app
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remarks of this check in out app.
	 *
	 * @return the remarks of this check in out app
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the user ID of this check in out app.
	 *
	 * @return the user ID of this check in out app
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this check in out app.
	 *
	 * @return the user name of this check in out app
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this check in out app.
	 *
	 * @return the user uuid of this check in out app
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this check in out app.
	 *
	 * @return the uuid of this check in out app
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
	 * Sets the check in time of this check in out app.
	 *
	 * @param checkInTime the check in time of this check in out app
	 */
	@Override
	public void setCheckInTime(Date checkInTime) {
		model.setCheckInTime(checkInTime);
	}

	/**
	 * Sets the check out time of this check in out app.
	 *
	 * @param checkOutTime the check out time of this check in out app
	 */
	@Override
	public void setCheckOutTime(Date checkOutTime) {
		model.setCheckOutTime(checkOutTime);
	}

	/**
	 * Sets the company ID of this check in out app.
	 *
	 * @param companyId the company ID of this check in out app
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this check in out app.
	 *
	 * @param createDate the create date of this check in out app
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this check in out app.
	 *
	 * @param groupId the group ID of this check in out app
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the location of this check in out app.
	 *
	 * @param location the location of this check in out app
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the log ID of this check in out app.
	 *
	 * @param logId the log ID of this check in out app
	 */
	@Override
	public void setLogId(long logId) {
		model.setLogId(logId);
	}

	/**
	 * Sets the modified date of this check in out app.
	 *
	 * @param modifiedDate the modified date of this check in out app
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this check in out app.
	 *
	 * @param primaryKey the primary key of this check in out app
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remarks of this check in out app.
	 *
	 * @param remarks the remarks of this check in out app
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the user ID of this check in out app.
	 *
	 * @param userId the user ID of this check in out app
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this check in out app.
	 *
	 * @param userName the user name of this check in out app
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this check in out app.
	 *
	 * @param userUuid the user uuid of this check in out app
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this check in out app.
	 *
	 * @param uuid the uuid of this check in out app
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
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CheckInOutAppWrapper wrap(CheckInOutApp checkInOutApp) {
		return new CheckInOutAppWrapper(checkInOutApp);
	}

}