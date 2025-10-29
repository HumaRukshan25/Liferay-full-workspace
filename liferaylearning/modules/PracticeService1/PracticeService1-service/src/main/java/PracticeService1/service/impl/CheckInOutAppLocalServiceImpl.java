/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.service.impl;

import PracticeService1.service.base.CheckInOutAppLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=PracticeService1.model.CheckInOutApp",
	service = AopService.class
)
public class CheckInOutAppLocalServiceImpl
	extends CheckInOutAppLocalServiceBaseImpl {
}