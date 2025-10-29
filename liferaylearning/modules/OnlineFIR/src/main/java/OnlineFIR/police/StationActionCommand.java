//
//package OnlineFIR.police;
//
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.model.Role;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.WebKeys;
//import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
//import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//
//import org.osgi.service.component.annotations.Component;
//
//import OnlineFIR.constants.OnlineFIRPortletKeys;
//import fironlineser.model.PoliceStation;
//import fironlineser.service.PoliceStationLocalServiceUtil;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import java.util.Date;
//import java.util.List;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//        "mvc.command.name=/admin/manageStationAction"
//    },
//    service = MVCActionCommand.class
//)
//public class StationActionCommand implements MVCActionCommand {
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
//        String actionType = ParamUtil.getString(actionRequest, "actionType");
//        String stationName = ParamUtil.getString(actionRequest, "stationName");
//        String address = ParamUtil.getString(actionRequest, "address");
//        String area = ParamUtil.getString(actionRequest, "jurisdictionArea");
//        long stationId = ParamUtil.getLong(actionRequest, "stationId");
//
//        try {
//            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//
//            // Fetch officer in charge (first user with "Police" role)
//            String officerName = "";
//            try {
//                long companyId = themeDisplay.getCompanyId();
//                Role policeRole = RoleLocalServiceUtil.getRole(companyId, "Police");
//                List<User> policeUsers = UserLocalServiceUtil.getRoleUsers(policeRole.getRoleId());
//                if (!policeUsers.isEmpty()) {
//                    officerName = policeUsers.get(0).getFullName();
//                }
//            } catch (PortalException e) {
//                e.printStackTrace();
//            }
//
//            if ("add".equalsIgnoreCase(actionType)) {
//                long newStationId = CounterLocalServiceUtil.increment(PoliceStation.class.getName());
//                PoliceStation station = PoliceStationLocalServiceUtil.createPoliceStation(newStationId);
//
//                station.setStationName(stationName);
//                station.setAddress(address);
//                station.setJurisdictionArea(area);
//                station.setStatus("Active");
//                station.setUserId(themeDisplay.getUserId());
//                station.setUserName(themeDisplay.getUser().getFullName());
//                station.setOfficerInCharge(officerName); // set officer in charge
//                station.setCreateDate(new Date());
//                station.setModifiedDate(new Date());
//
//                PoliceStationLocalServiceUtil.addPoliceStation(station);
//
//            } else if ("update".equalsIgnoreCase(actionType)) {
//                PoliceStation station = PoliceStationLocalServiceUtil.getPoliceStation(stationId);
//
//                station.setStationName(stationName);
//                station.setAddress(address);
//                station.setJurisdictionArea(area);
//                station.setOfficerInCharge(officerName); // update officer
//                station.setModifiedDate(new Date());
//
//                PoliceStationLocalServiceUtil.updatePoliceStation(station);
//
//            } else if ("delete".equalsIgnoreCase(actionType)) {
//                PoliceStationLocalServiceUtil.deletePoliceStation(stationId);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return true;
//    }
//}
//



package OnlineFIR.police;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import org.osgi.service.component.annotations.Component;

import OnlineFIR.constants.OnlineFIRPortletKeys;
import fironlineser.model.PoliceStation;
import fironlineser.service.PoliceStationLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;
import java.util.List;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/admin/manageStationAction"
    },
    service = MVCActionCommand.class
)
public class StationActionCommand implements MVCActionCommand {

    private int lastAssignedIndex = -1; // keeps track of last assigned officer

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        String actionType = ParamUtil.getString(actionRequest, "actionType");
        String stationName = ParamUtil.getString(actionRequest, "stationName");
        String address = ParamUtil.getString(actionRequest, "address");
        String area = ParamUtil.getString(actionRequest, "jurisdictionArea");
        long stationId = ParamUtil.getLong(actionRequest, "stationId");

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long companyId = themeDisplay.getCompanyId();

            // Fetch all police users
            Role policeRole = RoleLocalServiceUtil.getRole(companyId, "Police");
            List<User> policeUsers = UserLocalServiceUtil.getRoleUsers(policeRole.getRoleId());

            String officerName = "";
            if (!policeUsers.isEmpty()) {
                // Round-robin assignment
                lastAssignedIndex = (lastAssignedIndex + 1) % policeUsers.size();
                officerName = policeUsers.get(lastAssignedIndex).getFullName();
            }

            if ("add".equalsIgnoreCase(actionType)) {
                long newStationId = CounterLocalServiceUtil.increment(PoliceStation.class.getName());
                PoliceStation station = PoliceStationLocalServiceUtil.createPoliceStation(newStationId);

                station.setStationName(stationName);
                station.setAddress(address);
                station.setJurisdictionArea(area);
                station.setStatus("Active");
                station.setUserId(themeDisplay.getUserId());
                station.setUserName(themeDisplay.getUser().getFullName());
                station.setOfficerInCharge(officerName);
                station.setCreateDate(new Date());
                station.setModifiedDate(new Date());

                PoliceStationLocalServiceUtil.addPoliceStation(station);

            } else if ("update".equalsIgnoreCase(actionType)) {
                PoliceStation station = PoliceStationLocalServiceUtil.getPoliceStation(stationId);

                station.setStationName(stationName);
                station.setAddress(address);
                station.setJurisdictionArea(area);
                station.setOfficerInCharge(officerName); // update officer fairly
                station.setModifiedDate(new Date());

                PoliceStationLocalServiceUtil.updatePoliceStation(station);

            } else if ("delete".equalsIgnoreCase(actionType)) {
                PoliceStationLocalServiceUtil.deletePoliceStation(stationId);
            }

            
         // ✅ Redirect back to Station Management page after action
            actionResponse.setRenderParameter(
                "mvcRenderCommandName", "/admin/stationManagement" );
        } catch (PortalException e) {
            e.printStackTrace();
        }

        return true;
    }
}
