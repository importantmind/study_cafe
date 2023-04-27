package com.study.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.study.dto.MemberDTO;
import com.study.dto.SeatDTO;

public class SeatController {
	
	private static List<SeatDTO> seats = new ArrayList<>();
	private LoginController lc = new LoginController();
	
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
	
	//1. 전체조회
	public List<SeatDTO> allSeat(){
		return SeatController.seats;
	}
	
	//2. 자리 한개 조회
	public SeatDTO findSeat(int index) {
		return seats.get(index);
	}
	
	//3. 선택한 자리 예약상태
	public boolean getSeat(int index) {
		return seats.get(index).isSet();
	}
	
	//4. 상태변경 -> 수정필요 중복내용삭제 할 메소드로 
	public SeatDTO changeSeatStatus(int index) { 
		SeatDTO seat = findSeat(index);
		seat.setSet(!seat.isSet());
		return seat;
	}
	
	//5. 자리 상태 (O, X)리스트 반환
	public List<String> seatStatus(){
		return SeatController.seats.stream()
				.map(t -> t.isSet() == false? t.getNum()+"번: O": t.getNum()+"번: X").collect(Collectors.toList());
	}
	
	//좌석을 선택하면 회원의 seat에 들어가야하고, true로 바뀌어야한다.
	public boolean add(int index) {
		MemberDTO member = lc.getMember();
		SeatDTO seat = member.getSeatDTO();
		
		if(seat != null) return false;
		
		if(getSeat(index)) return false;
		
		SeatDTO choiceSeat = findSeat(index);
		member.setSeatDTO(choiceSeat);
		choiceSeat.setSet(true);
		return true;
	}
	
	//현재 회원의 seat이 있을때 좌석을 변경하는 경우로 인식 , 회원의 seat이 변경되어야하고, 기존 좌석이 false로 변경
	public boolean update(int index) {
		MemberDTO member = lc.getMember();
		SeatDTO seat = member.getSeatDTO();
		
		if(seat == null) return false; // 선택한 자리가 없으면 수정이 아니니까... 
		if(getSeat(index)) return false; // 상태가 true이면 이미 사용자가 있어서 안됌.
		
		seat.setSet(false); //기존좌석변경
		SeatDTO choiceSeat = findSeat(index);
		member.setSeatDTO(choiceSeat);
		choiceSeat.setSet(true);
		return true;
	}
	
	// 9. 좌석 초기화
	public int delete() {
		MemberDTO member = lc.getMember();
		if(member == null) return -1;
		
		SeatDTO seat = member.getSeatDTO();
		if(seat == null) return 0;
		
		int num = seat.getNum();
		//해당 회원의 좌석을 false로 변경시키고
		seats.get(num-1).setSet(false);
		// 회원의 자리 정보 없애기
		lc.getMember().setSeatDTO(null); 
		return 1;
	}	
	
	

}