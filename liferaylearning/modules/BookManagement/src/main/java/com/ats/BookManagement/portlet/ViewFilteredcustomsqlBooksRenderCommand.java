//package com.ats.BookManagement.portlet;
//
//import com.ats.BookManagement.constants.BookManagementPortletKeys;
//import com.ats.books.model.Books;
//import com.ats.books.service.BooksLocalServiceUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.util.ParamUtil;
//
//import org.osgi.service.component.annotations.Component;
//
//import javax.portlet.PortletException;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import java.util.List;
//
//@Component(
//    property = {
//        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
//        "mvc.command.name=/books/filtersqlView"
//    },
//    service = MVCRenderCommand.class
//)
//public class ViewFilteredcustomsqlBooksRenderCommand implements MVCRenderCommand {
//
//    @Override
//    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
//            throws PortletException {
//
//        String keyword = ParamUtil.getString(renderRequest, "keyword");
//
//        if (keyword != null && !keyword.isEmpty()) {
//            List<Books> filteredBooks = BooksLocalServiceUtil.getBooksByTitle(keyword);
//            renderRequest.setAttribute("filteredBooks", filteredBooks);
//            renderRequest.setAttribute("keyword", keyword);
//        }
//
//        return "/filtercustomsql.jsp";
//    }
//}
