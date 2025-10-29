package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.*;
import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/books/add"
    },
    service = MVCRenderCommand.class
)
public class AddBookMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        
    	
    	return "/addBooks.jsp";
    }
}


