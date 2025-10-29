//package OnlineFIR.fortesting;
//
//import com.liferay.mail.kernel.model.MailMessage;
//import com.liferay.mail.kernel.service.MailServiceUtil;
//import com.liferay.portal.kernel.model.Role;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.portlet.LiferayPortletURL;
//import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
//import com.liferay.portal.kernel.service.ServiceContext;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//        "mvc.command.name=/user/signup1"
//    },
//    service = MVCActionCommand.class
//)
//public class SignupUserMVCActionCommand implements MVCActionCommand {
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
//        try {
//            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//
//            String loginName = ParamUtil.getString(actionRequest, "loginName");
//            String firstName = ParamUtil.getString(actionRequest, "firstName");
//            String lastName = ParamUtil.getString(actionRequest, "lastName");
//            String email = ParamUtil.getString(actionRequest, "email");
//            String password = ParamUtil.getString(actionRequest, "password");
//            String roleName = ParamUtil.getString(actionRequest, "role");
//
//            long companyId = themeDisplay.getCompanyId();
//            ServiceContext serviceContext = new ServiceContext();
//
//            // Check if user exists
//            try {
//                User existingUser = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
//                if (existingUser != null) {
//                    actionRequest.setAttribute("signupError", "User with this email already exists");
//                    actionResponse.setRenderParameter("mvcPath", "/signup1.jsp");
//                    return false;
//                }
//            } catch (Exception ignored) {}
//
//            // Create inactive user
//            User newUser = UserLocalServiceUtil.addUser(
//                0L, companyId, false, password, password, false,
//                loginName, email, themeDisplay.getLocale(),
//                firstName, "", lastName,
//                0L, 0L, true, 1, 1, 1990,
//                "", 0, new long[0], new long[0], new long[0], new long[0],
//                false, serviceContext
//            );
//
//            UserLocalServiceUtil.updateStatus(newUser.getUserId(), 5, serviceContext); // pending
//
//            // Assign role
//            try {
//                Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
//                if (role != null) {
//                    UserLocalServiceUtil.addRoleUsers(role.getRoleId(), new long[]{newUser.getUserId()});
//                }
//            } catch (Exception ignored) {}
//
//            // Store user info in session for activation
//            HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
//            session.setAttribute("pendingUserId", newUser.getUserId());
//            session.setAttribute("pendingUserEmail", email);
//            session.setAttribute("pendingUserFirstName", firstName);
//
//            // Create activation URL using PortletURLFactoryUtil
//            LiferayPortletURL activationURL = PortletURLFactoryUtil.create(
//                actionRequest, 
//                OnlineFIRPortletKeys.ONLINEFIR, 
//                themeDisplay.getPlid(), 
//                PortletRequest.ACTION_PHASE
//            );
//            
//            activationURL.setParameter("mvcActionCommandName", "/user/activate1");
//            activationURL.setParameter("email", email);
//            activationURL.setParameter("firstName", firstName);
//            activationURL.setWindowState(actionRequest.getWindowState());
//            activationURL.setPortletMode(actionRequest.getPortletMode());
//
//            // Send activation email
//            InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR Portal");
//            InternetAddress to = new InternetAddress(email);
//            String subject = "Activate your Online FIR Account";
//            String body = "Hello " + firstName + ",\n\n" +
//                          "Please click this link to activate your account:\n" +
//                          activationURL.toString() +
//                          "\n\nYou will receive an OTP to complete registration.";
//
//            MailMessage mailMessage = new MailMessage(from, to, subject, body, false);
//            MailServiceUtil.sendEmail(mailMessage);
//
//            System.out.println("Activation email sent to: " + email);
//            System.out.println("Activation URL: " + activationURL.toString());
//
//            // Redirect to success page
//            actionResponse.setRenderParameter("mvcPath", "/activationSent1.jsp");
//
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            actionRequest.setAttribute("signupError", "Error during signup: " + e.getMessage());
//            actionResponse.setRenderParameter("mvcPath", "/signup1.jsp");
//            return false;
//        }
//    }
//}



package OnlineFIR.fortesting;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
        "mvc.command.name=/user/signup1"
    },
    service = MVCActionCommand.class
)
public class SignupUserMVCActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

            String loginName = ParamUtil.getString(actionRequest, "loginName");
            String firstName = ParamUtil.getString(actionRequest, "firstName");
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            String email = ParamUtil.getString(actionRequest, "email");
            String password = ParamUtil.getString(actionRequest, "password");
            String roleName = ParamUtil.getString(actionRequest, "role");
            String phoneNo = ParamUtil.getString(actionRequest, "phoneNo");

            long companyId = themeDisplay.getCompanyId();

            // Check if user exists
            try {
                User existingUser = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
                if (existingUser != null) {
                    actionRequest.setAttribute("signupError", "User with this email already exists");
                    actionResponse.setRenderParameter("mvcPath", "/signup1.jsp");
                    return false;
                }
            } catch (Exception ignored) {}

            // Store ALL user data in session (NOT in database yet)
            HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
            
            // Store user details in session
            session.setAttribute("pendingUserLoginName", loginName);
            session.setAttribute("pendingUserFirstName", firstName);
            session.setAttribute("pendingUserLastName", lastName);
            session.setAttribute("pendingUserEmail", email);
            session.setAttribute("pendingUserPassword", password);
            session.setAttribute("pendingUserRole", roleName);
            session.setAttribute("pendingUserPhoneNo", phoneNo);
            session.setAttribute("pendingUserCompanyId", companyId);

            // Create activation URL
            LiferayPortletURL activationURL = PortletURLFactoryUtil.create(
                actionRequest, 
                OnlineFIRPortletKeys.ONLINEFIR, 
                themeDisplay.getPlid(), 
                PortletRequest.ACTION_PHASE
            );
            
            activationURL.setParameter("mvcActionCommandName", "/user/activate1");
            activationURL.setParameter("email", email);
            activationURL.setParameter("firstName", firstName);
            activationURL.setWindowState(actionRequest.getWindowState());
            activationURL.setPortletMode(actionRequest.getPortletMode());

            // Send activation email
            InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR Portal");
            InternetAddress to = new InternetAddress(email);
            String subject = "Activate your Online FIR Account";
            String body = "Hello " + firstName + ",\n\n" +
                          "Please click this link to activate your account:\n" +
                          activationURL.toString() +
                          "\n\nYou will receive an OTP to complete registration.";

            MailMessage mailMessage = new MailMessage(from, to, subject, body, false);
            MailServiceUtil.sendEmail(mailMessage);

            System.out.println("Activation email sent to: " + email);
            System.out.println("User data stored in session, waiting for OTP verification");

            // Redirect to success page
            actionResponse.setRenderParameter("mvcPath", "/activationSent1.jsp");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            actionRequest.setAttribute("signupError", "Error during signup: " + e.getMessage());
            actionResponse.setRenderParameter("mvcPath", "/signup1.jsp");
            return false;
        }
    }
}