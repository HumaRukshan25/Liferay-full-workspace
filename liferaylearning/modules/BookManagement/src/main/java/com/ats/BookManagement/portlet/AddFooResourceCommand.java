package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.Foo;
import com.ats.books.service.FooLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;


@Component(
	    property = {
	        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
	        "mvc.command.name=addFoo"
	    },
	    service = MVCResourceCommand.class
	)
	public class AddFooResourceCommand implements MVCResourceCommand {
	    @Override
	    public boolean serveResource(ResourceRequest request, ResourceResponse response) throws PortletException {
	        try {
	            HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
	            BufferedReader reader = new BufferedReader(new InputStreamReader(httpRequest.getInputStream()));
	            StringBuilder sb = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                sb.append(line);
	            }

	            JSONObject body = JSONFactoryUtil.createJSONObject(sb.toString());
	            String userName = body.getString("userName");
	            long groupId = body.getLong("groupId");
	            long companyId = body.getLong("companyId");
	            long userId = body.getLong("userId");

	            long fooId = CounterLocalServiceUtil.increment(Foo.class.getName());
	            Foo foo = FooLocalServiceUtil.createFoo(fooId);
	            foo.setUserName(userName);
	            foo.setGroupId(groupId);
	            foo.setCompanyId(companyId);
	            foo.setUserId(userId);
	            foo.setCreateDate(new Date());
	            foo.setModifiedDate(new Date());

	            FooLocalServiceUtil.addFoo(foo);

	            PrintWriter out = response.getWriter();
	            out.write("success");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
	}
