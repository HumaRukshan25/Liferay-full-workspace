package myrest.internal.graphql.mutation.v1_0;

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

import javax.ws.rs.core.UriInfo;

import myrest.dto.v1_0.FIRRR;

import myrest.resource.v1_0.FIRRRResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Sania Mir
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setFIRRRResourceComponentServiceObjects(
		ComponentServiceObjects<FIRRRResource>
			firrrResourceComponentServiceObjects) {

		_firrrResourceComponentServiceObjects =
			firrrResourceComponentServiceObjects;
	}

	@GraphQLField(description = "add FIRRR")
	public FIRRR addFIRRR(@GraphQLName("firrr") FIRRR firrr) throws Exception {
		return _applyComponentServiceObjects(
			_firrrResourceComponentServiceObjects,
			this::_populateResourceContext,
			firrrResource -> firrrResource.addFIRRR(firrr));
	}

	@GraphQLField(description = "update FIRRR")
	public FIRRR updateFIRRR(@GraphQLName("firrr") FIRRR firrr)
		throws Exception {

		return _applyComponentServiceObjects(
			_firrrResourceComponentServiceObjects,
			this::_populateResourceContext,
			firrrResource -> firrrResource.updateFIRRR(firrr));
	}

	@GraphQLField(description = "Delete FIRRR by ID")
	public FIRRR deleteFIRRRById(@GraphQLName("firId") Long firId)
		throws Exception {

		return _applyComponentServiceObjects(
			_firrrResourceComponentServiceObjects,
			this::_populateResourceContext,
			firrrResource -> firrrResource.deleteFIRRRById(firId));
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
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}