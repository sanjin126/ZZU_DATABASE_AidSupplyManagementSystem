package com.aidsystem.bean;

import java.sql.Timestamp;

public class AidSupply {
	private int id;
	private String name;
	private Integer quantity;
	private String address;
	private Timestamp aidDate;
	private boolean needTransport;
	private Integer donId;
	private Integer volId;
	private boolean checkStatus;
	private boolean status;
	
	public AidSupply() {
		super();
	}
	/**
	 * 
	 * @Description 不可为空的属性：id，name，checkStatus，status
	 */
	public AidSupply(int id, String name, Integer quantity, String address, Timestamp aidDate, boolean needTransport,
			Integer donId, Integer volId, boolean checkStatus, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.address = address;
		this.aidDate = aidDate;
		this.needTransport = needTransport;
		this.donId = donId;
		this.volId = volId;
		this.checkStatus = checkStatus;
		this.status = status;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getAidDate() {
		return aidDate;
	}

	public void setAidDate(Timestamp aidDate) {
		this.aidDate = aidDate;
	}

	public boolean isNeedTransport() {
		return needTransport;
	}

	public void setNeedTransport(boolean needTransport) {
		this.needTransport = needTransport;
	}

	public Integer getDonId() {
		return donId;
	}

	public void setDonId(Integer donId) {
		this.donId = donId;
	}

	public Integer getVolId() {
		return volId;
	}

	public void setVolId(Integer volId) {
		this.volId = volId;
	}

	public boolean isCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(boolean checkStatus) {
		this.checkStatus = checkStatus;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AidSupply [id=" + id + ", name=" + name + ", quantity=" + quantity + ", address=" + address
				+ ", aidDate=" + aidDate + ", needTransport=" + needTransport + ", donId=" + donId + ", volId=" + volId
				+ ", checkStatus=" + checkStatus + ", status=" + status + "]";
	}
	


	
}
