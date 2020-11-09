package com.gk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gk.dao.EmployeeDao;
import com.gk.dto.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/gk/resources/applicationContext.xml");
		EmployeeDao employeeDao = (EmployeeDao) context.getBean("empDao");
		
		Employee employee = new Employee();

		employee.setEmpId(1);
		employee.setEmpName("Pranay Singh");
		employee.setEmpSalary(1000f);
		employee.setEmpAddr("Indore");
		String status = employeeDao.insertEmployee(employee);
		System.out.println(status);

		Employee employee1 = employeeDao.getEmployee(1);
		if (employee1 == null) {
			System.out.println("Employee Not Existed");
		} else {
			System.out.println("Employee Details");
			System.out.println("Employee Id: " + employee1.getEmpId());
			System.out.println("Employee Name: " + employee1.getEmpName());
			System.out.println("Employee Salary: " + employee1.getEmpSalary());
			System.out.println("Employee Address: " + employee1.getEmpAddr());
		}
		
		Employee employee2=new Employee();
		employee2.setEmpId(1);
		employee2.setEmpName("Apoorva Singh");
		employee2.setEmpSalary(2000f);
		employee2.setEmpAddr("Delhi");
		String status1=employeeDao.updateEmployee(employee2);
		System.out.println(status1);
		
		Employee employee3=employeeDao.getEmployee(1);
		String status2=employeeDao.deleteEmployee(employee3.getEmpId());
		System.out.println(status2);
	}

}
