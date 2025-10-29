package com.lib.myfirst.portlet;

import com.lib.myfirst.constants.MyfirstprojectPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

import org.osgi.service.component.annotations.Component;

//@Component(
//	property = {
//		"com.liferay.portlet.display-category=category.sample",
//		"com.liferay.portlet.header-portlet-css=/css/main.css",
//		"com.liferay.portlet.instanceable=true",
//		"javax.portlet.display-name=Myfirstproject",
//		"javax.portlet.init-param.template-path=/",
//		"javax.portlet.init-param.view-template=/view.jsp",
//		"javax.portlet.name=" + MyfirstprojectPortletKeys.MYFIRSTPROJECT,
//		"javax.portlet.resource-bundle=content.Language",
//		"javax.portlet.security-role-ref=power-user,user"
//	},
//	service = Portlet.class
//)
//public class MyfirstprojectPortlet extends MVCPortlet {
//
//	@Override
//	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
//			throws IOException, PortletException {
//		renderRequest.setAttribute("myString", "Hello from doView!");
//		super.doView(renderRequest, renderResponse);
//	}
//
//	@Override
//	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
//			throws IOException, PortletException {
//		@SuppressWarnings("deprecation")
//		String ajaxParam = resourceRequest.getParameter("ajaxParam");
//		resourceResponse.getWriter().write("AJAX param received: " + ajaxParam);
//	}
//}
@Component(
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Myfirstproject",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + MyfirstprojectPortletKeys.MYFIRSTPROJECT,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
	public class MyfirstprojectPortlet extends MVCPortlet {

		@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			renderRequest.setAttribute("myString", "Hello from doView()");
			super.doView(renderRequest, renderResponse);
		}
	}
