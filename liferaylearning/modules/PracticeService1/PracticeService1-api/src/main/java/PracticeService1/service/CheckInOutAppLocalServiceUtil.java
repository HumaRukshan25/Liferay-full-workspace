/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.service;

import PracticeService1.model.CheckInOutApp;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CheckInOutApp. This utility wraps
 * <code>PracticeService1.service.impl.CheckInOutAppLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CheckInOutAppLocalService
 * @generated
 */
public class CheckInOutAppLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>PracticeService1.service.impl.CheckInOutAppLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static CheckInOutApp addCheckInOutApp(CheckInOutApp checkInOutApp) {
		return getService().addCheckInOutApp(checkInOutApp);
	}

	/**
	 * Creates a new check in out app with the primary key. Does not add the check in out app to the database.
	 *
	 * @param logId the primary key for the new check in out app
	 * @return the new check in out app
	 */
	public static CheckInOutApp createCheckInOutApp(long logId) {
		return getService().createCheckInOutApp(logId);
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
	 * Deletes the check in out app from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckInOutAppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkInOutApp the check in out app
	 * @return the check in out app that was removed
	 */
	public static CheckInOutApp deleteCheckInOutApp(
		CheckInOutApp checkInOutApp) {

		return getService().deleteCheckInOutApp(checkInOutApp);
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
	public static CheckInOutApp deleteCheckInOutApp(long logId)
		throws PortalException {

		return getService().deleteCheckInOutApp(logId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PracticeService1.model.impl.CheckInOutAppModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PracticeService1.model.impl.CheckInOutAppModelImpl</code>.
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

	public static CheckInOutApp fetchCheckInOutApp(long logId) {
		return getService().fetchCheckInOutApp(logId);
	}

	/**
	 * Returns the check in out app matching the UUID and group.
	 *
	 * @param uuid the check in out app's UUID
	 * @param groupId the primary key of the group
	 * @return the matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public static CheckInOutApp fetchCheckInOutAppByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCheckInOutAppByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the check in out app with the primary key.
	 *
	 * @param logId the primary key of the check in out app
	 * @return the check in out app
	 * @throws PortalException if a check in out app with the primary key could not be found
	 */
	public static CheckInOutApp getCheckInOutApp(long logId)
		throws PortalException {

		return getService().getCheckInOutApp(logId);
	}

	/**
	 * Returns the check in out app matching the UUID and group.
	 *
	 * @param uuid the check in out app's UUID
	 * @param groupId the primary key of the group
	 * @return the matching check in out app
	 * @throws PortalException if a matching check in out app could not be found
	 */
	public static CheckInOutApp getCheckInOutAppByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCheckInOutAppByUuidAndGroupId(uuid, groupId);
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
	public static List<CheckInOutApp> getCheckInOutApps(int start, int end) {
		return getService().getCheckInOutApps(start, end);
	}

	/**
	 * Returns all the check in out apps matching the UUID and company.
	 *
	 * @param uuid the UUID of the check in out apps
	 * @param companyId the primary key of the company
	 * @return the matching check in out apps, or an empty list if no matches were found
	 */
	public static List<CheckInOutApp> getCheckInOutAppsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCheckInOutAppsByUuidAndCompanyId(
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
	public static List<CheckInOutApp> getCheckInOutAppsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CheckInOutApp> orderByComparator) {

		return getService().getCheckInOutAppsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of check in out apps.
	 *
	 * @return the number of check in out apps
	 */
	public static int getCheckInOutAppsCount() {
		return getService().getCheckInOutAppsCount();
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
	 * Updates the check in out app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckInOutAppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkInOutApp the check in out app
	 * @return the check in out app that was updated
	 */
	public static CheckInOutApp updateCheckInOutApp(
		CheckInOutApp checkInOutApp) {

		return getService().updateCheckInOutApp(checkInOutApp);
	}

	public static CheckInOutAppLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<CheckInOutAppLocalService> _serviceSnapshot =
		new Snapshot<>(
			CheckInOutAppLocalServiceUtil.class,
			CheckInOutAppLocalService.class);

}