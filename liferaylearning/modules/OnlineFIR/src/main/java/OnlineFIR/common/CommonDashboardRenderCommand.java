//package OnlineFIR.common;
//
//import com.liferay.portal.kernel.model.Role;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.WebKeys;
//import org.osgi.service.component.annotations.Component;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import java.util.List;
//import OnlineFIR.constants.OnlineFIRPortletKeys;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//        "mvc.command.name=/common/dashboard"
//    },
//    service = MVCRenderCommand.class
//)
//public class CommonDashboardRenderCommand implements MVCRenderCommand {
//
//    @Override
//    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
//        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//        User user = themeDisplay.getUser();
//
//        try {
//            List<Role> roles = user.getRoles();
//
//            for (Role role : roles) {
//                String roleName = role.getName().toLowerCase();
//
//                if (roleName.contains("admin")) {
//                    return "/dashboard1.jsp";
//                } else if (roleName.contains("police")) {
//                    return "/police_dashboard.jsp";
//                } else if (roleName.contains("inspector")) {
//                    return "/police_dashboard.jsp";
//                } else if (roleName.contains("citizen")) {
//                    return "/citizen_dashboard.jsp";
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Default fallback
//        return "/admin_error.jsp";
//    }
//}


package OnlineFIR.common;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import OnlineFIR.constants.OnlineFIRPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/common/dashboard"
    },
    service = MVCRenderCommand.class
)
public class CommonDashboardRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            User user = themeDisplay.getUser();

            HttpServletRequest request = PortalUtil.getOriginalServletRequest(
                    PortalUtil.getHttpServletRequest(renderRequest));
            HttpSession session = request.getSession(false);

            // ✅ Ensure OTP verified before proceeding
            Boolean otpVerified = (session != null) ? (Boolean) session.getAttribute("OTP_VERIFIED") : false;
            if (otpVerified == null || !otpVerified) {
                return "/otp_verification.jsp"; // not verified → back to OTP page
            }

            // ✅ Role-based dashboard
            List<Role> roles = user.getRoles();
            for (Role role : roles) {
                String roleName = role.getName().toLowerCase();

                if (roleName.contains("admin")) {
                    return "/dashboard1.jsp";
                } else if (roleName.contains("police")) {
                    return "/police_dashboard.jsp";
                } else if (roleName.contains("inspector")) {
                    return "/police_dashboard.jsp";
                } else if (roleName.contains("citizen")) {
                    return "/citizen_dashboard.jsp";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Default fallback
        return "/admin_error.jsp";
    }
}

