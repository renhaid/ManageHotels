package com.pojo;

public class RoomWaiterInfo {
	private int id;
	private int roomWaiterId;
	private String waiterName;
	private int roomId;
	private String status;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomWaiterId() {
		return roomWaiterId;
	}
	public void setRoomWaiterId(int roomWaiterId) {
		this.roomWaiterId = roomWaiterId;
	}
	public String getWaiterName() {
		return waiterName;
	}
	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
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
