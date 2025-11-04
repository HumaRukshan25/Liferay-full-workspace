package Flightheadlessapirest.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sania Mir
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/Flightheadlessapirest",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=Flightheadlessapirest"
	},
	service = Application.class
)
@Generated("")
public class FlightheadlessapirestApplication extends Application {
}