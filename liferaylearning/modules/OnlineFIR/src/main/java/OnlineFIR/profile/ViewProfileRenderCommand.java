package OnlineFIR.profile;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.model.Address;

import org.osgi.service.component.annotations.Component;
import OnlineFIR.constants.OnlineFIRPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/police/viewProfile"
    },
    service = MVCRenderCommand.class
)
public class ViewProfileRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long userId = themeDisplay.getUserId();

            User user = UserLocalServiceUtil.getUser(userId);
            List<Address> addresses = AddressLocalServiceUtil.getAddresses(
                user.getCompanyId(),
                User.class.getName(),
                userId
            );

            renderRequest.setAttribute("userProfile", user);
            renderRequest.setAttribute("addresses", addresses);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/view_profile.jsp";
    }
}
