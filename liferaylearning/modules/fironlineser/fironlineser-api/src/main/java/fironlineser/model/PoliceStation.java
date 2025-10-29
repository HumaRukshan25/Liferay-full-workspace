/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the PoliceStation service. Represents a row in the &quot;FIRFOO_PoliceStation&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PoliceStationModel
 * @generated
 */
@ImplementationClassName("fironlineser.model.impl.PoliceStationImpl")
@ProviderType
public interface PoliceStation extends PersistedModel, PoliceStationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>fironlineser.model.impl.PoliceStationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PoliceStation, Long> STATION_ID_ACCESSOR =
		new Accessor<PoliceStation, Long>() {

			@Override
			public Long get(PoliceStation policeStation) {
				return policeStation.getStationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PoliceStation> getTypeClass() {
				return PoliceStation.class;
			}

		};

}