/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import fironlineser.exception.NoSuchPoliceStationException;

import fironlineser.model.PoliceStation;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the police station service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PoliceStationUtil
 * @generated
 */
@ProviderType
public interface PoliceStationPersistence
	extends BasePersistence<PoliceStation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PoliceStationUtil} to access the police station persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the police stations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching police stations
	 */
	public java.util.List<PoliceStation> findByUuid(String uuid);

	/**
	 * Returns a range of all the police stations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PoliceStationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of police stations
	 * @param end the upper bound of the range of police stations (not inclusive)
	 * @return the range of matching police stations
	 */
	public java.util.List<PoliceStation> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the police stations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PoliceStationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of police stations
	 * @param end the upper bound of the range of police stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching police stations
	 */
	public java.util.List<PoliceStation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the police stations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PoliceStationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of police stations
	 * @param end the upper bound of the range of police stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching police stations
	 */
	public java.util.List<PoliceStation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first police station in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	public PoliceStation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
				orderByComparator)
		throws NoSuchPoliceStationException;

	/**
	 * Returns the first police station in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station, or <code>null</code> if a matching police station could not be found
	 */
	public PoliceStation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator);

	/**
	 * Returns the last police station in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	public PoliceStation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
				orderByComparator)
		throws NoSuchPoliceStationException;

	/**
	 * Returns the last police station in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station, or <code>null</code> if a matching police station could not be found
	 */
	public PoliceStation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator);

	/**
	 * Returns the police stations before and after the current police station in the ordered set where uuid = &#63;.
	 *
	 * @param stationId the primary key of the current police station
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next police station
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	public PoliceStation[] findByUuid_PrevAndNext(
			long stationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
				orderByComparator)
		throws NoSuchPoliceStationException;

	/**
	 * Removes all the police stations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of police stations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching police stations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the police stations where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @return the matching police stations
	 */
	public java.util.List<PoliceStation> findByJurisdiction(
		String jurisdictionArea);

	/**
	 * Returns a range of all the police stations where jurisdictionArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PoliceStationModelImpl</code>.
	 * </p>
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param start the lower bound of the range of police stations
	 * @param end the upper bound of the range of police stations (not inclusive)
	 * @return the range of matching police stations
	 */
	public java.util.List<PoliceStation> findByJurisdiction(
		String jurisdictionArea, int start, int end);

	/**
	 * Returns an ordered range of all the police stations where jurisdictionArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PoliceStationModelImpl</code>.
	 * </p>
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param start the lower bound of the range of police stations
	 * @param end the upper bound of the range of police stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching police stations
	 */
	public java.util.List<PoliceStation> findByJurisdiction(
		String jurisdictionArea, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the police stations where jurisdictionArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PoliceStationModelImpl</code>.
	 * </p>
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param start the lower bound of the range of police stations
	 * @param end the upper bound of the range of police stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching police stations
	 */
	public java.util.List<PoliceStation> findByJurisdiction(
		String jurisdictionArea, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	public PoliceStation findByJurisdiction_First(
			String jurisdictionArea,
			com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
				orderByComparator)
		throws NoSuchPoliceStationException;

	/**
	 * Returns the first police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station, or <code>null</code> if a matching police station could not be found
	 */
	public PoliceStation fetchByJurisdiction_First(
		String jurisdictionArea,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator);

	/**
	 * Returns the last police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	public PoliceStation findByJurisdiction_Last(
			String jurisdictionArea,
			com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
				orderByComparator)
		throws NoSuchPoliceStationException;

	/**
	 * Returns the last police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station, or <code>null</code> if a matching police station could not be found
	 */
	public PoliceStation fetchByJurisdiction_Last(
		String jurisdictionArea,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator);

	/**
	 * Returns the police stations before and after the current police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param stationId the primary key of the current police station
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next police station
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	public PoliceStation[] findByJurisdiction_PrevAndNext(
			long stationId, String jurisdictionArea,
			com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
				orderByComparator)
		throws NoSuchPoliceStationException;

	/**
	 * Removes all the police stations where jurisdictionArea = &#63; from the database.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 */
	public void removeByJurisdiction(String jurisdictionArea);

	/**
	 * Returns the number of police stations where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @return the number of matching police stations
	 */
	public int countByJurisdiction(String jurisdictionArea);

	/**
	 * Returns all the police stations where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @return the matching police stations
	 */
	public java.util.List<PoliceStation> findByStationName(String stationName);

	/**
	 * Returns a range of all the police stations where stationName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PoliceStationModelImpl</code>.
	 * </p>
	 *
	 * @param stationName the station name
	 * @param start the lower bound of the range of police stations
	 * @param end the upper bound of the range of police stations (not inclusive)
	 * @return the range of matching police stations
	 */
	public java.util.List<PoliceStation> findByStationName(
		String stationName, int start, int end);

	/**
	 * Returns an ordered range of all the police stations where stationName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PoliceStationModelImpl</code>.
	 * </p>
	 *
	 * @param stationName the station name
	 * @param start the lower bound of the range of police stations
	 * @param end the upper bound of the range of police stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching police stations
	 */
	public java.util.List<PoliceStation> findByStationName(
		String stationName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the police stations where stationName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PoliceStationModelImpl</code>.
	 * </p>
	 *
	 * @param stationName the station name
	 * @param start the lower bound of the range of police stations
	 * @param end the upper bound of the range of police stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching police stations
	 */
	public java.util.List<PoliceStation> findByStationName(
		String stationName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	public PoliceStation findByStationName_First(
			String stationName,
			com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
				orderByComparator)
		throws NoSuchPoliceStationException;

	/**
	 * Returns the first police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station, or <code>null</code> if a matching police station could not be found
	 */
	public PoliceStation fetchByStationName_First(
		String stationName,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator);

	/**
	 * Returns the last police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	public PoliceStation findByStationName_Last(
			String stationName,
			com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
				orderByComparator)
		throws NoSuchPoliceStationException;

	/**
	 * Returns the last police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station, or <code>null</code> if a matching police station could not be found
	 */
	public PoliceStation fetchByStationName_Last(
		String stationName,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator);

	/**
	 * Returns the police stations before and after the current police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationId the primary key of the current police station
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next police station
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	public PoliceStation[] findByStationName_PrevAndNext(
			long stationId, String stationName,
			com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
				orderByComparator)
		throws NoSuchPoliceStationException;

	/**
	 * Removes all the police stations where stationName = &#63; from the database.
	 *
	 * @param stationName the station name
	 */
	public void removeByStationName(String stationName);

	/**
	 * Returns the number of police stations where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @return the number of matching police stations
	 */
	public int countByStationName(String stationName);

	/**
	 * Caches the police station in the entity cache if it is enabled.
	 *
	 * @param policeStation the police station
	 */
	public void cacheResult(PoliceStation policeStation);

	/**
	 * Caches the police stations in the entity cache if it is enabled.
	 *
	 * @param policeStations the police stations
	 */
	public void cacheResult(java.util.List<PoliceStation> policeStations);

	/**
	 * Creates a new police station with the primary key. Does not add the police station to the database.
	 *
	 * @param stationId the primary key for the new police station
	 * @return the new police station
	 */
	public PoliceStation create(long stationId);

	/**
	 * Removes the police station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stationId the primary key of the police station
	 * @return the police station that was removed
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	public PoliceStation remove(long stationId)
		throws NoSuchPoliceStationException;

	public PoliceStation updateImpl(PoliceStation policeStation);

	/**
	 * Returns the police station with the primary key or throws a <code>NoSuchPoliceStationException</code> if it could not be found.
	 *
	 * @param stationId the primary key of the police station
	 * @return the police station
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	public PoliceStation findByPrimaryKey(long stationId)
		throws NoSuchPoliceStationException;

	/**
	 * Returns the police station with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stationId the primary key of the police station
	 * @return the police station, or <code>null</code> if a police station with the primary key could not be found
	 */
	public PoliceStation fetchByPrimaryKey(long stationId);

	/**
	 * Returns all the police stations.
	 *
	 * @return the police stations
	 */
	public java.util.List<PoliceStation> findAll();

	/**
	 * Returns a range of all the police stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PoliceStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of police stations
	 * @param end the upper bound of the range of police stations (not inclusive)
	 * @return the range of police stations
	 */
	public java.util.List<PoliceStation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the police stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PoliceStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of police stations
	 * @param end the upper bound of the range of police stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of police stations
	 */
	public java.util.List<PoliceStation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the police stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PoliceStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of police stations
	 * @param end the upper bound of the range of police stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of police stations
	 */
	public java.util.List<PoliceStation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PoliceStation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the police stations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of police stations.
	 *
	 * @return the number of police stations
	 */
	public int countAll();

}