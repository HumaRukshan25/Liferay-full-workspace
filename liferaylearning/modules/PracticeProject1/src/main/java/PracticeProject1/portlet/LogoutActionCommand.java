package PracticeProject1.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import PracticeProject1.constants.PracticeProject1PortletKeys;
import PracticeService1.model.CheckInOutApp;
import PracticeService1.service.CheckInOutAppLocalServiceUtil;

import java.util.Date;
import java.util.List;

@Component(
	property = {
		"javax.portlet.name=" + PracticeProject1PortletKeys.PRACTICEPROJECT1,
		"mvc.command.name=/logoutUser"
	},
	service = MVCActionCommand.class
)

public class LogoutActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		Long userId = (Long) actionRequest.getPortletSession().getAttribute("loggedInUserId");

		if (userId == null) {
			return false;
		}

		try {
			List<CheckInOutApp> logs = CheckInOutAppLocalServiceUtil.getCheckInOutApps(-1, -1);
			for (int i = logs.size() - 1; i >= 0; i--) {
				CheckInOutApp log = logs.get(i);
				if (log.getUserId() == userId && log.getCheckOutTime() == null) {
					log.setCheckOutTime(new Date());
					log.setModifiedDate(new Date());
					CheckInOutAppLocalServiceUtil.updateCheckInOutApp(log);
					break;
				}
			}
			actionRequest.getPortletSession().removeAttribute("loggedInUserId");
			actionResponse.setRenderParameter("mvcPath", "/view.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
