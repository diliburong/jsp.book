package com.book.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.book.dao.CategoryDao;
import com.book.dao.impl.CategoryDaoImpl;
import com.book.entity.Category;
import com.book.util.ConnectionFactory;

public class GetCategoryService {
	
	private CategoryDao categoryDao=new CategoryDaoImpl();
	
	public ArrayList<Category> getParentCategory(){
		
		ArrayList<Category> list = new ArrayList<Category>();  
		Connection conn=null;
		try{
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet resultSet=categoryDao.getParentCategory(conn);
			while(resultSet.next()){
				Category cat=new Category();
				cat.setId(resultSet.getLong(1));
				cat.setName(resultSet.getString(2));
				cat.setCategory_no(resultSet.getInt(3));
				cat.setPaerent_id(resultSet.getInt(4));
				
				list.add(cat);
				
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				conn.close();
			}catch(Exception e3){
				e3.printStackTrace();
			}
		}
		
		return list;
		
	}
	

}
