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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import fironlineser.exception.NoSuchSignupUserException;

import fironlineser.model.SignupUser;
import fironlineser.model.SignupUserTable;
import fironlineser.model.impl.SignupUserImpl;
import fironlineser.model.impl.SignupUserModelImpl;

import fironlineser.service.persistence.SignupUserPersistence;
import fironlineser.service.persistence.SignupUserUtil;
import fironlineser.service.persistence.impl.constants.FIRFOOPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the signup user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SignupUserPersistence.class)
public class SignupUserPersistenceImpl
	extends BasePersistenceImpl<SignupUser> implements SignupUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SignupUserUtil</code> to access the signup user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SignupUserImpl.class.getName();

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
	 * Returns all the signup users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching signup users
	 */
	@Override
	public List<SignupUser> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the signup users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @return the range of matching signup users
	 */
	@Override
	public List<SignupUser> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the signup users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signup users
	 */
	@Override
	public List<SignupUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SignupUser> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the signup users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signup users
	 */
	@Override
	public List<SignupUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SignupUser> orderByComparator,
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

		List<SignupUser> list = null;

		if (useFinderCache) {
			list = (List<SignupUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SignupUser signupUser : list) {
					if (!uuid.equals(signupUser.getUuid())) {
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

			sb.append(_SQL_SELECT_SIGNUPUSER_WHERE);

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
				sb.append(SignupUserModelImpl.ORDER_BY_JPQL);
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

				list = (List<SignupUser>)QueryUtil.list(
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
	 * Returns the first signup user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	@Override
	public SignupUser findByUuid_First(
			String uuid, OrderByComparator<SignupUser> orderByComparator)
		throws NoSuchSignupUserException {

		SignupUser signupUser = fetchByUuid_First(uuid, orderByComparator);

		if (signupUser != null) {
			return signupUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSignupUserException(sb.toString());
	}

	/**
	 * Returns the first signup user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	@Override
	public SignupUser fetchByUuid_First(
		String uuid, OrderByComparator<SignupUser> orderByComparator) {

		List<SignupUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last signup user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	@Override
	public SignupUser findByUuid_Last(
			String uuid, OrderByComparator<SignupUser> orderByComparator)
		throws NoSuchSignupUserException {

		SignupUser signupUser = fetchByUuid_Last(uuid, orderByComparator);

		if (signupUser != null) {
			return signupUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSignupUserException(sb.toString());
	}

	/**
	 * Returns the last signup user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	@Override
	public SignupUser fetchByUuid_Last(
		String uuid, OrderByComparator<SignupUser> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SignupUser> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the signup users before and after the current signup user in the ordered set where uuid = &#63;.
	 *
	 * @param signupUserId the primary key of the current signup user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signup user
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	@Override
	public SignupUser[] findByUuid_PrevAndNext(
			long signupUserId, String uuid,
			OrderByComparator<SignupUser> orderByComparator)
		throws NoSuchSignupUserException {

		uuid = Objects.toString(uuid, "");

		SignupUser signupUser = findByPrimaryKey(signupUserId);

		Session session = null;

		try {
			session = openSession();

			SignupUser[] array = new SignupUserImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, signupUser, uuid, orderByComparator, true);

			array[1] = signupUser;

			array[2] = getByUuid_PrevAndNext(
				session, signupUser, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SignupUser getByUuid_PrevAndNext(
		Session session, SignupUser signupUser, String uuid,
		OrderByComparator<SignupUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SIGNUPUSER_WHERE);

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
			sb.append(SignupUserModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(signupUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SignupUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the signup users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SignupUser signupUser :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(signupUser);
		}
	}

	/**
	 * Returns the number of signup users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching signup users
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SIGNUPUSER_WHERE);

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
		"signupUser.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(signupUser.uuid IS NULL OR signupUser.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByEmail;
	private FinderPath _finderPathWithoutPaginationFindByEmail;
	private FinderPath _finderPathCountByEmail;

	/**
	 * Returns all the signup users where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching signup users
	 */
	@Override
	public List<SignupUser> findByEmail(String email) {
		return findByEmail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the signup users where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @return the range of matching signup users
	 */
	@Override
	public List<SignupUser> findByEmail(String email, int start, int end) {
		return findByEmail(email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the signup users where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signup users
	 */
	@Override
	public List<SignupUser> findByEmail(
		String email, int start, int end,
		OrderByComparator<SignupUser> orderByComparator) {

		return findByEmail(email, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the signup users where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signup users
	 */
	@Override
	public List<SignupUser> findByEmail(
		String email, int start, int end,
		OrderByComparator<SignupUser> orderByComparator,
		boolean useFinderCache) {

		email = Objects.toString(email, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmail;
				finderArgs = new Object[] {email};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmail;
			finderArgs = new Object[] {email, start, end, orderByComparator};
		}

		List<SignupUser> list = null;

		if (useFinderCache) {
			list = (List<SignupUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SignupUser signupUser : list) {
					if (!email.equals(signupUser.getEmail())) {
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

			sb.append(_SQL_SELECT_SIGNUPUSER_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SignupUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				list = (List<SignupUser>)QueryUtil.list(
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
	 * Returns the first signup user in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	@Override
	public SignupUser findByEmail_First(
			String email, OrderByComparator<SignupUser> orderByComparator)
		throws NoSuchSignupUserException {

		SignupUser signupUser = fetchByEmail_First(email, orderByComparator);

		if (signupUser != null) {
			return signupUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("email=");
		sb.append(email);

		sb.append("}");

		throw new NoSuchSignupUserException(sb.toString());
	}

	/**
	 * Returns the first signup user in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	@Override
	public SignupUser fetchByEmail_First(
		String email, OrderByComparator<SignupUser> orderByComparator) {

		List<SignupUser> list = findByEmail(email, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last signup user in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	@Override
	public SignupUser findByEmail_Last(
			String email, OrderByComparator<SignupUser> orderByComparator)
		throws NoSuchSignupUserException {

		SignupUser signupUser = fetchByEmail_Last(email, orderByComparator);

		if (signupUser != null) {
			return signupUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("email=");
		sb.append(email);

		sb.append("}");

		throw new NoSuchSignupUserException(sb.toString());
	}

	/**
	 * Returns the last signup user in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	@Override
	public SignupUser fetchByEmail_Last(
		String email, OrderByComparator<SignupUser> orderByComparator) {

		int count = countByEmail(email);

		if (count == 0) {
			return null;
		}

		List<SignupUser> list = findByEmail(
			email, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the signup users before and after the current signup user in the ordered set where email = &#63;.
	 *
	 * @param signupUserId the primary key of the current signup user
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signup user
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	@Override
	public SignupUser[] findByEmail_PrevAndNext(
			long signupUserId, String email,
			OrderByComparator<SignupUser> orderByComparator)
		throws NoSuchSignupUserException {

		email = Objects.toString(email, "");

		SignupUser signupUser = findByPrimaryKey(signupUserId);

		Session session = null;

		try {
			session = openSession();

			SignupUser[] array = new SignupUserImpl[3];

			array[0] = getByEmail_PrevAndNext(
				session, signupUser, email, orderByComparator, true);

			array[1] = signupUser;

			array[2] = getByEmail_PrevAndNext(
				session, signupUser, email, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SignupUser getByEmail_PrevAndNext(
		Session session, SignupUser signupUser, String email,
		OrderByComparator<SignupUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SIGNUPUSER_WHERE);

		boolean bindEmail = false;

		if (email.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
		}
		else {
			bindEmail = true;

			sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
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
			sb.append(SignupUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmail) {
			queryPos.add(email);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(signupUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SignupUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the signup users where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	@Override
	public void removeByEmail(String email) {
		for (SignupUser signupUser :
				findByEmail(
					email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(signupUser);
		}
	}

	/**
	 * Returns the number of signup users where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching signup users
	 */
	@Override
	public int countByEmail(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByEmail;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SIGNUPUSER_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
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

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 =
		"signupUser.email = ?";

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 =
		"(signupUser.email IS NULL OR signupUser.email = '')";

	private FinderPath _finderPathWithPaginationFindByActivationToken;
	private FinderPath _finderPathWithoutPaginationFindByActivationToken;
	private FinderPath _finderPathCountByActivationToken;

	/**
	 * Returns all the signup users where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @return the matching signup users
	 */
	@Override
	public List<SignupUser> findByActivationToken(String activationToken) {
		return findByActivationToken(
			activationToken, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the signup users where activationToken = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param activationToken the activation token
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @return the range of matching signup users
	 */
	@Override
	public List<SignupUser> findByActivationToken(
		String activationToken, int start, int end) {

		return findByActivationToken(activationToken, start, end, null);
	}

	/**
	 * Returns an ordered range of all the signup users where activationToken = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param activationToken the activation token
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signup users
	 */
	@Override
	public List<SignupUser> findByActivationToken(
		String activationToken, int start, int end,
		OrderByComparator<SignupUser> orderByComparator) {

		return findByActivationToken(
			activationToken, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the signup users where activationToken = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param activationToken the activation token
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signup users
	 */
	@Override
	public List<SignupUser> findByActivationToken(
		String activationToken, int start, int end,
		OrderByComparator<SignupUser> orderByComparator,
		boolean useFinderCache) {

		activationToken = Objects.toString(activationToken, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByActivationToken;
				finderArgs = new Object[] {activationToken};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByActivationToken;
			finderArgs = new Object[] {
				activationToken, start, end, orderByComparator
			};
		}

		List<SignupUser> list = null;

		if (useFinderCache) {
			list = (List<SignupUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SignupUser signupUser : list) {
					if (!activationToken.equals(
							signupUser.getActivationToken())) {

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

			sb.append(_SQL_SELECT_SIGNUPUSER_WHERE);

			boolean bindActivationToken = false;

			if (activationToken.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACTIVATIONTOKEN_ACTIVATIONTOKEN_3);
			}
			else {
				bindActivationToken = true;

				sb.append(_FINDER_COLUMN_ACTIVATIONTOKEN_ACTIVATIONTOKEN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SignupUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActivationToken) {
					queryPos.add(activationToken);
				}

				list = (List<SignupUser>)QueryUtil.list(
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
	 * Returns the first signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	@Override
	public SignupUser findByActivationToken_First(
			String activationToken,
			OrderByComparator<SignupUser> orderByComparator)
		throws NoSuchSignupUserException {

		SignupUser signupUser = fetchByActivationToken_First(
			activationToken, orderByComparator);

		if (signupUser != null) {
			return signupUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("activationToken=");
		sb.append(activationToken);

		sb.append("}");

		throw new NoSuchSignupUserException(sb.toString());
	}

	/**
	 * Returns the first signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	@Override
	public SignupUser fetchByActivationToken_First(
		String activationToken,
		OrderByComparator<SignupUser> orderByComparator) {

		List<SignupUser> list = findByActivationToken(
			activationToken, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	@Override
	public SignupUser findByActivationToken_Last(
			String activationToken,
			OrderByComparator<SignupUser> orderByComparator)
		throws NoSuchSignupUserException {

		SignupUser signupUser = fetchByActivationToken_Last(
			activationToken, orderByComparator);

		if (signupUser != null) {
			return signupUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("activationToken=");
		sb.append(activationToken);

		sb.append("}");

		throw new NoSuchSignupUserException(sb.toString());
	}

	/**
	 * Returns the last signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	@Override
	public SignupUser fetchByActivationToken_Last(
		String activationToken,
		OrderByComparator<SignupUser> orderByComparator) {

		int count = countByActivationToken(activationToken);

		if (count == 0) {
			return null;
		}

		List<SignupUser> list = findByActivationToken(
			activationToken, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the signup users before and after the current signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param signupUserId the primary key of the current signup user
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signup user
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	@Override
	public SignupUser[] findByActivationToken_PrevAndNext(
			long signupUserId, String activationToken,
			OrderByComparator<SignupUser> orderByComparator)
		throws NoSuchSignupUserException {

		activationToken = Objects.toString(activationToken, "");

		SignupUser signupUser = findByPrimaryKey(signupUserId);

		Session session = null;

		try {
			session = openSession();

			SignupUser[] array = new SignupUserImpl[3];

			array[0] = getByActivationToken_PrevAndNext(
				session, signupUser, activationToken, orderByComparator, true);

			array[1] = signupUser;

			array[2] = getByActivationToken_PrevAndNext(
				session, signupUser, activationToken, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SignupUser getByActivationToken_PrevAndNext(
		Session session, SignupUser signupUser, String activationToken,
		OrderByComparator<SignupUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SIGNUPUSER_WHERE);

		boolean bindActivationToken = false;

		if (activationToken.isEmpty()) {
			sb.append(_FINDER_COLUMN_ACTIVATIONTOKEN_ACTIVATIONTOKEN_3);
		}
		else {
			bindActivationToken = true;

			sb.append(_FINDER_COLUMN_ACTIVATIONTOKEN_ACTIVATIONTOKEN_2);
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
			sb.append(SignupUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindActivationToken) {
			queryPos.add(activationToken);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(signupUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SignupUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the signup users where activationToken = &#63; from the database.
	 *
	 * @param activationToken the activation token
	 */
	@Override
	public void removeByActivationToken(String activationToken) {
		for (SignupUser signupUser :
				findByActivationToken(
					activationToken, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(signupUser);
		}
	}

	/**
	 * Returns the number of signup users where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @return the number of matching signup users
	 */
	@Override
	public int countByActivationToken(String activationToken) {
		activationToken = Objects.toString(activationToken, "");

		FinderPath finderPath = _finderPathCountByActivationToken;

		Object[] finderArgs = new Object[] {activationToken};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SIGNUPUSER_WHERE);

			boolean bindActivationToken = false;

			if (activationToken.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACTIVATIONTOKEN_ACTIVATIONTOKEN_3);
			}
			else {
				bindActivationToken = true;

				sb.append(_FINDER_COLUMN_ACTIVATIONTOKEN_ACTIVATIONTOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActivationToken) {
					queryPos.add(activationToken);
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

	private static final String
		_FINDER_COLUMN_ACTIVATIONTOKEN_ACTIVATIONTOKEN_2 =
			"signupUser.activationToken = ?";

	private static final String
		_FINDER_COLUMN_ACTIVATIONTOKEN_ACTIVATIONTOKEN_3 =
			"(signupUser.activationToken IS NULL OR signupUser.activationToken = '')";

	public SignupUserPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("role", "role_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SignupUser.class);

		setModelImplClass(SignupUserImpl.class);
		setModelPKClass(long.class);

		setTable(SignupUserTable.INSTANCE);
	}

	/**
	 * Caches the signup user in the entity cache if it is enabled.
	 *
	 * @param signupUser the signup user
	 */
	@Override
	public void cacheResult(SignupUser signupUser) {
		entityCache.putResult(
			SignupUserImpl.class, signupUser.getPrimaryKey(), signupUser);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the signup users in the entity cache if it is enabled.
	 *
	 * @param signupUsers the signup users
	 */
	@Override
	public void cacheResult(List<SignupUser> signupUsers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (signupUsers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SignupUser signupUser : signupUsers) {
			if (entityCache.getResult(
					SignupUserImpl.class, signupUser.getPrimaryKey()) == null) {

				cacheResult(signupUser);
			}
		}
	}

	/**
	 * Clears the cache for all signup users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SignupUserImpl.class);

		finderCache.clearCache(SignupUserImpl.class);
	}

	/**
	 * Clears the cache for the signup user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SignupUser signupUser) {
		entityCache.removeResult(SignupUserImpl.class, signupUser);
	}

	@Override
	public void clearCache(List<SignupUser> signupUsers) {
		for (SignupUser signupUser : signupUsers) {
			entityCache.removeResult(SignupUserImpl.class, signupUser);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SignupUserImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SignupUserImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new signup user with the primary key. Does not add the signup user to the database.
	 *
	 * @param signupUserId the primary key for the new signup user
	 * @return the new signup user
	 */
	@Override
	public SignupUser create(long signupUserId) {
		SignupUser signupUser = new SignupUserImpl();

		signupUser.setNew(true);
		signupUser.setPrimaryKey(signupUserId);

		String uuid = PortalUUIDUtil.generate();

		signupUser.setUuid(uuid);

		return signupUser;
	}

	/**
	 * Removes the signup user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param signupUserId the primary key of the signup user
	 * @return the signup user that was removed
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	@Override
	public SignupUser remove(long signupUserId)
		throws NoSuchSignupUserException {

		return remove((Serializable)signupUserId);
	}

	/**
	 * Removes the signup user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the signup user
	 * @return the signup user that was removed
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	@Override
	public SignupUser remove(Serializable primaryKey)
		throws NoSuchSignupUserException {

		Session session = null;

		try {
			session = openSession();

			SignupUser signupUser = (SignupUser)session.get(
				SignupUserImpl.class, primaryKey);

			if (signupUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSignupUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(signupUser);
		}
		catch (NoSuchSignupUserException noSuchEntityException) {
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
	protected SignupUser removeImpl(SignupUser signupUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(signupUser)) {
				signupUser = (SignupUser)session.get(
					SignupUserImpl.class, signupUser.getPrimaryKeyObj());
			}

			if (signupUser != null) {
				session.delete(signupUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (signupUser != null) {
			clearCache(signupUser);
		}

		return signupUser;
	}

	@Override
	public SignupUser updateImpl(SignupUser signupUser) {
		boolean isNew = signupUser.isNew();

		if (!(signupUser instanceof SignupUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(signupUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(signupUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in signupUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SignupUser implementation " +
					signupUser.getClass());
		}

		SignupUserModelImpl signupUserModelImpl =
			(SignupUserModelImpl)signupUser;

		if (Validator.isNull(signupUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			signupUser.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(signupUser);
			}
			else {
				signupUser = (SignupUser)session.merge(signupUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SignupUserImpl.class, signupUserModelImpl, false, true);

		if (isNew) {
			signupUser.setNew(false);
		}

		signupUser.resetOriginalValues();

		return signupUser;
	}

	/**
	 * Returns the signup user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the signup user
	 * @return the signup user
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	@Override
	public SignupUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSignupUserException {

		SignupUser signupUser = fetchByPrimaryKey(primaryKey);

		if (signupUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSignupUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return signupUser;
	}

	/**
	 * Returns the signup user with the primary key or throws a <code>NoSuchSignupUserException</code> if it could not be found.
	 *
	 * @param signupUserId the primary key of the signup user
	 * @return the signup user
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	@Override
	public SignupUser findByPrimaryKey(long signupUserId)
		throws NoSuchSignupUserException {

		return findByPrimaryKey((Serializable)signupUserId);
	}

	/**
	 * Returns the signup user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param signupUserId the primary key of the signup user
	 * @return the signup user, or <code>null</code> if a signup user with the primary key could not be found
	 */
	@Override
	public SignupUser fetchByPrimaryKey(long signupUserId) {
		return fetchByPrimaryKey((Serializable)signupUserId);
	}

	/**
	 * Returns all the signup users.
	 *
	 * @return the signup users
	 */
	@Override
	public List<SignupUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the signup users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @return the range of signup users
	 */
	@Override
	public List<SignupUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the signup users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of signup users
	 */
	@Override
	public List<SignupUser> findAll(
		int start, int end, OrderByComparator<SignupUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the signup users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of signup users
	 */
	@Override
	public List<SignupUser> findAll(
		int start, int end, OrderByComparator<SignupUser> orderByComparator,
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

		List<SignupUser> list = null;

		if (useFinderCache) {
			list = (List<SignupUser>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SIGNUPUSER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SIGNUPUSER;

				sql = sql.concat(SignupUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SignupUser>)QueryUtil.list(
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
	 * Removes all the signup users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SignupUser signupUser : findAll()) {
			remove(signupUser);
		}
	}

	/**
	 * Returns the number of signup users.
	 *
	 * @return the number of signup users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SIGNUPUSER);

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
		return "signupUserId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SIGNUPUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SignupUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the signup user persistence.
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

		_finderPathWithPaginationFindByEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"email"}, true);

		_finderPathWithoutPaginationFindByEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			true);

		_finderPathCountByEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			false);

		_finderPathWithPaginationFindByActivationToken = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActivationToken",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"activationToken"}, true);

		_finderPathWithoutPaginationFindByActivationToken = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActivationToken",
			new String[] {String.class.getName()},
			new String[] {"activationToken"}, true);

		_finderPathCountByActivationToken = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActivationToken",
			new String[] {String.class.getName()},
			new String[] {"activationToken"}, false);

		SignupUserUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SignupUserUtil.setPersistence(null);

		entityCache.removeCache(SignupUserImpl.class.getName());
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

	private static final String _SQL_SELECT_SIGNUPUSER =
		"SELECT signupUser FROM SignupUser signupUser";

	private static final String _SQL_SELECT_SIGNUPUSER_WHERE =
		"SELECT signupUser FROM SignupUser signupUser WHERE ";

	private static final String _SQL_COUNT_SIGNUPUSER =
		"SELECT COUNT(signupUser) FROM SignupUser signupUser";

	private static final String _SQL_COUNT_SIGNUPUSER_WHERE =
		"SELECT COUNT(signupUser) FROM SignupUser signupUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "signupUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SignupUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SignupUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SignupUserPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "role", "active"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}