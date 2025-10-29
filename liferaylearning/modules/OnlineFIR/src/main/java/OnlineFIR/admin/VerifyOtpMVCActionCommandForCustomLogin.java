// //this  i have done for custom login
//this  i have done for custom login
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
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
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
//        "mvc.command.name=/otp/verify1"
//    },
//    service = MVCActionCommand.class
//)
//public class VerifyOtpMVCActionCommandForCustomLogin implements MVCActionCommand {
//
//    private static final Log log = LogFactoryUtil.getLog(VerifyOtpMVCActionCommand.class);
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
//
//        String enteredOtp = ParamUtil.getString(actionRequest, "otp");
//        HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
//        
//        // Get the OTP from session
//        String expectedOtp = (String) session.getAttribute("EXPECTED_OTP");
//        String role = (String) session.getAttribute("USER_ROLE");
//        
//
//        // Debug logging
//        log.debug("Session ID: " + session.getId());
//        log.debug("Expected OTP from session: " + expectedOtp);
//        log.debug("Entered OTP: " + enteredOtp);
//        log.debug("User role: " + role);
//
//        // Check if OTP exists
//        if (expectedOtp == null) {
//            SessionErrors.add(actionRequest, "otpMissing");
//            log.error("No OTP found in session");
//            actionResponse.setRenderParameter("mvcPath", "/otp.jsp");
//            return false;
//        }
//
//        // Check if OTP has expired (5 minutes)
//        Long otpTimestamp = (Long) session.getAttribute("OTP_TIMESTAMP");
//        boolean isOtpExpired = otpTimestamp != null && 
//                              (System.currentTimeMillis() - otpTimestamp) > 300000;
//        
//        if (isOtpExpired) {
//            SessionErrors.add(actionRequest, "otpExpired");
//            log.error("OTP has expired");
//            session.removeAttribute("EXPECTED_OTP");
//            session.removeAttribute("OTP_CHALLENGE");
//            session.removeAttribute("OTP_TIMESTAMP");
//            actionResponse.setRenderParameter("mvcPath", "/otp.jsp");
//            return false;
//        }
//
//        // Verify OTP
//        if (expectedOtp.trim().equals(enteredOtp.trim())) {
//            SessionMessages.add(actionRequest, "otpVerified");
//            log.info("OTP verified successfully for role: " + role);
//            
//            // Clean up session
//            session.removeAttribute("EXPECTED_OTP");
//            session.removeAttribute("OTP_CHALLENGE");
//            session.removeAttribute("OTP_TIMESTAMP");
//
//            // Redirect based on role
//            if ("admin".equals(role)) {
//                actionResponse.setRenderParameter("mvcPath", "/dashboard.jsp");
//            } else {
//                actionResponse.setRenderParameter("mvcPath", "/success.jsp");
//            }
//        } else {
//            SessionErrors.add(actionRequest, "otpInvalid");
//            log.error("OTP verification failed. Expected: " + expectedOtp + ", Got: " + enteredOtp);
//            
//            // Stay on OTP page
//            if ("admin".equals(role)) {
//                actionResponse.setRenderParameter("mvcPath", "/admin_success.jsp");
//            } else {
//                actionResponse.setRenderParameter("mvcPath", "/otp.jsp");
//            }
//        }
//
//        return false;
//    }
//}

// i have done this for otp verification after login  2nd form for my signupuser table   
package OnlineFIR.admin;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

import OnlineFIR.constants.OnlineFIRPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/otp/verify1"
    },
    service = MVCActionCommand.class
)
public class VerifyOtpMVCActionCommandForCustomLogin implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(VerifyOtpMVCActionCommandForCustomLogin.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        String enteredOtp = ParamUtil.getString(actionRequest, "otp");
      
        HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();

    
     // Get OTP from session
        String expectedOtp = (String) session.getAttribute("EXPECTED_OTP");
        String role = (String) session.getAttribute("USER_ROLE"); // ✅ get from session

        // Debug logging
        log.debug("Session ID: " + session.getId());
        log.debug("Expected OTP from session: " + expectedOtp);
        log.debug("Entered OTP: " + enteredOtp);
        log.debug("Role from form: " + role);

        // Case 1: No OTP in session
        if (expectedOtp == null) {
            SessionErrors.add(actionRequest, "otpMissing");
            log.error("No OTP found in session");
            actionResponse.setRenderParameter("mvcPath", "/otp.jsp");
            return false;
        }

        // Case 2: OTP expired (5 minutes)
        Long otpTimestamp = (Long) session.getAttribute("OTP_TIMESTAMP");
        boolean isOtpExpired = otpTimestamp != null &&
                              (System.currentTimeMillis() - otpTimestamp) > 300000;

        if (isOtpExpired) {
            SessionErrors.add(actionRequest, "otpExpired");
            log.error("OTP has expired");
            session.removeAttribute("EXPECTED_OTP");
            session.removeAttribute("OTP_CHALLENGE");
            session.removeAttribute("OTP_TIMESTAMP");
            actionResponse.setRenderParameter("mvcPath", "/otp.jsp");
            return false;
        }

        // Case 3: OTP verified successfully
        if (expectedOtp.trim().equals(enteredOtp.trim())) {
            SessionMessages.add(actionRequest, "otpVerified");
            log.info("OTP verified successfully for role: " + role);

            // Clean up OTP session data
            session.removeAttribute("EXPECTED_OTP");
            session.removeAttribute("OTP_CHALLENGE");
            session.removeAttribute("OTP_TIMESTAMP");

            // Redirect user based on the role chosen in the form
            if ("admin".equalsIgnoreCase(role)) {
                actionResponse.setRenderParameter("mvcPath", "/dashboard.jsp");
            } else if ("police".equalsIgnoreCase(role)) {
                actionResponse.setRenderParameter("mvcPath", "/police_dashboard.jsp");
            } else if ("citizen".equalsIgnoreCase(role)) {
                actionResponse.setRenderParameter("mvcPath", "/citizen_dashboard.jsp");
            } else {
                actionResponse.setRenderParameter("mvcPath", "/success.jsp");
            }
        } 
        // Case 4: OTP mismatch
        else {
            SessionErrors.add(actionRequest, "otpInvalid");
            log.error("OTP verification failed. Expected: " + expectedOtp + ", Got: " + enteredOtp);
            actionResponse.setRenderParameter("mvcPath", "/otp.jsp");
        }

        return false;
    }
}
