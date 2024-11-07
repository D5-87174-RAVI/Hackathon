package com.raviprasad1810.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.raviprasad1810.dao.LoginDao;
import com.raviprasad1810.dao.MenuDao;
import com.raviprasad1810.dao.OrderDao;
import com.raviprasad1810.dao.Pizza_customersDao;
import com.raviprasad1810.entities.Pizza_customers;
import com.raviprasad1810.utils.Dbutil;

import java.sql.SQLException;
import java.util.Scanner;



public class TesterMain {
	
	public static int mainMenu() {
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("0. Exit");
		System.out.println("1. Sign In");
		System.out.println("2. Sign Up");
		choice=sc.nextInt();
		return choice;	
	}
	
	public static int adminMenu() {
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("0. Exit");
		System.out.println("1. Show all orders");
		System.out.println("2. Show order details (for given order id show Pizza & Customer details)");
		System.out.println("3. Sign Out");
		choice=sc.nextInt();
		return choice;	
	}
	
	public static int customerMenu() {
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("0. Exit");
		System.out.println("1. Show Veg Menu");
		System.out.println("2. Show Non-Veg Menu");
		System.out.println("3. Show available sizes (for given Item id)");
		System.out.println("4. Add to cart (for given price)");
		System.out.println("5. Show Cart (Pizzas with Size & Price Details)");
		System.out.println("6. Place Order (Save Order in Database for current customer)");
		System.out.println("7. Sign Out");
		choice=sc.nextInt();
		return choice;	
	}

	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LoginDao p = null;
		MenuDao m = null;
		OrderDao o = null;
		try {
			p = new LoginDao();
			m = new MenuDao();
			o = new OrderDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int choice;
		
		while((choice=mainMenu())!=0) {
			if(choice==1) {
				System.out.print("Enter email :");
				String email = sc.next();
				System.out.print("Enter password :");
				String pass = sc.next();
				int b=0;
				try {
					
					b = p.checkCustomer(email,pass);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(p.checkAdmin(email,pass)) {
					System.out.println("Login successfull as admin");
					int choice1;
					while((choice1=adminMenu())!=3) {
						if(choice1==1)
//							System.out.println("all orders");
							o.Allorders();
						else if(choice1==2)
//							System.out.println("order details (for given order id show Pizza & Customer details)");
							o.showOrders();
						else if(choice1==3)
							System.out.println("Sign Out");
						else if(choice1==0)
							System.exit(0);
						else 
							System.out.println("enter valid character");
					}
					
				}

				else if (b>0) {
					int choice2;
					while((choice2=customerMenu())!=7) {
						if(choice2==1)
							try {
								m.VegPizza();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						else if(choice2==2)
							try {
								m.NonVegPizza();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						else if(choice2==3)
							try {
								m.pizza_sizes();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						else if(choice2==4)
							try {
								m.addCart();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						else if(choice2==5)
//							System.out.println("5. Show Cart (Pizzas with Size & Price Details)");
							m.showCart();
						else if(choice2==6)
							try {
//							System.out.println(b);
								m.placeOrder(b);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						else if(choice2==0)
							System.exit(0);
						else 
							System.out.println("enter valid character");
						
						
				}}
				
				
			}
			else if(choice==2) {
				p.addCustomer(sc);
			}
			else 
				System.out.println("enter valid character");
		}
		

	}

			

}