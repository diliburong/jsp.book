package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.dao.Cart_ItemDao;


public class Cart_ItemDaoImpl implements Cart_ItemDao {

	@Override
	public ResultSet getCartItemByUserId(Connection conn,int user_id) throws SQLException {
		PreparedStatement ps=conn.
				prepareStatement("SELECT * FROM cart_item WHERE member_id=?");
		ps.setLong(1,user_id );
		
		//System.out.println(ps.executeQuery());
		return ps.executeQuery();
		
		
	}

	@Override
	public void addOneCart_Item(Connection conn, int user_id,int product_id) throws SQLException {
		
		PreparedStatement ps=conn.
				prepareCall("INSERT INTO cart_item(member_id,product_id,count) VALUES (?,?,?)");
		ps.setLong(1,user_id);
		ps.setInt(2, product_id);
		ps.setInt(3, 1);
		ps.execute();
		
	}

	@Override
	public void updateCart_Item(Connection conn, int user_id, int product_id) throws SQLException {
		
		PreparedStatement ps=conn.
				prepareCall("UPDATE cart_item SET count=count+1 WHERE member_id =? AND product_id =?");
		ps.setInt(1, user_id);
		ps.setInt(2, product_id);
		ps.execute();
		
		
	}

	@Override
	public void deleteCart_Item(Connection conn, int user_id, int product_id) throws SQLException {
		PreparedStatement ps=conn.
				prepareCall("DELETE FROM cart_item WHERE member_id =? AND product_id =?");
		ps.setInt(1, user_id);
		ps.setInt(2, product_id);
		ps.execute();
		
	}


}
