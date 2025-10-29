package OnlineFIRpolice.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

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
        "mvc.command.name=/police/acceptFIR"
    },
    service = MVCActionCommand.class
)
public class AcceptFIRActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        long firId = ParamUtil.getLong(actionRequest, "firId");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            FIRRR fir = FIRRRLocalServiceUtil.getFIRRR(firId);
            fir.setStatus("Accepted");
            fir.setModificationDetails("Accepted by: " + themeDisplay.getUser().getFullName());
            FIRRRLocalServiceUtil.updateFIRRR(fir);
            
            // ✅ Redirect back to the same render page
            actionResponse.setRenderParameter("mvcRenderCommandName", "/police/viewAssignedFIRs");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}