package com.ashish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.RestApiProj01CourseManagementSystemCrudOperationApplication;
import com.ashish.entity.Course;
import com.ashish.error.CustomException;
import com.ashish.repository.CourseRepository;

@Service
public class CourseMgmtServiceImpl implements ICourseMgmtService {

    private final RestApiProj01CourseManagementSystemCrudOperationApplication restApiProj01CourseManagementSystemCrudOperationApplication;

	@Autowired
	private CourseRepository courseRepo;

    CourseMgmtServiceImpl(RestApiProj01CourseManagementSystemCrudOperationApplication restApiProj01CourseManagementSystemCrudOperationApplication) {
        this.restApiProj01CourseManagementSystemCrudOperationApplication = restApiProj01CourseManagementSystemCrudOperationApplication;
    }
	
	@Override
	public String addCourse(Course course) {
		
		System.out.println("CourseMgmtServiceImpl.addCourse()");
		
		if(course.getDuration()>=1 && course.getFees()>=0) {
			Integer courseSavedId = courseRepo.save(course).getCourseId();
			return "Course is saved with id :: "+courseSavedId;
		}else {
			throw new CustomException("Course Duration and Course Fee Must me gratter then 1 Or Equals");
		}
	
		
	}

	@Override
	public Course getCourse(Integer id) {
		Course byId = courseRepo.findById(id).orElseThrow(()-> new CustomException(id+" is not Found!!"));
		
		return byId;
	}

	@Override
	public List<Course> getAllCourse() {
		System.out.println("CourseMgmtServiceImpl.getAllCourse()");
		List<Course> listOfAllCourse = courseRepo.findAll();
		if(listOfAllCourse.isEmpty()) {
			throw new CustomException("No Course Found in the DataBase! !");
		}
		return listOfAllCourse;
	}

	@Override
	public Course updateCourse(Integer id, Course course) {
		System.out.println("CourseMgmtServiceImpl.updateCourse()");
		Course oldCourse = courseRepo.findById(id).orElseThrow(()-> new CustomException(id+" Course is not Found!!"));
		if(course.getDuration()<1 || course.getFees()<1) {
			throw new CustomException("Course Duration and Fee must be >=1");
		}
		oldCourse.setTitle(course.getTitle());
		oldCourse.setInstruction(course.getInstruction());
		oldCourse.setDuration(course.getDuration());
		oldCourse.setFees(course.getFees());
		Course newCourseId = courseRepo.save(oldCourse);
		return newCourseId;
	}

	@Override
	public void deleteCourse(Integer id) {
		System.out.println("CourseMgmtServiceImpl.deleteCourse()");
		Course courses = courseRepo.findById(id).orElseThrow(()-> new CustomException(id+" Course is not Found!!"));
		courseRepo.deleteById(id);
		
	}

	
}
