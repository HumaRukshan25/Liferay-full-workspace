package OnlineFIRpolice.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import java.util.List;

import OnlineFIRpolice.constants.OnlineFIRpolicePortletKeys;
import fironlineser.model.PoliceStation;
import fironlineser.service.PoliceStationLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRpolicePortletKeys.ONLINEFIRPOLICE,
        "mvc.command.name=/admin/stationManagement"
    },
    service = MVCRenderCommand.class
)
public class StationManagementMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        try {
            List<PoliceStation> stations = PoliceStationLocalServiceUtil.getPoliceStations(-1, -1);
            renderRequest.setAttribute("stations", stations);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/station_management.jsp";
    }
}