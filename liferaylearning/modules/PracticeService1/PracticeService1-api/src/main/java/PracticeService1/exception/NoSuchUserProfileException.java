/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package PracticeService1.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUserProfileException extends NoSuchModelException {

	public NoSuchUserProfileException() {
	}

	public NoSuchUserProfileException(String msg) {
		super(msg);
	}

	public NoSuchUserProfileException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchUserProfileException(Throwable throwable) {
		super(throwable);
	}

}