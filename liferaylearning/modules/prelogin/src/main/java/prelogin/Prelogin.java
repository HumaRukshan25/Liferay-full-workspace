//package prelogin;
//
//import com.liferay.portal.kernel.events.ActionException;
//import com.liferay.portal.kernel.events.LifecycleAction;
//import com.liferay.portal.kernel.events.LifecycleEvent;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.osgi.service.component.annotations.Component;
//
//@Component(
//    immediate = true,
//    property = {
//        "key=login.events.pre"   // runs BEFORE login finalizes
//    },
//    service = LifecycleAction.class
//)
//public class Prelogin implements LifecycleAction {
//
//    private static final Log log = LogFactoryUtil.getLog(Prelogin.class);
//
//    @Override
//    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
//        HttpServletRequest request = lifecycleEvent.getRequest();
//        HttpSession session = request.getSession(false);
//
//        if (session == null) {
//            return; // no session → nothing to validate
//        }
//
//        Boolean otpChallenge = (Boolean) session.getAttribute("OTP_CHALLENGE");
//
//        if (Boolean.TRUE.equals(otpChallenge)) {
//            String expectedOtp = (String) session.getAttribute("EXPECTED_OTP");
//            String enteredOtp = request.getParameter("otp");
//
//            log.info("Verifying OTP... expected=" + expectedOtp + " entered=" + enteredOtp);
//
//            if (expectedOtp == null || enteredOtp == null || !expectedOtp.equals(enteredOtp)) {
//                log.warn("OTP verification failed");
//                request.setAttribute("otpError", true); // so JSP can show error
//                throw new ActionException("Invalid OTP"); // block login
//            }
//
//            // ✅ Success: remove OTP challenge
//            session.removeAttribute("OTP_CHALLENGE");
//            session.removeAttribute("EXPECTED_OTP");
//
//            log.info("OTP verified successfully, login continues.");
//        }
//    }
//}
