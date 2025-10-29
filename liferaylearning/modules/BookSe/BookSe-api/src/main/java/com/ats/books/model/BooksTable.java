/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;BOOKKK_Books&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Books
 * @generated
 */
public class BooksTable extends BaseTable<BooksTable> {

	public static final BooksTable INSTANCE = new BooksTable();

	public final Column<BooksTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BooksTable, Long> bookId = createColumn(
		"bookId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BooksTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BooksTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BooksTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BooksTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BooksTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BooksTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BooksTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BooksTable, String> author = createColumn(
		"author", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BooksTable, Date> publishDate = createColumn(
		"publishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BooksTable, Long> categoryId = createColumn(
		"categoryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private BooksTable() {
		super("BOOKKK_Books", BooksTable::new);
	}

}