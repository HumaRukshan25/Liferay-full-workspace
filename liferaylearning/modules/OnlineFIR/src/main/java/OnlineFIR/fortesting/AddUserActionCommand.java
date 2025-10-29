package OnlineFIR.fortesting;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.servlet.SessionMessages;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import OnlineFIR.constants.OnlineFIRPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
        "mvc.command.name=/admin/saveUser1"
    },
    service = MVCActionCommand.class
)
public class AddUserActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

            String loginName = ParamUtil.getString(actionRequest, "loginName");
            String firstName = ParamUtil.getString(actionRequest, "firstName");
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            String email = ParamUtil.getString(actionRequest, "email");
            String phoneNo = ParamUtil.getString(actionRequest, "phoneNo");
            String roleName = ParamUtil.getString(actionRequest, "role");
            boolean active = ParamUtil.getBoolean(actionRequest, "active", true); // default true
            String password = ParamUtil.getString(actionRequest, "password", "Test@123"); // default password

            long companyId = themeDisplay.getCompanyId();
            long creatorUserId = themeDisplay.getUserId();
            
            ServiceContext serviceContext = new ServiceContext();
            serviceContext.setCompanyId(companyId);
            serviceContext.setUserId(creatorUserId);

            System.out.println("Creating user with details:");
            System.out.println("Login: " + loginName);
            System.out.println("Email: " + email);
            System.out.println("Role: " + roleName);
            System.out.println("Active: " + active);

            // Check if user already exists
            try {
                User existingUser = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
                if (existingUser != null) {
                    SessionMessages.add(actionRequest, "error", "User with email " + email + " already exists!");
                    actionResponse.setRenderParameter("mvcRenderCommandName", "/admin/addUser1");
                    return false;
                }
            } catch (Exception e) {
                // User doesn't exist, continue
            }

            // Check if login name exists
            try {
                User existingUser = UserLocalServiceUtil.getUserByScreenName(companyId, loginName);
                if (existingUser != null) {
                    SessionMessages.add(actionRequest, "error", "Login name " + loginName + " already exists!");
                    actionResponse.setRenderParameter("mvcRenderCommandName", "/admin/addUser1");
                    return false;
                }
            } catch (Exception e) {
                // Login name doesn't exist, continue
            }

            // ---------- CREATE USER IN user_ TABLE ----------
            User newUser = UserLocalServiceUtil.addUser(
                creatorUserId,          // creatorUserId
                companyId,              // companyId
                false,                  // autoPassword
                password,               // password1
                password,               // password2
                false,                  // autoScreenName
                loginName,              // screenName
                email,                  // emailAddress
                themeDisplay.getLocale(), // locale
                firstName,              // firstName
                "",                     // middleName
                lastName,               // lastName
                0L,                     // prefixListTypeId
                0L,                     // suffixListTypeId
                true,                   // male
                1,                      // birthdayMonth
                1,                      // birthdayDay
                1990,                   // birthdayYear
                "",                     // jobTitle
                0, new long[0],            // groupIds
                new long[0],            // organizationIds
                new long[0],            // roleIds
                new long[0],            // userGroupIds
                false,                  // sendEmail
                serviceContext
            );

            System.out.println("User created successfully with ID: " + newUser.getUserId());

            // ---------- SET USER STATUS (ACTIVE/INACTIVE) ----------
            int status = active ? 0 : 5; // 0 = Active, 5 = Inactive
            UserLocalServiceUtil.updateStatus(newUser.getUserId(), status, serviceContext);
            System.out.println("User status set to: " + status);

            // ---------- ASSIGN ROLE ----------
            if (roleName != null && !roleName.isEmpty()) {
                try {
                    Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
                    if (role != null) {
                        UserLocalServiceUtil.addRoleUser(role.getRoleId(), newUser);
                        System.out.println("Role assigned: " + roleName);
                    } else {
                        System.out.println("Role not found: " + roleName);
                    }
                } catch (Exception e) {
                    System.out.println("Error assigning role: " + e.getMessage());
                }
            }

            // ---------- SET PHONE NUMBER (Using Expando) ----------
            if (phoneNo != null && !phoneNo.isEmpty()) {
                try {
                    // Using Expando attributes for custom fields
                    newUser.setExpandoBridgeAttributes(serviceContext);
                    
                    // Set phone number in expando
                  ExpandoBridge expando = newUser.getExpandoBridge();
                    expando.setAttribute("phoneNumber", phoneNo);
                    
                    System.out.println("Phone number set: " + phoneNo);
                } catch (Exception e) {
                    System.out.println("Error setting phone number: " + e.getMessage());
                }
            }

            // Success message
            SessionMessages.add(actionRequest, "user-added-success", "User " + firstName + " " + lastName + " added successfully!");

            System.out.println("User creation completed successfully");

            // Redirect back to Manage Users
            actionResponse.setRenderParameter("mvcRenderCommandName", "/admin/manageUsers1");

        } catch (Exception e) {
            e.printStackTrace();
            SessionMessages.add(actionRequest, "error", "Error creating user: " + e.getMessage());
            actionResponse.setRenderParameter("mvcRenderCommandName", "/admin/addUser1");
            return false;
        }

        return true;
    }
}
