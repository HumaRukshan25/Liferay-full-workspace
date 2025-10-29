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

import fironlineser.exception.NoSuchFIRException;

import fironlineser.model.FIR;

import fironlineser.service.FIRLocalServiceUtil;
import fironlineser.service.persistence.FIRPersistence;
import fironlineser.service.persistence.FIRUtil;

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
public class FIRPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "fironlineser.service"));

	@Before
	public void setUp() {
		_persistence = FIRUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<FIR> iterator = _firs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FIR fir = _persistence.create(pk);

		Assert.assertNotNull(fir);

		Assert.assertEquals(fir.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		FIR newFIR = addFIR();

		_persistence.remove(newFIR);

		FIR existingFIR = _persistence.fetchByPrimaryKey(
			newFIR.getPrimaryKey());

		Assert.assertNull(existingFIR);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addFIR();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FIR newFIR = _persistence.create(pk);

		newFIR.setUuid(RandomTestUtil.randomString());

		newFIR.setComplainantName(RandomTestUtil.randomString());

		newFIR.setIncidentDate(RandomTestUtil.nextDate());

		newFIR.setIncidentDetails(RandomTestUtil.randomString());

		newFIR.setStatus(RandomTestUtil.randomString());

		newFIR.setTimeline(RandomTestUtil.randomString());

		newFIR.setModificationDetails(RandomTestUtil.randomString());

		newFIR.setUserId(RandomTestUtil.nextLong());

		newFIR.setCreateDate(RandomTestUtil.nextDate());

		newFIR.setModifiedDate(RandomTestUtil.nextDate());

		_firs.add(_persistence.update(newFIR));

		FIR existingFIR = _persistence.findByPrimaryKey(newFIR.getPrimaryKey());

		Assert.assertEquals(existingFIR.getUuid(), newFIR.getUuid());
		Assert.assertEquals(existingFIR.getFirId(), newFIR.getFirId());
		Assert.assertEquals(
			existingFIR.getComplainantName(), newFIR.getComplainantName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingFIR.getIncidentDate()),
			Time.getShortTimestamp(newFIR.getIncidentDate()));
		Assert.assertEquals(
			existingFIR.getIncidentDetails(), newFIR.getIncidentDetails());
		Assert.assertEquals(existingFIR.getStatus(), newFIR.getStatus());
		Assert.assertEquals(existingFIR.getTimeline(), newFIR.getTimeline());
		Assert.assertEquals(
			existingFIR.getModificationDetails(),
			newFIR.getModificationDetails());
		Assert.assertEquals(existingFIR.getUserId(), newFIR.getUserId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingFIR.getCreateDate()),
			Time.getShortTimestamp(newFIR.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingFIR.getModifiedDate()),
			Time.getShortTimestamp(newFIR.getModifiedDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUserId() throws Exception {
		_persistence.countByUserId(RandomTestUtil.nextLong());

		_persistence.countByUserId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		FIR newFIR = addFIR();

		FIR existingFIR = _persistence.findByPrimaryKey(newFIR.getPrimaryKey());

		Assert.assertEquals(existingFIR, newFIR);
	}

	@Test(expected = NoSuchFIRException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<FIR> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"FIRFOO_FIR", "uuid", true, "firId", true, "complainantName", true,
			"incidentDate", true, "incidentDetails", true, "status", true,
			"timeline", true, "modificationDetails", true, "userId", true,
			"createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		FIR newFIR = addFIR();

		FIR existingFIR = _persistence.fetchByPrimaryKey(
			newFIR.getPrimaryKey());

		Assert.assertEquals(existingFIR, newFIR);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FIR missingFIR = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingFIR);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		FIR newFIR1 = addFIR();
		FIR newFIR2 = addFIR();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFIR1.getPrimaryKey());
		primaryKeys.add(newFIR2.getPrimaryKey());

		Map<Serializable, FIR> firs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, firs.size());
		Assert.assertEquals(newFIR1, firs.get(newFIR1.getPrimaryKey()));
		Assert.assertEquals(newFIR2, firs.get(newFIR2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, FIR> firs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(firs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		FIR newFIR = addFIR();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFIR.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, FIR> firs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, firs.size());
		Assert.assertEquals(newFIR, firs.get(newFIR.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, FIR> firs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(firs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		FIR newFIR = addFIR();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFIR.getPrimaryKey());

		Map<Serializable, FIR> firs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, firs.size());
		Assert.assertEquals(newFIR, firs.get(newFIR.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			FIRLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<FIR>() {

				@Override
				public void performAction(FIR fir) {
					Assert.assertNotNull(fir);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		FIR newFIR = addFIR();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			FIR.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("firId", newFIR.getFirId()));

		List<FIR> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		FIR existingFIR = result.get(0);

		Assert.assertEquals(existingFIR, newFIR);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			FIR.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("firId", RandomTestUtil.nextLong()));

		List<FIR> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		FIR newFIR = addFIR();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			FIR.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("firId"));

		Object newFirId = newFIR.getFirId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("firId", new Object[] {newFirId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFirId = result.get(0);

		Assert.assertEquals(existingFirId, newFirId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			FIR.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("firId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"firId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected FIR addFIR() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FIR fir = _persistence.create(pk);

		fir.setUuid(RandomTestUtil.randomString());

		fir.setComplainantName(RandomTestUtil.randomString());

		fir.setIncidentDate(RandomTestUtil.nextDate());

		fir.setIncidentDetails(RandomTestUtil.randomString());

		fir.setStatus(RandomTestUtil.randomString());

		fir.setTimeline(RandomTestUtil.randomString());

		fir.setModificationDetails(RandomTestUtil.randomString());

		fir.setUserId(RandomTestUtil.nextLong());

		fir.setCreateDate(RandomTestUtil.nextDate());

		fir.setModifiedDate(RandomTestUtil.nextDate());

		_firs.add(_persistence.update(fir));

		return fir;
	}

	private List<FIR> _firs = new ArrayList<FIR>();
	private FIRPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}