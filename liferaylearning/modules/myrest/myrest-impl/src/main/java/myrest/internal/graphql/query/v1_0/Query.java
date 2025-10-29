package myrest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import myrest.dto.v1_0.FIRRR;

import myrest.resource.v1_0.FIRRRResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Sania Mir
 * @generated
 */
@Generated("")
public class Query {

	public static void setFIRRRResourceComponentServiceObjects(
		ComponentServiceObjects<FIRRRResource>
			firrrResourceComponentServiceObjects) {

		_firrrResourceComponentServiceObjects =
			firrrResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {fIRRR{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get all FIRRR records")
	public FIRRRPage fIRRR() throws Exception {
		return _applyComponentServiceObjects(
			_firrrResourceComponentServiceObjects,
			this::_populateResourceContext,
			firrrResource -> new FIRRRPage(firrrResource.getFIRRR()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {fIRRRById(firId: ___){firId, complainantName, incidentDate, incidentDetails, incidentLocation, status, timeline, modificationDetails, assignedInspector, proofFileName, proofFilePath, userId, createDate, modifiedDate, message, data}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get FIRRR by ID")
	public FIRRR fIRRRById(@GraphQLName("firId") Long firId) throws Exception {
		return _applyComponentServiceObjects(
			_firrrResourceComponentServiceObjects,
			this::_populateResourceContext,
			firrrResource -> firrrResource.getFIRRRById(firId));
	}

	@GraphQLName("FIRRRPage")
	public class FIRRRPage {

		public FIRRRPage(Page firrrPage) {
			actions = firrrPage.getActions();

			items = firrrPage.getItems();
			lastPage = firrrPage.getLastPage();
			page = firrrPage.getPage();
			pageSize = firrrPage.getPageSize();
			totalCount = firrrPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<FIRRR> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(FIRRRResource firrrResource)
		throws Exception {

		firrrResource.setContextAcceptLanguage(_acceptLanguage);
		firrrResource.setContextCompany(_company);
		firrrResource.setContextHttpServletRequest(_httpServletRequest);
		firrrResource.setContextHttpServletResponse(_httpServletResponse);
		firrrResource.setContextUriInfo(_uriInfo);
		firrrResource.setContextUser(_user);
		firrrResource.setGroupLocalService(_groupLocalService);
		firrrResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<FIRRRResource>
		_firrrResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}