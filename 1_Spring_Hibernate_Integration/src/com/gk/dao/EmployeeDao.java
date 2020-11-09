package com.gk.dao;

import com.gk.dto.Employee;

public interface EmployeeDao {

	public String insert(Employee employee);

	public Employee getEmployee(int empId);

	public String update(Employee employee);

	public String delete(Employee employee);
}
