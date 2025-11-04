package Flightheadlessapirest.internal.graphql.servlet.v1_0;

import Flightheadlessapirest.internal.graphql.mutation.v1_0.Mutation;
import Flightheadlessapirest.internal.graphql.query.v1_0.Query;

import Flightheadlessapirest.resource.v1_0.FlightResource;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Sania Mir
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setFlightResourceComponentServiceObjects(
			_flightResourceComponentServiceObjects);

		Query.setFlightResourceComponentServiceObjects(
			_flightResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/Flightheadlessapirest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<FlightResource>
		_flightResourceComponentServiceObjects;

}