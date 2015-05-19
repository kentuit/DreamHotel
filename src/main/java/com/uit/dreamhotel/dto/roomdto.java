package com.uit.dreamhotel.dto;

public class roomdto {
	private int roomId;
	private int number;
	private int type;
	
	public roomdto(){
		super();
	}

	public roomdto(int roomId, int number, int type) {
		super();
		this.roomId = roomId;
		this.number = number;
		this.type = type;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	

}
