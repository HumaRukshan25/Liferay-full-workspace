//package OnlineFIR.admin;
//
//import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.servlet.SessionErrors;
//import com.liferay.portal.kernel.servlet.SessionMessages;
//import com.liferay.portal.kernel.util.PortalUtil;
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
////this is for sigup  action command to verify otp
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//        "mvc.command.name=/otp/verify2"
//    },
//    service = MVCActionCommand.class
//)
//public class VerifyOTPMVCActionCommand implements MVCActionCommand {
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
//
//        HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
//        int enteredOtp = ParamUtil.getInteger(actionRequest, "otp");
//
//        try {
//            int pendingOtp = (int) session.getAttribute("pendingOTP");
//
//            if (enteredOtp == pendingOtp) {
//                // Save to DB
//                long signupUserId = CounterLocalServiceUtil.increment(SignupUser.class.getName());
//                SignupUser signupUser = SignupUserLocalServiceUtil.createSignupUser(signupUserId);
//
//                signupUser.setLoginName((String) session.getAttribute("pendingLoginName"));
//                signupUser.setFirstName((String) session.getAttribute("pendingFirstName"));
//                signupUser.setLastName((String) session.getAttribute("pendingLastName"));
//                signupUser.setEmail((String) session.getAttribute("pendingEmail"));
//                signupUser.setPhoneNo((String) session.getAttribute("pendingPhoneNo"));
//                signupUser.setPassword_((String) session.getAttribute("pendingPassword"));
//                signupUser.setRole((String) session.getAttribute("pendingRole"));
//
//                SignupUserLocalServiceUtil.addSignupUser(signupUser);
//
//                // Clear session
//                session.invalidate();
//
//                SessionMessages.add(actionRequest, "otpStatus");
//                actionResponse.setRenderParameter("mvcPath", "/view.jsp");
//
//            } else {
//                SessionErrors.add(actionRequest, "otpError");
//                actionResponse.setRenderParameter("mvcPath", "/verifyOTP.jsp");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            SessionErrors.add(actionRequest, "otpError");
//        }
//
//        return true;
//    }
//}


// this i have done for signup to verify otp  for 2nd form
package OnlineFIR.admin;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

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
                "mvc.command.name=/otp/verify2"
        },
        service = MVCActionCommand.class
)
public class VerifyOTPMVCActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
        int enteredOtp = ParamUtil.getInteger(actionRequest, "otp");

        try {
            Integer pendingOtp = (Integer) session.getAttribute("pendingOTP");

            if (pendingOtp != null && enteredOtp == pendingOtp) {

                // Generate new primary key
                long signupUserId = CounterLocalServiceUtil.increment(SignupUser.class.getName());
                SignupUser signupUser = SignupUserLocalServiceUtil.createSignupUser(signupUserId);

                // Set all required fields from session
                signupUser.setLoginName((String) session.getAttribute("pendingLoginName"));
                signupUser.setFirstName((String) session.getAttribute("pendingFirstName"));
                signupUser.setLastName((String) session.getAttribute("pendingLastName"));
                signupUser.setEmail((String) session.getAttribute("pendingEmail"));
                signupUser.setPhoneNo((String) session.getAttribute("pendingPhoneNo"));
                signupUser.setPassword_((String) session.getAttribute("pendingPassword"));
                signupUser.setRole((String) session.getAttribute("pendingRole"));

                // Add to DB
                SignupUserLocalServiceUtil.addSignupUser(signupUser);

                System.out.println("User saved successfully: " + signupUser.getEmail());

                // Clear session attributes only after successful save
                session.removeAttribute("pendingLoginName");
                session.removeAttribute("pendingFirstName");
                session.removeAttribute("pendingLastName");
                session.removeAttribute("pendingEmail");
                session.removeAttribute("pendingPhoneNo");
                session.removeAttribute("pendingPassword");
                session.removeAttribute("pendingRole");
                session.removeAttribute("pendingOTP");

                SessionMessages.add(actionRequest, "otpStatus");
                actionResponse.setRenderParameter("mvcPath", "/view.jsp");

            } else {
                SessionErrors.add(actionRequest, "otpError");
                actionResponse.setRenderParameter("mvcPath", "/verifyOTP.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(actionRequest, "otpError");
        }

        return true;
    }
}
