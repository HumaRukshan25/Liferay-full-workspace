/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.service.persistence.test;

import com.ats.books.exception.NoSuchBooksException;
import com.ats.books.model.Books;
import com.ats.books.service.BooksLocalServiceUtil;
import com.ats.books.service.persistence.BooksPersistence;
import com.ats.books.service.persistence.BooksUtil;

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
public class BooksPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.ats.books.service"));

	@Before
	public void setUp() {
		_persistence = BooksUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Books> iterator = _bookses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Books books = _persistence.create(pk);

		Assert.assertNotNull(books);

		Assert.assertEquals(books.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Books newBooks = addBooks();

		_persistence.remove(newBooks);

		Books existingBooks = _persistence.fetchByPrimaryKey(
			newBooks.getPrimaryKey());

		Assert.assertNull(existingBooks);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBooks();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Books newBooks = _persistence.create(pk);

		newBooks.setUuid(RandomTestUtil.randomString());

		newBooks.setGroupId(RandomTestUtil.nextLong());

		newBooks.setCompanyId(RandomTestUtil.nextLong());

		newBooks.setUserId(RandomTestUtil.nextLong());

		newBooks.setUserName(RandomTestUtil.randomString());

		newBooks.setCreateDate(RandomTestUtil.nextDate());

		newBooks.setModifiedDate(RandomTestUtil.nextDate());

		newBooks.setTitle(RandomTestUtil.randomString());

		newBooks.setAuthor(RandomTestUtil.randomString());

		newBooks.setPublishDate(RandomTestUtil.nextDate());

		newBooks.setCategoryId(RandomTestUtil.nextLong());

		_bookses.add(_persistence.update(newBooks));

		Books existingBooks = _persistence.findByPrimaryKey(
			newBooks.getPrimaryKey());

		Assert.assertEquals(existingBooks.getUuid(), newBooks.getUuid());
		Assert.assertEquals(existingBooks.getBookId(), newBooks.getBookId());
		Assert.assertEquals(existingBooks.getGroupId(), newBooks.getGroupId());
		Assert.assertEquals(
			existingBooks.getCompanyId(), newBooks.getCompanyId());
		Assert.assertEquals(existingBooks.getUserId(), newBooks.getUserId());
		Assert.assertEquals(
			existingBooks.getUserName(), newBooks.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBooks.getCreateDate()),
			Time.getShortTimestamp(newBooks.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingBooks.getModifiedDate()),
			Time.getShortTimestamp(newBooks.getModifiedDate()));
		Assert.assertEquals(existingBooks.getTitle(), newBooks.getTitle());
		Assert.assertEquals(existingBooks.getAuthor(), newBooks.getAuthor());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBooks.getPublishDate()),
			Time.getShortTimestamp(newBooks.getPublishDate()));
		Assert.assertEquals(
			existingBooks.getCategoryId(), newBooks.getCategoryId());
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
	public void testCountByByAuthor() throws Exception {
		_persistence.countByByAuthor("");

		_persistence.countByByAuthor("null");

		_persistence.countByByAuthor((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Books newBooks = addBooks();

		Books existingBooks = _persistence.findByPrimaryKey(
			newBooks.getPrimaryKey());

		Assert.assertEquals(existingBooks, newBooks);
	}

	@Test(expected = NoSuchBooksException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Books> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOOKKK_Books", "uuid", true, "bookId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "title", true, "author", true,
			"publishDate", true, "categoryId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Books newBooks = addBooks();

		Books existingBooks = _persistence.fetchByPrimaryKey(
			newBooks.getPrimaryKey());

		Assert.assertEquals(existingBooks, newBooks);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Books missingBooks = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBooks);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Books newBooks1 = addBooks();
		Books newBooks2 = addBooks();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBooks1.getPrimaryKey());
		primaryKeys.add(newBooks2.getPrimaryKey());

		Map<Serializable, Books> bookses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, bookses.size());
		Assert.assertEquals(newBooks1, bookses.get(newBooks1.getPrimaryKey()));
		Assert.assertEquals(newBooks2, bookses.get(newBooks2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Books> bookses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(bookses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Books newBooks = addBooks();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBooks.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Books> bookses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, bookses.size());
		Assert.assertEquals(newBooks, bookses.get(newBooks.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Books> bookses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(bookses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Books newBooks = addBooks();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBooks.getPrimaryKey());

		Map<Serializable, Books> bookses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, bookses.size());
		Assert.assertEquals(newBooks, bookses.get(newBooks.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			BooksLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Books>() {

				@Override
				public void performAction(Books books) {
					Assert.assertNotNull(books);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Books newBooks = addBooks();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Books.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("bookId", newBooks.getBookId()));

		List<Books> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Books existingBooks = result.get(0);

		Assert.assertEquals(existingBooks, newBooks);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Books.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("bookId", RandomTestUtil.nextLong()));

		List<Books> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Books newBooks = addBooks();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Books.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("bookId"));

		Object newBookId = newBooks.getBookId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("bookId", new Object[] {newBookId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingBookId = result.get(0);

		Assert.assertEquals(existingBookId, newBookId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Books.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("bookId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"bookId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Books newBooks = addBooks();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newBooks.getPrimaryKey()));
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

		Books newBooks = addBooks();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Books.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("bookId", newBooks.getBookId()));

		List<Books> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Books books) {
		Assert.assertEquals(
			books.getUuid(),
			ReflectionTestUtil.invoke(
				books, "getColumnOriginalValue", new Class<?>[] {String.class},
				"uuid_"));
		Assert.assertEquals(
			Long.valueOf(books.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				books, "getColumnOriginalValue", new Class<?>[] {String.class},
				"groupId"));
	}

	protected Books addBooks() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Books books = _persistence.create(pk);

		books.setUuid(RandomTestUtil.randomString());

		books.setGroupId(RandomTestUtil.nextLong());

		books.setCompanyId(RandomTestUtil.nextLong());

		books.setUserId(RandomTestUtil.nextLong());

		books.setUserName(RandomTestUtil.randomString());

		books.setCreateDate(RandomTestUtil.nextDate());

		books.setModifiedDate(RandomTestUtil.nextDate());

		books.setTitle(RandomTestUtil.randomString());

		books.setAuthor(RandomTestUtil.randomString());

		books.setPublishDate(RandomTestUtil.nextDate());

		books.setCategoryId(RandomTestUtil.nextLong());

		_bookses.add(_persistence.update(books));

		return books;
	}

	private List<Books> _bookses = new ArrayList<Books>();
	private BooksPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}