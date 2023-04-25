package com.study.dto;

public class SeatDTO {

	private int num;
	private boolean set = false;
	
	public SeatDTO() {}

	public SeatDTO(int num, boolean set) {
		this.num = num;
		this.set = set;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isSet() {
		return set;
	}

	public void setSet(boolean set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "SeatDTO [num=" + num + ", set=" + set + "]";
	}
	

}
