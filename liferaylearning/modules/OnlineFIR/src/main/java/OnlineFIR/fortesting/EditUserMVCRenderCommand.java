package OnlineFIR.fortesting;

import OnlineFIR.constants.OnlineFIRPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/admin/editUser1"
    },
    service = MVCRenderCommand.class
)
public class EditUserMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        long userId = ParamUtil.getLong(renderRequest, "userId");

        try {
            User user = UserLocalServiceUtil.getUser(userId);
            renderRequest.setAttribute("editUser", user); // type-safe
        } catch (PortalException e) {
            e.printStackTrace();
        }

        return "/edit_user1.jsp"; // Place JSP here
    }
}
