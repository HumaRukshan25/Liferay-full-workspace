package OnlineFIR.admin;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import com.liferay.portal.kernel.servlet.SessionMessages;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import OnlineFIR.constants.OnlineFIRPortletKeys;
import fironlineser.model.SignupUser;
import fironlineser.service.SignupUserLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/admin/saveUser"
    },
    service = MVCActionCommand.class
)
public class AddUserActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        try {
            long signupUserId = CounterLocalServiceUtil.increment(SignupUser.class.getName());

            String loginName = ParamUtil.getString(actionRequest, "loginName");
            String firstName = ParamUtil.getString(actionRequest, "firstName");
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            String email = ParamUtil.getString(actionRequest, "email");
            String phoneNo = ParamUtil.getString(actionRequest, "phoneNo");
            String role = ParamUtil.getString(actionRequest, "role");
            boolean active = ParamUtil.getBoolean(actionRequest, "active");

            SignupUser user = SignupUserLocalServiceUtil.createSignupUser(signupUserId);
            user.setLoginName(loginName);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhoneNo(phoneNo);
            user.setRole(role);
            user.setActive(active);

            SignupUserLocalServiceUtil.addSignupUser(user);

            SessionMessages.add(actionRequest, "user-added-success");

            // redirect back to Manage Users
            actionResponse.setRenderParameter("mvcRenderCommandName", "/admin/manageUsers");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
