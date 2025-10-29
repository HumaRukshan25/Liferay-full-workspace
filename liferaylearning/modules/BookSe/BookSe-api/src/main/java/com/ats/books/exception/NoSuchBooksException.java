/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.ats.books.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchBooksException extends NoSuchModelException {

	public NoSuchBooksException() {
	}

	public NoSuchBooksException(String msg) {
		super(msg);
	}

	public NoSuchBooksException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchBooksException(Throwable throwable) {
		super(throwable);
	}

}