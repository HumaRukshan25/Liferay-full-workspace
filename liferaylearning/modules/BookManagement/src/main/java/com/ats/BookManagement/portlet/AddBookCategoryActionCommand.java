//package com.ats.BookManagement.portlet;
//
//import com.ats.BookManagement.constants.BookManagementPortletKeys;
//import com.ats.books.model.BookCategory;
//import com.ats.books.service.BookCategoryLocalServiceUtil;
//import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.WebKeys;
//
//import javax.portlet.*;
//import java.util.Date;
//
//import org.osgi.service.component.annotations.Component;
//
//@Component(
//    property = {
//        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
//        "mvc.command.name=/bookcategory/add"
//    },
//    service = MVCActionCommand.class
//)
//public class AddBookCategoryActionCommand implements MVCActionCommand {
//
//    @Override
//    public boolean processAction(ActionRequest request, ActionResponse response) {
//        try {
//        	
//      
//
//            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//
//            String categoryName = ParamUtil.getString(request, "categoryName");
//
//            long categoryId = CounterLocalServiceUtil.increment(BookCategory.class.getName());
//
//            BookCategory category = BookCategoryLocalServiceUtil.createBookCategory(categoryId);
//
//           //---> 
//           // long bookId = ParamUtil.getLong(request, "bookId");
//           // category.setBookId(bookId);
//
//
//            category.setCategoryId(categoryId);
//            category.setGroupId(themeDisplay.getScopeGroupId());
//            category.setCompanyId(themeDisplay.getCompanyId());
//            category.setUserId(themeDisplay.getUserId());
//            category.setUserName(themeDisplay.getUser().getFullName());
//            category.setCreateDate(new Date());
//            category.setModifiedDate(new Date());
//            category.setCategoryName(categoryName);
//
//            BookCategoryLocalServiceUtil.addBookCategory(category);
//
//            response.setRenderParameter("mvcRenderCommandName", "/bookcategory/view");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return true;
//    }
//}



package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.BookCategory;
import com.ats.books.service.BookCategoryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/bookcategory/add"
    },
    service = MVCActionCommand.class
)
public class AddBookCategoryActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

            // Fetch all form parameters
            String categoryName = ParamUtil.getString(request, "categoryName");
            String categoryCode = ParamUtil.getString(request, "categoryCode");
            String description = ParamUtil.getString(request, "description");
            String createdBy = ParamUtil.getString(request, "createdBy");
            String department = ParamUtil.getString(request, "department");
            String status = ParamUtil.getString(request, "status");
            long bookId = ParamUtil.getLong(request, "bookId");

            long categoryId = CounterLocalServiceUtil.increment(BookCategory.class.getName());
            BookCategory category = BookCategoryLocalServiceUtil.createBookCategory(categoryId);

            // Set values
            category.setCategoryId(categoryId);
            category.setGroupId(themeDisplay.getScopeGroupId());
            category.setCompanyId(themeDisplay.getCompanyId());
            category.setUserId(themeDisplay.getUserId());
            category.setUserName(themeDisplay.getUser().getFullName());
            category.setCreateDate(new Date());
            category.setModifiedDate(new Date());

            category.setCategoryName(categoryName);
           
            category.setBookId(bookId);
          

            BookCategoryLocalServiceUtil.addBookCategory(category);

            // Redirect to view after adding
            response.setRenderParameter("mvcRenderCommandName", "/bookcategory/view");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
