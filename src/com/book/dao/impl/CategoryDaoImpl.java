package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.dao.CategoryDao;
import com.book.entity.Category;

public class CategoryDaoImpl implements CategoryDao {

	
	
	@Override
	public ResultSet get(Connection conn, Category category) throws SQLException {

		PreparedStatement ps=conn.
				prepareStatement("SELECT * FROM category WHERE parent_id=?");
		ps.setInt(1, category.getPaerent_id());
		
		return ps.executeQuery();
	}

	@Override
	public ResultSet getParentCategory(Connection conn) throws SQLException {
		PreparedStatement ps=conn.
				prepareStatement("SELECT * FROM category WHERE parent_id IS NULL");
		
		return ps.executeQuery();
	}
	
	

}
