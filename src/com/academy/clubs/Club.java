package com.academy.clubs;

public class Club {
	String name;
	String desc;
	//TODO arraylist of users?
	
	public Club(String name)	{
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
