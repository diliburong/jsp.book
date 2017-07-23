package com.book.entity;

public class Product extends IdEntity {

	
	private String name;
	private String summary;
	private float price;
	private String preview;
	private int category_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", summary=" + summary + ", price=" + price + ", preview=" + preview
				+ ", category_id=" + category_id + ", id=" + id + "]";
	}
	
}
