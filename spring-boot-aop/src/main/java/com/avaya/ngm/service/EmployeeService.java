package com.avaya.ngm.service;

import org.springframework.stereotype.Service;

import com.avaya.ngm.model.Employee;

@Service
public class EmployeeService {

	public Employee createEmployee(String name, String empId) {

		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmpId(empId);
		return emp;
	}

	public void deleteEmployee(String empId) {
		
	}
}