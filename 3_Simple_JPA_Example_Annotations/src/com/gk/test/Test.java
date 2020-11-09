package com.gk.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.gk.dto.Employee;

public class Test {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setEmpName("Pranay Singh");
		employee.setEmpSalary(100000f);
		employee.setEmpAddr("Indore");
		EntityTransaction transaction1 = manager.getTransaction();
		transaction1.begin();
		manager.persist(employee);
		transaction1.commit();
		System.out.println("Employee Inserted Successfully");
		
		Employee emp=manager.find(Employee.class, 1);
		System.out.println(emp.toString());
		EntityTransaction transaction2= manager.getTransaction();
		transaction2.begin();
		emp.setEmpName("Apoorva Singh");
		emp.setEmpSalary(200000f);
		emp.setEmpAddr("Delhi");
		transaction2.commit();
		System.out.println("Employee Updated Successfully");
		
		EntityTransaction transaction3= manager.getTransaction();
		transaction2.begin();
		Employee emp1=manager.find(Employee.class, 1);
		manager.remove(emp1);
		transaction2.commit();
		System.out.println("Employee Deleted Successfully");
		
		
		manager.close();
	}

}
