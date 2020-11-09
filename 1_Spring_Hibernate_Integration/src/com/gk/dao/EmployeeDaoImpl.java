package com.gk.dao;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.gk.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	String status = "";
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	@Override
	public String insert(Employee employee) {
		try {
			//It will return the id.
			int empId = (Integer) hibernateTemplate.save(employee);
			if (empId == employee.getEmpId()) {
				status = "Employee Insertion Success";
			} else {
				status = "Employee Insertion Failure";
			}
		} catch (Exception e) {
			status = "Employee Insertion Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Transactional
	@Override
	public Employee getEmployee(int empId) {
		Employee employee = null;
		try {
			employee = (Employee)hibernateTemplate.get(Employee.class, empId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Transactional
	@Override
	public String update(Employee employee) {
		try {
			Employee emp=getEmployee(employee.getEmpId());
			if(emp==null) {
				System.out.println("Employee Not Existed");
			}else {
				//Remove the given object from the Session cache.
				hibernateTemplate.evict(emp);
				hibernateTemplate.update(employee);
				status="Employee Updated Successfully";
			}
		} catch (Exception e) {
			status="Employee Updation Failed";
			e.printStackTrace();
		}
		return status;
	}

	@Transactional
	@Override
	public String delete(Employee employee) {
		try {
			Employee emp=getEmployee(employee.getEmpId());
			if(emp==null) {
				System.out.println("Employee Not Existed");
			}else {
				//Remove the given object from the Session cache.
				hibernateTemplate.evict(emp);
				hibernateTemplate.delete(employee);
				status="Employee Deleted Successfully";
			}
		} catch (Exception e) {
			status="Employee Deletion Failed";
			e.printStackTrace();
		}
		return status;
	}

}
