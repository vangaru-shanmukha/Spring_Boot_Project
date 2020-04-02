package com.example.project.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.assignment.dao.DepartmentRepository;
import com.example.project.assignment.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	DepartmentRepository departmentRepository;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository theDepartmentRepository) {
		departmentRepository = theDepartmentRepository;
	}
	
	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Department findById(int theDepartmentId) {
		Optional<Department> result = departmentRepository.findById(theDepartmentId);
		Department theDepartment = null;
		if(result.isPresent()) {
			theDepartment = result.get();
		}
		else {
			throw new RuntimeException("Did not find department with code : " + theDepartmentId);
		}
		return theDepartment;
	}

	@Override
	public void save(Department theDepartment) {
		departmentRepository.save(theDepartment);

	}

	@Override
	public void deleteById(int theDepartmentId) {
		departmentRepository.deleteById(theDepartmentId);

	}

}
