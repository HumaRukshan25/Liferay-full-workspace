package OnlineFIR.admin;

import OnlineFIR.constants.OnlineFIRPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import fironlineser.service.SignupUserLocalServiceUtil; // your service builder class

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/admin/deleteUser"
    },
    service = MVCActionCommand.class
)
public class DeleteUserMVCActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(DeleteUserMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        long userId = ParamUtil.getLong(actionRequest, "userId");

        try {
            SignupUserLocalServiceUtil.deleteSignupUser(userId);
            log.info("User deleted successfully with ID: " + userId);
        } catch (Exception e) {
            log.error("Error deleting user with ID: " + userId, e);
        }

        // Redirect back to manage users page
        actionResponse.setRenderParameter("mvcPath", "/manage_users.jsp");
        return true;
    }
}
