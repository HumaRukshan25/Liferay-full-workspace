//package Flightheadlessapirest.internal.resource.v1_0;
//
//import Flightheadlessapirest.resource.v1_0.FlightResource;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.ServiceScope;
//
///**
// * @author Sania Mir
// */
//@Component(
//	properties = "OSGI-INF/liferay/rest/v1_0/flight.properties",
//	scope = ServiceScope.PROTOTYPE, service = FlightResource.class
//)
//public class FlightResourceImpl extends BaseFlightResourceImpl {
//}


package Flightheadlessapirest.internal.resource.v1_0;

import Flightheadlessapirest.dto.v1_0.Flight;
import Flightheadlessapirest.resource.v1_0.FlightResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.Response;

/**
 * @author Sania Mir
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/flight.properties",
	scope = ServiceScope.PROTOTYPE, service = FlightResource.class
)
public class FlightResourceImpl extends BaseFlightResourceImpl {

	@Override
	public Page<Flight> getFlights() throws Exception {
		
		List<FlightMgmtSystemService.model.Flight> flightEntities = FlightMgmtSystemService.service.FlightLocalServiceUtil.getFlights(-1, -1);
		List<Flight> flightDTOs = new ArrayList<>();
		
		for (FlightMgmtSystemService.model.Flight entity : flightEntities) {
			Flight dto = _toFlightDTO(entity);
			flightDTOs.add(dto);
		}
		
		return Page.of(flightDTOs);
	}
	
	@Override
	public Flight getFlight(Long flightId) throws Exception {
		FlightMgmtSystemService.model.Flight flightEntity = FlightMgmtSystemService.service.FlightLocalServiceUtil.fetchFlight(flightId);
		
		if (flightEntity == null) {
			Flight response = new Flight();
			return response;
		}
		
		Flight response = _toFlightDTO(flightEntity);
		return response;
	}
	
	@Override
	public Flight postFlight(Flight flight) throws Exception {
		
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long userId = serviceContext.getUserId();
		
		try {
			// Generate new flight ID using counter service
			long newFlightId = com.liferay.counter.kernel.service.CounterLocalServiceUtil.increment();
			
			FlightMgmtSystemService.model.Flight flightEntity = FlightMgmtSystemService.service.FlightLocalServiceUtil.createFlight(newFlightId);
			
			// Set the fields from DTO
			flightEntity.setFlightNumber(flight.getFlightNumber());
			flightEntity.setAirline(flight.getAirline());
			flightEntity.setDepartureAirport(flight.getDepartureAirport());
			flightEntity.setArrivalAirport(flight.getArrivalAirport());
			flightEntity.setDepartureTime(flight.getDepartureTime());
			flightEntity.setArrivalTime(flight.getArrivalTime());
			flightEntity.setAvailableSeats(flight.getAvailableSeats());
			flightEntity.setPrice(flight.getPrice());
			flightEntity.setUserId(userId);
			flightEntity.setUserName(contextUser.getFullName());
			
			// Set group and company context
			flightEntity.setGroupId(serviceContext.getScopeGroupId());
			flightEntity.setCompanyId(serviceContext.getCompanyId());
			
			// Generate UUID
			flightEntity.setUuid(com.liferay.portal.kernel.util.StringUtil.randomString());
			
			// Set dates
			java.util.Date now = new java.util.Date();
			flightEntity.setCreateDate(now);
			flightEntity.setModifiedDate(now);
			
			// Save to database
			flightEntity = FlightMgmtSystemService.service.FlightLocalServiceUtil.addFlight(flightEntity);
			
			Flight response = _toFlightDTO(flightEntity);
			return response;
			
		} catch (Exception e) {
			// Alternative approach if the above fails
			return _addFlightAutoIncrement(flight, userId, serviceContext);
		}
	}
	
	private Flight _addFlightAutoIncrement(Flight flight, long userId, ServiceContext serviceContext) {
		try {
			// Get the maximum existing ID and increment it
			List<FlightMgmtSystemService.model.Flight> allFlights = FlightMgmtSystemService.service.FlightLocalServiceUtil.getFlights(-1, -1);
			long maxId = 0;
			
			for (FlightMgmtSystemService.model.Flight entity : allFlights) {
				if (entity.getFlightId() > maxId) {
					maxId = entity.getFlightId();
				}
			}
			
			long newFlightId = maxId + 1;
			
			FlightMgmtSystemService.model.Flight flightEntity = FlightMgmtSystemService.service.FlightLocalServiceUtil.createFlight(newFlightId);
			
			// Set the fields
			flightEntity.setFlightNumber(flight.getFlightNumber());
			flightEntity.setAirline(flight.getAirline());
			flightEntity.setDepartureAirport(flight.getDepartureAirport());
			flightEntity.setArrivalAirport(flight.getArrivalAirport());
			flightEntity.setDepartureTime(flight.getDepartureTime());
			flightEntity.setArrivalTime(flight.getArrivalTime());
			flightEntity.setAvailableSeats(flight.getAvailableSeats());
			flightEntity.setPrice(flight.getPrice());
			flightEntity.setUserId(userId);
			flightEntity.setUserName(contextUser.getFullName());
			flightEntity.setGroupId(serviceContext.getScopeGroupId());
			flightEntity.setCompanyId(serviceContext.getCompanyId());
			flightEntity.setUuid(com.liferay.portal.kernel.util.StringUtil.randomString());
			
			java.util.Date now = new java.util.Date();
			flightEntity.setCreateDate(now);
			flightEntity.setModifiedDate(now);
			
			// Save to database
			flightEntity = FlightMgmtSystemService.service.FlightLocalServiceUtil.addFlight(flightEntity);
			
			Flight response = _toFlightDTO(flightEntity);
			return response;
			
		} catch (Exception e) {
			Flight response = new Flight();
			return response;
		}
	}
	
	@Override
	public Flight putFlight(Long flightId, Flight flight) throws Exception {
		
		if (flightId == null) {
			Flight response = new Flight();
			return response;
		}
		
		FlightMgmtSystemService.model.Flight flightEntity = FlightMgmtSystemService.service.FlightLocalServiceUtil.fetchFlight(flightId);
		
		if (flightEntity == null) {
			Flight response = new Flight();
			return response;
		}
		
		// Update entity from DTO
		flightEntity.setFlightNumber(flight.getFlightNumber());
		flightEntity.setAirline(flight.getAirline());
		flightEntity.setDepartureAirport(flight.getDepartureAirport());
		flightEntity.setArrivalAirport(flight.getArrivalAirport());
		flightEntity.setDepartureTime(flight.getDepartureTime());
		flightEntity.setArrivalTime(flight.getArrivalTime());
		flightEntity.setAvailableSeats(flight.getAvailableSeats());
		flightEntity.setPrice(flight.getPrice());
		flightEntity.setModifiedDate(new java.util.Date());
		
		// Save to database
		flightEntity = FlightMgmtSystemService.service.FlightLocalServiceUtil.updateFlight(flightEntity);
		
		Flight response = _toFlightDTO(flightEntity);
		return response;
	}
	
	@Override
	public Flight deleteFlight(Long flightId) throws Exception {
		
		Flight response = new Flight();
		
		try {
			FlightMgmtSystemService.model.Flight flightEntity = FlightMgmtSystemService.service.FlightLocalServiceUtil.fetchFlight(flightId);
			
			if (flightEntity != null) {
				// Set response data before deletion
				response.setFlightId(flightEntity.getFlightId());
				response.setFlightNumber(flightEntity.getFlightNumber());
				response.setAirline(flightEntity.getAirline());
				
				// Delete from database
				FlightMgmtSystemService.service.FlightLocalServiceUtil.deleteFlight(flightId);
			}
		} catch (Exception exception) {
			// Handle exception if needed
		}
		
		return response;
	}
	
	@Override
	public Response deleteFlightBatch(String callbackURL, Object object) throws Exception {
	    
	    try {
	        // Use Vulcan batch engine for batch deletion
	        vulcanBatchEngineImportTaskResource.setContextAcceptLanguage(
	            contextAcceptLanguage);
	        vulcanBatchEngineImportTaskResource.setContextCompany(contextCompany);
	        vulcanBatchEngineImportTaskResource.setContextHttpServletRequest(
	            contextHttpServletRequest);
	        vulcanBatchEngineImportTaskResource.setContextUriInfo(contextUriInfo);
	        vulcanBatchEngineImportTaskResource.setContextUser(contextUser);

	        Response.ResponseBuilder responseBuilder = Response.accepted();

	        return responseBuilder.entity(
	            vulcanBatchEngineImportTaskResource.deleteImportTask(
	                Flight.class.getName(), callbackURL, object)
	        ).build();
	        
	    } catch (Exception e) {
	        // Fallback manual batch deletion if needed
	        return _manualBatchDelete(callbackURL, object);
	    }
	}
	
	@Override
	public Response postFlightBatch(String callbackURL, Object object) throws Exception {
	    
	    try {
	        // Use Vulcan batch engine for batch creation
	        vulcanBatchEngineImportTaskResource.setContextAcceptLanguage(
	            contextAcceptLanguage);
	        vulcanBatchEngineImportTaskResource.setContextCompany(contextCompany);
	        vulcanBatchEngineImportTaskResource.setContextHttpServletRequest(
	            contextHttpServletRequest);
	        vulcanBatchEngineImportTaskResource.setContextUriInfo(contextUriInfo);
	        vulcanBatchEngineImportTaskResource.setContextUser(contextUser);

	        Response.ResponseBuilder responseBuilder = Response.accepted();

	        return responseBuilder.entity(
	            vulcanBatchEngineImportTaskResource.postImportTask(
	                Flight.class.getName(), callbackURL, null, object)
	        ).build();
	        
	    } catch (Exception e) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity("Batch creation failed: " + e.getMessage())
	            .build();
	    }
	}

	@Override
	public Response putFlightBatch(String callbackURL, Object object) throws Exception {
	    
	    try {
	        // Use Vulcan batch engine for batch update
	        vulcanBatchEngineImportTaskResource.setContextAcceptLanguage(
	            contextAcceptLanguage);
	        vulcanBatchEngineImportTaskResource.setContextCompany(contextCompany);
	        vulcanBatchEngineImportTaskResource.setContextHttpServletRequest(
	            contextHttpServletRequest);
	        vulcanBatchEngineImportTaskResource.setContextUriInfo(contextUriInfo);
	        vulcanBatchEngineImportTaskResource.setContextUser(contextUser);

	        Response.ResponseBuilder responseBuilder = Response.accepted();

	        return responseBuilder.entity(
	            vulcanBatchEngineImportTaskResource.putImportTask(
	                Flight.class.getName(), callbackURL, object)
	        ).build();
	        
	    } catch (Exception e) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity("Batch update failed: " + e.getMessage())
	            .build();
	    }
	}

	// Manual batch deletion implementation as fallback
	private Response _manualBatchDelete(String callbackURL, Object object) {
	    try {
	        // If object is a collection of Flight IDs, process them
	        if (object instanceof java.util.Collection) {
	            java.util.Collection<?> collection = (java.util.Collection<?>) object;
	            int successCount = 0;
	            int errorCount = 0;
	            List<String> errors = new ArrayList<>();
	            
	            for (Object item : collection) {
	                try {
	                    if (item instanceof Long) {
	                        Long flightId = (Long) item;
	                        FlightMgmtSystemService.service.FlightLocalServiceUtil.deleteFlight(flightId);
	                        successCount++;
	                    } else if (item instanceof java.util.Map) {
	                        // Handle map with flightId
	                        java.util.Map<?, ?> map = (java.util.Map<?, ?>) item;
	                        Object flightIdObj = map.get("flightId");
	                        if (flightIdObj instanceof Long) {
	                            Long flightId = (Long) flightIdObj;
	                            FlightMgmtSystemService.service.FlightLocalServiceUtil.deleteFlight(flightId);
	                            successCount++;
	                        } else {
	                            errorCount++;
	                            errors.add("Invalid flightId format: " + flightIdObj);
	                        }
	                    } else if (item instanceof Integer) {
	                        // Handle Integer IDs
	                        Integer flightId = (Integer) item;
	                        FlightMgmtSystemService.service.FlightLocalServiceUtil.deleteFlight(flightId.longValue());
	                        successCount++;
	                    } else {
	                        errorCount++;
	                        errors.add("Invalid item format: " + item);
	                    }
	                } catch (Exception e) {
	                    errorCount++;
	                    errors.add("Failed to delete Flight: " + item + " - " + e.getMessage());
	                }
	            }
	            
	            // Create response
	            java.util.Map<String, Object> response = new java.util.HashMap<>();
	            response.put("successCount", successCount);
	            response.put("errorCount", errorCount);
	            response.put("totalProcessed", collection.size());
	            response.put("status", "completed");
	            if (!errors.isEmpty()) {
	                response.put("errors", errors);
	            }
	            
	            return Response.ok(response).build();
	        }
	        
	        // If we can't process, return error
	        return Response.status(Response.Status.BAD_REQUEST)
	            .entity("Invalid batch delete request format. Expected array of Flight IDs.")
	            .build();
	        
	    } catch (Exception e) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity("Batch delete failed: " + e.getMessage())
	            .build();
	    }
	}

	private Flight _toFlightDTO(FlightMgmtSystemService.model.Flight entity) {
		Flight dto = new Flight();
		dto.setFlightId(entity.getFlightId());
		dto.setGroupId(entity.getGroupId());
		dto.setCompanyId(entity.getCompanyId());
		dto.setUserId(entity.getUserId());
		dto.setUserName(entity.getUserName());
		dto.setCreateDate(entity.getCreateDate());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setFlightNumber(entity.getFlightNumber());
		dto.setAirline(entity.getAirline());
		dto.setDepartureAirport(entity.getDepartureAirport());
		dto.setArrivalAirport(entity.getArrivalAirport());
		dto.setDepartureTime(entity.getDepartureTime());
		dto.setArrivalTime(entity.getArrivalTime());
		dto.setAvailableSeats(entity.getAvailableSeats());
		dto.setPrice(entity.getPrice());
		return dto;
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Flight>, UnsafeFunction<Flight, Flight, Exception>, Exception> contextBatchUnsafeBiConsumer) {
		// Empty implementation - not using batch operations
	}
}