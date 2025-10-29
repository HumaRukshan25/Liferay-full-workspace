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
 * The table class for the &quot;FIRFOO_PoliceStation&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PoliceStation
 * @generated
 */
public class PoliceStationTable extends BaseTable<PoliceStationTable> {

	public static final PoliceStationTable INSTANCE = new PoliceStationTable();

	public final Column<PoliceStationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PoliceStationTable, Long> stationId = createColumn(
		"stationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PoliceStationTable, String> stationName = createColumn(
		"stationName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PoliceStationTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PoliceStationTable, String> jurisdictionArea =
		createColumn(
			"jurisdictionArea", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PoliceStationTable, String> officerInCharge =
		createColumn(
			"officerInCharge", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PoliceStationTable, String> contactNumber =
		createColumn(
			"contactNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PoliceStationTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PoliceStationTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PoliceStationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PoliceStationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PoliceStationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PoliceStationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private PoliceStationTable() {
		super("FIRFOO_PoliceStation", PoliceStationTable::new);
	}

}