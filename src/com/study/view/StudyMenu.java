package com.study.view;

import java.util.Scanner;

import com.study.view.login.LoginView;
import com.study.view.snack.SnackView;

public class StudyMenu {
	
	private Scanner sc;
	private LoginView lv;
	private SnackView sv;

	public StudyMenu() {
		sc = new Scanner(System.in);		
		lv = new LoginView();
		sv = new SnackView();
	}
	
	public void mainMenu() {
		
		
		while(true) {
			System.out.println("*** HI STUDYCAFE ***");
			System.out.printf("*** 현재 %d명 사용중 ***\n", lv.AllMember());
			System.out.println("*** 1. 회원가입 ***");
			System.out.println("*** 2. 로그인 ***");
			System.out.println("*** 3. 간식 고르기(로그인 후 선택 가능) ***");
			System.out.println("*** 4. 프로그램 완전 종료 ***");
			int num = sc.nextInt();
			switch (num) {
			case 1: lv.register(); break;
			case 2: lv.login(); break;
			case 3: sv.snackSelect(); break;
			case 4: return;
			default: System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요");
			
			}
			
		}
		
	}
	
}
