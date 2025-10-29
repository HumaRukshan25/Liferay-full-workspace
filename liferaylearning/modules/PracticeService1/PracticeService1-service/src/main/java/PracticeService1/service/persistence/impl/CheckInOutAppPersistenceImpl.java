/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.service.persistence.impl;

import PracticeService1.exception.NoSuchCheckInOutAppException;

import PracticeService1.model.CheckInOutApp;
import PracticeService1.model.CheckInOutAppTable;
import PracticeService1.model.impl.CheckInOutAppImpl;
import PracticeService1.model.impl.CheckInOutAppModelImpl;

import PracticeService1.service.persistence.CheckInOutAppPersistence;
import PracticeService1.service.persistence.CheckInOutAppUtil;
import PracticeService1.service.persistence.impl.constants.ATSPersistenceConstants;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
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
 * The persistence implementation for the check in out app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CheckInOutAppPersistence.class)
public class CheckInOutAppPersistenceImpl
	extends BasePersistenceImpl<CheckInOutApp>
	implements CheckInOutAppPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CheckInOutAppUtil</code> to access the check in out app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CheckInOutAppImpl.class.getName();

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
	 * Returns all the check in out apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching check in out apps
	 */
	@Override
	public List<CheckInOutApp> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CheckInOutApp> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CheckInOutApp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CheckInOutApp> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CheckInOutApp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CheckInOutApp> orderByComparator,
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

		List<CheckInOutApp> list = null;

		if (useFinderCache) {
			list = (List<CheckInOutApp>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CheckInOutApp checkInOutApp : list) {
					if (!uuid.equals(checkInOutApp.getUuid())) {
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

			sb.append(_SQL_SELECT_CHECKINOUTAPP_WHERE);

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
				sb.append(CheckInOutAppModelImpl.ORDER_BY_JPQL);
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

				list = (List<CheckInOutApp>)QueryUtil.list(
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
	 * Returns the first check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	@Override
	public CheckInOutApp findByUuid_First(
			String uuid, OrderByComparator<CheckInOutApp> orderByComparator)
		throws NoSuchCheckInOutAppException {

		CheckInOutApp checkInOutApp = fetchByUuid_First(
			uuid, orderByComparator);

		if (checkInOutApp != null) {
			return checkInOutApp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCheckInOutAppException(sb.toString());
	}

	/**
	 * Returns the first check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	@Override
	public CheckInOutApp fetchByUuid_First(
		String uuid, OrderByComparator<CheckInOutApp> orderByComparator) {

		List<CheckInOutApp> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	@Override
	public CheckInOutApp findByUuid_Last(
			String uuid, OrderByComparator<CheckInOutApp> orderByComparator)
		throws NoSuchCheckInOutAppException {

		CheckInOutApp checkInOutApp = fetchByUuid_Last(uuid, orderByComparator);

		if (checkInOutApp != null) {
			return checkInOutApp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCheckInOutAppException(sb.toString());
	}

	/**
	 * Returns the last check in out app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	@Override
	public CheckInOutApp fetchByUuid_Last(
		String uuid, OrderByComparator<CheckInOutApp> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CheckInOutApp> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CheckInOutApp[] findByUuid_PrevAndNext(
			long logId, String uuid,
			OrderByComparator<CheckInOutApp> orderByComparator)
		throws NoSuchCheckInOutAppException {

		uuid = Objects.toString(uuid, "");

		CheckInOutApp checkInOutApp = findByPrimaryKey(logId);

		Session session = null;

		try {
			session = openSession();

			CheckInOutApp[] array = new CheckInOutAppImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, checkInOutApp, uuid, orderByComparator, true);

			array[1] = checkInOutApp;

			array[2] = getByUuid_PrevAndNext(
				session, checkInOutApp, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CheckInOutApp getByUuid_PrevAndNext(
		Session session, CheckInOutApp checkInOutApp, String uuid,
		OrderByComparator<CheckInOutApp> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHECKINOUTAPP_WHERE);

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
			sb.append(CheckInOutAppModelImpl.ORDER_BY_JPQL);
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
						checkInOutApp)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CheckInOutApp> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the check in out apps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CheckInOutApp checkInOutApp :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(checkInOutApp);
		}
	}

	/**
	 * Returns the number of check in out apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching check in out apps
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHECKINOUTAPP_WHERE);

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
		"checkInOutApp.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(checkInOutApp.uuid IS NULL OR checkInOutApp.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the check in out app where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCheckInOutAppException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	@Override
	public CheckInOutApp findByUUID_G(String uuid, long groupId)
		throws NoSuchCheckInOutAppException {

		CheckInOutApp checkInOutApp = fetchByUUID_G(uuid, groupId);

		if (checkInOutApp == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCheckInOutAppException(sb.toString());
		}

		return checkInOutApp;
	}

	/**
	 * Returns the check in out app where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	@Override
	public CheckInOutApp fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the check in out app where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	@Override
	public CheckInOutApp fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof CheckInOutApp) {
			CheckInOutApp checkInOutApp = (CheckInOutApp)result;

			if (!Objects.equals(uuid, checkInOutApp.getUuid()) ||
				(groupId != checkInOutApp.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CHECKINOUTAPP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<CheckInOutApp> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CheckInOutApp checkInOutApp = list.get(0);

					result = checkInOutApp;

					cacheResult(checkInOutApp);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CheckInOutApp)result;
		}
	}

	/**
	 * Removes the check in out app where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the check in out app that was removed
	 */
	@Override
	public CheckInOutApp removeByUUID_G(String uuid, long groupId)
		throws NoSuchCheckInOutAppException {

		CheckInOutApp checkInOutApp = findByUUID_G(uuid, groupId);

		return remove(checkInOutApp);
	}

	/**
	 * Returns the number of check in out apps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching check in out apps
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CHECKINOUTAPP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"checkInOutApp.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(checkInOutApp.uuid IS NULL OR checkInOutApp.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"checkInOutApp.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the check in out apps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching check in out apps
	 */
	@Override
	public List<CheckInOutApp> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CheckInOutApp> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<CheckInOutApp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CheckInOutApp> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<CheckInOutApp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CheckInOutApp> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<CheckInOutApp> list = null;

		if (useFinderCache) {
			list = (List<CheckInOutApp>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CheckInOutApp checkInOutApp : list) {
					if (!uuid.equals(checkInOutApp.getUuid()) ||
						(companyId != checkInOutApp.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CHECKINOUTAPP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CheckInOutAppModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<CheckInOutApp>)QueryUtil.list(
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
	 * Returns the first check in out app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check in out app
	 * @throws NoSuchCheckInOutAppException if a matching check in out app could not be found
	 */
	@Override
	public CheckInOutApp findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CheckInOutApp> orderByComparator)
		throws NoSuchCheckInOutAppException {

		CheckInOutApp checkInOutApp = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (checkInOutApp != null) {
			return checkInOutApp;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCheckInOutAppException(sb.toString());
	}

	/**
	 * Returns the first check in out app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	@Override
	public CheckInOutApp fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CheckInOutApp> orderByComparator) {

		List<CheckInOutApp> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CheckInOutApp findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CheckInOutApp> orderByComparator)
		throws NoSuchCheckInOutAppException {

		CheckInOutApp checkInOutApp = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (checkInOutApp != null) {
			return checkInOutApp;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCheckInOutAppException(sb.toString());
	}

	/**
	 * Returns the last check in out app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check in out app, or <code>null</code> if a matching check in out app could not be found
	 */
	@Override
	public CheckInOutApp fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CheckInOutApp> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CheckInOutApp> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CheckInOutApp[] findByUuid_C_PrevAndNext(
			long logId, String uuid, long companyId,
			OrderByComparator<CheckInOutApp> orderByComparator)
		throws NoSuchCheckInOutAppException {

		uuid = Objects.toString(uuid, "");

		CheckInOutApp checkInOutApp = findByPrimaryKey(logId);

		Session session = null;

		try {
			session = openSession();

			CheckInOutApp[] array = new CheckInOutAppImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, checkInOutApp, uuid, companyId, orderByComparator,
				true);

			array[1] = checkInOutApp;

			array[2] = getByUuid_C_PrevAndNext(
				session, checkInOutApp, uuid, companyId, orderByComparator,
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

	protected CheckInOutApp getByUuid_C_PrevAndNext(
		Session session, CheckInOutApp checkInOutApp, String uuid,
		long companyId, OrderByComparator<CheckInOutApp> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CHECKINOUTAPP_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(CheckInOutAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						checkInOutApp)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CheckInOutApp> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the check in out apps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CheckInOutApp checkInOutApp :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(checkInOutApp);
		}
	}

	/**
	 * Returns the number of check in out apps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching check in out apps
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CHECKINOUTAPP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"checkInOutApp.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(checkInOutApp.uuid IS NULL OR checkInOutApp.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"checkInOutApp.companyId = ?";

	public CheckInOutAppPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CheckInOutApp.class);

		setModelImplClass(CheckInOutAppImpl.class);
		setModelPKClass(long.class);

		setTable(CheckInOutAppTable.INSTANCE);
	}

	/**
	 * Caches the check in out app in the entity cache if it is enabled.
	 *
	 * @param checkInOutApp the check in out app
	 */
	@Override
	public void cacheResult(CheckInOutApp checkInOutApp) {
		entityCache.putResult(
			CheckInOutAppImpl.class, checkInOutApp.getPrimaryKey(),
			checkInOutApp);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {checkInOutApp.getUuid(), checkInOutApp.getGroupId()},
			checkInOutApp);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the check in out apps in the entity cache if it is enabled.
	 *
	 * @param checkInOutApps the check in out apps
	 */
	@Override
	public void cacheResult(List<CheckInOutApp> checkInOutApps) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (checkInOutApps.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CheckInOutApp checkInOutApp : checkInOutApps) {
			if (entityCache.getResult(
					CheckInOutAppImpl.class, checkInOutApp.getPrimaryKey()) ==
						null) {

				cacheResult(checkInOutApp);
			}
		}
	}

	/**
	 * Clears the cache for all check in out apps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CheckInOutAppImpl.class);

		finderCache.clearCache(CheckInOutAppImpl.class);
	}

	/**
	 * Clears the cache for the check in out app.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CheckInOutApp checkInOutApp) {
		entityCache.removeResult(CheckInOutAppImpl.class, checkInOutApp);
	}

	@Override
	public void clearCache(List<CheckInOutApp> checkInOutApps) {
		for (CheckInOutApp checkInOutApp : checkInOutApps) {
			entityCache.removeResult(CheckInOutAppImpl.class, checkInOutApp);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CheckInOutAppImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CheckInOutAppImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CheckInOutAppModelImpl checkInOutAppModelImpl) {

		Object[] args = new Object[] {
			checkInOutAppModelImpl.getUuid(),
			checkInOutAppModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, checkInOutAppModelImpl);
	}

	/**
	 * Creates a new check in out app with the primary key. Does not add the check in out app to the database.
	 *
	 * @param logId the primary key for the new check in out app
	 * @return the new check in out app
	 */
	@Override
	public CheckInOutApp create(long logId) {
		CheckInOutApp checkInOutApp = new CheckInOutAppImpl();

		checkInOutApp.setNew(true);
		checkInOutApp.setPrimaryKey(logId);

		String uuid = PortalUUIDUtil.generate();

		checkInOutApp.setUuid(uuid);

		checkInOutApp.setCompanyId(CompanyThreadLocal.getCompanyId());

		return checkInOutApp;
	}

	/**
	 * Removes the check in out app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the check in out app
	 * @return the check in out app that was removed
	 * @throws NoSuchCheckInOutAppException if a check in out app with the primary key could not be found
	 */
	@Override
	public CheckInOutApp remove(long logId)
		throws NoSuchCheckInOutAppException {

		return remove((Serializable)logId);
	}

	/**
	 * Removes the check in out app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the check in out app
	 * @return the check in out app that was removed
	 * @throws NoSuchCheckInOutAppException if a check in out app with the primary key could not be found
	 */
	@Override
	public CheckInOutApp remove(Serializable primaryKey)
		throws NoSuchCheckInOutAppException {

		Session session = null;

		try {
			session = openSession();

			CheckInOutApp checkInOutApp = (CheckInOutApp)session.get(
				CheckInOutAppImpl.class, primaryKey);

			if (checkInOutApp == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCheckInOutAppException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(checkInOutApp);
		}
		catch (NoSuchCheckInOutAppException noSuchEntityException) {
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
	protected CheckInOutApp removeImpl(CheckInOutApp checkInOutApp) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(checkInOutApp)) {
				checkInOutApp = (CheckInOutApp)session.get(
					CheckInOutAppImpl.class, checkInOutApp.getPrimaryKeyObj());
			}

			if (checkInOutApp != null) {
				session.delete(checkInOutApp);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (checkInOutApp != null) {
			clearCache(checkInOutApp);
		}

		return checkInOutApp;
	}

	@Override
	public CheckInOutApp updateImpl(CheckInOutApp checkInOutApp) {
		boolean isNew = checkInOutApp.isNew();

		if (!(checkInOutApp instanceof CheckInOutAppModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(checkInOutApp.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					checkInOutApp);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in checkInOutApp proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CheckInOutApp implementation " +
					checkInOutApp.getClass());
		}

		CheckInOutAppModelImpl checkInOutAppModelImpl =
			(CheckInOutAppModelImpl)checkInOutApp;

		if (Validator.isNull(checkInOutApp.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			checkInOutApp.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (checkInOutApp.getCreateDate() == null)) {
			if (serviceContext == null) {
				checkInOutApp.setCreateDate(date);
			}
			else {
				checkInOutApp.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!checkInOutAppModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				checkInOutApp.setModifiedDate(date);
			}
			else {
				checkInOutApp.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(checkInOutApp);
			}
			else {
				checkInOutApp = (CheckInOutApp)session.merge(checkInOutApp);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CheckInOutAppImpl.class, checkInOutAppModelImpl, false, true);

		cacheUniqueFindersCache(checkInOutAppModelImpl);

		if (isNew) {
			checkInOutApp.setNew(false);
		}

		checkInOutApp.resetOriginalValues();

		return checkInOutApp;
	}

	/**
	 * Returns the check in out app with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the check in out app
	 * @return the check in out app
	 * @throws NoSuchCheckInOutAppException if a check in out app with the primary key could not be found
	 */
	@Override
	public CheckInOutApp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCheckInOutAppException {

		CheckInOutApp checkInOutApp = fetchByPrimaryKey(primaryKey);

		if (checkInOutApp == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCheckInOutAppException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return checkInOutApp;
	}

	/**
	 * Returns the check in out app with the primary key or throws a <code>NoSuchCheckInOutAppException</code> if it could not be found.
	 *
	 * @param logId the primary key of the check in out app
	 * @return the check in out app
	 * @throws NoSuchCheckInOutAppException if a check in out app with the primary key could not be found
	 */
	@Override
	public CheckInOutApp findByPrimaryKey(long logId)
		throws NoSuchCheckInOutAppException {

		return findByPrimaryKey((Serializable)logId);
	}

	/**
	 * Returns the check in out app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the check in out app
	 * @return the check in out app, or <code>null</code> if a check in out app with the primary key could not be found
	 */
	@Override
	public CheckInOutApp fetchByPrimaryKey(long logId) {
		return fetchByPrimaryKey((Serializable)logId);
	}

	/**
	 * Returns all the check in out apps.
	 *
	 * @return the check in out apps
	 */
	@Override
	public List<CheckInOutApp> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CheckInOutApp> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CheckInOutApp> findAll(
		int start, int end,
		OrderByComparator<CheckInOutApp> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CheckInOutApp> findAll(
		int start, int end, OrderByComparator<CheckInOutApp> orderByComparator,
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

		List<CheckInOutApp> list = null;

		if (useFinderCache) {
			list = (List<CheckInOutApp>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHECKINOUTAPP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHECKINOUTAPP;

				sql = sql.concat(CheckInOutAppModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CheckInOutApp>)QueryUtil.list(
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
	 * Removes all the check in out apps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CheckInOutApp checkInOutApp : findAll()) {
			remove(checkInOutApp);
		}
	}

	/**
	 * Returns the number of check in out apps.
	 *
	 * @return the number of check in out apps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHECKINOUTAPP);

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
		return "logId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CHECKINOUTAPP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CheckInOutAppModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the check in out app persistence.
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

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		CheckInOutAppUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CheckInOutAppUtil.setPersistence(null);

		entityCache.removeCache(CheckInOutAppImpl.class.getName());
	}

	@Override
	@Reference(
		target = ATSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ATSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ATSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CHECKINOUTAPP =
		"SELECT checkInOutApp FROM CheckInOutApp checkInOutApp";

	private static final String _SQL_SELECT_CHECKINOUTAPP_WHERE =
		"SELECT checkInOutApp FROM CheckInOutApp checkInOutApp WHERE ";

	private static final String _SQL_COUNT_CHECKINOUTAPP =
		"SELECT COUNT(checkInOutApp) FROM CheckInOutApp checkInOutApp";

	private static final String _SQL_COUNT_CHECKINOUTAPP_WHERE =
		"SELECT COUNT(checkInOutApp) FROM CheckInOutApp checkInOutApp WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "checkInOutApp.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CheckInOutApp exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CheckInOutApp exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CheckInOutAppPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}