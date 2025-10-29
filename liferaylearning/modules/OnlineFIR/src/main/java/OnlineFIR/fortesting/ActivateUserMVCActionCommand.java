

package OnlineFIR.fortesting;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;

import OnlineFIR.constants.OnlineFIRPortletKeys;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/user/activate1"
    },
    service = MVCActionCommand.class
)
public class ActivateUserMVCActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            // Use ParamUtil instead of direct parameter access
            String email = ParamUtil.getString(actionRequest, "email");
            String firstName = ParamUtil.getString(actionRequest, "firstName");

            System.out.println("Activation attempt for email: " + email + ", firstName: " + firstName);

            if (email == null || email.isEmpty() || firstName == null || firstName.isEmpty()) {
                System.out.println("Email or firstName is null/empty");
                actionResponse.setRenderParameter("mvcPath", "/emailNotFound.jsp");
                return false;
            }

            HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
            
            // Store in session for OTP verification
            session.setAttribute("pendingUserEmail", email);
            session.setAttribute("pendingUserFirstName", firstName);

            // Generate 6-digit OTP
            int otp = new Random().nextInt(900000) + 100000;
            String otpString = String.valueOf(otp);
            session.setAttribute("pendingOTP", otpString);
            session.setAttribute("otpGeneratedTime", System.currentTimeMillis());

            System.out.println("Generated OTP: " + otpString + " for email: " + email);

            // Send OTP email
            InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR Portal");
            InternetAddress to = new InternetAddress(email);
            String subject = "Your OTP for Online FIR Signup";
            String body = "Hello " + firstName + ",\n\nYour OTP is: " + otp + "\nValid for 10 minutes.";

            MailMessage mailMessage = new MailMessage(from, to, subject, body, false);
            MailServiceUtil.sendEmail(mailMessage);

            System.out.println("OTP email sent successfully to: " + email);

            actionResponse.setRenderParameter("mvcPath", "/otpVerify1.jsp");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in activation: " + e.getMessage());
            actionResponse.setRenderParameter("mvcPath", "/error.jsp");
            return false;
        }
    }
}