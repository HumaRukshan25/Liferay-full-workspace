//package kaleoservice.handler;
//
//import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
//import com.liferay.portal.kernel.workflow.WorkflowConstants;
//import com.liferay.portal.kernel.workflow.WorkflowHandler;
//import com.liferay.portal.kernel.util.GetterUtil;
//import com.liferay.portal.kernel.service.ServiceContext;
//import com.liferay.portal.kernel.exception.PortalException;
//
//import kaleoservice.model.Foo;
//import kaleoservice.service.FooLocalServiceUtil;
//
//import java.io.Serializable;
//import java.util.Locale;
//import java.util.Map;
//
//import org.osgi.service.component.annotations.Component;
//
//@Component(
//	property = {
//		"model.class.name=kaleoservice.model.Foo"
//	},
//	service = WorkflowHandler.class
//)
//public class FooWorkflowHandler extends BaseWorkflowHandler<Foo> {
//
//	@Override
//	public String getClassName() {
//		return Foo.class.getName();
//	}
//
//	@Override
//	public String getType(Locale locale) {
//		return "Foo Workflow";
//	}
//
//	@Override
//	public Foo updateStatus(int status, Map<String, Serializable> workflowContext)
//			throws PortalException {
//
//		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
//		long classPK = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
//		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");
//
//		return FooLocalServiceUtil.updateStatus(userId, classPK, status, serviceContext);
//	}
//}


package kaleoservice.handler;

import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.exception.PortalException;

import kaleoservice.model.Foo;
import kaleoservice.service.FooLocalServiceUtil;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "model.class.name=kaleoservice.model.Foo"
    },
    service = WorkflowHandler.class
)
public class FooWorkflowHandler extends BaseWorkflowHandler<Foo> {

    @Override
    public String getClassName() {
        return Foo.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "Foo Workflow";
    }

    @Override
    public Foo updateStatus(int status, Map<String, Serializable> workflowContext)
        throws PortalException {

        long userId = GetterUtil.getLong(
            (String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long classPK = GetterUtil.getLong(
            (String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        ServiceContext serviceContext = (ServiceContext)workflowContext.get(
            WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

        return FooLocalServiceUtil.updateStatus(
            userId, classPK, status, serviceContext);
    }
}
