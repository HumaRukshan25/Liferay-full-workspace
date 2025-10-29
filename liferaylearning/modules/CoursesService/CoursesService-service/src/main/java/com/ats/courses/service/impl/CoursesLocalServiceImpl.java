/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.courses.service.impl;

import com.ats.courses.exception.NoSuchCoursesException;
import com.ats.courses.model.Courses;
import com.ats.courses.service.base.CoursesLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Base64;
import java.util.Date;
import java.util.List;


import org.osgi.service.component.annotations.Component;



/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.ats.courses.model.Courses", service = AopService.class)
public class CoursesLocalServiceImpl extends CoursesLocalServiceBaseImpl {

	@Override
	public Courses addCourses(String Courses_name, String Courses_des, String Courses_type, String Courses_rating,
			InputStream Courses_imgStream) {
		System.out.println("Service Coursesadd Method inside :::");
		long coursesId = counterLocalService.increment(Courses.class.getName());
		Courses objCourses = coursesPersistence.create(coursesId);
		try {
			objCourses.setCourses_name(Courses_name);
			objCourses.setCourses_des(Courses_des);
			objCourses.setCourses_type(Courses_type);
			objCourses.setCourses_rating(Courses_rating);
			objCourses.setCreateDate(new Date());

			String CoursesImgBase64;
			CoursesImgBase64 = convertImageToBase64(Courses_imgStream);
			objCourses.setCourses_img(CoursesImgBase64);

			System.out.println("Courses Name 	   ::" + Courses_name);
			System.out.println("Courses des  	   ::" + Courses_des);
			System.out.println("Courses type 	   ::" + Courses_type);
			System.out.println("Courses rating     ::" + Courses_rating);
			System.out.println("Courses imgStream  ::" + Courses_imgStream);
			coursesLocalService.addCourses(objCourses);
			return super.addCourses(objCourses);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objCourses;

	}

	
	public String convertImageToBase64(InputStream inputStream) throws java.io.IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int bytesRead;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		byte[] imageBytes = outputStream.toByteArray();
		return Base64.getEncoder().encodeToString(imageBytes);
	}

	@Override
	public Courses deleteCourses(long coursesId) throws NoSuchCoursesException {
		Courses deleteCourses = coursesPersistence.findByPrimaryKey(coursesId);
		return super.deleteCourses(deleteCourses);
	}
	

	@Override
	public Courses updateCourses(long coursesId, String Courses_name, String Courses_des, String Courses_type,
			String Courses_rating, InputStream Courses_imgStream) throws PortalException {

		Courses objCourses = coursesPersistence.findByPrimaryKey(coursesId);

		objCourses.setCourses_name(Courses_name);
		objCourses.setCourses_des(Courses_des);
		objCourses.setCourses_type(Courses_type);
		objCourses.setCourses_rating(Courses_rating);
		objCourses.setModifiedDate(new Date());

		if (Courses_imgStream != null) {
			String coursesPhotoBase64;
			try {
				coursesPhotoBase64 = convertImageToBase64(Courses_imgStream);
				objCourses.setCourses_img(coursesPhotoBase64);
			} catch (IOException e) {
				throw new PortalException("Error processing the product photo", e);
			}
		}
		objCourses = coursesPersistence.update(objCourses);

		return super.updateCourses(objCourses);
	}

	 // custom sql
		public List<Courses> GetAllCoursesTypes(String Courses_type) {
			return coursesFinder.GetAllCoursesTypes(Courses_type);
		}
	
		
		
		
		//-------for kaleo workflow  to get status------
		
//		public Courses updateStatus(
//		        long userId, long coursesId, int status, ServiceContext serviceContext)
//		    throws PortalException {
//
//		    Courses courses = getCourses(coursesId);
//
//		    courses.setStatus(status);
//		    courses.setModifiedDate(new Date());
//
//		    courses = updateCourses(courses);
//
//		    if (status == WorkflowConstants.STATUS_APPROVED) {
//		        assetEntryLocalService.updateVisible(
//		            Courses.class.getName(), coursesId, true);
//		    } else {
//		        assetEntryLocalService.updateVisible(
//		            Courses.class.getName(), coursesId, false);
//		    }
//
//		    System.out.println("Current Status for Course ID " + coursesId + " => " + status);
//
//		    return courses;
//		}
		
		
		public Courses updateStatus(
		        long userId, long coursesId, int status, ServiceContext serviceContext)
		    throws PortalException {

		    Courses course = getCourses(coursesId);
		    
		    User user = userLocalService.getUser(userId);
		    course.setStatus(status);
		   

		    course = updateCourses(course);

		    // Update asset visibility based on status
		    if (status == WorkflowConstants.STATUS_APPROVED) {
		        assetEntryLocalService.updateVisible(
		            Courses.class.getName(), coursesId, true);
		    }
		    else {
		        assetEntryLocalService.updateVisible(
		            Courses.class.getName(), coursesId, false);
		    }

		    // Reindex the course
		    Indexer<Courses> indexer = IndexerRegistryUtil.getIndexer(Courses.class);
		    if (indexer != null) {
		        indexer.reindex(course);
		    }

		    return course;
		}

		@Override
		public Courses updateStatus(long courseId, int status) {
		    try {
		        Courses courses = getCourses(courseId);

		        courses.setStatus(status);
		        courses.setModifiedDate(new Date());

		        boolean visible = (status == WorkflowConstants.STATUS_APPROVED);
		        assetEntryLocalService.updateVisible(Courses.class.getName(), courseId, visible);
		      

		        return updateCourses(courses);
		    } catch (PortalException e) {
		    	
		        e.printStackTrace();
		        return null; // or handle the exception as per your app logic
		    }
		}	
		
		
}



