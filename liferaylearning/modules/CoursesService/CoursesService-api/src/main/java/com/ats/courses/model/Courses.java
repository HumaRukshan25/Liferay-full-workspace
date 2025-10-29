/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Courses service. Represents a row in the &quot;ATS_Courses&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CoursesModel
 * @generated
 */
@ImplementationClassName("com.ats.courses.model.impl.CoursesImpl")
@ProviderType
public interface Courses extends CoursesModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ats.courses.model.impl.CoursesImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Courses, Long> COURSES_ID_ACCESSOR =
		new Accessor<Courses, Long>() {

			@Override
			public Long get(Courses courses) {
				return courses.getCoursesId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Courses> getTypeClass() {
				return Courses.class;
			}

		};

}