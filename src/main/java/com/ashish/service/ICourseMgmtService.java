package com.ashish.service;

import java.util.List;

import com.ashish.entity.Course;

public interface ICourseMgmtService {

	public String addCourse(Course course);
	public Course getCourse(Integer id);
	public List<Course> getAllCourse();
	public Course updateCourse(Integer id,Course course);
	public void deleteCourse(Integer id);
}
