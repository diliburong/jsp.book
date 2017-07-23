package com.book.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Pdt_ContentDao {

	public ResultSet getProductContentById(Connection conn,int product_id)  throws SQLException; 
	
}
