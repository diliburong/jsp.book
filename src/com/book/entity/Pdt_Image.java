package com.book.entity;

public class Pdt_Image extends IdEntity {

	
	private String image_path;
	private int image_no;
	private int product_id;
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public int getImage_no() {
		return image_no;
	}
	public void setImage_no(int image_no) {
		this.image_no = image_no;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@Override
	public String toString() {
		return "Pdt_Image [image_path=" + image_path + ", image_no=" + image_no + ", product_id=" + product_id + ", id="
				+ id + "]";
	}
	
	
}
