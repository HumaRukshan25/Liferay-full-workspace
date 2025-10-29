/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CoursesService}.
 *
 * @author Brian Wing Shun Chan
 * @see CoursesService
 * @generated
 */
public class CoursesServiceWrapper
	implements CoursesService, ServiceWrapper<CoursesService> {

	public CoursesServiceWrapper() {
		this(null);
	}

	public CoursesServiceWrapper(CoursesService coursesService) {
		_coursesService = coursesService;
	}

	@Override
	public void addCourses(
			javax.portlet.ActionRequest actionRequest,
			javax.portlet.ActionResponse actionResponse)
		throws java.io.IOException, javax.portlet.PortletException {

		_coursesService.addCourses(actionRequest, actionResponse);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _coursesService.getOSGiServiceIdentifier();
	}

	@Override
	public CoursesService getWrappedService() {
		return _coursesService;
	}

	@Override
	public void setWrappedService(CoursesService coursesService) {
		_coursesService = coursesService;
	}

	private CoursesService _coursesService;

}