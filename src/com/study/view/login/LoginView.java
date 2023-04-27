package com.study.view.login;

import java.util.Scanner;

import com.study.controller.LoginController;
//import com.study.controller.SeatController;
import com.study.dto.MemberDTO;
import com.study.view.seat.SeatView;
import com.study.view.snack.SnackView;

public class LoginView {
	
	private LoginController loginController;
	private SnackView sv = new SnackView();
	private SeatView sct = new SeatView(); 
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
		int num = 0;
		
		MemberDTO member = new MemberDTO(name, phoneNumber, money, num);
		boolean result = loginController.add(member); 
		
		if(result) {
			System.out.printf("%s 님 회원가입되었습니다.\n", member.getName());
			return;
		}
		
		System.out.println("이미 회원가입한 회원입니다. 로그인해주세요");
		
	}

	// 2. 로그인
	public void login() {
		
		if(loginController.getMember() != null) {
			loginSuccess();
			return;
		}
		
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("핸드폰번호 : ");
		String phoneNumber = sc.next();
		MemberDTO member = new MemberDTO(name, phoneNumber,0,0);
		
		MemberDTO dto = loginController.findByMember(member);
		
		if(dto == null) {
			System.out.println("로그인에 실패했습니다.");
			return;
		}
		
		System.out.printf("%s님 로그인 성공!\n", dto.getName());
		
		loginSuccess();
	}

	private void loginSuccess() {
		
		while(true) {
			
			System.out.println("*** 선택 메뉴를 골라주세요 ***");
			System.out.println("*** 1. 회원정보 수정하기 ***");
			System.out.println("*** 2. 돈 충전하기 ***");
			System.out.println("*** 3. 좌석 선택하기 ***");
			System.out.println("*** 4. 좌석 수정하기 ***");
			System.out.println("*** 5. 좌석 반납하기 ***");			
			System.out.println("*** 6. 간식 구매하기 ***");			
			System.out.println("*** 7. 첫화면으로 돌아가기 ***");
			
			int num = sc.nextInt();
			
			switch (num) {
			//1. 회원정보 수정하기
			case 1: updateMemeber(); break;
			//2. 돈 충전
			case 2: plusMoney(); break;
			//3. 좌석선택
			case 3: sct.seatView(); break;
			//4. 좌석 수정하기
			case 4: sct.seatMove(); break;
			//5. 좌석 반납하기
			case 5: sct.seatReturn(); break;
			//6. 간식 구매하기
			case 6: sv.snackSelect(); break;
			//7. 첫화면으로 돌아가기
			case 7: return;
			default: System.out.println("번호를 잘못눌렀어요! 다시해주세요!"); break;
			
			}
		}
	}
	
	// 3. 회원 정보 수정
	public void updateMemeber() {
		System.out.print("수정할 이름 (기존이름 유지-> '-' 입력) :  ");
		String name = sc.next();
		System.out.print("핸드폰번호 (기존 핸드폰번호 유지-> '-' 입력 ) : ");
		String phoneNumber = sc.next();
		loginController.update(name, phoneNumber);
	}
	
	
	// 4. 회원 로그아웃
	public void logout() {
		if(loginController.getMember() == null) {
			System.out.println("로그인이 되지 않았습니다. 로그인 후 진행해주세요");
			return;
		}
		loginController.resetMember();
	}
	
	//5. 돈 충전
	public void plusMoney() {
		System.out.print("추가할 금액을 입력해주세요! :  ");
		int money = sc.nextInt();
		
		boolean result = loginController.changeMoney(money);
		if(!result) {
			System.out.println("로그인 또는 입력한 금액이 잘못되었습니다.");
			return;
		}
		System.out.printf("돈을 충전했습니다. 현재 %s님의 금액 : %d원\n",loginController.getMember(), loginController.getMember().getMoney());
		
	}
	
	//6. 전체 사용자 수
	public int AllMember() {
		return loginController.findAll().size();
	}


}
