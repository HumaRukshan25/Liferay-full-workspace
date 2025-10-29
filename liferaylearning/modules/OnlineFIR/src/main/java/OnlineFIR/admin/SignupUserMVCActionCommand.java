
//package OnlineFIR.portlet;
//
//import com.liferay.mail.kernel.model.MailMessage;
//import com.liferay.mail.kernel.service.MailServiceUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.WebKeys;
//import com.liferay.portal.kernel.util.PortalUtil;
//
//import javax.mail.internet.InternetAddress;
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.servlet.http.HttpSession;
//
//import org.osgi.service.component.annotations.Component;
//
//import OnlineFIR.constants.OnlineFIRPortletKeys;
//
//import java.util.Random;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//        "mvc.command.name=/user/signup"
//    },
//    service = MVCActionCommand.class
//)
//public class SignupUserMVCActionCommand implements MVCActionCommand {
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
//
//        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//
//        String loginName = ParamUtil.getString(actionRequest, "loginName");
//        String firstName = ParamUtil.getString(actionRequest, "firstName");
//        String lastName = ParamUtil.getString(actionRequest, "lastName");
//        String email = ParamUtil.getString(actionRequest, "email");
//        String phoneNo = ParamUtil.getString(actionRequest, "phoneNo");
//        String password = ParamUtil.getString(actionRequest, "password");
//        String role = ParamUtil.getString(actionRequest, "role");
//
//        try {
//            // Generate OTP
//            int otp = new Random().nextInt(900000) + 100000; // 6-digit OTP
//
//            // Save data temporarily in HttpSession
//            HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
//            session.setAttribute("pendingLoginName", loginName);
//            session.setAttribute("pendingFirstName", firstName);
//            session.setAttribute("pendingLastName", lastName);
//            session.setAttribute("pendingEmail", email);
//            session.setAttribute("pendingPhoneNo", phoneNo);
//            session.setAttribute("pendingPassword", password);
//            session.setAttribute("pendingRole", role);
//            session.setAttribute("pendingOTP", otp);
//
//            // Send OTP email
//            InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR Portal");
//            InternetAddress to = new InternetAddress(email);
//
//            String subject = "Your OTP for Signup";
//            String body = "Dear " + firstName + ",\n\nYour OTP is: " + otp + "\n\nUse this to complete signup.";
//
//            MailMessage mailMessage = new MailMessage(from, to, subject, body, false);
//            MailServiceUtil.sendEmail(mailMessage);
//
//            System.out.println("OTP sent to " + email + ": " + otp);
//
//            // Redirect to OTP page
//            actionResponse.setRenderParameter("mvcPath", "/verifyOTP.jsp");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            actionRequest.setAttribute("signupError", "Signup failed: " + e.getMessage());
//        }
//
//        return true;
//    }
//}




package OnlineFIR.admin;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

import OnlineFIR.constants.OnlineFIRPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/user/signup"
    },
    service = MVCActionCommand.class
)
public class SignupUserMVCActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            String loginName = ParamUtil.getString(actionRequest, "loginName");
            String firstName = ParamUtil.getString(actionRequest, "firstName");
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            String email = ParamUtil.getString(actionRequest, "email");
            String phoneNo = ParamUtil.getString(actionRequest, "phoneNo");
            String password = ParamUtil.getString(actionRequest, "password");
            String role = ParamUtil.getString(actionRequest, "role");

            // Save data temporarily in session
            HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
            session.setAttribute("pendingLoginName", loginName);
            session.setAttribute("pendingFirstName", firstName);
            session.setAttribute("pendingLastName", lastName);
            session.setAttribute("pendingEmail", email);
            session.setAttribute("pendingPhoneNo", phoneNo);
            session.setAttribute("pendingPassword", password);
            session.setAttribute("pendingRole", role);

         // inside SignupUserMVCActionCommand.java
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

            // Generate render URL instead of action URL
            LiferayPortletURL activationURL = PortletURLFactoryUtil.create(
                    PortalUtil.getHttpServletRequest(actionRequest),
                    OnlineFIRPortletKeys.ONLINEFIR,
                    themeDisplay.getPlid(),
                    PortletRequest.RENDER_PHASE
            );

           activationURL.setParameter("mvcPath", "/activationSent.jsp"); // a JSP page with activate button
           
           
            activationURL.setParameter("email", email);

            String activationLink = activationURL.toString();


            // Send activation email
            InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR Portal");
            InternetAddress to = new InternetAddress(email);

            String subject = "Activate your Online FIR Account";
            String body = "Hello " + firstName + ",\n\n" +
                    "Click the link below to activate your account:\n" +
                    activationLink + "\n\n" +
                    "After clicking, you will receive an OTP.";

            MailMessage mailMessage = new MailMessage(from, to, subject, body, false);
            MailServiceUtil.sendEmail(mailMessage);

            System.out.println("Activation link sent to: " + email);
            System.out.println("Link: " + activationLink);

            // Redirect to confirmation JSP
            actionResponse.setRenderParameter("mvcPath", "/activationSent.jsp");
            
        
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            actionRequest.setAttribute("signupError", "Error during signup: " + e.getMessage());
            return false;
        }
    }
}


//package OnlineFIR.portlet;
//
//import com.liferay.mail.kernel.model.MailMessage;
//import com.liferay.mail.kernel.service.MailServiceUtil;
//import com.liferay.portal.kernel.model.Role;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.portlet.LiferayPortletURL;
//import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.WebKeys;
//
//import javax.mail.internet.InternetAddress;
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.portlet.PortletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.osgi.service.component.annotations.Component;
//
//import OnlineFIR.constants.OnlineFIRPortletKeys;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.util.List;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//        "mvc.command.name=/user/signup"
//    },
//    service = MVCActionCommand.class
//)
//public class SignupUserMVCActionCommand implements MVCActionCommand {
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
//        try {
//            String loginName = ParamUtil.getString(actionRequest, "loginName");
//            String firstName = ParamUtil.getString(actionRequest, "firstName");
//            String lastName = ParamUtil.getString(actionRequest, "lastName");
//            String email = ParamUtil.getString(actionRequest, "email");
//            String phoneNo = ParamUtil.getString(actionRequest, "phoneNo");
//            String password = ParamUtil.getString(actionRequest, "password");
//            String role = ParamUtil.getString(actionRequest, "role");
//
//            // Save data temporarily in session
//            HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
//            session.setAttribute("pendingLoginName", loginName);
//            session.setAttribute("pendingFirstName", firstName);
//            session.setAttribute("pendingLastName", lastName);
//            session.setAttribute("pendingEmail", email);
//            session.setAttribute("pendingPhoneNo", phoneNo);
//            session.setAttribute("pendingPassword", password);
//            session.setAttribute("pendingRole", role);
//
//            // ---------- STORE USER + ADMINISTRATOR IN DB ----------
//            Connection conn = null;
//            PreparedStatement ps = null;
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefir", "root", "password");
//
//                // Insert signed-up user
//                String sql = "INSERT INTO signupuser (loginName, firstName, lastName, email, phoneNo, password, role) VALUES (?,?,?,?,?,?,?)";
//                ps = conn.prepareStatement(sql);
//                ps.setString(1, loginName);
//                ps.setString(2, firstName);
//                ps.setString(3, lastName);
//                ps.setString(4, email);
//                ps.setString(5, phoneNo);
//                ps.setString(6, password);
//                ps.setString(7, role);
//                ps.executeUpdate();
//                ps.close();
//
//                // Fetch Administrator from Liferay
//                long companyId = PortalUtil.getDefaultCompanyId();
//                Role adminRole = RoleLocalServiceUtil.getRole(companyId, "Administrator");
//                List<User> admins = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
//
//                if (!admins.isEmpty()) {
//                    User admin = admins.get(0); // take first admin
//                    String sql2 = "INSERT INTO signupuser (loginName, firstName, lastName, email, phoneNo, password, role) VALUES (?,?,?,?,?,?,?)";
//                    ps = conn.prepareStatement(sql2);
//                    ps.setString(1, admin.getScreenName());
//                    ps.setString(2, admin.getFirstName());
//                    ps.setString(3, admin.getLastName());
//                    ps.setString(4, admin.getEmailAddress());
//                    ps.setString(5, ""); // phone not available
//                    ps.setString(6, ""); // don’t store admin password
//                    ps.setString(7, "Administrator");
//                    ps.executeUpdate();
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if (ps != null) ps.close();
//                if (conn != null) conn.close();
//            }
//
//            // ---------- SEND ACTIVATION MAIL ----------
//            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//
//            LiferayPortletURL activationURL = PortletURLFactoryUtil.create(
//                    PortalUtil.getHttpServletRequest(actionRequest),
//                    OnlineFIRPortletKeys.ONLINEFIR,
//                    themeDisplay.getPlid(),
//                    PortletRequest.RENDER_PHASE
//            );
//
//            activationURL.setParameter("mvcPath", "/activationSent.jsp");
//            activationURL.setParameter("email", email);
//
//            String activationLink = activationURL.toString();
//
//            InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR Portal");
//            InternetAddress to = new InternetAddress(email);
//
//            String subject = "Activate your Online FIR Account";
//            String body = "Hello " + firstName + ",\n\n" +
//                    "Click the link below to activate your account:\n" +
//                    activationLink + "\n\n" +
//                    "After clicking, you will receive an OTP.";
//
//            MailMessage mailMessage = new MailMessage(from, to, subject, body, false);
//            MailServiceUtil.sendEmail(mailMessage);
//
//            System.out.println("Activation link sent to: " + email);
//
//            actionResponse.setRenderParameter("mvcPath", "/activationSent.jsp");
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            actionRequest.setAttribute("signupError", "Error during signup: " + e.getMessage());
//            return false;
//        }
//    }
//}







