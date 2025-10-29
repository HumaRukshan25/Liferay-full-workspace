/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PracticeService1.service.persistence.impl;

import PracticeService1.model.CheckInOutAppTable;
import PracticeService1.model.impl.CheckInOutAppImpl;
import PracticeService1.model.impl.CheckInOutAppModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from CheckInOutApp.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=PracticeService1.model.impl.CheckInOutAppImpl",
		"table.name=ATS_CheckInOutApp"
	},
	service = ArgumentsResolver.class
)
public class CheckInOutAppModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		CheckInOutAppModelImpl checkInOutAppModelImpl =
			(CheckInOutAppModelImpl)baseModel;

		long columnBitmask = checkInOutAppModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(checkInOutAppModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					checkInOutAppModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(CheckInOutAppPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(checkInOutAppModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return CheckInOutAppImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return CheckInOutAppTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		CheckInOutAppModelImpl checkInOutAppModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = checkInOutAppModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = checkInOutAppModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= CheckInOutAppModelImpl.getColumnBitmask(
			"checkInTime");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}