//package OnlineFIR.fortesting;
//
//import com.liferay.mail.kernel.model.MailMessage;
//import com.liferay.mail.kernel.service.MailServiceUtil;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//
//import java.util.Random;
//import javax.mail.internet.InternetAddress;
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.osgi.service.component.annotations.Component;
//
//import OnlineFIR.constants.OnlineFIRPortletKeys;
//
//@Component(
//	    immediate = true,
//	    property = {
//	        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//	        "mvc.command.name=/otp/resend"
//	    },
//	    service = MVCActionCommand.class
//	)
//public class ResendOtpMVCActionCommand implements MVCActionCommand {
//
//    private static final Log log = LogFactoryUtil.getLog(ResendOtpMVCActionCommand.class);
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
//        try {
//            HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
//            HttpSession session = request.getSession();
//
//            long userId = PortalUtil.getUserId(request);
//            User user = UserLocalServiceUtil.getUser(userId);
//
//            if (user == null) {
//                log.error("User not found for resend OTP");
//                return false;
//            }
//
//            // Generate new OTP
//            String otpCode = String.format("%06d", new Random().nextInt(999999));
//            session.setAttribute("EXPECTED_OTP", otpCode);
//
//            // Send OTP email
//            InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR Registry System");
//            InternetAddress to = new InternetAddress(user.getEmailAddress());
//
//            MailMessage message = new MailMessage();
//            message.setFrom(from);
//            message.setTo(to);
//            message.setSubject("Your New OTP");
//            message.setBody("Hello " + user.getFullName() +
//                            ",\n\nYour new OTP is: " + otpCode +
//                            "\n\nUse this to continue login.");
//            message.setHTMLFormat(false);
//
//            MailServiceUtil.sendEmail(message);
//            log.info("Resent OTP: " + otpCode + " to " + user.getEmailAddress());
//
//            // Redirect back to OTP page
//            actionResponse.sendRedirect(PortalUtil.getCurrentURL(request));
//
//        } catch (Exception e) {
//            log.error("Error in resend OTP", e);
//            return false;
//        }
//        return true;
//    }
//}