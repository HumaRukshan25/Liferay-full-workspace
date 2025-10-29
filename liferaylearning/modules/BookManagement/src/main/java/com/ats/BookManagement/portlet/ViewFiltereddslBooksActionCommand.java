package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.Books;
import com.ats.books.model.BooksTable;
import com.ats.books.service.BooksLocalServiceUtil;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.List;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=/books/filterdslAction"
    },
    service = MVCActionCommand.class
)
public class ViewFiltereddslBooksActionCommand implements MVCActionCommand {
//	<!-- 2. for learning dsl query -->
    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        String keyword = ParamUtil.getString(actionRequest, "keyword", "");

        DSLQuery dslQuery = DSLQueryFactoryUtil
                .select(BooksTable.INSTANCE)
                .from(BooksTable.INSTANCE)
                .where(BooksTable.INSTANCE.title.like("%" + keyword + "%"));

        List<Books> filteredBooks = BooksLocalServiceUtil.dslQuery(dslQuery);

        actionRequest.setAttribute("filteredBooks", filteredBooks);
        actionRequest.setAttribute("keyword", keyword);

        actionResponse.setRenderParameter("mvcRenderCommandName", "/books/filterdslView");

        return true;
    }
}
