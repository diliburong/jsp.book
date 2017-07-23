package com.book.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



public interface ProductDao {

	
	public ResultSet getProductByCategoryId(Connection conn,int category_id) throws SQLException; 

	public ResultSet getProductById(Connection conn,int id) throws SQLException;

}
