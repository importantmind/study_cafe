package com.study.controller;

import java.util.ArrayList;
import java.util.List;

import com.study.dto.SeatDTO;
import com.study.dto.SnackDTO;

public class SeatController {
	
	private static List<SeatDTO> seats = new ArrayList<>();
	
	static {
		seats.add(new SeatDTO(1, false));
		seats.add(new SeatDTO(2, false));
		seats.add(new SeatDTO(3, false));
		seats.add(new SeatDTO(4, false));
		seats.add(new SeatDTO(5, false));
		seats.add(new SeatDTO(6, false));
		seats.add(new SeatDTO(7, false));
		seats.add(new SeatDTO(8, false));
		seats.add(new SeatDTO(9, false));		
	}
	

	public List<SeatDTO> getSnacks(){
		return SeatController.seats;

}

}