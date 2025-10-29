package com.lib.myfirst.portlet;

import com.lib.myfirst.constants.MyfirstprojectPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;


@Component(
		property = {
			"javax.portlet.name=" + MyfirstprojectPortletKeys.MYFIRSTPROJECT,
			"mvc.command.name=/myfirst/addData"
		},
		service = MVCActionCommand.class
	)
	public class AddDataActionCommand implements MVCActionCommand {

		@Override
		public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

			String firstName = ParamUtil.getString(actionRequest, "firstName");
			String email = ParamUtil.getString(actionRequest, "email");

			System.out.println("First Name: " + firstName);
			System.out.println("Email: " + email);

			return true;
		}
	}
