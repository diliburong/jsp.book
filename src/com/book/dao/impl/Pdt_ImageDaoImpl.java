package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.dao.Pdt_ImageDao;

public class Pdt_ImageDaoImpl implements Pdt_ImageDao {

	@Override
	public ResultSet getProductImagesById(Connection conn, int product_id) throws SQLException {
		PreparedStatement ps=conn.
				prepareStatement("SELECT * FROM pdt_images WHERE product_id=?");
		ps.setInt(1, product_id);
		
		
		return ps.executeQuery();
	}




}
