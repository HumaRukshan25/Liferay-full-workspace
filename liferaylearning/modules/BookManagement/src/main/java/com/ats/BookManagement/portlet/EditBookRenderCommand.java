package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.Books;
import com.ats.books.service.BooksLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.*;
import java.text.SimpleDateFormat;


import org.osgi.service.component.annotations.Component;



@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/books/edit"
    },
    service = MVCRenderCommand.class
)
public class EditBookRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest request, RenderResponse response) {
        long bookId = ParamUtil.getLong(request, "bookId");

        try {
            Books book = BooksLocalServiceUtil.getBooks(bookId);
            request.setAttribute("book", book);

            if (book.getPublishDate() != null) {
                String publishDateStr = new SimpleDateFormat("yyyy-MM-dd").format(book.getPublishDate());
                request.setAttribute("publishDateStr", publishDateStr);
            }
        } catch (PortalException e) {
            e.printStackTrace();
        }

        return "/editBooks.jsp";
    }
}
