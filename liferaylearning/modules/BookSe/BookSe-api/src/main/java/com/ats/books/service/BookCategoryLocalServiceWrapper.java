/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BookCategoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookCategoryLocalService
 * @generated
 */
public class BookCategoryLocalServiceWrapper
	implements BookCategoryLocalService,
			   ServiceWrapper<BookCategoryLocalService> {

	public BookCategoryLocalServiceWrapper() {
		this(null);
	}

	public BookCategoryLocalServiceWrapper(
		BookCategoryLocalService bookCategoryLocalService) {

		_bookCategoryLocalService = bookCategoryLocalService;
	}

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
	@Override
	public com.ats.books.model.BookCategory addBookCategory(
		com.ats.books.model.BookCategory bookCategory) {

		return _bookCategoryLocalService.addBookCategory(bookCategory);
	}

	/**
	 * Creates a new book category with the primary key. Does not add the book category to the database.
	 *
	 * @param categoryId the primary key for the new book category
	 * @return the new book category
	 */
	@Override
	public com.ats.books.model.BookCategory createBookCategory(
		long categoryId) {

		return _bookCategoryLocalService.createBookCategory(categoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookCategoryLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ats.books.model.BookCategory deleteBookCategory(
		com.ats.books.model.BookCategory bookCategory) {

		return _bookCategoryLocalService.deleteBookCategory(bookCategory);
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
	@Override
	public com.ats.books.model.BookCategory deleteBookCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookCategoryLocalService.deleteBookCategory(categoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookCategoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bookCategoryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bookCategoryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bookCategoryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _bookCategoryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _bookCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _bookCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _bookCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _bookCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ats.books.model.BookCategory fetchBookCategory(long categoryId) {
		return _bookCategoryLocalService.fetchBookCategory(categoryId);
	}

	/**
	 * Returns the book category matching the UUID and group.
	 *
	 * @param uuid the book category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching book category, or <code>null</code> if a matching book category could not be found
	 */
	@Override
	public com.ats.books.model.BookCategory fetchBookCategoryByUuidAndGroupId(
		String uuid, long groupId) {

		return _bookCategoryLocalService.fetchBookCategoryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bookCategoryLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<com.ats.books.model.BookCategory> getBookCategories(
		int start, int end) {

		return _bookCategoryLocalService.getBookCategories(start, end);
	}

	/**
	 * Returns all the book categories matching the UUID and company.
	 *
	 * @param uuid the UUID of the book categories
	 * @param companyId the primary key of the company
	 * @return the matching book categories, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ats.books.model.BookCategory>
		getBookCategoriesByUuidAndCompanyId(String uuid, long companyId) {

		return _bookCategoryLocalService.getBookCategoriesByUuidAndCompanyId(
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
	@Override
	public java.util.List<com.ats.books.model.BookCategory>
		getBookCategoriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ats.books.model.BookCategory> orderByComparator) {

		return _bookCategoryLocalService.getBookCategoriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of book categories.
	 *
	 * @return the number of book categories
	 */
	@Override
	public int getBookCategoriesCount() {
		return _bookCategoryLocalService.getBookCategoriesCount();
	}

	/**
	 * Returns the book category with the primary key.
	 *
	 * @param categoryId the primary key of the book category
	 * @return the book category
	 * @throws PortalException if a book category with the primary key could not be found
	 */
	@Override
	public com.ats.books.model.BookCategory getBookCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookCategoryLocalService.getBookCategory(categoryId);
	}

	/**
	 * Returns the book category matching the UUID and group.
	 *
	 * @param uuid the book category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching book category
	 * @throws PortalException if a matching book category could not be found
	 */
	@Override
	public com.ats.books.model.BookCategory getBookCategoryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookCategoryLocalService.getBookCategoryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _bookCategoryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bookCategoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookCategoryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ats.books.model.BookCategory updateBookCategory(
		com.ats.books.model.BookCategory bookCategory) {

		return _bookCategoryLocalService.updateBookCategory(bookCategory);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bookCategoryLocalService.getBasePersistence();
	}

	@Override
	public BookCategoryLocalService getWrappedService() {
		return _bookCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		BookCategoryLocalService bookCategoryLocalService) {

		_bookCategoryLocalService = bookCategoryLocalService;
	}

	private BookCategoryLocalService _bookCategoryLocalService;

}