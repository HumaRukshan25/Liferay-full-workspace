package OnlineFIR.fortesting;

import OnlineFIR.constants.OnlineFIRPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
                "mvc.command.name=/admin/updateUser12"
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
        String screenName = ParamUtil.getString(actionRequest, "screenName");
        boolean active = ParamUtil.getBoolean(actionRequest, "active");

        try {
            // Fetch existing user
            User user = UserLocalServiceUtil.getUser(userId);

            // Update fields
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmailAddress(email);
            user.setScreenName(screenName);
            user.setStatus(active ? 0 : 5); // 0 = active, 5 = inactive

            // Save changes through Liferay service
            UserLocalServiceUtil.updateUser(user);

            SessionMessages.add(actionRequest, "userUpdated");

        } catch (PortalException e) {
            e.printStackTrace();
        }

        // Redirect back to edit page
        actionResponse.setRenderParameter("mvcRenderCommandName", "/admin/editUser1");
        actionResponse.setRenderParameter("userId", String.valueOf(userId));

        return true;
    }
}
