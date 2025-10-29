package OnlinrFIRcitizen.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

import OnlinrFIRcitizen.constants.OnlinrFIRcitizenPortletKeys;
import fironlineser.model.FIRRR;
import fironlineser.service.FIRRRLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OnlinrFIRcitizenPortletKeys.ONLINRFIRCITIZEN,
        "mvc.command.name=/citizen/trackFIR"
    },
    service = MVCRenderCommand.class
)
public class TrackFIRRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long userId = themeDisplay.getUserId();

            // Create DynamicQuery for FIRRR
            DynamicQuery query = FIRRRLocalServiceUtil.dynamicQuery();

            // Filter by userId
            query.add(RestrictionsFactoryUtil.eq("userId", userId));

            // Execute query
            List<FIRRR> firs = FIRRRLocalServiceUtil.dynamicQuery(query);

            // Set results in request
            renderRequest.setAttribute("firs", firs);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/trackFIR.jsp";
    }
}