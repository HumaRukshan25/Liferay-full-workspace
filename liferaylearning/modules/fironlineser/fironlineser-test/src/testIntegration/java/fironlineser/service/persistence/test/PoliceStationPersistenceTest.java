/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import fironlineser.exception.NoSuchPoliceStationException;

import fironlineser.model.PoliceStation;

import fironlineser.service.PoliceStationLocalServiceUtil;
import fironlineser.service.persistence.PoliceStationPersistence;
import fironlineser.service.persistence.PoliceStationUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class PoliceStationPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "fironlineser.service"));

	@Before
	public void setUp() {
		_persistence = PoliceStationUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<PoliceStation> iterator = _policeStations.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PoliceStation policeStation = _persistence.create(pk);

		Assert.assertNotNull(policeStation);

		Assert.assertEquals(policeStation.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		PoliceStation newPoliceStation = addPoliceStation();

		_persistence.remove(newPoliceStation);

		PoliceStation existingPoliceStation = _persistence.fetchByPrimaryKey(
			newPoliceStation.getPrimaryKey());

		Assert.assertNull(existingPoliceStation);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPoliceStation();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PoliceStation newPoliceStation = _persistence.create(pk);

		newPoliceStation.setUuid(RandomTestUtil.randomString());

		newPoliceStation.setStationName(RandomTestUtil.randomString());

		newPoliceStation.setAddress(RandomTestUtil.randomString());

		newPoliceStation.setJurisdictionArea(RandomTestUtil.randomString());

		newPoliceStation.setOfficerInCharge(RandomTestUtil.randomString());

		newPoliceStation.setContactNumber(RandomTestUtil.randomString());

		newPoliceStation.setEmail(RandomTestUtil.randomString());

		newPoliceStation.setStatus(RandomTestUtil.randomString());

		newPoliceStation.setUserId(RandomTestUtil.nextLong());

		newPoliceStation.setUserName(RandomTestUtil.randomString());

		newPoliceStation.setCreateDate(RandomTestUtil.nextDate());

		newPoliceStation.setModifiedDate(RandomTestUtil.nextDate());

		_policeStations.add(_persistence.update(newPoliceStation));

		PoliceStation existingPoliceStation = _persistence.findByPrimaryKey(
			newPoliceStation.getPrimaryKey());

		Assert.assertEquals(
			existingPoliceStation.getUuid(), newPoliceStation.getUuid());
		Assert.assertEquals(
			existingPoliceStation.getStationId(),
			newPoliceStation.getStationId());
		Assert.assertEquals(
			existingPoliceStation.getStationName(),
			newPoliceStation.getStationName());
		Assert.assertEquals(
			existingPoliceStation.getAddress(), newPoliceStation.getAddress());
		Assert.assertEquals(
			existingPoliceStation.getJurisdictionArea(),
			newPoliceStation.getJurisdictionArea());
		Assert.assertEquals(
			existingPoliceStation.getOfficerInCharge(),
			newPoliceStation.getOfficerInCharge());
		Assert.assertEquals(
			existingPoliceStation.getContactNumber(),
			newPoliceStation.getContactNumber());
		Assert.assertEquals(
			existingPoliceStation.getEmail(), newPoliceStation.getEmail());
		Assert.assertEquals(
			existingPoliceStation.getStatus(), newPoliceStation.getStatus());
		Assert.assertEquals(
			existingPoliceStation.getUserId(), newPoliceStation.getUserId());
		Assert.assertEquals(
			existingPoliceStation.getUserName(),
			newPoliceStation.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPoliceStation.getCreateDate()),
			Time.getShortTimestamp(newPoliceStation.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingPoliceStation.getModifiedDate()),
			Time.getShortTimestamp(newPoliceStation.getModifiedDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByJurisdiction() throws Exception {
		_persistence.countByJurisdiction("");

		_persistence.countByJurisdiction("null");

		_persistence.countByJurisdiction((String)null);
	}

	@Test
	public void testCountByStationName() throws Exception {
		_persistence.countByStationName("");

		_persistence.countByStationName("null");

		_persistence.countByStationName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		PoliceStation newPoliceStation = addPoliceStation();

		PoliceStation existingPoliceStation = _persistence.findByPrimaryKey(
			newPoliceStation.getPrimaryKey());

		Assert.assertEquals(existingPoliceStation, newPoliceStation);
	}

	@Test(expected = NoSuchPoliceStationException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<PoliceStation> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"FIRFOO_PoliceStation", "uuid", true, "stationId", true,
			"stationName", true, "address", true, "jurisdictionArea", true,
			"officerInCharge", true, "contactNumber", true, "email", true,
			"status", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		PoliceStation newPoliceStation = addPoliceStation();

		PoliceStation existingPoliceStation = _persistence.fetchByPrimaryKey(
			newPoliceStation.getPrimaryKey());

		Assert.assertEquals(existingPoliceStation, newPoliceStation);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PoliceStation missingPoliceStation = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPoliceStation);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		PoliceStation newPoliceStation1 = addPoliceStation();
		PoliceStation newPoliceStation2 = addPoliceStation();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPoliceStation1.getPrimaryKey());
		primaryKeys.add(newPoliceStation2.getPrimaryKey());

		Map<Serializable, PoliceStation> policeStations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, policeStations.size());
		Assert.assertEquals(
			newPoliceStation1,
			policeStations.get(newPoliceStation1.getPrimaryKey()));
		Assert.assertEquals(
			newPoliceStation2,
			policeStations.get(newPoliceStation2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, PoliceStation> policeStations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(policeStations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		PoliceStation newPoliceStation = addPoliceStation();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPoliceStation.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, PoliceStation> policeStations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, policeStations.size());
		Assert.assertEquals(
			newPoliceStation,
			policeStations.get(newPoliceStation.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, PoliceStation> policeStations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(policeStations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		PoliceStation newPoliceStation = addPoliceStation();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPoliceStation.getPrimaryKey());

		Map<Serializable, PoliceStation> policeStations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, policeStations.size());
		Assert.assertEquals(
			newPoliceStation,
			policeStations.get(newPoliceStation.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PoliceStationLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<PoliceStation>() {

				@Override
				public void performAction(PoliceStation policeStation) {
					Assert.assertNotNull(policeStation);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		PoliceStation newPoliceStation = addPoliceStation();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PoliceStation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"stationId", newPoliceStation.getStationId()));

		List<PoliceStation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		PoliceStation existingPoliceStation = result.get(0);

		Assert.assertEquals(existingPoliceStation, newPoliceStation);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PoliceStation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("stationId", RandomTestUtil.nextLong()));

		List<PoliceStation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		PoliceStation newPoliceStation = addPoliceStation();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PoliceStation.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("stationId"));

		Object newStationId = newPoliceStation.getStationId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"stationId", new Object[] {newStationId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingStationId = result.get(0);

		Assert.assertEquals(existingStationId, newStationId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PoliceStation.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("stationId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"stationId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected PoliceStation addPoliceStation() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PoliceStation policeStation = _persistence.create(pk);

		policeStation.setUuid(RandomTestUtil.randomString());

		policeStation.setStationName(RandomTestUtil.randomString());

		policeStation.setAddress(RandomTestUtil.randomString());

		policeStation.setJurisdictionArea(RandomTestUtil.randomString());

		policeStation.setOfficerInCharge(RandomTestUtil.randomString());

		policeStation.setContactNumber(RandomTestUtil.randomString());

		policeStation.setEmail(RandomTestUtil.randomString());

		policeStation.setStatus(RandomTestUtil.randomString());

		policeStation.setUserId(RandomTestUtil.nextLong());

		policeStation.setUserName(RandomTestUtil.randomString());

		policeStation.setCreateDate(RandomTestUtil.nextDate());

		policeStation.setModifiedDate(RandomTestUtil.nextDate());

		_policeStations.add(_persistence.update(policeStation));

		return policeStation;
	}

	private List<PoliceStation> _policeStations =
		new ArrayList<PoliceStation>();
	private PoliceStationPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}