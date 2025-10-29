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
 * The table class for the &quot;BOOKKK_BookCategory&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BookCategory
 * @generated
 */
public class BookCategoryTable extends BaseTable<BookCategoryTable> {

	public static final BookCategoryTable INSTANCE = new BookCategoryTable();

	public final Column<BookCategoryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookCategoryTable, Long> categoryId = createColumn(
		"categoryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BookCategoryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookCategoryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookCategoryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookCategoryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookCategoryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BookCategoryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BookCategoryTable, String> categoryName = createColumn(
		"categoryName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookCategoryTable, Long> bookId = createColumn(
		"bookId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private BookCategoryTable() {
		super("BOOKKK_BookCategory", BookCategoryTable::new);
	}

}