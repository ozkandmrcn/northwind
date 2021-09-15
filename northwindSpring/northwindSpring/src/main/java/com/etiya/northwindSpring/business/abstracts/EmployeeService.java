package com.etiya.northwindSpring.business.abstracts;

import java.util.List;

import com.etiya.northwindSpring.core.utilities.results.DataResult;
import com.etiya.northwindSpring.entities.concretes.Employee;

public interface EmployeeService  {
	
	 DataResult<List<Employee>> getAll();

}
