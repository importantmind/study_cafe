package com.study.view.snack;

import java.util.Scanner;

import com.study.controller.LoginController;
import com.study.controller.SnackController;
import com.study.dto.MemberDTO;
import com.study.dto.SnackDTO;

public class SnackView {

	private SnackController snackController;
	private Scanner sc;
	private LoginController lc; 


	public SnackView() {
		snackController = new SnackController();
		sc = new Scanner(System.in);
		lc = new LoginController();
	}


	//1. 과자선택 
	public void snackSelect() {
		if(lc.getMember() == null) {
			System.out.println("로그인해야 구매가능합니다!!!!");
			return;
		}
		
		boolean bo = true;
		while(bo == true) {
			System.out.println("*** 과자 리스트 ***");	

			for(SnackDTO snack : snackController.getSnacks()) {
				System.out.println("< " + snack.getNum() + "번 > " + snack.getSnackName() + " : " + snack.getPrice() + "원");
			}
			System.out.println("< 5번 > 과자 구매 종료.");
			System.out.print("원하시는 과자의 번호를 선택해주세요 >>>");

			int num = sc.nextInt();
			switch(num) {
			case 0 : case 1 :  case 2 : case 3 : case 4 :
				creditSnack(num); break;
			case 5 : System.out.println("과자 구매를 종료 합니다."); return;
			default : System.out.println("번호를 잘못입력하셨습니다. 다시 한 번 확인해주세요."); break;
			}
		}
	}
	
	//2. 과자 결제
	public void creditSnack(int num) {
		boolean result = snackController.choiceSnack(num);
		
		MemberDTO member = lc.getMember();

		if(!result) {
			System.out.println("현재 보유하신 금액이 부족합니다. 보유금액 : " + member.getMoney() + "원");
			return;
		}
		
		System.out.println("구매 완료되었습니다.");
		System.out.println("남은 돈은 " + member.getMoney() + "원 입니다.");
	}

}


