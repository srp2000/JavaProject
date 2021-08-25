package com.amdocs.training.client;

import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.dao.CourseDAO;
import com.amdocs.training.dao.impl.CourseDAOImpl;
import com.amdocs.training.model.Course;

public class CourseClient {

	public static void main(String[] args) {
		List<Course> courses=new ArrayList<>();
		CourseDAO dao = new CourseDAOImpl();
		
		Course course = new Course(3001, "Design Patterns", 3500, "GOF and Sun Design Patterns", "video.mp4");
//		if(dao.saveCourse(course)) {
//			System.out.println("Course Added Successfully");
//			}
//			else {
//			System.out.println("Error Cannot Insert");
//			}
//	}
		courses=dao.viewCourse();
		courses.forEach((n)->System.out.println(n));
		}
}
