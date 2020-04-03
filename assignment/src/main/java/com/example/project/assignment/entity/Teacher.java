package com.example.project.assignment.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message = "is required")
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "belongsto", joinColumns = @JoinColumn(name = "email"), inverseJoinColumns = @JoinColumn(name = "department_id"))
	private List<Department> departments;

	@NotNull(message = "is required")
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "teaches", joinColumns = @JoinColumn(name = "email"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "house_number")
	private String houseNumber;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "street")
	private String street;

	@NotNull(message = "is required")
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "zipcode")
	private Address address;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "date_of_birth")
	private String dateOfBirth;

}
