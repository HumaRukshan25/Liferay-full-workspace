package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.service.BooksLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.exception.PortalException;

import javax.portlet.*;
import org.osgi.service.component.annotations.Component;



@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/books/delete"
    },
    service = MVCActionCommand.class
)
public class DeleteBookActionCommand implements MVCActionCommand {
    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
        long bookId = ParamUtil.getLong(request, "bookId");

        try {
            BooksLocalServiceUtil.deleteBooks(bookId);
        } catch (PortalException e) {
            e.printStackTrace();
        }

        return true;
    }
}
