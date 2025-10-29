package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.Books;
import com.ats.books.service.BooksLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.osgi.service.component.annotations.Component;



@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/books/edit"
    },
    service = MVCActionCommand.class
)
public class EditBookActionCommadn implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
        long bookId = ParamUtil.getLong(request, "bookId");
        String title = ParamUtil.getString(request, "title");
        String author = ParamUtil.getString(request, "author");
        String publishDateStr = ParamUtil.getString(request, "publishDate");

        try {
            Books book = BooksLocalServiceUtil.getBooks(bookId);
            book.setTitle(title);
            book.setAuthor(author);
            Date publishDate = new SimpleDateFormat("yyyy-MM-dd").parse(publishDateStr);
            book.setPublishDate(publishDate);
            BooksLocalServiceUtil.updateBooks(book);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
