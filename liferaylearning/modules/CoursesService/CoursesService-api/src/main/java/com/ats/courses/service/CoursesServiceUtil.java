/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.service;

import com.liferay.portal.kernel.module.service.Snapshot;

/**
 * Provides the remote service utility for Courses. This utility wraps
 * <code>com.ats.courses.service.impl.CoursesServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CoursesService
 * @generated
 */
public class CoursesServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ats.courses.service.impl.CoursesServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addCourses(
			javax.portlet.ActionRequest actionRequest,
			javax.portlet.ActionResponse actionResponse)
		throws java.io.IOException, javax.portlet.PortletException {

		getService().addCourses(actionRequest, actionResponse);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CoursesService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<CoursesService> _serviceSnapshot =
		new Snapshot<>(CoursesServiceUtil.class, CoursesService.class);

}