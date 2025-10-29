
package OnlineFIR.admin;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import OnlineFIR.constants.OnlineFIRPortletKeys;
import fironlineser.model.SignupUser;
import fironlineser.service.SignupUserLocalServiceUtil;


@Component(
immediate = true,
property = {
  "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
  "mvc.command.name=/admin/manageUsers"
},
service = MVCRenderCommand.class
)
public class ManageUsersRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest request, RenderResponse response)
            throws PortletException {

        // Fetch all users from signupuser table
        List<SignupUser> users = SignupUserLocalServiceUtil.getSignupUsers(-1, -1);

        // Pass to JSP
        request.setAttribute("users", users);

        return "/manage_users.jsp";
    }
}


//
//package OnlineFIR.admin;
//
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import org.osgi.service.component.annotations.Component;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import java.util.List;
//import OnlineFIR.constants.OnlineFIRPortletKeys;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
//        "mvc.command.name=/admin/manageUsers"
//    },
//    service = MVCRenderCommand.class
//)
//public class ManageUsersRenderCommand implements MVCRenderCommand {
//
//    @Override
//    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
//        try {
//            List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
//            renderRequest.setAttribute("users", users);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "/manage_users.jsp";
//    }
//}

