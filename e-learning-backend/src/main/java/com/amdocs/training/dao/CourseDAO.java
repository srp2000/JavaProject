package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.model.Course;

public interface CourseDAO {
	boolean saveCourse(Course course);
	List<Course> viewCourse();
	int deleteCourse(int a);
	int updateCourseFee(String a,double b,String c,String d,int e);
	
}
