package com.course.management.portlet;

import com.course.management.constants.HomeControllerPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
	    property = {
	        "com.liferay.portlet.display-category=category.ATS",
	        "com.liferay.portlet.header-portlet-css=/css/main.css",
	        "com.liferay.portlet.instanceable=true",
	        "javax.portlet.display-name=StudentController",
	        "javax.portlet.init-param.template-path=/",
	        "javax.portlet.init-param.view-template=/test.jsp",
	        "javax.portlet.name=" + HomeControllerPortletKeys.SUTUDENTCONTROLLER,
	        "javax.portlet.resource-bundle=content.Language",
	        "javax.portlet.security-role-ref=power-user,user"
	    },
	    service = Portlet.class
	)
public class StudentPortlet extends MVCPortlet {

}
