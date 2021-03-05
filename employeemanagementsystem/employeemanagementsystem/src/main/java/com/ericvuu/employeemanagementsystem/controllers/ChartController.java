package com.ericvuu.employeemanagementsystem.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ericvuu.employeemanagementsystem.models.Department;
import com.ericvuu.employeemanagementsystem.services.DepartmentService;

@RestController
public class ChartController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/charts/department")
	public Map<String, String> getDepartmentDetails(){
		
		HashMap<String, String> map = new HashMap<>();
		List<Department> allDepartments = departmentService.allDepartments();
		
		for(Department d: allDepartments) {
			int size = d.getEmployees().size();
			String str = Integer.toString(size);
			map.put(d.getName(), str);
		}
		
		return map;
	}
}
