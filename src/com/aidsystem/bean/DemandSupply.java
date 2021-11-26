package com.aidsystem.bean;

import java.sql.Timestamp;

public class DemandSupply {
	private int id;
	private String name;
	private Integer quantity;
	private Timestamp demandDate;
	private String description;
	private int orgId;
	private Integer volId;
	private boolean checkStatus;
	private boolean status;
	
	public DemandSupply() {
		super();
	}

	public DemandSupply(int id, String name, Integer quantity, Timestamp demandDate, String description, int orgId,
			Integer volId, boolean checkStatus, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.demandDate = demandDate;
		this.description = description;
		this.orgId = orgId;
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

	public Timestamp getDemandDate() {
		return demandDate;
	}

	public void setDemandDate(Timestamp demandDate) {
		this.demandDate = demandDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
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
		return "DemandSupply [id=" + id + ", name=" + name + ", quantity=" + quantity + ", demandDate=" + demandDate
				+ ", description=" + description + ", orgId=" + orgId + ", volId=" + volId + ", checkStatus="
				+ checkStatus + ", status=" + status + "]";
	}
	
	

	
	
}
