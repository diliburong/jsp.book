package com.book.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.book.dao.OrderDao;
import com.book.dao.Order_ItemDao;

import com.book.dao.impl.OrderDaoImpl;
import com.book.dao.impl.Order_ItemDaoImpl;
import com.book.entity.Cart_Item;
import com.book.entity.Order;
import com.book.entity.Order_Item;

import com.book.util.ConnectionFactory;

public class OrderService {


	
	private OrderDao orderDao=new OrderDaoImpl();
	private Order_ItemDao order_itemDao=new Order_ItemDaoImpl();
	
	Connection conn = null;
	CartService cs=new CartService();
	ProductService ps=new ProductService();
	
	
	private float total_price;
	private static int order_id;
	ArrayList<Cart_Item> cart_items_arr=new ArrayList<>();
	public void payOrder(){
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			
			System.out.println(getOrder_id());
			orderDao.updateOrderStatus(conn, 0,getOrder_id());
			
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
	public void commitOrder(int user_id){
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String order_no="E"+sdf.format(d);
		
		Order order=new Order();
		order.setUser_id(user_id);
		order.setTotal_price(getTotal_price());
		order.setStatus(1);
		order.setOrder_no(order_no);
		
		try {
			
			
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);	
			
			ResultSet rs=orderDao.addOrder(conn, order);
			while(rs.next()){
			
				//System.out.println(rs.getInt(1));
				this.setOrder_id(rs.getInt(1));
				commitOrderItem(conn,this.getOrder_id());
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

	public void commitOrderItem(Connection conn,int order_id) throws SQLException{
		
		for(Cart_Item cart_item:getCart_items_arr()){
			Order_Item order_item=new Order_Item();
			
			order_item.setCount(cart_item.getCount());
			order_item.setOrder_id(order_id);
			order_item.setProduct_id(cart_item.getProduct_id());
			
			order_itemDao.addOrder_Item(conn, order_item);
		}
		
		
	}
	public void getTotalPriceAndCartItem(int user_id, String product_ids) {
		float total_price = 0;
		ArrayList<Cart_Item> cart_items = cs.getCartList(user_id);
		ArrayList<Cart_Item> cart_items_arr = new ArrayList<>();
		String[] product_ids_arr = product_ids.split(",");

		for (Cart_Item cart_item : cart_items) {
			for (String x : product_ids_arr) {
				if (cart_item.getProduct_id() == Integer.parseInt(x)) {
					if (cart_item.getPdt() != null) {
						total_price += cart_item.getPdt().getPrice() * cart_item.getCount();
						cart_items_arr.add(cart_item);

					}
				}

			}

		}
		this.setTotal_price(total_price);
		this.setCart_items_arr(cart_items_arr);
	}
	
	
	public ArrayList<Order> getOrderList(int user_id) {

		ArrayList<Order> orders = new ArrayList<Order>();
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			ResultSet rs = orderDao.getOrderByUserId(conn, user_id);
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getLong(1));
				order.setUser_id(rs.getInt(2));
				order.setOrder_no(rs.getString(3));
				order.setTotal_price(rs.getFloat(4));
				order.setStatus(rs.getInt(5));

				order.setOrder_items(getOrderItemList(rs.getInt(1)));
				orders.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return orders;
	}
	
	
	public ArrayList<Order_Item> getOrderItemList(int order_id){
		ArrayList<Order_Item> order_items = new ArrayList<Order_Item>();
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			ResultSet rs = order_itemDao.getOrderItemByOrderId(conn, order_id);
			while (rs.next()) {
				Order_Item order_item = new Order_Item();
				order_item.setId(rs.getLong(1));
				order_item.setOrder_id(rs.getInt(2));
				order_item.setProduct_id(rs.getInt(3));
				order_item.setCount(rs.getInt(4));
				order_item.setPdt(ps.getProductById(rs.getInt(3)));
				order_items.add(order_item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return order_items;
	}
	public float getTotal_price() {
		return total_price;
	}


	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}


	public ArrayList<Cart_Item> getCart_items_arr() {
		return cart_items_arr;
	}


	public void setCart_items_arr(ArrayList<Cart_Item> cart_items_arr) {
		this.cart_items_arr = cart_items_arr;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
}
