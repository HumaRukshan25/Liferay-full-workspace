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
 * The table class for the &quot;FIRFOO_FIRRR&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FIRRR
 * @generated
 */
public class FIRRRTable extends BaseTable<FIRRRTable> {

	public static final FIRRRTable INSTANCE = new FIRRRTable();

	public final Column<FIRRRTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, Long> firId = createColumn(
		"firId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FIRRRTable, String> complainantName = createColumn(
		"complainantName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, Date> incidentDate = createColumn(
		"incidentDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, String> incidentDetails = createColumn(
		"incidentDetails", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, String> incidentLocation = createColumn(
		"incidentLocation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, String> timeline = createColumn(
		"timeline", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, String> modificationDetails = createColumn(
		"modificationDetails", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, String> assignedInspector = createColumn(
		"assignedInspector", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, String> proofFileName = createColumn(
		"proofFileName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, String> proofFilePath = createColumn(
		"proofFilePath", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FIRRRTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FIRRRTable() {
		super("FIRFOO_FIRRR", FIRRRTable::new);
	}

}