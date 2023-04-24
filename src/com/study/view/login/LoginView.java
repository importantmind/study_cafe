package com.study.view.login;

import java.util.Scanner;

import com.study.controller.LoginController;
import com.study.dto.MemberDTO;

public class LoginView {
	
	private LoginController loginController;
	private Scanner sc;
	
	public LoginView() {
		loginController = new LoginController();
		sc = new Scanner(System.in);
	}
	
	// 1. 회원가입
	public void register() {
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("핸드폰번호 : ");
		String phoneNumber = sc.next();
		System.out.print("보유 money : ");
		int money = sc.nextInt();
		
		MemberDTO member = new MemberDTO(name, phoneNumber, money);
		boolean result = loginController.add(member); 
		
		if(result) {
			System.out.printf("%s 님 회원가입되었습니다.\n", member.getName());
			return;
		}
		
		System.out.println("이미 회원가입한 회원입니다. 로그인해주세요");
		
	}

	// 2. 로그인
	public void login() {
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("핸드폰번호 : ");
		String phoneNumber = sc.next();
		MemberDTO member = new MemberDTO(name, phoneNumber, 0);
		
		MemberDTO dto = loginController.findByMember(member);
		
		if(dto == null) {
			System.out.println("로그인에 실패했습니다.");
			return;
		}
		
		System.out.printf("%s님 로그인 성공!\n", dto.getName() );
		
		//시간선택으로 넘어가는 메소드
		
	}
	
	// 3. 회원 정보 수정
	
	
	// 4. 회원 탈퇴
	
	
	// 5. 회원정보 수정

}
