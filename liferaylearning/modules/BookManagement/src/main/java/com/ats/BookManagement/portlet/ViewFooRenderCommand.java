package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;



import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;



import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/foo/view"
    },
    service = MVCRenderCommand.class
)
public class ViewFooRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
    	
    	
        return "/foo-list.jsp"; // make sure this file is placed inside src/main/resources/META-INF/resources/
    }
}
