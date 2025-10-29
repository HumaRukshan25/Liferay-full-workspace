//package kaleomodule.portlet;
//
//import kaleomodule.constants.KaleomodulePortletKeys;
//
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
//
//import javax.portlet.Portlet;
//
//import org.osgi.service.component.annotations.Component;
//
///**
// * @author Sania Mir
// */
//@Component(
//	property = {
//		"com.liferay.portlet.display-category=category.sample",
//		"com.liferay.portlet.header-portlet-css=/css/main.css",
//		"com.liferay.portlet.instanceable=true",
//		"javax.portlet.display-name=Kaleomodule",
//		"javax.portlet.init-param.template-path=/",
//		"javax.portlet.init-param.view-template=/view.jsp",
//		"javax.portlet.name=" + KaleomodulePortletKeys.KALEOMODULE,
//		"javax.portlet.resource-bundle=content.Language",
//		"javax.portlet.security-role-ref=power-user,user"
//	},
//	service = Portlet.class
//)
//public class KaleomodulePortlet extends MVCPortlet {
//}

package kaleomodule.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.exception.PortalException;

import kaleomodule.constants.KaleomodulePortletKeys;
import kaleoservice.model.Foo;
import kaleoservice.service.FooLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import java.io.IOException;
import java.util.Date;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Kaleomodule",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + KaleomodulePortletKeys.KALEOMODULE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class KaleomodulePortlet extends MVCPortlet {

	public void createFoo(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String field1 = ParamUtil.getString(actionRequest, "field1");
		String field5 = ParamUtil.getString(actionRequest, "field5");

		Foo foo = FooLocalServiceUtil.createFoo(0);
		foo.setField1(field1);
		foo.setField5(field5);
		foo.setGroupId(themeDisplay.getScopeGroupId());
		foo.setCompanyId(themeDisplay.getCompanyId());
		foo.setUserId(themeDisplay.getUserId());
		foo.setUserName(themeDisplay.getUser().getFullName());
		foo.setCreateDate(new Date());
		foo.setModifiedDate(new Date());
		foo.setStatus(0); // Pending

		foo = FooLocalServiceUtil.addFoo(foo);

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Foo.class.getName(), actionRequest);

			WorkflowHandlerRegistryUtil.startWorkflowInstance(
				themeDisplay.getCompanyId(),
				themeDisplay.getScopeGroupId(),
				themeDisplay.getUserId(),
				Foo.class.getName(),
				foo.getPrimaryKey(),
				foo,
				serviceContext
			);
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}
}
