/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package FlightMgmtSystemService.service.persistence;

import FlightMgmtSystemService.exception.NoSuchFlightException;

import FlightMgmtSystemService.model.Flight;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the flight service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlightUtil
 * @generated
 */
@ProviderType
public interface FlightPersistence extends BasePersistence<Flight> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlightUtil} to access the flight persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the flights where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching flights
	 */
	public java.util.List<Flight> findByUuid(String uuid);

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
	public java.util.List<Flight> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Flight> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Flight>
			orderByComparator);

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
	public java.util.List<Flight> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Flight>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first flight in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	public Flight findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Flight>
				orderByComparator)
		throws NoSuchFlightException;

	/**
	 * Returns the first flight in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public Flight fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Flight>
			orderByComparator);

	/**
	 * Returns the last flight in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	public Flight findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Flight>
				orderByComparator)
		throws NoSuchFlightException;

	/**
	 * Returns the last flight in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public Flight fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Flight>
			orderByComparator);

	/**
	 * Returns the flights before and after the current flight in the ordered set where uuid = &#63;.
	 *
	 * @param flightId the primary key of the current flight
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flight
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	public Flight[] findByUuid_PrevAndNext(
			long flightId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Flight>
				orderByComparator)
		throws NoSuchFlightException;

	/**
	 * Removes all the flights where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of flights where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching flights
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the flight where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFlightException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	public Flight findByUUID_G(String uuid, long groupId)
		throws NoSuchFlightException;

	/**
	 * Returns the flight where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public Flight fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the flight where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public Flight fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the flight where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the flight that was removed
	 */
	public Flight removeByUUID_G(String uuid, long groupId)
		throws NoSuchFlightException;

	/**
	 * Returns the number of flights where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching flights
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the flights where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching flights
	 */
	public java.util.List<Flight> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Flight> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Flight> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Flight>
			orderByComparator);

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
	public java.util.List<Flight> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Flight>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	public Flight findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Flight>
				orderByComparator)
		throws NoSuchFlightException;

	/**
	 * Returns the first flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public Flight fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Flight>
			orderByComparator);

	/**
	 * Returns the last flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	public Flight findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Flight>
				orderByComparator)
		throws NoSuchFlightException;

	/**
	 * Returns the last flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public Flight fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Flight>
			orderByComparator);

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
	public Flight[] findByUuid_C_PrevAndNext(
			long flightId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Flight>
				orderByComparator)
		throws NoSuchFlightException;

	/**
	 * Removes all the flights where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of flights where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching flights
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the flight in the entity cache if it is enabled.
	 *
	 * @param flight the flight
	 */
	public void cacheResult(Flight flight);

	/**
	 * Caches the flights in the entity cache if it is enabled.
	 *
	 * @param flights the flights
	 */
	public void cacheResult(java.util.List<Flight> flights);

	/**
	 * Creates a new flight with the primary key. Does not add the flight to the database.
	 *
	 * @param flightId the primary key for the new flight
	 * @return the new flight
	 */
	public Flight create(long flightId);

	/**
	 * Removes the flight with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight that was removed
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	public Flight remove(long flightId) throws NoSuchFlightException;

	public Flight updateImpl(Flight flight);

	/**
	 * Returns the flight with the primary key or throws a <code>NoSuchFlightException</code> if it could not be found.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	public Flight findByPrimaryKey(long flightId) throws NoSuchFlightException;

	/**
	 * Returns the flight with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight, or <code>null</code> if a flight with the primary key could not be found
	 */
	public Flight fetchByPrimaryKey(long flightId);

	/**
	 * Returns all the flights.
	 *
	 * @return the flights
	 */
	public java.util.List<Flight> findAll();

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
	public java.util.List<Flight> findAll(int start, int end);

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
	public java.util.List<Flight> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Flight>
			orderByComparator);

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
	public java.util.List<Flight> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Flight>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the flights from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of flights.
	 *
	 * @return the number of flights
	 */
	public int countAll();

}