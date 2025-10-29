/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CheckInOutAppLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CheckInOutAppLocalService
 * @generated
 */
public class CheckInOutAppLocalServiceWrapper
	implements CheckInOutAppLocalService,
			   ServiceWrapper<CheckInOutAppLocalService> {

	public CheckInOutAppLocalServiceWrapper() {
		this(null);
	}

	public CheckInOutAppLocalServiceWrapper(
		CheckInOutAppLocalService checkInOutAppLocalService) {

		_checkInOutAppLocalService = checkInOutAppLocalService;
	}

	/**
	 * Adds the check in out app to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckInOutAppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkInOutApp the check in out app
	 * @return the check in out app that was added
	 */
	@Override
	public PracticeService1.model.CheckInOutApp addCheckInOutApp(
		PracticeService1.model.CheckInOutApp checkInOutApp) {

		return _checkInOutAppLocalService.addCheckInOutApp(checkInOutApp);
	}

	/**
	 * Creates a new check in out app with the primary key. Does not add the check in out app to the database.
	 *
	 * @param logId the primary key for the new check in out app
	 * @return the new check in out app
	 */
	@Override
	public PracticeService1.model.CheckInOutApp createCheckInOutApp(
		long logId) {

		return _checkInOutAppLocalService.createCheckInOutApp(logId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkInOutAppLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the check in out app from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckInOutAppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkInOutApp the check in out app
	 * @return the check in out app that was removed
	 */
	@Override
	public PracticeService1.model.CheckInOutApp deleteCheckInOutApp(
		PracticeService1.model.CheckInOutApp checkInOutApp) {

		return _checkInOutAppLocalService.deleteCheckInOutApp(checkInOutApp);
	}

	/**
	 * Deletes the check in out app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckInOutAppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param logId the primary key of the check in out app
	 * @return the check in out app that was removed
	 * @throws PortalException if a check in out app with the primary key could not be found
	 */
	@Override
	public PracticeService1.model.CheckInOutApp deleteCheckInOutApp(long logId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkInOutAppLocalService.deleteCheckInOutApp(logId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkInOutAppLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _checkInOutAppLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _checkInOutAppLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _checkInOutAppLocalService.dynamicQuery();
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

		return _checkInOutAppLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PracticeService1.model.impl.CheckInOutAppModelImpl</code>.
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

		return _checkInOutAppLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PracticeService1.model.impl.CheckInOutAppModelImpl</code>.
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

		return _checkInOutAppLocalService.dynamicQuery(
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

		return _checkInOutAppLocalService.dynamicQueryCount(dynamicQuery);
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

		return _checkInOutAppLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public PracticeService1.model.CheckInOutApp fetchCheckInOutApp(long logId) {
		return _checkInOutAppLocalService.fetchCheckInOutApp(logId);
	}

	/**
	 * Returns the check in out app matching the UUID and group.
	 *
	 * @param uuid the check in out app's UUID
	 * @param groupId the primary key of the group
	 * @return the matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	@Override
	public PracticeService1.model.CheckInOutApp
		fetchCheckInOutAppByUuidAndGroupId(String uuid, long groupId) {

		return _checkInOutAppLocalService.fetchCheckInOutAppByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _checkInOutAppLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the check in out app with the primary key.
	 *
	 * @param logId the primary key of the check in out app
	 * @return the check in out app
	 * @throws PortalException if a check in out app with the primary key could not be found
	 */
	@Override
	public PracticeService1.model.CheckInOutApp getCheckInOutApp(long logId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkInOutAppLocalService.getCheckInOutApp(logId);
	}

	/**
	 * Returns the check in out app matching the UUID and group.
	 *
	 * @param uuid the check in out app's UUID
	 * @param groupId the primary key of the group
	 * @return the matching check in out app
	 * @throws PortalException if a matching check in out app could not be found
	 */
	@Override
	public PracticeService1.model.CheckInOutApp
			getCheckInOutAppByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkInOutAppLocalService.getCheckInOutAppByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the check in out apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PracticeService1.model.impl.CheckInOutAppModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of check in out apps
	 * @param end the upper bound of the range of check in out apps (not inclusive)
	 * @return the range of check in out apps
	 */
	@Override
	public java.util.List<PracticeService1.model.CheckInOutApp>
		getCheckInOutApps(int start, int end) {

		return _checkInOutAppLocalService.getCheckInOutApps(start, end);
	}

	/**
	 * Returns all the check in out apps matching the UUID and company.
	 *
	 * @param uuid the UUID of the check in out apps
	 * @param companyId the primary key of the company
	 * @return the matching check in out apps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<PracticeService1.model.CheckInOutApp>
		getCheckInOutAppsByUuidAndCompanyId(String uuid, long companyId) {

		return _checkInOutAppLocalService.getCheckInOutAppsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of check in out apps matching the UUID and company.
	 *
	 * @param uuid the UUID of the check in out apps
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of check in out apps
	 * @param end the upper bound of the range of check in out apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching check in out apps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<PracticeService1.model.CheckInOutApp>
		getCheckInOutAppsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<PracticeService1.model.CheckInOutApp> orderByComparator) {

		return _checkInOutAppLocalService.getCheckInOutAppsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of check in out apps.
	 *
	 * @return the number of check in out apps
	 */
	@Override
	public int getCheckInOutAppsCount() {
		return _checkInOutAppLocalService.getCheckInOutAppsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _checkInOutAppLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _checkInOutAppLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _checkInOutAppLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkInOutAppLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the check in out app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckInOutAppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkInOutApp the check in out app
	 * @return the check in out app that was updated
	 */
	@Override
	public PracticeService1.model.CheckInOutApp updateCheckInOutApp(
		PracticeService1.model.CheckInOutApp checkInOutApp) {

		return _checkInOutAppLocalService.updateCheckInOutApp(checkInOutApp);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _checkInOutAppLocalService.getBasePersistence();
	}

	@Override
	public CheckInOutAppLocalService getWrappedService() {
		return _checkInOutAppLocalService;
	}

	@Override
	public void setWrappedService(
		CheckInOutAppLocalService checkInOutAppLocalService) {

		_checkInOutAppLocalService = checkInOutAppLocalService;
	}

	private CheckInOutAppLocalService _checkInOutAppLocalService;

}