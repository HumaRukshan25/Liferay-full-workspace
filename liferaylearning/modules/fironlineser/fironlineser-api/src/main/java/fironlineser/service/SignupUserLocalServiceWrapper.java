/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SignupUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SignupUserLocalService
 * @generated
 */
public class SignupUserLocalServiceWrapper
	implements ServiceWrapper<SignupUserLocalService>, SignupUserLocalService {

	public SignupUserLocalServiceWrapper() {
		this(null);
	}

	public SignupUserLocalServiceWrapper(
		SignupUserLocalService signupUserLocalService) {

		_signupUserLocalService = signupUserLocalService;
	}

	/**
	 * Adds the signup user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignupUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signupUser the signup user
	 * @return the signup user that was added
	 */
	@Override
	public fironlineser.model.SignupUser addSignupUser(
		fironlineser.model.SignupUser signupUser) {

		return _signupUserLocalService.addSignupUser(signupUser);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signupUserLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new signup user with the primary key. Does not add the signup user to the database.
	 *
	 * @param signupUserId the primary key for the new signup user
	 * @return the new signup user
	 */
	@Override
	public fironlineser.model.SignupUser createSignupUser(long signupUserId) {
		return _signupUserLocalService.createSignupUser(signupUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signupUserLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the signup user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignupUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signupUserId the primary key of the signup user
	 * @return the signup user that was removed
	 * @throws PortalException if a signup user with the primary key could not be found
	 */
	@Override
	public fironlineser.model.SignupUser deleteSignupUser(long signupUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signupUserLocalService.deleteSignupUser(signupUserId);
	}

	/**
	 * Deletes the signup user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignupUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signupUser the signup user
	 * @return the signup user that was removed
	 */
	@Override
	public fironlineser.model.SignupUser deleteSignupUser(
		fironlineser.model.SignupUser signupUser) {

		return _signupUserLocalService.deleteSignupUser(signupUser);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _signupUserLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _signupUserLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _signupUserLocalService.dynamicQuery();
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

		return _signupUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>fironlineser.model.impl.SignupUserModelImpl</code>.
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

		return _signupUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>fironlineser.model.impl.SignupUserModelImpl</code>.
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

		return _signupUserLocalService.dynamicQuery(
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

		return _signupUserLocalService.dynamicQueryCount(dynamicQuery);
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

		return _signupUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public fironlineser.model.SignupUser fetchSignupUser(long signupUserId) {
		return _signupUserLocalService.fetchSignupUser(signupUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _signupUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _signupUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _signupUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signupUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the signup user with the primary key.
	 *
	 * @param signupUserId the primary key of the signup user
	 * @return the signup user
	 * @throws PortalException if a signup user with the primary key could not be found
	 */
	@Override
	public fironlineser.model.SignupUser getSignupUser(long signupUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signupUserLocalService.getSignupUser(signupUserId);
	}

	/**
	 * Returns a range of all the signup users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>fironlineser.model.impl.SignupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signup users
	 * @param end the upper bound of the range of signup users (not inclusive)
	 * @return the range of signup users
	 */
	@Override
	public java.util.List<fironlineser.model.SignupUser> getSignupUsers(
		int start, int end) {

		return _signupUserLocalService.getSignupUsers(start, end);
	}

	/**
	 * Returns the number of signup users.
	 *
	 * @return the number of signup users
	 */
	@Override
	public int getSignupUsersCount() {
		return _signupUserLocalService.getSignupUsersCount();
	}

	/**
	 * Updates the signup user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignupUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signupUser the signup user
	 * @return the signup user that was updated
	 */
	@Override
	public fironlineser.model.SignupUser updateSignupUser(
		fironlineser.model.SignupUser signupUser) {

		return _signupUserLocalService.updateSignupUser(signupUser);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _signupUserLocalService.getBasePersistence();
	}

	@Override
	public SignupUserLocalService getWrappedService() {
		return _signupUserLocalService;
	}

	@Override
	public void setWrappedService(
		SignupUserLocalService signupUserLocalService) {

		_signupUserLocalService = signupUserLocalService;
	}

	private SignupUserLocalService _signupUserLocalService;

}