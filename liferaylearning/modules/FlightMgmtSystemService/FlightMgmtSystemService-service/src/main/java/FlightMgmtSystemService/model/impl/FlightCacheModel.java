/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package FlightMgmtSystemService.model.impl;

import FlightMgmtSystemService.model.Flight;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Flight in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FlightCacheModel implements CacheModel<Flight>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FlightCacheModel)) {
			return false;
		}

		FlightCacheModel flightCacheModel = (FlightCacheModel)object;

		if (flightId == flightCacheModel.flightId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, flightId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", flightId=");
		sb.append(flightId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", flightNumber=");
		sb.append(flightNumber);
		sb.append(", airline=");
		sb.append(airline);
		sb.append(", departureAirport=");
		sb.append(departureAirport);
		sb.append(", arrivalAirport=");
		sb.append(arrivalAirport);
		sb.append(", departureTime=");
		sb.append(departureTime);
		sb.append(", arrivalTime=");
		sb.append(arrivalTime);
		sb.append(", availableSeats=");
		sb.append(availableSeats);
		sb.append(", price=");
		sb.append(price);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Flight toEntityModel() {
		FlightImpl flightImpl = new FlightImpl();

		if (uuid == null) {
			flightImpl.setUuid("");
		}
		else {
			flightImpl.setUuid(uuid);
		}

		flightImpl.setFlightId(flightId);
		flightImpl.setGroupId(groupId);
		flightImpl.setCompanyId(companyId);
		flightImpl.setUserId(userId);

		if (userName == null) {
			flightImpl.setUserName("");
		}
		else {
			flightImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			flightImpl.setCreateDate(null);
		}
		else {
			flightImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			flightImpl.setModifiedDate(null);
		}
		else {
			flightImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (flightNumber == null) {
			flightImpl.setFlightNumber("");
		}
		else {
			flightImpl.setFlightNumber(flightNumber);
		}

		if (airline == null) {
			flightImpl.setAirline("");
		}
		else {
			flightImpl.setAirline(airline);
		}

		if (departureAirport == null) {
			flightImpl.setDepartureAirport("");
		}
		else {
			flightImpl.setDepartureAirport(departureAirport);
		}

		if (arrivalAirport == null) {
			flightImpl.setArrivalAirport("");
		}
		else {
			flightImpl.setArrivalAirport(arrivalAirport);
		}

		if (departureTime == Long.MIN_VALUE) {
			flightImpl.setDepartureTime(null);
		}
		else {
			flightImpl.setDepartureTime(new Date(departureTime));
		}

		if (arrivalTime == Long.MIN_VALUE) {
			flightImpl.setArrivalTime(null);
		}
		else {
			flightImpl.setArrivalTime(new Date(arrivalTime));
		}

		flightImpl.setAvailableSeats(availableSeats);
		flightImpl.setPrice(price);

		flightImpl.resetOriginalValues();

		return flightImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		flightId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		flightNumber = objectInput.readUTF();
		airline = objectInput.readUTF();
		departureAirport = objectInput.readUTF();
		arrivalAirport = objectInput.readUTF();
		departureTime = objectInput.readLong();
		arrivalTime = objectInput.readLong();

		availableSeats = objectInput.readInt();

		price = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(flightId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (flightNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(flightNumber);
		}

		if (airline == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(airline);
		}

		if (departureAirport == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(departureAirport);
		}

		if (arrivalAirport == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arrivalAirport);
		}

		objectOutput.writeLong(departureTime);
		objectOutput.writeLong(arrivalTime);

		objectOutput.writeInt(availableSeats);

		objectOutput.writeDouble(price);
	}

	public String uuid;
	public long flightId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String flightNumber;
	public String airline;
	public String departureAirport;
	public String arrivalAirport;
	public long departureTime;
	public long arrivalTime;
	public int availableSeats;
	public double price;

}