package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.BookCategory;
import com.ats.books.service.BookCategoryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/bookcategory/edit"
    },
    service = MVCRenderCommand.class
)
public class EditBookCategoryRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long categoryId = ParamUtil.getLong(renderRequest, "categoryId");

        try {
            BookCategory category = BookCategoryLocalServiceUtil.getBookCategory(categoryId);
            renderRequest.setAttribute("category", category);
        } catch (PortalException e) {
            e.printStackTrace();
        }

        return "/editBookCategory.jsp";
    }
}
