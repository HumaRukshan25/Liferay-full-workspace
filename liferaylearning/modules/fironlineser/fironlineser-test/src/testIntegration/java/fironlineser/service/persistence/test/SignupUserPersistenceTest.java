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
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import fironlineser.exception.NoSuchSignupUserException;

import fironlineser.model.SignupUser;

import fironlineser.service.SignupUserLocalServiceUtil;
import fironlineser.service.persistence.SignupUserPersistence;
import fironlineser.service.persistence.SignupUserUtil;

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
public class SignupUserPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "fironlineser.service"));

	@Before
	public void setUp() {
		_persistence = SignupUserUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SignupUser> iterator = _signupUsers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SignupUser signupUser = _persistence.create(pk);

		Assert.assertNotNull(signupUser);

		Assert.assertEquals(signupUser.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SignupUser newSignupUser = addSignupUser();

		_persistence.remove(newSignupUser);

		SignupUser existingSignupUser = _persistence.fetchByPrimaryKey(
			newSignupUser.getPrimaryKey());

		Assert.assertNull(existingSignupUser);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSignupUser();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SignupUser newSignupUser = _persistence.create(pk);

		newSignupUser.setUuid(RandomTestUtil.randomString());

		newSignupUser.setLoginName(RandomTestUtil.randomString());

		newSignupUser.setFirstName(RandomTestUtil.randomString());

		newSignupUser.setLastName(RandomTestUtil.randomString());

		newSignupUser.setEmail(RandomTestUtil.randomString());

		newSignupUser.setPhoneNo(RandomTestUtil.randomString());

		newSignupUser.setPassword_(RandomTestUtil.randomString());

		newSignupUser.setRole(RandomTestUtil.randomString());

		newSignupUser.setActive(RandomTestUtil.randomBoolean());

		newSignupUser.setActivationToken(RandomTestUtil.randomString());

		_signupUsers.add(_persistence.update(newSignupUser));

		SignupUser existingSignupUser = _persistence.findByPrimaryKey(
			newSignupUser.getPrimaryKey());

		Assert.assertEquals(
			existingSignupUser.getUuid(), newSignupUser.getUuid());
		Assert.assertEquals(
			existingSignupUser.getSignupUserId(),
			newSignupUser.getSignupUserId());
		Assert.assertEquals(
			existingSignupUser.getLoginName(), newSignupUser.getLoginName());
		Assert.assertEquals(
			existingSignupUser.getFirstName(), newSignupUser.getFirstName());
		Assert.assertEquals(
			existingSignupUser.getLastName(), newSignupUser.getLastName());
		Assert.assertEquals(
			existingSignupUser.getEmail(), newSignupUser.getEmail());
		Assert.assertEquals(
			existingSignupUser.getPhoneNo(), newSignupUser.getPhoneNo());
		Assert.assertEquals(
			existingSignupUser.getPassword_(), newSignupUser.getPassword_());
		Assert.assertEquals(
			existingSignupUser.getRole(), newSignupUser.getRole());
		Assert.assertEquals(
			existingSignupUser.isActive(), newSignupUser.isActive());
		Assert.assertEquals(
			existingSignupUser.getActivationToken(),
			newSignupUser.getActivationToken());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByEmail() throws Exception {
		_persistence.countByEmail("");

		_persistence.countByEmail("null");

		_persistence.countByEmail((String)null);
	}

	@Test
	public void testCountByActivationToken() throws Exception {
		_persistence.countByActivationToken("");

		_persistence.countByActivationToken("null");

		_persistence.countByActivationToken((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SignupUser newSignupUser = addSignupUser();

		SignupUser existingSignupUser = _persistence.findByPrimaryKey(
			newSignupUser.getPrimaryKey());

		Assert.assertEquals(existingSignupUser, newSignupUser);
	}

	@Test(expected = NoSuchSignupUserException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SignupUser> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"FIRFOO_SignupUser", "uuid", true, "signupUserId", true,
			"loginName", true, "firstName", true, "lastName", true, "email",
			true, "phoneNo", true, "password_", true, "role", true, "active",
			true, "activationToken", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SignupUser newSignupUser = addSignupUser();

		SignupUser existingSignupUser = _persistence.fetchByPrimaryKey(
			newSignupUser.getPrimaryKey());

		Assert.assertEquals(existingSignupUser, newSignupUser);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SignupUser missingSignupUser = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSignupUser);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SignupUser newSignupUser1 = addSignupUser();
		SignupUser newSignupUser2 = addSignupUser();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSignupUser1.getPrimaryKey());
		primaryKeys.add(newSignupUser2.getPrimaryKey());

		Map<Serializable, SignupUser> signupUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, signupUsers.size());
		Assert.assertEquals(
			newSignupUser1, signupUsers.get(newSignupUser1.getPrimaryKey()));
		Assert.assertEquals(
			newSignupUser2, signupUsers.get(newSignupUser2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SignupUser> signupUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(signupUsers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SignupUser newSignupUser = addSignupUser();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSignupUser.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SignupUser> signupUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, signupUsers.size());
		Assert.assertEquals(
			newSignupUser, signupUsers.get(newSignupUser.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SignupUser> signupUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(signupUsers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SignupUser newSignupUser = addSignupUser();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSignupUser.getPrimaryKey());

		Map<Serializable, SignupUser> signupUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, signupUsers.size());
		Assert.assertEquals(
			newSignupUser, signupUsers.get(newSignupUser.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SignupUserLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SignupUser>() {

				@Override
				public void performAction(SignupUser signupUser) {
					Assert.assertNotNull(signupUser);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SignupUser newSignupUser = addSignupUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignupUser.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"signupUserId", newSignupUser.getSignupUserId()));

		List<SignupUser> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		SignupUser existingSignupUser = result.get(0);

		Assert.assertEquals(existingSignupUser, newSignupUser);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignupUser.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"signupUserId", RandomTestUtil.nextLong()));

		List<SignupUser> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SignupUser newSignupUser = addSignupUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignupUser.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("signupUserId"));

		Object newSignupUserId = newSignupUser.getSignupUserId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"signupUserId", new Object[] {newSignupUserId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSignupUserId = result.get(0);

		Assert.assertEquals(existingSignupUserId, newSignupUserId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignupUser.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("signupUserId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"signupUserId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected SignupUser addSignupUser() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SignupUser signupUser = _persistence.create(pk);

		signupUser.setUuid(RandomTestUtil.randomString());

		signupUser.setLoginName(RandomTestUtil.randomString());

		signupUser.setFirstName(RandomTestUtil.randomString());

		signupUser.setLastName(RandomTestUtil.randomString());

		signupUser.setEmail(RandomTestUtil.randomString());

		signupUser.setPhoneNo(RandomTestUtil.randomString());

		signupUser.setPassword_(RandomTestUtil.randomString());

		signupUser.setRole(RandomTestUtil.randomString());

		signupUser.setActive(RandomTestUtil.randomBoolean());

		signupUser.setActivationToken(RandomTestUtil.randomString());

		_signupUsers.add(_persistence.update(signupUser));

		return signupUser;
	}

	private List<SignupUser> _signupUsers = new ArrayList<SignupUser>();
	private SignupUserPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}