package com.springCRUD.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springCRUD.bean.Employee;
import com.springCRUD.dao.EmployeeDao;

public class TestApp {
	
	static ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	static EmployeeDao dao=(EmployeeDao) context.getBean("employeeDao");
	
	
	
	public void nameById() {
			String name=dao.getNameById(1);
		
		System.out.println(name);
	}
	
	public void cntEmp() {
		
		int cnt=dao.countEmpoyee();
		
		System.out.println(cnt);
	}
	
	public void saveEmp() {
		
		Employee e=new Employee(3, "HR", "Shivanand Patil");
		
		int cnt=dao.save(e);
		
		System.out.println(cnt+"  recors saved");
		
	}
	
	public void updateemp() {
		
		
		
		Employee e=new Employee(1, "IT", "Manoj D. Ilake");
		
		int cnt=dao.updateEmployee(e);
		
		System.out.println(cnt+" record updated");
		
	}

	public void deleteEmp() {
		
		int cnt=dao.deleteEmployee(1);
		
		System.out.println(cnt+" record deleted");
		
	}
	
	public void listOfEmp() {
		
		List<Employee> emp=dao.allEmployee();
		
		for (Employee e : emp) {
			
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		

		TestApp ta=new TestApp();
		
		//ta.nameById();
		
		//ta.cntEmp();
		
		//ta.saveEmp();
		
		//ta.updateemp();
		
		//ta.deleteEmp();
		
		ta.listOfEmp();
	}

}
