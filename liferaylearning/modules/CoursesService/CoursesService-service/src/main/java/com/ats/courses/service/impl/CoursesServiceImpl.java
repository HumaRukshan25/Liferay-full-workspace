/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.service.impl;

import com.ats.courses.service.CoursesLocalServiceUtil;
import com.ats.courses.service.base.CoursesServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=ats",
		"json.web.service.context.path=Courses"
	},
	service = AopService.class
)
public class CoursesServiceImpl extends CoursesServiceBaseImpl {
	
	public void addCourses(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		System.out.println("addCourses method inside :::::::::::::::::::::::");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		long userId = themeDisplay.getUserId();
		String userName = "ats";
		String Courses_name = ParamUtil.getString(actionRequest, "Courses_name");
		String Courses_des = ParamUtil.getString(actionRequest, "Courses_des");
		String Courses_type = ParamUtil.getString(actionRequest, "Courses_type");
		String Courses_rating = ParamUtil.getString(actionRequest, "Courses_rating");

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		InputStream CoursesImgStream = uploadPortletRequest.getFileAsStream("Courses_img");

		CoursesLocalServiceUtil.addCourses(Courses_name, Courses_des, Courses_type, Courses_rating, CoursesImgStream);
	
		   
		    SessionMessages.add(actionRequest, "course-added-success");
		} catch (Exception e) {
		    SessionErrors.add(actionRequest, "course-added-error");
		   e.getStackTrace();
		}
	 actionResponse.sendRedirect(PortalUtil.getCurrentURL(actionRequest));
	}
}