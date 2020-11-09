package com.gk.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gk.dto.Employee;

@Repository(value = "employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	String status = "";

	//It will inject EntityManager Obj. into DaoImpl class.
	@PersistenceContext
	private EntityManager manager;

	//It will inject transactional Service in Dao method.It is not required to create EntityTransaction Obj. and not require to perform Commit and RollBack operations. 
	@Transactional
	@Override
	public String insertEmployee(Employee employee) {
		try {
			manager.persist(employee);
			status = "Success";
		} catch (Exception e) {
			status = "Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee getEmployee(int empId) {
		Employee employee = (Employee) manager.find(Employee.class, empId);
		return employee;
	}

	@Transactional
	@Override
	public String updateEmployee(Employee employee) {
		try {
			Employee emp = (Employee) manager.find(Employee.class, employee.getEmpId());
			emp.setEmpName(employee.getEmpName());
			emp.setEmpSalary(employee.getEmpSalary());
			emp.setEmpAddr(employee.getEmpAddr());
			status = "Success";
		} catch (Exception e) {
			status = "Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Transactional
	@Override
	public String deleteEmployee(int empId) {
		try {
			Employee employee = (Employee) manager.find(Employee.class, empId);
			manager.remove(employee);
			status = "Success";
		} catch (Exception e) {
			status = "Failure";
			e.printStackTrace();
		}
		return status;
	}

}
