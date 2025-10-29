//package com.ats.BookManagement.portlet;
//
//import com.ats.BookManagement.constants.BookManagementPortletKeys;
//import com.ats.books.model.Foo;
//import com.ats.books.service.FooLocalServiceUtil;
//import com.liferay.portal.kernel.json.JSONArray;
//import com.liferay.portal.kernel.json.JSONFactoryUtil;
//import com.liferay.portal.kernel.json.JSONObject;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
//
//import org.osgi.service.component.annotations.Component;
//
//import javax.portlet.PortletException;
//import javax.portlet.ResourceRequest;
//import javax.portlet.ResourceResponse;
//
//import java.io.PrintWriter;
//import java.util.List;
//
//
//@Component(
//property = {
//    "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
//    "mvc.command.name=getFoos"
//},
//service = MVCResourceCommand.class
//)
//	public class GetFoosResourceCommand implements MVCResourceCommand {
//	    @Override
//	    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
//	            throws PortletException {
//
//	        try {
//	            List<Foo> foos = FooLocalServiceUtil.getFoos(-1, -1);
//
//	            JSONArray fooArray = JSONFactoryUtil.createJSONArray();
//
//	            for (Foo foo : foos) {
//	                JSONObject fooJSON = JSONFactoryUtil.createJSONObject();
//	                fooJSON.put("fooId", foo.getFooId());
//	                fooJSON.put("userName", foo.getUserName());
//	                fooJSON.put("groupId", foo.getGroupId());
//	                fooJSON.put("companyId", foo.getCompanyId());
//	                fooJSON.put("userId", foo.getUserId());
//	                fooJSON.put("createDate", String.valueOf(foo.getCreateDate()));
//	                fooJSON.put("modifiedDate", String.valueOf(foo.getModifiedDate()));
//	                fooArray.put(fooJSON);
//	            }
//
//	            JSONObject responseJSON = JSONFactoryUtil.createJSONObject();
//	            responseJSON.put("foos", fooArray);
//
//	            resourceResponse.setContentType("application/json");
//	            PrintWriter out = resourceResponse.getWriter();
//	            out.print(responseJSON.toString());
//	            out.flush();
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            throw new PortletException(e);
//	        }
//
//	        return true;
//	    }
//	}



package com.ats.BookManagement.portlet;

import com.ats.BookManagement.constants.BookManagementPortletKeys;
import com.ats.books.model.Foo;
import com.ats.books.service.FooLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@Component(
    property = {
        "javax.portlet.name=" + BookManagementPortletKeys.BOOKMANAGEMENT,
        "mvc.command.name=getFoos"
    },
    service = MVCResourceCommand.class
)
public class GetFoosResourceCommand implements MVCResourceCommand {

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException {

        try {
            String sortColumn = ParamUtil.getString(resourceRequest, "sortColumn", "fooId");
            String sortDir = ParamUtil.getString(resourceRequest, "sortDir", "asc");

            System.out.println("SortColumn: " + sortColumn + ", Direction: " + sortDir);

          
            List<String> validColumns = Arrays.asList(
                "fooId", "userName", "groupId", "companyId", "userId", "createDate", "modifiedDate"
            );

            DynamicQuery query = FooLocalServiceUtil.dynamicQuery();

            if (validColumns.contains(sortColumn)) {
                if ("desc".equalsIgnoreCase(sortDir)) {
                    query.addOrder(OrderFactoryUtil.desc(sortColumn));
                } else {
                    query.addOrder(OrderFactoryUtil.asc(sortColumn));
                }
            } else {
               
                query.addOrder(OrderFactoryUtil.asc("fooId"));
            }

            List<Foo> foos = FooLocalServiceUtil.dynamicQuery(query);

            JSONArray fooArray = JSONFactoryUtil.createJSONArray();

            for (Foo foo : foos) {
                JSONObject fooJSON = JSONFactoryUtil.createJSONObject();
                fooJSON.put("fooId", foo.getFooId());
                fooJSON.put("userName", foo.getUserName());
                fooJSON.put("groupId", foo.getGroupId());
                fooJSON.put("companyId", foo.getCompanyId());
                fooJSON.put("userId", foo.getUserId());
                fooJSON.put("createDate", String.valueOf(foo.getCreateDate()));
                fooJSON.put("modifiedDate", String.valueOf(foo.getModifiedDate()));
                fooArray.put(fooJSON);
            }

            JSONObject responseJSON = JSONFactoryUtil.createJSONObject();
            responseJSON.put("foos", fooArray);

            resourceResponse.setContentType("application/json");
            PrintWriter out = resourceResponse.getWriter();
            out.print(responseJSON.toString());
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
            throw new PortletException("Error fetching Foo data", e);
        }

        return true;
    }
}

