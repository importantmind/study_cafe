package com.study.dto;

import java.util.Objects;

public class MemberDTO {

	public static double count = 1L;
	private double id;
	private String name;
	private String phoneNumber;
	private int money;
	private SeatDTO seatDTO;
////////////////////////////////////////////////////////////
	private int num = 0;
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
//////////////////////////////////////////////////////////////
	

	public MemberDTO() {}

	public MemberDTO(String name, String phoneNumber, int money, int num) {
		this.id = count++;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.money = money;
		this.num = num;
	}

	public MemberDTO(String name2, String phoneNumber2) {
		
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public SeatDTO getSeatDTO() {
		return seatDTO;
	}


	public void setSeatDTO(SeatDTO seatDTO) {
		this.seatDTO = seatDTO;
	}

	

	@Override
	public String toString() {
		return "id : " + id + ", 이름 : " + name + ", 핸드폰 번호 : " + phoneNumber + ", 현재 보유한 돈 : " + money
				+ ", 현재 자리 : " + seatDTO ;
	}


	@Override
	public int hashCode() {
		return Objects.hash(name, phoneNumber);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		return Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
	}

	
}
