package com.pojo;

public class RoomInfo {
	private int id;
	private int roomId;
	private String roomType;
	private double roomPrice;
	private String status;
	private String floor;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "RoomInfo [id=" + id + ", roomId=" + roomId + ", roomType="
				+ roomType + ", roomPrice=" + roomPrice + ", status=" + status
				+ ", floor=" + floor + ", remark=" + remark + "]";
	}
	

}
