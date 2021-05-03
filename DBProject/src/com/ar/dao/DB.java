package com.ar.dao;

import com.ar.vo.*;
import com.ar.vo.*;

import java.sql.*;
import java.util.*;

public class DB {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private int val;

	Employee emp = new Employee();
	public void Connection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
		System.out.println("Connection Established");
	}

	public boolean insert(Employee emp) {
		try {
			psmt = conn.prepareStatement("insert into Emp1 values('0',?,?,?,?)");
			
			psmt.setString(1, emp.getName());
			psmt.setString(2, emp.getEmail());
			psmt.setString(3, emp.getContact());
			psmt.setString(4, emp.getSalary());
			
			val = psmt.executeUpdate();
		    } 
		catch (Exception e) 
	     	{
			System.out.println("Something not Right Here");
		    }
		if (val > 0)
			return true;
		else
			return false;
	}

	
	  public boolean delete(Employee emp) throws SQLException 
	  { 
		  psmt = conn.prepareStatement("delete from Emp1 where Email=?");
		  psmt.setString(1, emp.getEmail());
		  val = psmt.executeUpdate();
		  
		  if (val > 0)
				return true;
			else
				return false;
		  
	  }
	  
	  public boolean update(Employee emp) throws SQLException 
	  { 
		  psmt = conn.prepareStatement("update Emp1 set salary= ? where Email= ?");
		  
		  psmt.setString(1, emp.getSalary());
		  psmt.setString(2, emp.getEmail());
		  val = psmt.executeUpdate();		  
		  if (val > 0)
				return true;
			else
				return false;
		  }
	  
	 public int select(Employee emp) throws Exception
	 { 
		 int count=0;
		 psmt = conn.prepareStatement("select * from Emp1 where Email=?");
		 psmt.setString(1, emp.getEmail());
		 ResultSet rs=psmt.executeQuery();
		 while(rs.next())
		 {
			 ++count;
		 System.out.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getString(3)+ "\t" +rs.getString(4)+"\t"+rs.getString(5));
		 }
		 return count;
	 }

	 public List<Employee> retriveAllRecord(Employee emp) throws Exception
	 {
		 List<Employee> list = new ArrayList<Employee>();
		 psmt = conn.prepareStatement("select * from Emp1");
		 ResultSet rs=psmt.executeQuery();
		 
		 while(rs.next())
		 {
			// System.out.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getString(3)+ "\t" +rs.getString(4)+"\t"+rs.getString(5));
		 Employee Emp= new Employee();
		 
		 Emp.setId(rs.getInt(1));
		 Emp.setName(rs.getString(2));
		 Emp.setEmail(rs.getString(3));
		 Emp.setContact(rs.getString(4));
		 Emp.setSalary(rs.getString(5));
		 
		 		// list.add(new Employee());
			 list.add(Emp);
			 
		 }
		return list;
			 
	 }

	
	}
	 

