package OnlineFIR.admin;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import fironlineser.service.FIRRRLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import OnlineFIR.constants.OnlineFIRPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/admin/deleteFIR"
    },
    service = MVCActionCommand.class
)
public class DeleteFIRActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) {
        long firId = ParamUtil.getLong(request, "firId");

        try {
            FIRRRLocalServiceUtil.deleteFIRRR(firId);

            // ✅ Redirect back to the main FIR list
            response.setRenderParameter("mvcRenderCommandName", "/admin/viewAllFIRs");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true; // ✅ Must return true
    }
}
