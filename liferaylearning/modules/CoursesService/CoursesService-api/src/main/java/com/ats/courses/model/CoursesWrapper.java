/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Courses}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Courses
 * @generated
 */
public class CoursesWrapper
	extends BaseModelWrapper<Courses>
	implements Courses, ModelWrapper<Courses> {

	public CoursesWrapper(Courses courses) {
		super(courses);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("coursesId", getCoursesId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("Courses_img", getCourses_img());
		attributes.put("Courses_name", getCourses_name());
		attributes.put("Courses_des", getCourses_des());
		attributes.put("Courses_type", getCourses_type());
		attributes.put("Courses_rating", getCourses_rating());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long coursesId = (Long)attributes.get("coursesId");

		if (coursesId != null) {
			setCoursesId(coursesId);
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

		String Courses_img = (String)attributes.get("Courses_img");

		if (Courses_img != null) {
			setCourses_img(Courses_img);
		}

		String Courses_name = (String)attributes.get("Courses_name");

		if (Courses_name != null) {
			setCourses_name(Courses_name);
		}

		String Courses_des = (String)attributes.get("Courses_des");

		if (Courses_des != null) {
			setCourses_des(Courses_des);
		}

		String Courses_type = (String)attributes.get("Courses_type");

		if (Courses_type != null) {
			setCourses_type(Courses_type);
		}

		String Courses_rating = (String)attributes.get("Courses_rating");

		if (Courses_rating != null) {
			setCourses_rating(Courses_rating);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Courses cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this courses.
	 *
	 * @return the company ID of this courses
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the courses_des of this courses.
	 *
	 * @return the courses_des of this courses
	 */
	@Override
	public String getCourses_des() {
		return model.getCourses_des();
	}

	/**
	 * Returns the courses_img of this courses.
	 *
	 * @return the courses_img of this courses
	 */
	@Override
	public String getCourses_img() {
		return model.getCourses_img();
	}

	/**
	 * Returns the courses_name of this courses.
	 *
	 * @return the courses_name of this courses
	 */
	@Override
	public String getCourses_name() {
		return model.getCourses_name();
	}

	/**
	 * Returns the courses_rating of this courses.
	 *
	 * @return the courses_rating of this courses
	 */
	@Override
	public String getCourses_rating() {
		return model.getCourses_rating();
	}

	/**
	 * Returns the courses_type of this courses.
	 *
	 * @return the courses_type of this courses
	 */
	@Override
	public String getCourses_type() {
		return model.getCourses_type();
	}

	/**
	 * Returns the courses ID of this courses.
	 *
	 * @return the courses ID of this courses
	 */
	@Override
	public long getCoursesId() {
		return model.getCoursesId();
	}

	/**
	 * Returns the create date of this courses.
	 *
	 * @return the create date of this courses
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this courses.
	 *
	 * @return the group ID of this courses
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this courses.
	 *
	 * @return the modified date of this courses
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this courses.
	 *
	 * @return the primary key of this courses
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this courses.
	 *
	 * @return the status of this courses
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this courses.
	 *
	 * @return the user ID of this courses
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this courses.
	 *
	 * @return the user name of this courses
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this courses.
	 *
	 * @return the user uuid of this courses
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this courses.
	 *
	 * @return the uuid of this courses
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
	 * Sets the company ID of this courses.
	 *
	 * @param companyId the company ID of this courses
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the courses_des of this courses.
	 *
	 * @param Courses_des the courses_des of this courses
	 */
	@Override
	public void setCourses_des(String Courses_des) {
		model.setCourses_des(Courses_des);
	}

	/**
	 * Sets the courses_img of this courses.
	 *
	 * @param Courses_img the courses_img of this courses
	 */
	@Override
	public void setCourses_img(String Courses_img) {
		model.setCourses_img(Courses_img);
	}

	/**
	 * Sets the courses_name of this courses.
	 *
	 * @param Courses_name the courses_name of this courses
	 */
	@Override
	public void setCourses_name(String Courses_name) {
		model.setCourses_name(Courses_name);
	}

	/**
	 * Sets the courses_rating of this courses.
	 *
	 * @param Courses_rating the courses_rating of this courses
	 */
	@Override
	public void setCourses_rating(String Courses_rating) {
		model.setCourses_rating(Courses_rating);
	}

	/**
	 * Sets the courses_type of this courses.
	 *
	 * @param Courses_type the courses_type of this courses
	 */
	@Override
	public void setCourses_type(String Courses_type) {
		model.setCourses_type(Courses_type);
	}

	/**
	 * Sets the courses ID of this courses.
	 *
	 * @param coursesId the courses ID of this courses
	 */
	@Override
	public void setCoursesId(long coursesId) {
		model.setCoursesId(coursesId);
	}

	/**
	 * Sets the create date of this courses.
	 *
	 * @param createDate the create date of this courses
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this courses.
	 *
	 * @param groupId the group ID of this courses
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this courses.
	 *
	 * @param modifiedDate the modified date of this courses
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this courses.
	 *
	 * @param primaryKey the primary key of this courses
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this courses.
	 *
	 * @param status the status of this courses
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this courses.
	 *
	 * @param userId the user ID of this courses
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this courses.
	 *
	 * @param userName the user name of this courses
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this courses.
	 *
	 * @param userUuid the user uuid of this courses
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this courses.
	 *
	 * @param uuid the uuid of this courses
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
	protected CoursesWrapper wrap(Courses courses) {
		return new CoursesWrapper(courses);
	}

}