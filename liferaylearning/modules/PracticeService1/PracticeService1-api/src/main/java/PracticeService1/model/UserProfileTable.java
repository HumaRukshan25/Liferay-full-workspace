/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;ATS_UserProfile&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UserProfile
 * @generated
 */
public class UserProfileTable extends BaseTable<UserProfileTable> {

	public static final UserProfileTable INSTANCE = new UserProfileTable();

	public final Column<UserProfileTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserProfileTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserProfileTable, String> password = createColumn(
		"password_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private UserProfileTable() {
		super("ATS_UserProfile", UserProfileTable::new);
	}

}