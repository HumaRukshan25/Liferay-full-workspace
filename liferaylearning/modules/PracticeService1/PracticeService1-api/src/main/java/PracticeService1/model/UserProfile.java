/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the UserProfile service. Represents a row in the &quot;ATS_UserProfile&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserProfileModel
 * @generated
 */
@ImplementationClassName("PracticeService1.model.impl.UserProfileImpl")
@ProviderType
public interface UserProfile extends PersistedModel, UserProfileModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>PracticeService1.model.impl.UserProfileImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserProfile, Long> USER_ID_ACCESSOR =
		new Accessor<UserProfile, Long>() {

			@Override
			public Long get(UserProfile userProfile) {
				return userProfile.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserProfile> getTypeClass() {
				return UserProfile.class;
			}

		};

}