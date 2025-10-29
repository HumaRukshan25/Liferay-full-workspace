/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package PracticeService1.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCheckInOutAppException extends NoSuchModelException {

	public NoSuchCheckInOutAppException() {
	}

	public NoSuchCheckInOutAppException(String msg) {
		super(msg);
	}

	public NoSuchCheckInOutAppException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchCheckInOutAppException(Throwable throwable) {
		super(throwable);
	}

}