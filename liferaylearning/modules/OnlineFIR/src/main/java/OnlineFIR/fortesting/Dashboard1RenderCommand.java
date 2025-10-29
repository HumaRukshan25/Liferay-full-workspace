package OnlineFIR.fortesting;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.util.List;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=OnlineFIRPortlet",   // your portlet name (check PortletKeys class)
        "mvc.command.name=/dashboard1"           // render command mapping
    },
    service = MVCRenderCommand.class
)
public class Dashboard1RenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        // Fetch all Liferay users
        List<User> users = UserLocalServiceUtil.getUsers(-1, -1);

        // Pass to JSP
        renderRequest.setAttribute("users", users);
        return "/dashboard1.jsp"; // path to your JSP inside src/main/resources/META-INF/resources/
    }
    
}
