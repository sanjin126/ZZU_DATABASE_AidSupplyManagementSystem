package com.aidsystem.bean;

public class Transportation {
	
	private int aidId; //主键,救援物资aid_supplyid
	private Integer trpId; //运输人员transportation person id
	private int demId;
	private boolean status; //0表示正在运输，1表示完成运输
	
	
	
	public Transportation() {
		super();
	}



	public Transportation(int aidId, Integer trpId, int demId, boolean status) {
		super();
		this.aidId = aidId;
		this.trpId = trpId;
		this.demId = demId;
		this.status = status;
	}



	@Override
	public String toString() {
		return "Transportation [aidId=" + aidId + ", trpId=" + trpId + ", demId=" + demId + ", status=" + status + "]";
	}



	public int getAidId() {
		return aidId;
	}



	public void setAidId(int aidId) {
		this.aidId = aidId;
	}



	public Integer getTrpId() {
		return trpId;
	}



	public void setTrpId(Integer trpId) {
		this.trpId = trpId;
	}



	public int getDemId() {
		return demId;
	}



	public void setDemId(int demId) {
		this.demId = demId;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

	
}
