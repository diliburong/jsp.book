package com.book.entity;

public class Pdt_Content extends IdEntity {

	
	private String content;
	private int product_id;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@Override
	public String toString() {
		return "Pdt_Content [content=" + content + ", product_id=" + product_id + ", id=" + id + "]";
	}
	
}
