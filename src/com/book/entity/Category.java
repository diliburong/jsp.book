package com.book.entity;
import com.book.entity.IdEntity;

public class Category extends IdEntity {

	private String name;
	private int category_no;
	private int paerent_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public int getPaerent_id() {
		return paerent_id;
	}
	public void setPaerent_id(int paerent_id) {
		this.paerent_id = paerent_id;
	}
	@Override
	public String toString() {
		return "Category [name=" + name + ", category_no=" + category_no + ", paerent_id=" + paerent_id + "]";
	}
	
	
	
	
}
