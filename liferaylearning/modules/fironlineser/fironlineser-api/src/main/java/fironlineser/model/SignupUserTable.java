/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;FIRFOO_SignupUser&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SignupUser
 * @generated
 */
public class SignupUserTable extends BaseTable<SignupUserTable> {

	public static final SignupUserTable INSTANCE = new SignupUserTable();

	public final Column<SignupUserTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignupUserTable, Long> signupUserId = createColumn(
		"signupUserId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SignupUserTable, String> loginName = createColumn(
		"loginName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignupUserTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignupUserTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignupUserTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignupUserTable, String> phoneNo = createColumn(
		"phoneNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignupUserTable, String> password_ = createColumn(
		"password_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignupUserTable, String> role = createColumn(
		"role_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignupUserTable, Boolean> active = createColumn(
		"active_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SignupUserTable, String> activationToken = createColumn(
		"activationToken", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private SignupUserTable() {
		super("FIRFOO_SignupUser", SignupUserTable::new);
	}

}