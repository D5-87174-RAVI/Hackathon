package com.raviprasad1810.entities;

import java.util.Scanner;

public class Order {
int orderid;
int customerid;
String date;
String status;

public Order() {

}

public Order(int orderid, int customerid, String date, String status) {
super();
this.orderid = orderid;
this.customerid = customerid;
this.date = date;
this.status = status;
}

public int getOrderid() {
return orderid;
}

public void setOrderid(int orderid) {
this.orderid = orderid;
}

public int getCustomerid() {
return customerid;
}

public void setCustomerid(int customerid) {
this.customerid = customerid;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public void accept(Scanner sc) {
System.out.println("Enter Customer ID:");
customerid=sc.nextInt();
System.out.println("Enter Order Date:");
date=sc.nextLine();
System.out.println("Enter Status:");
status=sc.nextLine();
}

@Override
public String toString() {
return "Order [orderid=" + orderid + ", customerid=" + customerid + ", date=" + date + ", status=" + status
+ "]";
}




}