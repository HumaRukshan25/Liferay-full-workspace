/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the BookCategory service. Represents a row in the &quot;BOOKKK_BookCategory&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see BookCategoryModel
 * @generated
 */
@ImplementationClassName("com.ats.books.model.impl.BookCategoryImpl")
@ProviderType
public interface BookCategory extends BookCategoryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ats.books.model.impl.BookCategoryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BookCategory, Long> CATEGORY_ID_ACCESSOR =
		new Accessor<BookCategory, Long>() {

			@Override
			public Long get(BookCategory bookCategory) {
				return bookCategory.getCategoryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<BookCategory> getTypeClass() {
				return BookCategory.class;
			}

		};

}