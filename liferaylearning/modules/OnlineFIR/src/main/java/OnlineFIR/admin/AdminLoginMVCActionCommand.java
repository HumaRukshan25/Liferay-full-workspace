


//-> correct

package OnlineFIR.admin;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import OnlineFIR.constants.OnlineFIRPortletKeys;
import OnlineFIR.util.OTPUtil;
import fironlineser.model.SignupUser;
import fironlineser.service.SignupUserLocalServiceUtil;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/admin/login"
    },
    service = MVCActionCommand.class
)
public class AdminLoginMVCActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(AdminLoginMVCActionCommand.class);

//    private static final String DEFAULT_ADMIN_USERNAME = "123";
//    private static final String DEFAULT_ADMIN_PASSWORD = "123";
//    
    


    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        String loginName = ParamUtil.getString(actionRequest, "loginName", "");
        String password = ParamUtil.getString(actionRequest, "password", "");
        String role = ParamUtil.getString(actionRequest, "role", "").toLowerCase();

        HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();

        try {
//            if ("admin".equals(role)) {
//                // Hardcoded admin check
//                if (DEFAULT_ADMIN_USERNAME.equals(loginName) && DEFAULT_ADMIN_PASSWORD.equals(password)) {
//                    session.setAttribute("USER_ROLE", "admin");
//                    session.setAttribute("USERNAME", loginName);
//
//                    String otpCode = OTPUtil.generateOTP(session);
//                    log.info("Generated OTP for admin: " + otpCode);
//                    sendEmail("hrukshan135@gmail.com", "Your OTP for Admin Login", otpCode);
//
//                    actionResponse.setRenderParameter("mvcPath", "/admin_success.jsp");
//                } else {
//                    actionRequest.setAttribute("loginError", "Invalid admin username or password!");
//                    actionResponse.setRenderParameter("mvcPath", "/view.jsp");
//                }
//            } else 
            	if ("police".equals(role) || "citizen".equals(role)||"admin".equals(role)) {
                // Fetch all SignupUser records
                List<SignupUser> users = SignupUserLocalServiceUtil.getSignupUsers(0, SignupUserLocalServiceUtil.getSignupUsersCount());

                SignupUser matchedUser = users.stream()
                        .filter(u -> loginName.equals(u.getLoginName()) && role.equalsIgnoreCase(u.getRole()))
                        .findFirst()
                        .orElse(null);

                if (matchedUser != null && password.equals(matchedUser.getPassword_())) {
                    session.setAttribute("USER_ROLE", role);
                    session.setAttribute("USERNAME", loginName);

                    String otpCode = OTPUtil.generateOTP(session);
                    log.info("Generated OTP for " + role + ": " + otpCode);
                    sendEmail(matchedUser.getEmail(), "Your OTP for Login", otpCode);

                    actionResponse.setRenderParameter("mvcPath", "/admin_success.jsp");
                } else {
                    actionRequest.setAttribute("loginError", "Invalid username or password!");
                    actionResponse.setRenderParameter("mvcPath", "/view.jsp");
                }
            } else {
                actionRequest.setAttribute("loginError", "Please select a valid role!");
                actionResponse.setRenderParameter("mvcPath", "/view.jsp");
            }
        } catch (Exception e) {
            log.error("Login failed", e);
            actionRequest.setAttribute("loginError", "Error during login. Please try again.");
            actionResponse.setRenderParameter("mvcPath", "/view.jsp");
        }

        return true;
    }

    private void sendEmail(String toEmail, String subject, String otpCode) {
        try {
            InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR System");
            InternetAddress to = new InternetAddress(toEmail);

            MailMessage message = new MailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setBody("Hello,\n\nYour OTP is: " + otpCode + "\n\nUse this OTP to complete login.");
            message.setHTMLFormat(false);

            MailServiceUtil.sendEmail(message);
            log.info("OTP sent to: " + toEmail);
        } catch (Exception e) {
            log.error("Error sending OTP email", e);
        }
    }
}


//package OnlineFIR.portlet;
//
//import com.liferay.mail.kernel.model.MailMessage;
//import com.liferay.mail.kernel.service.MailServiceUtil;
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.security.auth.Authenticator;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.WebKeys;
//import OnlineFIR.constants.OnlineFIRPortletKeys;
//import OnlineFIR.util.OTPUtil;
//
//import javax.mail.internet.InternetAddress;
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.servlet.http.HttpSession;
//
//import org.osgi.service.component.annotations.Component;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//        "mvc.command.name=/admin/login"
//    },
//    service = MVCActionCommand.class
//)
//public class AdminLoginMVCActionCommand implements MVCActionCommand {
//
//    private static final Log log = LogFactoryUtil.getLog(AdminLoginMVCActionCommand.class);
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
//
//        String loginName = ParamUtil.getString(actionRequest, "loginName", "");
//        String password = ParamUtil.getString(actionRequest, "password", "");
//
//        HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
//
//        try {
//            long companyId = PortalUtil.getDefaultCompanyId();
//
//            // Fetch all users from Liferay user_ table
//            List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
//
//            // Filter by screenName
//            List<User> matchedUsers = users.stream()
//                    .filter(u -> loginName.equals(u.getScreenName()))
//                    .collect(Collectors.toList());
//
//            boolean authenticated = false;
//            User matchedUser = null;
//
//            for (User u : matchedUsers) {
//                // Authenticate using Liferay's Authenticator
//                Map<String, String[]> parameterMap = actionRequest.getParameterMap();
//                Map<String, Object> resultsMap = new HashMap<>();
//                Map<String, String[]> headerMap = new HashMap<>();
//
//                int status = UserLocalServiceUtil.authenticateByUserId(
//                        companyId,
//                        u.getUserId(),
//                        password,
//                        headerMap,
//                        parameterMap,
//                        resultsMap
//                );
//
//                if (status == Authenticator.SUCCESS) {
//                    authenticated = true;
//                    matchedUser = u;
//                    break;
//                }
//            }
//
//            if (authenticated && matchedUser != null) {
//                session.setAttribute("USERNAME", loginName);
//
//                String otpCode = OTPUtil.generateOTP(session);
//                log.info("Generated OTP for user: " + otpCode);
//
//                sendEmail(matchedUser.getEmailAddress(), "Your OTP for Login", otpCode);
//
//                actionResponse.setRenderParameter("mvcPath", "/dashboard.jsp");
//            } else {
//                actionRequest.setAttribute("loginError", "Invalid username or password!");
//                actionResponse.setRenderParameter("mvcPath", "/view.jsp");
//            }
//
//        } catch (PortalException e) {
//            log.error("Login failed", e);
//            actionRequest.setAttribute("loginError", "Error during login. Please try again.");
//            actionResponse.setRenderParameter("mvcPath", "/view.jsp");
//        }
//
//        return true;
//    }
//
//    private void sendEmail(String toEmail, String subject, String otpCode) {
//        try {
//            InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR System");
//            InternetAddress to = new InternetAddress(toEmail);
//
//            MailMessage message = new MailMessage();
//            message.setFrom(from);
//            message.setTo(to);
//            message.setSubject(subject);
//            message.setBody("Hello,\n\nYour OTP is: " + otpCode + "\n\nUse this OTP to complete login.");
//            message.setHTMLFormat(false);
//
//            MailServiceUtil.sendEmail(message);
//            log.info("OTP sent to: " + toEmail);
//        } catch (Exception e) {
//            log.error("Error sending OTP email", e);
//        }
//    }
//}
