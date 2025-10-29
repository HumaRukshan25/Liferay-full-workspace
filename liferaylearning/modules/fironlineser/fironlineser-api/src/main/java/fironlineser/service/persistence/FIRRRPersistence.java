/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import fironlineser.exception.NoSuchFIRRRException;

import fironlineser.model.FIRRR;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the firrr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FIRRRUtil
 * @generated
 */
@ProviderType
public interface FIRRRPersistence extends BasePersistence<FIRRR> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FIRRRUtil} to access the firrr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the firrrs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching firrrs
	 */
	public java.util.List<FIRRR> findByUuid(String uuid);

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
	public java.util.List<FIRRR> findByUuid(String uuid, int start, int end);

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
	public java.util.List<FIRRR> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
			orderByComparator);

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
	public java.util.List<FIRRR> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first firrr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firrr
	 * @throws NoSuchFIRRRException if a matching firrr could not be found
	 */
	public FIRRR findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
				orderByComparator)
		throws NoSuchFIRRRException;

	/**
	 * Returns the first firrr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firrr, or <code>null</code> if a matching firrr could not be found
	 */
	public FIRRR fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
			orderByComparator);

	/**
	 * Returns the last firrr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firrr
	 * @throws NoSuchFIRRRException if a matching firrr could not be found
	 */
	public FIRRR findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
				orderByComparator)
		throws NoSuchFIRRRException;

	/**
	 * Returns the last firrr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firrr, or <code>null</code> if a matching firrr could not be found
	 */
	public FIRRR fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
			orderByComparator);

	/**
	 * Returns the firrrs before and after the current firrr in the ordered set where uuid = &#63;.
	 *
	 * @param firId the primary key of the current firrr
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next firrr
	 * @throws NoSuchFIRRRException if a firrr with the primary key could not be found
	 */
	public FIRRR[] findByUuid_PrevAndNext(
			long firId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
				orderByComparator)
		throws NoSuchFIRRRException;

	/**
	 * Removes all the firrrs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of firrrs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching firrrs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the firrrs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching firrrs
	 */
	public java.util.List<FIRRR> findByUserId(long userId);

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
	public java.util.List<FIRRR> findByUserId(long userId, int start, int end);

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
	public java.util.List<FIRRR> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
			orderByComparator);

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
	public java.util.List<FIRRR> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first firrr in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firrr
	 * @throws NoSuchFIRRRException if a matching firrr could not be found
	 */
	public FIRRR findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
				orderByComparator)
		throws NoSuchFIRRRException;

	/**
	 * Returns the first firrr in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firrr, or <code>null</code> if a matching firrr could not be found
	 */
	public FIRRR fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
			orderByComparator);

	/**
	 * Returns the last firrr in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firrr
	 * @throws NoSuchFIRRRException if a matching firrr could not be found
	 */
	public FIRRR findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
				orderByComparator)
		throws NoSuchFIRRRException;

	/**
	 * Returns the last firrr in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firrr, or <code>null</code> if a matching firrr could not be found
	 */
	public FIRRR fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
			orderByComparator);

	/**
	 * Returns the firrrs before and after the current firrr in the ordered set where userId = &#63;.
	 *
	 * @param firId the primary key of the current firrr
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next firrr
	 * @throws NoSuchFIRRRException if a firrr with the primary key could not be found
	 */
	public FIRRR[] findByUserId_PrevAndNext(
			long firId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
				orderByComparator)
		throws NoSuchFIRRRException;

	/**
	 * Removes all the firrrs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of firrrs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching firrrs
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the firrr in the entity cache if it is enabled.
	 *
	 * @param firrr the firrr
	 */
	public void cacheResult(FIRRR firrr);

	/**
	 * Caches the firrrs in the entity cache if it is enabled.
	 *
	 * @param firrrs the firrrs
	 */
	public void cacheResult(java.util.List<FIRRR> firrrs);

	/**
	 * Creates a new firrr with the primary key. Does not add the firrr to the database.
	 *
	 * @param firId the primary key for the new firrr
	 * @return the new firrr
	 */
	public FIRRR create(long firId);

	/**
	 * Removes the firrr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param firId the primary key of the firrr
	 * @return the firrr that was removed
	 * @throws NoSuchFIRRRException if a firrr with the primary key could not be found
	 */
	public FIRRR remove(long firId) throws NoSuchFIRRRException;

	public FIRRR updateImpl(FIRRR firrr);

	/**
	 * Returns the firrr with the primary key or throws a <code>NoSuchFIRRRException</code> if it could not be found.
	 *
	 * @param firId the primary key of the firrr
	 * @return the firrr
	 * @throws NoSuchFIRRRException if a firrr with the primary key could not be found
	 */
	public FIRRR findByPrimaryKey(long firId) throws NoSuchFIRRRException;

	/**
	 * Returns the firrr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param firId the primary key of the firrr
	 * @return the firrr, or <code>null</code> if a firrr with the primary key could not be found
	 */
	public FIRRR fetchByPrimaryKey(long firId);

	/**
	 * Returns all the firrrs.
	 *
	 * @return the firrrs
	 */
	public java.util.List<FIRRR> findAll();

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
	public java.util.List<FIRRR> findAll(int start, int end);

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
	public java.util.List<FIRRR> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
			orderByComparator);

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
	public java.util.List<FIRRR> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FIRRR>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the firrrs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of firrrs.
	 *
	 * @return the number of firrrs
	 */
	public int countAll();

}