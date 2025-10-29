/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.service.persistence;

import com.ats.books.exception.NoSuchBookCategoryException;
import com.ats.books.model.BookCategory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the book category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookCategoryUtil
 * @generated
 */
@ProviderType
public interface BookCategoryPersistence extends BasePersistence<BookCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookCategoryUtil} to access the book category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the book categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching book categories
	 */
	public java.util.List<BookCategory> findByUuid(String uuid);

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
	public java.util.List<BookCategory> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<BookCategory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator);

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
	public java.util.List<BookCategory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public BookCategory findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
				orderByComparator)
		throws NoSuchBookCategoryException;

	/**
	 * Returns the first book category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public BookCategory fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator);

	/**
	 * Returns the last book category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public BookCategory findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
				orderByComparator)
		throws NoSuchBookCategoryException;

	/**
	 * Returns the last book category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public BookCategory fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator);

	/**
	 * Returns the book categories before and after the current book category in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current book category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book category
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	public BookCategory[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
				orderByComparator)
		throws NoSuchBookCategoryException;

	/**
	 * Removes all the book categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of book categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching book categories
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the book category where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBookCategoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public BookCategory findByUUID_G(String uuid, long groupId)
		throws NoSuchBookCategoryException;

	/**
	 * Returns the book category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public BookCategory fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the book category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public BookCategory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the book category where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the book category that was removed
	 */
	public BookCategory removeByUUID_G(String uuid, long groupId)
		throws NoSuchBookCategoryException;

	/**
	 * Returns the number of book categories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching book categories
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the book categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching book categories
	 */
	public java.util.List<BookCategory> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<BookCategory> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<BookCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator);

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
	public java.util.List<BookCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public BookCategory findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
				orderByComparator)
		throws NoSuchBookCategoryException;

	/**
	 * Returns the first book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public BookCategory fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator);

	/**
	 * Returns the last book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public BookCategory findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
				orderByComparator)
		throws NoSuchBookCategoryException;

	/**
	 * Returns the last book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public BookCategory fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator);

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
	public BookCategory[] findByUuid_C_PrevAndNext(
			long categoryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
				orderByComparator)
		throws NoSuchBookCategoryException;

	/**
	 * Removes all the book categories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of book categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching book categories
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the book categories where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the matching book categories
	 */
	public java.util.List<BookCategory> findByByCategoryName(
		String categoryName);

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
	public java.util.List<BookCategory> findByByCategoryName(
		String categoryName, int start, int end);

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
	public java.util.List<BookCategory> findByByCategoryName(
		String categoryName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator);

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
	public java.util.List<BookCategory> findByByCategoryName(
		String categoryName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public BookCategory findByByCategoryName_First(
			String categoryName,
			com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
				orderByComparator)
		throws NoSuchBookCategoryException;

	/**
	 * Returns the first book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public BookCategory fetchByByCategoryName_First(
		String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator);

	/**
	 * Returns the last book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	public BookCategory findByByCategoryName_Last(
			String categoryName,
			com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
				orderByComparator)
		throws NoSuchBookCategoryException;

	/**
	 * Returns the last book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public BookCategory fetchByByCategoryName_Last(
		String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator);

	/**
	 * Returns the book categories before and after the current book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryId the primary key of the current book category
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book category
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	public BookCategory[] findByByCategoryName_PrevAndNext(
			long categoryId, String categoryName,
			com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
				orderByComparator)
		throws NoSuchBookCategoryException;

	/**
	 * Removes all the book categories where categoryName = &#63; from the database.
	 *
	 * @param categoryName the category name
	 */
	public void removeByByCategoryName(String categoryName);

	/**
	 * Returns the number of book categories where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the number of matching book categories
	 */
	public int countByByCategoryName(String categoryName);

	/**
	 * Caches the book category in the entity cache if it is enabled.
	 *
	 * @param bookCategory the book category
	 */
	public void cacheResult(BookCategory bookCategory);

	/**
	 * Caches the book categories in the entity cache if it is enabled.
	 *
	 * @param bookCategories the book categories
	 */
	public void cacheResult(java.util.List<BookCategory> bookCategories);

	/**
	 * Creates a new book category with the primary key. Does not add the book category to the database.
	 *
	 * @param categoryId the primary key for the new book category
	 * @return the new book category
	 */
	public BookCategory create(long categoryId);

	/**
	 * Removes the book category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the book category
	 * @return the book category that was removed
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	public BookCategory remove(long categoryId)
		throws NoSuchBookCategoryException;

	public BookCategory updateImpl(BookCategory bookCategory);

	/**
	 * Returns the book category with the primary key or throws a <code>NoSuchBookCategoryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the book category
	 * @return the book category
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	public BookCategory findByPrimaryKey(long categoryId)
		throws NoSuchBookCategoryException;

	/**
	 * Returns the book category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the book category
	 * @return the book category, or <code>null</code> if a book category with the primary key could not be found
	 */
	public BookCategory fetchByPrimaryKey(long categoryId);

	/**
	 * Returns all the book categories.
	 *
	 * @return the book categories
	 */
	public java.util.List<BookCategory> findAll();

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
	public java.util.List<BookCategory> findAll(int start, int end);

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
	public java.util.List<BookCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator);

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
	public java.util.List<BookCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the book categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of book categories.
	 *
	 * @return the number of book categories
	 */
	public int countAll();

}