package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.dao.Order_ItemDao;
import com.book.entity.Order_Item;

public class Order_ItemDaoImpl implements Order_ItemDao {

	@Override
	public ResultSet getOrderItemByOrderId(Connection conn, int order_id) throws SQLException {
	
		PreparedStatement ps=conn.
				prepareStatement("SELECT * FROM order_item WHERE order_id=?");
		ps.setInt(1, order_id);
		
		return ps.executeQuery();
	}

	@Override
	public void addOrder_Item(Connection conn, Order_Item order_item) throws SQLException {
		PreparedStatement ps=conn.
				prepareCall("INSERT INTO order_item(order_id,product_id,count) VALUES (?,?,?)");
		ps.setInt(1,order_item.getOrder_id());
		ps.setInt(2, order_item.getProduct_id());
		ps.setInt(3, order_item.getCount());
		

		ps.execute();
	}
}
