/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.service.persistence;

import PracticeService1.model.CheckInOutApp;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the check in out app service. This utility wraps <code>PracticeService1.service.persistence.impl.CheckInOutAppPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CheckInOutAppPersistence
 * @generated
 */
public class CheckInOutAppUtil {

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
	public static void clearCache(CheckInOutApp checkInOutApp) {
		getPersistence().clearCache(checkInOutApp);
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
	public static Map<Serializable, CheckInOutApp> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CheckInOutApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CheckInOutApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CheckInOutApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CheckInOutApp> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CheckInOutApp update(CheckInOutApp checkInOutApp) {
		return getPersistence().update(checkInOutApp);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CheckInOutApp update(
		CheckInOutApp checkInOutApp, ServiceContext serviceContext) {

		return getPersistence().update(checkInOutApp, serviceContext);
	}

	/**
	 * Returns all the check in out apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching check in out apps
	 */
	public static List<CheckInOutApp> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the check in out apps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckInOutAppModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of check in out apps
	 * @param end the upper bound of the range of check in out apps (not inclusive)
	 * @return the range of matching check in out apps
	 */
	public static List<CheckInOutApp> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the check in out apps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckInOutAppModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of check in out apps
	 * @param end the upper bound of the range of check in out apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching check in out apps
	 */
	public static List<CheckInOutApp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CheckInOutApp> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the check in out apps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckInOutAppModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of check in out apps
	 * @param end the upper bound of the range of check in out apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching check in out apps
	 */
	public static List<CheckInOutApp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CheckInOutApp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	public static CheckInOutApp findByUuid_First(
			String uuid, OrderByComparator<CheckInOutApp> orderByComparator)
		throws PracticeService1.exception.NoSuchCheckInOutAppException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public static CheckInOutApp fetchByUuid_First(
		String uuid, OrderByComparator<CheckInOutApp> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	public static CheckInOutApp findByUuid_Last(
			String uuid, OrderByComparator<CheckInOutApp> orderByComparator)
		throws PracticeService1.exception.NoSuchCheckInOutAppException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public static CheckInOutApp fetchByUuid_Last(
		String uuid, OrderByComparator<CheckInOutApp> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the check in out apps before and after the current check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param logId the primary key of the current check in out app
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next check in out app
	 * @throws NoSuchCheckInOutAppException if a check in out app with the primary key could not be found
	 */
	public static CheckInOutApp[] findByUuid_PrevAndNext(
			long logId, String uuid,
			OrderByComparator<CheckInOutApp> orderByComparator)
		throws PracticeService1.exception.NoSuchCheckInOutAppException {

		return getPersistence().findByUuid_PrevAndNext(
			logId, uuid, orderByComparator);
	}

	/**
	 * Removes all the check in out apps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of check in out apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching check in out apps
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the check in out app where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCheckInOutAppException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	public static CheckInOutApp findByUUID_G(String uuid, long groupId)
		throws PracticeService1.exception.NoSuchCheckInOutAppException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the check in out app where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public static CheckInOutApp fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the check in out app where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public static CheckInOutApp fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the check in out app where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the check in out app that was removed
	 */
	public static CheckInOutApp removeByUUID_G(String uuid, long groupId)
		throws PracticeService1.exception.NoSuchCheckInOutAppException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of check in out apps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching check in out apps
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the check in out apps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching check in out apps
	 */
	public static List<CheckInOutApp> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the check in out apps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckInOutAppModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of check in out apps
	 * @param end the upper bound of the range of check in out apps (not inclusive)
	 * @return the range of matching check in out apps
	 */
	public static List<CheckInOutApp> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the check in out apps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckInOutAppModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of check in out apps
	 * @param end the upper bound of the range of check in out apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching check in out apps
	 */
	public static List<CheckInOutApp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CheckInOutApp> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the check in out apps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckInOutAppModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of check in out apps
	 * @param end the upper bound of the range of check in out apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching check in out apps
	 */
	public static List<CheckInOutApp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CheckInOutApp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first check in out app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	public static CheckInOutApp findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CheckInOutApp> orderByComparator)
		throws PracticeService1.exception.NoSuchCheckInOutAppException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first check in out app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public static CheckInOutApp fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CheckInOutApp> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last check in out app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	public static CheckInOutApp findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CheckInOutApp> orderByComparator)
		throws PracticeService1.exception.NoSuchCheckInOutAppException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last check in out app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public static CheckInOutApp fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CheckInOutApp> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the check in out apps before and after the current check in out app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param logId the primary key of the current check in out app
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next check in out app
	 * @throws NoSuchCheckInOutAppException if a check in out app with the primary key could not be found
	 */
	public static CheckInOutApp[] findByUuid_C_PrevAndNext(
			long logId, String uuid, long companyId,
			OrderByComparator<CheckInOutApp> orderByComparator)
		throws PracticeService1.exception.NoSuchCheckInOutAppException {

		return getPersistence().findByUuid_C_PrevAndNext(
			logId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the check in out apps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of check in out apps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching check in out apps
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the check in out app in the entity cache if it is enabled.
	 *
	 * @param checkInOutApp the check in out app
	 */
	public static void cacheResult(CheckInOutApp checkInOutApp) {
		getPersistence().cacheResult(checkInOutApp);
	}

	/**
	 * Caches the check in out apps in the entity cache if it is enabled.
	 *
	 * @param checkInOutApps the check in out apps
	 */
	public static void cacheResult(List<CheckInOutApp> checkInOutApps) {
		getPersistence().cacheResult(checkInOutApps);
	}

	/**
	 * Creates a new check in out app with the primary key. Does not add the check in out app to the database.
	 *
	 * @param logId the primary key for the new check in out app
	 * @return the new check in out app
	 */
	public static CheckInOutApp create(long logId) {
		return getPersistence().create(logId);
	}

	/**
	 * Removes the check in out app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the check in out app
	 * @return the check in out app that was removed
	 * @throws NoSuchCheckInOutAppException if a check in out app with the primary key could not be found
	 */
	public static CheckInOutApp remove(long logId)
		throws PracticeService1.exception.NoSuchCheckInOutAppException {

		return getPersistence().remove(logId);
	}

	public static CheckInOutApp updateImpl(CheckInOutApp checkInOutApp) {
		return getPersistence().updateImpl(checkInOutApp);
	}

	/**
	 * Returns the check in out app with the primary key or throws a <code>NoSuchCheckInOutAppException</code> if it could not be found.
	 *
	 * @param logId the primary key of the check in out app
	 * @return the check in out app
	 * @throws NoSuchCheckInOutAppException if a check in out app with the primary key could not be found
	 */
	public static CheckInOutApp findByPrimaryKey(long logId)
		throws PracticeService1.exception.NoSuchCheckInOutAppException {

		return getPersistence().findByPrimaryKey(logId);
	}

	/**
	 * Returns the check in out app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the check in out app
	 * @return the check in out app, or <code>null</code> if a check in out app with the primary key could not be found
	 */
	public static CheckInOutApp fetchByPrimaryKey(long logId) {
		return getPersistence().fetchByPrimaryKey(logId);
	}

	/**
	 * Returns all the check in out apps.
	 *
	 * @return the check in out apps
	 */
	public static List<CheckInOutApp> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the check in out apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckInOutAppModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of check in out apps
	 * @param end the upper bound of the range of check in out apps (not inclusive)
	 * @return the range of check in out apps
	 */
	public static List<CheckInOutApp> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the check in out apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckInOutAppModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of check in out apps
	 * @param end the upper bound of the range of check in out apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of check in out apps
	 */
	public static List<CheckInOutApp> findAll(
		int start, int end,
		OrderByComparator<CheckInOutApp> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the check in out apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckInOutAppModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of check in out apps
	 * @param end the upper bound of the range of check in out apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of check in out apps
	 */
	public static List<CheckInOutApp> findAll(
		int start, int end, OrderByComparator<CheckInOutApp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the check in out apps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of check in out apps.
	 *
	 * @return the number of check in out apps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CheckInOutAppPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CheckInOutAppPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CheckInOutAppPersistence _persistence;

}