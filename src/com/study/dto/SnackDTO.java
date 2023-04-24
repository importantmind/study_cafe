package com.study.dto;

public class SnackDTO {

	private int num;
	private String snackName;
	private int price;
	
	
	public SnackDTO(int num, String snackName, int price) {
		this.num = num;
		this.snackName = snackName;
		this.price = price;
		
	}
	
	public SnackDTO(String snackName)  {
		this.snackName = snackName;
	}	
	
		public SnackDTO(int price) 		{
			this.price = price;
	}
		
		
	public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getSnackName() {
			return snackName;
		}

		public void setSnackName(String snackName) {
			this.snackName = snackName;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

	@Override
	public String toString() {
		return "SnackDTO [snackName=" + snackName + ", price=" + price + "]";
	}
	

}