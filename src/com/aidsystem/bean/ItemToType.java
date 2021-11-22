package com.aidsystem.bean;

public class ItemToType {
	private String name;
	private String unit; //物资单位，由志愿者指定
	
	public ItemToType() {
		super();
	}

	public ItemToType(String name, String unit) {
		super();
		this.name = name;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "ItemToType [name=" + name + ", unit=" + unit + "]";
	}

	


}
