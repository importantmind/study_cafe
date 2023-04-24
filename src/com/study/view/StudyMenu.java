package com.study.view;

import java.util.Scanner;

import com.study.view.login.LoginView;

public class StudyMenu {
	
	private Scanner sc;
	private LoginView lv;
	
	public StudyMenu() {
	
		sc = new Scanner(System.in);		
		lv = new LoginView();
	}
	
	public void mainMenu() {
		
		
		while(true) {
			System.out.println("*** HI STUDYCAFE ***");
			System.out.println("*** 1. 회원가입 ***");
			System.out.println("*** 2. 로그인 ***");
			System.out.println("*** 3. 간식 고르기(로그인 후 선택 가능) ***");
			System.out.println("*** 4. 프로그램 완전 종료 ***");
			int num = sc.nextInt();
			switch (num) {
			case 1: lv.register(); break;
			case 2: lv.login(); break;
			default:
				break;
			}

			
		}
		
	}
	
	
	
	

}
