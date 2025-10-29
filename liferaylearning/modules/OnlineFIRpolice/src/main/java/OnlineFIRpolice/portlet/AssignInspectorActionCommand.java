package OnlineFIRpolice.portlet;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import OnlineFIRpolice.constants.OnlineFIRpolicePortletKeys;
import fironlineser.model.FIRRR;
import fironlineser.service.FIRRRLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRpolicePortletKeys.ONLINEFIRPOLICE,
        "mvc.command.name=/police/assignInspector"
    },
    service = MVCActionCommand.class
)
public class AssignInspectorActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        long firId = ParamUtil.getLong(actionRequest, "firId");
        long inspectorId = ParamUtil.getLong(actionRequest, "inspectorId");

        try {
            FIRRR fir = FIRRRLocalServiceUtil.getFIRRR(firId);
            User inspector = UserLocalServiceUtil.getUser(inspectorId);

            fir.setAssignedInspector(inspector.getFullName());
            fir.setStatus("Under Investigation");
            FIRRRLocalServiceUtil.updateFIRRR(fir);

            actionResponse.setRenderParameter("mvcRenderCommandName", "/police/viewAssignedFIRs");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}


