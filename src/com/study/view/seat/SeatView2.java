package com.study.view.seat;

import java.util.Scanner;

import com.study.controller.LoginController;
import com.study.controller.SeatController;
import com.study.dto.MemberDTO;

public class SeatView2 {
	LoginController lc = new LoginController();
	MemberDTO mb = new MemberDTO();
	SeatController sct = new SeatController();
	Scanner sc = new Scanner(System.in);
	
	//로그인컨트롤러의 members 리스트의 '현재 사용자(get(?)' 의 배열에 num값이 있는지 확인
	
	
	//1-1. 좌석 중복 배제
	public void seatView() {
		//num은 초기값 0
		if(lc.listMember().get(0).getNum() != 0) { //로그인컨트롤러의 members 리스트의 '현재 사용자(get(?)' 의 번호가 0이 아니면 선택불가능
			System.out.println("이미 좌석을 선택하셨습니다.");
			return;
	//1-2. 좌석을 3자리씩 3줄로 프린트
		}else {
		boolean go = true;
		while(go == true) {
		System.out.println("======== 좌석 현황 ========");
		for(int i = 0; i < 3; i++) {
			if(sct.getSeat().get(i).isSet()== false) {
				System.out.print((i+1) + "번 자리 O ");	
			}else {
				System.out.print((i+1) + "번 자리 X ");					
			}
			} System.out.println();
		for(int i = 3; i < 6; i++) {
			if(sct.getSeat().get(i).isSet()== false) {
				System.out.print((i+1) + "번 자리 O ");	
			}else {
				System.out.print((i+1) + "번 자리 X ");					
			}
			} System.out.println();
		for(int i = 6; i < 9; i++) {
			if(sct.getSeat().get(i).isSet()== false) {
				System.out.print((i+1) + "번 자리 O ");	
			}else {
				System.out.print((i+1) + "번 자리 X ");					
			}
			} System.out.println();
			
			//1-3. 좌석 선택
			System.out.println();
			System.out.println("원하시는 좌석을 선택해주세요.");
			System.out.println("단, X 표시의 좌석은 이용중인 좌석이므로 선택할 수 없습니다.");
			int num = sc.nextInt();
			
			if(false == sct.getSeat().get(num-1).isSet()) {
				//자리 선택완료
				System.out.println("자리가 선택되었습니다!");
				System.out.println("오늘도 열심히 공부하세요!");
				sct.getSeat().get(num-1).setSet(true);
				lc.listMember().get(0).setNum(num); //로그인컨트롤러의 members 리스트의 '현재 사용자(get(?)' 의 번호를 num으로 바꾼다. 
				go = false;
				break;
			}else if(true == sct.getSeat().get(num-1).isSet()){
				//자리 선택불가
				System.out.println("이미 이용중인 좌석입니다.");
				System.out.println("다시 선택해주세요.");
				break;
				//다른 번호 입력시 처리
			}else if(num > 9 || num < 1){
				System.out.println("잘못 입력하셨습니다. 좌석 번호를 확인 후 다시 입력해주세요.");
				break;
			}
		}
	}
}
	//2. 좌석 옮기는 메소드
	public void seatMove() {
		boolean go = true;
		while(go == true) {
		System.out.println("======== 좌석 현황 ========");
		for(int i = 0; i < 3; i++) {
			if(sct.getSeat().get(i).isSet()== false) {
				System.out.print((i+1) + "번 자리 O ");	
			}else {
				System.out.print((i+1) + "번 자리 X ");					
			}
			} System.out.println();
		for(int i = 3; i < 6; i++) {
			if(sct.getSeat().get(i).isSet()== false) {
				System.out.print((i+1) + "번 자리 O ");	
			}else {
				System.out.print((i+1) + "번 자리 X ");					
			}
			} System.out.println();
		for(int i = 6; i < 9; i++) {
			if(sct.getSeat().get(i).isSet()== false) {
				System.out.print((i+1) + "번 자리 O ");	
			}else {
				System.out.print((i+1) + "번 자리 X ");					
			}
			} System.out.println();
			
			System.out.println();
			System.out.println("현재 사용하고 계신 좌석 번호를 입력해주세요.");
			int num2 = sc.nextInt();
			
			//현재 사용자가 가지고 있는 자리 넘버와 같은지 확인
			//넘버가 틀리다면
			if(num2 != lc.listMember().get(0).getNum()) { 
				System.out.println("선택하신 자리는 이용중인 자리가 아닙니다.");
				System.out.println("다시 입력해주세요.");
				continue;
			//넘버가 맞다면
			}else {
			System.out.println("바꿀 좌석을 선택해주세요.");
			System.out.println("단, X 표시의 좌석은 이용중인 좌석이므로 선택할 수 없습니다.");
			int num = sc.nextInt();
			
			if(false == sct.getSeat().get(num-1).isSet()) {
				//자리 옮기기완료
				System.out.println("자리가 선택되었습니다!");
				System.out.println("쓰시던 자리는 깨끗이 치워주세요.");
				sct.getSeat().get(num-1).setSet(true);  //새로 선택한 좌석 true로 변경
				sct.getSeat().get(num2-1).setSet(false);  //이용 중인 좌석 false로 변경
				lc.listMember().get(0).setNum(num2); //로그인컨트롤러의 members 리스트의 '현재 사용자(get(?)' 의 번호를 num2로 바꾼다. 
				go = false;
				break;
			}else {
				//자리 선택불가
				System.out.println("이미 이용중인 좌석입니다.");
				System.out.println("다시 선택해주세요.");
				break;
	
				}
			}
		}
	}
	
	//3. 좌석 반납 메소드
	public void seatReturn() {
		boolean go = true;
		while(go == true) {
		System.out.println("현재 사용하고 계신 좌석 번호를 입력해주세요.");
		int num = sc.nextInt();
		
		//현재 사용자가 가지고 있는 자리 넘버와 같은지 확인
		//넘버가 틀리다면
		if(num != lc.listMember().get(0).getNum()) { 
			System.out.println("선택하신 자리는 이용중인 자리가 아닙니다.");
			System.out.println("다시 입력해주세요.");
			continue;
		}else {
		System.out.println("퇴실이 완료 되었습니다.");
		System.out.println("안녕히 가세요.");
		sct.getSeat().get(num-1).setSet(false);
		lc.listMember().get(0).setNum(0); //로그인컨트롤러의 members 리스트의 '현재 사용자(get(?)' 의 번호를 0으로 바꾼다. 
		break;
			}
		}
	}
}


