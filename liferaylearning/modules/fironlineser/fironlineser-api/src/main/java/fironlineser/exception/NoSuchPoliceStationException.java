/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package fironlineser.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPoliceStationException extends NoSuchModelException {

	public NoSuchPoliceStationException() {
	}

	public NoSuchPoliceStationException(String msg) {
		super(msg);
	}

	public NoSuchPoliceStationException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchPoliceStationException(Throwable throwable) {
		super(throwable);
	}

}