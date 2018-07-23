package com.pojo;

public class RestWaiterInfo {
	private int id;
	private int restWaiterId;
	private String waiterName;
	private int seatId;
	private String status;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRestWaiterId() {
		return restWaiterId;
	}
	public void setRestWaiterId(int restWaiterId) {
		this.restWaiterId = restWaiterId;
	}
	public String getWaiterName() {
		return waiterName;
	}
	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
