/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.model.impl;

import com.ats.books.model.BookCategory;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BookCategory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BookCategoryCacheModel
	implements CacheModel<BookCategory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BookCategoryCacheModel)) {
			return false;
		}

		BookCategoryCacheModel bookCategoryCacheModel =
			(BookCategoryCacheModel)object;

		if (categoryId == bookCategoryCacheModel.categoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, categoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", categoryId=");
		sb.append(categoryId);
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
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", bookId=");
		sb.append(bookId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BookCategory toEntityModel() {
		BookCategoryImpl bookCategoryImpl = new BookCategoryImpl();

		if (uuid == null) {
			bookCategoryImpl.setUuid("");
		}
		else {
			bookCategoryImpl.setUuid(uuid);
		}

		bookCategoryImpl.setCategoryId(categoryId);
		bookCategoryImpl.setGroupId(groupId);
		bookCategoryImpl.setCompanyId(companyId);
		bookCategoryImpl.setUserId(userId);

		if (userName == null) {
			bookCategoryImpl.setUserName("");
		}
		else {
			bookCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			bookCategoryImpl.setCreateDate(null);
		}
		else {
			bookCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bookCategoryImpl.setModifiedDate(null);
		}
		else {
			bookCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (categoryName == null) {
			bookCategoryImpl.setCategoryName("");
		}
		else {
			bookCategoryImpl.setCategoryName(categoryName);
		}

		bookCategoryImpl.setBookId(bookId);

		bookCategoryImpl.resetOriginalValues();

		return bookCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		categoryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		categoryName = objectInput.readUTF();

		bookId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(categoryId);

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

		if (categoryName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoryName);
		}

		objectOutput.writeLong(bookId);
	}

	public String uuid;
	public long categoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String categoryName;
	public long bookId;

}