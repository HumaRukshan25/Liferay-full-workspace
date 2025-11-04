package Flightheadlessapirest.internal.graphql.query.v1_0;

import Flightheadlessapirest.dto.v1_0.Flight;

import Flightheadlessapirest.resource.v1_0.FlightResource;

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

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Sania Mir
 * @generated
 */
@Generated("")
public class Query {

	public static void setFlightResourceComponentServiceObjects(
		ComponentServiceObjects<FlightResource>
			flightResourceComponentServiceObjects) {

		_flightResourceComponentServiceObjects =
			flightResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {flights{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public FlightPage flights() throws Exception {
		return _applyComponentServiceObjects(
			_flightResourceComponentServiceObjects,
			this::_populateResourceContext,
			flightResource -> new FlightPage(flightResource.getFlights()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {flight(flightId: ___){flightId, groupId, companyId, userId, userName, createDate, modifiedDate, flightNumber, airline, departureAirport, arrivalAirport, departureTime, arrivalTime, availableSeats, price}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Flight flight(@GraphQLName("flightId") Long flightId)
		throws Exception {

		return _applyComponentServiceObjects(
			_flightResourceComponentServiceObjects,
			this::_populateResourceContext,
			flightResource -> flightResource.getFlight(flightId));
	}

	@GraphQLName("FlightPage")
	public class FlightPage {

		public FlightPage(Page flightPage) {
			actions = flightPage.getActions();

			items = flightPage.getItems();
			lastPage = flightPage.getLastPage();
			page = flightPage.getPage();
			pageSize = flightPage.getPageSize();
			totalCount = flightPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Flight> items;

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

	private void _populateResourceContext(FlightResource flightResource)
		throws Exception {

		flightResource.setContextAcceptLanguage(_acceptLanguage);
		flightResource.setContextCompany(_company);
		flightResource.setContextHttpServletRequest(_httpServletRequest);
		flightResource.setContextHttpServletResponse(_httpServletResponse);
		flightResource.setContextUriInfo(_uriInfo);
		flightResource.setContextUser(_user);
		flightResource.setGroupLocalService(_groupLocalService);
		flightResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<FlightResource>
		_flightResourceComponentServiceObjects;

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