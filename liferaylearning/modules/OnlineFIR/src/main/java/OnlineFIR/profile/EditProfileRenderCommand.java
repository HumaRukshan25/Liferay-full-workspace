package OnlineFIR.profile;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import org.osgi.service.component.annotations.Component;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import OnlineFIR.constants.OnlineFIRPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/editProfile"
    },
    service = MVCRenderCommand.class
)
public class EditProfileRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long userId = themeDisplay.getUserId();
            User user = UserLocalServiceUtil.getUser(userId);

            renderRequest.setAttribute("userProfile", user);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/editProfile.jsp";
    }
}
