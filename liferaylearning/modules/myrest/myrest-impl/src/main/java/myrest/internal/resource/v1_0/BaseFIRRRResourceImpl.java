package myrest.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.filter.ExpressionConvert;
import com.liferay.portal.odata.filter.FilterParser;
import com.liferay.portal.odata.filter.FilterParserProvider;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.VulcanBatchEngineTaskItemDelegate;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.ActionUtil;
import com.liferay.portal.vulcan.util.TransformUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import myrest.dto.v1_0.FIRRR;

import myrest.resource.v1_0.FIRRRResource;

/**
 * @author Sania Mir
 * @generated
 */
@Generated("")
@javax.ws.rs.Path("/v1.0")
public abstract class BaseFIRRRResourceImpl
	implements EntityModelResource, FIRRRResource,
			   VulcanBatchEngineTaskItemDelegate<FIRRR> {

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/myrest/v1.0/get-firrr'  -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(
		description = "Get all FIRRR records"
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {@io.swagger.v3.oas.annotations.tags.Tag(name = "FIRRR")}
	)
	@javax.ws.rs.GET
	@javax.ws.rs.Path("/get-firrr")
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@Override
	public Page<FIRRR> getFIRRR() throws Exception {
		return Page.of(Collections.emptyList());
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/myrest/v1.0/get-firrr/{firId}'  -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(description = "Get FIRRR by ID")
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.PATH,
				name = "firId"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {@io.swagger.v3.oas.annotations.tags.Tag(name = "FIRRR")}
	)
	@javax.ws.rs.GET
	@javax.ws.rs.Path("/get-firrr/{firId}")
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@Override
	public FIRRR getFIRRRById(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.PathParam("firId")
			Long firId)
		throws Exception {

		return new FIRRR();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/myrest/v1.0/add-firrr' -d $'{"assignedInspector": ___, "complainantName": ___, "createDate": ___, "data": ___, "firId": ___, "incidentDate": ___, "incidentDetails": ___, "incidentLocation": ___, "message": ___, "modificationDetails": ___, "modifiedDate": ___, "proofFileName": ___, "proofFilePath": ___, "status": ___, "timeline": ___, "userId": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(description = "add FIRRR")
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {@io.swagger.v3.oas.annotations.tags.Tag(name = "FIRRR")}
	)
	@javax.ws.rs.Consumes({"application/json", "application/xml"})
	@javax.ws.rs.Path("/add-firrr")
	@javax.ws.rs.POST
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@Override
	public FIRRR addFIRRR(FIRRR firrr) throws Exception {
		return new FIRRR();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/myrest/v1.0/update-firrr' -d $'{"assignedInspector": ___, "complainantName": ___, "createDate": ___, "data": ___, "firId": ___, "incidentDate": ___, "incidentDetails": ___, "incidentLocation": ___, "message": ___, "modificationDetails": ___, "modifiedDate": ___, "proofFileName": ___, "proofFilePath": ___, "status": ___, "timeline": ___, "userId": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(description = "update FIRRR")
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {@io.swagger.v3.oas.annotations.tags.Tag(name = "FIRRR")}
	)
	@javax.ws.rs.Consumes({"application/json", "application/xml"})
	@javax.ws.rs.Path("/update-firrr")
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@javax.ws.rs.PUT
	@Override
	public FIRRR updateFIRRR(FIRRR firrr) throws Exception {
		return new FIRRR();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/myrest/v1.0/delete-firrr/{firId}'  -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(description = "Delete FIRRR by ID")
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.PATH,
				name = "firId"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {@io.swagger.v3.oas.annotations.tags.Tag(name = "FIRRR")}
	)
	@javax.ws.rs.DELETE
	@javax.ws.rs.Path("/delete-firrr/{firId}")
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@Override
	public FIRRR deleteFIRRRById(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.PathParam("firId")
			Long firId)
		throws Exception {

		return new FIRRR();
	}
	
	
	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PATCH' 'http://localhost:8080/o/myrest/v1.0/update-firrr/{firId}' -d $'{"assignedInspector": ___, "complainantName": ___, "status": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(description = "Partially update FIRRR")
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.PATH,
				name = "firId"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {@io.swagger.v3.oas.annotations.tags.Tag(name = "FIRRR")}
	)
	@javax.ws.rs.Consumes({"application/json", "application/xml"})
	@javax.ws.rs.Path("/update-firrr/{firId}")
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@javax.ws.rs.PATCH
	public FIRRR patchFIRRR(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.PathParam("firId")
			Long firId,
			FIRRR firrr)
		throws Exception {

		return new FIRRR();
	}

//	/**
//	 * Invoke this method with the command line:
//	 *
//	 * curl -X 'DELETE' 'http://localhost:8080/o/myrest/v1.0/delete-firrr/batch'  -u 'test@liferay.com:test'
//	 */
//	@io.swagger.v3.oas.annotations.Parameters(
//		value = {
//			@io.swagger.v3.oas.annotations.Parameter(
//				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
//				name = "callbackURL"
//			)
//		}
//	)
//	@io.swagger.v3.oas.annotations.tags.Tags(
//		value = {@io.swagger.v3.oas.annotations.tags.Tag(name = "FIRRR")}
//	)
//	@javax.ws.rs.Consumes("application/json")
//	@javax.ws.rs.DELETE
//	@javax.ws.rs.Path("/delete-firrr/batch")
//	@javax.ws.rs.Produces("application/json")
//	@Override
//	public Response deleteFIRRRBatch(
//			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
//			@javax.ws.rs.QueryParam("callbackURL")
//			String callbackURL,
//			Object object)
//		throws Exception {
//
//		return Response.accepted().build();
//	}
	
	
	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/myrest/v1.0/delete-firrr/batch'  -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Parameters(
	    value = {
	        @io.swagger.v3.oas.annotations.Parameter(
	            in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
	            name = "callbackURL"
	        )
	    }
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
	    value = {@io.swagger.v3.oas.annotations.tags.Tag(name = "FIRRR")}
	)
	@javax.ws.rs.Consumes("application/json")
	@javax.ws.rs.DELETE
	@javax.ws.rs.Path("/delete-firrr/batch")
	@javax.ws.rs.Produces("application/json")
	public Response deleteFIRRRBatch(
	        @io.swagger.v3.oas.annotations.Parameter(hidden = true)
	        @javax.ws.rs.QueryParam("callbackURL")
	        String callbackURL,
	        Object object)
	    throws Exception {

	    // COMPLETELY BYPASS VULCAN BATCH ENGINE - Use manual implementation only
	    return _simpleBatchDelete(object);
	}

	// Simple batch deletion that completely bypasses Vulcan
	private Response _simpleBatchDelete(Object object) {
	    try {
	        System.out.println("=== BATCH DELETE STARTED ===");
	        System.out.println("Received object type: " + (object != null ? object.getClass().getName() : "null"));
	        System.out.println("Received object: " + object);
	        
	        // Initialize counters
	        int successCount = 0;
	        int errorCount = 0;
	        List<String> errors = new ArrayList<>();
	        List<Long> processedIds = new ArrayList<>();

	        // Check if object is a collection
	        if (object instanceof java.util.Collection) {
	            java.util.Collection<?> collection = (java.util.Collection<?>) object;
	            System.out.println("Processing collection with " + collection.size() + " items");
	            
	            for (Object item : collection) {
	                try {
	                    Long firId = _extractFirId(item);
	                    
	                    if (firId != null) {
	                        System.out.println("Deleting FIR with ID: " + firId);
	                        
	                        // Delete the FIR record
	                        fironlineser.service.FIRRRLocalServiceUtil.deleteFIRRR(firId);
	                        successCount++;
	                        processedIds.add(firId);
	                        System.out.println("Successfully deleted FIR: " + firId);
	                    } else {
	                        errorCount++;
	                        String errorMsg = "Invalid FIR ID format: " + item;
	                        errors.add(errorMsg);
	                        System.out.println(errorMsg);
	                    }
	                    
	                } catch (Exception e) {
	                    errorCount++;
	                    String errorMsg = "Failed to delete FIR: " + item + " - " + e.getMessage();
	                    errors.add(errorMsg);
	                    System.out.println(errorMsg);
	                    e.printStackTrace();
	                }
	            }
	        } else {
	            String errorMsg = "Invalid request format. Expected JSON array but got: " + 
	                             (object != null ? object.getClass().getSimpleName() : "null");
	            System.out.println(errorMsg);
	            return Response.status(Response.Status.BAD_REQUEST)
	                .entity("{\"message\": \"" + errorMsg + "\"}")
	                .build();
	        }
	        
	        // Create success response
	        java.util.Map<String, Object> response = new java.util.HashMap<>();
	        response.put("success", true);
	        response.put("message", "Batch delete operation completed");
	        response.put("successCount", successCount);
	        response.put("errorCount", errorCount);
	        response.put("totalProcessed", successCount + errorCount);
	        response.put("processedIds", processedIds);
	        response.put("status", "completed");
	        
	        if (!errors.isEmpty()) {
	            response.put("errors", errors);
	        }
	        
	        System.out.println("=== BATCH DELETE COMPLETED ===");
	        System.out.println("Success: " + successCount + ", Errors: " + errorCount);
	        
	        return Response.ok(response).build();
	        
	    } catch (Exception e) {
	        System.out.println("=== BATCH DELETE FAILED ===");
	        e.printStackTrace();
	        
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity("{\"message\": \"Batch delete operation failed: " + e.getMessage() + "\"}")
	            .build();
	    }
	}

	// Helper method to extract FIR ID from different object types
	private Long _extractFirId(Object item) {
	    if (item == null) {
	        return null;
	    }
	    
	    try {
	        if (item instanceof Long) {
	            return (Long) item;
	        } else if (item instanceof Integer) {
	            return ((Integer) item).longValue();
	        } else if (item instanceof String) {
	            return Long.parseLong((String) item);
	        } else if (item instanceof java.util.Map) {
	            java.util.Map<?, ?> map = (java.util.Map<?, ?>) item;
	            Object firIdObj = map.get("firId");
	            if (firIdObj instanceof Long) {
	                return (Long) firIdObj;
	            } else if (firIdObj instanceof Integer) {
	                return ((Integer) firIdObj).longValue();
	            } else if (firIdObj instanceof String) {
	                return Long.parseLong((String) firIdObj);
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Error extracting FIR ID from: " + item + " - " + e.getMessage());
	    }
	    
	    return null;
	}

	@Override
	@SuppressWarnings("PMD.UnusedLocalVariable")
	public void create(
			java.util.Collection<FIRRR> firrrs,
			Map<String, Serializable> parameters)
		throws Exception {
	}

	@Override
	public void delete(
			java.util.Collection<FIRRR> firrrs,
			Map<String, Serializable> parameters)
		throws Exception {
	}

	@Override
	public EntityModel getEntityModel(Map<String, List<String>> multivaluedMap)
		throws Exception {

		return getEntityModel(
			new MultivaluedHashMap<String, Object>(multivaluedMap));
	}

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
		throws Exception {

		return null;
	}

	@Override
	public Page<FIRRR> read(
			Filter filter, Pagination pagination, Sort[] sorts,
			Map<String, Serializable> parameters, String search)
		throws Exception {

		return null;
	}

	@Override
	public void setLanguageId(String languageId) {
		this.contextAcceptLanguage = new AcceptLanguage() {

			@Override
			public List<Locale> getLocales() {
				return null;
			}

			@Override
			public String getPreferredLanguageId() {
				return languageId;
			}

			@Override
			public Locale getPreferredLocale() {
				return LocaleUtil.fromLanguageId(languageId);
			}

		};
	}

	@Override
	public void update(
			java.util.Collection<FIRRR> firrrs,
			Map<String, Serializable> parameters)
		throws Exception {
	}

	public void setContextAcceptLanguage(AcceptLanguage contextAcceptLanguage) {
		this.contextAcceptLanguage = contextAcceptLanguage;
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany) {

		this.contextCompany = contextCompany;
	}

	public void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {

		this.contextHttpServletRequest = contextHttpServletRequest;
	}

	public void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {

		this.contextHttpServletResponse = contextHttpServletResponse;
	}

	public void setContextUriInfo(UriInfo contextUriInfo) {
		this.contextUriInfo = contextUriInfo;
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser) {

		this.contextUser = contextUser;
	}

	public void setExpressionConvert(
		ExpressionConvert<Filter> expressionConvert) {

		this.expressionConvert = expressionConvert;
	}

	public void setFilterParserProvider(
		FilterParserProvider filterParserProvider) {

		this.filterParserProvider = filterParserProvider;
	}

	public void setGroupLocalService(GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	public void setResourceActionLocalService(
		ResourceActionLocalService resourceActionLocalService) {

		this.resourceActionLocalService = resourceActionLocalService;
	}

	public void setResourcePermissionLocalService(
		ResourcePermissionLocalService resourcePermissionLocalService) {

		this.resourcePermissionLocalService = resourcePermissionLocalService;
	}

	public void setRoleLocalService(RoleLocalService roleLocalService) {
		this.roleLocalService = roleLocalService;
	}

	@Override
	public Filter toFilter(
		String filterString, Map<String, List<String>> multivaluedMap) {

		try {
			EntityModel entityModel = getEntityModel(multivaluedMap);

			FilterParser filterParser = filterParserProvider.provide(
				entityModel);

			com.liferay.portal.odata.filter.Filter oDataFilter =
				new com.liferay.portal.odata.filter.Filter(
					filterParser.parse(filterString));

			return expressionConvert.convert(
				oDataFilter.getExpression(),
				contextAcceptLanguage.getPreferredLocale(), entityModel);
		}
		catch (Exception exception) {
			_log.error("Invalid filter " + filterString, exception);
		}

		return null;
	}

	protected Map<String, String> addAction(
		String actionName, GroupedModel groupedModel, String methodName) {

		return ActionUtil.addAction(
			actionName, getClass(), groupedModel, methodName,
			contextScopeChecker, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, Long id, String methodName, Long ownerId,
		String permissionName, Long siteId) {

		return ActionUtil.addAction(
			actionName, getClass(), id, methodName, contextScopeChecker,
			ownerId, permissionName, siteId, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, Long id, String methodName,
		ModelResourcePermission modelResourcePermission) {

		return ActionUtil.addAction(
			actionName, getClass(), id, methodName, contextScopeChecker,
			modelResourcePermission, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, String methodName, String permissionName,
		Long siteId) {

		return addAction(
			actionName, siteId, methodName, null, permissionName, siteId);
	}

	/*protected <T, R> List<R> transform(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}*/

	protected AcceptLanguage contextAcceptLanguage;
	protected com.liferay.portal.kernel.model.Company contextCompany;
	protected HttpServletRequest contextHttpServletRequest;
	protected HttpServletResponse contextHttpServletResponse;
	protected Object contextScopeChecker;
	protected UriInfo contextUriInfo;
	protected com.liferay.portal.kernel.model.User contextUser;
	protected ExpressionConvert<Filter> expressionConvert;
	protected FilterParserProvider filterParserProvider;
	protected GroupLocalService groupLocalService;
	protected ResourceActionLocalService resourceActionLocalService;
	protected ResourcePermissionLocalService resourcePermissionLocalService;
	protected RoleLocalService roleLocalService;
	protected VulcanBatchEngineImportTaskResource
		vulcanBatchEngineImportTaskResource;

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseFIRRRResourceImpl.class);

	

}