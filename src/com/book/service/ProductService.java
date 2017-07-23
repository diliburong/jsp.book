package com.book.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.book.dao.Pdt_ContentDao;
import com.book.dao.Pdt_ImageDao;
import com.book.dao.ProductDao;
import com.book.dao.impl.Pdt_ContentDaoImpl;
import com.book.dao.impl.Pdt_ImageDaoImpl;
import com.book.dao.impl.ProductDaoImpl;
import com.book.entity.Product;
import com.book.entity.Pdt_Content;
import com.book.entity.Pdt_Image;
import com.book.util.ConnectionFactory;

public class ProductService {

	
	private ProductDao productDao=new ProductDaoImpl();
	private Pdt_ContentDao pdt_contentDao=new Pdt_ContentDaoImpl();
	private Pdt_ImageDao pdt_imageDao=new Pdt_ImageDaoImpl();
	
	public ArrayList<Product> getProductByCategoryId(int category_id){
		
		ArrayList<Product> list = new ArrayList<Product>();  
		Connection conn=null;
		try{
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet resultSet=productDao.getProductByCategoryId(conn, category_id);
			while(resultSet.next()){
				Product pdt=new Product();
				pdt.setId(resultSet.getLong(1));
				pdt.setName(resultSet.getString(2));
				
				pdt.setSummary(resultSet.getString(3));
				pdt.setPrice(resultSet.getFloat(4));
				pdt.setPreview(resultSet.getString(5));
				pdt.setCategory_id(resultSet.getInt(6));
				
				list.add(pdt);
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

	public Product getProductById (int id){
		Product pdt=new Product();
		Connection conn=null;
		try{
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs=productDao.getProductById(conn, id);
			while(rs.next()){
				pdt.setId(rs.getLong(1));
				pdt.setName(rs.getString(2));
				
				pdt.setSummary(rs.getString(3));
				pdt.setPrice(rs.getFloat(4));
				pdt.setPreview(rs.getString(5));
				pdt.setCategory_id(rs.getInt(6));
				return pdt;
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				
			}catch(Exception e3){
				e3.printStackTrace();
			}	
		}
		return null;
	}
	
	public Pdt_Content getPdtContent(int product_id){
		
		Pdt_Content pdt_content=new Pdt_Content();
		Connection conn=null;
		try{
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs=pdt_contentDao.getProductContentById(conn, product_id);
			while(rs.next()){
				 pdt_content.setId(rs.getLong(1));
				 pdt_content.setContent(rs.getString(2));
				 pdt_content.setProduct_id(rs.getInt(3));
				 return pdt_content;
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				
			}catch(Exception e3){
				e3.printStackTrace();
			}	
		}
		return null;
	}

	public ArrayList<Pdt_Image> getPdtImages(int product_id){
		ArrayList<Pdt_Image> list = new ArrayList<Pdt_Image>();  
		Connection conn=null;
		try{
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs=pdt_imageDao.getProductImagesById(conn, product_id);
			while(rs.next()){
				Pdt_Image pdt_image=new Pdt_Image();
				pdt_image.setId(rs.getLong(1));
				pdt_image.setImage_path(rs.getString(2));
				pdt_image.setImage_no(rs.getInt(3));
				pdt_image.setProduct_id(rs.getInt(4));
				
				list.add(pdt_image);
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
	
	public int getCount(int product_id,int member_id){
		int count=0;
		
		
		
		
		return count;
	}
}
