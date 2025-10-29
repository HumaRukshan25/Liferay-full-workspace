/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.service.persistence;

import com.ats.courses.model.Courses;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the courses service. This utility wraps <code>com.ats.courses.service.persistence.impl.CoursesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CoursesPersistence
 * @generated
 */
public class CoursesUtil {

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
	public static void clearCache(Courses courses) {
		getPersistence().clearCache(courses);
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
	public static Map<Serializable, Courses> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Courses> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Courses> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Courses> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Courses> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Courses update(Courses courses) {
		return getPersistence().update(courses);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Courses update(
		Courses courses, ServiceContext serviceContext) {

		return getPersistence().update(courses, serviceContext);
	}

	/**
	 * Returns all the courseses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching courseses
	 */
	public static List<Courses> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Courses> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Courses> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Courses> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Courses> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Courses> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first courses in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public static Courses findByUuid_First(
			String uuid, OrderByComparator<Courses> orderByComparator)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first courses in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public static Courses fetchByUuid_First(
		String uuid, OrderByComparator<Courses> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last courses in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public static Courses findByUuid_Last(
			String uuid, OrderByComparator<Courses> orderByComparator)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last courses in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public static Courses fetchByUuid_Last(
		String uuid, OrderByComparator<Courses> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Courses[] findByUuid_PrevAndNext(
			long coursesId, String uuid,
			OrderByComparator<Courses> orderByComparator)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByUuid_PrevAndNext(
			coursesId, uuid, orderByComparator);
	}

	/**
	 * Removes all the courseses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of courseses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching courseses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the courses where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCoursesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public static Courses findByUUID_G(String uuid, long groupId)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the courses where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public static Courses fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the courses where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public static Courses fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the courses where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the courses that was removed
	 */
	public static Courses removeByUUID_G(String uuid, long groupId)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of courseses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching courseses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the courseses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching courseses
	 */
	public static List<Courses> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<Courses> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<Courses> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Courses> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<Courses> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Courses> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static Courses findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Courses> orderByComparator)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first courses in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public static Courses fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Courses> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static Courses findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Courses> orderByComparator)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last courses in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public static Courses fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Courses> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static Courses[] findByUuid_C_PrevAndNext(
			long coursesId, String uuid, long companyId,
			OrderByComparator<Courses> orderByComparator)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByUuid_C_PrevAndNext(
			coursesId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the courseses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of courseses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching courseses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the courseses where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @return the matching courseses
	 */
	public static List<Courses> findByCourses_type(String Courses_type) {
		return getPersistence().findByCourses_type(Courses_type);
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
	public static List<Courses> findByCourses_type(
		String Courses_type, int start, int end) {

		return getPersistence().findByCourses_type(Courses_type, start, end);
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
	public static List<Courses> findByCourses_type(
		String Courses_type, int start, int end,
		OrderByComparator<Courses> orderByComparator) {

		return getPersistence().findByCourses_type(
			Courses_type, start, end, orderByComparator);
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
	public static List<Courses> findByCourses_type(
		String Courses_type, int start, int end,
		OrderByComparator<Courses> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCourses_type(
			Courses_type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public static Courses findByCourses_type_First(
			String Courses_type, OrderByComparator<Courses> orderByComparator)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByCourses_type_First(
			Courses_type, orderByComparator);
	}

	/**
	 * Returns the first courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public static Courses fetchByCourses_type_First(
		String Courses_type, OrderByComparator<Courses> orderByComparator) {

		return getPersistence().fetchByCourses_type_First(
			Courses_type, orderByComparator);
	}

	/**
	 * Returns the last courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public static Courses findByCourses_type_Last(
			String Courses_type, OrderByComparator<Courses> orderByComparator)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByCourses_type_Last(
			Courses_type, orderByComparator);
	}

	/**
	 * Returns the last courses in the ordered set where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public static Courses fetchByCourses_type_Last(
		String Courses_type, OrderByComparator<Courses> orderByComparator) {

		return getPersistence().fetchByCourses_type_Last(
			Courses_type, orderByComparator);
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
	public static Courses[] findByCourses_type_PrevAndNext(
			long coursesId, String Courses_type,
			OrderByComparator<Courses> orderByComparator)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByCourses_type_PrevAndNext(
			coursesId, Courses_type, orderByComparator);
	}

	/**
	 * Removes all the courseses where Courses_type = &#63; from the database.
	 *
	 * @param Courses_type the courses_type
	 */
	public static void removeByCourses_type(String Courses_type) {
		getPersistence().removeByCourses_type(Courses_type);
	}

	/**
	 * Returns the number of courseses where Courses_type = &#63;.
	 *
	 * @param Courses_type the courses_type
	 * @return the number of matching courseses
	 */
	public static int countByCourses_type(String Courses_type) {
		return getPersistence().countByCourses_type(Courses_type);
	}

	/**
	 * Returns all the courseses where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @return the matching courseses
	 */
	public static List<Courses> findByCourses_name(String Courses_name) {
		return getPersistence().findByCourses_name(Courses_name);
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
	public static List<Courses> findByCourses_name(
		String Courses_name, int start, int end) {

		return getPersistence().findByCourses_name(Courses_name, start, end);
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
	public static List<Courses> findByCourses_name(
		String Courses_name, int start, int end,
		OrderByComparator<Courses> orderByComparator) {

		return getPersistence().findByCourses_name(
			Courses_name, start, end, orderByComparator);
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
	public static List<Courses> findByCourses_name(
		String Courses_name, int start, int end,
		OrderByComparator<Courses> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCourses_name(
			Courses_name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public static Courses findByCourses_name_First(
			String Courses_name, OrderByComparator<Courses> orderByComparator)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByCourses_name_First(
			Courses_name, orderByComparator);
	}

	/**
	 * Returns the first courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public static Courses fetchByCourses_name_First(
		String Courses_name, OrderByComparator<Courses> orderByComparator) {

		return getPersistence().fetchByCourses_name_First(
			Courses_name, orderByComparator);
	}

	/**
	 * Returns the last courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses
	 * @throws NoSuchCoursesException if a matching courses could not be found
	 */
	public static Courses findByCourses_name_Last(
			String Courses_name, OrderByComparator<Courses> orderByComparator)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByCourses_name_Last(
			Courses_name, orderByComparator);
	}

	/**
	 * Returns the last courses in the ordered set where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public static Courses fetchByCourses_name_Last(
		String Courses_name, OrderByComparator<Courses> orderByComparator) {

		return getPersistence().fetchByCourses_name_Last(
			Courses_name, orderByComparator);
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
	public static Courses[] findByCourses_name_PrevAndNext(
			long coursesId, String Courses_name,
			OrderByComparator<Courses> orderByComparator)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByCourses_name_PrevAndNext(
			coursesId, Courses_name, orderByComparator);
	}

	/**
	 * Removes all the courseses where Courses_name = &#63; from the database.
	 *
	 * @param Courses_name the courses_name
	 */
	public static void removeByCourses_name(String Courses_name) {
		getPersistence().removeByCourses_name(Courses_name);
	}

	/**
	 * Returns the number of courseses where Courses_name = &#63;.
	 *
	 * @param Courses_name the courses_name
	 * @return the number of matching courseses
	 */
	public static int countByCourses_name(String Courses_name) {
		return getPersistence().countByCourses_name(Courses_name);
	}

	/**
	 * Caches the courses in the entity cache if it is enabled.
	 *
	 * @param courses the courses
	 */
	public static void cacheResult(Courses courses) {
		getPersistence().cacheResult(courses);
	}

	/**
	 * Caches the courseses in the entity cache if it is enabled.
	 *
	 * @param courseses the courseses
	 */
	public static void cacheResult(List<Courses> courseses) {
		getPersistence().cacheResult(courseses);
	}

	/**
	 * Creates a new courses with the primary key. Does not add the courses to the database.
	 *
	 * @param coursesId the primary key for the new courses
	 * @return the new courses
	 */
	public static Courses create(long coursesId) {
		return getPersistence().create(coursesId);
	}

	/**
	 * Removes the courses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coursesId the primary key of the courses
	 * @return the courses that was removed
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	public static Courses remove(long coursesId)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().remove(coursesId);
	}

	public static Courses updateImpl(Courses courses) {
		return getPersistence().updateImpl(courses);
	}

	/**
	 * Returns the courses with the primary key or throws a <code>NoSuchCoursesException</code> if it could not be found.
	 *
	 * @param coursesId the primary key of the courses
	 * @return the courses
	 * @throws NoSuchCoursesException if a courses with the primary key could not be found
	 */
	public static Courses findByPrimaryKey(long coursesId)
		throws com.ats.courses.exception.NoSuchCoursesException {

		return getPersistence().findByPrimaryKey(coursesId);
	}

	/**
	 * Returns the courses with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coursesId the primary key of the courses
	 * @return the courses, or <code>null</code> if a courses with the primary key could not be found
	 */
	public static Courses fetchByPrimaryKey(long coursesId) {
		return getPersistence().fetchByPrimaryKey(coursesId);
	}

	/**
	 * Returns all the courseses.
	 *
	 * @return the courseses
	 */
	public static List<Courses> findAll() {
		return getPersistence().findAll();
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
	public static List<Courses> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Courses> findAll(
		int start, int end, OrderByComparator<Courses> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Courses> findAll(
		int start, int end, OrderByComparator<Courses> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the courseses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of courseses.
	 *
	 * @return the number of courseses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CoursesPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CoursesPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CoursesPersistence _persistence;

}