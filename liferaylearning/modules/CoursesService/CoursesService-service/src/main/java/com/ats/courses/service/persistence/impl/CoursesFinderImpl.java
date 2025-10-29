package com.ats.courses.service.persistence.impl;

import com.ats.courses.model.Courses;
import com.ats.courses.model.impl.CoursesImpl;
import com.ats.courses.service.persistence.CoursesFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = CoursesFinder.class)
public class CoursesFinderImpl extends CoursesFinderBaseImpl implements CoursesFinder {

	@Reference
	private CustomSQL customSQL;

	public List<Courses> GetAllCoursesTypes(String Courses_type) {

		List<Courses> courses = new ArrayList<Courses>();

		Session session = null;
		session = openSession();

		String sql = customSQL.get(getClass(), "GetAllCoursesTypes");
		System.out.println("Sql ============>" + sql);

		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setCacheable(false);

		sqlQuery.addEntity("Courses", CoursesImpl.class);

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);
		queryPos.add(Courses_type + "%");

		courses = sqlQuery.list();

		closeSession(session);
		return courses;
	}

}
