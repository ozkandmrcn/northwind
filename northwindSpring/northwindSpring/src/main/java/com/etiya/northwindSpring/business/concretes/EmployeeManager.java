package com.etiya.northwindSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwindSpring.business.abstracts.EmployeeService;
import com.etiya.northwindSpring.core.utilities.results.DataResult;
import com.etiya.northwindSpring.core.utilities.results.SuccessDataResult;
import com.etiya.northwindSpring.dataAccess.abstracts.EmployeeDao;
import com.etiya.northwindSpring.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	
	 private EmployeeDao employeeDao;
	
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}



	@Override
	public DataResult<List<Employee>> getAll() {
	
       List<Employee> employees=this.employeeDao.findAll();
		
		return new SuccessDataResult<List<Employee>>(employees, " Data listelendi.");
	}

}
