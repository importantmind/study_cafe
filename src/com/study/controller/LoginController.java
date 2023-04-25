package com.study.controller;

import java.util.ArrayList;
import java.util.List;

import com.study.dto.MemberDTO;

public class LoginController {

	private static List<MemberDTO> members = new ArrayList<>();
	private static MemberDTO member;
	
	static {
		members.add(new MemberDTO("주진선", "010-1111-1111", 100000));
		members.add(new MemberDTO("김해든", "010-2222-2222", 100000));
	}
	
	// 1. 회원 추가
	public boolean add(MemberDTO member) {
		if(findByMember(member) != null) {
			MemberDTO.count--;
			return false;
		}
		
		LoginController.members.add(member);
		LoginController.member = member;
		return true;
	}
	
	//2. 전체조회
	public List<MemberDTO> findAll(){
		return LoginController.members;
	}
	
	//3. 한명 조회
	public MemberDTO findByMember(MemberDTO member) {
		for (MemberDTO memberDto : members) {
			if(memberDto.equals(member)) {
				LoginController.member = memberDto;
				return memberDto;
			}
		}
		MemberDTO.count--;
		return null; // 널...밖에 없나
	}
	
	//4. 수정
	public MemberDTO update(String name, String phoneNumber) {
		// 둘다 입력안할 시
		if(name.equals("-") && phoneNumber.equals("-")) return LoginController.member;
		
		// 이름만 입력
		if((name.equals("-") == false) && phoneNumber.equals("-")) {
			LoginController.member.setName(name);
			return LoginController.member;
		}
		// 핸드폰 번호만 입력
		if(name.equals("-") && (phoneNumber.equals("-") == false)) {
			LoginController.member.setPhoneNumber(phoneNumber);
			return LoginController.member;
		}
		
		LoginController.member.setName(name);
		LoginController.member.setPhoneNumber(phoneNumber);
		return LoginController.member;
	}
	
	//5. 회원 삭제
	public void remove (MemberDTO member) {
		if(member == null) {
			System.out.println("해당 회원이 없습니다.");
			return;
		}
		
		LoginController.members.remove(member);
	}
	
	// 6. 돈 변경
	public boolean changeMoney(int money) {
		if(getMember() == null || money < 0) return false;
		
		LoginController.member.setMoney(LoginController.member.getMoney() + money);
		return true;
	}
	
	// 7. 현재 회원
	public MemberDTO getMember() {
		return LoginController.member;
	}
	
	// 8. 현재 회원 초기화
	public void resetMember() {
		LoginController.member = null;
	}
	
	
	
	
	
	

}
