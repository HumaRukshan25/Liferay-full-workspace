/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.service.persistence.test;

import com.ats.books.exception.NoSuchBookCategoryException;
import com.ats.books.model.BookCategory;
import com.ats.books.service.BookCategoryLocalServiceUtil;
import com.ats.books.service.persistence.BookCategoryPersistence;
import com.ats.books.service.persistence.BookCategoryUtil;

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
public class BookCategoryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.ats.books.service"));

	@Before
	public void setUp() {
		_persistence = BookCategoryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<BookCategory> iterator = _bookCategories.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BookCategory bookCategory = _persistence.create(pk);

		Assert.assertNotNull(bookCategory);

		Assert.assertEquals(bookCategory.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		BookCategory newBookCategory = addBookCategory();

		_persistence.remove(newBookCategory);

		BookCategory existingBookCategory = _persistence.fetchByPrimaryKey(
			newBookCategory.getPrimaryKey());

		Assert.assertNull(existingBookCategory);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBookCategory();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BookCategory newBookCategory = _persistence.create(pk);

		newBookCategory.setUuid(RandomTestUtil.randomString());

		newBookCategory.setGroupId(RandomTestUtil.nextLong());

		newBookCategory.setCompanyId(RandomTestUtil.nextLong());

		newBookCategory.setUserId(RandomTestUtil.nextLong());

		newBookCategory.setUserName(RandomTestUtil.randomString());

		newBookCategory.setCreateDate(RandomTestUtil.nextDate());

		newBookCategory.setModifiedDate(RandomTestUtil.nextDate());

		newBookCategory.setCategoryName(RandomTestUtil.randomString());

		newBookCategory.setBookId(RandomTestUtil.nextLong());

		_bookCategories.add(_persistence.update(newBookCategory));

		BookCategory existingBookCategory = _persistence.findByPrimaryKey(
			newBookCategory.getPrimaryKey());

		Assert.assertEquals(
			existingBookCategory.getUuid(), newBookCategory.getUuid());
		Assert.assertEquals(
			existingBookCategory.getCategoryId(),
			newBookCategory.getCategoryId());
		Assert.assertEquals(
			existingBookCategory.getGroupId(), newBookCategory.getGroupId());
		Assert.assertEquals(
			existingBookCategory.getCompanyId(),
			newBookCategory.getCompanyId());
		Assert.assertEquals(
			existingBookCategory.getUserId(), newBookCategory.getUserId());
		Assert.assertEquals(
			existingBookCategory.getUserName(), newBookCategory.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBookCategory.getCreateDate()),
			Time.getShortTimestamp(newBookCategory.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingBookCategory.getModifiedDate()),
			Time.getShortTimestamp(newBookCategory.getModifiedDate()));
		Assert.assertEquals(
			existingBookCategory.getCategoryName(),
			newBookCategory.getCategoryName());
		Assert.assertEquals(
			existingBookCategory.getBookId(), newBookCategory.getBookId());
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
	public void testCountByByCategoryName() throws Exception {
		_persistence.countByByCategoryName("");

		_persistence.countByByCategoryName("null");

		_persistence.countByByCategoryName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		BookCategory newBookCategory = addBookCategory();

		BookCategory existingBookCategory = _persistence.findByPrimaryKey(
			newBookCategory.getPrimaryKey());

		Assert.assertEquals(existingBookCategory, newBookCategory);
	}

	@Test(expected = NoSuchBookCategoryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<BookCategory> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOOKKK_BookCategory", "uuid", true, "categoryId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "categoryName", true,
			"bookId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		BookCategory newBookCategory = addBookCategory();

		BookCategory existingBookCategory = _persistence.fetchByPrimaryKey(
			newBookCategory.getPrimaryKey());

		Assert.assertEquals(existingBookCategory, newBookCategory);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BookCategory missingBookCategory = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBookCategory);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		BookCategory newBookCategory1 = addBookCategory();
		BookCategory newBookCategory2 = addBookCategory();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBookCategory1.getPrimaryKey());
		primaryKeys.add(newBookCategory2.getPrimaryKey());

		Map<Serializable, BookCategory> bookCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, bookCategories.size());
		Assert.assertEquals(
			newBookCategory1,
			bookCategories.get(newBookCategory1.getPrimaryKey()));
		Assert.assertEquals(
			newBookCategory2,
			bookCategories.get(newBookCategory2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, BookCategory> bookCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bookCategories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		BookCategory newBookCategory = addBookCategory();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBookCategory.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, BookCategory> bookCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bookCategories.size());
		Assert.assertEquals(
			newBookCategory,
			bookCategories.get(newBookCategory.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, BookCategory> bookCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bookCategories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		BookCategory newBookCategory = addBookCategory();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBookCategory.getPrimaryKey());

		Map<Serializable, BookCategory> bookCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bookCategories.size());
		Assert.assertEquals(
			newBookCategory,
			bookCategories.get(newBookCategory.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			BookCategoryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<BookCategory>() {

				@Override
				public void performAction(BookCategory bookCategory) {
					Assert.assertNotNull(bookCategory);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		BookCategory newBookCategory = addBookCategory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"categoryId", newBookCategory.getCategoryId()));

		List<BookCategory> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		BookCategory existingBookCategory = result.get(0);

		Assert.assertEquals(existingBookCategory, newBookCategory);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"categoryId", RandomTestUtil.nextLong()));

		List<BookCategory> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		BookCategory newBookCategory = addBookCategory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("categoryId"));

		Object newCategoryId = newBookCategory.getCategoryId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"categoryId", new Object[] {newCategoryId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCategoryId = result.get(0);

		Assert.assertEquals(existingCategoryId, newCategoryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("categoryId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"categoryId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		BookCategory newBookCategory = addBookCategory();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newBookCategory.getPrimaryKey()));
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

		BookCategory newBookCategory = addBookCategory();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"categoryId", newBookCategory.getCategoryId()));

		List<BookCategory> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(BookCategory bookCategory) {
		Assert.assertEquals(
			bookCategory.getUuid(),
			ReflectionTestUtil.invoke(
				bookCategory, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(bookCategory.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				bookCategory, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected BookCategory addBookCategory() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BookCategory bookCategory = _persistence.create(pk);

		bookCategory.setUuid(RandomTestUtil.randomString());

		bookCategory.setGroupId(RandomTestUtil.nextLong());

		bookCategory.setCompanyId(RandomTestUtil.nextLong());

		bookCategory.setUserId(RandomTestUtil.nextLong());

		bookCategory.setUserName(RandomTestUtil.randomString());

		bookCategory.setCreateDate(RandomTestUtil.nextDate());

		bookCategory.setModifiedDate(RandomTestUtil.nextDate());

		bookCategory.setCategoryName(RandomTestUtil.randomString());

		bookCategory.setBookId(RandomTestUtil.nextLong());

		_bookCategories.add(_persistence.update(bookCategory));

		return bookCategory;
	}

	private List<BookCategory> _bookCategories = new ArrayList<BookCategory>();
	private BookCategoryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}