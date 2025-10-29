////package postlogin;
////
////import com.liferay.portal.kernel.events.LifecycleAction;
////
////import org.osgi.service.component.annotations.Component;
////
/////**
//// * @author Sania Mir
//// */
////@Component(
////	property = {"key=login.events.post"
////		// TODO enter required service properties
////	},
////	service = LifecycleAction.class
////)
////public class Postlogin implements LifecycleAction {
////
////	// TODO enter required service methods
////
////}



// this  i have done for custom login
//
//package postlogin;
//
//import com.liferay.mail.kernel.model.MailMessage;
//import com.liferay.mail.kernel.service.MailServiceUtil;
//import com.liferay.portal.kernel.events.ActionException;
//import com.liferay.portal.kernel.events.LifecycleAction;
//import com.liferay.portal.kernel.events.LifecycleEvent;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.util.WebKeys;
//
//import java.util.Random;
//
//import javax.mail.internet.InternetAddress;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.osgi.service.component.annotations.Component;
//
//@Component(
//    immediate = true,
//    property = {
//        "key=login.events.post"
//    },
//    service = LifecycleAction.class
//)
//public class Postlogin implements LifecycleAction {
//
//    private static final Log log = LogFactoryUtil.getLog(Postlogin.class);
//
//    @Override
//    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
//        log.info("Inside the processLifecycleEvent method");
//
//        HttpServletRequest request = lifecycleEvent.getRequest();
//        HttpSession session = request.getSession();
//
//        try {
//            User user = (User) request.getAttribute(WebKeys.USER);
//
//            if (user == null) {
//                return;
//            }
//
//            // Generate random 6-digit OTP
//            String otpCode = String.format("%06d", new Random().nextInt(999999));
//            long otpTimestamp = System.currentTimeMillis();
//
//            log.info("Generated OTP: " + otpCode);
//            log.info("Session ID: " + session.getId());
//
//            // ✅ Store OTP & metadata in session
//            session.setAttribute("OTP_CHALLENGE", true);
//            session.setAttribute("EXPECTED_OTP", otpCode);
//            session.setAttribute("OTP_TIMESTAMP", otpTimestamp);
//            session.setAttribute("USER_ROLE", "user");
//
//            // Debug
//            logSessionAttributes(session);
//
//            // Send OTP email
//            InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR Registry System");
//            InternetAddress to = new InternetAddress(user.getEmailAddress());
//
//            MailMessage message = new MailMessage();
//            message.setFrom(from);
//            message.setTo(to);
//            message.setSubject("Your One Time Password (OTP)");
//            message.setBody(
//                "Hello " + user.getFullName() +
//                ",\n\nYour OTP is: " + otpCode +
//                "\n\nEnter this to continue login."
//            );
//            message.setHTMLFormat(false);
//
//            MailServiceUtil.sendEmail(message);
//
//            log.info("OTP email sent to: " + user.getEmailAddress());
//
//        } catch (Exception e) {
//            log.error("Error in Postlogin lifecycle event", e);
//            throw new ActionException(e);
//        }
//    }
//
//    private void logSessionAttributes(HttpSession session) {
//        java.util.Enumeration<String> attributeNames = session.getAttributeNames();
//        StringBuilder attributes = new StringBuilder("Session Attributes: ");
//        while (attributeNames.hasMoreElements()) {
//            String name = attributeNames.nextElement();
//            Object value = session.getAttribute(name);
//            attributes.append(name).append("=").append(value).append(", ");
//        }
//        log.info(attributes.toString());
//    }
//}

//for this i selcted service when creating this module postlogin 
//clean,build,deploy if not coming
package postlogin;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {"key=login.events.post"},
    service = LifecycleAction.class
)
public class Postlogin implements LifecycleAction {

    private static final Log log = LogFactoryUtil.getLog(Postlogin.class);

    @Override
    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
        log.info("Inside Postlogin event");

        HttpServletRequest request = lifecycleEvent.getRequest();
        HttpSession httpSession = request.getSession(true);

        try {
            User user = (User) request.getAttribute(WebKeys.USER);

            if (user == null) {
                log.warn("User is null in Postlogin event");
                return;
            }

            // Generate OTP
            String otpCode = String.format("%06d", new Random().nextInt(999999));
            log.info("Generated OTP: " + otpCode);

            // Store in HttpSession
            httpSession.setAttribute("EXPECTED_OTP", otpCode);
            httpSession.setAttribute("USER_ROLE", "user"); // or admin

            // Send OTP email
            InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR Registry System");
            InternetAddress to = new InternetAddress(user.getEmailAddress());

            MailMessage message = new MailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject("Your One Time Password (OTP)");
            message.setBody(
                "Hello " + user.getFullName() +
                ",\n\nYour OTP is: " + otpCode +
                "\n\nEnter this to continue login."
            );
            message.setHTMLFormat(false);

            MailServiceUtil.sendEmail(message);
            log.info("OTP email sent to: " + user.getEmailAddress());

        } catch (Exception e) {
            log.error("Error in Postlogin event", e);
            throw new ActionException(e);
        }
    }
}


