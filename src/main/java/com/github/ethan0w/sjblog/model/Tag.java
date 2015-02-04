package com.github.ethan0w.sjblog.model;

import java.io.Serializable;

/**
 * Tag model
 * @author hy
 *
 */
public class Tag implements Serializable{

	String name; //tag name
	int userId;  //user id
	int num;	 //article number of this tag
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
