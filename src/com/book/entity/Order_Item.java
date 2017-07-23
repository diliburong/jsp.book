package com.book.entity;

import com.book.entity.IdEntity;

public class Order_Item extends IdEntity {

	private int order_id;
	private int product_id;
	private int count;
	private Product pdt;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	public Product getPdt() {
		return pdt;
	}

	public void setPdt(Product pdt) {
		this.pdt = pdt;
	}

	@Override
	public String toString() {
		return "Order_Item [order_id=" + order_id + ", product_id=" + product_id + ", count=" + count + ", pdt=" + pdt
				+ ", id=" + id + "]";

	}
}
