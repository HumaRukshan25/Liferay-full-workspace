/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.model.impl;

import com.ats.books.model.Books;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Books in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BooksCacheModel implements CacheModel<Books>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BooksCacheModel)) {
			return false;
		}

		BooksCacheModel booksCacheModel = (BooksCacheModel)object;

		if (bookId == booksCacheModel.bookId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bookId=");
		sb.append(bookId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", author=");
		sb.append(author);
		sb.append(", publishDate=");
		sb.append(publishDate);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Books toEntityModel() {
		BooksImpl booksImpl = new BooksImpl();

		if (uuid == null) {
			booksImpl.setUuid("");
		}
		else {
			booksImpl.setUuid(uuid);
		}

		booksImpl.setBookId(bookId);
		booksImpl.setGroupId(groupId);
		booksImpl.setCompanyId(companyId);
		booksImpl.setUserId(userId);

		if (userName == null) {
			booksImpl.setUserName("");
		}
		else {
			booksImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			booksImpl.setCreateDate(null);
		}
		else {
			booksImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			booksImpl.setModifiedDate(null);
		}
		else {
			booksImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			booksImpl.setTitle("");
		}
		else {
			booksImpl.setTitle(title);
		}

		if (author == null) {
			booksImpl.setAuthor("");
		}
		else {
			booksImpl.setAuthor(author);
		}

		if (publishDate == Long.MIN_VALUE) {
			booksImpl.setPublishDate(null);
		}
		else {
			booksImpl.setPublishDate(new Date(publishDate));
		}

		booksImpl.setCategoryId(categoryId);

		booksImpl.resetOriginalValues();

		return booksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bookId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		author = objectInput.readUTF();
		publishDate = objectInput.readLong();

		categoryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(bookId);

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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (author == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(author);
		}

		objectOutput.writeLong(publishDate);

		objectOutput.writeLong(categoryId);
	}

	public String uuid;
	public long bookId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String author;
	public long publishDate;
	public long categoryId;

}