/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import fironlineser.exception.NoSuchSignupUserException;

import fironlineser.model.SignupUser;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the signup user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SignupUserUtil
 * @generated
 */
@ProviderType
public interface SignupUserPersistence extends BasePersistence<SignupUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SignupUserUtil} to access the signup user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the signup users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching signup users
	 */
	public java.util.List<SignupUser> findByUuid(String uuid);

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
	public java.util.List<SignupUser> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SignupUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator);

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
	public java.util.List<SignupUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first signup user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	public SignupUser findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
				orderByComparator)
		throws NoSuchSignupUserException;

	/**
	 * Returns the first signup user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	public SignupUser fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator);

	/**
	 * Returns the last signup user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	public SignupUser findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
				orderByComparator)
		throws NoSuchSignupUserException;

	/**
	 * Returns the last signup user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	public SignupUser fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator);

	/**
	 * Returns the signup users before and after the current signup user in the ordered set where uuid = &#63;.
	 *
	 * @param signupUserId the primary key of the current signup user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signup user
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	public SignupUser[] findByUuid_PrevAndNext(
			long signupUserId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
				orderByComparator)
		throws NoSuchSignupUserException;

	/**
	 * Removes all the signup users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of signup users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching signup users
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the signup users where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching signup users
	 */
	public java.util.List<SignupUser> findByEmail(String email);

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
	public java.util.List<SignupUser> findByEmail(
		String email, int start, int end);

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
	public java.util.List<SignupUser> findByEmail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator);

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
	public java.util.List<SignupUser> findByEmail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first signup user in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	public SignupUser findByEmail_First(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
				orderByComparator)
		throws NoSuchSignupUserException;

	/**
	 * Returns the first signup user in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	public SignupUser fetchByEmail_First(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator);

	/**
	 * Returns the last signup user in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	public SignupUser findByEmail_Last(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
				orderByComparator)
		throws NoSuchSignupUserException;

	/**
	 * Returns the last signup user in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	public SignupUser fetchByEmail_Last(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator);

	/**
	 * Returns the signup users before and after the current signup user in the ordered set where email = &#63;.
	 *
	 * @param signupUserId the primary key of the current signup user
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signup user
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	public SignupUser[] findByEmail_PrevAndNext(
			long signupUserId, String email,
			com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
				orderByComparator)
		throws NoSuchSignupUserException;

	/**
	 * Removes all the signup users where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public void removeByEmail(String email);

	/**
	 * Returns the number of signup users where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching signup users
	 */
	public int countByEmail(String email);

	/**
	 * Returns all the signup users where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @return the matching signup users
	 */
	public java.util.List<SignupUser> findByActivationToken(
		String activationToken);

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
	public java.util.List<SignupUser> findByActivationToken(
		String activationToken, int start, int end);

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
	public java.util.List<SignupUser> findByActivationToken(
		String activationToken, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator);

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
	public java.util.List<SignupUser> findByActivationToken(
		String activationToken, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	public SignupUser findByActivationToken_First(
			String activationToken,
			com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
				orderByComparator)
		throws NoSuchSignupUserException;

	/**
	 * Returns the first signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	public SignupUser fetchByActivationToken_First(
		String activationToken,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator);

	/**
	 * Returns the last signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user
	 * @throws NoSuchSignupUserException if a matching signup user could not be found
	 */
	public SignupUser findByActivationToken_Last(
			String activationToken,
			com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
				orderByComparator)
		throws NoSuchSignupUserException;

	/**
	 * Returns the last signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup user, or <code>null</code> if a matching signup user could not be found
	 */
	public SignupUser fetchByActivationToken_Last(
		String activationToken,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator);

	/**
	 * Returns the signup users before and after the current signup user in the ordered set where activationToken = &#63;.
	 *
	 * @param signupUserId the primary key of the current signup user
	 * @param activationToken the activation token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signup user
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	public SignupUser[] findByActivationToken_PrevAndNext(
			long signupUserId, String activationToken,
			com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
				orderByComparator)
		throws NoSuchSignupUserException;

	/**
	 * Removes all the signup users where activationToken = &#63; from the database.
	 *
	 * @param activationToken the activation token
	 */
	public void removeByActivationToken(String activationToken);

	/**
	 * Returns the number of signup users where activationToken = &#63;.
	 *
	 * @param activationToken the activation token
	 * @return the number of matching signup users
	 */
	public int countByActivationToken(String activationToken);

	/**
	 * Caches the signup user in the entity cache if it is enabled.
	 *
	 * @param signupUser the signup user
	 */
	public void cacheResult(SignupUser signupUser);

	/**
	 * Caches the signup users in the entity cache if it is enabled.
	 *
	 * @param signupUsers the signup users
	 */
	public void cacheResult(java.util.List<SignupUser> signupUsers);

	/**
	 * Creates a new signup user with the primary key. Does not add the signup user to the database.
	 *
	 * @param signupUserId the primary key for the new signup user
	 * @return the new signup user
	 */
	public SignupUser create(long signupUserId);

	/**
	 * Removes the signup user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param signupUserId the primary key of the signup user
	 * @return the signup user that was removed
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	public SignupUser remove(long signupUserId)
		throws NoSuchSignupUserException;

	public SignupUser updateImpl(SignupUser signupUser);

	/**
	 * Returns the signup user with the primary key or throws a <code>NoSuchSignupUserException</code> if it could not be found.
	 *
	 * @param signupUserId the primary key of the signup user
	 * @return the signup user
	 * @throws NoSuchSignupUserException if a signup user with the primary key could not be found
	 */
	public SignupUser findByPrimaryKey(long signupUserId)
		throws NoSuchSignupUserException;

	/**
	 * Returns the signup user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param signupUserId the primary key of the signup user
	 * @return the signup user, or <code>null</code> if a signup user with the primary key could not be found
	 */
	public SignupUser fetchByPrimaryKey(long signupUserId);

	/**
	 * Returns all the signup users.
	 *
	 * @return the signup users
	 */
	public java.util.List<SignupUser> findAll();

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
	public java.util.List<SignupUser> findAll(int start, int end);

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
	public java.util.List<SignupUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator);

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
	public java.util.List<SignupUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the signup users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of signup users.
	 *
	 * @return the number of signup users
	 */
	public int countAll();

}