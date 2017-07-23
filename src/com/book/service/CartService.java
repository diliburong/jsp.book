package com.book.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.book.dao.Cart_ItemDao;
import com.book.dao.impl.Cart_ItemDaoImpl;
import com.book.entity.Cart_Item;
import com.book.entity.Product;
import com.book.util.ConnectionFactory;
import com.mysql.fabric.xmlrpc.base.Array;

public class CartService {
	
	private Cart_ItemDao cart_itemDao=new Cart_ItemDaoImpl();
	
	Connection conn = null;
	
	public void addCart(int user_id, int product_id) {
		
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			ResultSet rs = cart_itemDao.getCartItemByUserId(conn, user_id);
			boolean exist = false;
			while (rs.next()) {
				if (rs.getInt(3) == product_id) {
					// count+1
					//System.out.println(rs.getInt(3));
					cart_itemDao.updateCart_Item(conn, user_id, product_id);
					exist = true;
					break;
				}
			}

			if (exist == false) {
			//	System.out.println("no");
				cart_itemDao.addOneCart_Item(conn, user_id, product_id);

			}
			
			conn.commit();

		} catch (Exception e) {
			try{
				conn.rollback();
			}catch(Exception e2){
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}

	}
	
	public void delete(int user_id,String product_ids){
		
		String[] product_id=product_ids.split(",");
		
		
		
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			for(String x:product_id){
				cart_itemDao.deleteCart_Item(conn, user_id, Integer.parseInt(x));
			}
			
			

			conn.commit();

		} catch (Exception e) {
			try{
				conn.rollback();
			}catch(Exception e2){
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		
		
	}
	
	public ArrayList<Cart_Item> getCartList(int user_id){
		ArrayList<Cart_Item> cart_item_list = new ArrayList<Cart_Item>();  
		ProductService ps=new ProductService();
		try{
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs=cart_itemDao.getCartItemByUserId(conn, user_id);
			while(rs.next()){
				Cart_Item cart_item=new Cart_Item();
				cart_item.setId(rs.getLong(1));
				cart_item.setMember_id(user_id);
				cart_item.setProduct_id(rs.getInt(3));
				cart_item.setCount(rs.getInt(4));
				
				cart_item.setPdt(ps.getProductById(rs.getInt(3)));
				
				cart_item_list.add(cart_item);
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
		return cart_item_list;
	}
	
	
}
