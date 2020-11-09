package com.gk.dao;

import com.gk.dto.Employee;

public interface EmployeeDao {

	public String insertEmployee(Employee employee);

	public Employee getEmployee(int empId);

	public String updateEmployee(Employee employee);

	public String deleteEmployee(int empId);
}
