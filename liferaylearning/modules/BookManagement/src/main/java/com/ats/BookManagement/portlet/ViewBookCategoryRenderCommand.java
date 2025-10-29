package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.BookCategory;
import com.ats.books.service.BookCategoryLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/bookcategory/view"
    },
    service = MVCRenderCommand.class
)
public class ViewBookCategoryRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        List<BookCategory> categories = BookCategoryLocalServiceUtil.getBookCategories(-1, -1);
        renderRequest.setAttribute("bookCategories", categories);
        return "/bookCategory.jsp";
    }
}
