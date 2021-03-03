package com.ericvuu.employeemanagementsystem.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ericvuu.employeemanagementsystem.models.Employee;
import com.ericvuu.employeemanagementsystem.services.EmployeeService;


@Component
public class EmployeeValidator implements Validator{
	
	@Autowired
	private EmployeeService employeeService;
	
	@Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        
        if (!employee.getPasswordConfirmation().equals(employee.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        } 
        
        if (employeeService.findByEmail(employee.getEmail()) != null) {
        	errors.rejectValue("email", "Duplicate");
        }
    }
}
