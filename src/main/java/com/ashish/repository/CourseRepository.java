package com.ashish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
