package OnlineFIR.portlet;

import OnlineFIR.constants.OnlineFIRPortletKeys;

import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sania Mir
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OnlineFIR",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OnlineFIRPortletKeys.ONLINEFIR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OnlineFIRPortlet extends MVCPortlet {
	
		 
		 
		 @Override
		    public void render(RenderRequest renderRequest, RenderResponse renderResponse)
		        throws IOException, PortletException {
		        
		        // Handle reset password token redirects
		        String token = ParamUtil.getString(renderRequest, "token");
		        String email = ParamUtil.getString(renderRequest, "email");
		        
		        if (token != null && !token.isEmpty() && email != null && !email.isEmpty()) {
		            // This is a password reset link, show the reset password form
		            renderRequest.setAttribute("token", token);
		            renderRequest.setAttribute("email", email);
		            try {
						include("/resetPassword.jsp", renderRequest, renderResponse);
					} catch (java.io.IOException | PortletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            return;
		        }
		        
		        try {
					super.render(renderRequest, renderResponse);
				} catch (java.io.IOException | PortletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    
	 }
}

