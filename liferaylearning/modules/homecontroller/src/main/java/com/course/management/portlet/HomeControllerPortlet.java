
package com.course.management.portlet;

import com.ats.courses.model.Courses;
import com.ats.courses.service.CoursesLocalServiceUtil;
import com.course.management.constants.HomeControllerPortletKeys;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.social.kernel.service.SocialActivityLocalServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=HomeController",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.name=" + HomeControllerPortletKeys.HOMECONTROLLER,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class HomeControllerPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String coursesType = ParamUtil.getString(renderRequest, "coursesType");
        List<Courses> coursesList;

        if (Validator.isNotNull(coursesType)) {
            coursesList = CoursesLocalServiceUtil.GetAllCoursesTypes(coursesType);
        } else {
            coursesList = CoursesLocalServiceUtil.getCourseses(-1, -1);
        }

        renderRequest.setAttribute("coursesList", coursesList);
        renderRequest.setAttribute("selectedCourseType", coursesType);
        renderRequest.setAttribute("themeDisplay", themeDisplay);

        super.doView(renderRequest, renderResponse);
    }
    public void addCourses(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            String Courses_name = ParamUtil.getString(actionRequest, "Courses_name");
            String Courses_des = ParamUtil.getString(actionRequest, "Courses_des");
            String Courses_type = ParamUtil.getString(actionRequest, "Courses_type");
            String Courses_rating = ParamUtil.getString(actionRequest, "Courses_rating");

            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
            InputStream CoursesImgStream = uploadRequest.getFileAsStream("Courses_img");

            // Add course with initial status as pending
            Courses course = CoursesLocalServiceUtil.addCourses(
                Courses_name, Courses_des, Courses_type, Courses_rating, CoursesImgStream);
            course.setStatus(WorkflowConstants.STATUS_PENDING);
            course = CoursesLocalServiceUtil.updateCourses(course);

            // Start workflow
            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Courses.class.getName(), actionRequest);
            
            WorkflowHandlerRegistryUtil.startWorkflowInstance(
                themeDisplay.getCompanyId(),
                themeDisplay.getScopeGroupId(),
                themeDisplay.getUserId(),
                Courses.class.getName(),
                course.getPrimaryKey(),
                course,
                serviceContext);

            SessionMessages.add(actionRequest, "course-added-success");
        } catch (Exception e) {
            SessionErrors.add(actionRequest, "course-added-error");
            e.printStackTrace();
        }

        actionResponse.sendRedirect(PortalUtil.getCurrentURL(actionRequest));
    }

    public void approveCourse(ActionRequest actionRequest, ActionResponse actionResponse) 
            throws IOException, PortletException {
        updateCourseStatus(actionRequest, WorkflowConstants.STATUS_APPROVED);
        actionResponse.sendRedirect(PortalUtil.getCurrentURL(actionRequest));
    }

    public void rejectCourse(ActionRequest actionRequest, ActionResponse actionResponse) 
            throws IOException, PortletException {
        updateCourseStatus(actionRequest, WorkflowConstants.STATUS_DENIED);
        actionResponse.sendRedirect(PortalUtil.getCurrentURL(actionRequest));
    }

    private void updateCourseStatus(ActionRequest actionRequest, int status) {
        long coursesId = ParamUtil.getLong(actionRequest, "coursesId");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Courses.class.getName(), actionRequest);

            // Get the current workflow task
            WorkflowTask workflowTask = WorkflowTaskManagerUtil.getWorkflowTask(
                themeDisplay.getCompanyId(), 
                ParamUtil.getLong(actionRequest, "workflowTaskId"));

            // Complete the task with transition
            String transitionName = (status == WorkflowConstants.STATUS_APPROVED) 
                ? "approve" : "reject";
            
            WorkflowTaskManagerUtil.completeWorkflowTask(
                themeDisplay.getCompanyId(),
                themeDisplay.getUserId(),
                workflowTask.getWorkflowTaskId(),
                transitionName,
                "Completed by Super Admin",
                (Map<String, Serializable>) serviceContext);

            if (status == WorkflowConstants.STATUS_APPROVED) {
                SessionMessages.add(actionRequest, "course-approved-success");
            } else {
                SessionMessages.add(actionRequest, "course-rejected-success");
            }
        } catch (PortalException e) {
            SessionErrors.add(actionRequest, "course-status-update-error");
            e.printStackTrace();
        }
    }
}