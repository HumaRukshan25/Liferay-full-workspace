
//-------------->  the below one i scorrce if ur getting any error use this

//
//package OnlineFIR.fortesting;
//
//import com.liferay.portal.kernel.model.Role;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
//import com.liferay.portal.kernel.service.ServiceContext;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//
//import org.osgi.service.component.annotations.Component;
//
//import OnlineFIR.constants.OnlineFIRPortletKeys;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.Enumeration;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//        "mvc.command.name=/user/verifyOtp"
//    },
//    service = MVCActionCommand.class
//)
//public class VerifyOTPMVCActionCommand implements MVCActionCommand {
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
//        try {
//            System.out.println("=== OTP VERIFICATION STARTED ===");
//            
//            // Get the HTTP request and session
//            HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
//            HttpSession session = httpRequest.getSession();
//            
//            // Try different ways to get the OTP parameter
//            String enteredOtp = null;
//            
//            // Method 1: Try ParamUtil
//            enteredOtp = ParamUtil.getString(actionRequest, "otp");
//            System.out.println("OTP from ParamUtil: '" + enteredOtp + "'");
//            
//            // Method 2: Try direct from action request
//            if (enteredOtp == null || enteredOtp.isEmpty()) {
//                enteredOtp = actionRequest.getParameter("otp");
//                System.out.println("OTP from actionRequest: '" + enteredOtp + "'");
//            }
//            
//            // Method 3: Try from HTTP request
//            if (enteredOtp == null || enteredOtp.isEmpty()) {
//                enteredOtp = httpRequest.getParameter("otp");
//                System.out.println("OTP from httpRequest: '" + enteredOtp + "'");
//            }
//            
//            String sessionOtp = (String) session.getAttribute("pendingOTP");
//            Long generatedTime = (Long) session.getAttribute("otpGeneratedTime");
//
//            System.out.println("=== OTP VALUES ===");
//            System.out.println("Entered OTP: '" + enteredOtp + "'");
//            System.out.println("Session OTP: '" + sessionOtp + "'");
//            System.out.println("Generated Time: " + generatedTime);
//
//            // Check if OTP is empty
//            if (enteredOtp == null || enteredOtp.trim().isEmpty()) {
//                String errorMsg = "Please enter the OTP code.";
//                System.out.println("ERROR: " + errorMsg);
//                actionRequest.setAttribute("otpError", errorMsg);
//                actionResponse.setRenderParameter("mvcPath", "/otpVerify1.jsp");
//                return false;
//            }
//            
//            enteredOtp = enteredOtp.trim();
//
//            // Check if session OTP exists
//            if (sessionOtp == null) {
//                String errorMsg = "OTP session expired. Please request a new OTP.";
//                System.out.println("ERROR: " + errorMsg);
//                actionRequest.setAttribute("otpError", errorMsg);
//                actionResponse.setRenderParameter("mvcPath", "/otpVerify1.jsp");
//                return false;
//            }
//
//            // Check if OTP is expired
//            if (generatedTime == null || (System.currentTimeMillis() - generatedTime > 10 * 60 * 1000)) {
//                String errorMsg = "OTP has expired. Please request a new one.";
//                System.out.println("ERROR: " + errorMsg);
//                actionRequest.setAttribute("otpError", errorMsg);
//                actionResponse.setRenderParameter("mvcPath", "/otpVerify1.jsp");
//                return false;
//            }
//
//            // Verify OTP
//            if (enteredOtp.equals(sessionOtp)) {
//                System.out.println("OTP VERIFICATION SUCCESSFUL");
//                
//                // ONLY NOW CREATE THE USER IN DATABASE
//                try {
//                    // Get user data from session
//                    String loginName = (String) session.getAttribute("pendingUserLoginName");
//                    String firstName = (String) session.getAttribute("pendingUserFirstName");
//                    String lastName = (String) session.getAttribute("pendingUserLastName");
//                    String email = (String) session.getAttribute("pendingUserEmail");
//                    String password = (String) session.getAttribute("pendingUserPassword");
//                    String roleName = (String) session.getAttribute("pendingUserRole");
//                    String phoneNo = (String) session.getAttribute("pendingUserPhoneNo");
//                    Long companyId = (Long) session.getAttribute("pendingUserCompanyId");
//
//                    System.out.println("Creating user in database: " + email);
//                    
//                    ServiceContext serviceContext = new ServiceContext();
//                    serviceContext.setCompanyId(companyId);
//
//                    // Create user in database
//                    User newUser = UserLocalServiceUtil.addUser(
//                        0L, // creatorUserId
//                        companyId, 
//                        false, // autoPassword
//                        password, 
//                        password, 
//                        false, // autoScreenName
//                        loginName, 
//                        email, 
//                        java.util.Locale.getDefault(),
//                        firstName, 
//                        "", // middleName
//                        lastName, 
//                        0L, // prefixListTypeId
//                        0L, // suffixListTypeId
//                        true, // male
//                        1, // birthdayMonth
//                        1, // birthdayDay
//                        1990, // birthdayYear
//                        "", // jobTitle
//                        0, new long[0], // groupIds
//                        new long[0], // organizationIds
//                        new long[0], // roleIds
//                        new long[0], // userGroupIds
//                        false, // sendEmail
//                        serviceContext
//                    );
//
//                    //this one we must UserLocalServiceUtil.updatePassword(newUser.getUserId(), password, password, false);
//                    
//                    
//                    // Set custom field for phone number if needed
//                    // You can use Expando attributes for custom fields
//                    
//                    // Assign role
//                    try {
//                        Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
//                        if (role != null) {
//                            UserLocalServiceUtil.addRoleUser(role.getRoleId(), newUser);
//                            System.out.println("Role assigned: " + roleName);
//                        }
//                    } catch (Exception e) {
//                        System.out.println("Error assigning role: " + e.getMessage());
//                    }
//
//                    System.out.println("User created successfully in database: " + email + " (ID: " + newUser.getUserId() + ")");
//
//                    // Cleanup session - remove all temporary data
//                    session.removeAttribute("pendingOTP");
//                    session.removeAttribute("otpGeneratedTime");
//                    session.removeAttribute("pendingUserLoginName");
//                    session.removeAttribute("pendingUserFirstName");
//                    session.removeAttribute("pendingUserLastName");
//                    session.removeAttribute("pendingUserEmail");
//                    session.removeAttribute("pendingUserPassword");
//                    session.removeAttribute("pendingUserRole");
//                    session.removeAttribute("pendingUserPhoneNo");
//                    session.removeAttribute("pendingUserCompanyId");
//
//                    actionResponse.setRenderParameter("mvcPath", "/success.jsp");
//                    return true;
//                    
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    System.out.println("Error creating user in database: " + e.getMessage());
//                    actionRequest.setAttribute("otpError", "Error creating account. Please try again or contact support.");
//                    actionResponse.setRenderParameter("mvcPath", "/otpVerify1.jsp");
//                    return false;
//                }
//            } else {
//                String errorMsg = "Invalid OTP code. Please try again.";
//                System.out.println("ERROR: " + errorMsg);
//                actionRequest.setAttribute("otpError", errorMsg);
//                actionResponse.setRenderParameter("mvcPath", "/otpVerify1.jsp");
//                return false;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            actionRequest.setAttribute("otpError", "System error during OTP verification: " + e.getMessage());
//            actionResponse.setRenderParameter("mvcPath", "/otpVerify1.jsp");
//            return false;
//        }
//    }
//}


package OnlineFIR.fortesting;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import OnlineFIR.constants.OnlineFIRPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/user/verifyOtp"
    },
    service = MVCActionCommand.class
)
public class VerifyOTPMVCActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            System.out.println("=== OTP VERIFICATION STARTED ===");

            HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
            HttpSession session = httpRequest.getSession();

            String enteredOtp = ParamUtil.getString(actionRequest, "otp");
            if (enteredOtp == null || enteredOtp.isEmpty()) {
                enteredOtp = httpRequest.getParameter("otp");
            }

            String sessionOtp = (String) session.getAttribute("pendingOTP");
            Long generatedTime = (Long) session.getAttribute("otpGeneratedTime");

            if (enteredOtp == null || enteredOtp.trim().isEmpty()) {
                actionRequest.setAttribute("otpError", "Please enter the OTP code.");
                actionResponse.setRenderParameter("mvcPath", "/otpVerify1.jsp");
                return false;
            }

            if (sessionOtp == null) {
                actionRequest.setAttribute("otpError", "OTP session expired. Please request a new OTP.");
                actionResponse.setRenderParameter("mvcPath", "/otpVerify1.jsp");
                return false;
            }

            if (generatedTime == null || (System.currentTimeMillis() - generatedTime > 10 * 60 * 1000)) {
                actionRequest.setAttribute("otpError", "OTP has expired. Please request a new one.");
                actionResponse.setRenderParameter("mvcPath", "/otpVerify1.jsp");
                return false;
            }

            if (!enteredOtp.equals(sessionOtp)) {
                actionRequest.setAttribute("otpError", "Invalid OTP code. Please try again.");
                actionResponse.setRenderParameter("mvcPath", "/otpVerify1.jsp");
                return false;
            }

            System.out.println("OTP VERIFICATION SUCCESSFUL");

            // Get user details from session
            String loginName = (String) session.getAttribute("pendingUserLoginName");
            String firstName = (String) session.getAttribute("pendingUserFirstName");
            String lastName = (String) session.getAttribute("pendingUserLastName");
            String email = (String) session.getAttribute("pendingUserEmail");
            String password = (String) session.getAttribute("pendingUserPassword");
            String roleName = (String) session.getAttribute("pendingUserRole");

            long companyId = PortalUtil.getCompanyId(actionRequest);
            ServiceContext serviceContext = new ServiceContext();
            serviceContext.setCompanyId(companyId);

            User user = null;
            try {
                // Check if user already exists
                user = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
                System.out.println("User already exists: " + email);
            } catch (Exception e) {
                // User doesn't exist, create new one
                user = UserLocalServiceUtil.addUser(
                        0L, companyId,
                        false,                  // autoPassword
                        "password", "password", // temporary password
                        false,                  // autoScreenName
                        loginName, email,
                        Locale.getDefault(),
                        firstName, "", lastName,
                        0L, 0L,
                        true, 1, 1, 1990,       // DOB dummy
                        "", 1,
                        new long[0], new long[0], new long[0], new long[0],
                        false,
                        serviceContext
                );

                // Reindex user
                Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(User.class);
                indexer.reindex(user);

                // Set real password
                UserLocalServiceUtil.updatePassword(user.getUserId(), password, password, false);

                System.out.println("New user created: " + email);
            }

            // ✅ Ensure user is active and verified (with fresh reload)
            try {
                user = UserLocalServiceUtil.getUser(user.getUserId());
                user.setAgreedToTermsOfUse(true);
                user.setEmailAddressVerified(true);
                user = UserLocalServiceUtil.updateUser(user);
                System.out.println("User verified successfully");
            } catch (Exception e) {
                System.out.println("Error while updating user verification flags: " + e.getMessage());
            }

            // Assign role
            try {
                Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
                if (role != null) {
                    UserLocalServiceUtil.addRoleUser(role.getRoleId(), user);
                    System.out.println("Role assigned: " + roleName);
                }
            } catch (Exception e) {
                System.out.println("Error assigning role: " + e.getMessage());
            }

            // Store logged-in user in session
            session.setAttribute("loggedInUserId", user.getUserId());

            // Cleanup OTP session attributes
            session.removeAttribute("pendingOTP");
            session.removeAttribute("otpGeneratedTime");
            session.removeAttribute("pendingUserLoginName");
            session.removeAttribute("pendingUserFirstName");
            session.removeAttribute("pendingUserLastName");
            session.removeAttribute("pendingUserEmail");
            session.removeAttribute("pendingUserPassword");
            session.removeAttribute("pendingUserRole");

            actionResponse.setRenderParameter("mvcPath", "/success.jsp");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            actionRequest.setAttribute("otpError", "System error: " + e.getMessage());
            actionResponse.setRenderParameter("mvcPath", "/otpVerify1.jsp");
            return false;
        }
    }
}
