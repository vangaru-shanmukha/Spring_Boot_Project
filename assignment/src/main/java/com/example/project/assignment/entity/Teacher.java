package com.example.project.assignment.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.project.assignment.validator.ValidEmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

	@Id
	@Column(name = "email")
	@ValidEmail
	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "belongsto", joinColumns = @JoinColumn(name = "email"), inverseJoinColumns = @JoinColumn(name = "department_id"))
	private List<Department> departments;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "teaches", joinColumns = @JoinColumn(name = "email"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	@Column(name = "house_number")
	private String houseNumber;

	@Column(name = "street")
	private String street;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "zipcode")
	private Address address;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	public void addDepartment(Department theDepartment) {

		if (departments == null) {
			departments = new ArrayList<Department>();
		}
		departments.add(theDepartment);
		theDepartment.addTeacher(this);
	}

	public void addCourse(Course theCourse) {

		if (courses == null) {
			courses = new ArrayList<Course>();
		}
		courses.add(theCourse);
		theCourse.addTeacher(this);
	}
}
