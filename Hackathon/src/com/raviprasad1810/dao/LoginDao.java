package com.raviprasad1810.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.raviprasad1810.entities.Pizza_customers;
import com.raviprasad1810.utils.Dbutil;

public class LoginDao  implements AutoCloseable{
	private Connection connection;
	public LoginDao() throws SQLException {
		connection = Dbutil.getConnection();
	}
	
	
	public void addCustomer(Scanner sc)  {
		Pizza_customers s=new Pizza_customers();
		s.accept(sc);
		String sql="insert into pizza_customers(Name,Password,Mobile,Address,Email)values(?,?,?,?,?)";
		try(PreparedStatement ps=connection.prepareStatement(sql)){
			ps.setString(1, s.getName());
			ps.setString(2, s.getPassword());
			ps.setString(3, s.getMobile());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getEmail());
			if(ps.executeUpdate()!=0) {
				System.out.println("sucessfully inserted");
			}
			else
			{
				System.out.println("unsucessful attempt");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
//	public boolean checkCustomer(String e,String p) {
//		int a=0;
//			try(PreparedStatement ps=connection.prepareStatement("select Email,Password,Name from pizza_customers")){
//				ResultSet rs=ps.executeQuery();
//				while(rs.next()) {
//					String email=rs.getString(1);
//					String password=rs.getString(2);
//					String name=rs.getString(3);
//					if(e.equals(email) && p.equals(password)){
//					System.out.println("welcome "+name);
//					a=1;
//					return true;
//					}
//				}
//			if(a==0){
//			System.out.println("Customer not existing!please Register");
//			return false;
//			}
//
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			return false;
//			}
	public int checkCustomer(String e,String p)  {
		int a=0,id=0;
			try(PreparedStatement ps=connection.prepareStatement("select Email,Password,Name,ID from pizza_customers")){
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					String email=rs.getString(1);
					String password=rs.getString(2);
					String name=rs.getString(3);
					id=rs.getInt(4);
					if(e.equals(email) && p.equals(password)){
					System.out.println("welcome "+name);
					a=1;
					break;
			}
				}
			if(a==0){
			System.out.println("Customer not existing!please Register");
			return 0;
			}} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			return id;
		
	}
	public  boolean checkAdmin(String email,String pass) {
		if(email.equals("admin@sunbeaminfo.com") && pass.equals("admin"))
			return true;
		return false;
	}

	@Override
	public void close() throws SQLException {
		if (connection != null)
			connection.close();
	}

}
