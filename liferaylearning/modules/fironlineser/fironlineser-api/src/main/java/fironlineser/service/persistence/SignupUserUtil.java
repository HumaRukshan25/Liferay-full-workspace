/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import fironlineser.model.SignupUser;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the signup user service. This utility wraps <code>fironlineser.service.persistence.impl.SignupUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SignupUserPersistence
 * @generated
 */
public class SignupUserUtil {

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
	public static void clearCache(SignupUser signupUser) {
		getPersistence().clearCache(signupUser);
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
	public static Map<Serializable, SignupUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SignupUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SignupUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SignupUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SignupUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SignupUser update(SignupUser signupUser) {
		return getPersistence().update(signupUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SignupUser update(
		SignupUser signupUser, ServiceContext serviceContext) {

		return getPersistence().update(signupUser, serviceContext);
	}

	/**
	 * Returns all the signup users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching signup users
	 */
	public static List<SignupUser> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<SignupUser> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<SignupUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SignupUser> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<SignupUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SignupUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first signup user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	public static SignupUser findByUuid_First(
			String uuid, OrderByComparator<SignupUser> orderByComparator)
		throws fironlineser.exception.NoSuchSignupUserException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first signup user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	public static SignupUser fetchByUuid_First(
		String uuid, OrderByComparator<SignupUser> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last signup user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	public static SignupUser findByUuid_Last(
			String uuid, OrderByComparator<SignupUser> orderByComparator)
		throws fironlineser.exception.NoSuchSignupUserException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last signup user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	public static SignupUser fetchByUuid_Last(
		String uuid, OrderByComparator<SignupUser> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static SignupUser[] findByUuid_PrevAndNext(
			long signupUserId, String uuid,
			OrderByComparator<SignupUser> orderByComparator)
		throws fironlineser.exception.NoSuchSignupUserException {

		return getPersistence().findByUuid_PrevAndNext(
			signupUserId, uuid, orderByComparator);
	}

	/**
	 * Removes all the signup users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of signup users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching signup users
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the signup users where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching signup users
	 */
	public static List<SignupUser> findByEmail(String email) {
		return getPersistence().findByEmail(email);
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
	public static List<SignupUser> findByEmail(
		String email, int start, int end) {

		return getPersistence().findByEmail(email, start, end);
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
	public static List<SignupUser> findByEmail(
		String email, int start, int end,
		OrderByComparator<SignupUser> orderByComparator) {

		return getPersistence().findByEmail(
			email, start, end, orderByComparator);
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
	public static List<SignupUser> findByEmail(
		String email, int start, int end,
		OrderByComparator<SignupUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmail(
			email, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first signup user in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	public static SignupUser findByEmail_First(
			String email, OrderByComparator<SignupUser> orderByComparator)
		throws fironlineser.exception.NoSuchSignupUserException {

		return getPersistence().findByEmail_First(email, orderByComparator);
	}

	/**
	 * Returns the first signup user in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	public static SignupUser fetchByEmail_First(
		String email, OrderByComparator<SignupUser> orderByComparator) {

		return getPersistence().fetchByEmail_First(email, orderByComparator);
	}

	/**
	 * Returns the last signup user in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	public static SignupUser findByEmail_Last(
			String email, OrderByComparator<SignupUser> orderByComparator)
		throws fironlineser.exception.NoSuchSignupUserException {

		return getPersistence().findByEmail_Last(email, orderByComparator);
	}

	/**
	 * Returns the last signup user in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	public static SignupUser fetchByEmail_Last(
		String email, OrderByComparator<SignupUser> orderByComparator) {

		return getPersistence().fetchByEmail_Last(email, orderByComparator);
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
	public static SignupUser[] findByEmail_PrevAndNext(
			long signupUserId, String email,
			OrderByComparator<SignupUser> orderByComparator)
		throws fironlineser.exception.NoSuchSignupUserException {

		return getPersistence().findByEmail_PrevAndNext(
			signupUserId, email, orderByComparator);
	}

	/**
	 * Removes all the signup users where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public static void removeByEmail(String email) {
		getPersistence().removeByEmail(email);
	}

	/**
	 * Returns the number of signup users where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching signup users
	 */
	public static int countByEmail(String email) {
		return getPersistence().countByEmail(email);
	}

	/**
	 * Returns all the signup users where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @return the matching signup users
	 */
	public static List<SignupUser> findByActivationToken(
		String activationToken) {

		return getPersistence().findByActivationToken(activationToken);
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
	public static List<SignupUser> findByActivationToken(
		String activationToken, int start, int end) {

		return getPersistence().findByActivationToken(
			activationToken, start, end);
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
	public static List<SignupUser> findByActivationToken(
		String activationToken, int start, int end,
		OrderByComparator<SignupUser> orderByComparator) {

		return getPersistence().findByActivationToken(
			activationToken, start, end, orderByComparator);
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
	public static List<SignupUser> findByActivationToken(
		String activationToken, int start, int end,
		OrderByComparator<SignupUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByActivationToken(
			activationToken, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	public static SignupUser findByActivationToken_First(
			String activationToken,
			OrderByComparator<SignupUser> orderByComparator)
		throws fironlineser.exception.NoSuchSignupUserException {

		return getPersistence().findByActivationToken_First(
			activationToken, orderByComparator);
	}

	/**
	 * Returns the first signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	public static SignupUser fetchByActivationToken_First(
		String activationToken,
		OrderByComparator<SignupUser> orderByComparator) {

		return getPersistence().fetchByActivationToken_First(
			activationToken, orderByComparator);
	}

	/**
	 * Returns the last signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	public static SignupUser findByActivationToken_Last(
			String activationToken,
			OrderByComparator<SignupUser> orderByComparator)
		throws fironlineser.exception.NoSuchSignupUserException {

		return getPersistence().findByActivationToken_Last(
			activationToken, orderByComparator);
	}

	/**
	 * Returns the last signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	public static SignupUser fetchByActivationToken_Last(
		String activationToken,
		OrderByComparator<SignupUser> orderByComparator) {

		return getPersistence().fetchByActivationToken_Last(
			activationToken, orderByComparator);
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
	public static SignupUser[] findByActivationToken_PrevAndNext(
			long signupUserId, String activationToken,
			OrderByComparator<SignupUser> orderByComparator)
		throws fironlineser.exception.NoSuchSignupUserException {

		return getPersistence().findByActivationToken_PrevAndNext(
			signupUserId, activationToken, orderByComparator);
	}

	/**
	 * Removes all the signup users where activationToken = &#63; from the database.
	 *
	 * @param activationToken the activation token
	 */
	public static void removeByActivationToken(String activationToken) {
		getPersistence().removeByActivationToken(activationToken);
	}

	/**
	 * Returns the number of signup users where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @return the number of matching signup users
	 */
	public static int countByActivationToken(String activationToken) {
		return getPersistence().countByActivationToken(activationToken);
	}

	/**
	 * Caches the signup user in the entity cache if it is enabled.
	 *
	 * @param signupUser the signup user
	 */
	public static void cacheResult(SignupUser signupUser) {
		getPersistence().cacheResult(signupUser);
	}

	/**
	 * Caches the signup users in the entity cache if it is enabled.
	 *
	 * @param signupUsers the signup users
	 */
	public static void cacheResult(List<SignupUser> signupUsers) {
		getPersistence().cacheResult(signupUsers);
	}

	/**
	 * Creates a new signup user with the primary key. Does not add the signup user to the database.
	 *
	 * @param signupUserId the primary key for the new signup user
	 * @return the new signup user
	 */
	public static SignupUser create(long signupUserId) {
		return getPersistence().create(signupUserId);
	}

	/**
	 * Removes the signup user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param signupUserId the primary key of the signup user
	 * @return the signup user that was removed
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	public static SignupUser remove(long signupUserId)
		throws fironlineser.exception.NoSuchSignupUserException {

		return getPersistence().remove(signupUserId);
	}

	public static SignupUser updateImpl(SignupUser signupUser) {
		return getPersistence().updateImpl(signupUser);
	}

	/**
	 * Returns the signup user with the primary key or throws a <code>NoSuchSignupUserException</code> if it could not be found.
	 *
	 * @param signupUserId the primary key of the signup user
	 * @return the signup user
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	public static SignupUser findByPrimaryKey(long signupUserId)
		throws fironlineser.exception.NoSuchSignupUserException {

		return getPersistence().findByPrimaryKey(signupUserId);
	}

	/**
	 * Returns the signup user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param signupUserId the primary key of the signup user
	 * @return the signup user, or <code>null</code> if a signup user with the primary key could not be found
	 */
	public static SignupUser fetchByPrimaryKey(long signupUserId) {
		return getPersistence().fetchByPrimaryKey(signupUserId);
	}

	/**
	 * Returns all the signup users.
	 *
	 * @return the signup users
	 */
	public static List<SignupUser> findAll() {
		return getPersistence().findAll();
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
	public static List<SignupUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<SignupUser> findAll(
		int start, int end, OrderByComparator<SignupUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<SignupUser> findAll(
		int start, int end, OrderByComparator<SignupUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the signup users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of signup users.
	 *
	 * @return the number of signup users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SignupUserPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SignupUserPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SignupUserPersistence _persistence;

}