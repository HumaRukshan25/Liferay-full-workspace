/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package FlightMgmtSystemService.service.persistence;

import FlightMgmtSystemService.model.Flight;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the flight service. This utility wraps <code>FlightMgmtSystemService.service.persistence.impl.FlightPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlightPersistence
 * @generated
 */
public class FlightUtil {

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
	public static void clearCache(Flight flight) {
		getPersistence().clearCache(flight);
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
	public static Map<Serializable, Flight> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Flight> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Flight> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Flight> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Flight> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Flight update(Flight flight) {
		return getPersistence().update(flight);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Flight update(Flight flight, ServiceContext serviceContext) {
		return getPersistence().update(flight, serviceContext);
	}

	/**
	 * Returns all the flights where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching flights
	 */
	public static List<Flight> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the flights where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @return the range of matching flights
	 */
	public static List<Flight> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the flights where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flights
	 */
	public static List<Flight> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Flight> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the flights where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching flights
	 */
	public static List<Flight> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Flight> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first flight in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	public static Flight findByUuid_First(
			String uuid, OrderByComparator<Flight> orderByComparator)
		throws FlightMgmtSystemService.exception.NoSuchFlightException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first flight in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public static Flight fetchByUuid_First(
		String uuid, OrderByComparator<Flight> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last flight in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	public static Flight findByUuid_Last(
			String uuid, OrderByComparator<Flight> orderByComparator)
		throws FlightMgmtSystemService.exception.NoSuchFlightException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last flight in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public static Flight fetchByUuid_Last(
		String uuid, OrderByComparator<Flight> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the flights before and after the current flight in the ordered set where uuid = &#63;.
	 *
	 * @param flightId the primary key of the current flight
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flight
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	public static Flight[] findByUuid_PrevAndNext(
			long flightId, String uuid,
			OrderByComparator<Flight> orderByComparator)
		throws FlightMgmtSystemService.exception.NoSuchFlightException {

		return getPersistence().findByUuid_PrevAndNext(
			flightId, uuid, orderByComparator);
	}

	/**
	 * Removes all the flights where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of flights where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching flights
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the flight where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFlightException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	public static Flight findByUUID_G(String uuid, long groupId)
		throws FlightMgmtSystemService.exception.NoSuchFlightException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the flight where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public static Flight fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the flight where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public static Flight fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the flight where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the flight that was removed
	 */
	public static Flight removeByUUID_G(String uuid, long groupId)
		throws FlightMgmtSystemService.exception.NoSuchFlightException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of flights where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching flights
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the flights where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching flights
	 */
	public static List<Flight> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the flights where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @return the range of matching flights
	 */
	public static List<Flight> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the flights where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flights
	 */
	public static List<Flight> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Flight> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the flights where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching flights
	 */
	public static List<Flight> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Flight> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	public static Flight findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Flight> orderByComparator)
		throws FlightMgmtSystemService.exception.NoSuchFlightException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public static Flight fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Flight> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	public static Flight findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Flight> orderByComparator)
		throws FlightMgmtSystemService.exception.NoSuchFlightException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public static Flight fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Flight> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the flights before and after the current flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param flightId the primary key of the current flight
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flight
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	public static Flight[] findByUuid_C_PrevAndNext(
			long flightId, String uuid, long companyId,
			OrderByComparator<Flight> orderByComparator)
		throws FlightMgmtSystemService.exception.NoSuchFlightException {

		return getPersistence().findByUuid_C_PrevAndNext(
			flightId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the flights where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of flights where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching flights
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the flight in the entity cache if it is enabled.
	 *
	 * @param flight the flight
	 */
	public static void cacheResult(Flight flight) {
		getPersistence().cacheResult(flight);
	}

	/**
	 * Caches the flights in the entity cache if it is enabled.
	 *
	 * @param flights the flights
	 */
	public static void cacheResult(List<Flight> flights) {
		getPersistence().cacheResult(flights);
	}

	/**
	 * Creates a new flight with the primary key. Does not add the flight to the database.
	 *
	 * @param flightId the primary key for the new flight
	 * @return the new flight
	 */
	public static Flight create(long flightId) {
		return getPersistence().create(flightId);
	}

	/**
	 * Removes the flight with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight that was removed
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	public static Flight remove(long flightId)
		throws FlightMgmtSystemService.exception.NoSuchFlightException {

		return getPersistence().remove(flightId);
	}

	public static Flight updateImpl(Flight flight) {
		return getPersistence().updateImpl(flight);
	}

	/**
	 * Returns the flight with the primary key or throws a <code>NoSuchFlightException</code> if it could not be found.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	public static Flight findByPrimaryKey(long flightId)
		throws FlightMgmtSystemService.exception.NoSuchFlightException {

		return getPersistence().findByPrimaryKey(flightId);
	}

	/**
	 * Returns the flight with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight, or <code>null</code> if a flight with the primary key could not be found
	 */
	public static Flight fetchByPrimaryKey(long flightId) {
		return getPersistence().fetchByPrimaryKey(flightId);
	}

	/**
	 * Returns all the flights.
	 *
	 * @return the flights
	 */
	public static List<Flight> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the flights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @return the range of flights
	 */
	public static List<Flight> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the flights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flights
	 */
	public static List<Flight> findAll(
		int start, int end, OrderByComparator<Flight> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the flights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of flights
	 */
	public static List<Flight> findAll(
		int start, int end, OrderByComparator<Flight> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the flights from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of flights.
	 *
	 * @return the number of flights
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FlightPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(FlightPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile FlightPersistence _persistence;

}