package com.raviprasad1810.entities;

public class Pizza_orderdetails {
int id;
int orderid;
int priceid;

public Pizza_orderdetails() {

}

public Pizza_orderdetails(int id, int orderid, int priceid) {
super();
this.id = id;
this.orderid = orderid;
this.priceid = priceid;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public int getOrderid() {
return orderid;
}

public void setOrderid(int orderid) {
this.orderid = orderid;
}

public int getPriceid() {
return priceid;
}

public void setPriceid(int priceid) {
this.priceid = priceid;
}

@Override
public String toString() {
return "pizza_orderdetails [id=" + id + ", orderid=" + orderid + ", priceid=" + priceid + "]";
}


}