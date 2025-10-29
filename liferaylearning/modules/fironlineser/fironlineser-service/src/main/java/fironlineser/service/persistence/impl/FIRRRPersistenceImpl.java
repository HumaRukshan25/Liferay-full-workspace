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

import fironlineser.exception.NoSuchFIRRRException;

import fironlineser.model.FIRRR;
import fironlineser.model.FIRRRTable;
import fironlineser.model.impl.FIRRRImpl;
import fironlineser.model.impl.FIRRRModelImpl;

import fironlineser.service.persistence.FIRRRPersistence;
import fironlineser.service.persistence.FIRRRUtil;
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
 * The persistence implementation for the firrr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FIRRRPersistence.class)
public class FIRRRPersistenceImpl
	extends BasePersistenceImpl<FIRRR> implements FIRRRPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FIRRRUtil</code> to access the firrr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FIRRRImpl.class.getName();

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
	 * Returns all the firrrs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching firrrs
	 */
	@Override
	public List<FIRRR> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FIRRR> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<FIRRR> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FIRRR> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<FIRRR> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FIRRR> orderByComparator, boolean useFinderCache) {

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

		List<FIRRR> list = null;

		if (useFinderCache) {
			list = (List<FIRRR>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FIRRR firrr : list) {
					if (!uuid.equals(firrr.getUuid())) {
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

			sb.append(_SQL_SELECT_FIRRR_WHERE);

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
				sb.append(FIRRRModelImpl.ORDER_BY_JPQL);
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

				list = (List<FIRRR>)QueryUtil.list(
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
	 * Returns the first firrr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firrr
	 * @throws NoSuchFIRRRException if a matching firrr could not be found
	 */
	@Override
	public FIRRR findByUuid_First(
			String uuid, OrderByComparator<FIRRR> orderByComparator)
		throws NoSuchFIRRRException {

		FIRRR firrr = fetchByUuid_First(uuid, orderByComparator);

		if (firrr != null) {
			return firrr;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFIRRRException(sb.toString());
	}

	/**
	 * Returns the first firrr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firrr, or <code>null</code> if a matching firrr could not be found
	 */
	@Override
	public FIRRR fetchByUuid_First(
		String uuid, OrderByComparator<FIRRR> orderByComparator) {

		List<FIRRR> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last firrr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firrr
	 * @throws NoSuchFIRRRException if a matching firrr could not be found
	 */
	@Override
	public FIRRR findByUuid_Last(
			String uuid, OrderByComparator<FIRRR> orderByComparator)
		throws NoSuchFIRRRException {

		FIRRR firrr = fetchByUuid_Last(uuid, orderByComparator);

		if (firrr != null) {
			return firrr;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFIRRRException(sb.toString());
	}

	/**
	 * Returns the last firrr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firrr, or <code>null</code> if a matching firrr could not be found
	 */
	@Override
	public FIRRR fetchByUuid_Last(
		String uuid, OrderByComparator<FIRRR> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FIRRR> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FIRRR[] findByUuid_PrevAndNext(
			long firId, String uuid, OrderByComparator<FIRRR> orderByComparator)
		throws NoSuchFIRRRException {

		uuid = Objects.toString(uuid, "");

		FIRRR firrr = findByPrimaryKey(firId);

		Session session = null;

		try {
			session = openSession();

			FIRRR[] array = new FIRRRImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, firrr, uuid, orderByComparator, true);

			array[1] = firrr;

			array[2] = getByUuid_PrevAndNext(
				session, firrr, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FIRRR getByUuid_PrevAndNext(
		Session session, FIRRR firrr, String uuid,
		OrderByComparator<FIRRR> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FIRRR_WHERE);

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
			sb.append(FIRRRModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(firrr)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FIRRR> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the firrrs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FIRRR firrr :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(firrr);
		}
	}

	/**
	 * Returns the number of firrrs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching firrrs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FIRRR_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "firrr.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(firrr.uuid IS NULL OR firrr.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the firrrs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching firrrs
	 */
	@Override
	public List<FIRRR> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FIRRR> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<FIRRR> findByUserId(
		long userId, int start, int end,
		OrderByComparator<FIRRR> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<FIRRR> findByUserId(
		long userId, int start, int end,
		OrderByComparator<FIRRR> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<FIRRR> list = null;

		if (useFinderCache) {
			list = (List<FIRRR>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FIRRR firrr : list) {
					if (userId != firrr.getUserId()) {
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

			sb.append(_SQL_SELECT_FIRRR_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FIRRRModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<FIRRR>)QueryUtil.list(
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
	 * Returns the first firrr in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firrr
	 * @throws NoSuchFIRRRException if a matching firrr could not be found
	 */
	@Override
	public FIRRR findByUserId_First(
			long userId, OrderByComparator<FIRRR> orderByComparator)
		throws NoSuchFIRRRException {

		FIRRR firrr = fetchByUserId_First(userId, orderByComparator);

		if (firrr != null) {
			return firrr;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchFIRRRException(sb.toString());
	}

	/**
	 * Returns the first firrr in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firrr, or <code>null</code> if a matching firrr could not be found
	 */
	@Override
	public FIRRR fetchByUserId_First(
		long userId, OrderByComparator<FIRRR> orderByComparator) {

		List<FIRRR> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last firrr in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firrr
	 * @throws NoSuchFIRRRException if a matching firrr could not be found
	 */
	@Override
	public FIRRR findByUserId_Last(
			long userId, OrderByComparator<FIRRR> orderByComparator)
		throws NoSuchFIRRRException {

		FIRRR firrr = fetchByUserId_Last(userId, orderByComparator);

		if (firrr != null) {
			return firrr;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchFIRRRException(sb.toString());
	}

	/**
	 * Returns the last firrr in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firrr, or <code>null</code> if a matching firrr could not be found
	 */
	@Override
	public FIRRR fetchByUserId_Last(
		long userId, OrderByComparator<FIRRR> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<FIRRR> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FIRRR[] findByUserId_PrevAndNext(
			long firId, long userId, OrderByComparator<FIRRR> orderByComparator)
		throws NoSuchFIRRRException {

		FIRRR firrr = findByPrimaryKey(firId);

		Session session = null;

		try {
			session = openSession();

			FIRRR[] array = new FIRRRImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, firrr, userId, orderByComparator, true);

			array[1] = firrr;

			array[2] = getByUserId_PrevAndNext(
				session, firrr, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FIRRR getByUserId_PrevAndNext(
		Session session, FIRRR firrr, long userId,
		OrderByComparator<FIRRR> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FIRRR_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(FIRRRModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(firrr)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FIRRR> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the firrrs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (FIRRR firrr :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(firrr);
		}
	}

	/**
	 * Returns the number of firrrs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching firrrs
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FIRRR_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"firrr.userId = ?";

	public FIRRRPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FIRRR.class);

		setModelImplClass(FIRRRImpl.class);
		setModelPKClass(long.class);

		setTable(FIRRRTable.INSTANCE);
	}

	/**
	 * Caches the firrr in the entity cache if it is enabled.
	 *
	 * @param firrr the firrr
	 */
	@Override
	public void cacheResult(FIRRR firrr) {
		entityCache.putResult(FIRRRImpl.class, firrr.getPrimaryKey(), firrr);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the firrrs in the entity cache if it is enabled.
	 *
	 * @param firrrs the firrrs
	 */
	@Override
	public void cacheResult(List<FIRRR> firrrs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (firrrs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FIRRR firrr : firrrs) {
			if (entityCache.getResult(FIRRRImpl.class, firrr.getPrimaryKey()) ==
					null) {

				cacheResult(firrr);
			}
		}
	}

	/**
	 * Clears the cache for all firrrs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FIRRRImpl.class);

		finderCache.clearCache(FIRRRImpl.class);
	}

	/**
	 * Clears the cache for the firrr.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FIRRR firrr) {
		entityCache.removeResult(FIRRRImpl.class, firrr);
	}

	@Override
	public void clearCache(List<FIRRR> firrrs) {
		for (FIRRR firrr : firrrs) {
			entityCache.removeResult(FIRRRImpl.class, firrr);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FIRRRImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FIRRRImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new firrr with the primary key. Does not add the firrr to the database.
	 *
	 * @param firId the primary key for the new firrr
	 * @return the new firrr
	 */
	@Override
	public FIRRR create(long firId) {
		FIRRR firrr = new FIRRRImpl();

		firrr.setNew(true);
		firrr.setPrimaryKey(firId);

		String uuid = PortalUUIDUtil.generate();

		firrr.setUuid(uuid);

		return firrr;
	}

	/**
	 * Removes the firrr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param firId the primary key of the firrr
	 * @return the firrr that was removed
	 * @throws NoSuchFIRRRException if a firrr with the primary key could not be found
	 */
	@Override
	public FIRRR remove(long firId) throws NoSuchFIRRRException {
		return remove((Serializable)firId);
	}

	/**
	 * Removes the firrr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the firrr
	 * @return the firrr that was removed
	 * @throws NoSuchFIRRRException if a firrr with the primary key could not be found
	 */
	@Override
	public FIRRR remove(Serializable primaryKey) throws NoSuchFIRRRException {
		Session session = null;

		try {
			session = openSession();

			FIRRR firrr = (FIRRR)session.get(FIRRRImpl.class, primaryKey);

			if (firrr == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFIRRRException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(firrr);
		}
		catch (NoSuchFIRRRException noSuchEntityException) {
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
	protected FIRRR removeImpl(FIRRR firrr) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(firrr)) {
				firrr = (FIRRR)session.get(
					FIRRRImpl.class, firrr.getPrimaryKeyObj());
			}

			if (firrr != null) {
				session.delete(firrr);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (firrr != null) {
			clearCache(firrr);
		}

		return firrr;
	}

	@Override
	public FIRRR updateImpl(FIRRR firrr) {
		boolean isNew = firrr.isNew();

		if (!(firrr instanceof FIRRRModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(firrr.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(firrr);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in firrr proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FIRRR implementation " +
					firrr.getClass());
		}

		FIRRRModelImpl firrrModelImpl = (FIRRRModelImpl)firrr;

		if (Validator.isNull(firrr.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			firrr.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (firrr.getCreateDate() == null)) {
			if (serviceContext == null) {
				firrr.setCreateDate(date);
			}
			else {
				firrr.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!firrrModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				firrr.setModifiedDate(date);
			}
			else {
				firrr.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(firrr);
			}
			else {
				firrr = (FIRRR)session.merge(firrr);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(FIRRRImpl.class, firrrModelImpl, false, true);

		if (isNew) {
			firrr.setNew(false);
		}

		firrr.resetOriginalValues();

		return firrr;
	}

	/**
	 * Returns the firrr with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the firrr
	 * @return the firrr
	 * @throws NoSuchFIRRRException if a firrr with the primary key could not be found
	 */
	@Override
	public FIRRR findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFIRRRException {

		FIRRR firrr = fetchByPrimaryKey(primaryKey);

		if (firrr == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFIRRRException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return firrr;
	}

	/**
	 * Returns the firrr with the primary key or throws a <code>NoSuchFIRRRException</code> if it could not be found.
	 *
	 * @param firId the primary key of the firrr
	 * @return the firrr
	 * @throws NoSuchFIRRRException if a firrr with the primary key could not be found
	 */
	@Override
	public FIRRR findByPrimaryKey(long firId) throws NoSuchFIRRRException {
		return findByPrimaryKey((Serializable)firId);
	}

	/**
	 * Returns the firrr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param firId the primary key of the firrr
	 * @return the firrr, or <code>null</code> if a firrr with the primary key could not be found
	 */
	@Override
	public FIRRR fetchByPrimaryKey(long firId) {
		return fetchByPrimaryKey((Serializable)firId);
	}

	/**
	 * Returns all the firrrs.
	 *
	 * @return the firrrs
	 */
	@Override
	public List<FIRRR> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FIRRR> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<FIRRR> findAll(
		int start, int end, OrderByComparator<FIRRR> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<FIRRR> findAll(
		int start, int end, OrderByComparator<FIRRR> orderByComparator,
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

		List<FIRRR> list = null;

		if (useFinderCache) {
			list = (List<FIRRR>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FIRRR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FIRRR;

				sql = sql.concat(FIRRRModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FIRRR>)QueryUtil.list(
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
	 * Removes all the firrrs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FIRRR firrr : findAll()) {
			remove(firrr);
		}
	}

	/**
	 * Returns the number of firrrs.
	 *
	 * @return the number of firrrs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FIRRR);

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
		return "firId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FIRRR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FIRRRModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the firrr persistence.
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

		_finderPathWithPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		FIRRRUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		FIRRRUtil.setPersistence(null);

		entityCache.removeCache(FIRRRImpl.class.getName());
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

	private static final String _SQL_SELECT_FIRRR =
		"SELECT firrr FROM FIRRR firrr";

	private static final String _SQL_SELECT_FIRRR_WHERE =
		"SELECT firrr FROM FIRRR firrr WHERE ";

	private static final String _SQL_COUNT_FIRRR =
		"SELECT COUNT(firrr) FROM FIRRR firrr";

	private static final String _SQL_COUNT_FIRRR_WHERE =
		"SELECT COUNT(firrr) FROM FIRRR firrr WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "firrr.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FIRRR exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FIRRR exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FIRRRPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}