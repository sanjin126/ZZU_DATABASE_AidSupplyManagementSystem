package com.aidsystem.bean;

public class Donator {
	private int id;
	private String name;
	private String phone;
	
	public Donator() {
		super();
	}
	/**
	 * 
	 * @Description 可以为空的属性：无
	 */
	public Donator(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Donator [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	

}
