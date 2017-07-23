package com.book.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.entity.Order_Item;




public interface Order_ItemDao {

	
	public ResultSet getOrderItemByOrderId(Connection conn,int order_id) throws SQLException; 
	public void addOrder_Item(Connection conn,Order_Item order_item) throws SQLException;

	
}
	
