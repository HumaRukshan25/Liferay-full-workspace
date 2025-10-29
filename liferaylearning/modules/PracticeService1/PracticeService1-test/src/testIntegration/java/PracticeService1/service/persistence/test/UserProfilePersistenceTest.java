/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.service.persistence.test;

import PracticeService1.exception.NoSuchUserProfileException;

import PracticeService1.model.UserProfile;

import PracticeService1.service.UserProfileLocalServiceUtil;
import PracticeService1.service.persistence.UserProfilePersistence;
import PracticeService1.service.persistence.UserProfileUtil;

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
public class UserProfilePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "PracticeService1.service"));

	@Before
	public void setUp() {
		_persistence = UserProfileUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<UserProfile> iterator = _userProfiles.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserProfile userProfile = _persistence.create(pk);

		Assert.assertNotNull(userProfile);

		Assert.assertEquals(userProfile.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		UserProfile newUserProfile = addUserProfile();

		_persistence.remove(newUserProfile);

		UserProfile existingUserProfile = _persistence.fetchByPrimaryKey(
			newUserProfile.getPrimaryKey());

		Assert.assertNull(existingUserProfile);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addUserProfile();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserProfile newUserProfile = _persistence.create(pk);

		newUserProfile.setUserName(RandomTestUtil.randomString());

		newUserProfile.setPassword(RandomTestUtil.randomString());

		_userProfiles.add(_persistence.update(newUserProfile));

		UserProfile existingUserProfile = _persistence.findByPrimaryKey(
			newUserProfile.getPrimaryKey());

		Assert.assertEquals(
			existingUserProfile.getUserId(), newUserProfile.getUserId());
		Assert.assertEquals(
			existingUserProfile.getUserName(), newUserProfile.getUserName());
		Assert.assertEquals(
			existingUserProfile.getPassword(), newUserProfile.getPassword());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		UserProfile newUserProfile = addUserProfile();

		UserProfile existingUserProfile = _persistence.findByPrimaryKey(
			newUserProfile.getPrimaryKey());

		Assert.assertEquals(existingUserProfile, newUserProfile);
	}

	@Test(expected = NoSuchUserProfileException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<UserProfile> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ATS_UserProfile", "userId", true, "userName", true, "password",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		UserProfile newUserProfile = addUserProfile();

		UserProfile existingUserProfile = _persistence.fetchByPrimaryKey(
			newUserProfile.getPrimaryKey());

		Assert.assertEquals(existingUserProfile, newUserProfile);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserProfile missingUserProfile = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingUserProfile);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		UserProfile newUserProfile1 = addUserProfile();
		UserProfile newUserProfile2 = addUserProfile();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserProfile1.getPrimaryKey());
		primaryKeys.add(newUserProfile2.getPrimaryKey());

		Map<Serializable, UserProfile> userProfiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, userProfiles.size());
		Assert.assertEquals(
			newUserProfile1, userProfiles.get(newUserProfile1.getPrimaryKey()));
		Assert.assertEquals(
			newUserProfile2, userProfiles.get(newUserProfile2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, UserProfile> userProfiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(userProfiles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		UserProfile newUserProfile = addUserProfile();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserProfile.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, UserProfile> userProfiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, userProfiles.size());
		Assert.assertEquals(
			newUserProfile, userProfiles.get(newUserProfile.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, UserProfile> userProfiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(userProfiles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		UserProfile newUserProfile = addUserProfile();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserProfile.getPrimaryKey());

		Map<Serializable, UserProfile> userProfiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, userProfiles.size());
		Assert.assertEquals(
			newUserProfile, userProfiles.get(newUserProfile.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			UserProfileLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<UserProfile>() {

				@Override
				public void performAction(UserProfile userProfile) {
					Assert.assertNotNull(userProfile);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		UserProfile newUserProfile = addUserProfile();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UserProfile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("userId", newUserProfile.getUserId()));

		List<UserProfile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		UserProfile existingUserProfile = result.get(0);

		Assert.assertEquals(existingUserProfile, newUserProfile);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UserProfile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("userId", RandomTestUtil.nextLong()));

		List<UserProfile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		UserProfile newUserProfile = addUserProfile();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UserProfile.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("userId"));

		Object newUserId = newUserProfile.getUserId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("userId", new Object[] {newUserId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingUserId = result.get(0);

		Assert.assertEquals(existingUserId, newUserId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UserProfile.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("userId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"userId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected UserProfile addUserProfile() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserProfile userProfile = _persistence.create(pk);

		userProfile.setUserName(RandomTestUtil.randomString());

		userProfile.setPassword(RandomTestUtil.randomString());

		_userProfiles.add(_persistence.update(userProfile));

		return userProfile;
	}

	private List<UserProfile> _userProfiles = new ArrayList<UserProfile>();
	private UserProfilePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}