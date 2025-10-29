package OnlineFIR.admin;

import OnlineFIR.constants.OnlineFIRPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import fironlineser.model.FIRRR;
import fironlineser.service.FIRRRLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/admin/updateFIR"
    },
    service = MVCActionCommand.class
)
public class UpdateFIRActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        long firId = ParamUtil.getLong(actionRequest, "firId");
        String complainantName = ParamUtil.getString(actionRequest, "complainantName");
        String incidentDetails = ParamUtil.getString(actionRequest, "incidentDetails");
        String incidentLocation = ParamUtil.getString(actionRequest, "incidentLocation");
        String status = ParamUtil.getString(actionRequest, "status");
        String assignedInspector = ParamUtil.getString(actionRequest, "assignedInspector");

        try {
            FIRRR fir = FIRRRLocalServiceUtil.getFIRRR(firId);

            fir.setComplainantName(complainantName);
            fir.setIncidentDetails(incidentDetails);
            fir.setIncidentLocation(incidentLocation);
            fir.setStatus(status);
            fir.setAssignedInspector(assignedInspector);

            FIRRRLocalServiceUtil.updateFIRRR(fir);

            SessionMessages.add(actionRequest, "firUpdated");

            // Redirect back to view page
            actionResponse.setRenderParameter("mvcRenderCommandName", "/admin/viewAllFIRs");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
