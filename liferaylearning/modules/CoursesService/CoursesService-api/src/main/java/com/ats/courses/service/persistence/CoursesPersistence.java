/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.service.persistence;

import com.ats.courses.exception.NoSuchCoursesException;
import com.ats.courses.model.Courses;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the courses service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CoursesUtil
 * @generated
 */
@ProviderType
public interface CoursesPersistence extends BasePersistence<Courses> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CoursesUtil} to access the courses persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the courseses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching courseses
	 */
	public java.util.List<Courses> findByUuid(String uuid);

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
	public java.util.List<Courses> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Courses> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

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
	public java.util.List<Courses> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first courses in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public Courses findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Courses>
				orderByComparator)
		throws NoSuchCoursesException;

	/**
	 * Returns the first courses in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public Courses fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

	/**
	 * Returns the last courses in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public Courses findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Courses>
				orderByComparator)
		throws NoSuchCoursesException;

	/**
	 * Returns the last courses in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public Courses fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

	/**
	 * Returns the courseses before and after the current courses in the ordered set where uuid = &#63;.
	 *
	 * @param coursesId the primary key of the current courses
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next courses
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	public Courses[] findByUuid_PrevAndNext(
			long coursesId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Courses>
				orderByComparator)
		throws NoSuchCoursesException;

	/**
	 * Removes all the courseses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of courseses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching courseses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the courses where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCoursesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public Courses findByUUID_G(String uuid, long groupId)
		throws NoSuchCoursesException;

	/**
	 * Returns the courses where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public Courses fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the courses where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public Courses fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the courses where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the courses that was removed
	 */
	public Courses removeByUUID_G(String uuid, long groupId)
		throws NoSuchCoursesException;

	/**
	 * Returns the number of courseses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching courseses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the courseses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching courseses
	 */
	public java.util.List<Courses> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Courses> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Courses> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

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
	public java.util.List<Courses> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first courses in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public Courses findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Courses>
				orderByComparator)
		throws NoSuchCoursesException;

	/**
	 * Returns the first courses in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public Courses fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

	/**
	 * Returns the last courses in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public Courses findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Courses>
				orderByComparator)
		throws NoSuchCoursesException;

	/**
	 * Returns the last courses in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public Courses fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

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
	public Courses[] findByUuid_C_PrevAndNext(
			long coursesId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Courses>
				orderByComparator)
		throws NoSuchCoursesException;

	/**
	 * Removes all the courseses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of courseses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching courseses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the courseses where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @return the matching courseses
	 */
	public java.util.List<Courses> findByCourses_type(String Courses_type);

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
	public java.util.List<Courses> findByCourses_type(
		String Courses_type, int start, int end);

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
	public java.util.List<Courses> findByCourses_type(
		String Courses_type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

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
	public java.util.List<Courses> findByCourses_type(
		String Courses_type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public Courses findByCourses_type_First(
			String Courses_type,
			com.liferay.portal.kernel.util.OrderByComparator<Courses>
				orderByComparator)
		throws NoSuchCoursesException;

	/**
	 * Returns the first courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public Courses fetchByCourses_type_First(
		String Courses_type,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

	/**
	 * Returns the last courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public Courses findByCourses_type_Last(
			String Courses_type,
			com.liferay.portal.kernel.util.OrderByComparator<Courses>
				orderByComparator)
		throws NoSuchCoursesException;

	/**
	 * Returns the last courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public Courses fetchByCourses_type_Last(
		String Courses_type,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

	/**
	 * Returns the courseses before and after the current courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param coursesId the primary key of the current courses
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next courses
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	public Courses[] findByCourses_type_PrevAndNext(
			long coursesId, String Courses_type,
			com.liferay.portal.kernel.util.OrderByComparator<Courses>
				orderByComparator)
		throws NoSuchCoursesException;

	/**
	 * Removes all the courseses where Courses_type = &#63; from the database.
	 *
	 * @param Courses_type the courses_type
	 */
	public void removeByCourses_type(String Courses_type);

	/**
	 * Returns the number of courseses where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @return the number of matching courseses
	 */
	public int countByCourses_type(String Courses_type);

	/**
	 * Returns all the courseses where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @return the matching courseses
	 */
	public java.util.List<Courses> findByCourses_name(String Courses_name);

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
	public java.util.List<Courses> findByCourses_name(
		String Courses_name, int start, int end);

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
	public java.util.List<Courses> findByCourses_name(
		String Courses_name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

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
	public java.util.List<Courses> findByCourses_name(
		String Courses_name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public Courses findByCourses_name_First(
			String Courses_name,
			com.liferay.portal.kernel.util.OrderByComparator<Courses>
				orderByComparator)
		throws NoSuchCoursesException;

	/**
	 * Returns the first courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public Courses fetchByCourses_name_First(
		String Courses_name,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

	/**
	 * Returns the last courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public Courses findByCourses_name_Last(
			String Courses_name,
			com.liferay.portal.kernel.util.OrderByComparator<Courses>
				orderByComparator)
		throws NoSuchCoursesException;

	/**
	 * Returns the last courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public Courses fetchByCourses_name_Last(
		String Courses_name,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

	/**
	 * Returns the courseses before and after the current courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param coursesId the primary key of the current courses
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next courses
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	public Courses[] findByCourses_name_PrevAndNext(
			long coursesId, String Courses_name,
			com.liferay.portal.kernel.util.OrderByComparator<Courses>
				orderByComparator)
		throws NoSuchCoursesException;

	/**
	 * Removes all the courseses where Courses_name = &#63; from the database.
	 *
	 * @param Courses_name the courses_name
	 */
	public void removeByCourses_name(String Courses_name);

	/**
	 * Returns the number of courseses where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @return the number of matching courseses
	 */
	public int countByCourses_name(String Courses_name);

	/**
	 * Caches the courses in the entity cache if it is enabled.
	 *
	 * @param courses the courses
	 */
	public void cacheResult(Courses courses);

	/**
	 * Caches the courseses in the entity cache if it is enabled.
	 *
	 * @param courseses the courseses
	 */
	public void cacheResult(java.util.List<Courses> courseses);

	/**
	 * Creates a new courses with the primary key. Does not add the courses to the database.
	 *
	 * @param coursesId the primary key for the new courses
	 * @return the new courses
	 */
	public Courses create(long coursesId);

	/**
	 * Removes the courses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coursesId the primary key of the courses
	 * @return the courses that was removed
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	public Courses remove(long coursesId) throws NoSuchCoursesException;

	public Courses updateImpl(Courses courses);

	/**
	 * Returns the courses with the primary key or throws a <code>NoSuchCoursesException</code> if it could not be found.
	 *
	 * @param coursesId the primary key of the courses
	 * @return the courses
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	public Courses findByPrimaryKey(long coursesId)
		throws NoSuchCoursesException;

	/**
	 * Returns the courses with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coursesId the primary key of the courses
	 * @return the courses, or <code>null</code> if a courses with the primary key could not be found
	 */
	public Courses fetchByPrimaryKey(long coursesId);

	/**
	 * Returns all the courseses.
	 *
	 * @return the courseses
	 */
	public java.util.List<Courses> findAll();

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
	public java.util.List<Courses> findAll(int start, int end);

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
	public java.util.List<Courses> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator);

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
	public java.util.List<Courses> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Courses>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the courseses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of courseses.
	 *
	 * @return the number of courseses
	 */
	public int countAll();

}