/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ATS_Courses&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Courses
 * @generated
 */
public class CoursesTable extends BaseTable<CoursesTable> {

	public static final CoursesTable INSTANCE = new CoursesTable();

	public final Column<CoursesTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CoursesTable, Long> coursesId = createColumn(
		"coursesId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CoursesTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CoursesTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CoursesTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CoursesTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CoursesTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CoursesTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CoursesTable, String> Courses_img = createColumn(
		"Courses_img", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CoursesTable, String> Courses_name = createColumn(
		"Courses_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CoursesTable, String> Courses_des = createColumn(
		"Courses_des", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CoursesTable, String> Courses_type = createColumn(
		"Courses_type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CoursesTable, String> Courses_rating = createColumn(
		"Courses_rating", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CoursesTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private CoursesTable() {
		super("ATS_Courses", CoursesTable::new);
	}

}