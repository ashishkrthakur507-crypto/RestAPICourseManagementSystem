package com.ashish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.entity.Course;
import com.ashish.service.ICourseMgmtService;

@RestController
public class CourseController {

	@Autowired
	private ICourseMgmtService courseService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCourseData(@RequestBody Course course){
		String course2 = courseService.addCourse(course);
		return new ResponseEntity<String>(course2,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Course>> getAllCourseData(){
		List<Course> allCourse = courseService.getAllCourse();
		return new ResponseEntity<List<Course>>(allCourse,HttpStatus.OK);
	}
	
	@GetMapping("/get/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable Integer courseId){
		Course course = courseService.getCourse(courseId);
		return new ResponseEntity<Course>(course,HttpStatus.FOUND);
	}
	
	@PutMapping("/update/{courseId}")
	public ResponseEntity<Course> updateCourse( @PathVariable Integer courseId ,@RequestBody Course course){
		Course updateCourse = courseService.updateCourse(courseId, course);
		return new ResponseEntity<Course>(updateCourse,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<String> deleteCourseById(@PathVariable Integer courseId){
		courseService.deleteCourse(courseId);
		return new ResponseEntity<String>(courseId+" Course is Deleted Successfully...",HttpStatus.OK);
	}
}
