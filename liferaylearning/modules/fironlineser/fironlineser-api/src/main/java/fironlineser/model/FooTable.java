/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;FIRFOO_Foo&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Foo
 * @generated
 */
public class FooTable extends BaseTable<FooTable> {

	public static final FooTable INSTANCE = new FooTable();

	public final Column<FooTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FooTable, Long> fooId = createColumn(
		"fooId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FooTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FooTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FooTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FooTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FooTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FooTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FooTable, String> field1 = createColumn(
		"field1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FooTable, Boolean> field2 = createColumn(
		"field2", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<FooTable, Integer> field3 = createColumn(
		"field3", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FooTable, Date> field4 = createColumn(
		"field4", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FooTable, String> field5 = createColumn(
		"field5", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FooTable() {
		super("FIRFOO_Foo", FooTable::new);
	}

}