/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.model.impl;

import com.ats.courses.model.Courses;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Courses in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CoursesCacheModel implements CacheModel<Courses>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CoursesCacheModel)) {
			return false;
		}

		CoursesCacheModel coursesCacheModel = (CoursesCacheModel)object;

		if (coursesId == coursesCacheModel.coursesId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, coursesId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", coursesId=");
		sb.append(coursesId);
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
		sb.append(", Courses_img=");
		sb.append(Courses_img);
		sb.append(", Courses_name=");
		sb.append(Courses_name);
		sb.append(", Courses_des=");
		sb.append(Courses_des);
		sb.append(", Courses_type=");
		sb.append(Courses_type);
		sb.append(", Courses_rating=");
		sb.append(Courses_rating);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Courses toEntityModel() {
		CoursesImpl coursesImpl = new CoursesImpl();

		if (uuid == null) {
			coursesImpl.setUuid("");
		}
		else {
			coursesImpl.setUuid(uuid);
		}

		coursesImpl.setCoursesId(coursesId);
		coursesImpl.setGroupId(groupId);
		coursesImpl.setCompanyId(companyId);
		coursesImpl.setUserId(userId);

		if (userName == null) {
			coursesImpl.setUserName("");
		}
		else {
			coursesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			coursesImpl.setCreateDate(null);
		}
		else {
			coursesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			coursesImpl.setModifiedDate(null);
		}
		else {
			coursesImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (Courses_img == null) {
			coursesImpl.setCourses_img("");
		}
		else {
			coursesImpl.setCourses_img(Courses_img);
		}

		if (Courses_name == null) {
			coursesImpl.setCourses_name("");
		}
		else {
			coursesImpl.setCourses_name(Courses_name);
		}

		if (Courses_des == null) {
			coursesImpl.setCourses_des("");
		}
		else {
			coursesImpl.setCourses_des(Courses_des);
		}

		if (Courses_type == null) {
			coursesImpl.setCourses_type("");
		}
		else {
			coursesImpl.setCourses_type(Courses_type);
		}

		if (Courses_rating == null) {
			coursesImpl.setCourses_rating("");
		}
		else {
			coursesImpl.setCourses_rating(Courses_rating);
		}

		coursesImpl.setStatus(status);

		coursesImpl.resetOriginalValues();

		return coursesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		coursesId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		Courses_img = objectInput.readUTF();
		Courses_name = objectInput.readUTF();
		Courses_des = objectInput.readUTF();
		Courses_type = objectInput.readUTF();
		Courses_rating = objectInput.readUTF();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(coursesId);

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

		if (Courses_img == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Courses_img);
		}

		if (Courses_name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Courses_name);
		}

		if (Courses_des == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Courses_des);
		}

		if (Courses_type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Courses_type);
		}

		if (Courses_rating == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Courses_rating);
		}

		objectOutput.writeInt(status);
	}

	public String uuid;
	public long coursesId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String Courses_img;
	public String Courses_name;
	public String Courses_des;
	public String Courses_type;
	public String Courses_rating;
	public int status;

}