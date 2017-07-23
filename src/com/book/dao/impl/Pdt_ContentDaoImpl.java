package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.dao.Pdt_ContentDao;

public class Pdt_ContentDaoImpl implements Pdt_ContentDao {

	@Override
	public ResultSet getProductContentById(Connection conn,int product_id) throws SQLException {
		PreparedStatement ps=conn.
				prepareStatement("SELECT * FROM pdt_content WHERE product_id=?");
		ps.setInt(1, product_id);
		
		
		return ps.executeQuery();
	}


}
