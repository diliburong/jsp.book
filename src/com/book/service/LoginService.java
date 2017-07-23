package com.book.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.book.dao.UserDao;
import com.book.dao.impl.UserDaoImpl;
import com.book.entity.User;
import com.book.util.ConnectionFactory;

public class LoginService {
	
	private UserDao userDao=new UserDaoImpl();
	
	public User check(User user){
		Connection conn=null;
		
		
		try{
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs=userDao.get(conn, user);
					
			while(rs.next()){

				user.setId(rs.getLong(1));
				return user;
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			try{
				conn.rollback();
			}catch(Exception e2){
				e2.printStackTrace();
			}
			
		}finally{
			try{
				conn.close();
				
			}catch(Exception e3){
				e3.printStackTrace();
			}
		}
		
		return null;
	}


}
