/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package kaleoservice.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Date;

import kaleoservice.model.Foo;
import kaleoservice.service.base.FooLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=kaleoservice.model.Foo",
	service = AopService.class
)
public class FooLocalServiceImpl extends FooLocalServiceBaseImpl {
	

	public Foo updateStatus(long userId, long fooId, int status, ServiceContext serviceContext)
			throws PortalException {

		Foo foo = getFoo(fooId);

		foo.setStatus(status);
		foo.setModifiedDate(new Date());

		foo = updateFoo(foo);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateVisible(Foo.class.getName(), fooId, true);
		} else {
			assetEntryLocalService.updateVisible(Foo.class.getName(), fooId, false);
		}

		return foo;
	}

}