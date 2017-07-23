package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.dao.OrderDao;
import com.book.entity.Order;

public class OrderDaoImpl implements OrderDao {

	@Override
	public ResultSet getOrderByUserId(Connection conn, int user_id) throws SQLException {
		
		PreparedStatement ps=conn.
				prepareStatement("SELECT * FROM `order` WHERE member_id=?");
		ps.setInt(1, user_id);
		
		return ps.executeQuery();
	}

	@Override
	public ResultSet addOrder(Connection conn, Order order) throws SQLException {
		PreparedStatement ps=conn.
				prepareCall("INSERT INTO `order`(member_id,order_no,total_price,status) VALUES (?,?,?,?)");
		
		ps.setInt(1, order.getUser_id());
		ps.setString(2, order.getOrder_no());
		ps.setFloat(3, order.getTotal_price());
		ps.setInt(4, order.getStatus());
		ps.executeUpdate();
		
		return ps.getGeneratedKeys();	
	}

	public void updateOrderStatus(Connection conn,int status,int order_id)throws SQLException{
		PreparedStatement ps=conn.
				prepareCall("UPDATE `order` SET status=? WHERE id =?");
		ps.setInt(1,status);
		ps.setInt(2, order_id);
		ps.execute();
	}
}
