package com.study.view.seat;

import java.util.Scanner;

import com.study.controller.SeatController;

public class SeatView {
	
	SeatController sct = new SeatController();
	Scanner sc = new Scanner(System.in);
	
	public void seatView() {
		boolean go = true;
		while(go == true) {
		System.out.println("=============== 좌석 현황 ===============");
		for(int i = 0; i < 3; i++) {
			System.out.print((i+1) + "번 자리 " + sct.getSnacks().get(i).isSet() + " ");
		} System.out.println();
			for(int i = 3; i < 6; i++) {
				System.out.print((i+1) + "번 자리 " + sct.getSnacks().get(i).isSet() + " ");
			} System.out.println();
				for(int i = 6; i < 9; i++) {
					System.out.print((i+1) + "번 자리 " + sct.getSnacks().get(i).isSet() + " ");
			} System.out.println();
			
			System.out.println();
			System.out.println("원하시는 좌석을 선택해주세요.");
			System.out.println("단, X 표시의 좌석은 이용중인 좌석이므로 선택할 수 없습니다.");
			int num = sc.nextInt();
			
			if(false == sct.getSnacks().get(num-1).isSet()) {
				//자리 선택완료
				System.out.println("자리가 선택되었습니다!");
				System.out.println("오늘도 열심히 공부하세요!");
				sct.getSnacks().get(num-1).setSet(true);
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
