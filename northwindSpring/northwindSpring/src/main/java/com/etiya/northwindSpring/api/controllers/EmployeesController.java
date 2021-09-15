package com.etiya.northwindSpring.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwindSpring.business.abstracts.EmployeeService;
import com.etiya.northwindSpring.core.utilities.results.DataResult;
import com.etiya.northwindSpring.entities.concretes.Employee;

@RestController 
@RequestMapping("/api/employees")
public class EmployeesController {
	
	
	private EmployeeService employeeService;
	
	@Autowired

	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	

	@GetMapping("/getall")
	public DataResult< List<Employee>> getall()
	{
	
		return this.employeeService.getAll();
		
		
	}
	
	

}
