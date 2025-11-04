package Flightheadlessapirest.internal.graphql.mutation.v1_0;

import Flightheadlessapirest.dto.v1_0.Flight;

import Flightheadlessapirest.resource.v1_0.FlightResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Sania Mir
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setFlightResourceComponentServiceObjects(
		ComponentServiceObjects<FlightResource>
			flightResourceComponentServiceObjects) {

		_flightResourceComponentServiceObjects =
			flightResourceComponentServiceObjects;
	}

	@GraphQLField
	public Flight createFlight(@GraphQLName("flight") Flight flight)
		throws Exception {

		return _applyComponentServiceObjects(
			_flightResourceComponentServiceObjects,
			this::_populateResourceContext,
			flightResource -> flightResource.postFlight(flight));
	}

	@GraphQLField
	public Response createFlightBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_flightResourceComponentServiceObjects,
			this::_populateResourceContext,
			flightResource -> flightResource.postFlightBatch(
				callbackURL, object));
	}

	@GraphQLField
	public Flight deleteFlight(@GraphQLName("flightId") Long flightId)
		throws Exception {

		return _applyComponentServiceObjects(
			_flightResourceComponentServiceObjects,
			this::_populateResourceContext,
			flightResource -> flightResource.deleteFlight(flightId));
	}

	@GraphQLField
	public Response deleteFlightBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_flightResourceComponentServiceObjects,
			this::_populateResourceContext,
			flightResource -> flightResource.deleteFlightBatch(
				callbackURL, object));
	}

	@GraphQLField
	public Flight updateFlight(
			@GraphQLName("flightId") Long flightId,
			@GraphQLName("flight") Flight flight)
		throws Exception {

		return _applyComponentServiceObjects(
			_flightResourceComponentServiceObjects,
			this::_populateResourceContext,
			flightResource -> flightResource.putFlight(flightId, flight));
	}

	@GraphQLField
	public Response updateFlightBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_flightResourceComponentServiceObjects,
			this::_populateResourceContext,
			flightResource -> flightResource.putFlightBatch(
				callbackURL, object));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}