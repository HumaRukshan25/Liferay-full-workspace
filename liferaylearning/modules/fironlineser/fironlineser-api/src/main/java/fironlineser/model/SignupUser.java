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
 * The extended model interface for the SignupUser service. Represents a row in the &quot;FIRFOO_SignupUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SignupUserModel
 * @generated
 */
@ImplementationClassName("fironlineser.model.impl.SignupUserImpl")
@ProviderType
public interface SignupUser extends PersistedModel, SignupUserModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>fironlineser.model.impl.SignupUserImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SignupUser, Long> SIGNUP_USER_ID_ACCESSOR =
		new Accessor<SignupUser, Long>() {

			@Override
			public Long get(SignupUser signupUser) {
				return signupUser.getSignupUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SignupUser> getTypeClass() {
				return SignupUser.class;
			}

		};

}