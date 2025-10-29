/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import fironlineser.model.PoliceStation;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the police station service. This utility wraps <code>fironlineser.service.persistence.impl.PoliceStationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PoliceStationPersistence
 * @generated
 */
public class PoliceStationUtil {

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
	public static void clearCache(PoliceStation policeStation) {
		getPersistence().clearCache(policeStation);
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
	public static Map<Serializable, PoliceStation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PoliceStation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PoliceStation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PoliceStation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PoliceStation update(PoliceStation policeStation) {
		return getPersistence().update(policeStation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PoliceStation update(
		PoliceStation policeStation, ServiceContext serviceContext) {

		return getPersistence().update(policeStation, serviceContext);
	}

	/**
	 * Returns all the police stations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching police stations
	 */
	public static List<PoliceStation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<PoliceStation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<PoliceStation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<PoliceStation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first police station in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	public static PoliceStation findByUuid_First(
			String uuid, OrderByComparator<PoliceStation> orderByComparator)
		throws fironlineser.exception.NoSuchPoliceStationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first police station in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station, or <code>null</code> if a matching police station could not be found
	 */
	public static PoliceStation fetchByUuid_First(
		String uuid, OrderByComparator<PoliceStation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last police station in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	public static PoliceStation findByUuid_Last(
			String uuid, OrderByComparator<PoliceStation> orderByComparator)
		throws fironlineser.exception.NoSuchPoliceStationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last police station in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station, or <code>null</code> if a matching police station could not be found
	 */
	public static PoliceStation fetchByUuid_Last(
		String uuid, OrderByComparator<PoliceStation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the police stations before and after the current police station in the ordered set where uuid = &#63;.
	 *
	 * @param stationId the primary key of the current police station
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next police station
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	public static PoliceStation[] findByUuid_PrevAndNext(
			long stationId, String uuid,
			OrderByComparator<PoliceStation> orderByComparator)
		throws fironlineser.exception.NoSuchPoliceStationException {

		return getPersistence().findByUuid_PrevAndNext(
			stationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the police stations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of police stations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching police stations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the police stations where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @return the matching police stations
	 */
	public static List<PoliceStation> findByJurisdiction(
		String jurisdictionArea) {

		return getPersistence().findByJurisdiction(jurisdictionArea);
	}

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
	public static List<PoliceStation> findByJurisdiction(
		String jurisdictionArea, int start, int end) {

		return getPersistence().findByJurisdiction(
			jurisdictionArea, start, end);
	}

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
	public static List<PoliceStation> findByJurisdiction(
		String jurisdictionArea, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator) {

		return getPersistence().findByJurisdiction(
			jurisdictionArea, start, end, orderByComparator);
	}

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
	public static List<PoliceStation> findByJurisdiction(
		String jurisdictionArea, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByJurisdiction(
			jurisdictionArea, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	public static PoliceStation findByJurisdiction_First(
			String jurisdictionArea,
			OrderByComparator<PoliceStation> orderByComparator)
		throws fironlineser.exception.NoSuchPoliceStationException {

		return getPersistence().findByJurisdiction_First(
			jurisdictionArea, orderByComparator);
	}

	/**
	 * Returns the first police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station, or <code>null</code> if a matching police station could not be found
	 */
	public static PoliceStation fetchByJurisdiction_First(
		String jurisdictionArea,
		OrderByComparator<PoliceStation> orderByComparator) {

		return getPersistence().fetchByJurisdiction_First(
			jurisdictionArea, orderByComparator);
	}

	/**
	 * Returns the last police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	public static PoliceStation findByJurisdiction_Last(
			String jurisdictionArea,
			OrderByComparator<PoliceStation> orderByComparator)
		throws fironlineser.exception.NoSuchPoliceStationException {

		return getPersistence().findByJurisdiction_Last(
			jurisdictionArea, orderByComparator);
	}

	/**
	 * Returns the last police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station, or <code>null</code> if a matching police station could not be found
	 */
	public static PoliceStation fetchByJurisdiction_Last(
		String jurisdictionArea,
		OrderByComparator<PoliceStation> orderByComparator) {

		return getPersistence().fetchByJurisdiction_Last(
			jurisdictionArea, orderByComparator);
	}

	/**
	 * Returns the police stations before and after the current police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param stationId the primary key of the current police station
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next police station
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	public static PoliceStation[] findByJurisdiction_PrevAndNext(
			long stationId, String jurisdictionArea,
			OrderByComparator<PoliceStation> orderByComparator)
		throws fironlineser.exception.NoSuchPoliceStationException {

		return getPersistence().findByJurisdiction_PrevAndNext(
			stationId, jurisdictionArea, orderByComparator);
	}

	/**
	 * Removes all the police stations where jurisdictionArea = &#63; from the database.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 */
	public static void removeByJurisdiction(String jurisdictionArea) {
		getPersistence().removeByJurisdiction(jurisdictionArea);
	}

	/**
	 * Returns the number of police stations where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @return the number of matching police stations
	 */
	public static int countByJurisdiction(String jurisdictionArea) {
		return getPersistence().countByJurisdiction(jurisdictionArea);
	}

	/**
	 * Returns all the police stations where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @return the matching police stations
	 */
	public static List<PoliceStation> findByStationName(String stationName) {
		return getPersistence().findByStationName(stationName);
	}

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
	public static List<PoliceStation> findByStationName(
		String stationName, int start, int end) {

		return getPersistence().findByStationName(stationName, start, end);
	}

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
	public static List<PoliceStation> findByStationName(
		String stationName, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator) {

		return getPersistence().findByStationName(
			stationName, start, end, orderByComparator);
	}

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
	public static List<PoliceStation> findByStationName(
		String stationName, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStationName(
			stationName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	public static PoliceStation findByStationName_First(
			String stationName,
			OrderByComparator<PoliceStation> orderByComparator)
		throws fironlineser.exception.NoSuchPoliceStationException {

		return getPersistence().findByStationName_First(
			stationName, orderByComparator);
	}

	/**
	 * Returns the first police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station, or <code>null</code> if a matching police station could not be found
	 */
	public static PoliceStation fetchByStationName_First(
		String stationName,
		OrderByComparator<PoliceStation> orderByComparator) {

		return getPersistence().fetchByStationName_First(
			stationName, orderByComparator);
	}

	/**
	 * Returns the last police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	public static PoliceStation findByStationName_Last(
			String stationName,
			OrderByComparator<PoliceStation> orderByComparator)
		throws fironlineser.exception.NoSuchPoliceStationException {

		return getPersistence().findByStationName_Last(
			stationName, orderByComparator);
	}

	/**
	 * Returns the last police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station, or <code>null</code> if a matching police station could not be found
	 */
	public static PoliceStation fetchByStationName_Last(
		String stationName,
		OrderByComparator<PoliceStation> orderByComparator) {

		return getPersistence().fetchByStationName_Last(
			stationName, orderByComparator);
	}

	/**
	 * Returns the police stations before and after the current police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationId the primary key of the current police station
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next police station
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	public static PoliceStation[] findByStationName_PrevAndNext(
			long stationId, String stationName,
			OrderByComparator<PoliceStation> orderByComparator)
		throws fironlineser.exception.NoSuchPoliceStationException {

		return getPersistence().findByStationName_PrevAndNext(
			stationId, stationName, orderByComparator);
	}

	/**
	 * Removes all the police stations where stationName = &#63; from the database.
	 *
	 * @param stationName the station name
	 */
	public static void removeByStationName(String stationName) {
		getPersistence().removeByStationName(stationName);
	}

	/**
	 * Returns the number of police stations where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @return the number of matching police stations
	 */
	public static int countByStationName(String stationName) {
		return getPersistence().countByStationName(stationName);
	}

	/**
	 * Caches the police station in the entity cache if it is enabled.
	 *
	 * @param policeStation the police station
	 */
	public static void cacheResult(PoliceStation policeStation) {
		getPersistence().cacheResult(policeStation);
	}

	/**
	 * Caches the police stations in the entity cache if it is enabled.
	 *
	 * @param policeStations the police stations
	 */
	public static void cacheResult(List<PoliceStation> policeStations) {
		getPersistence().cacheResult(policeStations);
	}

	/**
	 * Creates a new police station with the primary key. Does not add the police station to the database.
	 *
	 * @param stationId the primary key for the new police station
	 * @return the new police station
	 */
	public static PoliceStation create(long stationId) {
		return getPersistence().create(stationId);
	}

	/**
	 * Removes the police station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stationId the primary key of the police station
	 * @return the police station that was removed
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	public static PoliceStation remove(long stationId)
		throws fironlineser.exception.NoSuchPoliceStationException {

		return getPersistence().remove(stationId);
	}

	public static PoliceStation updateImpl(PoliceStation policeStation) {
		return getPersistence().updateImpl(policeStation);
	}

	/**
	 * Returns the police station with the primary key or throws a <code>NoSuchPoliceStationException</code> if it could not be found.
	 *
	 * @param stationId the primary key of the police station
	 * @return the police station
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	public static PoliceStation findByPrimaryKey(long stationId)
		throws fironlineser.exception.NoSuchPoliceStationException {

		return getPersistence().findByPrimaryKey(stationId);
	}

	/**
	 * Returns the police station with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stationId the primary key of the police station
	 * @return the police station, or <code>null</code> if a police station with the primary key could not be found
	 */
	public static PoliceStation fetchByPrimaryKey(long stationId) {
		return getPersistence().fetchByPrimaryKey(stationId);
	}

	/**
	 * Returns all the police stations.
	 *
	 * @return the police stations
	 */
	public static List<PoliceStation> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PoliceStation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PoliceStation> findAll(
		int start, int end,
		OrderByComparator<PoliceStation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PoliceStation> findAll(
		int start, int end, OrderByComparator<PoliceStation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the police stations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of police stations.
	 *
	 * @return the number of police stations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PoliceStationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PoliceStationPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PoliceStationPersistence _persistence;

}