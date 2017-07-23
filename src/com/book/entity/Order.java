package com.book.entity;

import java.util.ArrayList;

import com.book.entity.IdEntity;

public class Order extends IdEntity {

	private int user_id;
	private String order_no;
	private float total_price;
	private int status;
	
	private ArrayList<Order_Item> order_items;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ArrayList<Order_Item> getOrder_items() {
		return order_items;
	}
	public void setOrder_items(ArrayList<Order_Item> order_items) {
		this.order_items = order_items;
	}
	@Override
	public String toString() {
		return "Order [user_id=" + user_id + ", order_no=" + order_no + ", total_price=" + total_price + ", status="
				+ status + ", order_items=" + order_items + "]";
	}
	
	
	
	
}
