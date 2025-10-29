package PracticeProject1.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import PracticeProject1.constants.PracticeProject1PortletKeys;
import PracticeService1.model.UserProfile;
import PracticeService1.model.CheckInOutApp;
import PracticeService1.service.UserProfileLocalServiceUtil;
import PracticeService1.service.CheckInOutAppLocalServiceUtil;

import java.util.Date;
import java.util.List;

@Component(
	property = {
		"javax.portlet.name=" + PracticeProject1PortletKeys.PRACTICEPROJECT1,
		"mvc.command.name=/loginUser"
	},
	service = MVCActionCommand.class
)
public class LoginActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		String username = ParamUtil.getString(actionRequest, "username");
		String password = ParamUtil.getString(actionRequest, "password");

		try {
			List<UserProfile> users = UserProfileLocalServiceUtil.getUserProfiles(-1, -1);
			for (UserProfile user : users) {
				if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
					actionRequest.getPortletSession().setAttribute("loggedInUserId", user.getUserId());

					long logId = CounterLocalServiceUtil.increment(CheckInOutApp.class.getName());
					CheckInOutApp log = CheckInOutAppLocalServiceUtil.createCheckInOutApp(logId);
					log.setUserId(user.getUserId());
					log.setUserName(user.getUserName());
					log.setCheckInTime(new Date());
					log.setCreateDate(new Date());
					CheckInOutAppLocalServiceUtil.addCheckInOutApp(log);

					actionResponse.setRenderParameter("mvcPath", "/dashboard.jsp");
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
