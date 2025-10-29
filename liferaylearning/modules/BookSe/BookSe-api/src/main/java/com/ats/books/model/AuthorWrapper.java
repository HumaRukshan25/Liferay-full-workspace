/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Author}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Author
 * @generated
 */
public class AuthorWrapper
	extends BaseModelWrapper<Author> implements Author, ModelWrapper<Author> {

	public AuthorWrapper(Author author) {
		super(author);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorId", getAuthorId());
		attributes.put("liferayUserId", getLiferayUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		Long liferayUserId = (Long)attributes.get("liferayUserId");

		if (liferayUserId != null) {
			setLiferayUserId(liferayUserId);
		}
	}

	@Override
	public Author cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the author ID of this author.
	 *
	 * @return the author ID of this author
	 */
	@Override
	public long getAuthorId() {
		return model.getAuthorId();
	}

	/**
	 * Returns the liferay user ID of this author.
	 *
	 * @return the liferay user ID of this author
	 */
	@Override
	public long getLiferayUserId() {
		return model.getLiferayUserId();
	}

	/**
	 * Returns the liferay user uuid of this author.
	 *
	 * @return the liferay user uuid of this author
	 */
	@Override
	public String getLiferayUserUuid() {
		return model.getLiferayUserUuid();
	}

	/**
	 * Returns the primary key of this author.
	 *
	 * @return the primary key of this author
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the author ID of this author.
	 *
	 * @param authorId the author ID of this author
	 */
	@Override
	public void setAuthorId(long authorId) {
		model.setAuthorId(authorId);
	}

	/**
	 * Sets the liferay user ID of this author.
	 *
	 * @param liferayUserId the liferay user ID of this author
	 */
	@Override
	public void setLiferayUserId(long liferayUserId) {
		model.setLiferayUserId(liferayUserId);
	}

	/**
	 * Sets the liferay user uuid of this author.
	 *
	 * @param liferayUserUuid the liferay user uuid of this author
	 */
	@Override
	public void setLiferayUserUuid(String liferayUserUuid) {
		model.setLiferayUserUuid(liferayUserUuid);
	}

	/**
	 * Sets the primary key of this author.
	 *
	 * @param primaryKey the primary key of this author
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected AuthorWrapper wrap(Author author) {
		return new AuthorWrapper(author);
	}

}