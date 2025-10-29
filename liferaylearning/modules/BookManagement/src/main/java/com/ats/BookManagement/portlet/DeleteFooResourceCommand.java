package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.Foo;
import com.ats.books.service.FooLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;


@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=deleteFoo"
    },
    service = MVCResourceCommand.class
)
public class DeleteFooResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest request, ResourceResponse response) throws PortletException {
	    try {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(PortalUtil.getHttpServletRequest(request).getInputStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;

	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }

	        JSONObject jsonBody = JSONFactoryUtil.createJSONObject(sb.toString());
	        long fooId = jsonBody.getLong("fooId");

	        System.out.println("🧨 Received fooId for delete: " + fooId);

	        Foo foo = FooLocalServiceUtil.fetchFoo(fooId);

	        if (foo != null) {
	            FooLocalServiceUtil.deleteFoo(foo); // ✅ deletes from DB
	            response.getWriter().write("success");
	        } else {
	            response.getWriter().write("not_found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        try {
	            response.getWriter().write("error");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

	    return true;
	}

}
