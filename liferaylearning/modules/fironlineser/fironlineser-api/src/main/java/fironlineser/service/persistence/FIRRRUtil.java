/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import fironlineser.model.FIRRR;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the firrr service. This utility wraps <code>fironlineser.service.persistence.impl.FIRRRPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FIRRRPersistence
 * @generated
 */
public class FIRRRUtil {

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
	public static void clearCache(FIRRR firrr) {
		getPersistence().clearCache(firrr);
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
	public static Map<Serializable, FIRRR> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FIRRR> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FIRRR> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FIRRR> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FIRRR> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FIRRR update(FIRRR firrr) {
		return getPersistence().update(firrr);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FIRRR update(FIRRR firrr, ServiceContext serviceContext) {
		return getPersistence().update(firrr, serviceContext);
	}

	/**
	 * Returns all the firrrs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching firrrs
	 */
	public static List<FIRRR> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the firrrs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FIRRRModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of firrrs
	 * @param end the upper bound of the range of firrrs (not inclusive)
	 * @return the range of matching firrrs
	 */
	public static List<FIRRR> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the firrrs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FIRRRModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of firrrs
	 * @param end the upper bound of the range of firrrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching firrrs
	 */
	public static List<FIRRR> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FIRRR> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the firrrs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FIRRRModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of firrrs
	 * @param end the upper bound of the range of firrrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching firrrs
	 */
	public static List<FIRRR> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FIRRR> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first firrr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firrr
	 * @throws NoSuchFIRRRException if a matching firrr could not be found
	 */
	public static FIRRR findByUuid_First(
			String uuid, OrderByComparator<FIRRR> orderByComparator)
		throws fironlineser.exception.NoSuchFIRRRException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first firrr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firrr, or <code>null</code> if a matching firrr could not be found
	 */
	public static FIRRR fetchByUuid_First(
		String uuid, OrderByComparator<FIRRR> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last firrr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firrr
	 * @throws NoSuchFIRRRException if a matching firrr could not be found
	 */
	public static FIRRR findByUuid_Last(
			String uuid, OrderByComparator<FIRRR> orderByComparator)
		throws fironlineser.exception.NoSuchFIRRRException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last firrr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firrr, or <code>null</code> if a matching firrr could not be found
	 */
	public static FIRRR fetchByUuid_Last(
		String uuid, OrderByComparator<FIRRR> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the firrrs before and after the current firrr in the ordered set where uuid = &#63;.
	 *
	 * @param firId the primary key of the current firrr
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next firrr
	 * @throws NoSuchFIRRRException if a firrr with the primary key could not be found
	 */
	public static FIRRR[] findByUuid_PrevAndNext(
			long firId, String uuid, OrderByComparator<FIRRR> orderByComparator)
		throws fironlineser.exception.NoSuchFIRRRException {

		return getPersistence().findByUuid_PrevAndNext(
			firId, uuid, orderByComparator);
	}

	/**
	 * Removes all the firrrs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of firrrs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching firrrs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the firrrs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching firrrs
	 */
	public static List<FIRRR> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the firrrs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FIRRRModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of firrrs
	 * @param end the upper bound of the range of firrrs (not inclusive)
	 * @return the range of matching firrrs
	 */
	public static List<FIRRR> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the firrrs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FIRRRModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of firrrs
	 * @param end the upper bound of the range of firrrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching firrrs
	 */
	public static List<FIRRR> findByUserId(
		long userId, int start, int end,
		OrderByComparator<FIRRR> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the firrrs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FIRRRModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of firrrs
	 * @param end the upper bound of the range of firrrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching firrrs
	 */
	public static List<FIRRR> findByUserId(
		long userId, int start, int end,
		OrderByComparator<FIRRR> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first firrr in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firrr
	 * @throws NoSuchFIRRRException if a matching firrr could not be found
	 */
	public static FIRRR findByUserId_First(
			long userId, OrderByComparator<FIRRR> orderByComparator)
		throws fironlineser.exception.NoSuchFIRRRException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first firrr in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firrr, or <code>null</code> if a matching firrr could not be found
	 */
	public static FIRRR fetchByUserId_First(
		long userId, OrderByComparator<FIRRR> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last firrr in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firrr
	 * @throws NoSuchFIRRRException if a matching firrr could not be found
	 */
	public static FIRRR findByUserId_Last(
			long userId, OrderByComparator<FIRRR> orderByComparator)
		throws fironlineser.exception.NoSuchFIRRRException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last firrr in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firrr, or <code>null</code> if a matching firrr could not be found
	 */
	public static FIRRR fetchByUserId_Last(
		long userId, OrderByComparator<FIRRR> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the firrrs before and after the current firrr in the ordered set where userId = &#63;.
	 *
	 * @param firId the primary key of the current firrr
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next firrr
	 * @throws NoSuchFIRRRException if a firrr with the primary key could not be found
	 */
	public static FIRRR[] findByUserId_PrevAndNext(
			long firId, long userId, OrderByComparator<FIRRR> orderByComparator)
		throws fironlineser.exception.NoSuchFIRRRException {

		return getPersistence().findByUserId_PrevAndNext(
			firId, userId, orderByComparator);
	}

	/**
	 * Removes all the firrrs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of firrrs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching firrrs
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the firrr in the entity cache if it is enabled.
	 *
	 * @param firrr the firrr
	 */
	public static void cacheResult(FIRRR firrr) {
		getPersistence().cacheResult(firrr);
	}

	/**
	 * Caches the firrrs in the entity cache if it is enabled.
	 *
	 * @param firrrs the firrrs
	 */
	public static void cacheResult(List<FIRRR> firrrs) {
		getPersistence().cacheResult(firrrs);
	}

	/**
	 * Creates a new firrr with the primary key. Does not add the firrr to the database.
	 *
	 * @param firId the primary key for the new firrr
	 * @return the new firrr
	 */
	public static FIRRR create(long firId) {
		return getPersistence().create(firId);
	}

	/**
	 * Removes the firrr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param firId the primary key of the firrr
	 * @return the firrr that was removed
	 * @throws NoSuchFIRRRException if a firrr with the primary key could not be found
	 */
	public static FIRRR remove(long firId)
		throws fironlineser.exception.NoSuchFIRRRException {

		return getPersistence().remove(firId);
	}

	public static FIRRR updateImpl(FIRRR firrr) {
		return getPersistence().updateImpl(firrr);
	}

	/**
	 * Returns the firrr with the primary key or throws a <code>NoSuchFIRRRException</code> if it could not be found.
	 *
	 * @param firId the primary key of the firrr
	 * @return the firrr
	 * @throws NoSuchFIRRRException if a firrr with the primary key could not be found
	 */
	public static FIRRR findByPrimaryKey(long firId)
		throws fironlineser.exception.NoSuchFIRRRException {

		return getPersistence().findByPrimaryKey(firId);
	}

	/**
	 * Returns the firrr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param firId the primary key of the firrr
	 * @return the firrr, or <code>null</code> if a firrr with the primary key could not be found
	 */
	public static FIRRR fetchByPrimaryKey(long firId) {
		return getPersistence().fetchByPrimaryKey(firId);
	}

	/**
	 * Returns all the firrrs.
	 *
	 * @return the firrrs
	 */
	public static List<FIRRR> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the firrrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FIRRRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of firrrs
	 * @param end the upper bound of the range of firrrs (not inclusive)
	 * @return the range of firrrs
	 */
	public static List<FIRRR> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the firrrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FIRRRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of firrrs
	 * @param end the upper bound of the range of firrrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of firrrs
	 */
	public static List<FIRRR> findAll(
		int start, int end, OrderByComparator<FIRRR> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the firrrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FIRRRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of firrrs
	 * @param end the upper bound of the range of firrrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of firrrs
	 */
	public static List<FIRRR> findAll(
		int start, int end, OrderByComparator<FIRRR> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the firrrs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of firrrs.
	 *
	 * @return the number of firrrs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FIRRRPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(FIRRRPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile FIRRRPersistence _persistence;

}