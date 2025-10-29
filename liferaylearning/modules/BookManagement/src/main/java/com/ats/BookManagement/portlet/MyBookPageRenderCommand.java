// MyBookPageRenderCommand.java
package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/mybookpage"
    },
    service = MVCRenderCommand.class
)
public class MyBookPageRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest request, RenderResponse response) {
        return "/mybookpage.jsp";
    }
}
