package com.study.view.login;

import java.util.Scanner;

import com.study.controller.LoginController;
import com.study.dto.MemberDTO;
import com.study.dto.SnackDTO;

public class SnackView {
	
	public void snackSelect() {
			
		Scanner sc = new Scanner(System.in);
		MemberDTO mem = new MemberDTO();
		LoginController lc = new LoginController(); 
		
		SnackDTO[] sn = { new SnackDTO(1, "촉촉한 초코칩", 3500)
						, new SnackDTO(2, "엄마손파이", 3800)
						, new SnackDTO(3, "마가렛트", 5000)
						, new SnackDTO(4, "후렌치파이", 4500)
						, new SnackDTO(5, "버터와플", 3000)
		};			
		
		for(SnackDTO snack : sn) {
			System.out.println("< " + snack.getNum() + "번 > " + snack.getSnackName() + "은 " + snack.getPrice() + "원 입니다.");
		}
		
		System.out.println("< 6번 > 과자 구매 종료.");
		
		boolean bo = true;
		while(bo==true) {
			System.out.println("원하시는 과자의 번호를 선택해주세요");
			int num = sc.nextInt();
		switch(num) {
		case 1 : if(sn[0].getPrice() <= lc.getMember().getMoney() - sn[0].getPrice()) {
			System.out.println("구매 완료되었습니다.");
			System.out.println("남은 돈은 " + (lc.getMember().getMoney() - sn[0].getPrice()) + "원 입니다.");
			lc.getMember().setMoney(lc.getMember().getMoney() - sn[0].getPrice());
			break;
		}else {
			System.out.println("가진돈이 부족합니다."); break;
		}
			
		case 2 : if(sn[1].getPrice() <= lc.getMember().getMoney()) {
			System.out.println("구매 완료되었습니다.");
			System.out.println("남은 돈은 " + (lc.getMember().getMoney() - sn[1].getPrice()) + "원 입니다.");
			lc.getMember().setMoney(lc.getMember().getMoney() - sn[1].getPrice());	
			bo = false; break;
		}else {
			System.out.println("가진돈이 부족합니다."); break;
		}
			
		case 3 : if(sn[2].getPrice() <= lc.getMember().getMoney()) {
			System.out.println("구매 완료되었습니다.");
			System.out.println("남은 돈은 " + (lc.getMember().getMoney() - sn[2].getPrice()) + "원 입니다.");
			lc.getMember().setMoney(lc.getMember().getMoney() - sn[2].getPrice());	
			bo = false; break;
		}else {
			System.out.println("가진돈이 부족합니다."); break;
		}
			
		case 4 : if(sn[3].getPrice() <= lc.getMember().getMoney()) {
			System.out.println("구매 완료되었습니다.");
			System.out.println("남은 돈은 " + (lc.getMember().getMoney() - sn[3].getPrice()) + "원 입니다.");
			lc.getMember().setMoney(lc.getMember().getMoney() - sn[3].getPrice());	
			bo = false; break;
		}else {
			System.out.println("가진돈이 부족합니다."); break;
		}
			
		case 5 : if(sn[4].getPrice() <= lc.getMember().getMoney()) {
			System.out.println("구매 완료되었습니다.");
			System.out.println("남은 돈은 " + (lc.getMember().getMoney() - sn[4].getPrice()) + "원 입니다.");
			lc.getMember().setMoney(lc.getMember().getMoney() - sn[4].getPrice());	
			bo = false; break;
		}else {
			System.out.println("가진돈이 부족합니다."); break;
		}
		
		case 6 : System.out.println("과자 구매를 종료 합니다."); return;
		default : System.out.println("번호를 잘못입력하셨습니다. 다시 한 번 확인해주세요."); break;
			
		}
		
		}
		}


}


