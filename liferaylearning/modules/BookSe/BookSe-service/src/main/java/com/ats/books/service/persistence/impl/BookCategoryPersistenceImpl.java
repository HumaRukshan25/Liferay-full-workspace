/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.service.persistence.impl;

import com.ats.books.exception.NoSuchBookCategoryException;
import com.ats.books.model.BookCategory;
import com.ats.books.model.BookCategoryTable;
import com.ats.books.model.impl.BookCategoryImpl;
import com.ats.books.model.impl.BookCategoryModelImpl;
import com.ats.books.service.persistence.BookCategoryPersistence;
import com.ats.books.service.persistence.BookCategoryUtil;
import com.ats.books.service.persistence.impl.constants.BOOKKKPersistenceConstants;

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
 * The persistence implementation for the book category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BookCategoryPersistence.class)
public class BookCategoryPersistenceImpl
	extends BasePersistenceImpl<BookCategory>
	implements BookCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BookCategoryUtil</code> to access the book category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BookCategoryImpl.class.getName();

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
	 * Returns all the book categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching book categories
	 */
	@Override
	public List<BookCategory> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the book categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @return the range of matching book categories
	 */
	@Override
	public List<BookCategory> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the book categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book categories
	 */
	@Override
	public List<BookCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BookCategory> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the book categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book categories
	 */
	@Override
	public List<BookCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BookCategory> orderByComparator,
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

		List<BookCategory> list = null;

		if (useFinderCache) {
			list = (List<BookCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BookCategory bookCategory : list) {
					if (!uuid.equals(bookCategory.getUuid())) {
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

			sb.append(_SQL_SELECT_BOOKCATEGORY_WHERE);

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
				sb.append(BookCategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<BookCategory>)QueryUtil.list(
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
	 * Returns the first book category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	@Override
	public BookCategory findByUuid_First(
			String uuid, OrderByComparator<BookCategory> orderByComparator)
		throws NoSuchBookCategoryException {

		BookCategory bookCategory = fetchByUuid_First(uuid, orderByComparator);

		if (bookCategory != null) {
			return bookCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBookCategoryException(sb.toString());
	}

	/**
	 * Returns the first book category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category, or <code>null</code> if a matching book category could not be found
	 */
	@Override
	public BookCategory fetchByUuid_First(
		String uuid, OrderByComparator<BookCategory> orderByComparator) {

		List<BookCategory> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	@Override
	public BookCategory findByUuid_Last(
			String uuid, OrderByComparator<BookCategory> orderByComparator)
		throws NoSuchBookCategoryException {

		BookCategory bookCategory = fetchByUuid_Last(uuid, orderByComparator);

		if (bookCategory != null) {
			return bookCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBookCategoryException(sb.toString());
	}

	/**
	 * Returns the last book category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category, or <code>null</code> if a matching book category could not be found
	 */
	@Override
	public BookCategory fetchByUuid_Last(
		String uuid, OrderByComparator<BookCategory> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BookCategory> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the book categories before and after the current book category in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current book category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book category
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	@Override
	public BookCategory[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			OrderByComparator<BookCategory> orderByComparator)
		throws NoSuchBookCategoryException {

		uuid = Objects.toString(uuid, "");

		BookCategory bookCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			BookCategory[] array = new BookCategoryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bookCategory, uuid, orderByComparator, true);

			array[1] = bookCategory;

			array[2] = getByUuid_PrevAndNext(
				session, bookCategory, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookCategory getByUuid_PrevAndNext(
		Session session, BookCategory bookCategory, String uuid,
		OrderByComparator<BookCategory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOKCATEGORY_WHERE);

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
			sb.append(BookCategoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(bookCategory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BookCategory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the book categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BookCategory bookCategory :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bookCategory);
		}
	}

	/**
	 * Returns the number of book categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching book categories
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOKCATEGORY_WHERE);

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
		"bookCategory.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bookCategory.uuid IS NULL OR bookCategory.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the book category where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBookCategoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	@Override
	public BookCategory findByUUID_G(String uuid, long groupId)
		throws NoSuchBookCategoryException {

		BookCategory bookCategory = fetchByUUID_G(uuid, groupId);

		if (bookCategory == null) {
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

			throw new NoSuchBookCategoryException(sb.toString());
		}

		return bookCategory;
	}

	/**
	 * Returns the book category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book category, or <code>null</code> if a matching book category could not be found
	 */
	@Override
	public BookCategory fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the book category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching book category, or <code>null</code> if a matching book category could not be found
	 */
	@Override
	public BookCategory fetchByUUID_G(
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

		if (result instanceof BookCategory) {
			BookCategory bookCategory = (BookCategory)result;

			if (!Objects.equals(uuid, bookCategory.getUuid()) ||
				(groupId != bookCategory.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BOOKCATEGORY_WHERE);

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

				List<BookCategory> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					BookCategory bookCategory = list.get(0);

					result = bookCategory;

					cacheResult(bookCategory);
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
			return (BookCategory)result;
		}
	}

	/**
	 * Removes the book category where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the book category that was removed
	 */
	@Override
	public BookCategory removeByUUID_G(String uuid, long groupId)
		throws NoSuchBookCategoryException {

		BookCategory bookCategory = findByUUID_G(uuid, groupId);

		return remove(bookCategory);
	}

	/**
	 * Returns the number of book categories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching book categories
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BOOKCATEGORY_WHERE);

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
		"bookCategory.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(bookCategory.uuid IS NULL OR bookCategory.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"bookCategory.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the book categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching book categories
	 */
	@Override
	public List<BookCategory> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the book categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @return the range of matching book categories
	 */
	@Override
	public List<BookCategory> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the book categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book categories
	 */
	@Override
	public List<BookCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookCategory> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the book categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book categories
	 */
	@Override
	public List<BookCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookCategory> orderByComparator,
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

		List<BookCategory> list = null;

		if (useFinderCache) {
			list = (List<BookCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BookCategory bookCategory : list) {
					if (!uuid.equals(bookCategory.getUuid()) ||
						(companyId != bookCategory.getCompanyId())) {

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

			sb.append(_SQL_SELECT_BOOKCATEGORY_WHERE);

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
				sb.append(BookCategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<BookCategory>)QueryUtil.list(
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
	 * Returns the first book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	@Override
	public BookCategory findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BookCategory> orderByComparator)
		throws NoSuchBookCategoryException {

		BookCategory bookCategory = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (bookCategory != null) {
			return bookCategory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBookCategoryException(sb.toString());
	}

	/**
	 * Returns the first book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category, or <code>null</code> if a matching book category could not be found
	 */
	@Override
	public BookCategory fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BookCategory> orderByComparator) {

		List<BookCategory> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	@Override
	public BookCategory findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BookCategory> orderByComparator)
		throws NoSuchBookCategoryException {

		BookCategory bookCategory = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (bookCategory != null) {
			return bookCategory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBookCategoryException(sb.toString());
	}

	/**
	 * Returns the last book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category, or <code>null</code> if a matching book category could not be found
	 */
	@Override
	public BookCategory fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BookCategory> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<BookCategory> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the book categories before and after the current book category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current book category
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book category
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	@Override
	public BookCategory[] findByUuid_C_PrevAndNext(
			long categoryId, String uuid, long companyId,
			OrderByComparator<BookCategory> orderByComparator)
		throws NoSuchBookCategoryException {

		uuid = Objects.toString(uuid, "");

		BookCategory bookCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			BookCategory[] array = new BookCategoryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, bookCategory, uuid, companyId, orderByComparator,
				true);

			array[1] = bookCategory;

			array[2] = getByUuid_C_PrevAndNext(
				session, bookCategory, uuid, companyId, orderByComparator,
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

	protected BookCategory getByUuid_C_PrevAndNext(
		Session session, BookCategory bookCategory, String uuid, long companyId,
		OrderByComparator<BookCategory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_BOOKCATEGORY_WHERE);

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
			sb.append(BookCategoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(bookCategory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BookCategory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the book categories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (BookCategory bookCategory :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(bookCategory);
		}
	}

	/**
	 * Returns the number of book categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching book categories
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BOOKCATEGORY_WHERE);

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
		"bookCategory.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(bookCategory.uuid IS NULL OR bookCategory.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"bookCategory.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByByCategoryName;
	private FinderPath _finderPathWithoutPaginationFindByByCategoryName;
	private FinderPath _finderPathCountByByCategoryName;

	/**
	 * Returns all the book categories where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the matching book categories
	 */
	@Override
	public List<BookCategory> findByByCategoryName(String categoryName) {
		return findByByCategoryName(
			categoryName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the book categories where categoryName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @return the range of matching book categories
	 */
	@Override
	public List<BookCategory> findByByCategoryName(
		String categoryName, int start, int end) {

		return findByByCategoryName(categoryName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the book categories where categoryName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book categories
	 */
	@Override
	public List<BookCategory> findByByCategoryName(
		String categoryName, int start, int end,
		OrderByComparator<BookCategory> orderByComparator) {

		return findByByCategoryName(
			categoryName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the book categories where categoryName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book categories
	 */
	@Override
	public List<BookCategory> findByByCategoryName(
		String categoryName, int start, int end,
		OrderByComparator<BookCategory> orderByComparator,
		boolean useFinderCache) {

		categoryName = Objects.toString(categoryName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByByCategoryName;
				finderArgs = new Object[] {categoryName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByByCategoryName;
			finderArgs = new Object[] {
				categoryName, start, end, orderByComparator
			};
		}

		List<BookCategory> list = null;

		if (useFinderCache) {
			list = (List<BookCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BookCategory bookCategory : list) {
					if (!categoryName.equals(bookCategory.getCategoryName())) {
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

			sb.append(_SQL_SELECT_BOOKCATEGORY_WHERE);

			boolean bindCategoryName = false;

			if (categoryName.isEmpty()) {
				sb.append(_FINDER_COLUMN_BYCATEGORYNAME_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				sb.append(_FINDER_COLUMN_BYCATEGORYNAME_CATEGORYNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BookCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategoryName) {
					queryPos.add(categoryName);
				}

				list = (List<BookCategory>)QueryUtil.list(
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
	 * Returns the first book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	@Override
	public BookCategory findByByCategoryName_First(
			String categoryName,
			OrderByComparator<BookCategory> orderByComparator)
		throws NoSuchBookCategoryException {

		BookCategory bookCategory = fetchByByCategoryName_First(
			categoryName, orderByComparator);

		if (bookCategory != null) {
			return bookCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("categoryName=");
		sb.append(categoryName);

		sb.append("}");

		throw new NoSuchBookCategoryException(sb.toString());
	}

	/**
	 * Returns the first book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book category, or <code>null</code> if a matching book category could not be found
	 */
	@Override
	public BookCategory fetchByByCategoryName_First(
		String categoryName,
		OrderByComparator<BookCategory> orderByComparator) {

		List<BookCategory> list = findByByCategoryName(
			categoryName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category
	 * @throws NoSuchBookCategoryException if a matching book category could not be found
	 */
	@Override
	public BookCategory findByByCategoryName_Last(
			String categoryName,
			OrderByComparator<BookCategory> orderByComparator)
		throws NoSuchBookCategoryException {

		BookCategory bookCategory = fetchByByCategoryName_Last(
			categoryName, orderByComparator);

		if (bookCategory != null) {
			return bookCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("categoryName=");
		sb.append(categoryName);

		sb.append("}");

		throw new NoSuchBookCategoryException(sb.toString());
	}

	/**
	 * Returns the last book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book category, or <code>null</code> if a matching book category could not be found
	 */
	@Override
	public BookCategory fetchByByCategoryName_Last(
		String categoryName,
		OrderByComparator<BookCategory> orderByComparator) {

		int count = countByByCategoryName(categoryName);

		if (count == 0) {
			return null;
		}

		List<BookCategory> list = findByByCategoryName(
			categoryName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the book categories before and after the current book category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryId the primary key of the current book category
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book category
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	@Override
	public BookCategory[] findByByCategoryName_PrevAndNext(
			long categoryId, String categoryName,
			OrderByComparator<BookCategory> orderByComparator)
		throws NoSuchBookCategoryException {

		categoryName = Objects.toString(categoryName, "");

		BookCategory bookCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			BookCategory[] array = new BookCategoryImpl[3];

			array[0] = getByByCategoryName_PrevAndNext(
				session, bookCategory, categoryName, orderByComparator, true);

			array[1] = bookCategory;

			array[2] = getByByCategoryName_PrevAndNext(
				session, bookCategory, categoryName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookCategory getByByCategoryName_PrevAndNext(
		Session session, BookCategory bookCategory, String categoryName,
		OrderByComparator<BookCategory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOKCATEGORY_WHERE);

		boolean bindCategoryName = false;

		if (categoryName.isEmpty()) {
			sb.append(_FINDER_COLUMN_BYCATEGORYNAME_CATEGORYNAME_3);
		}
		else {
			bindCategoryName = true;

			sb.append(_FINDER_COLUMN_BYCATEGORYNAME_CATEGORYNAME_2);
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
			sb.append(BookCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCategoryName) {
			queryPos.add(categoryName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(bookCategory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BookCategory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the book categories where categoryName = &#63; from the database.
	 *
	 * @param categoryName the category name
	 */
	@Override
	public void removeByByCategoryName(String categoryName) {
		for (BookCategory bookCategory :
				findByByCategoryName(
					categoryName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bookCategory);
		}
	}

	/**
	 * Returns the number of book categories where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the number of matching book categories
	 */
	@Override
	public int countByByCategoryName(String categoryName) {
		categoryName = Objects.toString(categoryName, "");

		FinderPath finderPath = _finderPathCountByByCategoryName;

		Object[] finderArgs = new Object[] {categoryName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOKCATEGORY_WHERE);

			boolean bindCategoryName = false;

			if (categoryName.isEmpty()) {
				sb.append(_FINDER_COLUMN_BYCATEGORYNAME_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				sb.append(_FINDER_COLUMN_BYCATEGORYNAME_CATEGORYNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategoryName) {
					queryPos.add(categoryName);
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

	private static final String _FINDER_COLUMN_BYCATEGORYNAME_CATEGORYNAME_2 =
		"bookCategory.categoryName = ?";

	private static final String _FINDER_COLUMN_BYCATEGORYNAME_CATEGORYNAME_3 =
		"(bookCategory.categoryName IS NULL OR bookCategory.categoryName = '')";

	public BookCategoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BookCategory.class);

		setModelImplClass(BookCategoryImpl.class);
		setModelPKClass(long.class);

		setTable(BookCategoryTable.INSTANCE);
	}

	/**
	 * Caches the book category in the entity cache if it is enabled.
	 *
	 * @param bookCategory the book category
	 */
	@Override
	public void cacheResult(BookCategory bookCategory) {
		entityCache.putResult(
			BookCategoryImpl.class, bookCategory.getPrimaryKey(), bookCategory);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {bookCategory.getUuid(), bookCategory.getGroupId()},
			bookCategory);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the book categories in the entity cache if it is enabled.
	 *
	 * @param bookCategories the book categories
	 */
	@Override
	public void cacheResult(List<BookCategory> bookCategories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bookCategories.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BookCategory bookCategory : bookCategories) {
			if (entityCache.getResult(
					BookCategoryImpl.class, bookCategory.getPrimaryKey()) ==
						null) {

				cacheResult(bookCategory);
			}
		}
	}

	/**
	 * Clears the cache for all book categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BookCategoryImpl.class);

		finderCache.clearCache(BookCategoryImpl.class);
	}

	/**
	 * Clears the cache for the book category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BookCategory bookCategory) {
		entityCache.removeResult(BookCategoryImpl.class, bookCategory);
	}

	@Override
	public void clearCache(List<BookCategory> bookCategories) {
		for (BookCategory bookCategory : bookCategories) {
			entityCache.removeResult(BookCategoryImpl.class, bookCategory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BookCategoryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BookCategoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BookCategoryModelImpl bookCategoryModelImpl) {

		Object[] args = new Object[] {
			bookCategoryModelImpl.getUuid(), bookCategoryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, bookCategoryModelImpl);
	}

	/**
	 * Creates a new book category with the primary key. Does not add the book category to the database.
	 *
	 * @param categoryId the primary key for the new book category
	 * @return the new book category
	 */
	@Override
	public BookCategory create(long categoryId) {
		BookCategory bookCategory = new BookCategoryImpl();

		bookCategory.setNew(true);
		bookCategory.setPrimaryKey(categoryId);

		String uuid = PortalUUIDUtil.generate();

		bookCategory.setUuid(uuid);

		bookCategory.setCompanyId(CompanyThreadLocal.getCompanyId());

		return bookCategory;
	}

	/**
	 * Removes the book category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the book category
	 * @return the book category that was removed
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	@Override
	public BookCategory remove(long categoryId)
		throws NoSuchBookCategoryException {

		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the book category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the book category
	 * @return the book category that was removed
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	@Override
	public BookCategory remove(Serializable primaryKey)
		throws NoSuchBookCategoryException {

		Session session = null;

		try {
			session = openSession();

			BookCategory bookCategory = (BookCategory)session.get(
				BookCategoryImpl.class, primaryKey);

			if (bookCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bookCategory);
		}
		catch (NoSuchBookCategoryException noSuchEntityException) {
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
	protected BookCategory removeImpl(BookCategory bookCategory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bookCategory)) {
				bookCategory = (BookCategory)session.get(
					BookCategoryImpl.class, bookCategory.getPrimaryKeyObj());
			}

			if (bookCategory != null) {
				session.delete(bookCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bookCategory != null) {
			clearCache(bookCategory);
		}

		return bookCategory;
	}

	@Override
	public BookCategory updateImpl(BookCategory bookCategory) {
		boolean isNew = bookCategory.isNew();

		if (!(bookCategory instanceof BookCategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bookCategory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					bookCategory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bookCategory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BookCategory implementation " +
					bookCategory.getClass());
		}

		BookCategoryModelImpl bookCategoryModelImpl =
			(BookCategoryModelImpl)bookCategory;

		if (Validator.isNull(bookCategory.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bookCategory.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (bookCategory.getCreateDate() == null)) {
			if (serviceContext == null) {
				bookCategory.setCreateDate(date);
			}
			else {
				bookCategory.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!bookCategoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				bookCategory.setModifiedDate(date);
			}
			else {
				bookCategory.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bookCategory);
			}
			else {
				bookCategory = (BookCategory)session.merge(bookCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BookCategoryImpl.class, bookCategoryModelImpl, false, true);

		cacheUniqueFindersCache(bookCategoryModelImpl);

		if (isNew) {
			bookCategory.setNew(false);
		}

		bookCategory.resetOriginalValues();

		return bookCategory;
	}

	/**
	 * Returns the book category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the book category
	 * @return the book category
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	@Override
	public BookCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBookCategoryException {

		BookCategory bookCategory = fetchByPrimaryKey(primaryKey);

		if (bookCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBookCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bookCategory;
	}

	/**
	 * Returns the book category with the primary key or throws a <code>NoSuchBookCategoryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the book category
	 * @return the book category
	 * @throws NoSuchBookCategoryException if a book category with the primary key could not be found
	 */
	@Override
	public BookCategory findByPrimaryKey(long categoryId)
		throws NoSuchBookCategoryException {

		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the book category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the book category
	 * @return the book category, or <code>null</code> if a book category with the primary key could not be found
	 */
	@Override
	public BookCategory fetchByPrimaryKey(long categoryId) {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns all the book categories.
	 *
	 * @return the book categories
	 */
	@Override
	public List<BookCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the book categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @return the range of book categories
	 */
	@Override
	public List<BookCategory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the book categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of book categories
	 */
	@Override
	public List<BookCategory> findAll(
		int start, int end, OrderByComparator<BookCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the book categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book categories
	 * @param end the upper bound of the range of book categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of book categories
	 */
	@Override
	public List<BookCategory> findAll(
		int start, int end, OrderByComparator<BookCategory> orderByComparator,
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

		List<BookCategory> list = null;

		if (useFinderCache) {
			list = (List<BookCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOOKCATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKCATEGORY;

				sql = sql.concat(BookCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BookCategory>)QueryUtil.list(
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
	 * Removes all the book categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BookCategory bookCategory : findAll()) {
			remove(bookCategory);
		}
	}

	/**
	 * Returns the number of book categories.
	 *
	 * @return the number of book categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOOKCATEGORY);

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
		return "categoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BOOKCATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BookCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the book category persistence.
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

		_finderPathWithPaginationFindByByCategoryName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByCategoryName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"categoryName"}, true);

		_finderPathWithoutPaginationFindByByCategoryName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByCategoryName",
			new String[] {String.class.getName()},
			new String[] {"categoryName"}, true);

		_finderPathCountByByCategoryName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByCategoryName",
			new String[] {String.class.getName()},
			new String[] {"categoryName"}, false);

		BookCategoryUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BookCategoryUtil.setPersistence(null);

		entityCache.removeCache(BookCategoryImpl.class.getName());
	}

	@Override
	@Reference(
		target = BOOKKKPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BOOKKKPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BOOKKKPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BOOKCATEGORY =
		"SELECT bookCategory FROM BookCategory bookCategory";

	private static final String _SQL_SELECT_BOOKCATEGORY_WHERE =
		"SELECT bookCategory FROM BookCategory bookCategory WHERE ";

	private static final String _SQL_COUNT_BOOKCATEGORY =
		"SELECT COUNT(bookCategory) FROM BookCategory bookCategory";

	private static final String _SQL_COUNT_BOOKCATEGORY_WHERE =
		"SELECT COUNT(bookCategory) FROM BookCategory bookCategory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bookCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BookCategory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BookCategory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BookCategoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}