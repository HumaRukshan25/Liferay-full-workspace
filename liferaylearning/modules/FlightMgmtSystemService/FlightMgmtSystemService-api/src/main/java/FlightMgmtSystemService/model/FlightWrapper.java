/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package FlightMgmtSystemService.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Flight}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Flight
 * @generated
 */
public class FlightWrapper
	extends BaseModelWrapper<Flight> implements Flight, ModelWrapper<Flight> {

	public FlightWrapper(Flight flight) {
		super(flight);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("flightId", getFlightId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("flightNumber", getFlightNumber());
		attributes.put("airline", getAirline());
		attributes.put("departureAirport", getDepartureAirport());
		attributes.put("arrivalAirport", getArrivalAirport());
		attributes.put("departureTime", getDepartureTime());
		attributes.put("arrivalTime", getArrivalTime());
		attributes.put("availableSeats", getAvailableSeats());
		attributes.put("price", getPrice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long flightId = (Long)attributes.get("flightId");

		if (flightId != null) {
			setFlightId(flightId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String flightNumber = (String)attributes.get("flightNumber");

		if (flightNumber != null) {
			setFlightNumber(flightNumber);
		}

		String airline = (String)attributes.get("airline");

		if (airline != null) {
			setAirline(airline);
		}

		String departureAirport = (String)attributes.get("departureAirport");

		if (departureAirport != null) {
			setDepartureAirport(departureAirport);
		}

		String arrivalAirport = (String)attributes.get("arrivalAirport");

		if (arrivalAirport != null) {
			setArrivalAirport(arrivalAirport);
		}

		Date departureTime = (Date)attributes.get("departureTime");

		if (departureTime != null) {
			setDepartureTime(departureTime);
		}

		Date arrivalTime = (Date)attributes.get("arrivalTime");

		if (arrivalTime != null) {
			setArrivalTime(arrivalTime);
		}

		Integer availableSeats = (Integer)attributes.get("availableSeats");

		if (availableSeats != null) {
			setAvailableSeats(availableSeats);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}
	}

	@Override
	public Flight cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the airline of this flight.
	 *
	 * @return the airline of this flight
	 */
	@Override
	public String getAirline() {
		return model.getAirline();
	}

	/**
	 * Returns the arrival airport of this flight.
	 *
	 * @return the arrival airport of this flight
	 */
	@Override
	public String getArrivalAirport() {
		return model.getArrivalAirport();
	}

	/**
	 * Returns the arrival time of this flight.
	 *
	 * @return the arrival time of this flight
	 */
	@Override
	public Date getArrivalTime() {
		return model.getArrivalTime();
	}

	/**
	 * Returns the available seats of this flight.
	 *
	 * @return the available seats of this flight
	 */
	@Override
	public int getAvailableSeats() {
		return model.getAvailableSeats();
	}

	/**
	 * Returns the company ID of this flight.
	 *
	 * @return the company ID of this flight
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this flight.
	 *
	 * @return the create date of this flight
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the departure airport of this flight.
	 *
	 * @return the departure airport of this flight
	 */
	@Override
	public String getDepartureAirport() {
		return model.getDepartureAirport();
	}

	/**
	 * Returns the departure time of this flight.
	 *
	 * @return the departure time of this flight
	 */
	@Override
	public Date getDepartureTime() {
		return model.getDepartureTime();
	}

	/**
	 * Returns the flight ID of this flight.
	 *
	 * @return the flight ID of this flight
	 */
	@Override
	public long getFlightId() {
		return model.getFlightId();
	}

	/**
	 * Returns the flight number of this flight.
	 *
	 * @return the flight number of this flight
	 */
	@Override
	public String getFlightNumber() {
		return model.getFlightNumber();
	}

	/**
	 * Returns the group ID of this flight.
	 *
	 * @return the group ID of this flight
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this flight.
	 *
	 * @return the modified date of this flight
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the price of this flight.
	 *
	 * @return the price of this flight
	 */
	@Override
	public double getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this flight.
	 *
	 * @return the primary key of this flight
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this flight.
	 *
	 * @return the user ID of this flight
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this flight.
	 *
	 * @return the user name of this flight
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this flight.
	 *
	 * @return the user uuid of this flight
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this flight.
	 *
	 * @return the uuid of this flight
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the airline of this flight.
	 *
	 * @param airline the airline of this flight
	 */
	@Override
	public void setAirline(String airline) {
		model.setAirline(airline);
	}

	/**
	 * Sets the arrival airport of this flight.
	 *
	 * @param arrivalAirport the arrival airport of this flight
	 */
	@Override
	public void setArrivalAirport(String arrivalAirport) {
		model.setArrivalAirport(arrivalAirport);
	}

	/**
	 * Sets the arrival time of this flight.
	 *
	 * @param arrivalTime the arrival time of this flight
	 */
	@Override
	public void setArrivalTime(Date arrivalTime) {
		model.setArrivalTime(arrivalTime);
	}

	/**
	 * Sets the available seats of this flight.
	 *
	 * @param availableSeats the available seats of this flight
	 */
	@Override
	public void setAvailableSeats(int availableSeats) {
		model.setAvailableSeats(availableSeats);
	}

	/**
	 * Sets the company ID of this flight.
	 *
	 * @param companyId the company ID of this flight
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this flight.
	 *
	 * @param createDate the create date of this flight
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the departure airport of this flight.
	 *
	 * @param departureAirport the departure airport of this flight
	 */
	@Override
	public void setDepartureAirport(String departureAirport) {
		model.setDepartureAirport(departureAirport);
	}

	/**
	 * Sets the departure time of this flight.
	 *
	 * @param departureTime the departure time of this flight
	 */
	@Override
	public void setDepartureTime(Date departureTime) {
		model.setDepartureTime(departureTime);
	}

	/**
	 * Sets the flight ID of this flight.
	 *
	 * @param flightId the flight ID of this flight
	 */
	@Override
	public void setFlightId(long flightId) {
		model.setFlightId(flightId);
	}

	/**
	 * Sets the flight number of this flight.
	 *
	 * @param flightNumber the flight number of this flight
	 */
	@Override
	public void setFlightNumber(String flightNumber) {
		model.setFlightNumber(flightNumber);
	}

	/**
	 * Sets the group ID of this flight.
	 *
	 * @param groupId the group ID of this flight
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this flight.
	 *
	 * @param modifiedDate the modified date of this flight
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the price of this flight.
	 *
	 * @param price the price of this flight
	 */
	@Override
	public void setPrice(double price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this flight.
	 *
	 * @param primaryKey the primary key of this flight
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this flight.
	 *
	 * @param userId the user ID of this flight
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this flight.
	 *
	 * @param userName the user name of this flight
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this flight.
	 *
	 * @param userUuid the user uuid of this flight
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this flight.
	 *
	 * @param uuid the uuid of this flight
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected FlightWrapper wrap(Flight flight) {
		return new FlightWrapper(flight);
	}

}