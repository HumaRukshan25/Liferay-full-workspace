/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.service.persistence;

import com.ats.books.model.BookCategory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the book category service. This utility wraps <code>com.ats.books.service.persistence.impl.BookCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookCategoryPersistence
 * @generated
 */
public class BookCategoryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(BookCategory bookCategory) {
		getPersistence().clearCache(bookCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, BookCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BookCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BookCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BookCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BookCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BookCategory update(BookCategory bookCategory) {
		return getPersistence().update(bookCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BookCategory update(
		BookCategory bookCategory, ServiceContext serviceContext) {

		return getPersistence().update(bookCategory, serviceContext);
	}

	/**
	 * Returns all the book categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching book categories
	 */
	public static List<BookCategory> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the book categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @return the range of matching book categories
	 */
	public static List<BookCategory> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the book categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book categories
	 */
	public static List<BookCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BookCategory> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the book categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book categories
	 */
	public static List<BookCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BookCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public static BookCategory findByUuid_First(
			String uuid, OrderByComparator<BookCategory> orderByComparator)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first book category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public static BookCategory fetchByUuid_First(
		String uuid, OrderByComparator<BookCategory> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last book category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public static BookCategory findByUuid_Last(
			String uuid, OrderByComparator<BookCategory> orderByComparator)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last book category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public static BookCategory fetchByUuid_Last(
		String uuid, OrderByComparator<BookCategory> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the book categories before and after the current book category in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current book category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book category
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	public static BookCategory[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			OrderByComparator<BookCategory> orderByComparator)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().findByUuid_PrevAndNext(
			categoryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the book categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of book categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching book categories
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the book category where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBookCategoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public static BookCategory findByUUID_G(String uuid, long groupId)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the book category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public static BookCategory fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the book category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public static BookCategory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the book category where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the book category that was removed
	 */
	public static BookCategory removeByUUID_G(String uuid, long groupId)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of book categories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching book categories
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the book categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching book categories
	 */
	public static List<BookCategory> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the book categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @return the range of matching book categories
	 */
	public static List<BookCategory> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the book categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book categories
	 */
	public static List<BookCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookCategory> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the book categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book categories
	 */
	public static List<BookCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public static BookCategory findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BookCategory> orderByComparator)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public static BookCategory fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BookCategory> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public static BookCategory findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BookCategory> orderByComparator)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public static BookCategory fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BookCategory> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the book categories before and after the current book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current book category
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book category
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	public static BookCategory[] findByUuid_C_PrevAndNext(
			long categoryId, String uuid, long companyId,
			OrderByComparator<BookCategory> orderByComparator)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			categoryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the book categories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of book categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching book categories
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the book categories where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the matching book categories
	 */
	public static List<BookCategory> findByByCategoryName(String categoryName) {
		return getPersistence().findByByCategoryName(categoryName);
	}

	/**
	 * Returns a range of all the book categories where categoryName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @return the range of matching book categories
	 */
	public static List<BookCategory> findByByCategoryName(
		String categoryName, int start, int end) {

		return getPersistence().findByByCategoryName(categoryName, start, end);
	}

	/**
	 * Returns an ordered range of all the book categories where categoryName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book categories
	 */
	public static List<BookCategory> findByByCategoryName(
		String categoryName, int start, int end,
		OrderByComparator<BookCategory> orderByComparator) {

		return getPersistence().findByByCategoryName(
			categoryName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the book categories where categoryName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book categories
	 */
	public static List<BookCategory> findByByCategoryName(
		String categoryName, int start, int end,
		OrderByComparator<BookCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByByCategoryName(
			categoryName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public static BookCategory findByByCategoryName_First(
			String categoryName,
			OrderByComparator<BookCategory> orderByComparator)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().findByByCategoryName_First(
			categoryName, orderByComparator);
	}

	/**
	 * Returns the first book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public static BookCategory fetchByByCategoryName_First(
		String categoryName,
		OrderByComparator<BookCategory> orderByComparator) {

		return getPersistence().fetchByByCategoryName_First(
			categoryName, orderByComparator);
	}

	/**
	 * Returns the last book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public static BookCategory findByByCategoryName_Last(
			String categoryName,
			OrderByComparator<BookCategory> orderByComparator)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().findByByCategoryName_Last(
			categoryName, orderByComparator);
	}

	/**
	 * Returns the last book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public static BookCategory fetchByByCategoryName_Last(
		String categoryName,
		OrderByComparator<BookCategory> orderByComparator) {

		return getPersistence().fetchByByCategoryName_Last(
			categoryName, orderByComparator);
	}

	/**
	 * Returns the book categories before and after the current book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryId the primary key of the current book category
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book category
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	public static BookCategory[] findByByCategoryName_PrevAndNext(
			long categoryId, String categoryName,
			OrderByComparator<BookCategory> orderByComparator)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().findByByCategoryName_PrevAndNext(
			categoryId, categoryName, orderByComparator);
	}

	/**
	 * Removes all the book categories where categoryName = &#63; from the database.
	 *
	 * @param categoryName the category name
	 */
	public static void removeByByCategoryName(String categoryName) {
		getPersistence().removeByByCategoryName(categoryName);
	}

	/**
	 * Returns the number of book categories where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the number of matching book categories
	 */
	public static int countByByCategoryName(String categoryName) {
		return getPersistence().countByByCategoryName(categoryName);
	}

	/**
	 * Caches the book category in the entity cache if it is enabled.
	 *
	 * @param bookCategory the book category
	 */
	public static void cacheResult(BookCategory bookCategory) {
		getPersistence().cacheResult(bookCategory);
	}

	/**
	 * Caches the book categories in the entity cache if it is enabled.
	 *
	 * @param bookCategories the book categories
	 */
	public static void cacheResult(List<BookCategory> bookCategories) {
		getPersistence().cacheResult(bookCategories);
	}

	/**
	 * Creates a new book category with the primary key. Does not add the book category to the database.
	 *
	 * @param categoryId the primary key for the new book category
	 * @return the new book category
	 */
	public static BookCategory create(long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	 * Removes the book category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the book category
	 * @return the book category that was removed
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	public static BookCategory remove(long categoryId)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().remove(categoryId);
	}

	public static BookCategory updateImpl(BookCategory bookCategory) {
		return getPersistence().updateImpl(bookCategory);
	}

	/**
	 * Returns the book category with the primary key or throws a <code>NoSuchBookCategoryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the book category
	 * @return the book category
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	public static BookCategory findByPrimaryKey(long categoryId)
		throws com.ats.books.exception.NoSuchBookCategoryException {

		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	 * Returns the book category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the book category
	 * @return the book category, or <code>null</code> if a book category with the primary key could not be found
	 */
	public static BookCategory fetchByPrimaryKey(long categoryId) {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	 * Returns all the book categories.
	 *
	 * @return the book categories
	 */
	public static List<BookCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the book categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @return the range of book categories
	 */
	public static List<BookCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the book categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of book categories
	 */
	public static List<BookCategory> findAll(
		int start, int end, OrderByComparator<BookCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the book categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of book categories
	 */
	public static List<BookCategory> findAll(
		int start, int end, OrderByComparator<BookCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the book categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of book categories.
	 *
	 * @return the number of book categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BookCategoryPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(BookCategoryPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile BookCategoryPersistence _persistence;

}