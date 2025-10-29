/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.ats.courses.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCoursesException extends NoSuchModelException {

	public NoSuchCoursesException() {
	}

	public NoSuchCoursesException(String msg) {
		super(msg);
	}

	public NoSuchCoursesException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchCoursesException(Throwable throwable) {
		super(throwable);
	}

}