package com.ar.vo;

public class Employee {
private int id;
private String name;
private String email;
private String contact;
private String salary;

//getter & setter Method
/*
 * public Employee() {
 * 
 * } public Employee(int id, String name,String email, String contact, String
 * salary ) {
 * 
 * this.id=id; this.name=name; this.email=email; this.contact=contact;
 * this.salary=salary; }
 */
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}



}
