package com.book.entity;

public class Cart_Item extends IdEntity {

	private Product pdt;
	private int member_id,product_id,count;

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
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
		return "Cart_Item [pdt=" + pdt + ", member_id=" + member_id + ", product_id=" + product_id + ", count=" + count
				+ ", id=" + id + "]";
	}
	
}
