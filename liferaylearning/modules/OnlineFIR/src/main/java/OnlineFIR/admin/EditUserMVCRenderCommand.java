package OnlineFIR.admin;

import OnlineFIR.constants.OnlineFIRPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import fironlineser.model.SignupUser;
import fironlineser.service.SignupUserLocalServiceUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/admin/editUser"
    },
    service = MVCRenderCommand.class
)
public class EditUserMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        long userId = ParamUtil.getLong(renderRequest, "userId");

        try {
            SignupUser user = SignupUserLocalServiceUtil.getSignupUser(userId);
            renderRequest.setAttribute("editUser", user); // ✅ Must match JSP EL
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/edit_user.jsp"; // Place JSP at: src/main/resources/META-INF/resources/
    }
}
