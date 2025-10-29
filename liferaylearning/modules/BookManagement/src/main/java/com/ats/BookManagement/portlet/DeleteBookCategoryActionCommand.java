package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.service.BookCategoryLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/bookcategory/delete"
    },
    service = MVCActionCommand.class
)
public class DeleteBookCategoryActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) {
        try {
            long categoryId = ParamUtil.getLong(request, "categoryId");
            BookCategoryLocalServiceUtil.deleteBookCategory(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
