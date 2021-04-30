package com.ar.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ar.dao.DB;
import com.ar.vo.Employee;

public class DBOperation {

	public static void main(String[] args) throws Exception {

		Scanner xyz= new Scanner(System.in);
		
		DB db=new DB();
		db.Connection();
		System.out.println("=============================================================");
		System.out.println("Select Any Number from the Following");
		System.out.println("ENTER 1: Insert Operation");
		System.out.println("ENTER 2: Delete Operation");
		System.out.println("ENTER 3: Update Operation");
		System.out.println("ENTER 4: Select Operation");
		System.out.println("ENTER 5: Retrive All Record");
		System.out.println("=============================================================");
		System.out.println("Enter YOur Choice");
		int choice=xyz.nextInt();
		int count=0;
		boolean b;
		
		switch(choice)
		{
		case 1:
			System.out.println("INSERT Command");
			Employee emp= new Employee();
			//emp.setId('0');
			emp.setName("RAJA");
			emp.setSalary("10000");
			emp.setContact("9960747450");
			emp.setEmail("RAJA@GMAIL.COM");
			b=db.insert(emp);
			if(b)
				System.out.println("Record Inserted");
			else
				System.out.println("Record Not Inserted");
			break;
		case 2:
			System.out.println("Delete Command");
			Employee emp1= new Employee();
			emp1.setEmail("anup@gmail.com");
			b=db.delete(emp1);
			if(b)
				System.out.println("Record Deleted");
			else
				System.out.println("Record Not Deleted");
			
			break;
		case 3:
			System.out.println("Update Command");
			Employee emp2= new Employee();
			emp2.setEmail("radhika@gmail.com");
			emp2.setSalary("112233");
			b=db.update(emp2);
			if(b)
				System.out.println("Record updated");
			else
				System.out.println("Record Not updated");
			break;
		case 4:
			System.out.println("Select Command");
			Employee emp3= new Employee();
			emp3.setEmail("radhika@gmail.com");
			count=(int) db.select(emp3);
			if (count>0)
				System.out.println("Record Selected"+count);
			else
				System.out.println("No Record Selected");
			break;	
			
		case 5:
			System.out.println("Retrive all Data");
			
			List<Employee> lst = new ArrayList<Employee>();
			Employee emp4= new Employee();
			lst =db.retriveAllRecord(emp4);
			
			System.out.println("=========================================================");
			System.out.println("ID"+"\t"+"NAME"+"\t" +"EMAIL" +"\t"+"CONTACT"+"\t"+"SALARY");
			System.out.println("=========================================================");
			for (Employee s : lst) 
		        {
				 ++count;
				 System.out.println(s.getId() +"\t"+ s.getName() +"\t"+ s.getEmail()+ "\t" +s.getContact()+"\t"+s.getSalary());
		        }
			
		 System.out.printf("Total %d Record Retrived", count);
			break;
			
		default:
			System.out.println("=============================================================");
			System.out.print("Wrong key Pressed,please enter the correct key\n");
			System.out.println("Try again...!!!");
			System.out.println("=============================================================");
		}

	}

}
