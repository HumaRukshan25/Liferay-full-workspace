/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.service;

import com.ats.books.model.BookCategory;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BookCategory. This utility wraps
 * <code>com.ats.books.service.impl.BookCategoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BookCategoryLocalService
 * @generated
 */
public class BookCategoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ats.books.service.impl.BookCategoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the book category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookCategory the book category
	 * @return the book category that was added
	 */
	public static BookCategory addBookCategory(BookCategory bookCategory) {
		return getService().addBookCategory(bookCategory);
	}

	/**
	 * Creates a new book category with the primary key. Does not add the book category to the database.
	 *
	 * @param categoryId the primary key for the new book category
	 * @return the new book category
	 */
	public static BookCategory createBookCategory(long categoryId) {
		return getService().createBookCategory(categoryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the book category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookCategory the book category
	 * @return the book category that was removed
	 */
	public static BookCategory deleteBookCategory(BookCategory bookCategory) {
		return getService().deleteBookCategory(bookCategory);
	}

	/**
	 * Deletes the book category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param categoryId the primary key of the book category
	 * @return the book category that was removed
	 * @throws PortalException if a book category with the primary key could not be found
	 */
	public static BookCategory deleteBookCategory(long categoryId)
		throws PortalException {

		return getService().deleteBookCategory(categoryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ats.books.model.impl.BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ats.books.model.impl.BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static BookCategory fetchBookCategory(long categoryId) {
		return getService().fetchBookCategory(categoryId);
	}

	/**
	 * Returns the book category matching the UUID and group.
	 *
	 * @param uuid the book category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching book category, or <code>null</code> if a matching book category could not be found
	 */
	public static BookCategory fetchBookCategoryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchBookCategoryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the book categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ats.books.model.impl.BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @return the range of book categories
	 */
	public static List<BookCategory> getBookCategories(int start, int end) {
		return getService().getBookCategories(start, end);
	}

	/**
	 * Returns all the book categories matching the UUID and company.
	 *
	 * @param uuid the UUID of the book categories
	 * @param companyId the primary key of the company
	 * @return the matching book categories, or an empty list if no matches were found
	 */
	public static List<BookCategory> getBookCategoriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getBookCategoriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of book categories matching the UUID and company.
	 *
	 * @param uuid the UUID of the book categories
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching book categories, or an empty list if no matches were found
	 */
	public static List<BookCategory> getBookCategoriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookCategory> orderByComparator) {

		return getService().getBookCategoriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of book categories.
	 *
	 * @return the number of book categories
	 */
	public static int getBookCategoriesCount() {
		return getService().getBookCategoriesCount();
	}

	/**
	 * Returns the book category with the primary key.
	 *
	 * @param categoryId the primary key of the book category
	 * @return the book category
	 * @throws PortalException if a book category with the primary key could not be found
	 */
	public static BookCategory getBookCategory(long categoryId)
		throws PortalException {

		return getService().getBookCategory(categoryId);
	}

	/**
	 * Returns the book category matching the UUID and group.
	 *
	 * @param uuid the book category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching book category
	 * @throws PortalException if a matching book category could not be found
	 */
	public static BookCategory getBookCategoryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getBookCategoryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the book category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookCategory the book category
	 * @return the book category that was updated
	 */
	public static BookCategory updateBookCategory(BookCategory bookCategory) {
		return getService().updateBookCategory(bookCategory);
	}

	public static BookCategoryLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<BookCategoryLocalService> _serviceSnapshot =
		new Snapshot<>(
			BookCategoryLocalServiceUtil.class, BookCategoryLocalService.class);

}