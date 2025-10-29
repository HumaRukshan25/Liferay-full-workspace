package OnlineFIR.fortesting;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;

import OnlineFIR.constants.OnlineFIRPortletKeys;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/password/resetUser"
    },
    service = MVCActionCommand.class
)
public class ResetUserPasswordMVCActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(ResetUserPasswordMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        String email = ParamUtil.getString(actionRequest, "email");
        String newPassword = ParamUtil.getString(actionRequest, "newPassword");
        String confirmPassword = ParamUtil.getString(actionRequest, "confirmPassword");

        try {
            if (!newPassword.equals(confirmPassword)) {
                SessionErrors.add(actionRequest, "resetError");
                actionResponse.setRenderParameter("mvcPath", "/resetPassword1.jsp");
                return false;
            }

            // ✅ Get correct companyId
            long companyId = PortalUtil.getCompanyId(actionRequest);

            // ✅ Find user by email
            User user = null;
            try {
                user = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
            } catch (Exception noUserEx) {
                log.warn("No user found with email: " + email);
            }

            if (user == null) {
                SessionErrors.add(actionRequest, "userNotFound");
                actionResponse.setRenderParameter("mvcPath", "/resetPassword1.jsp");
                return false;
            }

            // ✅ Update password (Liferay handles hashing)
            UserLocalServiceUtil.updatePassword(
                user.getUserId(),
                newPassword,
                newPassword,
                false
            );

            // ✅ Send confirmation email (optional)
            try {
                InternetAddress from = new InternetAddress("hrukshan135@gmail.com", "Online FIR Portal");
                InternetAddress to = new InternetAddress(email);
                String subject = "Password Reset Confirmation";
                String body = "Hello " + user.getFirstName() + ",\n\n"
                            + "Your password has been reset successfully.\n\n"
                            + "Regards,\nOnline FIR Portal";

                MailMessage message = new MailMessage(from, to, subject, body, false);
                MailServiceUtil.sendEmail(message);
            } catch (Exception e) {
                log.warn("Error sending confirmation email to " + email, e);
            }

            SessionMessages.add(actionRequest, "resetSuccess");
            log.info("Password reset successful for: " + email);

        } catch (Exception e) {
            SessionErrors.add(actionRequest, "resetError");
            log.error("Error resetting password for email: " + email, e);
            actionResponse.setRenderParameter("mvcPath", "/resetPassword1.jsp");
            return false;
        }

        actionResponse.setRenderParameter("mvcPath", "/resetPassword1.jsp");
        return true;
    }
}
