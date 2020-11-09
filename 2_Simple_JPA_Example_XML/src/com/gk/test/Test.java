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
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
		System.out.println("Employee Inserted Successfully");
	}

}
