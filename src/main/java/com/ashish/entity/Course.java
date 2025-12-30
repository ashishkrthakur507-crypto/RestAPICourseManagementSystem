package com.ashish.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="COURSE_API")
@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	@NonNull
	@Column(length = 30)
	private String title;
	@NonNull
	@Column(length = 30)
	private String instruction;
	@NonNull
	private Integer duration;
	@NonNull
	private Double fees;
	
	

}
