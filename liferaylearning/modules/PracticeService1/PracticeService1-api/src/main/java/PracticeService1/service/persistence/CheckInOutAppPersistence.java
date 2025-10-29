/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.service.persistence;

import PracticeService1.exception.NoSuchCheckInOutAppException;

import PracticeService1.model.CheckInOutApp;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the check in out app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CheckInOutAppUtil
 * @generated
 */
@ProviderType
public interface CheckInOutAppPersistence
	extends BasePersistence<CheckInOutApp> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CheckInOutAppUtil} to access the check in out app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the check in out apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching check in out apps
	 */
	public java.util.List<CheckInOutApp> findByUuid(String uuid);

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
	public java.util.List<CheckInOutApp> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CheckInOutApp> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
			orderByComparator);

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
	public java.util.List<CheckInOutApp> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	public CheckInOutApp findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
				orderByComparator)
		throws NoSuchCheckInOutAppException;

	/**
	 * Returns the first check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public CheckInOutApp fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
			orderByComparator);

	/**
	 * Returns the last check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	public CheckInOutApp findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
				orderByComparator)
		throws NoSuchCheckInOutAppException;

	/**
	 * Returns the last check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public CheckInOutApp fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
			orderByComparator);

	/**
	 * Returns the check in out apps before and after the current check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param logId the primary key of the current check in out app
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next check in out app
	 * @throws NoSuchCheckInOutAppException if a check in out app with the primary key could not be found
	 */
	public CheckInOutApp[] findByUuid_PrevAndNext(
			long logId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
				orderByComparator)
		throws NoSuchCheckInOutAppException;

	/**
	 * Removes all the check in out apps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of check in out apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching check in out apps
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the check in out app where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCheckInOutAppException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	public CheckInOutApp findByUUID_G(String uuid, long groupId)
		throws NoSuchCheckInOutAppException;

	/**
	 * Returns the check in out app where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public CheckInOutApp fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the check in out app where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public CheckInOutApp fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the check in out app where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the check in out app that was removed
	 */
	public CheckInOutApp removeByUUID_G(String uuid, long groupId)
		throws NoSuchCheckInOutAppException;

	/**
	 * Returns the number of check in out apps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching check in out apps
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the check in out apps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching check in out apps
	 */
	public java.util.List<CheckInOutApp> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CheckInOutApp> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CheckInOutApp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
			orderByComparator);

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
	public java.util.List<CheckInOutApp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first check in out app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	public CheckInOutApp findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
				orderByComparator)
		throws NoSuchCheckInOutAppException;

	/**
	 * Returns the first check in out app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public CheckInOutApp fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
			orderByComparator);

	/**
	 * Returns the last check in out app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	public CheckInOutApp findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
				orderByComparator)
		throws NoSuchCheckInOutAppException;

	/**
	 * Returns the last check in out app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	public CheckInOutApp fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
			orderByComparator);

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
	public CheckInOutApp[] findByUuid_C_PrevAndNext(
			long logId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
				orderByComparator)
		throws NoSuchCheckInOutAppException;

	/**
	 * Removes all the check in out apps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of check in out apps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching check in out apps
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the check in out app in the entity cache if it is enabled.
	 *
	 * @param checkInOutApp the check in out app
	 */
	public void cacheResult(CheckInOutApp checkInOutApp);

	/**
	 * Caches the check in out apps in the entity cache if it is enabled.
	 *
	 * @param checkInOutApps the check in out apps
	 */
	public void cacheResult(java.util.List<CheckInOutApp> checkInOutApps);

	/**
	 * Creates a new check in out app with the primary key. Does not add the check in out app to the database.
	 *
	 * @param logId the primary key for the new check in out app
	 * @return the new check in out app
	 */
	public CheckInOutApp create(long logId);

	/**
	 * Removes the check in out app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the check in out app
	 * @return the check in out app that was removed
	 * @throws NoSuchCheckInOutAppException if a check in out app with the primary key could not be found
	 */
	public CheckInOutApp remove(long logId) throws NoSuchCheckInOutAppException;

	public CheckInOutApp updateImpl(CheckInOutApp checkInOutApp);

	/**
	 * Returns the check in out app with the primary key or throws a <code>NoSuchCheckInOutAppException</code> if it could not be found.
	 *
	 * @param logId the primary key of the check in out app
	 * @return the check in out app
	 * @throws NoSuchCheckInOutAppException if a check in out app with the primary key could not be found
	 */
	public CheckInOutApp findByPrimaryKey(long logId)
		throws NoSuchCheckInOutAppException;

	/**
	 * Returns the check in out app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the check in out app
	 * @return the check in out app, or <code>null</code> if a check in out app with the primary key could not be found
	 */
	public CheckInOutApp fetchByPrimaryKey(long logId);

	/**
	 * Returns all the check in out apps.
	 *
	 * @return the check in out apps
	 */
	public java.util.List<CheckInOutApp> findAll();

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
	public java.util.List<CheckInOutApp> findAll(int start, int end);

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
	public java.util.List<CheckInOutApp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
			orderByComparator);

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
	public java.util.List<CheckInOutApp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CheckInOutApp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the check in out apps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of check in out apps.
	 *
	 * @return the number of check in out apps
	 */
	public int countAll();

}