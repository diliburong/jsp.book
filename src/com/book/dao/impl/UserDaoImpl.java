package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.dao.UserDao;
import com.book.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(Connection conn, User user) throws SQLException {
		
		
	}

	@Override
	public void delete(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet get(Connection conn, User user) throws SQLException {
		PreparedStatement ps=conn.
				prepareStatement("SELECT * FROM member WHERE nickname=? AND password=?");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		
		return ps.executeQuery();
	}

}
