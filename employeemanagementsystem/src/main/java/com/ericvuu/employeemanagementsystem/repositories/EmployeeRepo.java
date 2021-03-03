package com.ericvuu.employeemanagementsystem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ericvuu.employeemanagementsystem.models.Employee;


@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long>{
	
	List<Employee>findAll();
	
	Employee findEmployeeById(Long employeeId);
	
	Employee findByEmail(String email);
}
