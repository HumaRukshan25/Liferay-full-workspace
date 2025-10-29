/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import fironlineser.exception.NoSuchPoliceStationException;

import fironlineser.model.PoliceStation;
import fironlineser.model.PoliceStationTable;
import fironlineser.model.impl.PoliceStationImpl;
import fironlineser.model.impl.PoliceStationModelImpl;

import fironlineser.service.persistence.PoliceStationPersistence;
import fironlineser.service.persistence.PoliceStationUtil;
import fironlineser.service.persistence.impl.constants.FIRFOOPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the police station service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PoliceStationPersistence.class)
public class PoliceStationPersistenceImpl
	extends BasePersistenceImpl<PoliceStation>
	implements PoliceStationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PoliceStationUtil</code> to access the police station persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PoliceStationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the police stations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching police stations
	 */
	@Override
	public List<PoliceStation> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PoliceStation> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<PoliceStation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<PoliceStation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<PoliceStation> list = null;

		if (useFinderCache) {
			list = (List<PoliceStation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PoliceStation policeStation : list) {
					if (!uuid.equals(policeStation.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_POLICESTATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PoliceStationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<PoliceStation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first police station in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	@Override
	public PoliceStation findByUuid_First(
			String uuid, OrderByComparator<PoliceStation> orderByComparator)
		throws NoSuchPoliceStationException {

		PoliceStation policeStation = fetchByUuid_First(
			uuid, orderByComparator);

		if (policeStation != null) {
			return policeStation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPoliceStationException(sb.toString());
	}

	/**
	 * Returns the first police station in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station, or <code>null</code> if a matching police station could not be found
	 */
	@Override
	public PoliceStation fetchByUuid_First(
		String uuid, OrderByComparator<PoliceStation> orderByComparator) {

		List<PoliceStation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last police station in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	@Override
	public PoliceStation findByUuid_Last(
			String uuid, OrderByComparator<PoliceStation> orderByComparator)
		throws NoSuchPoliceStationException {

		PoliceStation policeStation = fetchByUuid_Last(uuid, orderByComparator);

		if (policeStation != null) {
			return policeStation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPoliceStationException(sb.toString());
	}

	/**
	 * Returns the last police station in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station, or <code>null</code> if a matching police station could not be found
	 */
	@Override
	public PoliceStation fetchByUuid_Last(
		String uuid, OrderByComparator<PoliceStation> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PoliceStation> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PoliceStation[] findByUuid_PrevAndNext(
			long stationId, String uuid,
			OrderByComparator<PoliceStation> orderByComparator)
		throws NoSuchPoliceStationException {

		uuid = Objects.toString(uuid, "");

		PoliceStation policeStation = findByPrimaryKey(stationId);

		Session session = null;

		try {
			session = openSession();

			PoliceStation[] array = new PoliceStationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, policeStation, uuid, orderByComparator, true);

			array[1] = policeStation;

			array[2] = getByUuid_PrevAndNext(
				session, policeStation, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PoliceStation getByUuid_PrevAndNext(
		Session session, PoliceStation policeStation, String uuid,
		OrderByComparator<PoliceStation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_POLICESTATION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PoliceStationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						policeStation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PoliceStation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the police stations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PoliceStation policeStation :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policeStation);
		}
	}

	/**
	 * Returns the number of police stations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching police stations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICESTATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"policeStation.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(policeStation.uuid IS NULL OR policeStation.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByJurisdiction;
	private FinderPath _finderPathWithoutPaginationFindByJurisdiction;
	private FinderPath _finderPathCountByJurisdiction;

	/**
	 * Returns all the police stations where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @return the matching police stations
	 */
	@Override
	public List<PoliceStation> findByJurisdiction(String jurisdictionArea) {
		return findByJurisdiction(
			jurisdictionArea, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PoliceStation> findByJurisdiction(
		String jurisdictionArea, int start, int end) {

		return findByJurisdiction(jurisdictionArea, start, end, null);
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
	@Override
	public List<PoliceStation> findByJurisdiction(
		String jurisdictionArea, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator) {

		return findByJurisdiction(
			jurisdictionArea, start, end, orderByComparator, true);
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
	@Override
	public List<PoliceStation> findByJurisdiction(
		String jurisdictionArea, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator,
		boolean useFinderCache) {

		jurisdictionArea = Objects.toString(jurisdictionArea, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByJurisdiction;
				finderArgs = new Object[] {jurisdictionArea};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByJurisdiction;
			finderArgs = new Object[] {
				jurisdictionArea, start, end, orderByComparator
			};
		}

		List<PoliceStation> list = null;

		if (useFinderCache) {
			list = (List<PoliceStation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PoliceStation policeStation : list) {
					if (!jurisdictionArea.equals(
							policeStation.getJurisdictionArea())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_POLICESTATION_WHERE);

			boolean bindJurisdictionArea = false;

			if (jurisdictionArea.isEmpty()) {
				sb.append(_FINDER_COLUMN_JURISDICTION_JURISDICTIONAREA_3);
			}
			else {
				bindJurisdictionArea = true;

				sb.append(_FINDER_COLUMN_JURISDICTION_JURISDICTIONAREA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PoliceStationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindJurisdictionArea) {
					queryPos.add(jurisdictionArea);
				}

				list = (List<PoliceStation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	@Override
	public PoliceStation findByJurisdiction_First(
			String jurisdictionArea,
			OrderByComparator<PoliceStation> orderByComparator)
		throws NoSuchPoliceStationException {

		PoliceStation policeStation = fetchByJurisdiction_First(
			jurisdictionArea, orderByComparator);

		if (policeStation != null) {
			return policeStation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("jurisdictionArea=");
		sb.append(jurisdictionArea);

		sb.append("}");

		throw new NoSuchPoliceStationException(sb.toString());
	}

	/**
	 * Returns the first police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station, or <code>null</code> if a matching police station could not be found
	 */
	@Override
	public PoliceStation fetchByJurisdiction_First(
		String jurisdictionArea,
		OrderByComparator<PoliceStation> orderByComparator) {

		List<PoliceStation> list = findByJurisdiction(
			jurisdictionArea, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	@Override
	public PoliceStation findByJurisdiction_Last(
			String jurisdictionArea,
			OrderByComparator<PoliceStation> orderByComparator)
		throws NoSuchPoliceStationException {

		PoliceStation policeStation = fetchByJurisdiction_Last(
			jurisdictionArea, orderByComparator);

		if (policeStation != null) {
			return policeStation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("jurisdictionArea=");
		sb.append(jurisdictionArea);

		sb.append("}");

		throw new NoSuchPoliceStationException(sb.toString());
	}

	/**
	 * Returns the last police station in the ordered set where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station, or <code>null</code> if a matching police station could not be found
	 */
	@Override
	public PoliceStation fetchByJurisdiction_Last(
		String jurisdictionArea,
		OrderByComparator<PoliceStation> orderByComparator) {

		int count = countByJurisdiction(jurisdictionArea);

		if (count == 0) {
			return null;
		}

		List<PoliceStation> list = findByJurisdiction(
			jurisdictionArea, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PoliceStation[] findByJurisdiction_PrevAndNext(
			long stationId, String jurisdictionArea,
			OrderByComparator<PoliceStation> orderByComparator)
		throws NoSuchPoliceStationException {

		jurisdictionArea = Objects.toString(jurisdictionArea, "");

		PoliceStation policeStation = findByPrimaryKey(stationId);

		Session session = null;

		try {
			session = openSession();

			PoliceStation[] array = new PoliceStationImpl[3];

			array[0] = getByJurisdiction_PrevAndNext(
				session, policeStation, jurisdictionArea, orderByComparator,
				true);

			array[1] = policeStation;

			array[2] = getByJurisdiction_PrevAndNext(
				session, policeStation, jurisdictionArea, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PoliceStation getByJurisdiction_PrevAndNext(
		Session session, PoliceStation policeStation, String jurisdictionArea,
		OrderByComparator<PoliceStation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_POLICESTATION_WHERE);

		boolean bindJurisdictionArea = false;

		if (jurisdictionArea.isEmpty()) {
			sb.append(_FINDER_COLUMN_JURISDICTION_JURISDICTIONAREA_3);
		}
		else {
			bindJurisdictionArea = true;

			sb.append(_FINDER_COLUMN_JURISDICTION_JURISDICTIONAREA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PoliceStationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindJurisdictionArea) {
			queryPos.add(jurisdictionArea);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						policeStation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PoliceStation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the police stations where jurisdictionArea = &#63; from the database.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 */
	@Override
	public void removeByJurisdiction(String jurisdictionArea) {
		for (PoliceStation policeStation :
				findByJurisdiction(
					jurisdictionArea, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(policeStation);
		}
	}

	/**
	 * Returns the number of police stations where jurisdictionArea = &#63;.
	 *
	 * @param jurisdictionArea the jurisdiction area
	 * @return the number of matching police stations
	 */
	@Override
	public int countByJurisdiction(String jurisdictionArea) {
		jurisdictionArea = Objects.toString(jurisdictionArea, "");

		FinderPath finderPath = _finderPathCountByJurisdiction;

		Object[] finderArgs = new Object[] {jurisdictionArea};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICESTATION_WHERE);

			boolean bindJurisdictionArea = false;

			if (jurisdictionArea.isEmpty()) {
				sb.append(_FINDER_COLUMN_JURISDICTION_JURISDICTIONAREA_3);
			}
			else {
				bindJurisdictionArea = true;

				sb.append(_FINDER_COLUMN_JURISDICTION_JURISDICTIONAREA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindJurisdictionArea) {
					queryPos.add(jurisdictionArea);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_JURISDICTION_JURISDICTIONAREA_2 =
		"policeStation.jurisdictionArea = ?";

	private static final String _FINDER_COLUMN_JURISDICTION_JURISDICTIONAREA_3 =
		"(policeStation.jurisdictionArea IS NULL OR policeStation.jurisdictionArea = '')";

	private FinderPath _finderPathWithPaginationFindByStationName;
	private FinderPath _finderPathWithoutPaginationFindByStationName;
	private FinderPath _finderPathCountByStationName;

	/**
	 * Returns all the police stations where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @return the matching police stations
	 */
	@Override
	public List<PoliceStation> findByStationName(String stationName) {
		return findByStationName(
			stationName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PoliceStation> findByStationName(
		String stationName, int start, int end) {

		return findByStationName(stationName, start, end, null);
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
	@Override
	public List<PoliceStation> findByStationName(
		String stationName, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator) {

		return findByStationName(
			stationName, start, end, orderByComparator, true);
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
	@Override
	public List<PoliceStation> findByStationName(
		String stationName, int start, int end,
		OrderByComparator<PoliceStation> orderByComparator,
		boolean useFinderCache) {

		stationName = Objects.toString(stationName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStationName;
				finderArgs = new Object[] {stationName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStationName;
			finderArgs = new Object[] {
				stationName, start, end, orderByComparator
			};
		}

		List<PoliceStation> list = null;

		if (useFinderCache) {
			list = (List<PoliceStation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PoliceStation policeStation : list) {
					if (!stationName.equals(policeStation.getStationName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_POLICESTATION_WHERE);

			boolean bindStationName = false;

			if (stationName.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATIONNAME_STATIONNAME_3);
			}
			else {
				bindStationName = true;

				sb.append(_FINDER_COLUMN_STATIONNAME_STATIONNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PoliceStationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStationName) {
					queryPos.add(stationName);
				}

				list = (List<PoliceStation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	@Override
	public PoliceStation findByStationName_First(
			String stationName,
			OrderByComparator<PoliceStation> orderByComparator)
		throws NoSuchPoliceStationException {

		PoliceStation policeStation = fetchByStationName_First(
			stationName, orderByComparator);

		if (policeStation != null) {
			return policeStation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stationName=");
		sb.append(stationName);

		sb.append("}");

		throw new NoSuchPoliceStationException(sb.toString());
	}

	/**
	 * Returns the first police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching police station, or <code>null</code> if a matching police station could not be found
	 */
	@Override
	public PoliceStation fetchByStationName_First(
		String stationName,
		OrderByComparator<PoliceStation> orderByComparator) {

		List<PoliceStation> list = findByStationName(
			stationName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station
	 * @throws NoSuchPoliceStationException if a matching police station could not be found
	 */
	@Override
	public PoliceStation findByStationName_Last(
			String stationName,
			OrderByComparator<PoliceStation> orderByComparator)
		throws NoSuchPoliceStationException {

		PoliceStation policeStation = fetchByStationName_Last(
			stationName, orderByComparator);

		if (policeStation != null) {
			return policeStation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stationName=");
		sb.append(stationName);

		sb.append("}");

		throw new NoSuchPoliceStationException(sb.toString());
	}

	/**
	 * Returns the last police station in the ordered set where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching police station, or <code>null</code> if a matching police station could not be found
	 */
	@Override
	public PoliceStation fetchByStationName_Last(
		String stationName,
		OrderByComparator<PoliceStation> orderByComparator) {

		int count = countByStationName(stationName);

		if (count == 0) {
			return null;
		}

		List<PoliceStation> list = findByStationName(
			stationName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PoliceStation[] findByStationName_PrevAndNext(
			long stationId, String stationName,
			OrderByComparator<PoliceStation> orderByComparator)
		throws NoSuchPoliceStationException {

		stationName = Objects.toString(stationName, "");

		PoliceStation policeStation = findByPrimaryKey(stationId);

		Session session = null;

		try {
			session = openSession();

			PoliceStation[] array = new PoliceStationImpl[3];

			array[0] = getByStationName_PrevAndNext(
				session, policeStation, stationName, orderByComparator, true);

			array[1] = policeStation;

			array[2] = getByStationName_PrevAndNext(
				session, policeStation, stationName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PoliceStation getByStationName_PrevAndNext(
		Session session, PoliceStation policeStation, String stationName,
		OrderByComparator<PoliceStation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_POLICESTATION_WHERE);

		boolean bindStationName = false;

		if (stationName.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATIONNAME_STATIONNAME_3);
		}
		else {
			bindStationName = true;

			sb.append(_FINDER_COLUMN_STATIONNAME_STATIONNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PoliceStationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStationName) {
			queryPos.add(stationName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						policeStation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PoliceStation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the police stations where stationName = &#63; from the database.
	 *
	 * @param stationName the station name
	 */
	@Override
	public void removeByStationName(String stationName) {
		for (PoliceStation policeStation :
				findByStationName(
					stationName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policeStation);
		}
	}

	/**
	 * Returns the number of police stations where stationName = &#63;.
	 *
	 * @param stationName the station name
	 * @return the number of matching police stations
	 */
	@Override
	public int countByStationName(String stationName) {
		stationName = Objects.toString(stationName, "");

		FinderPath finderPath = _finderPathCountByStationName;

		Object[] finderArgs = new Object[] {stationName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICESTATION_WHERE);

			boolean bindStationName = false;

			if (stationName.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATIONNAME_STATIONNAME_3);
			}
			else {
				bindStationName = true;

				sb.append(_FINDER_COLUMN_STATIONNAME_STATIONNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStationName) {
					queryPos.add(stationName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATIONNAME_STATIONNAME_2 =
		"policeStation.stationName = ?";

	private static final String _FINDER_COLUMN_STATIONNAME_STATIONNAME_3 =
		"(policeStation.stationName IS NULL OR policeStation.stationName = '')";

	public PoliceStationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PoliceStation.class);

		setModelImplClass(PoliceStationImpl.class);
		setModelPKClass(long.class);

		setTable(PoliceStationTable.INSTANCE);
	}

	/**
	 * Caches the police station in the entity cache if it is enabled.
	 *
	 * @param policeStation the police station
	 */
	@Override
	public void cacheResult(PoliceStation policeStation) {
		entityCache.putResult(
			PoliceStationImpl.class, policeStation.getPrimaryKey(),
			policeStation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the police stations in the entity cache if it is enabled.
	 *
	 * @param policeStations the police stations
	 */
	@Override
	public void cacheResult(List<PoliceStation> policeStations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (policeStations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PoliceStation policeStation : policeStations) {
			if (entityCache.getResult(
					PoliceStationImpl.class, policeStation.getPrimaryKey()) ==
						null) {

				cacheResult(policeStation);
			}
		}
	}

	/**
	 * Clears the cache for all police stations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PoliceStationImpl.class);

		finderCache.clearCache(PoliceStationImpl.class);
	}

	/**
	 * Clears the cache for the police station.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PoliceStation policeStation) {
		entityCache.removeResult(PoliceStationImpl.class, policeStation);
	}

	@Override
	public void clearCache(List<PoliceStation> policeStations) {
		for (PoliceStation policeStation : policeStations) {
			entityCache.removeResult(PoliceStationImpl.class, policeStation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PoliceStationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PoliceStationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new police station with the primary key. Does not add the police station to the database.
	 *
	 * @param stationId the primary key for the new police station
	 * @return the new police station
	 */
	@Override
	public PoliceStation create(long stationId) {
		PoliceStation policeStation = new PoliceStationImpl();

		policeStation.setNew(true);
		policeStation.setPrimaryKey(stationId);

		String uuid = PortalUUIDUtil.generate();

		policeStation.setUuid(uuid);

		return policeStation;
	}

	/**
	 * Removes the police station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stationId the primary key of the police station
	 * @return the police station that was removed
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	@Override
	public PoliceStation remove(long stationId)
		throws NoSuchPoliceStationException {

		return remove((Serializable)stationId);
	}

	/**
	 * Removes the police station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the police station
	 * @return the police station that was removed
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	@Override
	public PoliceStation remove(Serializable primaryKey)
		throws NoSuchPoliceStationException {

		Session session = null;

		try {
			session = openSession();

			PoliceStation policeStation = (PoliceStation)session.get(
				PoliceStationImpl.class, primaryKey);

			if (policeStation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPoliceStationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policeStation);
		}
		catch (NoSuchPoliceStationException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PoliceStation removeImpl(PoliceStation policeStation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policeStation)) {
				policeStation = (PoliceStation)session.get(
					PoliceStationImpl.class, policeStation.getPrimaryKeyObj());
			}

			if (policeStation != null) {
				session.delete(policeStation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policeStation != null) {
			clearCache(policeStation);
		}

		return policeStation;
	}

	@Override
	public PoliceStation updateImpl(PoliceStation policeStation) {
		boolean isNew = policeStation.isNew();

		if (!(policeStation instanceof PoliceStationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(policeStation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					policeStation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in policeStation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PoliceStation implementation " +
					policeStation.getClass());
		}

		PoliceStationModelImpl policeStationModelImpl =
			(PoliceStationModelImpl)policeStation;

		if (Validator.isNull(policeStation.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			policeStation.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (policeStation.getCreateDate() == null)) {
			if (serviceContext == null) {
				policeStation.setCreateDate(date);
			}
			else {
				policeStation.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!policeStationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				policeStation.setModifiedDate(date);
			}
			else {
				policeStation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policeStation);
			}
			else {
				policeStation = (PoliceStation)session.merge(policeStation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PoliceStationImpl.class, policeStationModelImpl, false, true);

		if (isNew) {
			policeStation.setNew(false);
		}

		policeStation.resetOriginalValues();

		return policeStation;
	}

	/**
	 * Returns the police station with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the police station
	 * @return the police station
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	@Override
	public PoliceStation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPoliceStationException {

		PoliceStation policeStation = fetchByPrimaryKey(primaryKey);

		if (policeStation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPoliceStationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policeStation;
	}

	/**
	 * Returns the police station with the primary key or throws a <code>NoSuchPoliceStationException</code> if it could not be found.
	 *
	 * @param stationId the primary key of the police station
	 * @return the police station
	 * @throws NoSuchPoliceStationException if a police station with the primary key could not be found
	 */
	@Override
	public PoliceStation findByPrimaryKey(long stationId)
		throws NoSuchPoliceStationException {

		return findByPrimaryKey((Serializable)stationId);
	}

	/**
	 * Returns the police station with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stationId the primary key of the police station
	 * @return the police station, or <code>null</code> if a police station with the primary key could not be found
	 */
	@Override
	public PoliceStation fetchByPrimaryKey(long stationId) {
		return fetchByPrimaryKey((Serializable)stationId);
	}

	/**
	 * Returns all the police stations.
	 *
	 * @return the police stations
	 */
	@Override
	public List<PoliceStation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PoliceStation> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PoliceStation> findAll(
		int start, int end,
		OrderByComparator<PoliceStation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PoliceStation> findAll(
		int start, int end, OrderByComparator<PoliceStation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PoliceStation> list = null;

		if (useFinderCache) {
			list = (List<PoliceStation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICESTATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICESTATION;

				sql = sql.concat(PoliceStationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PoliceStation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the police stations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PoliceStation policeStation : findAll()) {
			remove(policeStation);
		}
	}

	/**
	 * Returns the number of police stations.
	 *
	 * @return the number of police stations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POLICESTATION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "stationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POLICESTATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PoliceStationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the police station persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByJurisdiction = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJurisdiction",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"jurisdictionArea"}, true);

		_finderPathWithoutPaginationFindByJurisdiction = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJurisdiction",
			new String[] {String.class.getName()},
			new String[] {"jurisdictionArea"}, true);

		_finderPathCountByJurisdiction = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJurisdiction",
			new String[] {String.class.getName()},
			new String[] {"jurisdictionArea"}, false);

		_finderPathWithPaginationFindByStationName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStationName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"stationName"}, true);

		_finderPathWithoutPaginationFindByStationName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStationName",
			new String[] {String.class.getName()}, new String[] {"stationName"},
			true);

		_finderPathCountByStationName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStationName",
			new String[] {String.class.getName()}, new String[] {"stationName"},
			false);

		PoliceStationUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PoliceStationUtil.setPersistence(null);

		entityCache.removeCache(PoliceStationImpl.class.getName());
	}

	@Override
	@Reference(
		target = FIRFOOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FIRFOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FIRFOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_POLICESTATION =
		"SELECT policeStation FROM PoliceStation policeStation";

	private static final String _SQL_SELECT_POLICESTATION_WHERE =
		"SELECT policeStation FROM PoliceStation policeStation WHERE ";

	private static final String _SQL_COUNT_POLICESTATION =
		"SELECT COUNT(policeStation) FROM PoliceStation policeStation";

	private static final String _SQL_COUNT_POLICESTATION_WHERE =
		"SELECT COUNT(policeStation) FROM PoliceStation policeStation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "policeStation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PoliceStation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PoliceStation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PoliceStationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}