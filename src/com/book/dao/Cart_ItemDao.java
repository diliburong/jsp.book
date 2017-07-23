package com.book.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.entity.Cart_Item;
import com.book.entity.User;

public interface Cart_ItemDao {

	
	public ResultSet getCartItemByUserId(Connection conn,int user_id) throws SQLException;
	public void addOneCart_Item(Connection conn,int user_id,int product_id) throws SQLException;
	
	public void updateCart_Item(Connection conn,int user_id,int product_id) throws SQLException;
	
	public void deleteCart_Item(Connection conn,int user_id,int product_id) throws SQLException;
}
