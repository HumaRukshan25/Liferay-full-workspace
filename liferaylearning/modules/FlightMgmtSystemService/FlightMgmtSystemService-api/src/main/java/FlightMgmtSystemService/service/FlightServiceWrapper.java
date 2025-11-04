/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package FlightMgmtSystemService.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FlightService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlightService
 * @generated
 */
public class FlightServiceWrapper
	implements FlightService, ServiceWrapper<FlightService> {

	public FlightServiceWrapper() {
		this(null);
	}

	public FlightServiceWrapper(FlightService flightService) {
		_flightService = flightService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _flightService.getOSGiServiceIdentifier();
	}

	@Override
	public FlightService getWrappedService() {
		return _flightService;
	}

	@Override
	public void setWrappedService(FlightService flightService) {
		_flightService = flightService;
	}

	private FlightService _flightService;

}