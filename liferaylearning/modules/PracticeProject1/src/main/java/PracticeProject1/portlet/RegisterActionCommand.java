package PracticeProject1.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import PracticeProject1.constants.PracticeProject1PortletKeys;
import PracticeService1.model.UserProfile;
import PracticeService1.service.UserProfileLocalServiceUtil;


@Component(
	property = {
		"javax.portlet.name=" + PracticeProject1PortletKeys.PRACTICEPROJECT1,
		"mvc.command.name=/registerUser"
	},
	service = MVCActionCommand.class
)
public class RegisterActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		String username = ParamUtil.getString(actionRequest, "username");
		String password = ParamUtil.getString(actionRequest, "password");

		try {
			long userId = System.currentTimeMillis(); // Simple unique ID generation
			UserProfile user = UserProfileLocalServiceUtil.createUserProfile(userId);
			user.setUserId(userId);
			user.setUserName(username);
			user.setPassword(password);

			UserProfileLocalServiceUtil.addUserProfile(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
