//package OnlineFIR.police;
//
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import org.osgi.service.component.annotations.Component;
//import OnlineFIR.constants.OnlineFIRPortletKeys;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//        "mvc.command.name=/police/fileFIR"
//    },
//    service = MVCRenderCommand.class
//)
//public class FileFIRRenderCommand implements MVCRenderCommand {
//    @Override
//    public String render(RenderRequest request, RenderResponse response) {
//        return "/fileFIR.jsp";
//    }
//}


package OnlineFIR.police;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

import java.util.List;

import OnlineFIR.constants.OnlineFIRPortletKeys;
import fironlineser.model.FIRRR;
import fironlineser.service.FIRRRLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/police/fileFIR"
    },
    service = MVCRenderCommand.class
)
public class FileFIRRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest request, RenderResponse response) {
        try {
            // ✅ Fetch all FIRs
            List<FIRRR> allFIRs = FIRRRLocalServiceUtil.getFIRRRs(-1, -1);
            
            // ✅ Set to request for JSP
            request.setAttribute("firs", allFIRs);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ✅ Forward to JSP
        return "/fileFIR1.jsp";
    }
}
