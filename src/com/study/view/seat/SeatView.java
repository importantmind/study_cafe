package com.study.view.seat;

import java.util.List;
import java.util.Scanner;

import com.study.controller.LoginController;
import com.study.controller.SeatController;

public class SeatView {
	
	LoginController lc = new LoginController();
	SeatController sct = new SeatController();
	Scanner sc = new Scanner(System.in);
	
	public void seatsToString() {
		List<String> list = sct.seatStatus();
		for (int i = 0; i < list.size(); i++) {
			System.out.print("["+list.get(i) + "] ");
			
			if((i+1) % 3 == 0) {
				System.out.println();
			}
		}
	}
	
	
	//1. 좌석을 선택하는 메소드
	public void choiceSeat() {
		if(lc.getMember().getSeatDTO() != null) {
			System.out.println("이미 좌석을 선택하셨습니다.");
			return;
		}
		
		boolean go = true;
		while(go == true) {
		System.out.println("======== 좌석 현황 ========");
			seatsToString();
			
			System.out.println();
			System.out.println("원하시는 좌석을 선택해주세요.");
			System.out.println("단, X 표시의 좌석은 이용중인 좌석이므로 선택할 수 없습니다.");
			int num = sc.nextInt();
			
			boolean result = sct.add(num-1);
			
			if(!result) {
				//자리 선택불가
				System.out.println("이미 이용중인 좌석입니다.");
				System.out.println("다시 선택해주세요.");
				break;
			}
			
			System.out.println("자리가 선택되었습니다!");
			System.out.println("오늘도 열심히 공부하세요!");
			
			lc.resetMember(); // 회원 로그아웃
			go = false;
			break;
		}
	}
	
	//2. 좌석 옮기는 메소드
	public void seatMove() {
		if(lc.getMember().getSeatDTO() == null) {
			System.out.println("현재 선택하신 좌석이 없습니다. 좌석선택 후 진행해주세요");
			return;
		}
		
		boolean go = true;
		while(go == true) {
		System.out.println("======== 좌석 현황 ========");
			seatsToString();

			System.out.println("바꿀 좌석을 선택해주세요.");
			System.out.println("단, X 표시의 좌석은 이용중인 좌석이므로 선택할 수 없습니다.");
			int num = sc.nextInt();
			boolean result = sct.update(num-1);
			
			if(!result) {
				System.out.println("이미 이용중인 좌석입니다.");
				System.out.println("다시 선택해주세요.");
				break;
			}
				//자리 옮기기완료
				System.out.println("자리가 선택되었습니다!");
				System.out.println("쓰시던 자리는 깨끗이 치워주세요.");
				
				go = false;
				break;
		}
	}
	
	//3. 좌석 반납 메소드
	public void seatReturn() {
		int result = sct.delete();
		if(result == -1) {
			System.out.println("로그인또는 회원가입을 해주세요");
			return;
		}
		
		if(result == 0) {
			System.out.println("현재 사용하고 있는 좌석이 없습니다.");
			return;
		}
		
		System.out.println("성공적으로 반납되었습니다.");
		lc.resetMember(); // 회원 로그아웃
	}
	
}
