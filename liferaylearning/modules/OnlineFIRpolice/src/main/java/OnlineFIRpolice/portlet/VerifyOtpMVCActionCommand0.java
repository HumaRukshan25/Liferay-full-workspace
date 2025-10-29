package OnlineFIRpolice.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

import java.util.List;

import OnlineFIRpolice.constants.OnlineFIRpolicePortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRpolicePortletKeys.ONLINEFIRPOLICE,
        "mvc.command.name=/otp/verify"
    },
    service = MVCActionCommand.class
)
public class VerifyOtpMVCActionCommand0 implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(VerifyOtpMVCActionCommand0.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        try {
            HttpServletRequest request = PortalUtil.getOriginalServletRequest(
                PortalUtil.getHttpServletRequest(actionRequest)
            );

            HttpSession session = request.getSession(false);

            if (session == null) {
                log.error("No session found for OTP verification");
                actionResponse.setRenderParameter("mvcPath", "/admin_error.jsp");
                return true;
            }

            String expectedOtp = (String) session.getAttribute("EXPECTED_OTP");
            String enteredOtp = ParamUtil.getString(actionRequest, "otp");

            log.info("Expected OTP: " + expectedOtp + ", Entered OTP: " + enteredOtp);

            if (expectedOtp != null && expectedOtp.equals(enteredOtp)) {
                log.info("✅ OTP Verified Successfully");

                // ✅ Remove old OTP
                session.removeAttribute("EXPECTED_OTP");

                // ✅ Mark user as verified
                session.setAttribute("OTP_VERIFIED", true);

                // ✅ Get logged-in user
                long userId = PortalUtil.getUserId(request);
                User user = UserLocalServiceUtil.getUser(userId);

                // ✅ Fetch user roles
                List<Role> roles = RoleLocalServiceUtil.getUserRoles(userId);

                String redirectPage = "/admin_error.jsp"; // default fallback

                for (Role role : roles) {
                    String roleName = role.getName();
                    log.info("User has role: " + roleName);

                    if ("Administrator".equalsIgnoreCase(roleName)) {
                        redirectPage = "/dashboard1.jsp";
                        break;
                    } else if ("Police".equalsIgnoreCase(roleName)) {
                        redirectPage = "/police_dashboard.jsp";
                        break;
                    } else if ("Inspector".equalsIgnoreCase(roleName)) {
                        redirectPage = "/police_dashboard.jsp";
                        break;
                    } else if ("Citizen".equalsIgnoreCase(roleName)) {
                        redirectPage = "/citizen_dashboard.jsp";
                        break;
                    }
                }

                // ✅ Forward to correct dashboard
                actionResponse.setRenderParameter("mvcPath", redirectPage);

            } else {
                log.info("❌ OTP Verification Failed");
                actionResponse.setRenderParameter("mvcPath", "/admin_error.jsp");
            }

        } catch (Exception e) {
            log.error("Error verifying OTP", e);
            actionResponse.setRenderParameter("mvcPath", "/admin_error.jsp");
        }

        return true;
    }
}