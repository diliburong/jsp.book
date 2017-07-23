package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.dao.ProductDao;

public class ProductDaoImpl implements ProductDao {

	@Override
	public ResultSet getProductByCategoryId(Connection conn, int category_id) throws SQLException {

		
		PreparedStatement ps=conn.
				prepareStatement("SELECT * FROM product WHERE category_id=?");
		ps.setInt(1, category_id);
		
		return ps.executeQuery();
		
		
	}

	@Override
	public ResultSet getProductById(Connection conn, int id) throws SQLException {
		PreparedStatement ps=conn.
				prepareStatement("SELECT * FROM product WHERE id=?");
		ps.setInt(1, id);
		
		return ps.executeQuery();
	}


}
