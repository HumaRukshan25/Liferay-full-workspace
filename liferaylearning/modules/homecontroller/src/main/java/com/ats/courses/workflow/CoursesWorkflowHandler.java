package com.ats.courses.workflow;

import com.ats.courses.model.Courses;
import com.ats.courses.service.CoursesLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {"model.class.name=com.ats.courses.model.Courses"},
    service = WorkflowHandler.class
)
public class CoursesWorkflowHandler extends BaseWorkflowHandler<Courses> {

    @Override
    public String getClassName() {
        return Courses.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "Course";
    }

    @Override
    public Courses updateStatus(
            int status, Map<String, Serializable> workflowContext)
        throws PortalException {

        long userId = GetterUtil.getLong(
            (String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long classPK = GetterUtil.getLong(
            (String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext)workflowContext.get(
            WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

        return CoursesLocalServiceUtil.updateStatus(
            userId, classPK, status, serviceContext);
    }
}