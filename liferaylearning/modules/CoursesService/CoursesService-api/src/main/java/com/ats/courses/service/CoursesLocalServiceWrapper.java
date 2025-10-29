/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CoursesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CoursesLocalService
 * @generated
 */
public class CoursesLocalServiceWrapper
	implements CoursesLocalService, ServiceWrapper<CoursesLocalService> {

	public CoursesLocalServiceWrapper() {
		this(null);
	}

	public CoursesLocalServiceWrapper(CoursesLocalService coursesLocalService) {
		_coursesLocalService = coursesLocalService;
	}

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
	@Override
	public com.ats.courses.model.Courses addCourses(
		com.ats.courses.model.Courses courses) {

		return _coursesLocalService.addCourses(courses);
	}

	@Override
	public com.ats.courses.model.Courses addCourses(
		String Courses_name, String Courses_des, String Courses_type,
		String Courses_rating, java.io.InputStream Courses_imgStream) {

		return _coursesLocalService.addCourses(
			Courses_name, Courses_des, Courses_type, Courses_rating,
			Courses_imgStream);
	}

	@Override
	public String convertImageToBase64(java.io.InputStream inputStream)
		throws java.io.IOException {

		return _coursesLocalService.convertImageToBase64(inputStream);
	}

	/**
	 * Creates a new courses with the primary key. Does not add the courses to the database.
	 *
	 * @param coursesId the primary key for the new courses
	 * @return the new courses
	 */
	@Override
	public com.ats.courses.model.Courses createCourses(long coursesId) {
		return _coursesLocalService.createCourses(coursesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coursesLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ats.courses.model.Courses deleteCourses(
		com.ats.courses.model.Courses courses) {

		return _coursesLocalService.deleteCourses(courses);
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
	@Override
	public com.ats.courses.model.Courses deleteCourses(long coursesId)
		throws com.ats.courses.exception.NoSuchCoursesException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _coursesLocalService.deleteCourses(coursesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coursesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _coursesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _coursesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _coursesLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _coursesLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _coursesLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _coursesLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _coursesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _coursesLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ats.courses.model.Courses fetchCourses(long coursesId) {
		return _coursesLocalService.fetchCourses(coursesId);
	}

	/**
	 * Returns the courses matching the UUID and group.
	 *
	 * @param uuid the courses's UUID
	 * @param groupId the primary key of the group
	 * @return the matching courses, or <code>null</code> if a matching courses could not be found
	 */
	@Override
	public com.ats.courses.model.Courses fetchCoursesByUuidAndGroupId(
		String uuid, long groupId) {

		return _coursesLocalService.fetchCoursesByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _coursesLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ats.courses.model.Courses> GetAllCoursesTypes(
		String Courses_type) {

		return _coursesLocalService.GetAllCoursesTypes(Courses_type);
	}

	/**
	 * Returns the courses with the primary key.
	 *
	 * @param coursesId the primary key of the courses
	 * @return the courses
	 * @throws PortalException if a courses with the primary key could not be found
	 */
	@Override
	public com.ats.courses.model.Courses getCourses(long coursesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coursesLocalService.getCourses(coursesId);
	}

	/**
	 * Returns the courses matching the UUID and group.
	 *
	 * @param uuid the courses's UUID
	 * @param groupId the primary key of the group
	 * @return the matching courses
	 * @throws PortalException if a matching courses could not be found
	 */
	@Override
	public com.ats.courses.model.Courses getCoursesByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coursesLocalService.getCoursesByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.ats.courses.model.Courses> getCourseses(
		int start, int end) {

		return _coursesLocalService.getCourseses(start, end);
	}

	/**
	 * Returns all the courseses matching the UUID and company.
	 *
	 * @param uuid the UUID of the courseses
	 * @param companyId the primary key of the company
	 * @return the matching courseses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ats.courses.model.Courses>
		getCoursesesByUuidAndCompanyId(String uuid, long companyId) {

		return _coursesLocalService.getCoursesesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.ats.courses.model.Courses>
		getCoursesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ats.courses.model.Courses> orderByComparator) {

		return _coursesLocalService.getCoursesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of courseses.
	 *
	 * @return the number of courseses
	 */
	@Override
	public int getCoursesesCount() {
		return _coursesLocalService.getCoursesesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _coursesLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _coursesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _coursesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coursesLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ats.courses.model.Courses updateCourses(
		com.ats.courses.model.Courses courses) {

		return _coursesLocalService.updateCourses(courses);
	}

	@Override
	public com.ats.courses.model.Courses updateCourses(
			long coursesId, String Courses_name, String Courses_des,
			String Courses_type, String Courses_rating,
			java.io.InputStream Courses_imgStream)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coursesLocalService.updateCourses(
			coursesId, Courses_name, Courses_des, Courses_type, Courses_rating,
			Courses_imgStream);
	}

	@Override
	public com.ats.courses.model.Courses updateStatus(
		long courseId, int status) {

		return _coursesLocalService.updateStatus(courseId, status);
	}

	@Override
	public com.ats.courses.model.Courses updateStatus(
			long userId, long coursesId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coursesLocalService.updateStatus(
			userId, coursesId, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _coursesLocalService.getBasePersistence();
	}

	@Override
	public CoursesLocalService getWrappedService() {
		return _coursesLocalService;
	}

	@Override
	public void setWrappedService(CoursesLocalService coursesLocalService) {
		_coursesLocalService = coursesLocalService;
	}

	private CoursesLocalService _coursesLocalService;

}