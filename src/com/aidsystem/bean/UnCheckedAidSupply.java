package com.aidsystem.bean;

import java.sql.Timestamp;
/**
 * 
 * @Description 对应于视图view
 * @author sanjin
 * @version
 * @date 2021年11月18日下午8:46:01
 *
 */
public class UnCheckedAidSupply {
	private int aidId;
	private String aidName;
	private Integer quantity;
	private int donId;
	private String donName;
	private String phone;
	private String address;
	private boolean needTransport;
	private boolean checkStatus;
	
	public UnCheckedAidSupply() {
		super();
	}

	public UnCheckedAidSupply(int aidId, String aidName, Integer quantity, int donId, String donName, String phone,
			String address, boolean needTransport, boolean checkStatus) {
		super();
		this.aidId = aidId;
		this.aidName = aidName;
		this.quantity = quantity;
		this.donId = donId;
		this.donName = donName;
		this.phone = phone;
		this.address = address;
		this.needTransport = needTransport;
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

	public int getDonId() {
		return donId;
	}

	public void setDonId(int donId) {
		this.donId = donId;
	}

	public String getDonName() {
		return donName;
	}

	public void setDonName(String donName) {
		this.donName = donName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isNeedTransport() {
		return needTransport;
	}

	public void setNeedTransport(boolean needTransport) {
		this.needTransport = needTransport;
	}

	public boolean isCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(boolean checkStatus) {
		this.checkStatus = checkStatus;
	}

	@Override
	public String toString() {
		return "UnCheckedAidSupply [aidId=" + aidId + ", aidName=" + aidName + ", quantity=" + quantity + ", donId="
				+ donId + ", donName=" + donName + ", phone=" + phone + ", address=" + address + ", needTransport="
				+ needTransport + ", checkStatus=" + checkStatus + "]";
	}
	
	
	
	
}
