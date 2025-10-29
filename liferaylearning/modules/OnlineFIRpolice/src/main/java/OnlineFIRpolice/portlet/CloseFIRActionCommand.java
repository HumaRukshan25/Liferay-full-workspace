package OnlineFIRpolice.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import fironlineser.model.FIRRR;
import fironlineser.service.FIRRRLocalServiceUtil;
import OnlineFIRpolice.constants.OnlineFIRpolicePortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRpolicePortletKeys.ONLINEFIRPOLICE,
        "mvc.command.name=/police/closeFIR"
    },
    service = MVCActionCommand.class
)
public class CloseFIRActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        long firId = ParamUtil.getLong(actionRequest, "firId");

        try {
            FIRRR fir = FIRRRLocalServiceUtil.getFIRRR(firId);
            fir.setStatus("Closed");
            fir.setModificationDetails("FIR closed successfully");
            FIRRRLocalServiceUtil.updateFIRRR(fir);
            
            // ✅ Redirect back to the same render page
            actionResponse.setRenderParameter("mvcRenderCommandName", "/police/viewAssignedFIRs");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}