/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package FlightMgmtSystemService.service.persistence.test;

import FlightMgmtSystemService.exception.NoSuchFlightException;

import FlightMgmtSystemService.model.Flight;

import FlightMgmtSystemService.service.FlightLocalServiceUtil;
import FlightMgmtSystemService.service.persistence.FlightPersistence;
import FlightMgmtSystemService.service.persistence.FlightUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.AssertUtils;
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
public class FlightPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "FlightMgmtSystemService.service"));

	@Before
	public void setUp() {
		_persistence = FlightUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Flight> iterator = _flights.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Flight flight = _persistence.create(pk);

		Assert.assertNotNull(flight);

		Assert.assertEquals(flight.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Flight newFlight = addFlight();

		_persistence.remove(newFlight);

		Flight existingFlight = _persistence.fetchByPrimaryKey(
			newFlight.getPrimaryKey());

		Assert.assertNull(existingFlight);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addFlight();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Flight newFlight = _persistence.create(pk);

		newFlight.setUuid(RandomTestUtil.randomString());

		newFlight.setGroupId(RandomTestUtil.nextLong());

		newFlight.setCompanyId(RandomTestUtil.nextLong());

		newFlight.setUserId(RandomTestUtil.nextLong());

		newFlight.setUserName(RandomTestUtil.randomString());

		newFlight.setCreateDate(RandomTestUtil.nextDate());

		newFlight.setModifiedDate(RandomTestUtil.nextDate());

		newFlight.setFlightNumber(RandomTestUtil.randomString());

		newFlight.setAirline(RandomTestUtil.randomString());

		newFlight.setDepartureAirport(RandomTestUtil.randomString());

		newFlight.setArrivalAirport(RandomTestUtil.randomString());

		newFlight.setDepartureTime(RandomTestUtil.nextDate());

		newFlight.setArrivalTime(RandomTestUtil.nextDate());

		newFlight.setAvailableSeats(RandomTestUtil.nextInt());

		newFlight.setPrice(RandomTestUtil.nextDouble());

		_flights.add(_persistence.update(newFlight));

		Flight existingFlight = _persistence.findByPrimaryKey(
			newFlight.getPrimaryKey());

		Assert.assertEquals(existingFlight.getUuid(), newFlight.getUuid());
		Assert.assertEquals(
			existingFlight.getFlightId(), newFlight.getFlightId());
		Assert.assertEquals(
			existingFlight.getGroupId(), newFlight.getGroupId());
		Assert.assertEquals(
			existingFlight.getCompanyId(), newFlight.getCompanyId());
		Assert.assertEquals(existingFlight.getUserId(), newFlight.getUserId());
		Assert.assertEquals(
			existingFlight.getUserName(), newFlight.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingFlight.getCreateDate()),
			Time.getShortTimestamp(newFlight.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingFlight.getModifiedDate()),
			Time.getShortTimestamp(newFlight.getModifiedDate()));
		Assert.assertEquals(
			existingFlight.getFlightNumber(), newFlight.getFlightNumber());
		Assert.assertEquals(
			existingFlight.getAirline(), newFlight.getAirline());
		Assert.assertEquals(
			existingFlight.getDepartureAirport(),
			newFlight.getDepartureAirport());
		Assert.assertEquals(
			existingFlight.getArrivalAirport(), newFlight.getArrivalAirport());
		Assert.assertEquals(
			Time.getShortTimestamp(existingFlight.getDepartureTime()),
			Time.getShortTimestamp(newFlight.getDepartureTime()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingFlight.getArrivalTime()),
			Time.getShortTimestamp(newFlight.getArrivalTime()));
		Assert.assertEquals(
			existingFlight.getAvailableSeats(), newFlight.getAvailableSeats());
		AssertUtils.assertEquals(
			existingFlight.getPrice(), newFlight.getPrice());
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
		Flight newFlight = addFlight();

		Flight existingFlight = _persistence.findByPrimaryKey(
			newFlight.getPrimaryKey());

		Assert.assertEquals(existingFlight, newFlight);
	}

	@Test(expected = NoSuchFlightException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Flight> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"FLIGHT_Flight", "uuid", true, "flightId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "flightNumber", true, "airline", true,
			"departureAirport", true, "arrivalAirport", true, "departureTime",
			true, "arrivalTime", true, "availableSeats", true, "price", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Flight newFlight = addFlight();

		Flight existingFlight = _persistence.fetchByPrimaryKey(
			newFlight.getPrimaryKey());

		Assert.assertEquals(existingFlight, newFlight);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Flight missingFlight = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingFlight);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Flight newFlight1 = addFlight();
		Flight newFlight2 = addFlight();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFlight1.getPrimaryKey());
		primaryKeys.add(newFlight2.getPrimaryKey());

		Map<Serializable, Flight> flights = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, flights.size());
		Assert.assertEquals(
			newFlight1, flights.get(newFlight1.getPrimaryKey()));
		Assert.assertEquals(
			newFlight2, flights.get(newFlight2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Flight> flights = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(flights.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Flight newFlight = addFlight();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFlight.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Flight> flights = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, flights.size());
		Assert.assertEquals(newFlight, flights.get(newFlight.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Flight> flights = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(flights.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Flight newFlight = addFlight();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFlight.getPrimaryKey());

		Map<Serializable, Flight> flights = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, flights.size());
		Assert.assertEquals(newFlight, flights.get(newFlight.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			FlightLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Flight>() {

				@Override
				public void performAction(Flight flight) {
					Assert.assertNotNull(flight);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Flight newFlight = addFlight();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Flight.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("flightId", newFlight.getFlightId()));

		List<Flight> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Flight existingFlight = result.get(0);

		Assert.assertEquals(existingFlight, newFlight);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Flight.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("flightId", RandomTestUtil.nextLong()));

		List<Flight> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Flight newFlight = addFlight();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Flight.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("flightId"));

		Object newFlightId = newFlight.getFlightId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("flightId", new Object[] {newFlightId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFlightId = result.get(0);

		Assert.assertEquals(existingFlightId, newFlightId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Flight.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("flightId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"flightId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Flight newFlight = addFlight();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newFlight.getPrimaryKey()));
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

		Flight newFlight = addFlight();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Flight.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("flightId", newFlight.getFlightId()));

		List<Flight> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Flight flight) {
		Assert.assertEquals(
			flight.getUuid(),
			ReflectionTestUtil.invoke(
				flight, "getColumnOriginalValue", new Class<?>[] {String.class},
				"uuid_"));
		Assert.assertEquals(
			Long.valueOf(flight.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				flight, "getColumnOriginalValue", new Class<?>[] {String.class},
				"groupId"));
	}

	protected Flight addFlight() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Flight flight = _persistence.create(pk);

		flight.setUuid(RandomTestUtil.randomString());

		flight.setGroupId(RandomTestUtil.nextLong());

		flight.setCompanyId(RandomTestUtil.nextLong());

		flight.setUserId(RandomTestUtil.nextLong());

		flight.setUserName(RandomTestUtil.randomString());

		flight.setCreateDate(RandomTestUtil.nextDate());

		flight.setModifiedDate(RandomTestUtil.nextDate());

		flight.setFlightNumber(RandomTestUtil.randomString());

		flight.setAirline(RandomTestUtil.randomString());

		flight.setDepartureAirport(RandomTestUtil.randomString());

		flight.setArrivalAirport(RandomTestUtil.randomString());

		flight.setDepartureTime(RandomTestUtil.nextDate());

		flight.setArrivalTime(RandomTestUtil.nextDate());

		flight.setAvailableSeats(RandomTestUtil.nextInt());

		flight.setPrice(RandomTestUtil.nextDouble());

		_flights.add(_persistence.update(flight));

		return flight;
	}

	private List<Flight> _flights = new ArrayList<Flight>();
	private FlightPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}