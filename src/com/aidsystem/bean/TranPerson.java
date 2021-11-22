package com.aidsystem.bean;

public class TranPerson {
	private int id;
	private String name;
	private String gender;
	private Integer age;
	private String phone;
	private String area;
	private String numberPlate;
	
	public TranPerson() {
		super();
	}
	/**
	 * 
	 * @Description 可为空的属性：gender，age，area
	 */

	public TranPerson(int id, String name, String gender, Integer age, String phone, String area, String numberPlate) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.area = area;
		this.numberPlate = numberPlate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	@Override
	public String toString() {
		return "TranPerson [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", phone=" + phone
				+ ", area=" + area + ", numberPlate=" + numberPlate + "]";
	}
	

}
