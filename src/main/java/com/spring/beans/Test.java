package com.spring.beans;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("hibernate.xml");
		EmployeeDao empDao = (EmployeeDao) context.getBean("EmployeeDao");
		empDao.saveEmployee(new Employee(1, "dd", 5000));
		//empDao.updateEmployee(new Student(2, "nag", 6000));
		//empDao.deleteEmployee(3);
		
//	List<Employee> list = empDao.getAllEmployee();
//		//System.out.println(employeeDao.getEmployee(1));
//	for(Employee emp : list) {
//		System.out.println(emp);
//		}
		
}


	}


