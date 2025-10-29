package OnlineFIR.admin;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;

import org.osgi.service.component.annotations.Component;

import OnlineFIR.constants.OnlineFIRPortletKeys;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
                "mvc.command.name=/user/activate"
        },
        service = MVCActionCommand.class
)
public class ActivateUserMVCActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();
            String email = (String) session.getAttribute("pendingEmail");
            String firstName = (String) session.getAttribute("pendingFirstName");

            if (email == null || firstName == null) {
                actionResponse.setRenderParameter("mvcPath", "/error.jsp");
                return false;
            }

            // Generate OTP
            int otp = new Random().nextInt(900000) + 100000;
            session.setAttribute("pendingOTP", otp);

            // Send OTP email
            InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR Portal");
            InternetAddress to = new InternetAddress(email);
            String subject = "Your OTP for Online FIR Signup";
            String body = "Hello " + firstName + ",\n\n" +
                    "Your OTP is: " + otp + "\n\n" +
                    "Enter this OTP to complete signup.";

            MailMessage mailMessage = new MailMessage(from, to, subject, body, false);
            MailServiceUtil.sendEmail(mailMessage);

            System.out.println("OTP sent to: " + email + " OTP: " + otp);

            // Redirect to OTP verify page
            actionResponse.setRenderParameter("mvcPath", "/verifyOTP.jsp");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

