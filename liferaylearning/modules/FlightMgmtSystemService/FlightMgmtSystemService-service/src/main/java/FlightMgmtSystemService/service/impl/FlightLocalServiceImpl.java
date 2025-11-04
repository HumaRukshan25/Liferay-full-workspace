package FlightMgmtSystemService.service.impl;
import FlightMgmtSystemService.model.Flight;
import FlightMgmtSystemService.service.base.FlightLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=FlightMgmtSystemService.model.Flight",
	service = AopService.class
)
public class FlightLocalServiceImpl extends FlightLocalServiceBaseImpl {
	

	/**
	 * Add flight and store into database
	 */
	@Override
	public Flight addFlight(
	        long userId, long groupId, long companyId,
	        String flightNumber, String airline,
	        String departureAirport, String arrivalAirport,
	        Date departureTime, Date arrivalTime,
	        int availableSeats, double price) {

	    long flightId = counterLocalService.increment(Flight.class.getName());

	    Flight flight = flightPersistence.create(flightId);

	    // Audit fields
	    flight.setUserId(userId);
	    flight.setGroupId(groupId);
	    flight.setCompanyId(companyId);
	    flight.setCreateDate(new Date());
	    flight.setModifiedDate(new Date());

	    // Flight fields
	    flight.setFlightNumber(flightNumber);
	    flight.setAirline(airline);
	    flight.setDepartureAirport(departureAirport);
	    flight.setArrivalAirport(arrivalAirport);
	    flight.setDepartureTime(departureTime);
	    flight.setArrivalTime(arrivalTime);
	    flight.setAvailableSeats(availableSeats);
	    flight.setPrice(price);

	    return flightPersistence.update(flight); // Save to DB
	}
	
//	@Override
//	public Flight updateFlight(
//	        long flightId, String flightNumber, String airline,
//	        String departureAirport, String arrivalAirport,
//	        int availableSeats, double price) {
//
//	    try {
//	        // Fetch existing flight record
//	        Flight flight = flightPersistence.findByPrimaryKey(flightId);
//
//	        // Update fields
//	        flight.setFlightNumber(flightNumber);
//	        flight.setAirline(airline);
//	        flight.setDepartureAirport(departureAirport);
//	        flight.setArrivalAirport(arrivalAirport);
//	        flight.setAvailableSeats(availableSeats);
//	        flight.setPrice(price);
//
//	        // Save to DB
//	        return flightPersistence.update(flight);
//
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//	    return null;
//	}
	
	@Override
	public Flight updateFlight(
	        long flightId, String flightNumber, String airline,
	        String departureAirport, String arrivalAirport,
	        Date departureTime, Date arrivalTime,
	        int availableSeats, double price) {

	    Flight flight = flightPersistence.fetchByPrimaryKey(flightId);

	    flight.setFlightNumber(flightNumber);
	    flight.setAirline(airline);
	    flight.setDepartureAirport(departureAirport);
	    flight.setArrivalAirport(arrivalAirport);
	    flight.setDepartureTime(departureTime);
	    flight.setArrivalTime(arrivalTime);
	    flight.setAvailableSeats(availableSeats);
	    flight.setPrice(price);

	    return flightPersistence.update(flight);
	}


}

