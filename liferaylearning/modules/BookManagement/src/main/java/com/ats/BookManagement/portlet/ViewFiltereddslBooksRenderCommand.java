package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.Books;
import com.ats.books.model.BooksTable;
import com.ats.books.service.BooksLocalServiceUtil;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/books/filterdslView"
    },
    service = MVCRenderCommand.class
)
public class ViewFiltereddslBooksRenderCommand implements MVCRenderCommand {
//	<!-- 2. for learning dsl query -->
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        String keyword = ParamUtil.getString(renderRequest, "keyword");

        if (keyword != null && !keyword.isEmpty()) {
            DSLQuery dslQuery = DSLQueryFactoryUtil
                    .select(BooksTable.INSTANCE)
                    .from(BooksTable.INSTANCE)
                    .where(BooksTable.INSTANCE.title.like("%" + keyword + "%"));

            List<Books> filteredBooks = BooksLocalServiceUtil.dslQuery(dslQuery);

            renderRequest.setAttribute("filteredBooks", filteredBooks);
            renderRequest.setAttribute("keyword", keyword);
        }

        return "/filterdsl.jsp";
    }
}
