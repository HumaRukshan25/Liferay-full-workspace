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

import fironlineser.exception.NoSuchFIRRRException;

import fironlineser.model.FIRRR;

import fironlineser.service.FIRRRLocalServiceUtil;
import fironlineser.service.persistence.FIRRRPersistence;
import fironlineser.service.persistence.FIRRRUtil;

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
public class FIRRRPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "fironlineser.service"));

	@Before
	public void setUp() {
		_persistence = FIRRRUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<FIRRR> iterator = _firrrs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FIRRR firrr = _persistence.create(pk);

		Assert.assertNotNull(firrr);

		Assert.assertEquals(firrr.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		FIRRR newFIRRR = addFIRRR();

		_persistence.remove(newFIRRR);

		FIRRR existingFIRRR = _persistence.fetchByPrimaryKey(
			newFIRRR.getPrimaryKey());

		Assert.assertNull(existingFIRRR);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addFIRRR();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FIRRR newFIRRR = _persistence.create(pk);

		newFIRRR.setUuid(RandomTestUtil.randomString());

		newFIRRR.setComplainantName(RandomTestUtil.randomString());

		newFIRRR.setIncidentDate(RandomTestUtil.nextDate());

		newFIRRR.setIncidentDetails(RandomTestUtil.randomString());

		newFIRRR.setIncidentLocation(RandomTestUtil.randomString());

		newFIRRR.setStatus(RandomTestUtil.randomString());

		newFIRRR.setTimeline(RandomTestUtil.randomString());

		newFIRRR.setModificationDetails(RandomTestUtil.randomString());

		newFIRRR.setAssignedInspector(RandomTestUtil.randomString());

		newFIRRR.setProofFileName(RandomTestUtil.randomString());

		newFIRRR.setProofFilePath(RandomTestUtil.randomString());

		newFIRRR.setUserId(RandomTestUtil.nextLong());

		newFIRRR.setCreateDate(RandomTestUtil.nextDate());

		newFIRRR.setModifiedDate(RandomTestUtil.nextDate());

		_firrrs.add(_persistence.update(newFIRRR));

		FIRRR existingFIRRR = _persistence.findByPrimaryKey(
			newFIRRR.getPrimaryKey());

		Assert.assertEquals(existingFIRRR.getUuid(), newFIRRR.getUuid());
		Assert.assertEquals(existingFIRRR.getFirId(), newFIRRR.getFirId());
		Assert.assertEquals(
			existingFIRRR.getComplainantName(), newFIRRR.getComplainantName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingFIRRR.getIncidentDate()),
			Time.getShortTimestamp(newFIRRR.getIncidentDate()));
		Assert.assertEquals(
			existingFIRRR.getIncidentDetails(), newFIRRR.getIncidentDetails());
		Assert.assertEquals(
			existingFIRRR.getIncidentLocation(),
			newFIRRR.getIncidentLocation());
		Assert.assertEquals(existingFIRRR.getStatus(), newFIRRR.getStatus());
		Assert.assertEquals(
			existingFIRRR.getTimeline(), newFIRRR.getTimeline());
		Assert.assertEquals(
			existingFIRRR.getModificationDetails(),
			newFIRRR.getModificationDetails());
		Assert.assertEquals(
			existingFIRRR.getAssignedInspector(),
			newFIRRR.getAssignedInspector());
		Assert.assertEquals(
			existingFIRRR.getProofFileName(), newFIRRR.getProofFileName());
		Assert.assertEquals(
			existingFIRRR.getProofFilePath(), newFIRRR.getProofFilePath());
		Assert.assertEquals(existingFIRRR.getUserId(), newFIRRR.getUserId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingFIRRR.getCreateDate()),
			Time.getShortTimestamp(newFIRRR.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingFIRRR.getModifiedDate()),
			Time.getShortTimestamp(newFIRRR.getModifiedDate()));
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
		FIRRR newFIRRR = addFIRRR();

		FIRRR existingFIRRR = _persistence.findByPrimaryKey(
			newFIRRR.getPrimaryKey());

		Assert.assertEquals(existingFIRRR, newFIRRR);
	}

	@Test(expected = NoSuchFIRRRException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<FIRRR> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"FIRFOO_FIRRR", "uuid", true, "firId", true, "complainantName",
			true, "incidentDate", true, "incidentDetails", true,
			"incidentLocation", true, "status", true, "timeline", true,
			"modificationDetails", true, "assignedInspector", true,
			"proofFileName", true, "proofFilePath", true, "userId", true,
			"createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		FIRRR newFIRRR = addFIRRR();

		FIRRR existingFIRRR = _persistence.fetchByPrimaryKey(
			newFIRRR.getPrimaryKey());

		Assert.assertEquals(existingFIRRR, newFIRRR);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FIRRR missingFIRRR = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingFIRRR);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		FIRRR newFIRRR1 = addFIRRR();
		FIRRR newFIRRR2 = addFIRRR();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFIRRR1.getPrimaryKey());
		primaryKeys.add(newFIRRR2.getPrimaryKey());

		Map<Serializable, FIRRR> firrrs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, firrrs.size());
		Assert.assertEquals(newFIRRR1, firrrs.get(newFIRRR1.getPrimaryKey()));
		Assert.assertEquals(newFIRRR2, firrrs.get(newFIRRR2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, FIRRR> firrrs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(firrrs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		FIRRR newFIRRR = addFIRRR();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFIRRR.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, FIRRR> firrrs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, firrrs.size());
		Assert.assertEquals(newFIRRR, firrrs.get(newFIRRR.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, FIRRR> firrrs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(firrrs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		FIRRR newFIRRR = addFIRRR();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFIRRR.getPrimaryKey());

		Map<Serializable, FIRRR> firrrs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, firrrs.size());
		Assert.assertEquals(newFIRRR, firrrs.get(newFIRRR.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			FIRRRLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<FIRRR>() {

				@Override
				public void performAction(FIRRR firrr) {
					Assert.assertNotNull(firrr);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		FIRRR newFIRRR = addFIRRR();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			FIRRR.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("firId", newFIRRR.getFirId()));

		List<FIRRR> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		FIRRR existingFIRRR = result.get(0);

		Assert.assertEquals(existingFIRRR, newFIRRR);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			FIRRR.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("firId", RandomTestUtil.nextLong()));

		List<FIRRR> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		FIRRR newFIRRR = addFIRRR();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			FIRRR.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("firId"));

		Object newFirId = newFIRRR.getFirId();

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
			FIRRR.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("firId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"firId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected FIRRR addFIRRR() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FIRRR firrr = _persistence.create(pk);

		firrr.setUuid(RandomTestUtil.randomString());

		firrr.setComplainantName(RandomTestUtil.randomString());

		firrr.setIncidentDate(RandomTestUtil.nextDate());

		firrr.setIncidentDetails(RandomTestUtil.randomString());

		firrr.setIncidentLocation(RandomTestUtil.randomString());

		firrr.setStatus(RandomTestUtil.randomString());

		firrr.setTimeline(RandomTestUtil.randomString());

		firrr.setModificationDetails(RandomTestUtil.randomString());

		firrr.setAssignedInspector(RandomTestUtil.randomString());

		firrr.setProofFileName(RandomTestUtil.randomString());

		firrr.setProofFilePath(RandomTestUtil.randomString());

		firrr.setUserId(RandomTestUtil.nextLong());

		firrr.setCreateDate(RandomTestUtil.nextDate());

		firrr.setModifiedDate(RandomTestUtil.nextDate());

		_firrrs.add(_persistence.update(firrr));

		return firrr;
	}

	private List<FIRRR> _firrrs = new ArrayList<FIRRR>();
	private FIRRRPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}