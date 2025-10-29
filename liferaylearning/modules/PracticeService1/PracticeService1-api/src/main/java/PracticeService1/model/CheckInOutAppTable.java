/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ATS_CheckInOutApp&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CheckInOutApp
 * @generated
 */
public class CheckInOutAppTable extends BaseTable<CheckInOutAppTable> {

	public static final CheckInOutAppTable INSTANCE = new CheckInOutAppTable();

	public final Column<CheckInOutAppTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CheckInOutAppTable, Long> logId = createColumn(
		"logId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CheckInOutAppTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CheckInOutAppTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CheckInOutAppTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CheckInOutAppTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CheckInOutAppTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CheckInOutAppTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CheckInOutAppTable, Date> checkInTime = createColumn(
		"checkInTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CheckInOutAppTable, Date> checkOutTime = createColumn(
		"checkOutTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CheckInOutAppTable, String> remarks = createColumn(
		"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CheckInOutAppTable, String> location = createColumn(
		"location", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CheckInOutAppTable() {
		super("ATS_CheckInOutApp", CheckInOutAppTable::new);
	}

}