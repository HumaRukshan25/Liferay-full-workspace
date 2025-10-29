//
//package OnlineFIR.portlet;
//
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.servlet.SessionErrors;
//import com.liferay.portal.kernel.servlet.SessionMessages;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.servlet.http.HttpSession;
//
//import org.osgi.service.component.annotations.Component;
//
//import OnlineFIR.constants.OnlineFIRPortletKeys;
//import fironlineser.model.SignupUser;
//import fironlineser.service.SignupUserLocalServiceUtil;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//        "mvc.command.name=/password/reset"
//    },
//    service = MVCActionCommand.class
//)
//public class ResetPasswordMVCActionCommand implements MVCActionCommand {
//
//    private static final Log log = LogFactoryUtil.getLog(ResetPasswordMVCActionCommand.class);
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
//        String email = ParamUtil.getString(actionRequest, "email");
//        String token = ParamUtil.getString(actionRequest, "token");
//        String newPassword = ParamUtil.getString(actionRequest, "newPassword");
//        String confirmPassword = ParamUtil.getString(actionRequest, "confirmPassword");
//
//        try {
//            HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
//
//            // Validate token using EMAIL as key (not userId)
//            String storedToken = (String) session.getAttribute("RESET_TOKEN_" + email);
//            Date expiryDate = (Date) session.getAttribute("TOKEN_EXPIRY_" + email);
//
//            if (storedToken == null || !storedToken.equals(token)) {
//                SessionErrors.add(actionRequest, "resetError", "Invalid or expired reset token");
//                log.warn("Invalid or expired token for email: " + email);
//                actionResponse.setRenderParameter("mvcPath", "/resetPassword.jsp");
//                actionResponse.setRenderParameter("email", email);
//                actionResponse.setRenderParameter("token", token);
//                return false;
//            }
//
//            if (expiryDate == null || expiryDate.before(new Date())) {
//                SessionErrors.add(actionRequest, "resetError", "Reset token has expired");
//                log.warn("Expired token for email: " + email);
//                actionResponse.setRenderParameter("mvcPath", "/resetPassword.jsp");
//                actionResponse.setRenderParameter("email", email);
//                actionResponse.setRenderParameter("token", token);
//                return false;
//            }
//
//            if (!newPassword.equals(confirmPassword)) {
//                SessionErrors.add(actionRequest, "resetError", "Passwords do not match");
//                log.warn("Passwords do not match for email: " + email);
//                actionResponse.setRenderParameter("mvcPath", "/resetPassword.jsp");
//                actionResponse.setRenderParameter("email", email);
//                actionResponse.setRenderParameter("token", token);
//                return false;
//            }
//
//            // Find user by email and update password
//            List<SignupUser> users = SignupUserLocalServiceUtil.getSignupUsers(0, SignupUserLocalServiceUtil.getSignupUsersCount());
//            SignupUser user = users.stream()
//                .filter(u -> email.equalsIgnoreCase(u.getEmail()))
//                .findFirst()
//                .orElse(null);
//
//            if (user != null) {
//                // Update password in database for this specific email
//                user.setPassword_(newPassword);
//                SignupUserLocalServiceUtil.updateSignupUser(user);
//
//                // Invalidate token
//                session.removeAttribute("RESET_TOKEN_" + email);
//                session.removeAttribute("TOKEN_EXPIRY_" + email);
//                session.removeAttribute("RESET_EMAIL");
//
//                SessionMessages.add(actionRequest, "resetSuccess");
//                log.info("Password reset successful for user: " + user.getEmail());
//            } else {
//                SessionErrors.add(actionRequest, "resetError", "User not found");
//                log.warn("User not found for email: " + email);
//                actionResponse.setRenderParameter("mvcPath", "/resetPassword.jsp");
//                actionResponse.setRenderParameter("email", email);
//                actionResponse.setRenderParameter("token", token);
//                return false;
//            }
//
//        } catch (Exception e) {
//            SessionErrors.add(actionRequest, "resetError", "Error resetting password");
//            log.error("Error resetting password for email: " + email, e);
//            actionResponse.setRenderParameter("mvcPath", "/resetPassword.jsp");
//            actionResponse.setRenderParameter("email", email);
//            actionResponse.setRenderParameter("token", token);
//            return false;
//        }
//
//        actionResponse.setRenderParameter("mvcPath", "/resetPassword.jsp");
//        return false;
//    }
//}


package OnlineFIR.admin;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import OnlineFIR.constants.OnlineFIRPortletKeys;
import fironlineser.model.SignupUser;
import fironlineser.service.SignupUserLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/password/reset"
    },
    service = MVCActionCommand.class
)
public class ResetPasswordMVCActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(ResetPasswordMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        String email = ParamUtil.getString(actionRequest, "email");
        String newPassword = ParamUtil.getString(actionRequest, "newPassword");
        String confirmPassword = ParamUtil.getString(actionRequest, "confirmPassword");

        try {
            // Check if passwords match
            if (!newPassword.equals(confirmPassword)) {
                SessionErrors.add(actionRequest, "resetError");
                log.warn("Passwords do not match for email: " + email);
                actionResponse.setRenderParameter("mvcPath", "/resetPassword.jsp");
                return false;
            }

            // Find user by email
            List<SignupUser> users = SignupUserLocalServiceUtil.getSignupUsers(
                    0, SignupUserLocalServiceUtil.getSignupUsersCount());

            SignupUser user = users.stream()
                .filter(u -> email.equalsIgnoreCase(u.getEmail()))
                .findFirst()
                .orElse(null);

            if (user != null) {
                // Update password
                user.setPassword_(newPassword);
                SignupUserLocalServiceUtil.updateSignupUser(user);

                SessionMessages.add(actionRequest, "resetSuccess");
                log.info("Password reset successful for user: " + user.getEmail());
            } else {
                SessionErrors.add(actionRequest, "resetError");
                log.warn("User not found for email: " + email);
                actionResponse.setRenderParameter("mvcPath", "/resetPassword.jsp");
                return false;
            }

        } catch (Exception e) {
            SessionErrors.add(actionRequest, "resetError");
            log.error("Error resetting password for email: " + email, e);
            actionResponse.setRenderParameter("mvcPath", "/resetPassword.jsp");
            return false;
        }

        actionResponse.setRenderParameter("mvcPath", "/resetPassword.jsp");
        return true;
    }
}

