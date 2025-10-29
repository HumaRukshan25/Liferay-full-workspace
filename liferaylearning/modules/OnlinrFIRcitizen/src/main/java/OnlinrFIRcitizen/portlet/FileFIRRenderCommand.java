package OnlinrFIRcitizen.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.util.List;

import OnlinrFIRcitizen.constants.OnlinrFIRcitizenPortletKeys;
import fironlineser.model.FIRRR;
import fironlineser.service.FIRRRLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlinrFIRcitizenPortletKeys.ONLINRFIRCITIZEN,
        "mvc.command.name=/citizen/fileFIR"
    },
    service = MVCRenderCommand.class
)
public class FileFIRRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long userId = themeDisplay.getUserId();

            // Fetch FIRs for the logged-in user
            List<FIRRR> firs = FIRRRLocalServiceUtil.getFIRRRs(-1, -1);
            renderRequest.setAttribute("firs", firs);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/fileFIR.jsp"; // JSP page to render
    }
}