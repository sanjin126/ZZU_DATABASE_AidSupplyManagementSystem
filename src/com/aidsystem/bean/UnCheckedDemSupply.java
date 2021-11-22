package com.aidsystem.bean;

import java.sql.Timestamp;

public class UnCheckedDemSupply {
	private int aidId;
	private String aidName;
	private Integer quantity;
	private int orgId;
	private String orgName;
	private String address;
	private String director;
	private String phone;
	private String description;
	private boolean checkStatus;
	
	public UnCheckedDemSupply() {
		super();
	}

	public UnCheckedDemSupply(int aidId, String aidName, Integer quantity, int orgId, String orgName, String address,
			String director, String phone, String description, boolean checkStatus) {
		super();
		this.aidId = aidId;
		this.aidName = aidName;
		this.quantity = quantity;
		this.orgId = orgId;
		this.orgName = orgName;
		this.address = address;
		this.director = director;
		this.phone = phone;
		this.description = description;
		this.checkStatus = checkStatus;
	}

	public int getAidId() {
		return aidId;
	}

	public void setAidId(int aidId) {
		this.aidId = aidId;
	}

	public String getAidName() {
		return aidName;
	}

	public void setAidName(String aidName) {
		this.aidName = aidName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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

	public boolean isCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(boolean checkStatus) {
		this.checkStatus = checkStatus;
	}

	@Override
	public String toString() {
		return "UnCheckedDemSupply [aidId=" + aidId + ", aidName=" + aidName + ", quantity=" + quantity + ", orgId="
				+ orgId + ", orgName=" + orgName + ", address=" + address + ", director=" + director + ", phone="
				+ phone + ", description=" + description + ", checkStatus=" + checkStatus + "]";
	}
	
	
	

}
