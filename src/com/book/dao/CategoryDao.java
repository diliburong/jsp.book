package com.book.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.book.entity.Category;

public interface CategoryDao {

	public ResultSet get(Connection conn,Category category) throws SQLException; 
	
	public ResultSet getParentCategory(Connection conn) throws SQLException;
	
	
}
