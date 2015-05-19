package com.uit.dreamhotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.UniqueConstraint;

@Entity
@Table(name="room", catalog="dreamhotel", uniqueConstraints = {
		@UniqueConstraint(columnNames = "number"),
		/*@UniqueConstraint(columnNames = "xxx")*/
})

public class room {
	private int roomId;
	private int number;
	private int type;
	
	public room(){
		super();
	}

	public room(int roomId, int number, int type) {
		super();
		this.roomId = roomId;
		this.number = number;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name ="roomId", unique = true, nullable = false)
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	@Column(name ="number", unique = true, nullable = false)
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Column(name ="type", unique = true, nullable = false)
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	

}
