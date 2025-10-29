/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.model.impl;

import com.ats.books.model.Author;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Author in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AuthorCacheModel implements CacheModel<Author>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AuthorCacheModel)) {
			return false;
		}

		AuthorCacheModel authorCacheModel = (AuthorCacheModel)object;

		if (authorId == authorCacheModel.authorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, authorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{authorId=");
		sb.append(authorId);
		sb.append(", liferayUserId=");
		sb.append(liferayUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Author toEntityModel() {
		AuthorImpl authorImpl = new AuthorImpl();

		authorImpl.setAuthorId(authorId);
		authorImpl.setLiferayUserId(liferayUserId);

		authorImpl.resetOriginalValues();

		return authorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		authorId = objectInput.readLong();

		liferayUserId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(authorId);

		objectOutput.writeLong(liferayUserId);
	}

	public long authorId;
	public long liferayUserId;

}