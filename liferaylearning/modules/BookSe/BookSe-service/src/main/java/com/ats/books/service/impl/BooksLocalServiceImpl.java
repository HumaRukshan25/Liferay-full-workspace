/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.service.impl;



import com.ats.books.service.base.BooksLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ats.books.model.Books",
	service = AopService.class
)
public class BooksLocalServiceImpl extends BooksLocalServiceBaseImpl {

	/**
	 * Custom finder method to get books by author name using custom SQL.
	 */


}