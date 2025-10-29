package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.Books;
import com.ats.books.service.BooksLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/books/viewFiltered"
    },
    service = MVCRenderCommand.class
)
public class ViewFilteredBooksRenderCommand implements MVCRenderCommand {
	//1.for learning dynamic query
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        String titleKeyword = ParamUtil.getString(renderRequest, "title");
        String sortBy = ParamUtil.getString(renderRequest, "sortColumn");

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

        List<Books> books = BooksLocalServiceUtil.dynamicQuery(query);

        renderRequest.setAttribute("bookList", books);
        renderRequest.setAttribute("title", titleKeyword);
        renderRequest.setAttribute("sortColumn", sortBy);

        return "/filterdql.jsp";
    }
}
