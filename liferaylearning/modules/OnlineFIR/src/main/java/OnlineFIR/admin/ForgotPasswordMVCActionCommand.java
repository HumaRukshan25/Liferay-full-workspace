//package OnlineFIR.portlet;
//
//import com.liferay.mail.kernel.model.MailMessage;
//import com.liferay.mail.kernel.service.MailServiceUtil;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.servlet.SessionErrors;
//import com.liferay.portal.kernel.servlet.SessionMessages;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.WebKeys;
//
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//import javax.mail.internet.InternetAddress;
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
//        "mvc.command.name=/password/forgot"
//    },
//    service = MVCActionCommand.class
//)
//public class ForgotPasswordMVCActionCommand implements MVCActionCommand {
//
//    private static final Log log = LogFactoryUtil.getLog(ForgotPasswordMVCActionCommand.class);
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
//        String email = ParamUtil.getString(actionRequest, "email");
//        
//        try {
//            // Find user by email in custom SignupUser table
//            List<SignupUser> users = SignupUserLocalServiceUtil.getSignupUsers(0, SignupUserLocalServiceUtil.getSignupUsersCount());
//            SignupUser user = users.stream()
//                .filter(u -> email.equalsIgnoreCase(u.getEmail()))
//                .findFirst()
//                .orElse(null);
//            
//            if (user != null) {
//                // Generate reset token
//                String resetToken = UUID.randomUUID().toString();
//                Date expirationDate = new Date(System.currentTimeMillis() + (60 * 60 * 1000)); // 1 hour
//                
//                // Store token in session
//                HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
//                session.setAttribute("RESET_TOKEN_" + user.getSignupUserId(), resetToken);
//                session.setAttribute("TOKEN_EXPIRY_" + user.getSignupUserId(), expirationDate);
//                session.setAttribute("RESET_USER_ID", user.getSignupUserId());
//                session.setAttribute("RESET_USER_TYPE", "custom");
//                
//                // Send reset email
//                sendResetEmail(user, resetToken, actionRequest);
//                
//                SessionMessages.add(actionRequest, "resetLinkSent");
//                log.info("Password reset link sent to: " + email);
//            } else {
//                SessionErrors.add(actionRequest, "resetError", "No account found with this email address");
//                log.warn("Password reset attempt for non-existent email: " + email);
//            }
//        } catch (Exception e) {
//            SessionErrors.add(actionRequest, "resetError", "Error processing your request");
//            log.error("Error in password reset process: " + e.getMessage(), e);
//        }
//        
//        actionResponse.setRenderParameter("mvcPath", "/forgotPassword.jsp");
//        return false;
//    }
//    
//    private void sendResetEmail(SignupUser user, String token, ActionRequest actionRequest) {
//        try {
//            // Get theme display for proper URL construction
//            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//            String portalURL = themeDisplay.getPortalURL();
//            
//            String resetURL = portalURL + "/online-fir1?p_p_id=OnlineFIR_OnlineFIRPortlet_INSTANCE_lvkd" +
//            	    "&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view" +
//            	    "&_OnlineFIR_OnlineFIRPortlet_INSTANCE_lvkd_mvcPath=/resetPassword.jsp" +
//            	    "&email=" + user.getEmail();
//
//
//            String subject = "Password Reset Request - Online FIR System";
//            String body = "Hello " + user.getFirstName() + ",\n\n" +
//                         "You requested to reset your password for the Online FIR System. " +
//                         "Click the link below to reset your password:\n\n" +
//                         resetURL + "\n\n" +
//                         "This link will expire in 1 hour.\n\n" +
//                         "If you didn't request this password reset, please ignore this email.\n\n" +
//                         "Thank you,\nOnline FIR Team";
//            
//            MailMessage mailMessage = new MailMessage();
//            mailMessage.setTo(new InternetAddress(user.getEmail()));
//            mailMessage.setSubject(subject);
//            mailMessage.setBody(body);
//            mailMessage.setFrom(new InternetAddress("noreply@onlinefir.com", "Online FIR System"));
//            
//            MailServiceUtil.sendEmail(mailMessage);
//            log.info("Reset password email sent to: " + user.getEmail());
//        } catch (Exception e) {
//            log.error("Error sending reset email: " + e.getMessage(), e);
//        }
//    }
//}



package OnlineFIR.admin;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

import OnlineFIR.constants.OnlineFIRPortletKeys;
import fironlineser.model.SignupUser;
import fironlineser.service.SignupUserLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/password/forgot"
    },
    service = MVCActionCommand.class
)
public class ForgotPasswordMVCActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(ForgotPasswordMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        String email = ParamUtil.getString(actionRequest, "email");
        
        try {
            // Find user by email in custom SignupUser table
            List<SignupUser> users = SignupUserLocalServiceUtil.getSignupUsers(0, SignupUserLocalServiceUtil.getSignupUsersCount());
            SignupUser user = users.stream()
                .filter(u -> email.equalsIgnoreCase(u.getEmail()))
                .findFirst()
                .orElse(null);
            
            if (user != null) {
                // Generate reset token
                String resetToken = UUID.randomUUID().toString();
                Date expirationDate = new Date(System.currentTimeMillis() + (60 * 60 * 1000)); // 1 hour
                
                // Store token in session using EMAIL as key (not userId)
                HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
                session.setAttribute("RESET_TOKEN_" + user.getEmail(), resetToken);
                session.setAttribute("TOKEN_EXPIRY_" + user.getEmail(), expirationDate);
                session.setAttribute("RESET_EMAIL", user.getEmail());
                
                // Send reset email
                sendResetEmail(user, resetToken, actionRequest);
                
                SessionMessages.add(actionRequest, "resetLinkSent");
                log.info("Password reset link sent to: " + email);
            } else {
                SessionErrors.add(actionRequest, "resetError", "No account found with this email address");
                log.warn("Password reset attempt for non-existent email: " + email);
            }
        } catch (Exception e) {
            SessionErrors.add(actionRequest, "resetError", "Error processing your request");
            log.error("Error in password reset process: " + e.getMessage(), e);
        }
        
        actionResponse.setRenderParameter("mvcPath", "/forgotPassword.jsp");
        return false;
    }
    
    private void sendResetEmail(SignupUser user, String token, ActionRequest actionRequest) {
        try {
            // Get theme display for proper URL construction
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            String portalURL = themeDisplay.getPortalURL();
            
            // Create reset URL with email and token parameters
            String resetURL = portalURL + "/online-fir1?p_p_id=OnlineFIR_OnlineFIRPortlet_INSTANCE_lvkd" +
                "&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view" +
                "&_OnlineFIR_OnlineFIRPortlet_INSTANCE_lvkd_mvcPath=/resetPassword.jsp" +
                "&email=" + user.getEmail() + "&token=" + token;

            String subject = "Password Reset Request - Online FIR System";
            String body = "Hello " + user.getFirstName() + ",\n\n" +
                         "You requested to reset your password for the Online FIR System. " +
                         "Click the link below to reset your password:\n\n" +
                         resetURL + "\n\n" +
                         "This link will expire in 1 hour.\n\n" +
                         "If you didn't request this password reset, please ignore this email.\n\n" +
                         "Thank you,\nOnline FIR Team";
            
            MailMessage mailMessage = new MailMessage();
            mailMessage.setTo(new InternetAddress(user.getEmail()));
            mailMessage.setSubject(subject);
            mailMessage.setBody(body);
            mailMessage.setFrom(new InternetAddress("noreply@onlinefir.com", "Online FIR System"));
            
            MailServiceUtil.sendEmail(mailMessage);
            log.info("Reset password email sent to: " + user.getEmail());
        } catch (Exception e) {
            log.error("Error sending reset email: " + e.getMessage(), e);
        }
    }
}