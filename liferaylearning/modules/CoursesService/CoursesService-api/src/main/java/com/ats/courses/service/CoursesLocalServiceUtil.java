/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.service;

import com.ats.courses.model.Courses;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.InputStream;
import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Courses. This utility wraps
 * <code>com.ats.courses.service.impl.CoursesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CoursesLocalService
 * @generated
 */
public class CoursesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ats.courses.service.impl.CoursesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the courses to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CoursesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param courses the courses
	 * @return the courses that was added
	 */
	public static Courses addCourses(Courses courses) {
		return getService().addCourses(courses);
	}

	public static Courses addCourses(
		String Courses_name, String Courses_des, String Courses_type,
		String Courses_rating, InputStream Courses_imgStream) {

		return getService().addCourses(
			Courses_name, Courses_des, Courses_type, Courses_rating,
			Courses_imgStream);
	}

	public static String convertImageToBase64(InputStream inputStream)
		throws java.io.IOException {

		return getService().convertImageToBase64(inputStream);
	}

	/**
	 * Creates a new courses with the primary key. Does not add the courses to the database.
	 *
	 * @param coursesId the primary key for the new courses
	 * @return the new courses
	 */
	public static Courses createCourses(long coursesId) {
		return getService().createCourses(coursesId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the courses from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CoursesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param courses the courses
	 * @return the courses that was removed
	 */
	public static Courses deleteCourses(Courses courses) {
		return getService().deleteCourses(courses);
	}

	/**
	 * Deletes the courses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CoursesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coursesId the primary key of the courses
	 * @return the courses that was removed
	 * @throws NoSuchCoursesException
	 * @throws PortalException if a courses with the primary key could not be found
	 */
	public static Courses deleteCourses(long coursesId)
		throws com.ats.courses.exception.NoSuchCoursesException,
			   PortalException {

		return getService().deleteCourses(coursesId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ats.courses.model.impl.CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ats.courses.model.impl.CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Courses fetchCourses(long coursesId) {
		return getService().fetchCourses(coursesId);
	}

	/**
	 * Returns the courses matching the UUID and group.
	 *
	 * @param uuid the courses's UUID
	 * @param groupId the primary key of the group
	 * @return the matching courses, or <code>null</code> if a matching courses could not be found
	 */
	public static Courses fetchCoursesByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCoursesByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Courses> GetAllCoursesTypes(String Courses_type) {
		return getService().GetAllCoursesTypes(Courses_type);
	}

	/**
	 * Returns the courses with the primary key.
	 *
	 * @param coursesId the primary key of the courses
	 * @return the courses
	 * @throws PortalException if a courses with the primary key could not be found
	 */
	public static Courses getCourses(long coursesId) throws PortalException {
		return getService().getCourses(coursesId);
	}

	/**
	 * Returns the courses matching the UUID and group.
	 *
	 * @param uuid the courses's UUID
	 * @param groupId the primary key of the group
	 * @return the matching courses
	 * @throws PortalException if a matching courses could not be found
	 */
	public static Courses getCoursesByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getCoursesByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the courseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ats.courses.model.impl.CoursesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @return the range of courseses
	 */
	public static List<Courses> getCourseses(int start, int end) {
		return getService().getCourseses(start, end);
	}

	/**
	 * Returns all the courseses matching the UUID and company.
	 *
	 * @param uuid the UUID of the courseses
	 * @param companyId the primary key of the company
	 * @return the matching courseses, or an empty list if no matches were found
	 */
	public static List<Courses> getCoursesesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCoursesesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of courseses matching the UUID and company.
	 *
	 * @param uuid the UUID of the courseses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of courseses
	 * @param end the upper bound of the range of courseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching courseses, or an empty list if no matches were found
	 */
	public static List<Courses> getCoursesesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Courses> orderByComparator) {

		return getService().getCoursesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of courseses.
	 *
	 * @return the number of courseses
	 */
	public static int getCoursesesCount() {
		return getService().getCoursesesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the courses in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CoursesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param courses the courses
	 * @return the courses that was updated
	 */
	public static Courses updateCourses(Courses courses) {
		return getService().updateCourses(courses);
	}

	public static Courses updateCourses(
			long coursesId, String Courses_name, String Courses_des,
			String Courses_type, String Courses_rating,
			InputStream Courses_imgStream)
		throws PortalException {

		return getService().updateCourses(
			coursesId, Courses_name, Courses_des, Courses_type, Courses_rating,
			Courses_imgStream);
	}

	public static Courses updateStatus(long courseId, int status) {
		return getService().updateStatus(courseId, status);
	}

	public static Courses updateStatus(
			long userId, long coursesId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateStatus(
			userId, coursesId, status, serviceContext);
	}

	public static CoursesLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<CoursesLocalService> _serviceSnapshot =
		new Snapshot<>(
			CoursesLocalServiceUtil.class, CoursesLocalService.class);

}