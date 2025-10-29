/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link FIRRRLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FIRRRLocalService
 * @generated
 */
public class FIRRRLocalServiceWrapper
	implements FIRRRLocalService, ServiceWrapper<FIRRRLocalService> {

	public FIRRRLocalServiceWrapper() {
		this(null);
	}

	public FIRRRLocalServiceWrapper(FIRRRLocalService firrrLocalService) {
		_firrrLocalService = firrrLocalService;
	}

	/**
	 * Adds the firrr to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FIRRRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param firrr the firrr
	 * @return the firrr that was added
	 */
	@Override
	public fironlineser.model.FIRRR addFIRRR(fironlineser.model.FIRRR firrr) {
		return _firrrLocalService.addFIRRR(firrr);
	}

	@Override
	public fironlineser.model.FIRRR createFIR(
			long userId, String complainantName, java.util.Date incidentDate,
			String incidentDetails, String incidentLocation, String status,
			String proofFileName, String proofFilePath)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _firrrLocalService.createFIR(
			userId, complainantName, incidentDate, incidentDetails,
			incidentLocation, status, proofFileName, proofFilePath);
	}

	/**
	 * Creates a new firrr with the primary key. Does not add the firrr to the database.
	 *
	 * @param firId the primary key for the new firrr
	 * @return the new firrr
	 */
	@Override
	public fironlineser.model.FIRRR createFIRRR(long firId) {
		return _firrrLocalService.createFIRRR(firId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _firrrLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the firrr from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FIRRRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param firrr the firrr
	 * @return the firrr that was removed
	 */
	@Override
	public fironlineser.model.FIRRR deleteFIRRR(
		fironlineser.model.FIRRR firrr) {

		return _firrrLocalService.deleteFIRRR(firrr);
	}

	/**
	 * Deletes the firrr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FIRRRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param firId the primary key of the firrr
	 * @return the firrr that was removed
	 * @throws PortalException if a firrr with the primary key could not be found
	 */
	@Override
	public fironlineser.model.FIRRR deleteFIRRR(long firId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _firrrLocalService.deleteFIRRR(firId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _firrrLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _firrrLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _firrrLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _firrrLocalService.dynamicQuery();
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

		return _firrrLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>fironlineser.model.impl.FIRRRModelImpl</code>.
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

		return _firrrLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>fironlineser.model.impl.FIRRRModelImpl</code>.
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

		return _firrrLocalService.dynamicQuery(
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

		return _firrrLocalService.dynamicQueryCount(dynamicQuery);
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

		return _firrrLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public fironlineser.model.FIRRR fetchFIRRR(long firId) {
		return _firrrLocalService.fetchFIRRR(firId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _firrrLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the firrr with the primary key.
	 *
	 * @param firId the primary key of the firrr
	 * @return the firrr
	 * @throws PortalException if a firrr with the primary key could not be found
	 */
	@Override
	public fironlineser.model.FIRRR getFIRRR(long firId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _firrrLocalService.getFIRRR(firId);
	}

	/**
	 * Returns a range of all the firrrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>fironlineser.model.impl.FIRRRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of firrrs
	 * @param end the upper bound of the range of firrrs (not inclusive)
	 * @return the range of firrrs
	 */
	@Override
	public java.util.List<fironlineser.model.FIRRR> getFIRRRs(
		int start, int end) {

		return _firrrLocalService.getFIRRRs(start, end);
	}

	/**
	 * Returns the number of firrrs.
	 *
	 * @return the number of firrrs
	 */
	@Override
	public int getFIRRRsCount() {
		return _firrrLocalService.getFIRRRsCount();
	}

	@Override
	public java.util.List<fironlineser.model.FIRRR> getFIRsByUserId(
		long userId) {

		return _firrrLocalService.getFIRsByUserId(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _firrrLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _firrrLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _firrrLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the firrr in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FIRRRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param firrr the firrr
	 * @return the firrr that was updated
	 */
	@Override
	public fironlineser.model.FIRRR updateFIRRR(
		fironlineser.model.FIRRR firrr) {

		return _firrrLocalService.updateFIRRR(firrr);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _firrrLocalService.getBasePersistence();
	}

	@Override
	public FIRRRLocalService getWrappedService() {
		return _firrrLocalService;
	}

	@Override
	public void setWrappedService(FIRRRLocalService firrrLocalService) {
		_firrrLocalService = firrrLocalService;
	}

	private FIRRRLocalService _firrrLocalService;

}