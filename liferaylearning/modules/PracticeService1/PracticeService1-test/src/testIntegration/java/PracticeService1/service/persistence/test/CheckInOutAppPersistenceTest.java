/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.service.persistence.test;

import PracticeService1.exception.NoSuchCheckInOutAppException;

import PracticeService1.model.CheckInOutApp;

import PracticeService1.service.CheckInOutAppLocalServiceUtil;
import PracticeService1.service.persistence.CheckInOutAppPersistence;
import PracticeService1.service.persistence.CheckInOutAppUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
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
public class CheckInOutAppPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "PracticeService1.service"));

	@Before
	public void setUp() {
		_persistence = CheckInOutAppUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CheckInOutApp> iterator = _checkInOutApps.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CheckInOutApp checkInOutApp = _persistence.create(pk);

		Assert.assertNotNull(checkInOutApp);

		Assert.assertEquals(checkInOutApp.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CheckInOutApp newCheckInOutApp = addCheckInOutApp();

		_persistence.remove(newCheckInOutApp);

		CheckInOutApp existingCheckInOutApp = _persistence.fetchByPrimaryKey(
			newCheckInOutApp.getPrimaryKey());

		Assert.assertNull(existingCheckInOutApp);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCheckInOutApp();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CheckInOutApp newCheckInOutApp = _persistence.create(pk);

		newCheckInOutApp.setUuid(RandomTestUtil.randomString());

		newCheckInOutApp.setGroupId(RandomTestUtil.nextLong());

		newCheckInOutApp.setCompanyId(RandomTestUtil.nextLong());

		newCheckInOutApp.setUserId(RandomTestUtil.nextLong());

		newCheckInOutApp.setUserName(RandomTestUtil.randomString());

		newCheckInOutApp.setCreateDate(RandomTestUtil.nextDate());

		newCheckInOutApp.setModifiedDate(RandomTestUtil.nextDate());

		newCheckInOutApp.setCheckInTime(RandomTestUtil.nextDate());

		newCheckInOutApp.setCheckOutTime(RandomTestUtil.nextDate());

		newCheckInOutApp.setRemarks(RandomTestUtil.randomString());

		newCheckInOutApp.setLocation(RandomTestUtil.randomString());

		_checkInOutApps.add(_persistence.update(newCheckInOutApp));

		CheckInOutApp existingCheckInOutApp = _persistence.findByPrimaryKey(
			newCheckInOutApp.getPrimaryKey());

		Assert.assertEquals(
			existingCheckInOutApp.getUuid(), newCheckInOutApp.getUuid());
		Assert.assertEquals(
			existingCheckInOutApp.getLogId(), newCheckInOutApp.getLogId());
		Assert.assertEquals(
			existingCheckInOutApp.getGroupId(), newCheckInOutApp.getGroupId());
		Assert.assertEquals(
			existingCheckInOutApp.getCompanyId(),
			newCheckInOutApp.getCompanyId());
		Assert.assertEquals(
			existingCheckInOutApp.getUserId(), newCheckInOutApp.getUserId());
		Assert.assertEquals(
			existingCheckInOutApp.getUserName(),
			newCheckInOutApp.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCheckInOutApp.getCreateDate()),
			Time.getShortTimestamp(newCheckInOutApp.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCheckInOutApp.getModifiedDate()),
			Time.getShortTimestamp(newCheckInOutApp.getModifiedDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCheckInOutApp.getCheckInTime()),
			Time.getShortTimestamp(newCheckInOutApp.getCheckInTime()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCheckInOutApp.getCheckOutTime()),
			Time.getShortTimestamp(newCheckInOutApp.getCheckOutTime()));
		Assert.assertEquals(
			existingCheckInOutApp.getRemarks(), newCheckInOutApp.getRemarks());
		Assert.assertEquals(
			existingCheckInOutApp.getLocation(),
			newCheckInOutApp.getLocation());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CheckInOutApp newCheckInOutApp = addCheckInOutApp();

		CheckInOutApp existingCheckInOutApp = _persistence.findByPrimaryKey(
			newCheckInOutApp.getPrimaryKey());

		Assert.assertEquals(existingCheckInOutApp, newCheckInOutApp);
	}

	@Test(expected = NoSuchCheckInOutAppException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CheckInOutApp> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ATS_CheckInOutApp", "uuid", true, "logId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "checkInTime", true, "checkOutTime",
			true, "remarks", true, "location", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CheckInOutApp newCheckInOutApp = addCheckInOutApp();

		CheckInOutApp existingCheckInOutApp = _persistence.fetchByPrimaryKey(
			newCheckInOutApp.getPrimaryKey());

		Assert.assertEquals(existingCheckInOutApp, newCheckInOutApp);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CheckInOutApp missingCheckInOutApp = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCheckInOutApp);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CheckInOutApp newCheckInOutApp1 = addCheckInOutApp();
		CheckInOutApp newCheckInOutApp2 = addCheckInOutApp();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCheckInOutApp1.getPrimaryKey());
		primaryKeys.add(newCheckInOutApp2.getPrimaryKey());

		Map<Serializable, CheckInOutApp> checkInOutApps =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, checkInOutApps.size());
		Assert.assertEquals(
			newCheckInOutApp1,
			checkInOutApps.get(newCheckInOutApp1.getPrimaryKey()));
		Assert.assertEquals(
			newCheckInOutApp2,
			checkInOutApps.get(newCheckInOutApp2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CheckInOutApp> checkInOutApps =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(checkInOutApps.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CheckInOutApp newCheckInOutApp = addCheckInOutApp();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCheckInOutApp.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CheckInOutApp> checkInOutApps =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, checkInOutApps.size());
		Assert.assertEquals(
			newCheckInOutApp,
			checkInOutApps.get(newCheckInOutApp.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CheckInOutApp> checkInOutApps =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(checkInOutApps.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CheckInOutApp newCheckInOutApp = addCheckInOutApp();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCheckInOutApp.getPrimaryKey());

		Map<Serializable, CheckInOutApp> checkInOutApps =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, checkInOutApps.size());
		Assert.assertEquals(
			newCheckInOutApp,
			checkInOutApps.get(newCheckInOutApp.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CheckInOutAppLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CheckInOutApp>() {

				@Override
				public void performAction(CheckInOutApp checkInOutApp) {
					Assert.assertNotNull(checkInOutApp);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CheckInOutApp newCheckInOutApp = addCheckInOutApp();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CheckInOutApp.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("logId", newCheckInOutApp.getLogId()));

		List<CheckInOutApp> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CheckInOutApp existingCheckInOutApp = result.get(0);

		Assert.assertEquals(existingCheckInOutApp, newCheckInOutApp);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CheckInOutApp.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("logId", RandomTestUtil.nextLong()));

		List<CheckInOutApp> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CheckInOutApp newCheckInOutApp = addCheckInOutApp();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CheckInOutApp.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("logId"));

		Object newLogId = newCheckInOutApp.getLogId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("logId", new Object[] {newLogId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingLogId = result.get(0);

		Assert.assertEquals(existingLogId, newLogId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CheckInOutApp.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("logId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"logId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CheckInOutApp newCheckInOutApp = addCheckInOutApp();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newCheckInOutApp.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		CheckInOutApp newCheckInOutApp = addCheckInOutApp();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CheckInOutApp.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("logId", newCheckInOutApp.getLogId()));

		List<CheckInOutApp> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(CheckInOutApp checkInOutApp) {
		Assert.assertEquals(
			checkInOutApp.getUuid(),
			ReflectionTestUtil.invoke(
				checkInOutApp, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(checkInOutApp.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				checkInOutApp, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected CheckInOutApp addCheckInOutApp() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CheckInOutApp checkInOutApp = _persistence.create(pk);

		checkInOutApp.setUuid(RandomTestUtil.randomString());

		checkInOutApp.setGroupId(RandomTestUtil.nextLong());

		checkInOutApp.setCompanyId(RandomTestUtil.nextLong());

		checkInOutApp.setUserId(RandomTestUtil.nextLong());

		checkInOutApp.setUserName(RandomTestUtil.randomString());

		checkInOutApp.setCreateDate(RandomTestUtil.nextDate());

		checkInOutApp.setModifiedDate(RandomTestUtil.nextDate());

		checkInOutApp.setCheckInTime(RandomTestUtil.nextDate());

		checkInOutApp.setCheckOutTime(RandomTestUtil.nextDate());

		checkInOutApp.setRemarks(RandomTestUtil.randomString());

		checkInOutApp.setLocation(RandomTestUtil.randomString());

		_checkInOutApps.add(_persistence.update(checkInOutApp));

		return checkInOutApp;
	}

	private List<CheckInOutApp> _checkInOutApps =
		new ArrayList<CheckInOutApp>();
	private CheckInOutAppPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}