package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.Books;
import com.ats.books.service.BooksLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import javax.portlet.*;
import java.io.IOException;

import java.util.List;

import org.osgi.service.component.annotations.Component;


// do clean build deploy if portlet not showing in widgets
@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Book-Management",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)



public class BookManagementPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        List<Books> books = BooksLocalServiceUtil.getBookses(-1, -1);
        renderRequest.setAttribute("books", books);

        super.doView(renderRequest, renderResponse);
        
        ///---------for customfieldto fetchh------>
        try {
			User user=UserLocalServiceUtil.getUser(1);
			
	 user.getExpandoBridge().getAttribute("Blood group1");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}

