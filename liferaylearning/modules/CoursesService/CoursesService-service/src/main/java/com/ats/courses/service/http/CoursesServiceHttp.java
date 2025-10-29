/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.service.http;

import com.ats.courses.service.CoursesServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>CoursesServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CoursesServiceHttp {

	public static void addCourses(
			HttpPrincipal httpPrincipal,
			javax.portlet.ActionRequest actionRequest,
			javax.portlet.ActionResponse actionResponse)
		throws java.io.IOException, javax.portlet.PortletException {

		try {
			MethodKey methodKey = new MethodKey(
				CoursesServiceUtil.class, "addCourses",
				_addCoursesParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, actionRequest, actionResponse);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof java.io.IOException) {
					throw (java.io.IOException)exception;
				}

				if (exception instanceof javax.portlet.PortletException) {
					throw (javax.portlet.PortletException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CoursesServiceHttp.class);

	private static final Class<?>[] _addCoursesParameterTypes0 = new Class[] {
		javax.portlet.ActionRequest.class, javax.portlet.ActionResponse.class
	};

}