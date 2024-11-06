package com.raviprasad1810.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.raviprasad1810.entities.Pizza_pricing;
import com.raviprasad1810.utils.Dbutil;


public class MenuDao implements AutoCloseable{
	
	private Connection connection;
	public MenuDao() throws SQLException {
		connection = Dbutil.getConnection();
	}
	
	List<Pizza_pricing> cart=new ArrayList<Pizza_pricing>();
	public void addCart() throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter pizza id you want");
		int a=sc.nextInt();
		try(PreparedStatement ps=connection.prepareStatement("select id,sizes,price from pizza_pricing where id=?")){
			ps.setInt(1, a);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String size=rs.getString(2);
				double price=rs.getDouble(3);
				Pizza_pricing p1=new Pizza_pricing(id,size,price);
				cart.add(p1);
		}
		}
	}
	
	public void VegPizza() throws SQLException {
		try(PreparedStatement ps=connection.prepareStatement("select * from PIZZA_ITEMS")){
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String pizza_name=rs.getString(2);
				String type=rs.getString(3);
				String category=rs.getString(4);
				String toppings=rs.getString(5);
				if(type.equals("Veg")) {
				System.out.println(id+" "+pizza_name+" "+type+" "+category+" "+toppings);
				}
		}
		}
	}
	public void NonVegPizza() throws SQLException {
		try(PreparedStatement ps=connection.prepareStatement("select * from PIZZA_ITEMS")){
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String pizza_name=rs.getString(2);
				String type=rs.getString(3);
				String category=rs.getString(4);
				String toppings=rs.getString(5);
				if(type.equals("NonVeg")) {
				System.out.println(id+" "+pizza_name+" "+type+" "+category+" "+toppings);
				}
		}
		}
		}
	
	public void pizza_sizes() throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter pizza id you want");
		int a=sc.nextInt();
		try(PreparedStatement ps=connection.prepareStatement("select pizza_pricing.id , sizes,price from pizza_pricing , pizza_items where pizza_items.id=itemid and itemid=?")){
			ps.setInt(1, a);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String size=rs.getString(2);
				double price=rs.getDouble(3);
				System.out.println(id+" "+size+" "+price);

		}
		}
	}
	
	public void placeOrder(int id) throws SQLException {
//		import java.time.format.DateTimeFormatter;  
//		import java.time.LocalDateTime;  
		int oid=0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();  
	    System.out.println("Current Date and Time: " + dtf.format(now)); 
	    String s=dtf.format(now);
		String sql="insert into PIZZA_ORDERS(customerId,OrderTime,STATUS)values(?,?,?)";
		try(PreparedStatement ps=connection.prepareStatement(sql)){
			ps.setInt(1, id);
			ps.setString(2,s);
			ps.setString(3,"Pending");	
			ps.execute();
		}
		try(PreparedStatement ps1=connection.prepareStatement("select id from PIZZA_ORDERS where customerid=? and OrderTime=?")){
			ps1.setInt(1, id);
			ps1.setString(2, s);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				oid=rs.getInt(1);			
		}
		}
			for(Pizza_pricing ob:cart) {
			String sql1="insert into PIZZA_ORDERDETAILS(Orderid,priceid)values(?,?)";
			try(PreparedStatement ps2=connection.prepareStatement(sql1)){
				ps2.setInt(1, oid);		
				ps2.setInt(2,ob.id);
				ps2.execute();
			}
			}
		
			cart.clear();
	}
	
	public void showCart()  {
		for(Pizza_pricing p:cart) {
		System.out.println(p);//make sure tostring method written in pizzapricing class
	}
	}
	
	
	

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

//	public void signout() {
//		cart.clear();
//	}

}
