package OnlineFIR.admin;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import fironlineser.model.FIRRR;
import fironlineser.service.FIRRRLocalServiceUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;
import org.osgi.service.component.annotations.Component;
import OnlineFIR.constants.OnlineFIRPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/admin/editFIR"
    },
    service = MVCRenderCommand.class
)
public class EditFIRRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        long firId = ParamUtil.getLong(renderRequest, "firId");

        FIRRR fir = FIRRRLocalServiceUtil.fetchFIRRR(firId);
        renderRequest.setAttribute("fir", fir);

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            Role inspectorRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Inspector");
            List<User> inspectors = UserLocalServiceUtil.getRoleUsers(inspectorRole.getRoleId());
            renderRequest.setAttribute("inspectors", inspectors);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/updateFIR.jsp";
    }
}
