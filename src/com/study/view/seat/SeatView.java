//package com.study.view.seat;
//
//import java.util.Scanner;
//
//import com.study.controller.SeatController;
//
//public class SeatView {
//	
//	SeatController sct = new SeatController();
//	Scanner sc = new Scanner(System.in);
//	
//	//1-1. 좌석을 3자리씩 3줄로 프린트
//	public void seatView() {
//		boolean go = true;
//		while(go == true) {
//		System.out.println("======== 좌석 현황 ========");
//		for(int i = 0; i < 3; i++) {
//			if(sct.getSeat().get(i).isSet()== false) {
//				System.out.print((i+1) + "번 자리 O ");	
//			}else {
//				System.out.print((i+1) + "번 자리 X ");					
//			}
//			} System.out.println();
//		for(int i = 3; i < 6; i++) {
//			if(sct.getSeat().get(i).isSet()== false) {
//				System.out.print((i+1) + "번 자리 O ");	
//			}else {
//				System.out.print((i+1) + "번 자리 X ");					
//			}
//			} System.out.println();
//		for(int i = 6; i < 9; i++) {
//			if(sct.getSeat().get(i).isSet()== false) {
//				System.out.print((i+1) + "번 자리 O ");	
//			}else {
//				System.out.print((i+1) + "번 자리 X ");					
//			}
//			} System.out.println();
//			
//			//1-2. 좌석 선택
//			System.out.println();
//			System.out.println("원하시는 좌석을 선택해주세요.");
//			System.out.println("단, X 표시의 좌석은 이용중인 좌석이므로 선택할 수 없습니다.");
//			int num = sc.nextInt();
//			
//			if(num > 9 || num < 1) {
//				//다른 번호 입력시 처리
//				System.out.println("잘못 입력하셨습니다. 좌석 번호를 확인 후 다시 입력해주세요.");
//				continue;
//			}else if(false == sct.getSeat().get(num-1).isSet()){
//				//자리 선택완료
//				System.out.println("자리가 선택되었습니다!");
//				System.out.println("오늘도 열심히 공부하세요!");
//				sct.getSeat().get(num-1).setSet(true);
//				go = false;
//				break;
//				//자리 선택불가
//			}else{
//				System.out.println("이미 이용중인 좌석입니다.");
//				System.out.println("다시 선택해주세요.");
//				continue;
//		}
//			
//	}
//}	
//	//2. 좌석 옮기는 메소드
//	public void seatMove() {
//		boolean go = true;
//		while(go == true) {
//		System.out.println("======== 좌석 현황 ========");
//		for(int i = 0; i < 3; i++) {
//			if(sct.getSeat().get(i).isSet()== false) {
//				System.out.print((i+1) + "번 자리 O ");	
//			}else {
//				System.out.print((i+1) + "번 자리 X ");					
//			}
//			} System.out.println();
//		for(int i = 3; i < 6; i++) {
//			if(sct.getSeat().get(i).isSet()== false) {
//				System.out.print((i+1) + "번 자리 O ");	
//			}else {
//				System.out.print((i+1) + "번 자리 X ");					
//			}
//			} System.out.println();
//		for(int i = 6; i < 9; i++) {
//			if(sct.getSeat().get(i).isSet()== false) {
//				System.out.print((i+1) + "번 자리 O ");	
//			}else {
//				System.out.print((i+1) + "번 자리 X ");					
//			}
//			} System.out.println();
//			
//			System.out.println();
//			System.out.println("현재 사용하고 계신 좌석 번호를 입력해주세요.");
//			int num2 = sc.nextInt();
//			
//			//다른번호 선택시
//			if(num2 > 9 || num2 < 1) {
//				//다른 번호 입력시 처리
//				System.out.println("잘못 입력하셨습니다. 좌석 번호를 확인 후 다시 입력해주세요.");
//				continue;
//			}else if(false == sct.getSeat().get(num2-1).isSet()){
//				System.out.println("선택하신 자리는 이용중인 자리가 아닙니다.");
//				System.out.println("다시 입력해주세요.");
//				continue;
//			}else {
//				System.out.println("바꿀 좌석을 선택해주세요.");
//				System.out.println("단, X 표시의 좌석은 이용중인 좌석이므로 선택할 수 없습니다.");
//				int num = sc.nextInt();
//			
//			
//			if(num > 9 || num < 1) {
//				//다른 번호 입력시 처리
//				System.out.println("잘못 입력하셨습니다. 좌석 번호를 확인 후 다시 입력해주세요.");
//				continue;
//			}else if(false == sct.getSeat().get(num-1).isSet()){
//				//자리 옮기기완료
//				System.out.println("자리가 선택되었습니다!");
//				System.out.println("쓰시던 자리는 깨끗이 치워주세요.");
//				sct.getSeat().get(num-1).setSet(true);  //새로 선택한 좌석 true로 변경
//				sct.getSeat().get(num2-1).setSet(false);  //이용 중인 좌석 false로 변경
//				go = false;
//				break;
//			}else {
//				//자리 선택불가
//				System.out.println("이미 이용중인 좌석입니다.");
//				System.out.println("다시 선택해주세요.");
//				continue;
//				}
//			}
//				
//		}
//	}
//	
//	//3. 좌석 반납 메소드
//	public void seatReturn() {
//		boolean go = true;
//		while(go == true) {
//		System.out.println("현재 사용하고 계신 좌석 번호를 입력해주세요.");
//		int num = sc.nextInt();
//		//다른 번호 입력시 처리
//		if(num > 9 || num < 1) {
//			System.out.println("잘못 입력하셨습니다. 좌석 번호를 확인 후 다시 입력해주세요.");
//			continue;
//		//반납 불가
//		}else if(false == sct.getSeat().get(num-1).isSet()){
//			System.out.println("선택하신 자리는 이용중인 자리가 아닙니다.");
//			System.out.println("다시 입력해주세요.");
//			continue;
//		//자리 옮기기완료
//		}else{
//			System.out.println("퇴실이 완료 되었습니다.");
//			System.out.println("안녕히 가세요.");
//			sct.getSeat().get(num-1).setSet(false);		
//			break;
//			}
//		}
//	}	
//}
