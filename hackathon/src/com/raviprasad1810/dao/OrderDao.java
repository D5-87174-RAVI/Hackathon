package com.raviprasad1810.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import com.raviprasad1810.utils.Dbutil;

public class OrderDao implements AutoCloseable {
	private Connection connection;
	public OrderDao() throws SQLException {
		connection = Dbutil.getConnection();
	}
	
	public void Allorders(){
		try(PreparedStatement ps=connection.prepareStatement("select * from PIZZA_ORDERS")){
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				int cid=rs.getInt(2);
				String date=rs.getString(3);
				String status=rs.getString(4);
				
				System.out.println(id+" "+cid+" "+date+" "+status);
				
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	
	public void showOrders(){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter order id you want");
		int a=sc.nextInt();
		try(PreparedStatement ps=connection.prepareStatement("SELECT PIZZA_ITEMS.Name ,PIZZA_CUSTOMERS.Name ,PIZZA_CUSTOMERS.Mobile,PIZZA_CUSTOMERS.Email,PIZZA_CUSTOMERS.Address FROM PIZZA_ITEMS JOIN PIZZA_PRICING ON PIZZA_PRICING.ITEMID = PIZZA_ITEMS.ID JOIN PIZZA_ORDERDETAILS ON PIZZA_PRICING.ID = PIZZA_ORDERDETAILS.PRICEID JOIN PIZZA_ORDERS ON PIZZA_ORDERDETAILS.OrderId = PIZZA_ORDERS.ID JOIN PIZZA_CUSTOMERS ON PIZZA_ORDERS.CustomerId = PIZZA_CUSTOMERS.ID and orderid =?")){
			ps.setInt(1, a);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String pname=rs.getString(1);
				String cname=rs.getString(2);
				String mob=rs.getString(3);
				String email=rs.getString(4);
				String add=rs.getString(5);

				System.out.println(pname+" "+cname+" "+mob+" "+email+" "+add);
				
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
