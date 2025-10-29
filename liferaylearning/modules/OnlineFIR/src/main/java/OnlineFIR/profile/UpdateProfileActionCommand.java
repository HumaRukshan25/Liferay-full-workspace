package OnlineFIR.profile;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import OnlineFIR.constants.OnlineFIRPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/police/updateProfile"
    },
    service = MVCActionCommand.class
)
public class UpdateProfileActionCommand implements MVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(UpdateProfileActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);

            long userId = ParamUtil.getLong(actionRequest, "userId");
            String firstName = ParamUtil.getString(actionRequest, "firstName");
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
            String screenName = ParamUtil.getString(actionRequest, "screenName");

            // Fetch the current user
            User user = UserLocalServiceUtil.getUser(userId);

            // Update user details
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmailAddress(emailAddress);
            user.setScreenName(screenName);

            // Save changes
            UserLocalServiceUtil.updateUser(user);

            _log.info("Profile updated successfully for userId: " + userId);

            // Redirect back to profile view
            actionResponse.setRenderParameter("mvcRenderCommandName", "/police/viewProfile");

        } catch (Exception e) {
            _log.error("Error updating user profile", e);
        }

        return true;
    }
}
