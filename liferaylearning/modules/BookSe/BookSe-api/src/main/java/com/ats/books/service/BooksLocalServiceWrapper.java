/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BooksLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BooksLocalService
 * @generated
 */
public class BooksLocalServiceWrapper
	implements BooksLocalService, ServiceWrapper<BooksLocalService> {

	public BooksLocalServiceWrapper() {
		this(null);
	}

	public BooksLocalServiceWrapper(BooksLocalService booksLocalService) {
		_booksLocalService = booksLocalService;
	}

	/**
	 * Adds the books to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BooksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param books the books
	 * @return the books that was added
	 */
	@Override
	public com.ats.books.model.Books addBooks(com.ats.books.model.Books books) {
		return _booksLocalService.addBooks(books);
	}

	/**
	 * Creates a new books with the primary key. Does not add the books to the database.
	 *
	 * @param bookId the primary key for the new books
	 * @return the new books
	 */
	@Override
	public com.ats.books.model.Books createBooks(long bookId) {
		return _booksLocalService.createBooks(bookId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _booksLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the books from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BooksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param books the books
	 * @return the books that was removed
	 */
	@Override
	public com.ats.books.model.Books deleteBooks(
		com.ats.books.model.Books books) {

		return _booksLocalService.deleteBooks(books);
	}

	/**
	 * Deletes the books with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BooksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookId the primary key of the books
	 * @return the books that was removed
	 * @throws PortalException if a books with the primary key could not be found
	 */
	@Override
	public com.ats.books.model.Books deleteBooks(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _booksLocalService.deleteBooks(bookId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _booksLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _booksLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _booksLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _booksLocalService.dynamicQuery();
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

		return _booksLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ats.books.model.impl.BooksModelImpl</code>.
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

		return _booksLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ats.books.model.impl.BooksModelImpl</code>.
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

		return _booksLocalService.dynamicQuery(
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

		return _booksLocalService.dynamicQueryCount(dynamicQuery);
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

		return _booksLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ats.books.model.Books fetchBooks(long bookId) {
		return _booksLocalService.fetchBooks(bookId);
	}

	/**
	 * Returns the books matching the UUID and group.
	 *
	 * @param uuid the books's UUID
	 * @param groupId the primary key of the group
	 * @return the matching books, or <code>null</code> if a matching books could not be found
	 */
	@Override
	public com.ats.books.model.Books fetchBooksByUuidAndGroupId(
		String uuid, long groupId) {

		return _booksLocalService.fetchBooksByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _booksLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the books with the primary key.
	 *
	 * @param bookId the primary key of the books
	 * @return the books
	 * @throws PortalException if a books with the primary key could not be found
	 */
	@Override
	public com.ats.books.model.Books getBooks(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _booksLocalService.getBooks(bookId);
	}

	/**
	 * Returns the books matching the UUID and group.
	 *
	 * @param uuid the books's UUID
	 * @param groupId the primary key of the group
	 * @return the matching books
	 * @throws PortalException if a matching books could not be found
	 */
	@Override
	public com.ats.books.model.Books getBooksByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _booksLocalService.getBooksByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the bookses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ats.books.model.impl.BooksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @return the range of bookses
	 */
	@Override
	public java.util.List<com.ats.books.model.Books> getBookses(
		int start, int end) {

		return _booksLocalService.getBookses(start, end);
	}

	/**
	 * Returns all the bookses matching the UUID and company.
	 *
	 * @param uuid the UUID of the bookses
	 * @param companyId the primary key of the company
	 * @return the matching bookses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ats.books.model.Books>
		getBooksesByUuidAndCompanyId(String uuid, long companyId) {

		return _booksLocalService.getBooksesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of bookses matching the UUID and company.
	 *
	 * @param uuid the UUID of the bookses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching bookses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ats.books.model.Books>
		getBooksesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ats.books.model.Books> orderByComparator) {

		return _booksLocalService.getBooksesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of bookses.
	 *
	 * @return the number of bookses
	 */
	@Override
	public int getBooksesCount() {
		return _booksLocalService.getBooksesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _booksLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _booksLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _booksLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _booksLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the books in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BooksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param books the books
	 * @return the books that was updated
	 */
	@Override
	public com.ats.books.model.Books updateBooks(
		com.ats.books.model.Books books) {

		return _booksLocalService.updateBooks(books);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _booksLocalService.getBasePersistence();
	}

	@Override
	public BooksLocalService getWrappedService() {
		return _booksLocalService;
	}

	@Override
	public void setWrappedService(BooksLocalService booksLocalService) {
		_booksLocalService = booksLocalService;
	}

	private BooksLocalService _booksLocalService;

}