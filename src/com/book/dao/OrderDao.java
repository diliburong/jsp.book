package com.book.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.entity.Order;

public interface OrderDao {

	
	
	public ResultSet getOrderByUserId(Connection conn,int user_id) throws SQLException; 
	
	
	public ResultSet addOrder(Connection conn,Order order) throws SQLException;
	public void updateOrderStatus(Connection conn,int status,int order_id)throws SQLException;
}
