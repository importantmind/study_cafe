package com.study.controller;

import java.util.ArrayList;
import java.util.List;

import com.study.dto.MemberDTO;
import com.study.dto.SnackDTO;

public class SnackController {

	private static List<SnackDTO> snacks = new ArrayList<>();
	private LoginController lc = new LoginController();

	static {
		snacks.add(new SnackDTO(0, "엄마손파이", 3800));
		snacks.add(new SnackDTO(1, "촉촉한 초코칩", 3500));
		snacks.add(new SnackDTO(2, "마가렛트", 5000));
		snacks.add(new SnackDTO(3, "후렌치파이", 4500));
		snacks.add(new SnackDTO(4, "버터와플", 3000));
	}
	
	//1. 과자 전체 반환
	public List<SnackDTO> getSnacks(){
		return SnackController.snacks;
	} 
	
	//2. 과자 선택 -> 결제
	public boolean choiceSnack(int num) {
		MemberDTO member = lc.getMember();
		int price = member.getMoney();
		SnackDTO snack = snacks.get(num);
		
		if(snack.getPrice() > member.getMoney()) {
			return false;
		}
		
		member.setMoney(member.getMoney() - snack.getPrice());
		return true;
	}
	
	 
	
	
	
}
