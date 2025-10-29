//package com.ats.BookManagement.portlet;
//
//import com.ats.BookManagement.constants.BookManagementPortletKeys;
//import com.ats.books.model.BookCategory;
//import com.ats.books.service.BookCategoryLocalServiceUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.util.ParamUtil;
//
//import javax.portlet.*;
//import java.util.Date;
//
//import org.osgi.service.component.annotations.Component;
//
//@Component(
//    property = {
//        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
//        "mvc.command.name=/bookcategory/edit"
//    },
//    service = MVCActionCommand.class
//)
//public class EditBookCategoryActionCommand implements MVCActionCommand {
//
//    @Override
//    public boolean processAction(ActionRequest request, ActionResponse response) {
//        try {
//            long categoryId = ParamUtil.getLong(request, "categoryId");
//            String categoryName = ParamUtil.getString(request, "categoryName");
//
//            //
//           // long bookId = ParamUtil.getLong(request, "bookId");
//            
//
//            BookCategory category = BookCategoryLocalServiceUtil.getBookCategory(categoryId);
//            category.setCategoryName(categoryName);
//            //
//          //  category.setBookId(bookId);
//            category.setModifiedDate(new Date());
//
//            BookCategoryLocalServiceUtil.updateBookCategory(category);
//
//            response.setRenderParameter("mvcRenderCommandName", "/bookcategory/view");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return true;
//    }
//}



// ------------------ EditBookCategoryActionCommand.java ------------------
package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.BookCategory;
import com.ats.books.service.BookCategoryLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.*;
import java.util.Date;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/bookcategory/edit"
    },
    service = MVCActionCommand.class
)
public class EditBookCategoryActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) {
        try {
            long categoryId = ParamUtil.getLong(request, "categoryId");
            String categoryName = ParamUtil.getString(request, "categoryName");
            long bookId = ParamUtil.getLong(request, "bookId");

            BookCategory category = BookCategoryLocalServiceUtil.getBookCategory(categoryId);
            category.setCategoryName(categoryName);
            category.setBookId(bookId);
            category.setModifiedDate(new Date());

            BookCategoryLocalServiceUtil.updateBookCategory(category);

            response.setRenderParameter("mvcRenderCommandName", "/bookcategory/view");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
