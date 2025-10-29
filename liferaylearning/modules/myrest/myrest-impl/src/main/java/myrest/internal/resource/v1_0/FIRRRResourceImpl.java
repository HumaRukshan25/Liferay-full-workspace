package myrest.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import myrest.dto.v1_0.FIRRR;
import myrest.resource.v1_0.FIRRRResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;


//refer this http://localhost:8080/o/api
/**
 * @author Sania Mir
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/firrr.properties",
	scope = ServiceScope.PROTOTYPE, service = FIRRRResource.class
)
public class FIRRRResourceImpl extends BaseFIRRRResourceImpl {
	
	@Override
	public Page<FIRRR> getFIRRR() throws Exception {
		
		List<fironlineser.model.FIRRR> firrrEntities = fironlineser.service.FIRRRLocalServiceUtil.getFIRRRs(-1, -1);
		List<FIRRR> firrrDTOs = new ArrayList<>();
		
		for (fironlineser.model.FIRRR entity : firrrEntities) {
			FIRRR dto = _toFIRRRDTO(entity);
			dto.setMessage("FIR data retrieved successfully");
			firrrDTOs.add(dto);
		}
		
		return Page.of(firrrDTOs);
	}
	
	@Override
	public FIRRR getFIRRRById(Long firId) throws Exception {
		fironlineser.model.FIRRR firrrEntity = fironlineser.service.FIRRRLocalServiceUtil.fetchFIRRR(firId);
		
		if (firrrEntity == null) {
			FIRRR response = new FIRRR();
			response.setMessage("FIR not found with ID: " + firId);
			return response;
		}
		
		FIRRR response = _toFIRRRDTO(firrrEntity);
		response.setMessage("FIR retrieved successfully");
		return response;
	}
	
	@Override
	public FIRRR addFIRRR(FIRRR firrr) throws Exception {
		
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long userId = serviceContext.getUserId();
		
		try {
			// Use the service method that doesn't require an ID parameter
			// Let Liferay generate the primary key automatically
			long firId = fironlineser.service.FIRRRLocalServiceUtil.getFIRRRsCount();
			firId++; // Simple increment, but better to use counter service
			
			// Create entity using counter local service for proper ID generation
			long newFirId = com.liferay.counter.kernel.service.CounterLocalServiceUtil.increment();
			
			fironlineser.model.FIRRR firrrEntity = fironlineser.service.FIRRRLocalServiceUtil.createFIRRR(newFirId);
			
			// Set the fields
			firrrEntity.setComplainantName(firrr.getComplainantName());
			firrrEntity.setIncidentDate(firrr.getIncidentDate());
			firrrEntity.setIncidentDetails(firrr.getIncidentDetails());
			firrrEntity.setIncidentLocation(firrr.getIncidentLocation());
			firrrEntity.setStatus(firrr.getStatus() != null ? firrr.getStatus() : "Pending");
			firrrEntity.setTimeline(firrr.getTimeline());
			firrrEntity.setModificationDetails(firrr.getModificationDetails());
			firrrEntity.setAssignedInspector(firrr.getAssignedInspector());
			firrrEntity.setProofFileName(firrr.getProofFileName());
			firrrEntity.setProofFilePath(firrr.getProofFilePath());
			firrrEntity.setUserId(userId);
			
			// Generate UUID
			firrrEntity.setUuid(com.liferay.portal.kernel.util.StringUtil.randomString());
			
			// Set dates
			java.util.Date now = new java.util.Date();
			firrrEntity.setCreateDate(now);
			firrrEntity.setModifiedDate(now);
			
			// Save to database
			firrrEntity = fironlineser.service.FIRRRLocalServiceUtil.addFIRRR(firrrEntity);
			
			FIRRR response = _toFIRRRDTO(firrrEntity);
			response.setMessage("FIR added successfully with ID: " + firrrEntity.getFirId());
			return response;
			
		} catch (Exception e) {
			// Alternative approach if the above fails
			return _addFIRRRAutoIncrement(firrr, userId);
		}
	}
	
	private FIRRR _addFIRRRAutoIncrement(FIRRR firrr, long userId) {
		try {
			// Get the maximum existing ID and increment it
			List<fironlineser.model.FIRRR> allFirrrs = fironlineser.service.FIRRRLocalServiceUtil.getFIRRRs(-1, -1);
			long maxId = 0;
			
			for (fironlineser.model.FIRRR entity : allFirrrs) {
				if (entity.getFirId() > maxId) {
					maxId = entity.getFirId();
				}
			}
			
			long newFirId = maxId + 1;
			
			fironlineser.model.FIRRR firrrEntity = fironlineser.service.FIRRRLocalServiceUtil.createFIRRR(newFirId);
			
			// Set the fields
			firrrEntity.setComplainantName(firrr.getComplainantName());
			firrrEntity.setIncidentDate(firrr.getIncidentDate());
			firrrEntity.setIncidentDetails(firrr.getIncidentDetails());
			firrrEntity.setIncidentLocation(firrr.getIncidentLocation());
			firrrEntity.setStatus(firrr.getStatus() != null ? firrr.getStatus() : "Pending");
			firrrEntity.setTimeline(firrr.getTimeline());
			firrrEntity.setModificationDetails(firrr.getModificationDetails());
			firrrEntity.setAssignedInspector(firrr.getAssignedInspector());
			firrrEntity.setProofFileName(firrr.getProofFileName());
			firrrEntity.setProofFilePath(firrr.getProofFilePath());
			firrrEntity.setUserId(userId);
			firrrEntity.setUuid(com.liferay.portal.kernel.util.StringUtil.randomString());
			
			java.util.Date now = new java.util.Date();
			firrrEntity.setCreateDate(now);
			firrrEntity.setModifiedDate(now);
			
			// Save to database
			firrrEntity = fironlineser.service.FIRRRLocalServiceUtil.addFIRRR(firrrEntity);
			
			FIRRR response = _toFIRRRDTO(firrrEntity);
			response.setMessage("FIR added successfully with ID: " + firrrEntity.getFirId());
			return response;
			
		} catch (Exception e) {
			FIRRR response = new FIRRR();
			response.setMessage("Failed to add FIR: " + e.getMessage());
			return response;
		}
	}
	
	@Override
	public FIRRR updateFIRRR(FIRRR firrr) throws Exception {
		
		if (firrr.getFirId() == null) {
			FIRRR response = new FIRRR();
			response.setMessage("FIR ID is required for update");
			return response;
		}
		
		fironlineser.model.FIRRR firrrEntity = fironlineser.service.FIRRRLocalServiceUtil.fetchFIRRR(firrr.getFirId());
		
		if (firrrEntity == null) {
			FIRRR response = new FIRRR();
			response.setMessage("FIR not found with ID: " + firrr.getFirId());
			return response;
		}
		
		// Update entity from DTO
		firrrEntity.setComplainantName(firrr.getComplainantName());
		firrrEntity.setIncidentDate(firrr.getIncidentDate());
		firrrEntity.setIncidentDetails(firrr.getIncidentDetails());
		firrrEntity.setIncidentLocation(firrr.getIncidentLocation());
		firrrEntity.setStatus(firrr.getStatus());
		firrrEntity.setTimeline(firrr.getTimeline());
		firrrEntity.setModificationDetails(firrr.getModificationDetails());
		firrrEntity.setAssignedInspector(firrr.getAssignedInspector());
		firrrEntity.setProofFileName(firrr.getProofFileName());
		firrrEntity.setProofFilePath(firrr.getProofFilePath());
		firrrEntity.setModifiedDate(new java.util.Date());
		
		// Save to database
		firrrEntity = fironlineser.service.FIRRRLocalServiceUtil.updateFIRRR(firrrEntity);
		
		FIRRR response = _toFIRRRDTO(firrrEntity);
		response.setMessage("FIR updated successfully");
		return response;
	}
	
	// CHANGE METHOD NAME TO MATCH INTERFACE - from deleteFIRRR to deleteFIRRRById
		@Override
		public FIRRR deleteFIRRRById(Long firId) throws Exception {
			
			FIRRR response = new FIRRR();
			
			try {
				fironlineser.model.FIRRR firrrEntity = fironlineser.service.FIRRRLocalServiceUtil.fetchFIRRR(firId);
				
				if (firrrEntity != null) {
					// Set response data before deletion
					response.setFirId(firrrEntity.getFirId());
					response.setComplainantName(firrrEntity.getComplainantName());
					response.setIncidentDate(firrrEntity.getIncidentDate());
					
					// Delete from database
					fironlineser.service.FIRRRLocalServiceUtil.deleteFIRRR(firId);
					response.setMessage("FIR deleted successfully");
				} else {
					response.setMessage("FIR not found");
				}
			} catch (Exception exception) {
				response.setMessage("FIR deletion failed: " + exception.getMessage());
			}
			
			return response;
		}
		
	
	

	private FIRRR _toFIRRRDTO(fironlineser.model.FIRRR entity) {
		FIRRR dto = new FIRRR();
		dto.setFirId(entity.getFirId());
		dto.setComplainantName(entity.getComplainantName());
		dto.setIncidentDate(entity.getIncidentDate());
		dto.setIncidentDetails(entity.getIncidentDetails());
		dto.setIncidentLocation(entity.getIncidentLocation());
		dto.setStatus(entity.getStatus());
		dto.setTimeline(entity.getTimeline());
		dto.setModificationDetails(entity.getModificationDetails());
		dto.setAssignedInspector(entity.getAssignedInspector());
		dto.setProofFileName(entity.getProofFileName());
		dto.setProofFilePath(entity.getProofFilePath());
		dto.setUserId(entity.getUserId());
		dto.setCreateDate(entity.getCreateDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<FIRRR>, UnsafeFunction<FIRRR, FIRRR, Exception>, Exception> contextBatchUnsafeBiConsumer) {
		// Empty implementation - not using batch operations
	}
}