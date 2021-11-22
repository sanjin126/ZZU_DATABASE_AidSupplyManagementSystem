package com.aidsystem.bean;

public class Organization {
	private int id;
	private String name;
	private String address;
	private String director;
	private String phone;
	private String description;
	
	public Organization() {
		super();
	}
	/**
	 * 
	 * @Description 可以为空的属性：name，description
	 */
	public Organization(int id, String name, String address, String director, String phone, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.director = director;
		this.phone = phone;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", address=" + address + ", director=" + director
				+ ", phone=" + phone + ", description=" + description + "]";
	}
	

}
