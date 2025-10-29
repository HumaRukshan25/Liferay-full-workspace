package com.lib.myfirst.portlet;

import com.lib.myfirst.constants.MyfirstprojectPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;


@Component(
		property = {
			"javax.portlet.name=" + MyfirstprojectPortletKeys.MYFIRSTPROJECT,
			"mvc.command.name=/myfirst/addData"
		},
		service = MVCRenderCommand.class
	)
	public class AddDataMVCRenderCommand implements MVCRenderCommand {

		@Override
		public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
			return "/addData.jsp";
		}
	}
