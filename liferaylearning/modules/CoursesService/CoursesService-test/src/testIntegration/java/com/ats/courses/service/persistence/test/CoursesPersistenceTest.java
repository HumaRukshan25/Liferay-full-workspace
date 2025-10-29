/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.service.persistence.test;

import com.ats.courses.exception.NoSuchCoursesException;
import com.ats.courses.model.Courses;
import com.ats.courses.service.CoursesLocalServiceUtil;
import com.ats.courses.service.persistence.CoursesPersistence;
import com.ats.courses.service.persistence.CoursesUtil;

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
public class CoursesPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.ats.courses.service"));

	@Before
	public void setUp() {
		_persistence = CoursesUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Courses> iterator = _courseses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Courses courses = _persistence.create(pk);

		Assert.assertNotNull(courses);

		Assert.assertEquals(courses.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Courses newCourses = addCourses();

		_persistence.remove(newCourses);

		Courses existingCourses = _persistence.fetchByPrimaryKey(
			newCourses.getPrimaryKey());

		Assert.assertNull(existingCourses);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCourses();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Courses newCourses = _persistence.create(pk);

		newCourses.setUuid(RandomTestUtil.randomString());

		newCourses.setGroupId(RandomTestUtil.nextLong());

		newCourses.setCompanyId(RandomTestUtil.nextLong());

		newCourses.setUserId(RandomTestUtil.nextLong());

		newCourses.setUserName(RandomTestUtil.randomString());

		newCourses.setCreateDate(RandomTestUtil.nextDate());

		newCourses.setModifiedDate(RandomTestUtil.nextDate());

		newCourses.setCourses_img(RandomTestUtil.randomString());

		newCourses.setCourses_name(RandomTestUtil.randomString());

		newCourses.setCourses_des(RandomTestUtil.randomString());

		newCourses.setCourses_type(RandomTestUtil.randomString());

		newCourses.setCourses_rating(RandomTestUtil.randomString());

		newCourses.setStatus(RandomTestUtil.nextInt());

		_courseses.add(_persistence.update(newCourses));

		Courses existingCourses = _persistence.findByPrimaryKey(
			newCourses.getPrimaryKey());

		Assert.assertEquals(existingCourses.getUuid(), newCourses.getUuid());
		Assert.assertEquals(
			existingCourses.getCoursesId(), newCourses.getCoursesId());
		Assert.assertEquals(
			existingCourses.getGroupId(), newCourses.getGroupId());
		Assert.assertEquals(
			existingCourses.getCompanyId(), newCourses.getCompanyId());
		Assert.assertEquals(
			existingCourses.getUserId(), newCourses.getUserId());
		Assert.assertEquals(
			existingCourses.getUserName(), newCourses.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCourses.getCreateDate()),
			Time.getShortTimestamp(newCourses.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCourses.getModifiedDate()),
			Time.getShortTimestamp(newCourses.getModifiedDate()));
		Assert.assertEquals(
			existingCourses.getCourses_img(), newCourses.getCourses_img());
		Assert.assertEquals(
			existingCourses.getCourses_name(), newCourses.getCourses_name());
		Assert.assertEquals(
			existingCourses.getCourses_des(), newCourses.getCourses_des());
		Assert.assertEquals(
			existingCourses.getCourses_type(), newCourses.getCourses_type());
		Assert.assertEquals(
			existingCourses.getCourses_rating(),
			newCourses.getCourses_rating());
		Assert.assertEquals(
			existingCourses.getStatus(), newCourses.getStatus());
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
	public void testCountByCourses_type() throws Exception {
		_persistence.countByCourses_type("");

		_persistence.countByCourses_type("null");

		_persistence.countByCourses_type((String)null);
	}

	@Test
	public void testCountByCourses_name() throws Exception {
		_persistence.countByCourses_name("");

		_persistence.countByCourses_name("null");

		_persistence.countByCourses_name((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Courses newCourses = addCourses();

		Courses existingCourses = _persistence.findByPrimaryKey(
			newCourses.getPrimaryKey());

		Assert.assertEquals(existingCourses, newCourses);
	}

	@Test(expected = NoSuchCoursesException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Courses> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ATS_Courses", "uuid", true, "coursesId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "Courses_img", true, "Courses_name",
			true, "Courses_des", true, "Courses_type", true, "Courses_rating",
			true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Courses newCourses = addCourses();

		Courses existingCourses = _persistence.fetchByPrimaryKey(
			newCourses.getPrimaryKey());

		Assert.assertEquals(existingCourses, newCourses);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Courses missingCourses = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCourses);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Courses newCourses1 = addCourses();
		Courses newCourses2 = addCourses();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCourses1.getPrimaryKey());
		primaryKeys.add(newCourses2.getPrimaryKey());

		Map<Serializable, Courses> courseses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, courseses.size());
		Assert.assertEquals(
			newCourses1, courseses.get(newCourses1.getPrimaryKey()));
		Assert.assertEquals(
			newCourses2, courseses.get(newCourses2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Courses> courseses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(courseses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Courses newCourses = addCourses();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCourses.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Courses> courseses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, courseses.size());
		Assert.assertEquals(
			newCourses, courseses.get(newCourses.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Courses> courseses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(courseses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Courses newCourses = addCourses();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCourses.getPrimaryKey());

		Map<Serializable, Courses> courseses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, courseses.size());
		Assert.assertEquals(
			newCourses, courseses.get(newCourses.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CoursesLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Courses>() {

				@Override
				public void performAction(Courses courses) {
					Assert.assertNotNull(courses);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Courses newCourses = addCourses();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Courses.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("coursesId", newCourses.getCoursesId()));

		List<Courses> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Courses existingCourses = result.get(0);

		Assert.assertEquals(existingCourses, newCourses);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Courses.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("coursesId", RandomTestUtil.nextLong()));

		List<Courses> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Courses newCourses = addCourses();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Courses.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("coursesId"));

		Object newCoursesId = newCourses.getCoursesId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"coursesId", new Object[] {newCoursesId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCoursesId = result.get(0);

		Assert.assertEquals(existingCoursesId, newCoursesId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Courses.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("coursesId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"coursesId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Courses newCourses = addCourses();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newCourses.getPrimaryKey()));
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

		Courses newCourses = addCourses();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Courses.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("coursesId", newCourses.getCoursesId()));

		List<Courses> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Courses courses) {
		Assert.assertEquals(
			courses.getUuid(),
			ReflectionTestUtil.invoke(
				courses, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(courses.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				courses, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected Courses addCourses() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Courses courses = _persistence.create(pk);

		courses.setUuid(RandomTestUtil.randomString());

		courses.setGroupId(RandomTestUtil.nextLong());

		courses.setCompanyId(RandomTestUtil.nextLong());

		courses.setUserId(RandomTestUtil.nextLong());

		courses.setUserName(RandomTestUtil.randomString());

		courses.setCreateDate(RandomTestUtil.nextDate());

		courses.setModifiedDate(RandomTestUtil.nextDate());

		courses.setCourses_img(RandomTestUtil.randomString());

		courses.setCourses_name(RandomTestUtil.randomString());

		courses.setCourses_des(RandomTestUtil.randomString());

		courses.setCourses_type(RandomTestUtil.randomString());

		courses.setCourses_rating(RandomTestUtil.randomString());

		courses.setStatus(RandomTestUtil.nextInt());

		_courseses.add(_persistence.update(courses));

		return courses;
	}

	private List<Courses> _courseses = new ArrayList<Courses>();
	private CoursesPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}