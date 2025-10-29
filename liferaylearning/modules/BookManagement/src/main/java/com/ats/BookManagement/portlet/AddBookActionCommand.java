//package com.ats.BookManagement.portlet;
//
//import com.ats.BookManagement.constants.BookManagementPortletKeys;
//import com.ats.books.model.Books;
//import com.ats.books.service.BooksLocalServiceUtil;
//import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.util.ParamUtil;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.portlet.PortletException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.osgi.service.component.annotations.Component;
//@Component(
//    property = {
//        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
//        "mvc.command.name=/books/add"
//    },
//    service = MVCActionCommand.class
//)
//public class AddBookActionCommand implements MVCActionCommand {
//
//    @Override
//    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
//        try {
//            String title = ParamUtil.getString(request, "title");
//            String author = ParamUtil.getString(request, "author");
//            String publishDateStr = ParamUtil.getString(request, "publishDate");
//
//            
//            // Get userId of selected author and convert to full name
//            long authorUserId = ParamUtil.getLong(request, "authorUserId");
//            User authorUser = UserLocalServiceUtil.getUser(authorUserId);
//            String authorName = authorUser.getFullName();
//            
//            Date publishDate = new SimpleDateFormat("yyyy-MM-dd").parse(publishDateStr);
//            long bookId = CounterLocalServiceUtil.increment(Books.class.getName());
//
//            
//            Books book = BooksLocalServiceUtil.createBooks(bookId);
//            book.setTitle(title);
//            book.setAuthor(author);
//            book.setPublishDate(publishDate);
//
//            // Optional: Set audit fields if your entity uses them
//            book.setCreateDate(new Date());
//            book.setModifiedDate(new Date());
//
//            BooksLocalServiceUtil.addBooks(book);
//
//            // Redirect back to the default view
//            response.setRenderParameter("mvcRenderCommandName", "/");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new PortletException("Error adding book", e);
//        }
//
//        return true;
//    }
//}
//


package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.Books;
import com.ats.books.service.BooksLocalServiceUtil;


import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/books/add"
    },
    service = MVCActionCommand.class
)
public class AddBookActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
        try {
            String title = ParamUtil.getString(request, "title");
            long authorUserId = ParamUtil.getLong(request, "author"); // from <aui:select name="author">
            String publishDateStr = ParamUtil.getString(request, "publishDate");

            // Fetch full name from Liferay user
            User authorUser = UserLocalServiceUtil.getUser(authorUserId);
            String authorName = authorUser.getFullName();

            Date publishDate = new SimpleDateFormat("yyyy-MM-dd").parse(publishDateStr);
            long bookId = CounterLocalServiceUtil.increment(Books.class.getName());

            Books book = BooksLocalServiceUtil.createBooks(bookId);
            book.setTitle(title);
            book.setAuthor(authorName); // store author's full name
            book.setPublishDate(publishDate);

            book.setCreateDate(new Date());
            book.setModifiedDate(new Date());

            BooksLocalServiceUtil.addBooks(book);

            response.setRenderParameter("mvcRenderCommandName", "/");
        } catch (Exception e) {
            e.printStackTrace();
            throw new PortletException("Error adding book", e);
        }

        return true;
    }
}
