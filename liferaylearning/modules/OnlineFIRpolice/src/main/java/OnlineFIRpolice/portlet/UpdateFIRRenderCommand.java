package OnlineFIRpolice.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import OnlineFIRpolice.constants.OnlineFIRpolicePortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRpolicePortletKeys.ONLINEFIRPOLICE,
        "mvc.command.name=/police/updateFIR"
    },
    service = MVCRenderCommand.class
)
public class UpdateFIRRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        return "/updateFIR.jsp";
    }
}