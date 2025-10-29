package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.Books;
import com.ats.books.service.BooksLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import java.util.List;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/books/filterBooks"
    },
    service = MVCActionCommand.class
)
public class FilterBooksActionCommand implements MVCActionCommand {
//1.for learning dynamic query
    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        String titleKeyword = ParamUtil.getString(actionRequest, "title");
        String sortBy = ParamUtil.getString(actionRequest, "sortColumn");

        DynamicQuery query = DynamicQueryFactoryUtil.forClass(
            Books.class, PortalClassLoaderUtil.getClassLoader()
        );

        if (Validator.isNotNull(titleKeyword)) {
            query.add(PropertyFactoryUtil.forName("title").like("%" + titleKeyword + "%"));
        }

        if ("title".equalsIgnoreCase(sortBy)) {
            query.addOrder(OrderFactoryUtil.asc("title"));
        } else if ("author".equalsIgnoreCase(sortBy)) {
            query.addOrder(OrderFactoryUtil.asc("author"));
        }

        List<Books> bookList = BooksLocalServiceUtil.dynamicQuery(query);

        actionRequest.setAttribute("bookList", bookList);
        actionRequest.setAttribute("title", titleKeyword);
        actionRequest.setAttribute("sortColumn", sortBy);

        // Forward to JSP
        actionResponse.setRenderParameter("mvcPath", "/filterdql.jsp");
        return true;
    }
}
