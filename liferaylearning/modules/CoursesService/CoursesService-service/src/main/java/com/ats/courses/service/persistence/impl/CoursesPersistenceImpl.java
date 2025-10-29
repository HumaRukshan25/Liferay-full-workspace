/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.service.persistence.impl;

import com.ats.courses.exception.NoSuchCoursesException;
import com.ats.courses.model.Courses;
import com.ats.courses.model.CoursesTable;
import com.ats.courses.model.impl.CoursesImpl;
import com.ats.courses.model.impl.CoursesModelImpl;
import com.ats.courses.service.persistence.CoursesPersistence;
import com.ats.courses.service.persistence.CoursesUtil;
import com.ats.courses.service.persistence.impl.constants.ATSPersistenceConstants;

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
 * The persistence implementation for the courses service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CoursesPersistence.class)
public class CoursesPersistenceImpl
	extends BasePersistenceImpl<Courses> implements CoursesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CoursesUtil</code> to access the courses persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CoursesImpl.class.getName();

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
	 * Returns all the courseses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching courseses
	 */
	@Override
	public List<Courses> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the courseses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @return the range of matching courseses
	 */
	@Override
	public List<Courses> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the courseses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching courseses
	 */
	@Override
	public List<Courses> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Courses> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the courseses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching courseses
	 */
	@Override
	public List<Courses> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Courses> orderByComparator, boolean useFinderCache) {

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

		List<Courses> list = null;

		if (useFinderCache) {
			list = (List<Courses>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Courses courses : list) {
					if (!uuid.equals(courses.getUuid())) {
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

			sb.append(_SQL_SELECT_COURSES_WHERE);

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
				sb.append(CoursesModelImpl.ORDER_BY_JPQL);
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

				list = (List<Courses>)QueryUtil.list(
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
	 * Returns the first courses in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	@Override
	public Courses findByUuid_First(
			String uuid, OrderByComparator<Courses> orderByComparator)
		throws NoSuchCoursesException {

		Courses courses = fetchByUuid_First(uuid, orderByComparator);

		if (courses != null) {
			return courses;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCoursesException(sb.toString());
	}

	/**
	 * Returns the first courses in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 */
	@Override
	public Courses fetchByUuid_First(
		String uuid, OrderByComparator<Courses> orderByComparator) {

		List<Courses> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last courses in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	@Override
	public Courses findByUuid_Last(
			String uuid, OrderByComparator<Courses> orderByComparator)
		throws NoSuchCoursesException {

		Courses courses = fetchByUuid_Last(uuid, orderByComparator);

		if (courses != null) {
			return courses;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCoursesException(sb.toString());
	}

	/**
	 * Returns the last courses in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 */
	@Override
	public Courses fetchByUuid_Last(
		String uuid, OrderByComparator<Courses> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Courses> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the courseses before and after the current courses in the ordered set where uuid = &#63;.
	 *
	 * @param coursesId the primary key of the current courses
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next courses
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	@Override
	public Courses[] findByUuid_PrevAndNext(
			long coursesId, String uuid,
			OrderByComparator<Courses> orderByComparator)
		throws NoSuchCoursesException {

		uuid = Objects.toString(uuid, "");

		Courses courses = findByPrimaryKey(coursesId);

		Session session = null;

		try {
			session = openSession();

			Courses[] array = new CoursesImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, courses, uuid, orderByComparator, true);

			array[1] = courses;

			array[2] = getByUuid_PrevAndNext(
				session, courses, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Courses getByUuid_PrevAndNext(
		Session session, Courses courses, String uuid,
		OrderByComparator<Courses> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COURSES_WHERE);

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
			sb.append(CoursesModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(courses)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Courses> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the courseses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Courses courses :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(courses);
		}
	}

	/**
	 * Returns the number of courseses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching courseses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COURSES_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "courses.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(courses.uuid IS NULL OR courses.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the courses where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCoursesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	@Override
	public Courses findByUUID_G(String uuid, long groupId)
		throws NoSuchCoursesException {

		Courses courses = fetchByUUID_G(uuid, groupId);

		if (courses == null) {
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

			throw new NoSuchCoursesException(sb.toString());
		}

		return courses;
	}

	/**
	 * Returns the courses where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching courses, or <code>null</code> if a matching courses could not be found
	 */
	@Override
	public Courses fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the courses where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching courses, or <code>null</code> if a matching courses could not be found
	 */
	@Override
	public Courses fetchByUUID_G(
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

		if (result instanceof Courses) {
			Courses courses = (Courses)result;

			if (!Objects.equals(uuid, courses.getUuid()) ||
				(groupId != courses.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COURSES_WHERE);

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

				List<Courses> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Courses courses = list.get(0);

					result = courses;

					cacheResult(courses);
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
			return (Courses)result;
		}
	}

	/**
	 * Removes the courses where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the courses that was removed
	 */
	@Override
	public Courses removeByUUID_G(String uuid, long groupId)
		throws NoSuchCoursesException {

		Courses courses = findByUUID_G(uuid, groupId);

		return remove(courses);
	}

	/**
	 * Returns the number of courseses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching courseses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COURSES_WHERE);

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
		"courses.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(courses.uuid IS NULL OR courses.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"courses.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the courseses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching courseses
	 */
	@Override
	public List<Courses> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the courseses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @return the range of matching courseses
	 */
	@Override
	public List<Courses> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the courseses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching courseses
	 */
	@Override
	public List<Courses> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Courses> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the courseses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching courseses
	 */
	@Override
	public List<Courses> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Courses> orderByComparator, boolean useFinderCache) {

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

		List<Courses> list = null;

		if (useFinderCache) {
			list = (List<Courses>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Courses courses : list) {
					if (!uuid.equals(courses.getUuid()) ||
						(companyId != courses.getCompanyId())) {

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

			sb.append(_SQL_SELECT_COURSES_WHERE);

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
				sb.append(CoursesModelImpl.ORDER_BY_JPQL);
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

				list = (List<Courses>)QueryUtil.list(
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
	 * Returns the first courses in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	@Override
	public Courses findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Courses> orderByComparator)
		throws NoSuchCoursesException {

		Courses courses = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (courses != null) {
			return courses;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCoursesException(sb.toString());
	}

	/**
	 * Returns the first courses in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 */
	@Override
	public Courses fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Courses> orderByComparator) {

		List<Courses> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last courses in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	@Override
	public Courses findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Courses> orderByComparator)
		throws NoSuchCoursesException {

		Courses courses = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (courses != null) {
			return courses;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCoursesException(sb.toString());
	}

	/**
	 * Returns the last courses in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 */
	@Override
	public Courses fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Courses> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Courses> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the courseses before and after the current courses in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param coursesId the primary key of the current courses
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next courses
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	@Override
	public Courses[] findByUuid_C_PrevAndNext(
			long coursesId, String uuid, long companyId,
			OrderByComparator<Courses> orderByComparator)
		throws NoSuchCoursesException {

		uuid = Objects.toString(uuid, "");

		Courses courses = findByPrimaryKey(coursesId);

		Session session = null;

		try {
			session = openSession();

			Courses[] array = new CoursesImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, courses, uuid, companyId, orderByComparator, true);

			array[1] = courses;

			array[2] = getByUuid_C_PrevAndNext(
				session, courses, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Courses getByUuid_C_PrevAndNext(
		Session session, Courses courses, String uuid, long companyId,
		OrderByComparator<Courses> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COURSES_WHERE);

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
			sb.append(CoursesModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(courses)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Courses> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the courseses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Courses courses :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(courses);
		}
	}

	/**
	 * Returns the number of courseses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching courseses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COURSES_WHERE);

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
		"courses.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(courses.uuid IS NULL OR courses.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"courses.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCourses_type;
	private FinderPath _finderPathWithoutPaginationFindByCourses_type;
	private FinderPath _finderPathCountByCourses_type;

	/**
	 * Returns all the courseses where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @return the matching courseses
	 */
	@Override
	public List<Courses> findByCourses_type(String Courses_type) {
		return findByCourses_type(
			Courses_type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the courseses where Courses_type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param Courses_type the courses_type
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @return the range of matching courseses
	 */
	@Override
	public List<Courses> findByCourses_type(
		String Courses_type, int start, int end) {

		return findByCourses_type(Courses_type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the courseses where Courses_type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param Courses_type the courses_type
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching courseses
	 */
	@Override
	public List<Courses> findByCourses_type(
		String Courses_type, int start, int end,
		OrderByComparator<Courses> orderByComparator) {

		return findByCourses_type(
			Courses_type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the courseses where Courses_type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param Courses_type the courses_type
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching courseses
	 */
	@Override
	public List<Courses> findByCourses_type(
		String Courses_type, int start, int end,
		OrderByComparator<Courses> orderByComparator, boolean useFinderCache) {

		Courses_type = Objects.toString(Courses_type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCourses_type;
				finderArgs = new Object[] {Courses_type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCourses_type;
			finderArgs = new Object[] {
				Courses_type, start, end, orderByComparator
			};
		}

		List<Courses> list = null;

		if (useFinderCache) {
			list = (List<Courses>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Courses courses : list) {
					if (!Courses_type.equals(courses.getCourses_type())) {
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

			sb.append(_SQL_SELECT_COURSES_WHERE);

			boolean bindCourses_type = false;

			if (Courses_type.isEmpty()) {
				sb.append(_FINDER_COLUMN_COURSES_TYPE_COURSES_TYPE_3);
			}
			else {
				bindCourses_type = true;

				sb.append(_FINDER_COLUMN_COURSES_TYPE_COURSES_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CoursesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCourses_type) {
					queryPos.add(Courses_type);
				}

				list = (List<Courses>)QueryUtil.list(
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
	 * Returns the first courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	@Override
	public Courses findByCourses_type_First(
			String Courses_type, OrderByComparator<Courses> orderByComparator)
		throws NoSuchCoursesException {

		Courses courses = fetchByCourses_type_First(
			Courses_type, orderByComparator);

		if (courses != null) {
			return courses;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Courses_type=");
		sb.append(Courses_type);

		sb.append("}");

		throw new NoSuchCoursesException(sb.toString());
	}

	/**
	 * Returns the first courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 */
	@Override
	public Courses fetchByCourses_type_First(
		String Courses_type, OrderByComparator<Courses> orderByComparator) {

		List<Courses> list = findByCourses_type(
			Courses_type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	@Override
	public Courses findByCourses_type_Last(
			String Courses_type, OrderByComparator<Courses> orderByComparator)
		throws NoSuchCoursesException {

		Courses courses = fetchByCourses_type_Last(
			Courses_type, orderByComparator);

		if (courses != null) {
			return courses;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Courses_type=");
		sb.append(Courses_type);

		sb.append("}");

		throw new NoSuchCoursesException(sb.toString());
	}

	/**
	 * Returns the last courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 */
	@Override
	public Courses fetchByCourses_type_Last(
		String Courses_type, OrderByComparator<Courses> orderByComparator) {

		int count = countByCourses_type(Courses_type);

		if (count == 0) {
			return null;
		}

		List<Courses> list = findByCourses_type(
			Courses_type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the courseses before and after the current courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param coursesId the primary key of the current courses
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next courses
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	@Override
	public Courses[] findByCourses_type_PrevAndNext(
			long coursesId, String Courses_type,
			OrderByComparator<Courses> orderByComparator)
		throws NoSuchCoursesException {

		Courses_type = Objects.toString(Courses_type, "");

		Courses courses = findByPrimaryKey(coursesId);

		Session session = null;

		try {
			session = openSession();

			Courses[] array = new CoursesImpl[3];

			array[0] = getByCourses_type_PrevAndNext(
				session, courses, Courses_type, orderByComparator, true);

			array[1] = courses;

			array[2] = getByCourses_type_PrevAndNext(
				session, courses, Courses_type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Courses getByCourses_type_PrevAndNext(
		Session session, Courses courses, String Courses_type,
		OrderByComparator<Courses> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COURSES_WHERE);

		boolean bindCourses_type = false;

		if (Courses_type.isEmpty()) {
			sb.append(_FINDER_COLUMN_COURSES_TYPE_COURSES_TYPE_3);
		}
		else {
			bindCourses_type = true;

			sb.append(_FINDER_COLUMN_COURSES_TYPE_COURSES_TYPE_2);
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
			sb.append(CoursesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCourses_type) {
			queryPos.add(Courses_type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(courses)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Courses> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the courseses where Courses_type = &#63; from the database.
	 *
	 * @param Courses_type the courses_type
	 */
	@Override
	public void removeByCourses_type(String Courses_type) {
		for (Courses courses :
				findByCourses_type(
					Courses_type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(courses);
		}
	}

	/**
	 * Returns the number of courseses where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @return the number of matching courseses
	 */
	@Override
	public int countByCourses_type(String Courses_type) {
		Courses_type = Objects.toString(Courses_type, "");

		FinderPath finderPath = _finderPathCountByCourses_type;

		Object[] finderArgs = new Object[] {Courses_type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COURSES_WHERE);

			boolean bindCourses_type = false;

			if (Courses_type.isEmpty()) {
				sb.append(_FINDER_COLUMN_COURSES_TYPE_COURSES_TYPE_3);
			}
			else {
				bindCourses_type = true;

				sb.append(_FINDER_COLUMN_COURSES_TYPE_COURSES_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCourses_type) {
					queryPos.add(Courses_type);
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

	private static final String _FINDER_COLUMN_COURSES_TYPE_COURSES_TYPE_2 =
		"courses.Courses_type = ?";

	private static final String _FINDER_COLUMN_COURSES_TYPE_COURSES_TYPE_3 =
		"(courses.Courses_type IS NULL OR courses.Courses_type = '')";

	private FinderPath _finderPathWithPaginationFindByCourses_name;
	private FinderPath _finderPathWithoutPaginationFindByCourses_name;
	private FinderPath _finderPathCountByCourses_name;

	/**
	 * Returns all the courseses where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @return the matching courseses
	 */
	@Override
	public List<Courses> findByCourses_name(String Courses_name) {
		return findByCourses_name(
			Courses_name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the courseses where Courses_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param Courses_name the courses_name
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @return the range of matching courseses
	 */
	@Override
	public List<Courses> findByCourses_name(
		String Courses_name, int start, int end) {

		return findByCourses_name(Courses_name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the courseses where Courses_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param Courses_name the courses_name
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching courseses
	 */
	@Override
	public List<Courses> findByCourses_name(
		String Courses_name, int start, int end,
		OrderByComparator<Courses> orderByComparator) {

		return findByCourses_name(
			Courses_name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the courseses where Courses_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param Courses_name the courses_name
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching courseses
	 */
	@Override
	public List<Courses> findByCourses_name(
		String Courses_name, int start, int end,
		OrderByComparator<Courses> orderByComparator, boolean useFinderCache) {

		Courses_name = Objects.toString(Courses_name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCourses_name;
				finderArgs = new Object[] {Courses_name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCourses_name;
			finderArgs = new Object[] {
				Courses_name, start, end, orderByComparator
			};
		}

		List<Courses> list = null;

		if (useFinderCache) {
			list = (List<Courses>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Courses courses : list) {
					if (!Courses_name.equals(courses.getCourses_name())) {
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

			sb.append(_SQL_SELECT_COURSES_WHERE);

			boolean bindCourses_name = false;

			if (Courses_name.isEmpty()) {
				sb.append(_FINDER_COLUMN_COURSES_NAME_COURSES_NAME_3);
			}
			else {
				bindCourses_name = true;

				sb.append(_FINDER_COLUMN_COURSES_NAME_COURSES_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CoursesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCourses_name) {
					queryPos.add(Courses_name);
				}

				list = (List<Courses>)QueryUtil.list(
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
	 * Returns the first courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	@Override
	public Courses findByCourses_name_First(
			String Courses_name, OrderByComparator<Courses> orderByComparator)
		throws NoSuchCoursesException {

		Courses courses = fetchByCourses_name_First(
			Courses_name, orderByComparator);

		if (courses != null) {
			return courses;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Courses_name=");
		sb.append(Courses_name);

		sb.append("}");

		throw new NoSuchCoursesException(sb.toString());
	}

	/**
	 * Returns the first courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 */
	@Override
	public Courses fetchByCourses_name_First(
		String Courses_name, OrderByComparator<Courses> orderByComparator) {

		List<Courses> list = findByCourses_name(
			Courses_name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	@Override
	public Courses findByCourses_name_Last(
			String Courses_name, OrderByComparator<Courses> orderByComparator)
		throws NoSuchCoursesException {

		Courses courses = fetchByCourses_name_Last(
			Courses_name, orderByComparator);

		if (courses != null) {
			return courses;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Courses_name=");
		sb.append(Courses_name);

		sb.append("}");

		throw new NoSuchCoursesException(sb.toString());
	}

	/**
	 * Returns the last courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 */
	@Override
	public Courses fetchByCourses_name_Last(
		String Courses_name, OrderByComparator<Courses> orderByComparator) {

		int count = countByCourses_name(Courses_name);

		if (count == 0) {
			return null;
		}

		List<Courses> list = findByCourses_name(
			Courses_name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the courseses before and after the current courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param coursesId the primary key of the current courses
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next courses
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	@Override
	public Courses[] findByCourses_name_PrevAndNext(
			long coursesId, String Courses_name,
			OrderByComparator<Courses> orderByComparator)
		throws NoSuchCoursesException {

		Courses_name = Objects.toString(Courses_name, "");

		Courses courses = findByPrimaryKey(coursesId);

		Session session = null;

		try {
			session = openSession();

			Courses[] array = new CoursesImpl[3];

			array[0] = getByCourses_name_PrevAndNext(
				session, courses, Courses_name, orderByComparator, true);

			array[1] = courses;

			array[2] = getByCourses_name_PrevAndNext(
				session, courses, Courses_name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Courses getByCourses_name_PrevAndNext(
		Session session, Courses courses, String Courses_name,
		OrderByComparator<Courses> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COURSES_WHERE);

		boolean bindCourses_name = false;

		if (Courses_name.isEmpty()) {
			sb.append(_FINDER_COLUMN_COURSES_NAME_COURSES_NAME_3);
		}
		else {
			bindCourses_name = true;

			sb.append(_FINDER_COLUMN_COURSES_NAME_COURSES_NAME_2);
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
			sb.append(CoursesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCourses_name) {
			queryPos.add(Courses_name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(courses)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Courses> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the courseses where Courses_name = &#63; from the database.
	 *
	 * @param Courses_name the courses_name
	 */
	@Override
	public void removeByCourses_name(String Courses_name) {
		for (Courses courses :
				findByCourses_name(
					Courses_name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(courses);
		}
	}

	/**
	 * Returns the number of courseses where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @return the number of matching courseses
	 */
	@Override
	public int countByCourses_name(String Courses_name) {
		Courses_name = Objects.toString(Courses_name, "");

		FinderPath finderPath = _finderPathCountByCourses_name;

		Object[] finderArgs = new Object[] {Courses_name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COURSES_WHERE);

			boolean bindCourses_name = false;

			if (Courses_name.isEmpty()) {
				sb.append(_FINDER_COLUMN_COURSES_NAME_COURSES_NAME_3);
			}
			else {
				bindCourses_name = true;

				sb.append(_FINDER_COLUMN_COURSES_NAME_COURSES_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCourses_name) {
					queryPos.add(Courses_name);
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

	private static final String _FINDER_COLUMN_COURSES_NAME_COURSES_NAME_2 =
		"courses.Courses_name = ?";

	private static final String _FINDER_COLUMN_COURSES_NAME_COURSES_NAME_3 =
		"(courses.Courses_name IS NULL OR courses.Courses_name = '')";

	public CoursesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Courses.class);

		setModelImplClass(CoursesImpl.class);
		setModelPKClass(long.class);

		setTable(CoursesTable.INSTANCE);
	}

	/**
	 * Caches the courses in the entity cache if it is enabled.
	 *
	 * @param courses the courses
	 */
	@Override
	public void cacheResult(Courses courses) {
		entityCache.putResult(
			CoursesImpl.class, courses.getPrimaryKey(), courses);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {courses.getUuid(), courses.getGroupId()}, courses);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the courseses in the entity cache if it is enabled.
	 *
	 * @param courseses the courseses
	 */
	@Override
	public void cacheResult(List<Courses> courseses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (courseses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Courses courses : courseses) {
			if (entityCache.getResult(
					CoursesImpl.class, courses.getPrimaryKey()) == null) {

				cacheResult(courses);
			}
		}
	}

	/**
	 * Clears the cache for all courseses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CoursesImpl.class);

		finderCache.clearCache(CoursesImpl.class);
	}

	/**
	 * Clears the cache for the courses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Courses courses) {
		entityCache.removeResult(CoursesImpl.class, courses);
	}

	@Override
	public void clearCache(List<Courses> courseses) {
		for (Courses courses : courseses) {
			entityCache.removeResult(CoursesImpl.class, courses);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CoursesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CoursesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(CoursesModelImpl coursesModelImpl) {
		Object[] args = new Object[] {
			coursesModelImpl.getUuid(), coursesModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, coursesModelImpl);
	}

	/**
	 * Creates a new courses with the primary key. Does not add the courses to the database.
	 *
	 * @param coursesId the primary key for the new courses
	 * @return the new courses
	 */
	@Override
	public Courses create(long coursesId) {
		Courses courses = new CoursesImpl();

		courses.setNew(true);
		courses.setPrimaryKey(coursesId);

		String uuid = PortalUUIDUtil.generate();

		courses.setUuid(uuid);

		courses.setCompanyId(CompanyThreadLocal.getCompanyId());

		return courses;
	}

	/**
	 * Removes the courses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coursesId the primary key of the courses
	 * @return the courses that was removed
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	@Override
	public Courses remove(long coursesId) throws NoSuchCoursesException {
		return remove((Serializable)coursesId);
	}

	/**
	 * Removes the courses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the courses
	 * @return the courses that was removed
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	@Override
	public Courses remove(Serializable primaryKey)
		throws NoSuchCoursesException {

		Session session = null;

		try {
			session = openSession();

			Courses courses = (Courses)session.get(
				CoursesImpl.class, primaryKey);

			if (courses == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCoursesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(courses);
		}
		catch (NoSuchCoursesException noSuchEntityException) {
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
	protected Courses removeImpl(Courses courses) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courses)) {
				courses = (Courses)session.get(
					CoursesImpl.class, courses.getPrimaryKeyObj());
			}

			if (courses != null) {
				session.delete(courses);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (courses != null) {
			clearCache(courses);
		}

		return courses;
	}

	@Override
	public Courses updateImpl(Courses courses) {
		boolean isNew = courses.isNew();

		if (!(courses instanceof CoursesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(courses.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(courses);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in courses proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Courses implementation " +
					courses.getClass());
		}

		CoursesModelImpl coursesModelImpl = (CoursesModelImpl)courses;

		if (Validator.isNull(courses.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			courses.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (courses.getCreateDate() == null)) {
			if (serviceContext == null) {
				courses.setCreateDate(date);
			}
			else {
				courses.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!coursesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				courses.setModifiedDate(date);
			}
			else {
				courses.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(courses);
			}
			else {
				courses = (Courses)session.merge(courses);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(CoursesImpl.class, coursesModelImpl, false, true);

		cacheUniqueFindersCache(coursesModelImpl);

		if (isNew) {
			courses.setNew(false);
		}

		courses.resetOriginalValues();

		return courses;
	}

	/**
	 * Returns the courses with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the courses
	 * @return the courses
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	@Override
	public Courses findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCoursesException {

		Courses courses = fetchByPrimaryKey(primaryKey);

		if (courses == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCoursesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return courses;
	}

	/**
	 * Returns the courses with the primary key or throws a <code>NoSuchCoursesException</code> if it could not be found.
	 *
	 * @param coursesId the primary key of the courses
	 * @return the courses
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	@Override
	public Courses findByPrimaryKey(long coursesId)
		throws NoSuchCoursesException {

		return findByPrimaryKey((Serializable)coursesId);
	}

	/**
	 * Returns the courses with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coursesId the primary key of the courses
	 * @return the courses, or <code>null</code> if a courses with the primary key could not be found
	 */
	@Override
	public Courses fetchByPrimaryKey(long coursesId) {
		return fetchByPrimaryKey((Serializable)coursesId);
	}

	/**
	 * Returns all the courseses.
	 *
	 * @return the courseses
	 */
	@Override
	public List<Courses> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the courseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @return the range of courseses
	 */
	@Override
	public List<Courses> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the courseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of courseses
	 */
	@Override
	public List<Courses> findAll(
		int start, int end, OrderByComparator<Courses> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the courseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of courseses
	 */
	@Override
	public List<Courses> findAll(
		int start, int end, OrderByComparator<Courses> orderByComparator,
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

		List<Courses> list = null;

		if (useFinderCache) {
			list = (List<Courses>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COURSES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COURSES;

				sql = sql.concat(CoursesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Courses>)QueryUtil.list(
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
	 * Removes all the courseses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Courses courses : findAll()) {
			remove(courses);
		}
	}

	/**
	 * Returns the number of courseses.
	 *
	 * @return the number of courseses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COURSES);

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
		return "coursesId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COURSES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CoursesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the courses persistence.
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

		_finderPathWithPaginationFindByCourses_type = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourses_type",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"Courses_type"}, true);

		_finderPathWithoutPaginationFindByCourses_type = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourses_type",
			new String[] {String.class.getName()},
			new String[] {"Courses_type"}, true);

		_finderPathCountByCourses_type = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourses_type",
			new String[] {String.class.getName()},
			new String[] {"Courses_type"}, false);

		_finderPathWithPaginationFindByCourses_name = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourses_name",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"Courses_name"}, true);

		_finderPathWithoutPaginationFindByCourses_name = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourses_name",
			new String[] {String.class.getName()},
			new String[] {"Courses_name"}, true);

		_finderPathCountByCourses_name = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourses_name",
			new String[] {String.class.getName()},
			new String[] {"Courses_name"}, false);

		CoursesUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CoursesUtil.setPersistence(null);

		entityCache.removeCache(CoursesImpl.class.getName());
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

	private static final String _SQL_SELECT_COURSES =
		"SELECT courses FROM Courses courses";

	private static final String _SQL_SELECT_COURSES_WHERE =
		"SELECT courses FROM Courses courses WHERE ";

	private static final String _SQL_COUNT_COURSES =
		"SELECT COUNT(courses) FROM Courses courses";

	private static final String _SQL_COUNT_COURSES_WHERE =
		"SELECT COUNT(courses) FROM Courses courses WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "courses.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Courses exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Courses exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CoursesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}