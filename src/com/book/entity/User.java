package com.book.entity;

import com.book.entity.IdEntity;

public class User extends IdEntity {

	private String name;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", id=" + id + "]";
	}


	
//	private String password;
	
	
}