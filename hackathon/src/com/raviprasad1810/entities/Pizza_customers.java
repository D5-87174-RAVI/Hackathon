package com.raviprasad1810.entities;

import java.util.Scanner;

public class Pizza_customers {
int id;
String name;
String password;
String mobile;
String Address;
String email;

public Pizza_customers() {

}

public Pizza_customers(int id, String name, String password, String mobile, String address, String email) {
super();
this.id = id;
this.name = name;
this.password = password;
this.mobile = mobile;
Address = address;
this.email = email;
}

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

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String getMobile() {
return mobile;
}

public void setMobile(String mobile) {
this.mobile = mobile;
}

public String getAddress() {
return Address;
}

public void setAddress(String address) {
Address = address;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public void accept(Scanner sc) {
	System.out.println("Enter Your Name");
	setName(sc.next());
	
	System.out.println("Enter New Password");
	setPassword(sc.next());
	
	System.out.println("Enter your Mobile Number");
	setMobile(sc.next());
	
	System.out.println("Enter your Address");
	setAddress(sc.next());
	
	System.out.println("Enter your Email");
	setEmail(sc.next());
}

@Override
public String toString() {
return "pizza_customers [id=" + id + ", name=" + name + ", password=" + password + ", mobile=" + mobile
+ ", Address=" + Address + ", email=" + email + "]";
}


}