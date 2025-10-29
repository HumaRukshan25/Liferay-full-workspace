package OnlineFIR.admin;

import OnlineFIR.constants.OnlineFIRPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import fironlineser.model.SignupUser;
import fironlineser.service.SignupUserLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/admin/updateUser"
    },
    service = MVCActionCommand.class
)
public class UpdateUserMVCActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        long userId = ParamUtil.getLong(actionRequest, "userId");
        String firstName = ParamUtil.getString(actionRequest, "firstName");
        String lastName = ParamUtil.getString(actionRequest, "lastName");
        String email = ParamUtil.getString(actionRequest, "email");
        String phone = ParamUtil.getString(actionRequest, "phoneNo");
        String role = ParamUtil.getString(actionRequest, "role");
        boolean active = ParamUtil.getBoolean(actionRequest, "active");

        SignupUser user = SignupUserLocalServiceUtil.fetchSignupUser(userId);

        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhoneNo(phone);
            user.setRole(role);
            user.setActive(active);

            SignupUserLocalServiceUtil.updateSignupUser(user);
            SessionMessages.add(actionRequest, "userUpdated");
        }

        // Redirect back to Manage Users page
        actionResponse.setRenderParameter("mvcRenderCommandName", "/admin/manageUsers");
        return true;
    }
}
