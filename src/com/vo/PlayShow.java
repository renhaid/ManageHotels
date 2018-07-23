package com.vo;

public class PlayShow {
	private String custName;
	private String startDate;
	private String endDate;
	private double money;
	private int roomId;
	private int seatId;
	private int garaId;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getGaraId() {
		return garaId;
	}
	public void setGaraId(int garaId) {
		this.garaId = garaId;
	}
	@Override
	public String toString() {
		return "PlayShow [custName=" + custName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", money=" + money + ", roomId="
				+ roomId + ", seatId=" + seatId + ", garaId=" + garaId + "]";
	}
	
	

}
