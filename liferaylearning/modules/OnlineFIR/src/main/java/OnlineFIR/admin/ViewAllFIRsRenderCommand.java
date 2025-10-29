//
//package OnlineFIR.admin;
//
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import javax.portlet.PortletException;
//
//import org.osgi.service.component.annotations.Component;
//import java.util.List;
//
//import OnlineFIR.constants.OnlineFIRPortletKeys;
//import fironlineser.model.FIRRR;
//import fironlineser.service.FIRRRLocalServiceUtil;
//
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//        "mvc.command.name=/admin/viewAllFIRs"
//    },
//    service = MVCRenderCommand.class
//)
//public class ViewAllFIRsRenderCommand implements MVCRenderCommand {
//
//    @Override
//    public String render(RenderRequest request, RenderResponse response)
//            throws PortletException {
//
//        try {
//            // ✅ Fetch all FIRs from database
//            List<FIRRR> firs = FIRRRLocalServiceUtil.getFIRRRs(-1, -1);
//
//            // ✅ Set list to request for JSP
//            request.setAttribute("firs", firs);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // ✅ Return JSP page path
//        return "/viewAllFIRs.jsp";
//    }
//}
//

package OnlineFIR.admin;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import fironlineser.model.FIRRR;
import fironlineser.service.FIRRRLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;
import java.util.ArrayList;
import OnlineFIR.constants.OnlineFIRPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/admin/viewAllFIRs"
    },
    service = MVCRenderCommand.class
)
public class ViewAllFIRsRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest request, RenderResponse response) {
        try {
            List<FIRRR> firs = FIRRRLocalServiceUtil.getFIRRRs(-1, -1);

            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            long companyId = themeDisplay.getCompanyId();

            List<User> inspectors;
            try {
                inspectors = UserLocalServiceUtil.getRoleUsers(
                        RoleLocalServiceUtil.getRole(companyId, "Inspector").getRoleId()
                );
            } catch (Exception e) {
                inspectors = new ArrayList<>();
            }

            request.setAttribute("firs", firs);
            request.setAttribute("inspectors", inspectors);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/viewAllFIRs.jsp";
    }
}
