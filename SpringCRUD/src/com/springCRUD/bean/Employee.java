package com.springCRUD.bean;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private int id;
	private String Department;
	private String fullName;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String department, String fullName) {
		super();
		this.id = id;
		Department = department;
		this.fullName = fullName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", Department=" + Department + ", fullName=" + fullName + "]";
	}
	
	
	
	
	
}
